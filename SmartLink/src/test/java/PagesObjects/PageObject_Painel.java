package PagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;

import Utilitarios.FuncoesReusaveis;

public class PageObject_Painel extends FuncoesReusaveis {

	public static void PainelSelecaoLeitura() throws Exception {

		if (IsElementPresent("dashboardui")) {

			// Escrevendo no Console
			System.out.println("Painel - está Visiveis");

			/** Report Extent **/
			test.log(Status.PASS, "Painel - está Visiveis");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "PainelSelecaoLeitura-PainelVisivel"));
			/** Report Extent **/

			if (IsElementPresent("dashboardui_context_card")) {

				// Procurando o Elemento
				WebElement selecaoLeitura = driver.findElement(By.id("dashboardui_context_card"));

				// Funcao HighLight
				HighLightElement(selecaoLeitura);

				// Clicar no Botão
				selecaoLeitura.click();
				Thread.sleep(1000); // Espera 1 segundo

				// Escrevendo no Console
				System.out.println("Painel - Seleção de leitura");

				/** Report Extent **/
				test.log(Status.PASS, "Painel - Seleção de leitura");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "PainelSelecaoLeitura-AcionadoBotaoSelecaoLeituraComSucesso"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Painel - Seleção de leitura não Visível");

				/** Report Extent **/
				test.log(Status.FAIL, "Painel - Seleção de leitura não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "PainelSelecaoLeitura-NaoVisivel"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console
			System.out.println("Painel - Não estão Visiveis");

			/** Report Extent **/
			test.log(Status.FAIL, "Painel - Não estão Visiveis");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "PainelSelecaoLeitura-PainelNaoVisivel"));
			/** Report Extent **/

		}

	}
	
	public static void PainelSelecaoLocal() throws Exception {

		if (IsElementPresent("CardContainerid1")) {

			// Escrevendo no Console
			System.out.println("Painel - Seleção de Local");

			/** Report Extent **/
			test.log(Status.PASS, "Painel - Seleção de Local");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "PainelSelecaoLocal-PainelSelecaoLocalVisivel"));
			/** Report Extent **/

			if (IsElementPresent("CardContainer_Header_id1")) {

				// Procurando o Elemento
				WebElement selecionarLocal = driver.findElement(By.id("CardContainer_Header_id1"));

				// Funcao HighLight
				HighLightElement(selecionarLocal);

				// Clicar no Botão 'Local'
				selecionarLocal.click();
				Thread.sleep(1000); // Espera 1 segundo

				// Escrevendo no Console
				System.out.println("Painel - Selecionar Local");

				/** Report Extent **/
				test.log(Status.PASS, "Painel - Selecionar Local");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso",
						"PainelSelecaoLocal-SelecionarLocalComSucesso"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Painel - Local não visível");

				/** Report Extent **/
				test.log(Status.FAIL, "Painel - Local não visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "PainelSelecaoLocal-LocalNaoVisivel"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console
			System.out.println("Painel - Seleção de Local não Visível");

			/** Report Extent **/
			test.log(Status.FAIL, "Painel - Seleção de Local não Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "PainelSelecaoLocal-PainelSelecaoLocalNaoVisivel"));
			/** Report Extent **/

		}

	}
	
	public static void PainelSelecaoOpcaoLocal(String OpcaoLocal) throws Exception {

		if (IsElementPresent("CardContainer_Contentid1")) {

			// Escrevendo no Console
			System.out.println("Painel - Seleção da opção de Local está Visível");

			/** Report Extent **/
			test.log(Status.PASS, "Painel - Seleção da opção de Local está Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "PainelSelecaoOpcaoLocal-PainelSelecaoOpcaoLocalVisivel"));
			/** Report Extent **/

			if (driver.findElement(By.id("CardContainer_Contentid1")).getAttribute("textContent").contains(OpcaoLocal)) {

				// Procurando o Elemento
				WebElement selecionarOpcaoLocal = driver.findElement(By.xpath("//*[text()='" + OpcaoLocal + "']"));
							
				// Funcao HighLight
				HighLightElement(selecionarOpcaoLocal);

				// Clicar na Opção do Local
				//selecionarOpcaoLocal.click();
				//System.out.println(selecionarOpcaoLocal.getLocation());
				
				Actions buttonOpcaoLocal = new Actions(driver);   
				buttonOpcaoLocal.moveToElement(selecionarOpcaoLocal).click().build().perform();
				//buttonOpcaoLocal.moveByOffset(497,286).click().build().perform();
				
				Thread.sleep(1000); // Espera 1 segundo

				// Escrevendo no Console
				System.out.println("Painel - Opção do Local " + OpcaoLocal +  " selecionada");

				/** Report Extent **/
				test.log(Status.PASS, "Painel - Opção do Local " + OpcaoLocal +  " selecionada");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso",
						"PainelSelecaoOpcaoLocal-SelecionarOpçãoLocalComSucesso"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Painel - Opção do Local " + OpcaoLocal +  " não está visível");

				/** Report Extent **/
				test.log(Status.FAIL, "Painel - Opção do Local " + OpcaoLocal +  " não está visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "PainelSelecaoOpcaoLocal-OpcaoLocalNaoVisivel"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console
			System.out.println("Painel - Seleção da opção de Local não está Visível");

			/** Report Extent **/
			test.log(Status.FAIL, "Painel - Seleção da opção de Local não está Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "PainelSelecaoOpcaoLocal-PainelSelecaoOpcaoLocalNaoVisivel"));
			/** Report Extent **/

		}

	}
	
	public static void PainelSelecaoAmbiente() throws Exception {

		if (IsElementPresent("CardContainerid2")) {

			// Escrevendo no Console
			System.out.println("Painel - Seleção de Ambiente");

			/** Report Extent **/
			test.log(Status.PASS, "Painel - Seleção de Ambiente");
			test.addScreenCaptureFromPath(
					TakeScreenshot("Sucesso", "PainelSelecaoAmbiente-PainelSelecaoAmbienteVisivel"));
			/** Report Extent **/

			if (IsElementPresent("CardContainer_Header_id2")) {

				// Procurando o Elemento
				WebElement selecionarAmbiente = driver.findElement(By.id("CardContainer_Header_id2"));

				// Funcao HighLight
				HighLightElement(selecionarAmbiente);

				// Clicar no Botão 'Ambiente'
				selecionarAmbiente.click();
				Thread.sleep(1000); // Espera 1 segundo

				// Escrevendo no Console
				System.out.println("Painel - Selecionar Ambiente");

				/** Report Extent **/
				test.log(Status.PASS, "Painel - Selecionar Ambiente");
				test.addScreenCaptureFromPath(
						TakeScreenshot("Sucesso", "PainelSelecaoAmbiente-SelecionarAmbienteComSucesso"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Painel - Ambiente não visível");

				/** Report Extent **/
				test.log(Status.FAIL, "Painel - Ambiente não visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "PainelSelecaoAmbiente-AmbienteNaoVisivel"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console
			System.out.println("Painel - Seleção de Ambiente não Visível");

			/** Report Extent **/
			test.log(Status.FAIL, "Painel - Seleção de Ambiente não Visível");
			test.addScreenCaptureFromPath(
					TakeScreenshot("Erro", "PainelSelecaoAmbiente-PainelSelecaoAmbienteNaoVisivel"));
			/** Report Extent **/

		}

	}

	public static void PainelSelecaoOpcaoAmbiente(String OpcaoAmbiente) throws Exception {

		if (IsElementPresent("CardContainer_Contentid2")) {

			// Escrevendo no Console
			System.out.println("Painel - Seleção da opção de Ambiente está Visível");

			/** Report Extent **/
			test.log(Status.PASS, "Painel - Seleção da opção de Ambiente está Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "PainelSelecaoOpcaoAmbiente-PainelSelecaoOpcaoAmbienteVisivel"));
			/** Report Extent **/

			if (driver.findElement(By.id("CardContainer_Contentid2")).getAttribute("textContent").contains(OpcaoAmbiente)) {

				// Procurando o Elemento
				WebElement selecionarOpcaoAmbiente = driver.findElement(By.xpath("//*[text()='" + OpcaoAmbiente + "']"));			
				
				// Funcao HighLight
				HighLightElement(selecionarOpcaoAmbiente);

				// Clicar na Opção do Ambiente
				//selecionarOpcaoAmbiente.click();
				//System.out.println(selecionarOpcaoAmbiente.getLocation());
				
				Actions buttonOpcaoAmbiente = new Actions(driver);   
				buttonOpcaoAmbiente.moveToElement(selecionarOpcaoAmbiente).click().build().perform();
				//buttonOpcaoLocal.moveByOffset(497,286).click().build().perform();
				
				Thread.sleep(1000); // Espera 1 segundo

				// Escrevendo no Console
				System.out.println("Painel - Opção do Ambiente " + OpcaoAmbiente +  " selecionada");

				/** Report Extent **/
				test.log(Status.PASS, "Painel - Opção do Ambiente  " + OpcaoAmbiente +  " selecionada");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso",
						"PainelSelecaoOpcaoAmbiente-SelecionarOpçãoAmbienteComSucesso"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Painel - Opção do Ambiente " + OpcaoAmbiente +  " não está visível");

				/** Report Extent **/
				test.log(Status.FAIL, "Painel - Opção do Ambiente " + OpcaoAmbiente +  " não está visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "PainelSelecaoOpcaoAmbiente-OpcaoAmbienteNaoVisivel"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console
			System.out.println("Painel - Seleção da opção de Ambiente não está Visível");

			/** Report Extent **/
			test.log(Status.FAIL, "Painel - Seleção da opção de Ambiente não está Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "PainelSelecaoOpcaoAmbiente-PainelSelecaoOpcaoAmbienteNaoVisivel"));
			/** Report Extent **/

		}

	}

	public static void PainelSelecaoDispositivo() throws Exception {
		
		if (IsElementPresent("CardContainerid3")) {

			// Escrevendo no Console
			System.out.println("Painel - Seleção de Dispositivo");

			/** Report Extent **/
			test.log(Status.PASS, "Painel - Seleção de Dispositivo");
			test.addScreenCaptureFromPath(
					TakeScreenshot("Sucesso", "PainelSelecaoDispositivo-PainelSelecaoDispositivoVisivel"));
			/** Report Extent **/

			if (IsElementPresent("CardContainer_Header_id3")) {

				// Procurando o Elemento
				WebElement selecionarDispositivo= driver.findElement(By.id("CardContainer_Header_id3"));

				// Funcao HighLight
				HighLightElement(selecionarDispositivo);

				// Clicar no Botão 'Dispositivo'
				selecionarDispositivo.click();
				Thread.sleep(1000); // Espera 1 segundo

				// Escrevendo no Console
				System.out.println("Painel - Selecionar Dispositivo");

				/** Report Extent **/
				test.log(Status.PASS, "Painel - Selecionar Dispositivo");
				test.addScreenCaptureFromPath(
						TakeScreenshot("Sucesso", "PainelSelecaoDispositivo-SelecionarDispositivoComSucesso"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Painel - Dispositivo não visível");

				/** Report Extent **/
				test.log(Status.FAIL, "Painel - Dispositivo não visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "PainelSelecaoDispositivo-DispositivoNaoVisivel"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console
			System.out.println("Painel - Seleção de Dispositivo não Visível");

			/** Report Extent **/
			test.log(Status.FAIL, "Painel - Seleção de Dispositivo não Visível");
			test.addScreenCaptureFromPath(
					TakeScreenshot("Erro", "PainelSelecaoDispositivo-PainelSelecaoDispositivoNaoVisivel"));
			/** Report Extent **/

		}
		
	}
	
	public static void PainelSelecaoOpcaoDispositivo(String OpcaoDispositivo) throws Exception {

		if (IsElementPresent("CardContainer_Contentid3")) {

			// Escrevendo no Console
			System.out.println("Painel - Seleção da opção de Dispositivo está Visível");

			/** Report Extent **/
			test.log(Status.PASS, "Painel - Seleção da opção de Dispositivo está Visível");
			test.addScreenCaptureFromPath(
					TakeScreenshot("Sucesso", "PainelSelecaoOpcaoDispositivo-PainelSelecaoOpcaoDispositivoVisivel"));
			/** Report Extent **/

			if (driver.findElement(By.id("CardContainer_Contentid3")).getAttribute("textContent")
					.contains(OpcaoDispositivo)) {

				// Procurando o Elemento
				WebElement selecionarOpcaoDispositivo = driver
						.findElement(By.xpath("//*[text()='" + OpcaoDispositivo + "']"));

				// Funcao HighLight
				HighLightElement(selecionarOpcaoDispositivo);

				// Clicar na Opção do Ambiente
				// selecionarOpcaoAmbiente.click();
				// System.out.println(selecionarOpcaoAmbiente.getLocation());

				Actions buttonOpcaoDispositivo = new Actions(driver);
				buttonOpcaoDispositivo.moveToElement(selecionarOpcaoDispositivo).click().build().perform();
				// buttonOpcaoLocal.moveByOffset(497,286).click().build().perform();

				Thread.sleep(1000); // Espera 1 segundo

				// Escrevendo no Console
				System.out.println("Painel - Opção do Dispositivo " + OpcaoDispositivo + " selecionada");

				/** Report Extent **/
				test.log(Status.PASS, "Painel - Opção do Dispositivo  " + OpcaoDispositivo + " selecionada");
				test.addScreenCaptureFromPath(
						TakeScreenshot("Sucesso", "PainelSelecaoOpcaoDispositivo-SelecionarOpçãoDispositivoComSucesso"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Painel - Opção do Dispositivo " + OpcaoDispositivo + " não está visível");

				/** Report Extent **/
				test.log(Status.FAIL, "Painel - Opção do Dispositivo " + OpcaoDispositivo + " não está visível");
				test.addScreenCaptureFromPath(
						TakeScreenshot("Erro", "PainelSelecaoOpcaoDispositivo-OpcaoDispositivoNaoVisivel"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console
			System.out.println("Painel - Seleção da opção de Dispositivo não está Visível");

			/** Report Extent **/
			test.log(Status.FAIL, "Painel - Seleção da opção de Dispositivo não está Visível");
			test.addScreenCaptureFromPath(
					TakeScreenshot("Erro", "PainelSelecaoOpcaoDispositivo-PainelSelecaoOpcaoDispositivoNaoVisivel"));
			/** Report Extent **/

		}

	}
		
	public static void PainelCheckConfiguracoesLocais() throws Exception {
		
		if (IsElementPresent("dashboarcontextchange_bg")) {

			// Procurando o Elemento
			WebElement checkConfiguracaoesLocais = driver.findElement(By.id("dashboarcontextchange_bg"));

			// Funcao HighLight
			HighLightElement(checkConfiguracaoesLocais);
			
			// Escrevendo no Console
			System.out.println("Painel - Configurações de Locais está Visível");

			/** Report Extent **/
			test.log(Status.PASS, "Painel - Configurações de Locais está Visível");
			test.addScreenCaptureFromPath(
					TakeScreenshot("Sucesso", "PainelCheckConfiguracoesLocais-PainelConfiguracoesLocaisVisivel"));
			/** Report Extent **/
		
		} else {

			// Escrevendo no Console
			System.out.println("Painel - Configurações de Locais não está Visível");

			/** Report Extent **/
			test.log(Status.FAIL, "Painel - Configurações de Locais não está Visível");
			test.addScreenCaptureFromPath(
					TakeScreenshot("Erro", "PainelCheckConfiguracoesLocais-PainelConfiguracoesLocaisNaoVisivel"));
			/** Report Extent **/

		}
		
		
	}
		
	public static void PainelCheckSelecaoContexto() throws Exception {

		if (driver.findElement(By.id("dashboardui_context_card")).getAttribute("innerText").contains("Local")) {

			// Escrevendo no Console
			System.out.println("Painel - Seleção de Contexto configurado de forma padrão");

			/** Report Extent **/
			test.log(Status.ERROR, "Painel - Seleção de Contexto configurado de forma padrão");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "PainelCheckSelecaoContexto-ConfiguradoPadrao"));
			/** Report Extent **/

		} else {

			// Procurando o Elemento
			WebElement checkSelecaoContexto = driver.findElement(By.id("dashboardui_context_card"));

			// Funcao HighLight
			HighLightElement(checkSelecaoContexto);

			// Escrevendo no Console
			System.out.println("Painel - Seleção de Contexto configurador com sucesso");

			/** Report Extent **/
			test.log(Status.PASS, "Painel - Seleção de Contexto configurador com sucesso");
			test.addScreenCaptureFromPath(
					TakeScreenshot("Sucesso", "PainelCheckSelecaoContexto-ConfiguradoComSucesso"));
			/** Report Extent **/

		}

	}
	
	public static void ButtonSalvarConfiguracoes() throws Exception {

		if (IsElementPresent("dashboarcontextchange_bg")) {

			// Escrevendo no Console
			System.out.println("Painel - Contexto está Visiveis");

			/** Report Extent **/
			test.log(Status.PASS, "Painel - Contexto está Visiveis");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "ButtonSalvarConfiguracoes-PainelContextoVisivel"));
			/** Report Extent **/

			if (IsElementPresent("dashboarcontextchange_confirmationbutton")) {

				// Procurando o Elemento
				WebElement buttonSalvarConfiguracoes = driver.findElement(By.id("dashboarcontextchange_confirmationbutton"));

				// Funcao HighLight
				HighLightElement(buttonSalvarConfiguracoes);

				// Clicar no Botão
				buttonSalvarConfiguracoes.click();
				Thread.sleep(1000); // Espera 1 segundo

				// Escrevendo no Console
				System.out.println("Painel - Button 'Salvar configurações' acionado");

				/** Report Extent **/
				test.log(Status.PASS, "Painel - Button 'Salvar configurações' acionado");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "ButtonSalvarConfiguracoes-AcionadoBotaoSalvarConfiguracoesComSucesso"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Painel - Button 'Salvar configurações' não Visível");

				/** Report Extent **/
				test.log(Status.FAIL, "Painel - Button 'Salvar configurações' não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "ButtonSalvarConfiguracoes-NaoVisivel"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console
			System.out.println("Painel - Contexto Não estão Visiveis");

			/** Report Extent **/
			test.log(Status.FAIL, "Painel - Contexto Não estão Visiveis");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "PainelSelecaoLeitura-PainelContextoNaoVisivel"));
			/** Report Extent **/

		}

	}
	
	
}
