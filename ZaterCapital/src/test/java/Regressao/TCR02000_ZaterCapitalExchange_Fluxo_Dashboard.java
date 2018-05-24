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
public class TCR02000_ZaterCapitalExchange_Fluxo_Dashboard extends FuncoesReusaveis_Windows {
	
	@BeforeClass
	public static void AbrirBrowser() throws Exception {
					
		// Chamando o Browser
		InitBrowser("Chrome");
		
		/** Report Extent **/
		StartReport("TCR02000_ZaterCapitalExchange_Fluxo_Dashboard_TestResult");	
		test = extent.createTest("TCR02000_ZaterCapitalExchange_Fluxo_Dashboard_Iniciar");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		// Chamando o Site e configurando o Browser  
		//driver.navigate().to(Dados.Producao_Site_ZaterCapital);	// chamando o site
		//driver.get(Dados_Windows.Homologacao_Site_ZaterCapital_Exchange);
		driver.get("http://localhost:3000/authentication");
		driver.manage().window().maximize(); // maximizando o browser
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // esperando por até 20 segundos
		
		// Pegando as URLs
		String url_site = driver.getCurrentUrl(); // URL atual
		String url_dados = "http://localhost:3000/authentication";
		//String url_dados = Dados_Windows.Homologacao_Site_ZaterCapital_Exchange; // URL da class Dados
		
		/** Report Extent **/
		test.log(Status.INFO, "TCR02000_ZaterCapitalExchange_Fluxo_Dashboard_Iniciar");
		test.log(Status.PASS, "Browser Carregado com Sucesso");	
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","TCR02000_ZaterCapitalExchange_Fluxo_Dashboard-AbrirSiteComSucesso"));
		/** Report Extent **/
		
		// Escrevendo no Console
		System.out.println(url_site);
		System.out.println(url_dados);
		
		// Assert para verificar se as URLs sao iguais
		//assertEquals(url_dados, url_site);
		
		if (url_site.equals(url_dados) && IsElementPresent("btn-logar")) {	// || IsElementPresent("Zater Capital")
		
		// Escrevendo no Console
		System.out.println("Abrir o Browser - Abrir o Site da Exchange da Zater Capital");
		
		/** Report Extent **/
		test.log(Status.PASS, "Abrir o Browser - Abrir o Site da Exchange da Zater Capital");
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","TCR02000_ZaterCapitalExchange_Fluxo_Dashboard_Iniciar-AbrirSiteComSucesso"));
		/** Report Extent **/
		
		} else {
								
			// Escrevendo no Console
			System.out.println("Abrir o Browser - ERROR ao abrir Site da Exchange da Zater Capital");
			
			/** Report Extent **/
			test.log(Status.ERROR, "Abrir o Browser - ERROR ao abrir Site da Exchange da Zater Capital");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","TCR02000_ZaterCapitalExchange_Fluxo_Dashboard_Iniciar-ErroAbrirSite"));
			/** Report Extent **/
			
		}
		
	}

