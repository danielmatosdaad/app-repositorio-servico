/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.app.repositorioservico.web.controller.imp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.app.barramento.integracao.dto.FiltroDTO;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.repositorio.api.RespositorioDelegate;
import br.app.repositorio.service.imp.RepositorioServicoImp;
import br.app.repositorio.servico.integracao.RepositorioServicoDTO;

@Path("/repositorio")
@RequestScoped
@Named
public class RepositorioController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Validator validator;

	@POST
	@Path("/filtro")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<RepositorioServicoDTO> filtrar(FiltroDTO filtro) {
		List<RepositorioServicoDTO> repositorios = null;
		try {

			repositorios = RespositorioDelegate.getIntancia().getServico().filtrar(filtro);
		} catch (InfraEstruturaException | NegocioException e) {
			e.printStackTrace();
		}
		if (repositorios == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return repositorios;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/buscar/{page:[0-9][0-9]*}/{results:[0-9][0-9]*}")
	public List<RepositorioServicoDTO> buscar(@PathParam("page") int page, @PathParam("results") int results,
			FiltroDTO filtroDTO) {
		List<RepositorioServicoDTO> repositorios = null;
		try {
			repositorios = RespositorioDelegate.getIntancia().getServico().listaComFiltro(filtroDTO, results, page);
		} catch (InfraEstruturaException | NegocioException e) {
			e.printStackTrace();
		}
		if (repositorios == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return repositorios;
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public RepositorioServicoDTO buscarPorId(@PathParam("id") long id) {
		RepositorioServicoDTO repositorio = null;
		try {
			repositorio = RespositorioDelegate.getIntancia().getServico().bustarPorID(id);
		} catch (InfraEstruturaException | NegocioException e) {
			e.printStackTrace();
		}
		if (repositorio == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return repositorio;
	}

	/**
	 * Creates a new member from the values provided. Performs validation, and
	 * will return a JAX-RS response with either 200 ok, or with a map of
	 * fields, and related errors.
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response criarImovel(RepositorioServicoDTO repositorio) {

		Response.ResponseBuilder builder = null;

		try {
			validateRepositorio(repositorio);

			RespositorioDelegate.getIntancia().getServico().adiconar(repositorio);

			builder = Response.ok();
		} catch (ConstraintViolationException ce) {
			builder = createViolationResponse(ce.getConstraintViolations());
		} catch (ValidationException e) {
			Map<String, String> responseObj = new HashMap<>();
			responseObj.put("error", e.getMessage());
			builder = Response.status(Response.Status.CONFLICT).entity(responseObj);
		} catch (Exception e) {
			Map<String, String> responseObj = new HashMap<>();
			responseObj.put("error", e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
		}

		return builder.build();
	}

	private void validateRepositorio(RepositorioServicoDTO repositorio)
			throws ConstraintViolationException, ValidationException {
		Set<ConstraintViolation<RepositorioServicoDTO>> violations = validator.validate(repositorio);

		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
		}
	}

	private Response.ResponseBuilder createViolationResponse(Set<ConstraintViolation<?>> violations) {

		Map<String, String> responseObj = new HashMap<>();

		for (ConstraintViolation<?> violation : violations) {
			responseObj.put(violation.getPropertyPath().toString(), violation.getMessage());
		}

		return Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
	}

}
