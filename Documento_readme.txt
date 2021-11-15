Para rodar a API, deve-se ter uma IDE, como IntelliJ IDEA ou SpringTool Suite 4;

Após isso, abrir o projeto em uma IDE, procurar pela classe main do projeto (src/main/java/ProjurisApplication) e rodar a aplicação (IntelliJ - Clicar com botao direito e escolher a opção 'Run')

Após isso, utilizar o Postman para inserir um cliente
- fazer uma requisição POST, no endpoint da inserção do cliente, com a seguinte URL: localhost:8080/cliente/insert com os dados do cliente.
- na aba body, utilizar o tipo de dado raw e selecionar JSON
exemplo: 
{
 "nome": "João da Silva",
 "telefone": "83988888888",
 "email": "joao@bol.com.br"
}

Irá retornar o ID do cliente inserido, esse ID será utilizado para inserir o endereço, equipamento e ordem de serviço do cliente.

- O banco utilizado foi o h2. Assim, no browser inserir a URL: http://localhost:8080/h2-console e se logar. Para ter certeza que os dados estão sendo salvos, consultar em cada tabela existente os dados inseridos. Clique na tabela desejada e depois no botão 'Run'

-Utilizar o Postman, com a URL: localhost:8080/endereco/insert com os dados do endereço do cliente:
exemplo: 

{
    "municipio": "João Pessoa",
    "bairro": "Manaíra",
    "logradouro": "Rua Pedro Pessoa",
    "numero": "123",
    "complemento": "perto da Drogasil",
    "cliente": {
        "id": 1,
        "nome": "João da Silva",
        "telefone": "83988888888",
        "email": "joao@bol.com.br"
    }
}

- Após isso, inserir o equipamento do cliente, junto com o id desse mesmo cliente, URL: localhost:8080/equipamento/insert
exemplo: 
{
    "tipo": "Laptop",
    "marca": "Dell",
    "problema": "Aquecimento",
    "cliente": {
        "id": 1,
        "nome": "João da Silva",
        "telefone": "83988888888",
        "email": "joao@bol.com.br"
    }
}

Inserir o funcionário que será responsável pelo serviço: URL: localhost:8080/funcionario/insert

Inserir a ordem de serviço, URL: localhost:8080/ordem-servico/insert
exemplo:

{
    "isPendente": false,
    "detalhes": "",
    "clienteId": 1,
    "equipamentoId": 1
}





