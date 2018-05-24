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
@CadastrarUsuario
Feature: Cadastrar usuario no Sistema SmartLink da Deca
  As um usuario Pessoa Juridica
  I want me cadastrar no site do Sistema SmartLink da Deca
  Because eu quero acessar as funcionalidade para ter controle sobre o meu SmartLink

  @CadastrarPessoaJuridica
  Scenario Outline: Cadastrar usuario no Sistema SmartLink da Deca - Pessoa Juridica
    Given um usuario do tipo Pessoa Juridica na Tela de Cadastro do Sistema SmartLink
    And marcar o RadioButton PESSOAJURIDICA
    When informar os dados <RazaoSocial>, <CNPJ>, <Segmento>, <BuscarCEP>, <Numero>, <Complemento>, <TelefoneEmpresa>, <NomeGestor>, <Email>, <Senha> e <ConfirmarSenha> na Tela de Cadastro
    And marcar a opcao TERMOS_USO para o usuario juridico
    And acionar o Botao CONCLUIR_MEU_CADASTRO para o usuario juridico
    Then o sistema deve permitir o cadastramento do usuario juridico com sucesso e redirecionar o usuario para a Tela de LOGIN.

    Examples: 
      | RazaoSocial           | CNPJ             | Segmento    | BuscarCEP  | Numero   | Complemento                         | TelefoneEmpresa | NomeGestor                         | Email                                 | Senha           | ConfirmarSenha  |
      | "FCamara"             | "63607159000199" | "Hotelaria" | "01362000" | "1"      | "Tecnologia"                        | "19992929999"   | "Jefferson B Campiol"              | "automacao_duratex2@smartlink.com.br" | "Automacao@123" | "Automacao@123" |
      | "Duratex - SmartLink" | "81731853000103" | "Comércio"  | "13290000" | "123"    | "IOT Sistemas"                      | "11934567898"   | "Claudio Akio Nakimata Junior "    | "fcarama@duratex.com.br"              | "Automacao@123" | "Automacao@123" |
      | "Deca"                | "87672746000120" | "Industria" | "12442144" | "12345"  | "Industria de Madeira e Hidraulica" | "1131772900"    | "Carlos de Souza Rodrigues Junior" | "Automacao@123"                       | "Automacao@123" | "Automacao@123" |
      | "Automação 2"         | "41265658000102" | "Predial"   | "00000000" | "0"      | "Av. Paulista"                      | "21990876213"   | "Felipe Mietto"                    | "automacao3@duratex.com.br"           | "Automacao@123" | "Automacao@123" |
      | "Automação 5"         | "14253838000101" | ""          | "13456789" | "dasdsa" | "Centro"                            | "11"            | "Duratex"                          | "automacao4@duratex.com.br"           | "Automacao@123" | "Automacao@123" |
