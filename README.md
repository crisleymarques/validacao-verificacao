<h1 align="center"> 
	Validação & Verificação de Software 🖥✅
</h1> 


<p align="center"> 
	Atividades desenvolvidas durante a disciplina de Validação e Verificação de Software no período 2023.2 na UFCG
</p>

<div align="center">
	
[![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/)
[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/pt-BR/)
[![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)](https://maven.apache.org/)
[![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)](https://swagger.io/)
[![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)](https://git-scm.com/)
[![Junit]( https://img.shields.io/badge/Junit-25A162?style=for-the-badge&logo=junit5&logoColor=white)](https://junit.org/junit5/)
 
</div>

<p align="center">
  <a href="#sobre-a-disciplina-">Sobre</a> •
  <a href="#especificações-">Especificações</a> •
  <a href="#exercícios-">Exercícios</a> •
  <a href="#licença-">Licença</a> •
  <a href="#autores-">Autores</a>
</p>

## Sobre a disciplina 📌
<p align="justify">
Tem como objetivo principal apresentar e discutir técnicas e ferramentas para a validação e verificação de software. A disciplina aborda desde técnicas de teste de software, passando por técnicas de verificação formal, até a análise estática de código. 

##### Verificação
> Checar se o software atende seus requisitos funcionais e não funcionais
- Estamos construindo <b>certo o produto</b>?

##### Validação
> Garantir que o software atende as expectativas do cliente
- Estamos construindo <b>o produto certo</b>?

</p>

## Especificações 📋
### Processador de Boletos 🧾💸

O objetivo desse processador é verificar todos os boletos e, caso o valor da soma de todos os boletos seja maior que o valor da fatura, então essa fatura deverá ser considerada como paga.

- [x]  Uma fatura contém data, valor total e nome do cliente.
- [x]  Um boleto contém o código do boleto, data, e valor pago.
- [x]  Um pagamento contém o valor pago, a data, e o tipo do pagamento efetuado ("BOLETO")
- [x]  O processador de boletos, ao receber uma lista de boletos, deve então, para cada boleto, criar um "pagamento" associado a essa fatura.
- [x]  Esse pagamento contém o valor pago, a data, e o tipo do pagamento efetuado (que nesse caso é "BOLETO").
- [x]  Como dito anteriormente, caso a soma de todos os boletos seja igual ou ultrapasse o valor da fatura, a mesma deve ser marcada como "PAGA".📑
> Exemplo: Fatura de 1.500,00 com 3 boletos no valor de 500,00, 400,00 e 600,00: fatura marcada como PAGA, e três pagamentos do tipo BOLETO criados

### Gerenciador de Tarefas 📅📝
Deve-se implementar um sistema para auxiliar os usuários no acompanhamento e organização de suas tarefas diárias. O sistema permitirá que os usuários criem, atualizem e excluam tarefas, definindo detalhes como título, descrição, data de vencimento e prioridade.

- [x]  O sistema deve permitir que os usuários criem novas tarefas, inserindo informações como título, descrição, data de vencimento e prioridade.

- [x]  Os usuários devem poder atualizar os detalhes de uma tarefa existente, incluindo a possibilidade de modificar o título, a descrição, a data de vencimento e a prioridade.

- [x]  Os usuários devem ser capazes de excluir tarefas da lista, caso a tarefa não seja mais relevante.

- [x]  O sistema deve exibir uma lista de todas as tarefas do usuário, ordenadas por data de vencimento e prioridade.

- [x]  Os usuários devem poder marcar tarefas como prioridades altas, médias ou baixas.


## Exercícios 
#### 2 - Test Driven Development (TDD) 🧪
- [Especificação](https://docs.google.com/document/d/14d-A6nhw6KBR0zRqH85oNRkDGlSUOKQ73_YKYMgvjRQ/edit?usp=sharing) do exercício.

---

## Autores
| [<img src="https://avatars.githubusercontent.com/u/44072771?s=400&u=b17d945fa43dec67a69d1cb11e2f23a7b2e0ad95&v=4" width="120px;"/><br /><sub><b>Crisley Marques</b></sub>](https://github.com/crisleymarques) <br/> | [<img src="https://avatars.githubusercontent.com/u/64588244?v=4" width="120px;" /><br /><sub><b>Igor Correia</b></sub>](https://github.com/igor-correia) <br/> | 
| :---: | :---: | 
