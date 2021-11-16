Para rodar a API, deve-se ter uma IDE, como IntelliJ IDEA ou SpringTool Suite 4;

Após isso, abrir o projeto em uma IDE, procurar pela classe main do projeto (src/main/java/ProjurisApplication) e rodar a aplicação (IntelliJ - Clicar com botao direito e escolher a opção 'Run')

Após isso, utilizar o Postman para inserir um cliente
- fazer uma requisição POST, no endpoint da inserção do cliente, com a seguinte URL: localhost:8080/cliente/insert com os dados do cliente.
- na aba Body, utilizar o tipo de dado raw e selecionar JSON
exemplo: 

{
 "nome": "João da Silva",
 "telefone": "83988888888",
 "email": "joao@bol.com.br"
}


Isso irá retornar o ID do cliente inserido, esse ID será utilizado para inserir o endereço, equipamento e ordem de serviço do cliente.

- O banco utilizado foi o h2. Assim, no browser inserir a URL: http://localhost:8080/h2-console e se logar. Para ter certeza que os dados estão sendo salvos, consultar em cada tabela existente os dados inseridos. 
Clique na tabela desejada e depois no botão 'Run' ou após cada inserção, realizar uma requisição GET e adicionar o id de cada inserção desejada.

Exemplo: 

-Para inserção do endereço do cliente, utilizar o Postman e inserir uma requisição POST com a URL: localhost:8080/endereco/insert com os dados do endereço do cliente:

exemplo: 

{
    "municipio": "João Pessoa",
    "bairro": "Manaíra",
    "logradouro": "Rua Pedro Pessoa",
    "numero": "123",
    "complemento": "perto da Drogasil",
    "clienteId": 1 
}

- Após isso, inserir o equipamento do cliente, junto com o id desse mesmo cliente, 
fazer uma requisição POST, utilizando a URL: localhost:8080/equipamento/insert

exemplo: 

{
    "tipo": "Laptop",
    "marca": "Dell",
    "problema": "Aquecimento",
    "clienteId": 1
}

- Inserir o funcionário que será responsável pelo serviço. Utilizando uma requisição POST e a URL: localhost:8080/funcionario/insert

exemplo: 

{
    "nome": "Lucas",
    "matricula": "12345"
}


- Registrar a ordem de serviço, URL: localhost:8080/ordem-servico/insert
exemplo:

{
    "isPendente": false,
    "clienteId": 1,
    "funcionarioId": 1,
    "equipamentoId": 1 
}


- Consultar ordens de servico pendentes pelo funcionário:
como o id do funcionário inserido é 1, faz-se a requisição GET com a URL: localhost:8080/ordem-servico/funcionario/1


- Registro para iniciar serviço 
	com o id da ordem em mãos, nesse caso sendo igual a 1, faz-se a requisição PATCH com a URL: localhost:8080/ordem-servico/inicio/1

- Registro finalizar serviço:
	com o id da ordem em mãos, nesse caso sendo igual a 1, a URL fica: localhost:8080/ordem-servico/fim/1	

- Se houver necessidade de inserir um acompanhamento de ordem de serviço, antes de finalizar o registro, inserir o acompanhamento com o id da ordem de serviço em mãos. 
Assim, realizar uma requisição POST e a URL ficará: localhost:8080/acompanhamento-ordem-servico/insert 
e o corpo da requisição (em JSON) ficará:

exemplo: 

{
    "mensagem": "o serviço precisou ser interrompido por conta de uma peça que levará uma semana para ser entregue",
    "ordemServicoId" : 1
}

- Para consultar, realizar uma requisição GET com a URL com o id desejado: 
exemplo: localhost:8080/acompanhamento-ordem-servico/1 





