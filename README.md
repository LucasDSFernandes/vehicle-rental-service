# Vechile-rental-service

## Vehicle Rental Api

##  Api para sistema de aluguel de carros com Java e Spring boot


Documentação registrada no swagger no endereço: http://localhost:8081/swagger-ui.html
Para executar este serviço, basta executar como uma aplicação spring boot, o projeto roda por padrão na porta 8081. 



## Api's  de uso do adiministrador do sistema:



	- (GET) http://localhost:8081/admin/vehicles - Api responsavel por Listar Todos os carros.
	- (POST) http://localhost:8081/admin/vehicle - Api responsavel por Registrar um carro
	- (DELETE) http://localhost:8081/admin/vehicle/{id} - Api responsavel por deletar um carro



### Api's para uso do cliente.



	- (POST) http://localhost:8081/rental/register - Api responsavel por registrar o Aluguel do carro.
	- (POST) http://localhost:8081/rental/search - Api responsavel por listar todos os carros para aluguel.



##  Api's responsaveis para buscar informações para cadastro dos veiculos.



	- (GET) http://localhost:8081/utils/categories - Api responsavel por Listar as categorias para o cadastro de veiculos.
	- (GET) http://localhost:8081/utils/manufacturers - Api responsavel por listar todas as marca da FIPE.
	- (GET) http://localhost:8081/utils/manufacturers/{manufacturerId}/models -Api responsavel por listar todas os modelos da FIPE.
	- (GET) http://localhost:8081/utils//manufacturers/{manufacturerId}/models/{modelId}/years_fuels - Api responsavel por Listar os anos e conbustivelda FIPE.


 
##Para a execução do front desta aplicação é necessário executar os seguintes passos:



	- Baixar o projeto vehicle-rental-web
	- Baixar o node.js; 
	- Baixar o angular através do npm install -g @angular/cli (o -g é para dizer que é global); 
	- Baixar o projeto do bitbucket;
	- Baixar as dependências através do npm install, estando dentro da pasta do projeto do front; 
	- Para rodar basta digitar o ng serve --open (o --open é para abrir o browser) dentro da pasta do projeto front;
	- E para fazer o build é ng build.
	
## Para execução das classes de teste Utilizar como parametro

```sh
 $ -Dspring.profiles.active=test (A conf aponta para o arquivo application-test.properties)
```