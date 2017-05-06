--
-- JBoss, Home of Professional Open Source
-- Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
-- contributors by the @authors tag. See the copyright.txt in the
-- distribution for a full listing of individual contributors.
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- http://www.apache.org/licenses/LICENSE-2.0
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

-- You can use this file to load seed data into the database using SQL statements
insert into informacaoservico(interfaces,envio,reposta,delegate,ativo) values('br.app.barramento.integracao.dao.interfaces.IServicoRemoteDAO','br.app.servico.infra.integracao.dto.ParametroDTO', 'br.app.servico.infra.integracao.dto.ParametroDTO','br.app.servico.infra.parametro.api.ParametroDelegate',1);
insert into informacaoservico(interfaces,envio,reposta,delegate,ativo) values('br.app.barramento.integracao.dao.interfaces.IServicoRemoteDAO','br.app.servico.infra.integracao.dto.GrupoFuncionalidadeDTO', 'br.app.servico.infra.integracao.dto.dto.GrupoFuncionalidadeDTO','br.app.servico.infra.funcionalidademetadado.api.GrupoFuncionalidadeDelegate',1);
insert into informacaoservico(interfaces,envio,reposta,delegate,ativo) values('br.app.barramento.integracao.dao.interfaces.IServicoRemoteDAO','br.app.servico.infra.integracao.dto.IdentificadorDTO', 'br.app.servico.infra.integracao.dto.IdentificadorDTO','br.app.servico.infra.funcionalidademetadado.api.IdentificadorDelegate',1);
insert into informacaoservico(interfaces,envio,reposta,delegate,ativo) values('br.app.barramento.integracao.dao.interfaces.IServicoRemoteDAO','br.app.servico.infra.integracao.dto.PerfilDTO', 'br.app.servico.infra.integracao.dto.PerfilDTO','br.app.servico.infra.funcionalidademetadado.api.PerfilDelegate',1);
insert into informacaoservico(interfaces,envio,reposta,delegate,ativo) values('br.app.barramento.integracao.dao.interfaces.IServicoRemoteDAO','br.app.servico.infra.integracao.dto.FuncionalidadeDTO', 'br.app.servico.infra.integracao.dto.FuncionalidadeDTO','br.app.servico.infra.funcionalidademetadado.api.FuncionalidadeDelegate',1);
insert into informacaoservico(interfaces,envio,reposta,delegate,ativo) values('br.app.barramento.integracao.dao.interfaces.IServicoRemoteDAO','br.app.servico.infra.integracao.dto.MetaDadoDTO', 'br.app.servico.infra.integracao.dto.MetaDadoDTO','br.app.servico.infra.funcionalidademetadado.api.MetaDadoDelegate',1);
insert into informacaoservico(interfaces,envio,reposta,delegate,ativo) values('br.app.servico.infra.integracao.interfaces.IServicoComponenteTelaRemote','br.app.servico.infra.integracao.dto.ObterConversaoComponenteTelaDTO', 'br.app.servico.infra.integracao.dto.ObterConversaoComponenteTelaDTO','br.app.servico.infra.telametadadoxml.api.ComponenteTelaDelegate',1);
insert into informacaoservico(interfaces,envio,reposta,delegate,ativo) values('br.app.servico.infra.integracao.interfaces.IServicoComponenteTelaRemote','br.app.servico.infra.integracao.dto.ObterConversaoCompositeDTO', 'br.app.servico.infra.integracao.dto.ObterConversaoCompositeDTO','br.app.servico.infra.telametadadoxml.api.ComponenteTelaDelegate',1);
insert into informacaoservico(interfaces,envio,reposta,delegate,ativo) values('br.app.servico.infra.integracao.interfaces.IServicoComponenteTelaRemote','br.app.servico.infra.integracao.dto.ObterConversaoComponenteUIDTO', 'br.app.servico.infra.integracao.dto.RepostaConversaoComponenteUIDTO','br.app.servico.infra.telametadadoxml.api.ComponenteTelaDelegate',1);
insert into informacaoservico(interfaces,envio,reposta,delegate,ativo) values('br.app.servico.infra.integracao.interfaces.IServicoProcessoConfiguracao','br.app.servico.infra.integracao.dto.ProcessoConfiguracaoDTO', 'br.app.servico.infra.integracao.dto.ProcessoConfiguracaoDTO','br.app.servico.infra.funcionalidademetadado.api.ProcessoConfiguracaoTelaDelegate',1);
insert into informacaoservico(interfaces,envio,reposta,delegate,ativo) values('br.app.barramento.integracao.dao.interfaces.IServicoRemoteDAO','br.app.corporativo.integracao.dto.UsuarioDTO', 'br.app.corporativo.integracao.dto.UsuarioDTO','br.app.corporativo.usuario.api.UsuarioDelegate',1);


