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
@ConfigurarUsuario
Feature: Configurar usuário na Exchange da Zater Capital
  As um usuario Pessoa Fisica já cadastrado no site da Zater Capital
  I want finalizar o meu cadastro na Tela de Configurações da Exchange da Zater Capital
  Because eu quero ter o meu cadastro finalizado para poder subir de nível

  @ConfigurarPessoaFisica
  Scenario Outline: Configurar usuário na Exchange da Zater Capital - Pessoa Fisica
    Given um usuario do tipo Pessoa Fisica.
    When logar na Exchange da Zater Capital com o <Usuario> valido e uma <Senha> valida.
    And clicar na opção CONFIGURACOES.
    When inserir a FOTO do PERFIL.
    And inserir as FOTOS dos DOCUMENTOS, ANEXO1, ANEXO2, ANEXO3 e ANEXO4.
    And informar os Dados <Nome>, <Sobrenome>, <Nascimento>, <Endereco>, <Estado>, <Cidade>, <CEP>, <Celular> e <IR> na Tela de CONFIGURACOES.
    And acionar o BOTAO CONFIRMAR DADOS.
    Then o sistema deve permitir a atualização dos dados cadastrais do usuario com sucesso e alterar o nivel do usuario.

    Examples: 
      | Usuario                         | Senha           | Nome          | Sobrenome          | Nascimento | Endereco             | Estado | Cidade      | CEP        | Celular       | IR           |
      | "jefferson.campiol@netlolo.com" | "123@321"       | "Jefferson"   | "Barbieri Campiol" | "01051986" | "Rua Amazonas, 116"  | "SP"   | "Vinhedo"   | "13280000" | "19992524666" | "1234567890" |
      | "automacaox@netlolo.com"        | "Automacao@123" | "Automação X" | "Netlolo"          | "01012000" | "Av. Paulista, 2202" | "SP"   | "São Paulo" | "01361000" | "11987654321" | "1234567890" |
      | "automacao2@netlolo.com"        | "Automacao@123" | "Automação 2" | "Netlolo"          | "01012000" | "Av. Paulista, 2202" | "SP"   | "São Paulo" | "01361000" | "11987654321" | "1234567890" |


# -L5PheQMw5T8EiZJzP1t
