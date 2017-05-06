package br.app.repositorio.servico.integracao;


import br.app.barramento.integracao.dao.interfaces.IServicoDAO;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;

public interface IServicoRepositorio extends IServicoDAO<RepositorioServicoDTO>{

	public IRepositorio getRespositorio() throws InfraEstruturaException, NegocioException;
}
