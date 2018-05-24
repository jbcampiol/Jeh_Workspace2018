package PagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import Utilitarios.FuncoesReusaveis;

public class PageObject_Dashboard extends FuncoesReusaveis {
	
	public static void MenuInicio() throws Exception {

		if (IsElementPresent("menusideweb")) {

			// Escrevendo no Console
			System.out.println("Dashboard - Menus do Dashboard estão Visiveis");

			/** Report Extent **/
			test.log(Status.PASS, "Dashboard - Menus do Dashboard estão Visiveis");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "MenuInicio-MenusDashboardVisivel"));
			/** Report Extent **/

			if (IsElementPresent("navigationcontainer_homeIcon_web")) {

				// Procurando o Elemento
				WebElement menuInicio = driver.findElement(By.id("navigationcontainer_homeIcon_web"));

				// Funcao HighLight
				HighLightElement(menuInicio);

				// Clicar no Menu
				menuInicio.click();
				Thread.sleep(1000); // Espera 1 segundo

				// Escrevendo no Console
				System.out.println("Dashboard - Menu Início");

				/** Report Extent **/
				test.log(Status.PASS, "Dashboard - Menu Início");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "MenuInicio-AcionadoComSucesso"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Dashboard - Menu Início não Visível");

				/** Report Extent **/
				test.log(Status.FAIL, "Dashboard - Menu Início não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "MenuInicio-NaoVisivel"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console
			System.out.println("Dashboard - Menus do Dashboard Não estão Visiveis");

			/** Report Extent **/
			test.log(Status.FAIL, "Dashboard - Menus do Dashboard Não estão Visiveis");
			test.addScreenCaptureFromPath(TakeScreenshot("ERRO", "MenuInicio-MenusDashboardNaoVisivel"));
			/** Report Extent **/

		}

	}
	
	public static void MenuPainel() throws Exception {
		
		if (IsElementPresent("menusideweb")) {

			// Escrevendo no Console
			System.out.println("Dashboard - Menus do Dashboard estão Visiveis");

			/** Report Extent **/
			test.log(Status.PASS, "Dashboard - Menus do Dashboard estão Visiveis");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "MenuPainel-MenusDashboardVisivel"));
			/** Report Extent **/

			if (IsElementPresent("navigationcontainer_painelIcon_web")) {

				// Procurando o Elemento
				WebElement menuPainel = driver.findElement(By.id("navigationcontainer_painelIcon_web"));

				// Funcao HighLight
				HighLightElement(menuPainel);

				// Clicar no Menu
				menuPainel.click();
				Thread.sleep(1000); // Espera 1 segundo

				// Escrevendo no Console
				System.out.println("Dashboard - Menu Painel");

				/** Report Extent **/
				test.log(Status.PASS, "Dashboard - Menu Painel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "MenuPainel-AcionadoComSucesso"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Dashboard - Menu Painel não Visível");

				/** Report Extent **/
				test.log(Status.FAIL, "Dashboard - Menu Painel não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "MenuPainel-NaoVisivel"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console
			System.out.println("Dashboard - Menus do Dashboard Não estão Visiveis");

			/** Report Extent **/
			test.log(Status.FAIL, "Dashboard - Menus do Dashboard Não estão Visiveis");
			test.addScreenCaptureFromPath(TakeScreenshot("ERRO", "MenuPainel-MenusDashboardNaoVisivel"));
			/** Report Extent **/

		}
		
	}
		
	public static void MenuDispositivos() throws Exception {
		
		if (IsElementPresent("menusideweb")) {

			// Escrevendo no Console
			System.out.println("Dashboard - Menus do Dashboard estão Visiveis");

			/** Report Extent **/
			test.log(Status.PASS, "Dashboard - Menus do Dashboard estão Visiveis");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "MenuDispositivos-MenusDashboardVisivel"));
			/** Report Extent **/

