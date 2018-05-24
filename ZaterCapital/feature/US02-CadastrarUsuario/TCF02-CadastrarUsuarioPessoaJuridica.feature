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
Feature: Cadastrar na Exchange da Zater Capital
  As um usuario Pessoa Juridica
  I want cadastrar no site da Exchange da Zater Capital
  Because eu quero acessar as funcionalidade e ser cliente

  @CadastrarPessoaJuridica
  Scenario Outline: Cadastrar na Exchange da Zater Capital - Pessoa Juridica
    Given um usuario do tipo Pessoa Juridica na Tela de Cadastro da Exchange da Zater Capital.
    And marcar o RadioButton PESSOAJURICA.
    When informar os <RazaoSocial>, <NomeFantasia>, <CNPJ>, <E-Mail>, <ConfirmarEmail>, <Senha>, <ConfirmarSenha>, <SelecionarEstado> e <Cidade> na Tela de Cadastro
    And marcar a opcao ACEITO_TERMO.
    And acionar o Botao CRIAR_CONTA.
    Then o sistema deve permitir o cadastramento do usuario com sucesso e redirecionar o usuario para a Tela de LOGIN.

    Examples: 
      | RazaoSocial               | NomeFantasia            | CNPJ             | E-Mail                          | ConfirmarEmail                  | Senha           | ConfirmarSenha  | SelecionarEstado | Cidade           |
      | "Automação1 S/A"          | "Zater Capital"         | "82604202000107" | "automacao1@netlolo.com"        | "automacao1@netlolo.com"        | "Automacao@123" | "Automacao@123" | "SP"             | "São Paulo"      |
      | "Automação2 S/A"          | "Zater Capital"         | "46718622000150" | "automacao2@netlolo.com"        | "automacao2@netlolo.com"        | "Automacao@123" | "Automacao@123" | "PR"             | "Curitiba"       |
      | "Automação3 S/A"          | "Zater Capital"         | "53821231000122" | "automacao3@netlolo.com"        | "automacao3@netlolo.com"        | "Automacao@123" | "Automacao@123" | "BA"             | "Salvador"       |
      | "Automação4 S/A"          | "Zater Capital"         | "65344273000107" | "automacao4@netlolo.com"        | "automacao4@netlolo.com"        | "Automacao@123" | "Automacao@123" | "SP"             | "São Paulo"      |
      | "Jefferson S/A"           | "Jefferson Informática" | "78754316000166" | "jefferson.campiol@netlolo.com" | "jefferson.campiol@netlolo.com" | "123@321"       | "123@321"       | "SP"             | "Vinhedo"        |
      | "Paulo"                   | "1fdsfsdfsffdsfs"       | "13123123122222" | "paulo.luedy@netlolo.com"       | "paulo.luedy@netlolo.com"       | "123"           | "123"           | "SP"             | "Santos"         |
      | "ZAZACATARINA"            | "CATARINA"              | "29163465550145" | "ZAteraa@gmail.com"             | "ZAteraa@gmail.com"             | ""              | ""              | "RJ"             | "Rio de Janeiro" |
      | "ZATER TECHNOLOGIES LTDA" | "ZATER CAPITAL"         | "29163165000166" | "suportezater@zatercapital.com" | "suportezater@zatercapital.com" | "123456"        | "123456"        | "SP"             | "São Paulo"      |
