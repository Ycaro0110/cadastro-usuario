# 📘 API de Cadastro de Usuários

## 📌 Descrição

A **API de Cadastro de Usuários** é uma aplicação REST desenvolvida em **Java utilizando Spring Boot**, responsável pelo gerenciamento de usuários.

A API permite realizar operações básicas de **CRUD (Create, Read, Update e Delete)**, possibilitando o cadastro, listagem, busca, atualização e remoção de usuários.

A aplicação foi construída utilizando **arquitetura em camadas**, separando responsabilidades entre **Controller, Business e Infrastructure**, garantindo melhor organização, manutenção e escalabilidade do sistema.

---

# 🏗️ Arquitetura da Aplicação

A aplicação segue uma **arquitetura em camadas**, onde cada camada possui responsabilidades específicas.

```
Controller → Business → Infrastructure → Database
```

### Controller

Responsável por expor os **endpoints da API** e receber as requisições HTTP.

Funções:

* Receber requisições do cliente
* Encaminhar chamadas para a camada de negócio
* Retornar respostas HTTP

---

### Business

Contém a **lógica de negócio da aplicação**.

Responsabilidades:

* Processamento das regras de negócio
* Manipulação dos dados da aplicação
* Comunicação entre Controller e camada de infraestrutura

---

### Infrastructure

Responsável pela **persistência de dados**, incluindo:

* Entidades
* Repositórios
* Comunicação com o banco de dados

---

# 🛠️ Tecnologias Utilizadas

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Maven

---

# 📂 Estrutura do Projeto

```
src
 └── main
     └── java
         └── com.example.cadastro_usuario
             ├── controller
             │    └── UsuarioController
             ├── business
             │    └── UsuarioService
             ├── infrastructure
             │    ├── entitys
             │    │     └── Usuario
             │    └── repository
             └── CadastroUsuarioApplication
```

---

# 👤 Modelo de Usuário

A entidade **Usuario** possui os seguintes atributos:

| Campo | Tipo   |
| ----- | ------ |
| id    | Long   |
| nome  | String |
| email | String |

### Exemplo de objeto JSON

```json
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao@email.com"
}
```

---

# 🔗 Endpoints da API

Base URL:

```
/usuario
```

---

## 📌 Cadastrar Usuário

**POST**

```
/usuario
```

### Body da requisição

```json
{
  "nome": "João Silva",
  "email": "joao@email.com"
}
```

### Resposta

```
200 OK
```

---

## 📌 Listar Usuários

**GET**

```
/usuario/listar
```

### Resposta

```json
[
  {
    "id": 1,
    "nome": "João Silva",
    "email": "joao@email.com"
  },
  {
    "id": 2,
    "nome": "Maria Souza",
    "email": "maria@email.com"
  }
]
```

---

## 📌 Buscar Usuário por Email

**GET**

```
/usuario?email=email@exemplo.com
```

### Exemplo

```
/usuario?email=joao@email.com
```

---

## 📌 Atualizar Usuário

**PUT**

```
/usuario?id=1
```

### Body da requisição

```json
{
  "nome": "João Atualizado",
  "email": "novoemail@email.com"
}
```

---

## 📌 Deletar Usuário

**DELETE**

```
/usuario?email=email@exemplo.com
```

### Exemplo

```
/usuario?email=joao@email.com
```

---

# ▶️ Executando o Projeto

### 1️⃣ Clonar o repositório

```bash
git clone https://github.com/seuusuario/cadastro-usuario-api.git
```

### 2️⃣ Entrar no diretório

```bash
cd cadastro-usuario-api
```

### 3️⃣ Executar a aplicação

```bash
mvn spring-boot:run
```

A aplicação estará disponível em:

```
http://localhost:8080
```

---

# 🧪 Testes da API

A API pode ser testada utilizando ferramentas como:

* Postman
* Insomnia
* Curl

---

# 📚 Conceitos Aplicados

* API REST
* Arquitetura em Camadas
* Injeção de Dependência
* Spring Boot
* Persistência com JPA
