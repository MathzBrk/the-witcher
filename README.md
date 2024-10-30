This readme is in English and in PT-BR

PT-BR:
The Witcher 3 API
API REST para informações detalhadas sobre o jogo The Witcher 3: Wild Hunt

Este projeto fornece uma API REST para acesso a informações sobre o jogo The Witcher 3: Wild Hunt, incluindo personagens, monstros, missões (quests), itens e reinos. A API foi projetada para facilitar a recuperação desses dados para desenvolvedores, jogadores e aplicações de terceiros.

Funcionalidades
Personagens: Informações sobre personagens do jogo.
Monstros: Detalhes sobre os monstros enfrentados.
Missões (Quests): Dados sobre as missões disponíveis.
Itens: Informações sobre itens utilizáveis no jogo.
Reinos: Descrições dos reinos do universo de The Witcher 3.
Cada funcionalidade possui métodos de consulta (GET) para recuperação de dados. A API fornece respostas no formato JSON para facilitar a integração com aplicações front-end ou de terceiros.

Há também um MainMenu que permite listar alguns dados pré-salvos no banco de dados, além da possibilidade de criar mais dados para compor a API.

Tecnologias Utilizadas
Java 17
Spring Boot 3.3.4: Framework para desenvolvimento da API.
Spring Boot Starter Web: Para criação da API REST.
Spring Boot Starter Data JPA: Para persistência de dados.
Spring Boot DevTools: Para desenvolvimento local.
Spring Boot Starter Test: Para testes.
PostgreSQL: Banco de dados relacional.
Maven: Gerenciamento de dependências.
Jakarta Persistence API (JPA): Para mapeamento objeto-relacional (ORM).
Estrutura do Projeto
O projeto segue o padrão Package by Layer e está dividido nos seguintes pacotes principais:

Controller: Gerencia as requisições HTTP e delega as operações para o serviço.
DTO (Data Transfer Objects): Facilita a troca de dados entre camadas e garante uma representação simplificada das informações na API.
Model: Contém as entidades mapeadas com o banco de dados.
Repository: Interface que estende JpaRepository, responsável pela comunicação com o banco de dados.
Service: Implementa a lógica de negócios e interage com o repositório para manipulação de dados.
Como Executar
Clone o repositório para sua máquina local.
Certifique-se de ter o PostgreSQL instalado e rodando. Atualize o arquivo application.properties com suas credenciais do banco de dados.
Execute o projeto. A API estará disponível em: http://localhost:8080.

English:

The Witcher 3 API
REST API for detailed information about the game The Witcher 3: Wild Hunt

This project provides a REST API to access information about the game The Witcher 3: Wild Hunt, including characters, monsters, quests, items, and realms. The API was designed to facilitate the retrieval of this data for developers, players, and third-party applications.

Features

Characters: Information about characters in the game.
Monsters: Details about the encountered monsters.
Quests: Data about available quests.
Items: Information about usable items in the game.
Realms: Descriptions of the realms in the Witcher 3 universe. Each feature has GET methods for data retrieval. The API provides JSON-formatted responses for easy integration with front-end or third-party applications.
There is also a MainMenu that allows you to list some pre-saved data in the database, as well as the ability to create more data to compose the API.

Technologies Used

Java 17
Spring Boot 3.3.4: Framework for API development.
Spring Boot Starter Web: For creating the REST API.
Spring Boot Starter Data JPA: For data persistence.
Spring Boot DevTools: For local development.
Spring Boot Starter Test: For testing.
PostgreSQL: Relational database.
Maven: Dependency management.
Jakarta Persistence API (JPA): For object-relational mapping (ORM).
Project Structure
The project follows the Package by Layer pattern and is divided into the following main packages:

Controller: Manages HTTP requests and delegates operations to the service.
DTO (Data Transfer Objects): Facilitates data exchange between layers and ensures a simplified representation of information in the API.
Model: Contains entities mapped to the database.
Repository: Interface that extends JpaRepository, responsible for communicating with the database.
Service: Implements business logic and interacts with the repository for data manipulation.
How to Run

Clone the repository to your local machine.
Make sure you have PostgreSQL installed and running. Update the application.properties file with your database credentials.
Run the project. The API will be available at: http://localhost:8080.
