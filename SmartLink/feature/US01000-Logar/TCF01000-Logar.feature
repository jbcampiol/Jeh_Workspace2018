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
Feature: Logar no Sistema SmartLink da Deca
  As um usuario que adquiriu o produto IoT Deca SmartLink
  I want Logar no sistema
  Because eu preciso verificar as configurações do SmartLink para pode usar

  @Logar
  Scenario Outline: Logar no Sistema SmartLink da Deca
    Given usuario do Sistema SmartLink Deca, PJ ou PF
    When informar um <Usuario> valido e uma <Senha> valida
    And acionar o Botao de ENTRAR
    Then o sistema deve permitir a autenticao do usuario no sistema SmartLink Deca

    Examples: 
      | Usuario                            | Senha          |
      | "decaiotqa@gmail.com"              | "asdqweasdqwe" |
      | "jefferson.campiol@fcamara.com.br" | "123@321"      |
      | "automacao@deca.com.br"            | "123456"       |
      