package br.app.repositorio.servico.integracao;

import br.app.barramento.integracao.exception.NegocioException;

public interface CatalogoServico {

	public static final String CATALOGO_FNC_MDO = "CATALOGO_FNC_MDO";
	public static final String CATALOGO_CTA = "CATALOGO_CTA";
	public static final String CATALOGO_PMT = "CATALOGO_PMT";
	public static final String CATALOGO_TLA_MDO = "CATALOGO_TLA_MDO";
	
	String getNome();
	String getNomeArtefatoId();
	
	public InformacaoServico buscarInformacaoServico(String name,String envio,String tokenAutorizaca) throws NegocioException;
}
