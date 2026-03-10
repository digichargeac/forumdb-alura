# ForumHub API

API REST desenvolvida em Java com o objetivo de gerenciar tópicos de um fórum de discussão.
O projeto foi desenvolvido como parte de estudos sobre arquitetura backend moderna utilizando Spring Boot, autenticação JWT e boas práticas de desenvolvimento de APIs.

---

## 📌 Descrição

O **ForumHub** é uma API responsável por gerenciar tópicos de um fórum, permitindo:

* Criar tópicos
* Listar tópicos
* Atualizar tópicos
* Remover tópicos
* Autenticar usuários via login
* Proteger rotas utilizando autenticação JWT

A aplicação segue arquitetura baseada em camadas, separando responsabilidades entre **controller, service, repository, domain e security**.

---

## 🚀 Tecnologias utilizadas

O projeto foi desenvolvido utilizando as seguintes tecnologias:

* Java 21+
* Spring Boot
* Spring Security
* Spring Data JPA
* JWT (JSON Web Token)
* Flyway
* PostgreSQL
* Maven
* Lombok

Frameworks e ferramentas importantes utilizados:

* Spring Boot
* Spring Security
* Hibernate
* Flyway
* PostgreSQL

---

## 📂 Estrutura do Projeto

```
src
 └── main
     └── java
         └── com.alura.forumhub
             ├── config
             │     └── SecurityConfigurations
             │
             ├── controller
             │     └── AuthController
             │
             ├── domain
             │     ├── topico
             │     │     ├── Topico
             │     │     ├── StatusTopico
             │     │     └── TopicoRepository
             │     │
             │     └── usuario
             │           ├── Usuario
             │           └── UsuarioRepository
             │
             ├── dto
             │     └── DadosLogin
             │
             ├── security
             │     ├── SecurityFilter
             │     └── TokenService
             │
             └── ForumhubApplication
```

---

## 🔐 Autenticação

A API utiliza autenticação baseada em **JWT (JSON Web Token)**.

Fluxo de autenticação:

1. O usuário realiza login.
2. A API valida as credenciais.
3. Um token JWT é gerado.
4. O token deve ser enviado no header das requisições protegidas.

Header utilizado:

```
Authorization: Bearer TOKEN_JWT
```

---

## 📡 Endpoints principais

### 🔑 Login

```
POST /login
```

Exemplo de requisição:

```json
{
  "login": "usuario",
  "senha": "123456"
}
```

Resposta:

```
TOKEN JWT
```

---

### 📚 Tópicos

Alguns endpoints esperados para gerenciamento de tópicos:

```
GET /topicos
POST /topicos
PUT /topicos/{id}
DELETE /topicos/{id}
```

---

## 🗄️ Banco de Dados

O projeto utiliza **PostgreSQL** como banco de dados.

As migrações são controladas através do **Flyway**.

### Tabela `topicos`

```
id
titulo
mensagem
data_criacao
status
autor
curso
```

### Tabela `usuarios`

```
id
login
senha
```

---

## ⚙️ Configuração do Projeto

### 1️⃣ Clonar o repositório

```bash
git clone https://github.com/seu-usuario/forumhub.git
```

### 2️⃣ Configurar banco de dados

Criar banco PostgreSQL:

```
forumdb
```

### 3️⃣ Configurar `application.properties`

```
spring.datasource.url=jdbc:postgresql://localhost:5432/forumdb
spring.datasource.username=postgres
spring.datasource.password=senha

spring.jpa.hibernate.ddl-auto=validate

jwt.secret=seu_segredo_super_secreto
```

---

## ▶️ Executar o projeto

Rodar a aplicação utilizando Maven:

```
mvn spring-boot:run
```

Ou executar a classe principal:

```
ForumhubApplication.java
```

A aplicação será iniciada em:

```
http://localhost:8080
```

---

## 🧪 Testes da API

Ferramentas recomendadas para testes:

* Postman
* Insomnia
* Curl

Fluxo recomendado de teste:

1. Criar usuário no banco
2. Fazer login
3. Receber token
4. Acessar endpoints protegidos

---

## 📚 Conceitos aplicados

Este projeto aplica diversos conceitos importantes de desenvolvimento backend:

* API REST
* Arquitetura em camadas
* Autenticação JWT
* Controle de acesso com Spring Security
* Migrations com Flyway
* Persistência com JPA/Hibernate
* DTOs
* Clean Code

---

## 👨‍💻 Autor

Projeto desenvolvido por:

**Antônio Carlos Martins Teixeira**

Como parte de estudos em desenvolvimento backend com Java e Spring.

---

## 📄 Licença

Este projeto foi desenvolvido para fins educacionais.
