# Agenda  


Exemplos Métodos POST 

- Cliente
```sh
{
        "nome": "Pablo",
        "cpf": "449.586.152-98"
}
```

- Serviço 
```sh
         "codigo": 48,
        "descricao": "Configuração de software",
        "valor": 1200.00
```


- Agendamento 
```sh
{
        "datahora": "08/12/2021 12:46",
        "observacao": "Atualizar para windowns 11",
        "servico": {
            "id": 2,
        },
        "cliente": {
            "id": 1,
    }
}
```
- Metodo GET especifico para agendamentos 

 Exemplo
```sh
http://localhost:8080/agendamento/cliente?linesPerPage?page=?&orderBY=valor&direction=DESC
```

Parametros: 
- page:  defaul="24"
- linesPerPage:  default="24"
- orderBy:  default="cliente"
- direction:  default="ASC"

Exemplo de response 

```sh
        {
            "id": 5,
            "cliente": "Beatriz",
            "datahora": "08/12/2021 12:46",
            "valor": 1200.00
        }
```

## Docker 
```sh
dockerhub 
docker pull pdevtest/agenda

build
docker build -t agenda.app .

docker run 
docker run -p 8080:8080 agenda.app
```
