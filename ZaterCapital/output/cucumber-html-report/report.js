$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("feature/US01-LogarExchange/TCF01-LogarExchange.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: your.email@your.domain.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 20,
  "name": "Logar na Exchange da Zater Capital",
  "description": "As um usuario da Zatar Capital\nI want Logar na Exchange\nBecause eu preciso acessar minha conta e verificar meus bitcoins",
  "id": "logar-na-exchange-da-zater-capital",
  "keyword": "Feature",
  "tags": [
    {
      "line": 19,
      "name": "@LogarExchange"
    }
  ]
});
formatter.scenarioOutline({
  "line": 26,
  "name": "Logar na Exchange da Zater Capital",
  "description": "",
  "id": "logar-na-exchange-da-zater-capital;logar-na-exchange-da-zater-capital",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 25,
      "name": "@Logar"
    }
  ]
});
formatter.step({
  "line": 27,
  "name": "usuario do da Zater Capital",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "informar um \u003cUsuario\u003e valido e uma \u003cSenha\u003e valida",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "acionar o Botao de LOGAR",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "o sistema deve permitir a autenticao do usuario na exchange com sucesso",
  "keyword": "Then "
});
formatter.examples({
  "line": 32,
  "name": "",
  "description": "",
  "id": "logar-na-exchange-da-zater-capital;logar-na-exchange-da-zater-capital;",
  "rows": [
    {
      "cells": [
        "Usuario",
        "Senha"
      ],
      "line": 33,
      "id": "logar-na-exchange-da-zater-capital;logar-na-exchange-da-zater-capital;;1"
    },
    {
      "cells": [
        "\"vinicius@netlolo.com\"",
        "\"123456\""
      ],
      "line": 34,
      "id": "logar-na-exchange-da-zater-capital;logar-na-exchange-da-zater-capital;;2"
    },
    {
      "cells": [
        "\"jefferson.campiol@netlolo.com\"",
        "\"123@321\""
      ],
      "line": 35,
      "id": "logar-na-exchange-da-zater-capital;logar-na-exchange-da-zater-capital;;3"
    },
    {
      "cells": [
        "\"paulo.luedy@netlolo.com\"",
        "\"adasdd\""
      ],
      "line": 36,
      "id": "logar-na-exchange-da-zater-capital;logar-na-exchange-da-zater-capital;;4"
    },
    {
      "cells": [
        "\"daniel.silvamiranda02@gmail.com\"",
        "\"Dga384315@\""
      ],
      "line": 37,
      "id": "logar-na-exchange-da-zater-capital;logar-na-exchange-da-zater-capital;;5"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 34,
  "name": "Logar na Exchange da Zater Capital",
  "description": "",
  "id": "logar-na-exchange-da-zater-capital;logar-na-exchange-da-zater-capital;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 19,
      "name": "@LogarExchange"
    },
    {
      "line": 25,
      "name": "@Logar"
    }
  ]
});
formatter.step({
  "line": 27,
  "name": "usuario do da Zater Capital",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "informar um \"vinicius@netlolo.com\" valido e uma \"123456\" valida",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "acionar o Botao de LOGAR",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "o sistema deve permitir a autenticao do usuario na exchange com sucesso",
  "keyword": "Then "
});
formatter.match({
  "location": "TCF01_LogarExchange.usuario_do_da_Zater_Capital()"
});
formatter.result({
  "duration": 5127862062,
  "error_message": "org.openqa.selenium.SessionNotCreatedException: session not created exception\nfrom disconnected: received Inspector.detached event\n  (Session info: chrome\u003d64.0.3282.186)\n  (Driver info: chromedriver\u003d2.33.506120 (e3e53437346286c0bc2d2dc9aa4915ba81d9023f),platform\u003dWindows NT 10.0.15063 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 3.19 seconds\nBuild info: version: \u00273.8.1\u0027, revision: \u00276e95a6684b\u0027, time: \u00272017-12-01T18:33:54.468Z\u0027\nSystem info: host: \u0027LAPTOP-V886S6BJ\u0027, ip: \u002710.6.254.18\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_151\u0027\nDriver info: driver.version: ChromeDriver\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:214)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:166)\r\n\tat org.openqa.selenium.remote.JsonWireProtocolResponse.lambda$new$0(JsonWireProtocolResponse.java:53)\r\n\tat org.openqa.selenium.remote.JsonWireProtocolResponse.lambda$getResponseFunction$2(JsonWireProtocolResponse.java:91)\r\n\tat org.openqa.selenium.remote.ProtocolHandshake.lambda$createSession$0(ProtocolHandshake.java:123)\r\n\tat java.util.stream.ReferencePipeline$3$1.accept(Unknown Source)\r\n\tat java.util.Spliterators$ArraySpliterator.tryAdvance(Unknown Source)\r\n\tat java.util.stream.ReferencePipeline.forEachWithCancel(Unknown Source)\r\n\tat java.util.stream.AbstractPipeline.copyIntoWithCancel(Unknown Source)\r\n\tat java.util.stream.AbstractPipeline.copyInto(Unknown Source)\r\n\tat java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)\r\n\tat java.util.stream.FindOps$FindOp.evaluateSequential(Unknown Source)\r\n\tat java.util.stream.AbstractPipeline.evaluate(Unknown Source)\r\n\tat java.util.stream.ReferencePipeline.findFirst(Unknown Source)\r\n\tat org.openqa.selenium.remote.ProtocolHandshake.createSession(ProtocolHandshake.java:126)\r\n\tat org.openqa.selenium.remote.ProtocolHandshake.createSession(ProtocolHandshake.java:73)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:142)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:601)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.startSession(RemoteWebDriver.java:219)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.\u003cinit\u003e(RemoteWebDriver.java:142)\r\n\tat org.openqa.selenium.chrome.ChromeDriver.\u003cinit\u003e(ChromeDriver.java:181)\r\n\tat org.openqa.selenium.chrome.ChromeDriver.\u003cinit\u003e(ChromeDriver.java:168)\r\n\tat org.openqa.selenium.chrome.ChromeDriver.\u003cinit\u003e(ChromeDriver.java:123)\r\n\tat Utilitarios.FuncoesReusaveis_Windows.InitBrowser(FuncoesReusaveis_Windows.java:69)\r\n\tat Funcional.US01_LogarExchange.TCF01_LogarExchange.usuario_do_da_Zater_Capital(TCF01_LogarExchange.java:23)\r\n\tat ✽.Given usuario do da Zater Capital(feature/US01-LogarExchange/TCF01-LogarExchange.feature:27)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "vinicius@netlolo.com",
      "offset": 13
    },
    {
      "val": "123456",
      "offset": 49
    }
  ],
  "location": "TCF01_LogarExchange.informar_um_valido_e_uma_valida(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TCF01_LogarExchange.acionar_o_Botao_de_LOGAR()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TCF01_LogarExchange.o_sistema_deve_permitir_a_autenticao_do_usuario_na_exchange_com_sucesso()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 35,
  "name": "Logar na Exchange da Zater Capital",
  "description": "",
  "id": "logar-na-exchange-da-zater-capital;logar-na-exchange-da-zater-capital;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 19,
      "name": "@LogarExchange"
    },
    {
      "line": 25,
      "name": "@Logar"
    }
  ]
});
formatter.step({
  "line": 27,
  "name": "usuario do da Zater Capital",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "informar um \"jefferson.campiol@netlolo.com\" valido e uma \"123@321\" valida",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "acionar o Botao de LOGAR",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "o sistema deve permitir a autenticao do usuario na exchange com sucesso",
  "keyword": "Then "
});
formatter.match({
  "location": "TCF01_LogarExchange.usuario_do_da_Zater_Capital()"
});
