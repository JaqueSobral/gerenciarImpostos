# Desafio: Construindo uma API de Cálculo de Impostos com TDD, Spring Security e JWT

## Descrição do Desafio
Este projeto consiste no desenvolvimento de uma API RESTful para gerenciar e calcular impostos no Brasil. A API permite o registro de diferentes tipos de impostos, como ICMS, ISS, IPI, entre outros, e realiza cálculos com base no tipo de imposto e no valor base fornecido. Além disso, a API é segura, utilizando **Spring Security** e **JWT (JSON Web Token)** para autenticação e autorização.

---
## Objetivo
Criar uma API funcional e segura que atenda aos seguintes requisitos:

### 1. Gerenciamento de Tipos de Impostos
- Listar todos os tipos de impostos disponíveis.
- Cadastrar novos tipos de impostos (nome, descrição e alíquota).
- Obter detalhes de um tipo de imposto específico pelo ID.
- Excluir um tipo de imposto pelo ID.

### 2. Cálculo de Impostos
- Calcular o valor do imposto com base no tipo de imposto (identificado pelo ID) e no valor base fornecido.

### 3. Segurança
- Implementar autenticação e autorização utilizando **Spring Security** e **JWT**.
- Apenas usuários autenticados podem acessar os endpoints.
- Restringir o acesso a endpoints de criação, exclusão e cálculo de impostos para usuários com o papel de **ADMIN**.

### 4. Padrões e Boas Práticas
- Seguir o padrão **REST** para a construção dos endpoints.
- Utilizar códigos HTTP apropriados para cada operação (200, 201, 204, 400, 404).
- Garantir que a API seja escalável e permita a adição de novos tipos de impostos e lógica de cálculo no futuro.

---
## Requisitos Técnicos
- **Linguagem**: Java
- **Framework**: Spring Boot
- **Autenticação e Autorização**: Spring Security e JWT
- **Testes**: JUnit (Não implementado)
- **Documentação**: README.md
- **Formato de Resposta**: JSON

---

## Endpoints Implementados

### 1. **GET /tipos**
Retorna a lista de todos os tipos de impostos cadastrados.

*# API de Gestão de Impostos

Este repositório contém a implementação de uma API para gestão de impostos, incluindo cadastro, cálculo e autenticação de usuários.

## Endpoints

### 1. **GET /tipos**
Retorna a lista de tipos de impostos cadastrados.

**Resposta (200):**
```JSON
[
  {
    "id": 1,
    "nome": "ICMS",
    "descricao": "Imposto sobre Circulação de Mercadorias e Serviços",
    "aliquota": 18.0
  },
  {
    "id": 2,
    "nome": "ISS",
    "descricao": "Imposto sobre Serviços",
    "aliquota": 5.0
  }
]

2. POST /tipos
Cadastra um novo tipo de imposto. Acesso restrito ao papel ADMIN.

Entrada:
{
  "nome": "IPI",
  "descricao": "Imposto sobre Produtos Industrializados",
  "aliquota": 12.0
}
Resposta (201):
{
  "id": 3,
  "nome": "IPI",
  "descricao": "Imposto sobre Produtos Industrializados",
  "aliquota": 12.0
}
3. POST /calculo
Calcula o valor do imposto com base no tipo de imposto e no valor base. Acesso restrito ao papel ADMIN.

Entrada:
{
  "tipoImpostoId": 1,
  "valorBase": 1000.0
}
Resposta (200):
{
  "tipoImposto": "ICMS",
  "valorBase": 1000.0,
  "aliquota": 18.0,
  "valorImposto": 180.0
}
4. GET /tipos/{id}
Retorna os detalhes de um tipo de imposto específico pelo ID.

Resposta (200):
{
  "id": 1,
  "nome": "ICMS",
  "descricao": "Imposto sobre Circulação de Mercadorias e Serviços",
  "aliquota": 18.0
}
5. DELETE /tipos/{id}
Exclui um tipo de imposto pelo ID. Acesso restrito ao papel ADMIN.

Resposta (204): Sem conteúdo.

6. POST /user/register
Registra novos usuários no sistema.

Entrada:
{
  "username": "usuario123",
  "password": "senhaSegura",
  "role": "USER"
}
Resposta (201):
{
  "id": 1,
  "username": "usuario123",
  "role": "USER"
}
7. POST /user/login
Autentica usuários e gera um token JWT.

Entrada:
{
  "username": "usuario123",
  "password": "senhaSegura"
}
Resposta (200):
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
]

##Tecnologias Utilizadas##
Java com Spring Boot
Spring Security para autenticação e autorização
JWT para geração de tokens
JUnit para testes unitários
Swagger para documentação da API
##Como Executar o Projeto##
**Clone o repositório:**
1-git clone <url-do-repositorio>
2-cd <nome-do-projeto>
3-Configure o banco de dados no arquivo application.properties.
4-Execute o projeto:./mvnw spring-boot:run

