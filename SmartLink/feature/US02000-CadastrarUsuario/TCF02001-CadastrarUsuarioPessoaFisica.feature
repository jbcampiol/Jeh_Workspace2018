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
  As um usuario Pessoa Fisica
  I want me cadastrar no site do Sistema SmartLink da Deca
  Because eu quero acessar as funcionalidade para ter controle sobre o meu SmartLink

  @CadastrarPessoaFisica
  Scenario Outline: Cadastrar usuario no Sistema SmartLink da Deca - Pessoa Fisica
    Given um usuario do tipo Pessoa Fisica na Tela de Cadastro do Sistema SmartLink
    And marcar o RadioButton PESSOAFISICA
    When informar os dados <NomeCompleto>, <CPF>, <BuscarCEP>, <Numero>, <Complemento>, <TelefoneContato>, <Email>, <Senha> e <ConfirmarSenha> na Tela de Cadastro
    And marcar a opcao TERMOS_USO para o usuario fisico
    And acionar o Botao CONCLUIR_MEU_CADASTRO para o usuario fisico
    Then o sistema deve permitir o cadastramento do usuario com sucesso e redirecionar o usuario para a Tela de LOGIN.

    Examples: 
      | NomeCompleto                  | CPF           | BuscarCEP  | Numero | Complemento          | TelefoneContato | Email                                 | Senha           | ConfirmarSenha  |
      | "Jefferson Barbieri Campiol"  | "62743282703" | "13280268" | "116"  | "Bairro Planalto"    | "19992634545"   | "jefferson.campiol@fcamara.com.br"    | "1234@4321"     | "1234@4321"     |
      | "Automação Duratex SmartLink" | "43582237885" | "10021994" | "1234" | "Paulista"           | "11992456767"   | "automacao_duratex1@smartlink.com.br" | "12345678"      | "12345678"      |
      | "Automação 1"                 | "55371056599" | "01012000" | "431"  | "Vila Nova"          | "21998763421"   | "automacao1@duratex.com.br"           | "Automacao@123" | "Automacao@123" |
      | "Automação 2"                 | "51566348501" | "01012000" | "1"    | "Deca"               | "adadadaddad"   | "automacao2@deca.com.br"              | "Automacao@123" | "Automacao"     |
      | "Automação 5"                 | "23874631702" | "06061999" | ""     | "Escritório Central" | "21333123312"   | "Automacao5@1234567"                  | "Automacao@123" | "Automacao@123" |
