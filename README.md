# healthStatus

![Java 8 Maven Tests](https://github.com/idelberto/healthStatus/workflows/Java%208%20Maven%20Tests/badge.svg)
![Test Covarage](https://raw.githubusercontent.com/idelberto/healthStatus/be83e89a15449b21433b7d3fb5739de5512bb4e5/jacoco.svg)

### Para provisionar um postgres via docker

docker run --name postgres-health-status -p 5432:5432 -e POSTGRES_PASSWORD=root -d postgres

## Para realizar o diff das entidades jpa e o banco
`mvn liquibase:diff`
  
Sempre q gerar um diff aplicar o change-log gerado banco, seja iniciando a aplicação ou rodando o comando
  
`mvn liquibase:update`
  
Se vc gerar o diff 2 vezes sem aplicar o change-log gerado banco ele vai gerar arquivos repetidos que vão dar erro na migração depois

### Lombok
Para aplicar o Lombok no STS veja o tutorial:
  
[Windows](https://www.youtube.com/watch?v=5j2hr8l9F7Y)
  
[Linux](https://www.youtube.com/watch?v=3ouoZ3LjSKM)

### Para visualizar a cobertura de testes da aplicação
Execute o comando
  
`mvn verify`
  
para rodar os testes unitarios e de integração, depois navegue até a pasta /target/site/jacoco-merged-test-coverage-report e acesse o arquivo index.html. Irá aparecer no seu browser o relatório de cobertura de testes gerados pelo Jacoco
![Jacoco](https://i.ibb.co/x8dzw9z/jacoco.png)