	@Test
	public void STP01_000_LogarExchange() throws Exception {
	
		/** Report Extent **/
		test = extent.createTest("STP01_000_LogarExchange");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		if (IsElementPresent("Page-1")) {
			
			// Escrevendo no Console
			System.out.println("LoginPage - Logo ZATERX Visivel");
			
			/** Report Extent **/
			test.log(Status.PASS, "LoginPage - Logo Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP01_000_LogarExchange-LoginVisivel"));
			/** Report Extent **/

			if (IsElementPresent("inputEmail3")) {

				// Procurando o Elemento
				WebElement Login = driver.findElement(By.id("inputEmail3"));

				// Funcao HighLight
				HighLightElement(Login);

				// Digitando o Usuário
				Login.sendKeys(Dados_Windows.Homologacao_Exchange_EMAIL);
				Thread.sleep(1000); // Espera 1 segundo
				
				/** Report Extent **/
				test.log(Status.PASS, "LoginPage - Usuário Informado");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP01_000_LogarExchange-UsuarioInformado"));
				/** Report Extent **/

				// Escrevendo no Console
				System.out.println("LoginPage - Usuário Informado");
				System.out.println("Usuário: " + Dados_Windows.Homologacao_Exchange_EMAIL);
				
			} else {

				// Escrevendo no Console
				System.out.println("LoginPage - Usuário Não Informado");
				
				/** Report Extent **/
				test.log(Status.ERROR, "LoginPage - Usuário Não Informado");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP01_000_LogarExchange-UsuarioNaoInformado"));
				/** Report Extent **/

			}

			if (IsElementPresent("inputPassword3")) {

				// Procurando o Elemento
				WebElement Password = driver.findElement(By.id("inputPassword3"));

				// Funcao HighLight
				HighLightElement(Password);

				// Digitando a Senha
				Password.sendKeys(Dados_Windows.Homologacao_Exchange_Senha);        
				Thread.sleep(1000); // Espera 1 segundo

				/** Report Extent **/
				test.log(Status.PASS, "LoginPage - Senha Informada");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP01_000_LogarExchange-SenhaInformada"));
				/** Report Extent **/
				
				// Escrevendo no Console
				System.out.println("LoginPage - Senha Informada");
				System.out.println("Senha: " + Dados_Windows.Homologacao_Exchange_Senha);

			} else {

				// Escrevendo no Console
				System.out.println("LoginPage - Senha Não Informada");
				
				/** Report Extent **/
				test.log(Status.ERROR, "LoginPage - Senha Não Informada");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP01_000_LogarExchange-SenhaNaoInformada"));
				/** Report Extent **/

			}
			
			if(IsElementPresent("btn-logar")) {
				
				// Procurando o Elemento
		        WebElement ButtonLogar = driver.findElement(By.id("btn-logar"));
		        
		        // Funcao HighLight
		        HighLightElement(ButtonLogar);
		        
				/** Report Extent **/
				test.log(Status.PASS, "LoginPage - Acionando o Botão LOGAR");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP01_000_LogarExchange-AcionarBotaoLogar"));
				/** Report Extent **/
		        
		        // Clicando no Botão LOGAR
		        ButtonLogar.click();
		        Thread.sleep(2000); // Espera 2 segundo
		        
		        // Escrevendo no Console
		        System.out.println("LoginPage - Acionando o Botão LOGAR");
		        
				} else {
					
			        // Escrevendo no Console
			        System.out.println("LoginPage - Não Acionando o Botão LOGAR");
			        
					/** Report Extent **/
					test.log(Status.ERROR, "LoginPage - Não Acionando o Botão LOGAR");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP01_000_LogarExchange-NaoAcionarBotaoLogar"));
					/** Report Extent **/
					
				}

		} else {

			// Escrevendo no Console
			System.out.println("LoginPage - Logo ZATERX Não Visivel");
			
			/** Report Extent **/
			test.log(Status.PASS, "LoginPage - Logo ZATERX Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP01_000_LogarExchange-LoginNaoVisivel"));
			/** Report Extent **/

		}		
	}
  	
	@Test
	public void STP02_000_Navegar_Dashboard() throws Exception {

		/** Report Extent **/
		test = extent.createTest("STP02_000_Navegar_Dashboard");
		test.assignCategory("Regressão");
		/** Report Extent **/

		if(IsElementPresent("//button[text()='OK!']")) {

			// Buscar o elemento na página
			WebElement POP_UP = driver.findElement(By.xpath("//button[text()='OK!']"));

			// Funcao HighLight
			HighLightElement(POP_UP);

			//Clicar no POP_UP
			POP_UP.click();
			Thread.sleep(2000);// esperar 2 segundo

			// Escrevendo no Console
			System.out.println("Dashboard - Possui Mensagem de POP_UP");

			/** Report Extent **/
			test.log(Status.PASS, "Dashboard - Possui Mensagem de POP_UP");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP02_000_Navegar_Dashboard-PopUP"));
			/** Report Extent **/
			
        	// Verifica se o Texto é verdadeiro
	        //assertEquals("COMPRAR", driver.findElement(By.xpath("/html/body/main/div/div/content-top/div/h1")).getText());
	        //assertTrue(driver.findElement(By.xpath("/html/body/main/div/div/content-top/div/h1")).getText(),true);	        
			
		} else {

			// Escrevendo no Console
			System.out.println("Dashboard - Não Possui Mensagem de POP_UP");

			/** Report Extent **/
			test.log(Status.INFO, "Não Possui Mensagem de POP_UP");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP02_000_Navegar_Dashboard-SemPopUP"));
			/** Report Extent **/

		}

		if(IsElementPresent("//*[@class='profile-toggle-link dropdown-toggle']")) {

			// Funcao HighLight
			HighLightElement(driver.findElement(By.xpath("//*[@class='profile-toggle-link dropdown-toggle']")));

			// Escrevendo no Console
			System.out.println("Dashboard - Logado com Sucesso");
			
			/** Report Extent **/
			test.log(Status.PASS, "Dashboard - Logado com Sucesso");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP02_000_Navegar_Dashboard-LogadoComSucesso"));
			/** Report Extent **/

			if(IsElementPresent("//*[@class='al-title ng-binding']")) {

				// Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("/html/body/main/div/div/content-top/div/h1")));
				
				// Escrevendo no Console
				System.out.println("Dashboard - Visivel");

				/** Report Extent **/
				test.log(Status.PASS, "Dashboard - Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP02_000_Navegar_Dashboard-DashboardVisivel"));
				/** Report Extent **/
				
				
				if (driver.findElement(By.xpath("/html/body/main/div/div/content-top/div/h1")).getAttribute("innerText").contains("DASHBOARD") || IsElementPresent("dashboard")) {
				
					// Funcao HighLight
					HighLightElement(driver.findElement(By.xpath("//*[@id='dashboard']/panel-data/div/div[1]/div/div/div/div/h3")));
					HighLightElement(driver.findElement(By.xpath("//*[@id='dashboard']/panel-data/div/div[2]/div/div/div/div/h3")));
					HighLightElement(driver.findElement(By.id("tradeChart")));
					
					// Escrevendo no Console
					System.out.println("Textos - Visivel");

					/** Report Extent **/
					test.log(Status.PASS, "Textos - Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP02_000_Navegar_Dashboard-TextosVisivel"));
					/** Report Extent **/
					
				} else {
					
					// Escrevendo no Console
					System.out.println("Textos - Não Visivel");

					/** Report Extent **/
					test.log(Status.ERROR, "Textos - Não Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP02_000_Navegar_Dashboard-TextosNaoVisivel"));
					/** Report Extent **/
					
				}
					
				
			} else {

				// Escrevendo no Console
				System.out.println("Dashboard - Não Visivel");

				/** Report Extent **/
				test.log(Status.ERROR, "Dashboard - Não Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP02_000_Navegar_Dashboard-DashboardNaoVisivel"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console
			System.out.println("Dashboard - Erro ao Logar");

			/** Report Extent **/
			test.log(Status.ERROR, "Dasboard - Erro ao Logar");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP02_000_Navegar_Dashboard-ErroLogar"));
			/** Report Extent **/

		}

	}

	@Test
	public void STP02_001_VerificarUltimaTransacao() throws Exception {
		
		/** Report Extent **/
		test = extent.createTest("STP02_001_VerificarUltimaTransacao");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		//Buscando classe Json e passando url
    	String ReturnURL = Json(Dados_Windows.Homologacao_JSON);
    	
    	//Populando a variavel com o urq que contem Json 
    	System.out.println("Retorno da URL do JSon: " + ReturnURL);
    	
    	//Apontando aonde esta a substring "last" e atribuindo a variavel last 
    	String ReturnLast = ReturnURL.substring(ReturnURL.indexOf("\"" + "last" +  "\"" + ":"),ReturnURL.lastIndexOf("," + "\"" + "low" + "\""));
    	String LastJSon =  ReturnLast.substring(7);
    	
    	//Escrevendo no console  
    	System.out.println("Valor da Ultima Transação no JSON: " + LastJSon);
    	
    	//Atribuindo o xpath a lastweb 
    	String LastWeb = driver.findElement(By.xpath("/html/body/main/page-top/div/div[1]/p/strong")).getText().substring(2, 8).replace(".", "").replaceAll(",", ".");
    
    	//Escrevendo no console  
    	System.out.println("Valor da Ultima Transação no WEB: " + LastWeb);
    	
		/** Report Extent **/
		test.log(Status.PASS, "Validando - Ultima Transação");
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP02_001_VerificarUltimaTransacao-ValidarTransacao"));
		/** Report Extent **/
    		  	
    	if(LastJSon.equals(LastWeb)) { //Igualando string e variavel para verificar se os valores são iguais 
    		
			// Procurando o Elemento
			WebElement Web = driver.findElement(By.xpath("/html/body/main/page-top/div/div[1]/p/strong"));

			// Funcao HighLight
			HighLightElement(Web);
    		
        	//Escrevendo no console  
    		System.out.println("Valor da Ultima Transação - OK");
    		
    		/** Report Extent **/
			test.log(Status.PASS, "Valor da Ultima Transação - OK");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP02_001_VerificarUltimaTransacao-TransacaoOK"));
			/** Report Extent **/
			
    	}else {
    		
        	//Escrevendo no console  
    		System.out.println("Valor da Ultima Transação - NOK");
    		
    		/** Report Extent **/
			test.log(Status.ERROR, "Valor da Ultima Transação - NOK");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP02_001_VerificarUltimaTransacao-TransacaoNOK"));
			/** Report Extent **/
			
    	}
	} 

	@Test
	public void STP02_002_FecharIntercom() throws Exception {
		
		/** Report Extent **/
		test = extent.createTest("STP02_002_FecharIntercom");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		if(IsElementPresent("intercom-container")) {
				
        	//Escrevendo no console  
    		System.out.println("Intercom - OK");
    		
    		/** Report Extent **/
			test.log(Status.PASS, "Intercom - OK");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP02_002_FecharIntercom-IntercomOK"));
			/** Report Extent **/
			
			if(IsElementPresent("intercom-borderless-frame")) {
						
				// Frame
				driver.switchTo().frame(driver.findElement(By.name("intercom-borderless-frame")));	
				
				// Procurando o Elemento
				WebElement Intercom1 = driver.findElement(By.xpath("//*[@class='intercom-chat-card-body']"));
				
				// Funcao HighLight
				HighLightElement(Intercom1);
				
				// Clicar no Intercom'
				Intercom1.click();
				Thread.sleep(2000);// esperar 2 segundo
				
				// Procurando o Elemento
				WebElement Intercom2 = driver.findElement(By.xpath("//*[@class='intercom-borderless-dismiss-button']"));
	    		
				// Funcao HighLight
				HighLightElement(Intercom2);
							
				// Clicar no Botao 'Fechar'
				Intercom2.click();
				Thread.sleep(2000);// esperar 2 segundo
							
	        	//Escrevendo no console  
	    		System.out.println("Fechar Intercom - OK");
	    		
	    		/** Report Extent **/
				test.log(Status.PASS, "Fechar Intercom - OK");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP02_002_FecharIntercom-FecharIntercomOK"));
				/** Report Extent **/
				
			} else {
				
	        	//Escrevendo no console  
	    		System.out.println("Frame - NOK");
	    		
	    		/** Report Extent **/
				test.log(Status.ERROR, "Frame - NOK");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP02_002_FecharIntercom-FrameNOK"));
				/** Report Extent **/					
				
			}
			
		} else {
					
        	//Escrevendo no console  
    		System.out.println("Fechar Intercom - NOK");
    		
    		/** Report Extent **/
			test.log(Status.ERROR, "Fechar Intercom - NOK");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP02_002_FecharIntercom-FecharIntercomNOK"));
			/** Report Extent **/			
			
		}
	
	}
		
	@Test
	public void STP12_000_LogOutExchange() throws Exception {
		
		/** Report Extent **/
		test = extent.createTest("STP99_LogOutExchange");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		if(IsElementPresent("//*[@class='profile-toggle-link dropdown-toggle']")) {
			
			// Buscar o elemento na página
			WebElement MenuLogOut = driver.findElement(By.xpath("//*[@class='profile-toggle-link dropdown-toggle']"));
			
	        // Funcao HighLight
	        HighLightElement(MenuLogOut);
	        
			//Clicar no Menu LogOut
	        MenuLogOut.click();
			Thread.sleep(2000);// esperar 2 segundo
	        
	        /** Report Extent **/
			test.log(Status.PASS, "LogOut - MENU LOGOUT Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP99_LogOutExchange-MenuLogOutVisivel"));
			/** Report Extent **/
	        
	        // Escrevendo no Console
	        System.out.println("LogOut - MENU LOGOUT Visivel!!!");
	        
			
	        if(IsElementPresent("//*[text()='Sair']")) {
	        	
				// Buscar o elemento na página
	        	WebElement LogOut = driver.findElement(By.xpath("//*[text()='Sair']"));
	        	
		        // Funcao HighLight
		        HighLightElement(LogOut);
		        
				//Clicar no Menu LogOut
		        LogOut.click();
				Thread.sleep(10000);// esperar 1 segundo
		        
		        /** Report Extent **/
				test.log(Status.PASS, "LogOut - LogOut com Sucesso");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP99_LogOutExchange-LogOutComSucesso"));
				/** Report Extent **/
		        
		        // Escrevendo no Console
		        System.out.println("LogOut - LogOut com Sucesso");
		        
	        } else {
		        
		        // Escrevendo no Console
		        System.out.println("LogOut - LogOut sem Sucesso");
		        
		        /** Report Extent **/
				test.log(Status.ERROR, "LogOut - LogOut sem Sucesso");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP99_LogOutExchange-LogOutSemSucesso"));
				/** Report Extent **/
	        	
	        }
			
		} else {
	        
	        // Escrevendo no Console
	        System.out.println("LogOut - MENU LOGOUT Não Visivel");
	        
	        /** Report Extent **/
			test.log(Status.ERROR, "LogOut - MENU LOGOUT Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP99_LogOutExchange-MenuLogOutNaoVisivel"));
			/** Report Extent **/
	        
		}
		
	}
	
	@AfterClass
	public static void FecharBrowser() throws Exception {

		// Escrevendo no Console
		System.out.println("Fechar o Browser");
		
		/** Report Extent **/
		test = extent.createTest("TCR02000_ZaterCapitalExchange_Fluxo_Dashboard_Finalizar");
		test.assignCategory("Regressão");
		/** Report Extent **/
                
		/** Report Extent **/
		test.log(Status.PASS, "Browser Encerrado com Sucesso");
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","TCR02000_ZaterCapitalExchange_Fluxo_Dashboard_Finalizar-EncerrarSiteComSucesso"));
		/** Report Extent **/
        
        // Encerra o Report
        extent.flush();

		// Fechar o Browser
		driver.quit();
		//driver.close();

	}

}
