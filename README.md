# Implementação de Análise de Vendas: 2 em Java utilizando Programação Funcional e Expressões Lambda

 Está implementação em Java para realiza uma análise de vendas utilizando programação funcional e expressões lambda. O objetivo é ler um arquivo .csv contendo registros de vendas, realizar algumas análises específicas e apresentar os resultados. Este projeto é desenvolvido de acordo com os critérios e requisitos definidos.

## Requisitos do Projeto

- Ler um arquivo .csv contendo registros de venda.
- Instanciar uma lista de objetos do tipo Sale com base nos dados lidos.
- Aplicar programação funcional e expressões lambda para realizar as análises.
- Mostrar as seguintes análises:
  1. O programa deve varrer toda a lista para encontrar os nomes dos vendedores.
  2. O programa deverá mostrar o total vendido por cada vendedor
  3. Caso ocorra alguma falha na leitura do arquivo, a exceção deve ser tratada, e mostrada uma
mensagem
## Diagrama de classes
```mermaid
classDiagram
    class Sale {
        -Integer month
        -Integer year
        -String seller
        -Integer items
        -Double total
        +Double averagePrice()
    }

    class Program {
        +main(String[] args)
    }
    Sale -- Program : user
