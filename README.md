# Sobre o projeto:
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/emerson-roots/teste_pratico/blob/master/LICENSE) 

![NPM](https://img.shields.io/badge/Angular-DD0031?style=flat&logo=angular&logoColor=white)
![NPM](https://img.shields.io/badge/TypeScript-007ACC?style=flat&logo=typescript&logoColor=white) 
![NPM](https://img.shields.io/badge/Bootstrap-563D7C?style=flat&logo=bootstrap&logoColor=white) 
![NPM](https://img.shields.io/badge/HTML5-E34F26?style=flat&logo=html5&logoColor=white) 
![NPM](https://img.shields.io/badge/CSS3-1572B6?style=flat&logo=css3&logoColor=white) 
![NPM](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=java&logoColor=white) 
![NPM](https://img.shields.io/badge/Spring-6DB33F?style=flat&logo=spring&logoColor=white)


Link YouTube para video demonstração do projeto **FINALIZADO**; 
- https://youtu.be/DRtIStmbnJE

Link YouTube demonstrando parte do processo de desenvolvimento BACKEND (Requisito: 1 hora de video); 
- https://youtu.be/wE7Sf1wbbSI


## Teste prático desenvolvendo um CRUD para participar de processo seletivo.
### Os requisitos são;


Crud de Contêiner
- Cliente
- Número do contêiner (4 letras e 7 números. Ex: TEST1234567)
- Tipo: 20 / 40
- Status: Cheio / Vazio
- Categoria: Importação / Exportação

Crud de Movimentações
- Tipo de Movimentação (Embarque, Descarga, Gate In, Gate out, Posicionamento
Pilha, Pesagem, Scanner)
- Data e Hora do Início
- Data e Hora do Fim

Gerar um relatório com o total de movimentações agrupadas por cliente e tipo de
movimentação.

No final do relatório deverá conter um sumário com o total de importação / exportação.

# 🛠 Skills utilizadas
	
### FRONTEND 

- (Link do repositório: https://github.com/emerson-roots/teste_pratico_frontend)
-	Angular 12
-	Node.js
-	HTML/CSS
-	Bootstrap 4

### BACKEND
-	Java 11
-	Padrão API Rest
-	Spring Boot
-	JPA/Hibernate
-	Maven
-	Banco de dados H2 (banco em memória)

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


# 🚀 Autor

*Emerson Melo de Lima*

emerson_sardinha@hotmail.com
