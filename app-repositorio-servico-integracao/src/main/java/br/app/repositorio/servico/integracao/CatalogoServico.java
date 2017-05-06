package br.app.repositorio.servico.integracao;

public interface CatalogoServico {

	public static final String CATALOGO_FNC_MDO = "CATALOGO_FNC_MDO";
	public static final String CATALOGO_CTA = "CATALOGO_CTA";
	public static final String CATALOGO_PMT = "CATALOGO_PMT";
	public static final String CATALOGO_TLA_MDO = "CATALOGO_TLA_MDO";

	public InformacaoServico buscarInformacaoServico(String name,String envio);
}
