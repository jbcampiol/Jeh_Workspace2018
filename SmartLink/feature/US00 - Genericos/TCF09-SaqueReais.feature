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
Feature: Saque em Dinheiro

  Scenario Outline: Saque em Dinheiro
    Given Um saque para o banco desejado
    When entrar com nova conta <NomedoBanco> <NumeroAgencia> <ContaCorrente> <Codigobanco> e botao Cadastrar
    Then irá para a tela de Saque  <Bancos> <ValordeRetirada> com as taxas <TaxadoTed> <TaxadaOperação> e Valor Líquido<ValorLíquido> Confirma

    Examples: 
      | NomedoBanco | NumeroAgencia | ContaCorrente | Codigobanco | Bancos     | ValordeRetirada | TaxadoTed | TaxadaOperação | ValorLíquido |
      | "Original"  | "13"          | "416515"      | "74"        | "Original" | ""              | "9"       | "0,002"        | ""           |
