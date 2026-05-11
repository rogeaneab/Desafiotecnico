# Agenda de Contatos - Desafio Técnico (SOLID + JDBC)

Sistema de gerenciamento de contatos desenvolvido em Java, utilizando JDBC para persistência em banco de dados SQLite. O projeto segue os princípios SOLID e padrões de arquitetura em camadas.

## Tecnologias Utilizadas
* **Java 17** (ou superior)
* **Maven** (Gerenciamento de dependências)
* **SQLite** (Banco de dados relacional)
* **JDBC** (Java Database Connectivity)

## Arquitetura e SOLID
O projeto foi estruturado seguindo os princípios SOLID:
* **S (Single Responsibility):** Cada classe possui uma responsabilidade única (Model, Repository, Service, UI).
* **D (Dependency Inversion):** O Service depende de uma interface (`ContatoRepository`), permitindo a troca da implementação de persistência sem afetar a lógica de negócio.
* **Camadas:** Separação clara entre interface de usuário (Console), lógica de negócio (Service) e acesso a dados (Repository).

## Como Executar
1. Certifique-se de ter o **Maven** instalado e configurado no seu PATH.
2. Clone o repositório.
3. Na raiz do projeto, execute o comando para compilar e baixar as dependências:
   ```bash
   mvn clean install
