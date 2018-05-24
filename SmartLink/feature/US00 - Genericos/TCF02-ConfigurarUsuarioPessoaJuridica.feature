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
  As um usuario Pessoa Juridica já cadastrado no site da Zater Capital
  I want finalizar o meu cadastro na Tela de Configurações da Exchange da Zater Capital
  Because eu quero ter o meu cadastro finalizado para poder subir de nível

@ConfigurarPessoaJuridica
  Scenario Outline: Configurar usuário na Exchange da Zater Capital - Pessoa Juridica
    Given um usuario do tipo Pessoa Juridica
    When logar na Exchange da Zater Capital com o <Usuario> valido e uma <Senha> valida
    And clicar na opção CONFIGURACOES
    When inserir a FOTO do PERFIL
    And inserir as FOTOS dos DOCUMENTOS, ANEXO1, ANEXO2, ANEXO3 e ANEXO4
    And informar os Dados <NomeSocio>, <RazaoSocial>, <NomeFantasia>, <Endereco>, <Estado>, <Cidade>, <CEP>, <ContactName>, <ContactEMail> e <Telefone> na Tela de CONFIGURACOES.
    And acionar o BOTAO CONFIRMAR DADOS
    Then o sistema deve permitir a atualização dos dados cadastrais do usuario com sucesso e alterar o nivel do usuario

    Examples: 
      | Usuario                    | Senha           | NomeSocio                             | RazaoSocial                        | NomeFantasia                                 | Endereco                                                 | Estado | Cidade           | CEP        | ContactName                                | ContactEMail                    | Telefone      |
      | "automacao1@netlolo.com"   | "Automacao@123" | "Jefferson Barbieri Campiol"          | "Barbieri Campiol LTDA"            | "Exchange BITCOINS THE BEST - Zater Capital" | "Av. Paulista, 2202"                                     | "SP"   | "São Paulo"      | "01361000" | "Zater Capital Contact Name (Netlolo) - 1" | "jefferson.campiol@netlolo.com" | "19992524666" |
      | "automacao3@netlolo.com"   | "Automacao@123" | "Zater Capital Exchange BITCOINS - 1" | "Zater Capital LTDA"               | "Exchange BITCOINS THE BEST LTDA"            | "Av. Copacabana, 1234 - Copacabana"                      | "RJ"   | "Rio de Janeiro" | "03123131" | "Zater Capital Contact Name - 2"           | "jefferson.campiol@netlolo.com" | "19992524000" |
      | "automacao4@netlolo.com"   | "Automacao@123" | "Zater Capital Exchange BITCOINS - 2" | "Netlolo & Zater Capital Exchange" | "Exchange BITCOINS THE BEST ME"              | "Av. da Praia - 1234 - Bairro: Centro"                   | "BA"   | "Salvador"       | "98327327" | "Zater Capital Contact Name - 3"           | "jefferson.campiol@netlolo.com" | "11991662343" |
      | "suporte@zatercapital.com" | "123456"        | "Zater Capital Exchange BITCOINS - 3" | "Netlolo"                          | "Exchange BITCOINS THE BEST"                 | "Rua da Logoa AZUL, 9876 - Santa Fé - Prédio Maria Rosa" | "ES"   | "Vitória"        | "31312313" | "Zater Capital Contact Name - 4"           | "suporte@zatercapital.com"      | "11986572928" |
