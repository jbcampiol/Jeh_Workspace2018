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

Feature: Deposito em dinheiro 
  Logar na exchange navegar para deposito em dinheiro  

 Scenario Outline: Deposito em dinheiro
     
    Given deposito para ZaterExchange em Depositos
    And assionando o botao Deposito 
    When  selecionar o <Banco> e  colocar o <valor> de deposito
    And Precionar o botao Confirma 
    Then verificar  <dinheiro> se somou

    Examples: 
      | Banco      | Valor |Dinheiro|
      |"Santander" |"5000" |""      |
   