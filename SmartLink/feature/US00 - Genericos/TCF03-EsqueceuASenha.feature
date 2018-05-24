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
Feature: Como usuario Pessoa juridica com cadastro
         é preciso logar na exchange.staging.zatercapital,
         e modificar o e-mail ,clicando em esqueceu a senha
         ,entrar com email no input e clicar no botao confirma

  Scenario Outline: Esqueceu a senha na exchange.staging.zatercapital
    Given Um email valido para recuperar senha 
    When informar um <email> valido
    And acionar o Botao de Confirma
    Then o sistema deve acionar uma modal com a messagem de sucesso

    Examples: 
      | Email                     |
      | "paulo.luedy@netlolo.com" |
      
