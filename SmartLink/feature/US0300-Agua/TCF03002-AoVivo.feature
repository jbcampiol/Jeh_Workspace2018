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
@Agua
Feature: Ao Vivo
  As um usuario 
  I want poder visualizar o consumo ao vivo dos meus dispositivos que esta conectados
  Because eu tenha uma maneira de visualizar os fluxo de agua que esta passando no contexto que eu selecionei
  
  Keywords Summary: Pré-Condição
		Deve-se ter um dispositivo configurado e lendo água para poder ser feito o teste do gráfico

	Keywords Summary: Critérios de Aceite
    Se nenhum dispositivo for selecionado, o consumo lido deve ser o total, para todos os dispositivos instalados
    Quero ter uma visualizacao do consumo total do periodo em Litros com a precisao de apenas uma casa decimal
    Quero ter um contador do tempo de leitura em segundos
    Quero ter uma visualizacao do volume de agua lido pelo tempo em Litros / minuto com a precisa de uma casa decimal
    Toda a vez que a leitura ao vivo for acionada, deve-se zerar o contador e o volume lidos
  
  @AoVivo
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
