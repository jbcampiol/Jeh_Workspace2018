package Regressao;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.Status;

//import Utilitarios.Dados_Linux;
//import Utilitarios.FuncoesReusaveis_Linux;
import Utilitarios.Dados_Windows;
import Utilitarios.FuncoesReusaveis_Windows;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TCR03_Navegacao_Site_ZaterCapitalAdmin extends FuncoesReusaveis_Windows {

	@BeforeClass
	public static void AbrirBrowser() throws Exception  {	

		// Chamando o Browser
		InitBrowser("Chrome");

		/** Report Extent **/
		StartReport("TCR03_Navegacao_Site_ZaterCapitalAdmin_TestResult");	
		test = extent.createTest("TCR03_Navegacao_Site_ZaterCapitalAdmin_Iniciar");
		test.assignCategory("Regressão");
		/** Report Extent **/

		// Chamando o Site e configurando o Browser  
		driver.get(Dados_Windows.Homologacao_Site_ZaterCapital_Admin);
		driver.manage().window().maximize(); // maximizando o browser
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // esperando por até 20 segundos

		// Pegando as URLs
		String url_site = driver.getCurrentUrl(); // URL atual
		String url_dados = Dados_Windows.Homologacao_Site_ZaterCapital_Admin; // URL da class Dados

		/** Report Extent **/
		test.log(Status.INFO, "TCR03_Navegacao_Site_ZaterCapitalAdmin_Iniciar");
		test.log(Status.PASS, "Browser Carregado com Sucesso");	
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","TCR03_Navegacao_Site_ZaterCapitalAdmin_Iniciar-AbrirSiteComSucesso"));
		/** Report Extent **/

		// Escrevendo no Console
		System.out.println(url_site);
		System.out.println(url_dados);

		// Assert para verificar se as URLs sao iguais
		//assertEquals(url_dados, url_site);	

		if (url_site.equals(url_dados) && IsElementPresent("login-form")) {	// || IsElementPresent("Zater Capital")

			// Escrevendo no Console
			System.out.println("Abrir o Browser - ADM");

			// Funcao HighLight
			HighLightElement(driver.findElement(By.id("login-form")));

			/** Report Extent **/
			test.log(Status.PASS, "Abrir o Browser - Abrir a aplicacao do ADM");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","TCR03_Navegacao_Site_ZaterCapitalAdmin_Iniciar-AbrirSiteComSucesso"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("Abrir o Browser - ERROR ao abrir Site  do ADM  Zater Capital");

			/** Report Extent **/
			test.log(Status.ERROR, "Abrir o Browser - ERROR ao abrir Site do ADM da Zater Capital");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","TCR03_Navegacao_Site_ZaterCapitalAdmin_Iniciar-ErroAbrirSite"));
			/** Report Extent **/

		}
	}

	@Test
	public void STP01_Logar_ADM() throws Exception {

		/** Report Extent **/
		test = extent.createTest("STP01_Logar_ADM");
		test.assignCategory("Regressão");
		/** Report Extent **/

		if (IsElementPresent("login-form")) {

			// Procurando o Elemento
			WebElement LoginForm = driver.findElement(By.id("login-form"));

			// Funcao HighLight
			HighLightElement(LoginForm);

			// Escrevendo no Console
			System.out.println("LoginPage - Logo ADM Visivel");

			/** Report Extent **/
			test.log(Status.PASS, "LoginPage - Logo Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP01_Logar_ADM-LoginVisivel"));
			/** Report Extent **/

			if (IsElementPresent("username")) {

				// Procurando o Elemento
				WebElement login = driver.findElement(By.id("username"));

				// Funcao HighLight
				HighLightElement(login);

				// Digitando o Usuário
				login.sendKeys(Dados_Windows.Homologacao_Admin_EMAIL);
				Thread.sleep(1000); // Espera 1 segundo

				// Escrevendo no Console
				System.out.println("LoginPage - Usuário Informado");
				System.out.println("Usuário: " + Dados_Windows.Homologacao_Admin_EMAIL);

				/** Report Extent **/
				test.log(Status.PASS, "LoginPage - Usuário Informado");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP01_Logar_ADM-UsuarioInformado"));
				/** Report Extent **/
			} else {

				// Escrevendo no Console
				System.out.println("LoginPage - Usuário Não Informado");

				/** Report Extent **/
				test.log(Status.ERROR, "LoginPage - Usuário Não Informado");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP01_Logar_ADM-UsuarioNaoInformado"));
				/** Report Extent **/

			}

			if (IsElementPresent("password")) {

				// Procurando o Elemento
				WebElement password = driver.findElement(By.id("password"));

				// Funcao HighLight
				HighLightElement(password);

				// Digitando a Senha
				password.sendKeys(Dados_Windows.Homologacao_Admin_Senha);        
				Thread.sleep(1000); // Espera 1 segundo

				/** Report Extent **/
				test.log(Status.PASS, "LoginPage - Senha Informada");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP01_Logar_ADM-SenhaInformada"));
				/** Report Extent **/

				// Escrevendo no Console
				System.out.println("LoginPage - Senha Informada");
				System.out.println("Senha: " + Dados_Windows.Producao_Exchange_Senha);

			} else {

				// Escrevendo no Console
				System.out.println("LoginPage - Senha Não Informada");

				/** Report Extent **/
				test.log(Status.ERROR, "LoginPage - Senha Não Informada");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP01_Logar_ADM-SenhaNaoInformada"));
				/** Report Extent **/

			}

			if(IsElementPresent("login-submit")) {

				// Procurando o Elemento
				WebElement ButtonLogar = driver.findElement(By.id("login-submit"));

				// Funcao HighLight
				HighLightElement(ButtonLogar);

				// Clicando no Botão LOGAR
				ButtonLogar.click();
				Thread.sleep(2000); // Espera 2 segundo

				// Escrevendo no Console
				System.out.println("LoginPage - Acionando o Botão LOGAR");

				/** Report Extent **/
				test.log(Status.PASS, "LoginPage - Acionando o Botão LOGAR");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP01_Logar_ADM-AcionarBotaoLogar"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("LoginPage - Não Acionando o Botão LOGAR");

				/** Report Extent **/
				test.log(Status.ERROR, "LoginPage - Não Acionando o Botão LOGAR");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP01_Logar_ADM-NaoAcionarBotaoLogar"));
				/** Report Extent **/

			}

		} else {

			//Escrevendo no Console
			System.out.println("LoginPage - Logo ZATERX ADM Não Visivel");

			/** Report Extent **/
			test.log(Status.ERROR, "LoginPage - Logo ZATERX ADM Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP01_Logar_ADM-LoginNaoVisivel"));
			/** Report Extent **/			

		}

	}

	@Test
	public void STP02_Navegar_Dashboard() throws Exception {

		/** Report Extent **/
		test = extent.createTest("STP02_Navegar_Dashboard");
		test.assignCategory("Regressão");
		/** Report Extent **/

		if(IsElementPresent("menu-content")) {

			// Escrevendo no Console
			System.out.println("Dashboard - Visivel");

			/** Report Extent **/
			test.log(Status.PASS, "Dashboard - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP02_Navegar_Dashboard-DashboardVisivel"));
			/** Report Extent **/

			if (driver.findElement(By.xpath("//*[@id='content']/div/div/div/div/div[1]/h1[1]")).getAttribute("innerText").contains("DASHBOARD")) {

				// Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("//*[@id='content']/div/div/div/div/div[1]/h1[1]")));

				// Escrevendo no Console
				System.out.println("Assert: " + driver.findElement(By.xpath("//*[@id='content']/div/div/div/div/div[1]/h1[1]")).getText());

				/** Report Extent **/
				test.log(Status.PASS, "Assert: " + driver.findElement(By.xpath("//*[@id='content']/div/div/div/div/div[1]/h1[1]")).getText());
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP02_Navegar_Dashboard-DashboardVisivel"));
				/** Report Extent **/


				/*


				//BTC TAXAS//	
				// Verifica se o texto e verdadeiro 
				assertEquals("BTC TAXAS:", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[1]/div/div[1]")).getText());
				assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[1]/div/div[1]")).getText(),true);

				//Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[1]/div/div[1]")));

				//Escrevendo no console 
				System.out.println("Assert: " + driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[1]/div/div[1]")).getText());

				//BTC EM NEGOCIACAO//		
				// Verifica se o texto e verdadeiro 
				assertEquals("BTC EM NEGOCIAÇÕES:", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[2]/div/div[1]")).getText());
				assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[2]/div/div[1]")).getText(),true);

				//Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[2]/div/div[1]")));

				// Verifica se o texto e verdadeiro 
				System.out.println("Assert: " + driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[2]/div/div[1]")).getText());

				//BTC TOTAL NA APLICACAO//
				// Verifica se o texto e verdadeiro 
				assertEquals("BTC TOTAL NA APLICAÇÃO:", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[3]/div/div[1]")).getText());
				assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[3]/div/div[1]")).getText(),true);

				//Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[3]/div/div[1]")));

				//Escrevendo no console 
				System.out.println("Assert: " + driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[3]/div/div[1]")).getText());

				//DINHEIRO TOTAL//
				// Verifica se o texto e verdadeiro 
				assertEquals("DINHEIRO TAXAS:", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[4]/div/div[1]")).getText());
				assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[4]/div/div[1]")).getText(),true);

				//Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[4]/div/div[1]")));

				//Escrevendo no console 
				System.out.println("Assert: " + driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[4]/div/div[1]")).getText());

				//DINHEIRO EM NEGOCIAÇÕES//
				// Verifica se o texto e verdadeiro 
				assertEquals("DINHEIRO EM NEGOCIAÇÕES:", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[5]/div/div[1]")).getText());
				assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[5]/div/div[1]")).getText(),true);

				//Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[5]/div/div[1]")));

				//Escrevendo no console 
				System.out.println("Assert: " + driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[5]/div/div[1]")).getText());

				//DINHEIRO TOTAL NA APLICAÇÃO://
				// Verifica se o texto e verdadeiro 
				assertEquals("DINHEIRO TOTAL NA APLICAÇÃO:", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[6]/div/div[1]")).getText());
				assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[6]/div/div[1]")).getText(),true);

				//Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[6]/div/div[1]")));

				//Escrevendo no console 
				System.out.println("Assert: " + driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[6]/div/div[1]")).getText());

				//AGUARDANDO DOCUMENTOS://
				// Verifica se o texto e verdadeiro 
				assertEquals("AGUARDANDO DOCUMENTOS:", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[7]/div/div/div[1]")).getText());
				assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[7]/div/div/div[1]")).getText(),true);

				//Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[7]/div/div/div[1]")));

				//Escrevendo no console 
				System.out.println("Assert: " + driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[7]/div/div/div[1]")).getText());

				//APROVADOS://
				// Verifica se o texto e verdadeiro 
				assertEquals("APROVADOS:", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[8]/div[1]/div/div[1]")).getText());
				assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[8]/div[1]/div/div[1]")).getText(),true);

				//Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[8]/div[1]/div/div[1]")));

				//Escrevendo no console 
				System.out.println("Assert: " + driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[8]/div[1]/div/div[1]")).getText());

				//NOVOS CADASTROS://
				// Verifica se o texto e verdadeiro 
				assertEquals("NOVOS CADASTROS:", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[9]/div/div[1]")).getText());
				assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[9]/div/div[1]")).getText(),true);

				//Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[9]/div/div[1]")));

				//Escrevendo no console 
				System.out.println("Assert: " + driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[9]/div/div[1]")).getText());


				 */


			} else {

				// Escrevendo no Console
				System.out.println("Dashboard - Assert Não Visivel");

				/** Report Extent **/
				test.log(Status.ERROR, "Dashboard - Assert Não Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP02_Navegar_Dashboard-DashboardAssertNaoVisivel"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console
			System.out.println("Dashboard - Não Visivel");

			/** Report Extent **/
			test.log(Status.ERROR, "Dashboard - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP02_Navegar_Dashboard-DashboardNaoVisivel"));
			/** Report Extent **/

		}
	}

	@Test
	public void STP03_Navegar_Cliente() throws Exception {

		/** Report Extent **/
		test = extent.createTest("STP03_Navegar_Cliente");
		test.assignCategory("Regressão");
		/** Report Extent **/

		//Verifica se elemento esta presente 
		if (IsElementPresent("//*[@id='menu-content']/a[2]/li")) {

			//Atribuindo xpth do webElement a variavel Cliente 
			WebElement Cliente = driver.findElement(By.xpath("//*[@id='menu-content']/a[2]/li"));

			//Funcao HighLight
			HighLightElement(Cliente);

			// Clicar no MENu 'Clientes'
			Cliente.click();
			Thread.sleep(1000); // Esperar 1 segundo

			// Escrevendo no Console
			System.out.println("MENU Clientes - Visivel");

			/** Report Extent **/
			test.log(Status.PASS, "MENU Clientes - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_Navegar_Cliente-MenuClientesVisivel"));
			/** Report Extent **/

			if (driver.findElement(By.xpath("//*[@class='page-header']")).getAttribute("innerText").contains("CLIENTES")) {

				// Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div/div/div[1]/h1")));

				// Escrevendo no Console
				System.out.println("Clientes - Visivel");

				/** Report Extent **/
				test.log(Status.PASS, "Clientes - Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_Navegar_Cliente-ClientesVisivel"));
				/** Report Extent **/


				/*

				//CPF://
				//Verifica se texto existe 
				assertEquals("CPF", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[1]")).getText());
				assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[1]")).getText(),true);

				//Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[1]")));

				//Escreve no console 
				System.out.println("Assert: " + driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[1]")).getText());

				//CNPJ://
				//Verifica se texto existe 
				assertEquals("CNPJ", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[2]")).getText());
				assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[2]")).getText(),true);

				//Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[2]")));

				//Escreve no console 
				System.out.println("Assert: " + driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[2]")).getText());

				//Email://
				//Verifica se texto existe 
				assertEquals("E-mail", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[3]")).getText());
				assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[3]")).getText(),true);

				//Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[3]")));

				//Escreve no console 
				System.out.println("Assert: " + driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[3]")).getText());

				//Status://
				//Verifica se texto existe 
				assertEquals("Status", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[4]")).getText());
				assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[4]")).getText(),true);

				//Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[4]")));

				//Escreve no console 
				System.out.println("Assert: " + driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[4]")).getText());

				//Descrição://
				//Verifica se texto existe 
				assertEquals("Descrição", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[5]")).getText());
				assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[5]")).getText(),true);

				//Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[5]")));

				//Escreve no console 
				System.out.println("Assert: " + driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[5]")).getText());

				//Verifica se texto existe 
				assertEquals("Criado em", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[6]")).getText());
				assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[6]")).getText(),true);

				//Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[6]")));

				//Escreve no console 
				System.out.println("Assert: " + driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[6]")).getText());

				 */


			} else {

				// Escrevendo no Console
				System.out.println("Clientes - Não Visivel");

				/** Report Extent **/
				test.log(Status.ERROR, "Clientes - Não Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_Navegar_Cliente-ClientesNaoVisivel"));
				/** Report Extent **/

			}

		}else {

			// Escrevendo no Console
			System.out.println("MENU Clientes - Não Visivel");

			/** Report Extent **/
			test.log(Status.ERROR, "MENU Clientes - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_Navegar_Cliente-MenuClientesNaoVisivel"));
			/** Report Extent **/

		}

	}

	@Test
	public void STP04_Navegar_Bancos() throws Exception{

		/** Report Extent **/
		test = extent.createTest("STP04_Navegar_Bancos");
		test.assignCategory("Regressão");
		/** Report Extent **/

		//Verifica se elemento esta presente 
		if(IsElementPresent("//*[@id='menu-content']/a[3]/li")) {

			//Atribui o xpath a variavel bancos 
			WebElement MenuBancos = driver.findElement(By.xpath("//*[@id='menu-content']/a[3]/li"));

			//Funcao HighLight
			HighLightElement(MenuBancos);

			// Clicar no MENU 'Bancos'
			MenuBancos.click();
			Thread.sleep(1000); // Esperar 1 segundo

			// Escrevendo no Console
			System.out.println("MENU Bancos - Visivel");

			/** Report Extent **/
			test.log(Status.PASS, "MENU Bancos - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_Navegar_Bancos-MenuBancosVisivel"));
			/** Report Extent **/

			if (driver.findElement(By.xpath("//*[@class='page-header']")).getAttribute("innerText").contains("BANCOS")) {

				// Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div/div/div[1]/h1")));

				// Escrevendo no Console
				System.out.println("Bancos - Visivel");

				/** Report Extent **/
				test.log(Status.PASS, "Bancos - Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_Navegar_Bancos-BancosVisivel"));
				/** Report Extent **/



				/*

				//Verifica se texto e verdadeiro 
				assertEquals("BANCOS", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[1]/h1")).getText());
				assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[1]/h1")).getText(),true);

				//Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[1]/h1")));
				System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[1]/h1")).getText());

				//Verifica se texto e verdadeiro 
				assertEquals("Nome Banco", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[1]")).getText());
				assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[1]")).getText(),true);

				//Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[1]")));
				System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[1]")).getText());

				//Verifica se texto e verdadeiro 
				assertEquals("Número", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[2]")).getText());
				assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[2]")).getText(),true);

				//Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[2]")));
				System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[2]")).getText());

				//Verifica se texto e verdadeiro 
				assertEquals("Conta Corrente", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[3]")).getText());
				assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[3]")).getText(),true);

				//Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[3]")));
				System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[3]")).getText());

				//Verifica se texto e verdadeiro 
				assertEquals("Número Agência", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[4]")).getText());
				assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[4]")).getText(),true);

				//Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[4]")));
				System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[4]")).getText());

				 */



				if (IsElementPresent("//*[@id='content']/div/div[1]/div/div/div[1]/a")) {

					//Atribui o xpath a variavel Cdbancos 
					WebElement BotaoCadastrarBancos = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div/div/div[1]/a"));

					// Funcao HighLight
					HighLightElement(BotaoCadastrarBancos); 

					// Clicar no Botão 'Cadastrar Bancos'
					BotaoCadastrarBancos.click();
					Thread.sleep(1000); // Esperar 1 segundo 

					// Escrevendo no Console
					System.out.println("Botão 'Cadastrar Bancos' - Visivel");

					/** Report Extent **/
					test.log(Status.PASS, "Botão 'Cadastrar Bancos' - Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_Navegar_Bancos-BotaoCadastrarBancosVisivel"));
					/** Report Extent **/


					/*

					//Verifica se texto e verdadeiro 
					assertEquals("Cadatrar Taxa de Depósito", driver.findElement(By.xpath("//*[@id=\"mycreateRegister\"]")).getText());
					assertTrue(driver.findElement(By.xpath("//*[@id=\"mycreateRegister\"]")).getText(),true);

					//Funcao HighLight
					HighLightElement(driver.findElement(By.xpath("//*[@id=\"mycreateRegister\"]")));
					System.out.println(driver.findElement(By.xpath("//*[@id=\"mycreateRegister\"]")).getText());
					//*[@id="mycreateRegister"]


					 */

					if (IsElementPresent("register-form")) {

						//Atribui o xpath a variavel
						WebElement Formumario = driver.findElement(By.id("register-form"));
						WebElement FecharFormumario = driver.findElement(By.xpath("//button[@class='close']"));

						// Funcao HighLight
						HighLightElement(Formumario);
						HighLightElement(FecharFormumario); 

						// Clicar no Botão 'Fechar'
						FecharFormumario.click();
						Thread.sleep(1000); // Esperar 1 segundo 

						// Escrevendo no Console
						System.out.println("Botão 'Fechar' - Visivel");

						/** Report Extent **/
						test.log(Status.PASS, "Botão 'Fechar' - Visivel");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_Navegar_Bancos-BotaoFecharVisivel"));
						/** Report Extent **/

					} else {

						// Escrevendo no Console
						System.out.println("Botão 'Fechar' - Não Visivel");

						/** Report Extent **/
						test.log(Status.ERROR, "Botão 'Fechar' - Não Visivel");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_Navegar_Bancos-BotaoFecharNaoVisivel"));
						/** Report Extent **/

					}


				} else {

					// Escrevendo no Console
					System.out.println("Botão 'Cadastrar Bancos' - Não Visivel");

					/** Report Extent **/
					test.log(Status.ERROR, "Botão 'Cadastrar Bancos' - Não Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_Navegar_Bancos-BotaoCadastrarBancosNaoVisivel"));
					/** Report Extent **/

				}			

			} else {

				// Escrevendo no Console
				System.out.println("Bancos - Não Visivel");

				/** Report Extent **/
				test.log(Status.ERROR, "Bancos - Não Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_Navegar_Bancos-BancosNaoVisivel"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console
			System.out.println("MENU Bancos - Não Visivel");

			/** Report Extent **/
			test.log(Status.ERROR, "MENU Bancos - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_Navegar_Bancos-MenuBancosNaoVisivel"));
			/** Report Extent **/

		}

	}        

	@Test    
	public void STP05_Navegar_Saques() throws Exception{
	
		/** Report Extent **/
		test = extent.createTest("STP05_Navegar_Saques");
		test.assignCategory("Regressão");
		/** Report Extent **/

		//Verifica Elemento se esta visivel 
		if(IsElementPresent("//*[@id='menu-content']/a[4]/li")) {

			//Atribuindo xpath a variavel saque 
			WebElement MenuSaques = driver.findElement(By.xpath("//*[@id='menu-content']/a[4]/li"));

			//Funcao HighLight 
			HighLightElement(MenuSaques);
            
			// Clicar no MENU 'Saque'
			MenuSaques.click();
			Thread.sleep(1000); // Esperar 1 segundo
			
			// Escrevendo no Console
			System.out.println("MENU Saques - Visivel");

			/** Report Extent **/
			test.log(Status.PASS, "MENU Saques - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_Navegar_Saques-MENUSaquesVisivel"));
			/** Report Extent **/
						
			if (driver.findElement(By.xpath("//*[@class='page-header ng-binding ng-scope']")).getAttribute("innerText").contains("SAQUES")) {
				
				// Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div/div/div[1]/h1")));

				// Escrevendo no Console
				System.out.println("Saque - Visivel");

				/** Report Extent **/
				test.log(Status.PASS, "Saques - Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_Navegar_Saques-SaquesVisivel"));
				/** Report Extent **/

				
				//			//Verifica se o elemento e  verdadeiro 
				//			assertEquals("Data", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[1]")).getText());
				//			assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[1]")).getText(),true);
				//
				//			//Funcao HighLight
				//			HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[1]")));
				//			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[1]")).getText());
				//
				//			//Verifica se o elemento e  verdadeiro 
				//			assertEquals("Valor", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[2]")).getText());
				//			assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[2]")).getText(),true);
				//
				//			//Funcao HighLight
				//			HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[2]")));
				//			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[2]")).getText());
				//
				//			//Verifica se o elemento e  verdadeiro 
				//			assertEquals("Cliente", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[3]")).getText());
				//			assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[3]")).getText(),true);
				//
				//			//Funcao HighLight
				//			HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[3]")));
				//			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[3]")).getText());
				//
				//			//Verifica se o elemento e  verdadeiro 
				//			assertEquals("Status", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[4]")).getText());
				//			assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[4]")).getText(),true);
				//
				//			//Funcao HighLight
				//			HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[4]")));
				//			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[4]")).getText());
		
				
			} else {
				
				//Escreve no console 
				System.out.println("Saques não Visível");
				
				/** Report Extent **/
				test.log(Status.ERROR, "Saques não Visível");
				test.addScreenCaptureFromPath("Erro" , "STP05_Navegar_Saques-SaqueNaoVisivel");
				/** Report Extent **/
				
			}
			
		} else {
			
			//Escreve no console 
			System.out.println("MENU Saques - Não Visivel");
			
			/** Report Extent **/
			test.log(Status.ERROR, "MENU Saques - Não Visivel");
			test.addScreenCaptureFromPath("Erro" , "STP05_Navegar_Saques-MenuSaqueNaoVisivel");
			/** Report Extent **/

		}
	}

	@Test
	public void STP06_Navegar_Deposito() throws Exception{
        
		/** Report Extent **/
		test = extent.createTest("STP06_Navegar_Deposito");
		test.assignCategory("Regressão");
		/** Report Extent **/
          
		//Verifica se elemento e visivel  
		if(IsElementPresent("//*[@id='menu-content']/a[5]/li")) {
        
			//Atribui o xpath a variqvel
			WebElement MenuDeposito = driver.findElement(By.xpath("//*[@id='menu-content']/a[5]/li"));
            
			//Funcao HighLight 
			HighLightElement(MenuDeposito);
            
			// Clicar no MENU 'Deposito'
			MenuDeposito.click();
			Thread.sleep(1000); // Esperar 1 segundo
			
			// Escrevendo no Console
			System.out.println("MENU Depositos - Visivel");

			/** Report Extent **/
			test.log(Status.PASS, "MENU Depositos - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP06_Navegar_Deposito-MENUDepositosVisivel"));
			/** Report Extent **/
			
			if (driver.findElement(By.xpath("//*[@class='page-header ng-binding ng-scope']")).getAttribute("innerText").contains("DEPÓSITO")) {
				
				// Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div/div/div[1]/h1")));
	
				//Escreve no console 
				System.out.println("Depósitos Visível");
				
				/** Report Extent **/
				test.log(Status.PASS, "Depósitos Visível");
				test.addScreenCaptureFromPath("Sucesso" , "STP06_Navegar_Deposito-DepositosVisivel");
				/** Report Extent **/
					
				//			//Verifica se elemento e verdadeiro 
				//			assertEquals("Data", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[1]")).getText());
				//			assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[1]")).getText(),true);
				//
				//			//Funcao HighLight
				//			HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[1]")));
				//			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[1]")).getText());
				//
				//			//Verifica se elemento e verdadeiro 
				//			assertEquals("Valor", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[2]")).getText());
				//			assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[2]")).getText(),true);
				//
				//			//Funcao HighLight
				//			HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[2]")));
				//			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[2]")).getText());
				//
				//			//Verifica se elemento e verdadeiro 
				//			assertEquals("Email", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[3]")).getText());
				//			assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[3]")).getText(),true);
				//
				//			//Funcao HighLight
				//			HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[3]")));
				//			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[3]")).getText());
				//
				//			//Verifica se elemento e verdadeiro 
				//			assertEquals("Cliente", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[4]")).getText());
				//			assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[4]")).getText(),true);
				//
				//			//Funcao HighLight
				//			HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[4]")));
				//			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[4]")).getText());
				
			} else {
				
				//Escreve no console 
				System.out.println("Depósitos não Visível");
				
				/** Report Extent **/
				test.log(Status.ERROR, "Depósitos não Visível");
				test.addScreenCaptureFromPath("Erro" , "STP06_Navegar_Deposito-DepositosNaoVisivel");
				/** Report Extent **/
			
			}
			
		} else {
			
			// Escrevendo no Console
			System.out.println("MENU Depositos - Não Visivel");

			/** Report Extent **/
			test.log(Status.ERROR, "MENU Depositos - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP06_Navegar_Deposito-MenuDepositosNaoVisivel"));
			/** Report Extent **/
			
		}

}

	@Test
	public void STP07_Navegar_Taxas() throws Exception{

		/** Report Extent **/
		test = extent.createTest("STP07_Navegar_Taxas");
		test.assignCategory("Regressão");
		/** Report Extent **/

		//Verifica se elemento e visivel  
		if(IsElementPresent("//*[@id='menu-content']/a[6]/li")) {

			//Atribui o xpath a variqvel
			WebElement MenuTaxas = driver.findElement(By.xpath("//*[@id='menu-content']/a[6]/li"));

			//Funcao HighLight 
			HighLightElement(MenuTaxas);

			// Clicar no MENU 'Taxas'
			MenuTaxas.click();
			Thread.sleep(1000); // Esperar 1 segundo

			// Escrevendo no Console
			System.out.println("MENU Taxas - Visivel");

			/** Report Extent **/
			test.log(Status.PASS, "MENU Taxas - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP07_Navegar_Taxas-MenuTaxasVisivel"));
			/** Report Extent **/

			if (driver.findElement(By.xpath("//*[@class='page-header']")).getAttribute("innerText").contains("TAXA DE DEPÓSITO")) {

				// Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div/div/div[1]/h1")));

				//Escreve no console 
				System.out.println("Taxas Visível");

				/** Report Extent **/
				test.log(Status.PASS, "Taxas Visível");
				test.addScreenCaptureFromPath("Sucesso" , "STP07_Navegar_Taxas-TaxasVisivel");
				/** Report Extent **/

				//			//Verifica se elemento e verdadeiro 
				//			assertEquals("Conta", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[1]")).getText());
				//			assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[1]")).getText(),true);
				//
				//			//Funcao HighLight 
				//			HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[1]")));
				//			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[1]")).getText());
				//
				//			//Verifica se elemento e verdadeiro 
				//			assertEquals("Tipo", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[2]")).getText());
				//			assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[2]")).getText(),true);
				//
				//			//Funcao HighLight 
				//			HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[2]")));
				//			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[2]")).getText());
				//
				//			//Verifica se elemento e verdadeiro 
				//			assertEquals("Operações", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[3]")).getText());
				//			assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[3]")).getText(),true);
				//
				//			//Funcao HighLight 
				//			HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[3]")));
				//			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[3]")).getText());
				//
				//			//Verifica se elemento e verdadeiro 
				//			assertEquals("Passiva", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[4]")).getText());
				//			assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[4]")).getText(),true);
				//
				//			//Funcao HighLight 
				//			HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[4]")));
				//			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[4]")).getText());
				//
				//			//Verifica se elemento e verdadeiro 
				//			assertEquals("Ativa", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[5]")).getText());
				//			assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[5]")).getText(),true);
				//
				//			//Funcao HighLight 
				//			HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[5]")));
				//			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[5]")).getText());
				//
				//			//Verifica se elemento e verdadeiro 
				//			assertEquals("Fixa", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[6]")).getText());
				//			assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div/table/thead/tr/th[6]")).getText(),true);

				if (IsElementPresent("//*[@class='btn btn-primary pull-right btn-admission']")) {

					//Atribui o xpath a variqvel
					WebElement BotaoCadastrarTaxa = driver.findElement(By.xpath("//*[@class='btn btn-primary pull-right btn-admission']"));

					//Funcao HighLight 
					HighLightElement(BotaoCadastrarTaxa);

					// Clicar no MENU 'Taxas'
					BotaoCadastrarTaxa.click();
					Thread.sleep(1000); // Esperar 1 segundo

					// Escrevendo no Console
					System.out.println("Botão 'Cadastrar Taxa de Depósito' - Visivel");

					/** Report Extent **/
					test.log(Status.PASS, "Botão 'Cadastrar Taxa de Depósito' - Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP07_Navegar_Taxas-BotaoCadastrarTaxaVisivel"));
					/** Report Extent **/

					if (IsElementPresent("//*[@class='close']")) {

						//Atribui o xpath a variqvel
						WebElement BotaoFechar = driver.findElement(By.xpath("//*[@class='close']"));

						//Funcao HighLight 
						HighLightElement(BotaoFechar);

						// Clicar no MENU 'Fechar'
						BotaoFechar.click();
						Thread.sleep(1000); // Esperar 1 segundo

						// Escrevendo no Console
						System.out.println("Botão 'Fechar' - Visivel");

						/** Report Extent **/
						test.log(Status.PASS, "Botão 'Fechar' - Visivel");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP07_Navegar_Taxas-BotaoFecharVisivel"));
						/** Report Extent **/

					} else {

						// Escrevendo no Console
						System.out.println("Botão 'Fechar' - Não Visivel");

						/** Report Extent **/
						test.log(Status.ERROR, "Botão 'Fechar' - Não Visivel");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP07_Navegar_Taxas-BotaoFecharNaoVisivel"));
						/** Report Extent **/

					}


				} else {

					// Escrevendo no Console
					System.out.println("Botão 'Cadastrar Taxa de Depósito' - Não Visivel");

					/** Report Extent **/
					test.log(Status.ERROR, "Botão 'Cadastrar Taxa de Depósito' - Não Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP07_Navegar_Taxas-BotaoCadastrarTaxaNaoVisivel"));
					/** Report Extent **/

				}

			} else {

				//Escreve no console 
				System.out.println("Taxas Não Visível");

				/** Report Extent **/
				test.log(Status.ERROR, "Taxas Não Visível");
				test.addScreenCaptureFromPath("Erro" , "STP07_Navegar_Taxas-TaxasNaoVisivel");
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console
			System.out.println("MENU Taxas - Não Visivel");

			/** Report Extent **/
			test.log(Status.ERROR, "MENU Taxas - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP07_Navegar_Taxas-MenuTaxasNaoVisivel"));
			/** Report Extent **/

		}

	}

	@Test
	public void STP08_Navegar_Automatizacoes() throws Exception{

		/** Report Extent **/
		test = extent.createTest("STP08_Navegar_Automatizacoes");
		test.assignCategory("Regressão");
		/** Report Extent **/

		//Verifica se elemento e visivel  
		if(IsElementPresent("//*[@id='menu-content']/a[7]/li")) {

			//Atribui o xpath a variqvel
			WebElement MenuRelatorios = driver.findElement(By.xpath("//*[@id='menu-content']/a[7]/li"));

			//Funcao HighLight 
			HighLightElement(MenuRelatorios);

			// Clicar no MENU 'Relatórios'
			MenuRelatorios.click();
			Thread.sleep(1000); // Esperar 1 segundo

			// Escrevendo no Console
			System.out.println("MENU Relatórios - Visivel");

			/** Report Extent **/
			test.log(Status.PASS, "MENU Relatórios - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP08_Navegar_Automatizacoes-MenuRelatoriosVisivel"));
			/** Report Extent **/
			
			if (driver.findElement(By.xpath("//*[@class='page-header']")).getAttribute("innerText").contains("CLIENTES")) {

				// Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div/div/div[1]/h1")));

				//Escreve no console 
				System.out.println("Relatório Visível");

				/** Report Extent **/
				test.log(Status.PASS, "Relatório Visível");
				test.addScreenCaptureFromPath("Sucesso" , "STP08_Navegar_Automatizacoes-RelatorioVisivel");
				/** Report Extent **/
			

									//Verifica se elemento e verdadeiro 
						//			assertEquals("Valor:", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/fieldset/div[1]/label")).getText());
						//			assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/fieldset/div[1]/label")).getText(),true);
						//
						//			//Funcao HighLight 
						//			HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/fieldset/div[1]/label")));
						//			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/fieldset/div[1]/label")).getText());
						//
						//			//Verifica se elemento e verdadeiro 
						//			assertEquals("Quantidade de Compras:", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/fieldset/div[2]/label")).getText());
						//			assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/fieldset/div[2]/label")).getText(),true);
						//
						//			//Funcao HighLight 
						//			HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/fieldset/div[2]/label")));
						//			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/fieldset/div[2]/label")).getText());
						//
						//			//Verifica se elemento e verdadeiro 
						//			assertEquals("Quantidade de Vendas:", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/fieldset/div[3]/label")).getText());
						//			assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/fieldset/div[3]/label")).getText(),true);
						//
						//			//Funcao HighLight 
						//			HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/fieldset/div[3]/label")));
						//			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/fieldset/div[3]/label")).getText());
						//
						//			//Verifica se elemento e verdadeiro 
						//			assertEquals("Cadência:", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/fieldset/div[4]/label")).getText());
						//			assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/fieldset/div[4]/label")).getText(),true);
						//
						//			//Funcao HighLight 
						//			HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/fieldset/div[4]/label")));
						//			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/fieldset/div[4]/label")).getText());
						//
						//			//Verifica se elemento e verdadeiro 
						//			assertEquals("Transações Total:", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[3]/form/fieldset/div[1]/label")).getText());
						//			assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[3]/form/fieldset/div[1]/label")).getText(),true);
						//
						//			//Funcao HighLight 
						//			HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[3]/form/fieldset/div[1]/label")));
						//			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[3]/form/fieldset/div[1]/label")).getText());
						//
						//			//Verifica se elemento e verdadeiro 
						//			assertEquals("Espaço de tempo:", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[3]/form/fieldset/div[2]/label")).getText());
						//			assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[3]/form/fieldset/div[2]/label")).getText(),true);
						//
						//			//Funcao HighLight 
						//			HighLightElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[3]/form/fieldset/div[2]/label")));
						//			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[3]/form/fieldset/div[2]/label")).getText());
				
				if (IsElementPresent("//button[text()='Exportar']")) {
					
					//Atribui o xpath a variqvel
					WebElement BotaoExportar = driver.findElement(By.xpath("//button[text()='Exportar']"));

					//Funcao HighLight 
					HighLightElement(BotaoExportar);

					// Clicar no Botão 'Exportar'
					BotaoExportar.click();
					Thread.sleep(1000); // Esperar 1 segundo

					// Escrevendo no Console
					System.out.println("Botão 'Exportar' - Visivel");

					/** Report Extent **/
					test.log(Status.PASS, "Botão 'Exportar' - Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP08_Navegar_Automatizacoes-BotaoExportarVisivel"));
					/** Report Extent **/
					
				} else {
					
					//Escreve no console 
					System.out.println("Botão 'Exportar' Não Visível");

					/** Report Extent **/
					test.log(Status.ERROR, "Botão 'Exportar' Não Visível");
					test.addScreenCaptureFromPath("Erro" , "STP08_Navegar_Automatizacoes-BotaoExportarNaoVisivel");
					/** Report Extent **/
					
				}
					
			} else {
				
				//Escreve no console 
				System.out.println("Relatório Não Visível");

				/** Report Extent **/
				test.log(Status.ERROR, "Relatório Não Visível");
				test.addScreenCaptureFromPath("Erro" , "STP08_Navegar_Automatizacoes-RelatorioNaoVisivel");
				/** Report Extent **/
				
			}

		} else {

			// Escrevendo no Console
			System.out.println("MENU Relatórios - Não Visivel");
			
			/** Report Extent **/
			test.log(Status.ERROR, "MENU Relatórios - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP08_Navegar_Automatizacoes-MenuRelatoriosNaoVisivel"));
			/** Report Extent **/

		}

	}

	@Test
	public void STP99_Logout_ADM () throws Exception {

		/** Report Extent **/
		test = extent.createTest("STP99_Logout_ADM");
		test.assignCategory("Regressão");
		/** Report Extent **/

		//Verifica se elemento e visivel  
		if (IsElementEnabled("//button[@class='pull-right btn btn-primary btn-oirh-header']")) {

			// Atribui o xpath a variqvel sair 
			WebElement Sair = driver.findElement(By.xpath("//button[@class='pull-right btn btn-primary btn-oirh-header']"));

			// Funcao HighLight 
			HighLightElement(Sair);

			// Clicar no Botão 'Sair'
			Sair.click();
			Thread.sleep(1000); // Esperar 1 segundo

			// Escrevendo no Console
			System.out.println("Acionar o Botão 'Sair'");

			/** Report Extent **/
			test.log(Status.PASS, "Acionar o Botão 'Sair'");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP99_Logout_ADM-AcionarBotaoSair"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("Botão 'Sair' - Não Visível");

			/** Report Extent **/
			test.log(Status.ERROR, "Botão 'Sair' - Não Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP99_Logout_ADM-BotaoSairNaoVisivel"));
			/** Report Extent **/

		}
	}

	@AfterClass
	public static void FecharBrowser() throws Exception {

		// Escrevendo no Console
		System.out.println("Fechar o Browser");

		/** Report Extent **/
		test = extent.createTest("TCR03_Navegacao_Site_ZaterCapitalAdmin_Finalizar");
		test.assignCategory("Regressão");
		/** Report Extent **/

		/** Report Extent **/
		test.log(Status.PASS, "Browser Encerrado com Sucesso");
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","TCR03_Navegacao_Site_ZaterCapitalAdmin_Finalizar-EncerrarSiteComSucesso"));
		/** Report Extent **/

		// Encerra o Report
		extent.flush();

		// Fechar o Browser
		driver.quit();
		//driver.close();

	}

}




