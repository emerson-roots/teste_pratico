# Teste prático para PROCESSO SELETIVO (gravando o desenvovlvimento, a tela do computador e publicar no YouTube [Confira aqui](https://www.youtube.com/watch?v=wE7Sf1wbbSI/ "https://www.youtube.com/watch?v=wE7Sf1wbbSI")).
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/emerson-roots/teste_pratico/blob/master/LICENSE) 

## Este repositório contém o desenvolvimento de uma aplicação web (no formato API Rest) para participar de um processo seletivo.

### Os requisitos de projeto para seleção foram;

- vídeo de 1 hora de duração sem cortes (gravação de tela do computador - Assista o video YouTube [AQUI](https://www.youtube.com/watch?v=wE7Sf1wbbSI/ "https://www.youtube.com/watch?v=wE7Sf1wbbSI"))
- explicar passo a passo o que está fazendo durante o desenvolvimento utilizando microfone
- entregar pelo menos uma versão parcial porém funcional
- aplicação web
- banco de dados estruturado
- livre escolha da tecnologia a ser utilizada
- crud Conteiner
- o atributo Codigo do Conteiner deve respeitar o padrão 4 letras 7 números. (EX.: TEST1234567)
- crud Movimentações de Conteiner
- validações gerais
- gerar relatório
- gerar sumário
- versionar o código-fonte no Github


### A tecnologia utilizada;
- Java 11
- Spring Framework (versão 2.5.4)
- Banco de dados H2
- JPA/Hibernate
- Maven

# Como executar o projeto LOCALMENTE

## Pré-requisitos: 
- Java 11
- Maven
- Postman para testar as requisições
- Importar o arquivo "Teste_Pratico_Processo_Seletivo.postman_collection.json" que está dentro do projeto para o Postman. Neste arquivo contém todas as requisições elaboradas para efetuar os testes. Se preferir, fique a vontade para montar suas próprias requisições e testes.


```bash
# na linha de comando, clonar repositório
git clone https://github.com/emerson-roots/teste_pratico

# entrar na pasta do projeto back end

# fazer build no projeto pelo Maven (caso houver testes ativos, comente a anotação @Test ou ignore os testes);
mvn package -e

# entrar na pasta /target e executar a aplicação;
java -jar teste_pratico-0.0.1-SNAPSHOT.jar

# teste a aplicação no postman a partir da URL base;
http://localhost:8080/

# os endpoints padrão são;
http://localhost:8080/conteiners
http://localhost:8080/movimentacao_conteiners

# pausar/stopar aplicação
CTRL+C na linha de comando
```


# Autor

*Emerson Melo de Lima*

emerson_sardinha@hotmail.com
