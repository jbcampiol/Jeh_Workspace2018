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
@Agua
Feature: Seleção Contexto
  As um usuario 
  I want poder selecionar o local/ambiente ou dispositivo na opção Selecao de Leitura na tela de Painel
  Because quero visualizar na Tela de Painel o gráfico exatamente com as informações que foram escolhidas da medicao ao Vivo e no Painel
  
  Keywords Summary: Pré-Condição
  	É necessário que tenha sido feita a instalação e instanciação do dispositivo/ambiente/local na rotina de instalação.
  
  Keywords Summary: Critérios de Aceite
  Toda a vez que seleciono um local, a opção para escolher o ambiente deverá aparecer
  	Toda a vez que seleciono um ambiente, a lista de dispositivos deve aparecer.
  	Só posso selecionar um único local/ambiente ou dispositivo
  	Terei a opção de selecionar apenas o Local ou o Ambiente ou o Device
  	Ao apertar o botão de Salvar configurações devo voltar para a tela de painel
  	Caso não possua nenhum contexto selecionado, a minha selecao de leitura deve apontar para todos (Comportamento Default).

  @SelecionarSelecaoLeitura
  Scenario: Selecionar Selecao de Leitura
    Given um usuario logado e ja com a instalacao e instanciacao do dispositovo IoT SmartLink realizado
    When acessar o Menu PAINEL
    And acionar o opção SELECAO DE LEITURA
    Then o sistema deve exibir a Tela CONFIGURACOES DE LOCAIS para que o usuario possa configurar o Local/Ambiente/Dispositivo IoT SmartLink

  @SelecionarContexto
  Scenario Outline: Selecionar Contexto
    Given um usuario do sistema que está na Tela CONFIGURACOES DE LOCAIS
    When selecionar o Menu LOCAL
    And selecionar a Opção do LOCAL <LOCAL>
    Then o sistema deve exibir o Menu AMBIENTE
    When selecionar o Menu AMBIENTE
    And selecionar a Opção do AMBIENTE <AMBIENTE>
    Then o sistema deve exibir o Menu DISPOSITIVO
    When selecionar o Menu DISPOSITIVO
    And selecionar a Opção DISPOSITIVO <DISPOSITIVO>
    And acionor o Botao SALVAR CONFIGURACOES DE LOCAIS
    When o sistema deve salvar com sucesso as configuracoes Local/Ambiente/Dispositivo

    Examples: 
      | LOCAL              | AMBIENTE                      | DISPOSITIVO    |
      | "Deca"             | "Lab Engenharia"              | "Teste 34c4ca" |
      | "Duratex paulista" | "Cozinha 10˚ andar - edit540" | ""             |
      | "Deca"             | "Salinha"                     | "Teste 35b90c" |
