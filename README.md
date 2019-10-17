Projeto FicticiusClean

O projeto foi desenvolvido e testadoo utilizando o servidor TomCat v7.0.
O primeiro passo é adicionar os servlets:

 	<servlet-mapping>
 		<servlet-name>getLista</servlet-name>
 			<url-pattern>/getLista</url-pattern>
 	</servlet-mapping>
    <servlet-mapping>
 	    <servlet-name>cadastroVeiculo</servlet-name>
 			<url-pattern>/cadastroVeiculo</url-pattern>
 	</servlet-mapping>

Ao levantat o serviço o padrão é ser utilizado a porta 8080.
EXEMPLO:

http://localhost:8080/



Inicialmente existem duas APIs no projetos sendo eles:

Para cadastro de veiculos, onde deve receber alguns parametros para o novo cadastro.
EXEMPLO:
METODO: POST
URL:
    http://localhost:8080/cadastroVeiculo
PARAMETROS:

  "consumoCidade": "1000.1",
  "consumoEstrada": "100",
  "nome": "CarroExemplo",
  "marca": "MarcaExemplo",
  "modelo": "ModeloExemplo",
  "dataFabricacao": "01/01/2000"
  
  Caso o cadastro seja efetuado com sucesso o retorno será status 200 com a mensagem "Veiculo Cadastrado com Sucesso".
  
  
  
  
  Para consulta da lista de veiculos, o retorno esta ordenado por custo, do menos para o maior.
EXEMPLO:
METODO: GET
URL:
    http://localhost:8080/getLista?preco=2.00&kmCidade=200&kmEstrada=100
PARAMETROS:

  "preco": "2.00",
  "kmCidade": "200",
  "kmEstrada": "100".
  
  o retorno com o codigo 200 e o resultado esperado é um Json.
  EXEMPLO:
  
  [
  {
    "custo": 4.8,
    "combustivel": 2,
    "nome": "teste1",
    "marca": "marca",
    "modelo": "modelo",
    "dataFabricacao": 2000
  },
  {
    "custo": 17.14,
    "combustivel": 7.14,
    "nome": "teste2",
    "marca": "marca",
    "modelo": "modelo",
    "dataFabricacao": 2000
  },
  {
    "custo": 25.26,
    "combustivel": 10.53,
    "nome": "teste3",
    "marca": "marca",
    "modelo": "modelo",
    "dataFabricacao": 2000
  },
  {
    "custo": 34.29,
    "combustivel": 14.29,
    "nome": "teste4",
    "marca": "marca",
    "modelo": "modelo",
    "dataFabricacao": 2000
  },
  {
    "custo": 34.29,
    "combustivel": 14.29,
    "nome": "teste5",
    "marca": "marca",
    "modelo": "modelo",
    "dataFabricacao": 2000
  },
  {
    "custo": 480,
    "combustivel": 200,
    "nome": "teste6",
    "marca": "marca",
    "modelo": "modelo",
    "dataFabricacao": 2000
  }
]
  
  
  
  
  
  Quaisquer duvidas estou a disposição.
  

  
  
  

