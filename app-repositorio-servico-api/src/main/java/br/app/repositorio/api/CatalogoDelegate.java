package br.app.repositorio.api;


import br.app.barramento.integracao.dto.EnvioDTO;
import br.app.barramento.integracao.dto.LocalizadorServico;
import br.app.barramento.integracao.dto.Mensagem;
import br.app.barramento.integracao.dto.RespostaDTO;
import br.app.barramento.integracao.dto.TipoAcao;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.repositorio.servico.integracao.IServicoCatalogo;
import br.app.smart.api.infra.AbstractDelegate;
import br.app.smart.api.infra.TipoLocalizador;

public class CatalogoDelegate extends AbstractDelegate<IServicoCatalogo> {

	public CatalogoDelegate() {
	}
	public CatalogoDelegate(LocalizadorServico<IServicoCatalogo> localizaServico) {
		super(localizaServico);
	}

	public IServicoCatalogo getServico() {
		return getLocalizadorServico().getServico();
	}

	public static CatalogoDelegate getIntancia() {

		LocalizadorServico<IServicoCatalogo> localizaServico = new LocalizarServicoRepositorio<IServicoCatalogo>(
				TipoLocalizador.REMOTO);

		CatalogoDelegate delegate = new CatalogoDelegate(localizaServico);

		return delegate;
	}
	
	
	@Override
	public LocalizadorServico<IServicoCatalogo> getLocalizadorServico(TipoAcao acao) {

		if (TipoAcao.EXECUTAR.equals(acao)) {
			LocalizadorServico<IServicoCatalogo> localizaServico = new LocalizarServicoRepositorio<IServicoCatalogo>(
					TipoLocalizador.REMOTO);

			return localizaServico;
		}
		throw new RuntimeException("Acao nao reconhecida");
	}

	@Override
	public void executarServico(TipoAcao acao, EnvioDTO envio, RespostaDTO resposta,IServicoCatalogo servico)
			throws NegocioException, InfraEstruturaException {
		resposta.setMensagem(Mensagem.ERRO);
		resposta.getMensagem().setErro("Funcionalidade nao implementada:" + acao.getValue());
	}
}
