# healthStatus

### Para provisionar um postgres via docker

docker run --name postgres-liquibase -p 5432:5432 -e POSTGRES_PASSWORD=root -d postgres

### Para realizar o diff das entidades jpa e o banco
mvn liquibase:diff
Sempre q gerar um diff novo fazer a aplicação dele no banco, seja iniciando a aplicação ou rodando o comando mvn liquibase:update isso pq se vc gerar o diff 2 vezes sem aplicar no banco ele vai gerar arquivos repetidos que vão dar erro na migração depois

### Para visualizar a cobertura de testes da aplicação
Execute o comando mvn verify para rodar os testes unitarios e de integração, depois navegue até a pasta /target/site/jacoco-merged-test-coverage-report e acesse o arquivo index.html. Irá aparecer no seu browser o relatório de cobertura de testes gerados pelo Jacoco
![Jacoco](https://lh4.googleusercontent.com/pEOUkTeRb8aMf1sAEL8_pV9gIMxrr94T-ICk-9LtjPoKjfcsVgu64mYRd6QPTOYvu6FqpogihNqcTA=w1366-h634-rw)
