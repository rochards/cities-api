# Digital Innovation: Expert class - Desenvolvimento de uma API REST para o cálculo de distância entre cidades.

Desenvolvimento de uma API REST para calcular a distância entre duas cidades utilizando coordenadas geográficas (latitude, longitude). As informações foram persistidas no banco PostgreSQL rodando em um container docker.

Principais tópicos abordados:
- Busca de recursos paginadas;
- Docker e containers;
- Mapeamento de dados do tipo JSON do banco de dados para o Java.

O que foi utilizado para o desenvolvimento deste projeto:
- Java 11;
- Gradle 6.8.1;
- [Intellij IDEA](https://www.jetbrains.com/pt-br/idea/);
- Git e GitHub;
- [Docker](https://www.docker.com/get-started);
- [PostgreSQL](https://www.postgresql.org/);
- [Postman](https://www.postman.com/)

## Preparando o ambiente para executar o projeto

Instalação das ferramentas:
- Instalação do Docker no Ubuntu: [1](https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-20-04-pt)
- Instalação do Gradle: [2](https://gradle.org/install/)

Comandos:
- Container do PostgreSQL: \
`$ docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres`. O comando cria um container da imagem do *postgres* e o chama de *cities-db*. O banco de dados criado dentro desse container é o *cities*. Além disso são expostas as variáveis de ambiente POSTGRES_USER, POSTGRES_PASSWORD e POSTGRES_DB;
- Baixar os dados para popular o banco de dados: [dados](https://github.com/chinnonsantos/sql-paises-estados-cidades/tree/master/PostgreSQL);
- Acesse onde você baixou os dados acima;
- Para inserir esse dados no container, devemos utilizar o comando `psql` para interagir com o postgres. Você não precisa ter o postgres instalado em sua máquina, basta rodar outro container e em seguida executar os comandos de inserção de dados e configurações adicionais:
```
$ docker run -it --rm --net=host -v $PWD:/tmp postgres /bin/bash

$ psql -h localhost -U postgres_user_city cities -f /tmp/pais.sql
$ psql -h localhost -U postgres_user_city cities -f /tmp/estado.sql
$ psql -h localhost -U postgres_user_city cities -f /tmp/cidade.sql

$ psql -h localhost -U postgres_user_city cities

$ CREATE EXTENSION cube; 
$ CREATE EXTENSION earthdistance;
```
- Para executar o projeto no terminal, utilize o comando: `$ gradle bootRun`;
- Exemplos de consultas no Postman:  
```
Retorna 10 países na página 0, ordenado pelo nome de forma ascendente -> localhost:8080/countries?page=0&size=10&sort=name,asc
Retorna o país com id 10 -> localhost:8080/countries/10
Retorna todos os estados -> localhost:8080/states
Retorna 20 cidades na página 0 -> localhost:8080/cities?page=0&size=20
Calcula a distância em milhas das cidades com ids 4929 e 5254 -> localhost:8080/distances/by-cube?from=4929&to=5254
Calcula a distância em metros das cidades com ids 4929 e 5254 -> localhost:8080/distances/by-points?from=4929&to=5254
```

Repositório original do projeto: [cities-api](https://github.com/andrelugomes/digital-innovation-one/tree/master/cities-api)
