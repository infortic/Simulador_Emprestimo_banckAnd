# Simulador de Financiamento

Solução para contratação de empréstimos. Permitindo a simulação antes de efetivar a contratação.

### Informações Adicionais
- As simulações de empréstimo possuem um período de validade de 30 dias. 
- Após este período não será possível efetivar a contratação. 
- Somente realizar simulações para cpf e email válido!

### Dados de entrada
- NOME
- CPF
- EMAIL
- VALOR_CONTRATO
- QUANTIDADE_PARCELAS.


# Regras de Negócio:

### Taxa de Juros  
- Sendo valor contrato menor ou igual a R$1.000,00 atribuir 1,8% como percentual de taxa de juros
- se não: atribuir 3%.
- Sendo a quantidade de parcelas maior que 12 parcelas, adicionar 0,5% a taxa de juros.

### Valor da Parcela
- Calcular o valor da parcela conforme: Taxa de juros (R3)
- valorContato*(1+(quantideParcelas*taxajuros))/quantidadeParcelas

### Quantidade Máxima de Parcelas

- Quantidade máxima de parcelas: 24

### Retorno da API:

- Informações do cliente;
- Data da Simulacao;
- Data Validade Simulação;
- Valor Contrato;
- Quantida de Parcelas;
- Valor Parcela;
- Taxa Juros Emprestimo.

## Executando e testando o projeto

### Pré-requisitos
* Java 8
* Mave
* Banco de Dados PostGres V8+


### Passo a passo

`Ultilize esta linha de código para baixar a branch da aplicação`

`git clone https://github.com/infortic/Simulador_Emprestimo_banckAnd.git`

### 1 - Baixando e instalando o PostGres

`1.a - Você pode baixar uma versão do postgres no seguinte link:`
https://www.postgresql.org/download/

importante durante a instalação selecione o drive JDBC, pois o mesmo é necessário para o java reconhecer o banco de dados.

Apos o download o processo de instalação é bastante simples e intuitivo, mas em caso de duvidas este material poderá ser consultado: 

`no Windows: `https://www.postgresqltutorial.com/install-postgresql/
`no Linux: `https://www.digitalocean.com/community/tutorials/como-instalar-e-utilizar-o-postgresql-no-ubuntu-16-04-pt 

`1.b - Criando o banco de dados`

Acesso o PGADMIN (aplicação instalada junto com o banco) e execute o seguinte query:

```
CREATE DATABASE banco
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
```
`1.c - Configurando o banco na aplicação`

acesse o arquivo "application.yml" no seguinte caminho:
`\src\main\resources\application.properties`

No exemplo a baixo vemos a configuração original da aplicação com o banco de dados "banco", user "postgres" e senha "root"
```
spring.datasource.url=jdbc:postgresql://localhost:5432/banco
spring.datasource.username=postgres
spring.datasource.password=root
```
caso necessário esta configuração pode ser alterada!


#### 2 - Buildar e executar a aplicação

Dentro do diretório root da aplicação executar os passos abaixo.

2.a - Para buildar a aplicação:
` mvn clean install #buildando o pacote da aplicação`

a linha de código a cima criara uma pasta chamada `target` com a versão final da aplicação.

2.b Para executar a aplicação:

` java -jar SimuladorFinanciamento-0.0.1.jar`

A partir deste ponto se tudo ocorrer corretamente a aplicação estará rodando 
e atendendo requisições através da porta cadastrada no arquivo `application.yml` (se não foi alterado estará na porta 5001).

É possível utilizar o client do swagger através da url [http://localhost:5001/swagger-ui.html], possibilitando a verificação dos endpoints, dos DTOs esperados, e até mesmo realizar testes de requisições. 

#### 4 - Executando Testes Automatizados
` mvn test #Dentro do pacote da aplicação para executar os testes automatizados`
