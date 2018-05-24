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
  As um usuario Pessoa Fisica
  I want cadastrar no site da Exchange da Zater Capital
  Because eu quero acessar as funcionalidade e ser cliente

  @CadastrarPessoaFisica
  Scenario Outline: Cadastrar na Exchange da Zater Capital - Pessoa Fisica
    Given um usuario do tipo Pessoa Fisica na Tela de Cadastro da Exchange da Zater Capital.
    And marcar o RadioButton PESSOAFISICA.
    When informar os dados <Nome>, <Sobrenome>, <Nascimento>, <CPF>, <E-Mail>, <ConfirmarEmail>, <Senha>, <ConfirmarSenha>, <SelecionarEstado> e <Cidade> na Tela de Cadastro.
    And marcar a opcao ACEITO_TERMO.
    And acionar o Botao CRIAR_CONTA.
    Then o sistema deve permitir o cadastramento do usuario com sucesso e redirecionar o usuario para a Tela de LOGIN.

    Examples: 
      | Nome         | Sobrenome          | Nascimento | CPF           | E-Mail                          | ConfirmarEmail                  | Senha           | ConfirmarSenha  | SelecionarEstado | Cidade           |
      | "Jefferson"  | "Barbieri Campiol" | "01051986" | "62743282703" | "jefferson.campiol@netlolo.com" | "jefferson.campiol@netlolo.com" | "123@321"       | "123@321"       | "SP"             | "Vinhedo"        |
      | "Paulo"      | "Luedy"            | "10021994" | "43582237885" | "paulo.luedy@netlolo.com"       | "paulo.luedy@netlolo.com"       | "123456"        | "123456"        | "SP"             | "Santos"         |
      | "AutomaçãoX" | "Netlolo"          | "01012000" | "55371056599" | "automacaox@netlolo.com"        | "automacaox@netlolo.com"        | "Automacao@123" | "Automacao@123" | "SP"             | "São Paulo"      |
      | "Automação2" | "Netlolo"          | "01012000" | "51566348501" | "automacao2@netlolo.com"        | "automacao2@netlolo.com"        | "Automacao@123" | "Automacao@123" | "RJ"             | "Rio de Janeiro" |
      | "Automação5" | "Netlolo"          | "06061999" | "23874631702" | "Automacao5@netlolo.com"        | "Automacao5@netlolo.com"        | "Automacao@123" | "Automacao@123" | "BA"             | "Salvador"       |
