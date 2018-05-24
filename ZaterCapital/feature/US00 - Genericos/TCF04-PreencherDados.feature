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
Feature: Dados Cadastrais
  Eu quero usar essas informações para reconhecer se o usuario
  é autentico e como esta seu nome no mercado

  Scenario Outline: Dados Cadastrais
    Given um usuario validado preencher PDF PNG e JPEG
    And preencher os dados pessoais
    When selecionar o botao <NomeSocio><E-mailSocio><RazaoSocial><NomeFantasia><CNPJ><Endereco><Estado><Cidade><CEP><Nome><Email><Telefone>
    And clicar no botao salvar
    Then verificar <nivel> se mudou

    Examples: 
      | NomeSocio | E-mailSocio               | RazaoSocial                    | NomeFantasia  | CNPJ                 | Endereco             | Estado | Cidade   | CEP       | nivel   | Nome            | Email           | Telefone         |
      | "Paulo"   | "paulo.luedy@netlolo.com" | "paulo alberto luedy radiante" | "paulo luedy" | "29.157.479/0001-56" | "Saturnino de brito" | "SP"   | "Santos" | "1107000" | "Prata" | "paulo alberto" | "paulo alberto" | "(13) 3464-3026" |