insert into acaoservico(nome,descricao) values('SALVAR','SALVAR REGISTRO');
insert into acaoservico(nome,descricao) values('BUSCAR_TODOS','BUSCAR TODOS REGISTRO');
insert into acaoservico(nome,descricao) values('SALVAR_LISTA','SALVAR LISTA REGISTRO');
insert into acaoservico(nome,descricao) values('EXCLUIR','EXCLUIR TODOS REGISTRO');
insert into acaoservico(nome,descricao) values('ATUALIZAR','ATUALIZAR TODOS REGISTRO');
insert into acaoservico(nome,descricao) values('BUSCAR_POR_ID','BUSCAR POR ID REGISTRO');
insert into acaoservico(nome,descricao) values('EXCLUIR_POR_ID','EXCLUIR POR ID REGISTRO');
insert into acaoservico(nome,descricao) values('BUSCAR_POR_INTERVALO','BUSCAR POR INTERVALO REGISTRO');
insert into acaoservico(nome,descricao) values('EXECUTAR','EXECUTAR');
insert into acaoservico(nome,descricao) values('CONVERTER_ARQUIVO_COMPONENTE_TELA','CONVERTER ARQUIVO COMPONENTE TELA');
insert into acaoservico(nome,descricao) values('CONVERTER_COMPOSITE_COMPONENTE_TELA','CONVERTER COMPOSITE COMPONENTE TELA');
insert into acaoservico(nome,descricao) values('CONVERTER_COMPONENTE_TELA_UI','CONVERTER COMPONENTE TELA UI');
insert into acaoservico(nome,descricao) values('SALVAR_SEM_RELACIONAMENTO','SALVAR_SEM_RELACIONAMENTO');
insert into acaoservico(nome,descricao) values('SALVAR_TELA_UI','SALVAR TELA UI');


insert into repositorio(nome,ativo) values('RESPOSITORIO_INFRA',1);
insert into repositorio(nome,ativo) values('REPOSITORIO_CORPORATIVO',1);
insert into catalogo(nome,repositorio_id,ativo) values('CATALOGO_PMT',2,1);
insert into catalogo(nome,repositorio_id,ativo) values('CATALOGO_FNC',2,1);
insert into catalogo(nome,repositorio_id,ativo) values('CATALOGO_CPN_TLA',2,1);
insert into catalogo(nome,repositorio_id,ativo) values('CATALOGO_USR',2,1);

insert into servico(acaoServico_id,catalogo_id,informacaoServico_id,ativo) values(1,1,1,1)
insert into servico(acaoServico_id,catalogo_id,informacaoServico_id,ativo) values(2,1,1,1)
insert into servico(acaoServico_id,catalogo_id,informacaoServico_id,ativo) values(1,2,2,1)
insert into servico(acaoServico_id,catalogo_id,informacaoServico_id,ativo) values(2,2,2,1)
insert into servico(acaoServico_id,catalogo_id,informacaoServico_id,ativo) values(1,2,3,1)	
insert into servico(acaoServico_id,catalogo_id,informacaoServico_id,ativo) values(2,2,3,1)
insert into servico(acaoServico_id,catalogo_id,informacaoServico_id,ativo) values(1,2,4,1)
insert into servico(acaoServico_id,catalogo_id,informacaoServico_id,ativo) values(2,2,4,1)
insert into servico(acaoServico_id,catalogo_id,informacaoServico_id,ativo) values(1,2,5,1)
insert into servico(acaoServico_id,catalogo_id,informacaoServico_id,ativo) values(2,2,5,1)	
insert into servico(acaoServico_id,catalogo_id,informacaoServico_id,ativo) values(1,2,6,1)
insert into servico(acaoServico_id,catalogo_id,informacaoServico_id,ativo) values(2,2,6,1)
insert into servico(acaoServico_id,catalogo_id,informacaoServico_id,ativo) values(10,3,7,1)
insert into servico(acaoServico_id,catalogo_id,informacaoServico_id,ativo) values(11,3,8,1)
insert into servico(acaoServico_id,catalogo_id,informacaoServico_id,ativo) values(12,3,9,1)
insert into servico(acaoServico_id,catalogo_id,informacaoServico_id,ativo) values(13,2,5,1)
insert into servico(acaoServico_id,catalogo_id,informacaoServico_id,ativo) values(14,2,10,1)
insert into servico(acaoServico_id,catalogo_id,informacaoServico_id,ativo) values(1,4,11,1)
insert into servico(acaoServico_id,catalogo_id,informacaoServico_id,ativo) values(2,4,11,1)
