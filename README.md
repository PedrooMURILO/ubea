# Projeto UBEA - ONG de Adoção de Gatos

Sistema para gestão de adoções de gatos, desenvolvido para a ONG UBEA.

## Tecnologias Utilizadas

- **Back-End:** Java 17 com Spring Boot
- **Banco de Dados:** SQL Server
- **Gerenciador de Dependências:** Maven

## Estrutura do Projeto

/src
/main
/java
/com/ubea
/controller
/model
/repository
/service
/resources
application.properties

## Funcionalidades e Métodos Disponíveis

A API oferece os principais endpoints para gerenciamento dos gatos, usuários e adoções. Entre os principais métodos estão:

### Usuários
- **Cadastrar usuário:** `POST /users` — Cria um novo usuário.
- **Atualizar usuário:** `PUT /users/{id}` — Atualiza dados do usuário.
- **Excluir usuário:** `DELETE /users/{id}` — Remove um usuário (normalmente desativa).
- **Buscar usuário por ID:** `GET /users/{id}` — Retorna dados de um usuário específico.
- **Login:** `POST /login` — Autentica usuário com email e senha.

### Gatos
- **Cadastrar gato:** `POST /cats` — Adiciona um novo gato para adoção.
- **Listar gatos:** `GET /cats` — Retorna lista dos gatos disponíveis.
- **Atualizar gato:** `PUT /cats/{id}` — Atualiza informações de um gato.
- **Remover gato:** `DELETE /cats/{id}` — Remove um gato do sistema.

### Adoções
- **Registrar adoção:** `POST /adoptions` — Registra a adoção de um gato por um usuário.
- **Listar adoções:** `GET /adoptions` — Lista todas as adoções feitas.
- **Detalhar adoção:** `GET /adoptions/{id}` — Retorna detalhes de uma adoção específica.

Esses métodos seguem padrões REST, utilizando JSON para requisições e respostas, garantindo comunicação clara e consistente com o front-end ou clientes externos.
