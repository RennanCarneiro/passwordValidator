# API de Validação de Senhas (Password Validator)

Uma API RESTful desenvolvida em **Java 26** e **Spring Boot 4**, construída para validar a força e segurança de senhas. 

O diferencial deste projeto é a sua arquitetura limpa: o motor de validação foi totalmente isolado do framework utilizando o padrão de projeto estrutural **Chain of Responsibility** (Corrente de Responsabilidade), garantindo um código altamente coeso, testável e fácil de expandir.

---

## Demonstração ao Vivo (Deploy)

A API está hospedada na nuvem utilizando o **Render** e conteinerizada com **Docker**. Você pode testá-la diretamente pelo navegador através da interface do Swagger:

 **[Acessar a API na Nuvem] https://passwordvalidator-dht6.onrender.com**

> **Nota sobre o ambiente gratuito:** Esta aplicação está hospedada em um plano gratuito. Caso a API fique sem receber requisições por 15 minutos, o servidor entra em modo de hibernação. Portanto, **a primeira requisição pode levar cerca de 40 a 50 segundos** para "acordar" o servidor. As requisições subsequentes serão instantâneas.

---

## Destaques Técnicos

* **Design Pattern (Chain of Responsibility):** Regras de negócio separadas em elos encadeados (`LengthValidator`, `UpperCaseValidator`, `SpecialCharValidator`). Adicionar uma nova regra no futuro (ex: exigir números) não quebra o código existente (Open/Closed Principle).
* **Tratamento Global de Erros (Controller Advice):** Qualquer falha na validação é interceptada globalmente, retornando um JSON estruturado e padronizado com o HTTP Status correto (400 Bad Request).
* **Uso de Java Records:** DTOs imutáveis modernos (`ErrorResponse`) para o transporte de dados de erro.
* **Qualidade e Testes:** Cobertura de testes unitários com JUnit 5 para garantir o comportamento correto de cada elo da corrente de validação.
* **Infraestrutura como Código:** Aplicação conteinerizada com Docker utilizando *multi-stage build* para otimização de imagem.

## Tecnologias Utilizadas

* **Linguagem:** Java 26
* **Framework:** Spring Boot 4.0.6
* **Gerenciador de Dependências:** Maven
* **Testes:** JUnit 5
* **Documentação:** Springdoc OpenAPI (Swagger UI)
* **DevOps/Infra:** Docker & Render (PaaS)

## ⚙️ Como Executar o Projeto Localmente

1. Clone o repositório:
   ```bash
   git clone [https://github.com/RennanCarneiro/passwordValidation.git](https://github.com/SEU_USUARIO/passwordValidation.git)

## Endpoint Principal

### `POST /api/auth/validate`

Valida uma senha com base nas seguintes regras:
- Mínimo de 8 caracteres.
- Pelo menos uma letra maiúscula.
- Pelo menos um caractere especial.