			if (IsElementPresent("navigationcontainer_dispositivosIcon_web")) {

				// Procurando o Elemento
				WebElement menuDispositivos = driver.findElement(By.id("navigationcontainer_dispositivosIcon_web"));

				// Funcao HighLight
				HighLightElement(menuDispositivos);

				// Clicar no Menu
				menuDispositivos.click();
				Thread.sleep(1000); // Espera 1 segundo

				// Escrevendo no Console
				System.out.println("Dashboard - Menu Dispositivos");

				/** Report Extent **/
				test.log(Status.PASS, "Dashboard - Menu Dispositivos");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "MenuDispositivos-AcionadoComSucesso"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Dashboard - Menu Dispositivos não Visível");

				/** Report Extent **/
				test.log(Status.FAIL, "Dashboard - Menu Dispositivos não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "MenuDispositivos-NaoVisivel"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console
			System.out.println("Dashboard - Menus do Dashboard Não estão Visiveis");

			/** Report Extent **/
			test.log(Status.FAIL, "Dashboard - Menus do Dashboard Não estão Visiveis");
			test.addScreenCaptureFromPath(TakeScreenshot("ERRO", "MenuDispositivos-MenusDashboardNaoVisivel"));
			/** Report Extent **/

		}
		
	}
	
	public static void MenuAlarmes() throws Exception {
		
		if (IsElementPresent("menusideweb")) {

			// Escrevendo no Console
			System.out.println("Dashboard - Menus do Dashboard estão Visiveis");

			/** Report Extent **/
			test.log(Status.PASS, "Dashboard - Menus do Dashboard estão Visiveis");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "MenuAlarmes-MenusDashboardVisivel"));
			/** Report Extent **/

			if (IsElementPresent("navigationcontainer_notificacoesIcon_web")) {

				// Procurando o Elemento
				WebElement menuAlarmes = driver.findElement(By.id("navigationcontainer_notificacoesIcon_web"));

				// Funcao HighLight
				HighLightElement(menuAlarmes);

				// Clicar no Menu
				menuAlarmes.click();
				Thread.sleep(1000); // Espera 1 segundo

				// Escrevendo no Console
				System.out.println("Dashboard - Menu Alarmes");

				/** Report Extent **/
				test.log(Status.PASS, "Dashboard - Menu Alarmes");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "MenuAlarmes-AcionadoComSucesso"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Dashboard - Menu Alarmes não Visível");

				/** Report Extent **/
				test.log(Status.FAIL, "Dashboard - Menu Alarmes não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "MenuAlarmes-NaoVisivel"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console
			System.out.println("Dashboard - Menus do Dashboard Não estão Visiveis");

			/** Report Extent **/
			test.log(Status.FAIL, "Dashboard - Menus do Dashboard Não estão Visiveis");
			test.addScreenCaptureFromPath(TakeScreenshot("ERRO", "MenuAlarmes-MenusDashboardNaoVisivel"));
			/** Report Extent **/

		}
		
	}
	
	public static void MenuConfiguracoes() throws Exception {
		
		if (IsElementPresent("menusideweb")) {

			// Escrevendo no Console
			System.out.println("Dashboard - Menus do Dashboard estão Visiveis");

			/** Report Extent **/
			test.log(Status.PASS, "Dashboard - Menus do Dashboard estão Visiveis");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "MenuConfiguracoes-MenusDashboardVisivel"));
			/** Report Extent **/

			if (IsElementPresent("navigationcontainer_configuracoesIcon_web")) {

				// Procurando o Elemento
				WebElement menuConfiguracoes = driver.findElement(By.id("navigationcontainer_configuracoesIcon_web"));

				// Funcao HighLight
				HighLightElement(menuConfiguracoes);

				// Clicar no Menu
				menuConfiguracoes.click();
				Thread.sleep(1000); // Espera 1 segundo

				// Escrevendo no Console
				System.out.println("Dashboard - Menu Configurações");

				/** Report Extent **/
				test.log(Status.PASS, "Dashboard - Menu Configurações");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "MenuConfiguracoes-AcionadoComSucesso"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Dashboard - Menu Configurações não Visível");

				/** Report Extent **/
				test.log(Status.FAIL, "Dashboard - Menu Configurações não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "MenuConfiguracoes-NaoVisivel"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console
			System.out.println("Dashboard - Menus do Dashboard Não estão Visiveis");

			/** Report Extent **/
			test.log(Status.FAIL, "Dashboard - Menus do Dashboard Não estão Visiveis");
			test.addScreenCaptureFromPath(TakeScreenshot("ERRO", "MenuConfiguracoes-MenusDashboardNaoVisivel"));
			/** Report Extent **/

		}
		
	}
	
}
