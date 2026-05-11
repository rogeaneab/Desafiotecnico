# Agenda de Contatos - Desafio Técnico (SOLID + JDBC)
Sistema de gerenciamento de contatos via console desenvolvido em Java,
utilizando JDBC para persistência em SQLite e seguindo os princípios
**SOLID**.
## Como Executar
1. Certifique-se de ter o **Java 17** e o **Maven** instalados.
2. Clone o repositório.
3. No terminal, execute: `mvn clean install`
4. Rode a classe `Main.java`.
## Estrutura do Projeto (SOLID)
O projeto está organizado conforme os princípios de design:
- **`model`**: Entidade Contato.
- **`repository`**: Interface e implementação JDBC (Inversão de
Dependência).
- **`service`**: Regras de negócio separadas da UI (Responsabilidade
Única).
- **`database`**: Gestão da conexão SQLite.
- **`ui`**: Interface de console.
## Tecnologias
- Java 17
- SQLite
- Maven
