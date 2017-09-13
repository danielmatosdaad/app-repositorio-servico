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
insert into acaoservico(nome,descricao) values('SALVAR','SALVAR REGISTRO');
insert into acaoservico(nome,descricao) values('DELETAR','DELETAR REGISTRO');
insert into repositorio(nome,nomeArtefatoId,loginServidor,senhaServidor,ipServidor,portaServidor,ativo) values('RESPOSITORIO_CATALOGO_SERVICO','app-repositorio-servico-ear','admin','Daad161931[','127.0.0.1','8080',1);
insert into catalogo(nome,nomeArtefatoId,repositorio_id,ativo) values('RPO_SVC','app-repositorio-servico-ejb',1,1);
insert into informacaoservico(interfaces,envio,reposta,delegate,tokenAutorizacao,ativo) values('br.app.barramento.integracao.dao.interfaces.IServicoRemoteDAO','br.app.repositorio.servico.integracao.RepositorioServicoDTO', 'br.app.repositorio.servico.integracao.RepositorioServicoDTO','br.app.repositorio.api.RespositorioDelegate','tokenrespositorio',1);
insert into servico(acaoServico_id,catalogo_id,informacaoServico_id,ativo) values(1,1,1,1)
insert into servico(acaoServico_id,catalogo_id,informacaoServico_id,ativo) values(2,1,1,1)

