# Microsserviços - Pedido e Produto

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

Esse é um projeto construído em  **Java com Spring Boot, OpenFeign, Spring Data Jpa, PostgreSQL, Flyway** 

O Projeto utiliza a arquitetura de microsserviços com Java/Spring. Ao qual poderá realizar a criação de um produto, criação de um pedido e remoção de um pedido. O microsserviço é utilizado para chamadas HTTP utilizando o OpenFeign, sendo possível buscar os dados dos produtos para que seja criado os pedidos. 
## Table of Contents

- [Instalação](#instalação)
- [Usabilidade](#usabilidade)
- [API Endpoints](#api-endpoints)
- [Contribuição](#contribuição)

## Instalação

1. Clone o repositório:

```bash
git clone https://github.com/samuel-melo1/Order-Product-Microsservice
```

2. Instale o banco de dados PostgreSQL

[PostgreSQL](https://www.postgresql.org/download/) 

## Usabilidade

1. Crie o seguinte banco de dados no PostgreSQL: product-order-db  
2. Inicie a aplicação com o Maven
3. A API estará disponível em http://localhost:8080

## API Endpoints
A API possui os seguintes endpoints:

```markdown

POST /api/v1/create - Realizar a criação de um produto.

GET /api/v1/{id} - Buscar um produto cadastrado na base de dados. 

GET /api/v1/products - Buscar todos os usuários cadastrados na base de dados. 

POST /api/orders/create-order - Realiza a criação de um pedido.

GET /api/orders/delete/{id}  - Realiza a exclusão de um determinado pedido. 
```

## Contribuição

Sugestões e/ou contribuições são bem-vindas! Se você encontrar qualquer questão ou tenha sugestões de melhorias, por favor, abra uma solicitação pull para o repositório. 


Ao contribuir para este projeto, siga o estilo de código existente, [commit conventions](https://www.conventionalcommits.org/en/v1.0.0/), e envie suas alterações em uma ramificação separada.
