# 📚 BibliotecaFuc — API de Biblioteca

API REST para gerenciamento de uma biblioteca, com cadastro de **livros** e **categorias**, desenvolvida durante o curso de Java da escola de programação **Fuctura Tecnologia**. O projeto aplica DTOs com ModelMapper, tratamento global de exceções e perfis de ambiente com H2 e MySQL.

> 📚 **Status:** projeto de estudos concluído — evolução dos exercícios de POO para uma API estruturada com boas práticas de camadas e tratamento de erros.

## 🛠️ Tecnologias

- **Java 11**
- **Spring Boot 2** (Web, Data JPA, DevTools)
- **H2 Database** — banco em memória (perfil `test`)
- **MySQL 8** — perfil `dev`
- **ModelMapper** — conversão entre entidades e DTOs
- **Maven**

## 🏗️ Estrutura do projeto

```
src/main/java/com/fuc/biblioteca/
├── configs/       # Bean do ModelMapper
├── controllers/   # Endpoints REST (Livro e Categoria)
├── dtos/          # Objetos de transferência (LivroDto, CategoriaDto)
├── enums/         # Enum Tamanho do livro
├── exceptions/    # Exceções customizadas + handler global
├── models/        # Entidades JPA (Livro N—1 Categoria)
├── profiles/      # Seed de dados por perfil (dev/test)
├── repositories/  # Interfaces JPA
└── services/      # Regras de negócio e validações
```

## 📌 Endpoints

### Livros — `/livro`

| Método | Rota | Descrição |
|--------|------|-----------|
| `GET` | `/livro` | Lista todos os livros |
| `GET` | `/livro/{id}` | Busca livro por id |
| `POST` | `/livro` | Cadastra um livro |
| `PUT` | `/livro/{id}` | Atualiza um livro |
| `DELETE` | `/livro/{id}` | Remove um livro |

### Categorias — `/categoria`

| Método | Rota | Descrição |
|--------|------|-----------|
| `GET` | `/categoria` | Lista todas as categorias |
| `GET` | `/categoria/{id}` | Busca categoria por id |
| `POST` | `/categoria` | Cadastra uma categoria |
| `PUT` | `/categoria/{id}` | Atualiza uma categoria |
| `DELETE` | `/categoria/{id}` | Remove uma categoria |

### Exemplo de requisição

```http
POST /livro
Content-Type: application/json

{
  "titulo": "Clean Code",
  "autor": "Robert C. Martin",
  "texto": "Um manual de boas práticas...",
  "categoria": { "id": 1 }
}
```

## ⚠️ Tratamento de erros

O `GlobalExceptionHandler` (`@RestControllerAdvice`) centraliza as respostas de erro da API:

| Exceção | Status HTTP | Exemplo |
|---------|-------------|---------|
| `ResourceNotFoundException` | `404 Not Found` | Id do livro não encontrado |
| `BadRequestException` | `400 Bad Request` | Título do livro é obrigatório |
| `ConflictException` | `409 Conflict` | Já existe um livro com este título |
| `Exception` (genérica) | `500 Internal Server Error` | Erro inesperado |

## ⚙️ Perfis de ambiente

| Perfil | Banco | Uso |
|--------|-------|-----|
| `test` (padrão) | H2 em memória | Desenvolvimento rápido, com console em `/h2-console` |
| `dev` | MySQL local (`createDatabaseIfNotExist=true`) | Ambiente com banco persistente |

O perfil ativo é definido em `application.properties` na propriedade `spring.profiles.active`.

## 🚀 Como rodar

### Pré-requisitos

- Java 11+
- (Opcional) MySQL 8 para o perfil `dev`

### Rodando com H2 (perfil test — zero configuração)

```bash
git clone https://github.com/luanmvcosta0/BibliotecaFuc.git
cd BibliotecaFuc
./mvnw spring-boot:run
```

A API sobe em `http://localhost:8080`, e o console do H2 fica em `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:testdb`, usuário `sa`, sem senha).

### Rodando com MySQL (perfil dev)

1. Garanta um MySQL rodando em `localhost:3306` (o banco `biblioteca` é criado automaticamente).
2. Ajuste usuário/senha no `application-dev.properties`, se necessário.
3. Troque o perfil ativo para `dev` no `application.properties` e rode a aplicação.

## 🎯 O que eu pratiquei nesse projeto

- CRUD completo com arquitetura em camadas (Controller → Service → Repository)
- Padrão **DTO** com conversão automática via **ModelMapper**
- **Tratamento global de exceções** com `@RestControllerAdvice` e exceções customizadas
- Validações de negócio no service (título obrigatório, título duplicado)
- Relacionamento `@ManyToOne` entre Livro e Categoria
- Uso de **enums** em entidades JPA
- **Perfis de ambiente** (test/dev) com H2 e MySQL
- Respostas HTTP semânticas com `ResponseEntity` (200, 204, 404, 409...)

---

Feito por [Luan Costa](https://github.com/luanmvcosta0) 👋
