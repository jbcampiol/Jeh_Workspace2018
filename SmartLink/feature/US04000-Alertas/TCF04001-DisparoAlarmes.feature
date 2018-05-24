#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Alertas
Feature: Disparo de Alarmes
  As um usuario 
  I want que meus alarmes de media de consumo disparem automaticamente caso eu tenha excedido o consumo do alarme que eu criei
  Because De maneira que eu seja notificado caso tenha chegado ao valor percentual que foi estabelecido no alarme

	Keywords Summary: Pre - Condicoes
		Ter criado um alarme com um valor % que esteja cadastrado em um email e ou aceite notificacoes push
    Ter uma media de consumo do usuario como referencia
    Ter um dispositivo lendo agua constantemente
    O alarme criado deve possuir um nome
    O alarme criado deve estar dentro de um contexto de leitura (Local/ambiente ou dispositivo)
    O alarme criado deve possuir um valor percentual (1 a 150%) referente a media de consumo do usuario
	
	Keywords Summary: Criterios de Aceitacao
		Assim que ocorrer o disparo do alarme, deve-se receber um email notificando o usuario quando o valor % foi atingido em um determinado contexto. O mesmo ocorre na notificacao push para o usuario.

	Keywords Summary: DODS
		Deve-se realizar o teste com pelo menos dois alarmes configurados em emails diferentes
    Verificar a funcionalidade no IOS, que nao permite push notifications, apenas email



  @tag1
  Scenario: Title of your scenario
    Given I want to write a step with precondition
    And some other precondition
    When I complete action
    And some other action
    And yet another action
    Then I validate the outcomes
    And check more outcomes

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
      
      

      
