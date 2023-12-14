Exemplo de CRUD com Spark Java

Este é um exemplo simples de aplicação CRUD (Create, Read, Update, Delete) construída com o Spark Java. Ele demonstra como criar endpoints RESTful para gerenciar uma coleção de usuários.

Pré-requisitos
Antes de começar, certifique-se de ter os seguintes itens instalados:

Java (versão 8 ou superior)
Maven
Postman (opcional, para testes)

#Primeiros Passos

#Clone o repositório:

bash
Copy code
git clone https://github.com/Lcooser/AssessmentJavaAPI.git

Navegue até o diretório do projeto:

bash
Copy code
cd AssessmentJavaAPI

Compile o projeto:

bash
Copy code
mvn clean install
Execute a aplicação:

bash
Copy code
java -jar target/AssessmentJavaAPI-1.0.jar
A aplicação será iniciada em http://localhost:4567/api/usuarios.

Endpoints
GET /api/usuarios: Recupera todos os usuários.
GET /api/usuarios/:id: Recupera um usuário específico por ID.
POST /api/usuarios: Cria um novo usuário.
PUT /api/usuarios: Atualiza um usuário existente.
DELETE /api/usuarios/:id: Exclui um usuário por ID.

#Testando
Use o Postman ou qualquer outra ferramenta de teste de API para interagir com os endpoints.

Exemplo de JSON para requisições POST e PUT:

json
Copy code
{
  "id": 1,
  "nome": "Fulano",
  "senha": "minhasenha"
}
Contribuições
Sinta-se à vontade para contribuir abrindo issues ou criando pull requests. Seu feedback é apreciado!

