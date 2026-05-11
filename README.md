# Agenda de Contatos - Desafio Técnico (SOLID + JDBC)

Sistema de gerenciamento de contatos desenvolvido em Java, utilizando JDBC para persistência em banco de dados SQLite. O projeto segue os princípios SOLID e padrões de arquitetura em camadas.

## Tecnologias Utilizadas
* **Java 17** (ou superior)
* **Maven** (Gerenciamento de dependências)
* **SQLite** (Banco de dados relacional)
* **JDBC** (Java Database Connectivity)

## Estrutura do Projeto (SOLID)
Como o projeto está organizado:
- **`model`**: Entidade Contato.
- **`repository`**: Interface e implementação JDBC (Inversão de
Dependência).
- **`service`**: Regras de negócio separadas da UI (Responsabilidade
Única).
- **`database`**: Gestão da conexão SQLite.
- **`ui`**: Interface de console.

## Como Executar
1. Certifique-se de ter o **Maven** instalado e configurado no seu PATH.
2. Clone o repositório.
3. Na raiz do projeto, execute o comando para compilar e baixar as dependências:
   ```bash
   mvn clean install
