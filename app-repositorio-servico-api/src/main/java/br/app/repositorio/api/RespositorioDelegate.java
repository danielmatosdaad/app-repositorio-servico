package br.app.repositorio.api;

import br.app.barramento.integracao.dto.EnvioDTO;
import br.app.barramento.integracao.dto.LocalizadorServico;
import br.app.barramento.integracao.dto.Mensagem;
import br.app.barramento.integracao.dto.RespostaDTO;
import br.app.barramento.integracao.dto.TipoAcao;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.repositorio.servico.integracao.IServicoRepositorio;
import br.app.smart.api.infra.AbstractDelegate;
import br.app.smart.api.infra.TipoLocalizador;

public class RespositorioDelegate extends AbstractDelegate<IServicoRepositorio> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RespositorioDelegate() {
	}

	public RespositorioDelegate(LocalizadorServico<IServicoRepositorio> localizaServico) {
		super(localizaServico);
	}

	public IServicoRepositorio getServico() {
		return getLocalizadorServico().getServico();
	}

	public static RespositorioDelegate getIntancia() {

		LocalizadorServico<IServicoRepositorio> localizaServico = new LocalizarServicoRepositorio<IServicoRepositorio>(
				TipoLocalizador.REMOTO);
		RespositorioDelegate delegate = new RespositorioDelegate(localizaServico);

		return delegate;
	}

	@Override
	public LocalizadorServico<IServicoRepositorio> getLocalizadorServico(TipoAcao acao) {

		if (TipoAcao.isAcaoDAO(acao)) {
			LocalizadorServico<IServicoRepositorio> localizaServico = new LocalizarServicoRepositorio<IServicoRepositorio>(
					TipoLocalizador.REMOTO.getValue(), LocalizarServicoRepositorio.REGISTRO_NOME_LOCAL_DAO,
					LocalizarServicoRepositorio.REGISTRO_NOME_REMOTO_DAO);

			return localizaServico;
		}
		LocalizadorServico<IServicoRepositorio> localizaServico = new LocalizarServicoRepositorio<IServicoRepositorio>(
				TipoLocalizador.REMOTO);

		return localizaServico;
		
	}

	@Override
	public void executarServico(TipoAcao acao, EnvioDTO envio, RespostaDTO resposta, IServicoRepositorio servico)
			throws NegocioException, InfraEstruturaException {
		resposta.setMensagem(Mensagem.ERRO);
		resposta.getMensagem().setErro("Funcionalidade nao implementada:" + acao.getValue());
	}
}
