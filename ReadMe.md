

# TodoList

Este é um projeto de gerenciamento de tarefas desenvolvido em **Java** utilizando o framework **Spring Boot** e gerenciado pelo **Maven**. O objetivo do projeto é fornecer uma API REST para criar, listar e atualizar tarefas.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
    - Spring Boot Starter Web
    - Spring Boot Starter Data JPA
    - Spring Boot DevTools
    - Spring Boot Starter Test
- **H2 Database** (banco de dados em memória)
- **Lombok** (para reduzir boilerplate no código)
- **BCrypt** (para hashing de senhas)
- **Maven** (gerenciador de dependências)
- **Docker** (para containerização)

## Funcionalidades

### Endpoints da API

#### Criar Tarefa
- **POST** `/tasks/`
    - Cria uma nova tarefa.
    - Validações:
        - A data de início e término devem ser maiores que a data atual.
        - A data de início deve ser menor que a data de término.
        - O título da tarefa não pode exceder 50 caracteres.

#### Listar Tarefas
- **GET** `/tasks/`
    - Lista todas as tarefas associadas ao usuário autenticado.

#### Atualizar Tarefa
- **PUT** `/tasks/{id}`
    - Atualiza uma tarefa existente.
    - Validações:
        - Verifica se a tarefa existe.
        - Verifica se o usuário autenticado tem permissão para alterar a tarefa.

## Estrutura do Projeto

### `pom.xml`
O arquivo `pom.xml` gerencia as dependências do projeto, incluindo Spring Boot, H2 Database, Lombok, BCrypt, entre outras.

### `TaskController.java`
Controlador responsável por gerenciar os endpoints da API relacionados às tarefas.

### `Dockerfile`
Arquivo para containerização do projeto. Ele realiza as seguintes etapas:
1. Usa uma imagem base do Ubuntu para compilar o projeto.
2. Instala o Maven e o OpenJDK 17.
3. Compila o projeto com o Maven.
4. Usa uma imagem base do OpenJDK 17 para executar o JAR gerado.

## Como Executar

### Pré-requisitos
- **Java 17** instalado.
- **Maven** instalado.
- **Docker** (opcional, para execução em container).

### Passos
1. Clone o repositório.
2. Compile o projeto:
   ```bash
   mvn clean install
   ```
3. Execute o projeto:
   ```bash
   java -jar target/todolist-0.0.1-SNAPSHOT.jar
   ```

### Usando Docker
1. Construa a imagem Docker:
   ```bash
   docker build -t todolist .
   ```
2. Execute o container:
   ```bash
   docker run -p 8080:8080 todolist
   ```

## Teste Online

Você pode testar as funcionalidades do projeto acessando o link do deploy:

[https://todolist-rocket-gyos.onrender.com](https://todolist-rocket-gyos.onrender.com)

## Observações
- O banco de dados H2 é utilizado apenas em tempo de execução e não persiste os dados após o encerramento da aplicação.
- Certifique-se de configurar corretamente o atributo `idUser` no cabeçalho da requisição para associar as tarefas ao usuário correto.

