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
@LogarExchange
Feature: Logar na Exchange da Zater Capital
  As um usuario da Zatar Capital
  I want Logar na Exchange
  Because eu preciso acessar minha conta e verificar meus bitcoins

@Logar
  Scenario Outline: Logar na Exchange da Zater Capital
    Given usuario do da Zater Capital
    When informar um <Usuario> valido e uma <Senha> valida
    And acionar o Botao de LOGAR
    Then o sistema deve permitir a autenticao do usuario na exchange com sucesso

    Examples: 
      | Usuario                           | Senha        |
      | "vinicius@netlolo.com"            | "123456"     |
      | "jefferson.campiol@netlolo.com"   | "123@321"    |
      | "paulo.luedy@netlolo.com"         | "adasdd"     |
      | "daniel.silvamiranda02@gmail.com" | "Dga384315@" |
