package Regressao;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import Utilitarios.Dados_Windows;
import Utilitarios.FuncoesReusaveis_Windows;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TCR02008_ZaterCapitalExchange_Fluxo_Configuracoes extends FuncoesReusaveis_Windows {

	@BeforeClass
	public static void AbrirBrowser() throws Exception {
					
		// Chamando o Browser
		InitBrowser("Chrome");
		
		/** Report Extent **/
		StartReport("TCR02008_ZaterCapitalExchange_Fluxo_Configuracoes_TestResult");	
		test = extent.createTest("TCR02008_ZaterCapitalExchange_Fluxo_Configuracoes_Iniciar");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		// Chamando o Site e configurando o Browser  
		//driver.navigate().to(Dados.Producao_Site_ZaterCapital);	// chamando o site
		driver.get(Dados_Windows.Homologacao_Site_ZaterCapital_Exchange);
		driver.manage().window().maximize(); // maximizando o browser
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // esperando por até 20 segundos
		
		// Pegando as URLs
		String url_site = driver.getCurrentUrl(); // URL atual
		String url_dados = Dados_Windows.Homologacao_Site_ZaterCapital_Exchange; // URL da class Dados
		
		/** Report Extent **/
		test.log(Status.INFO, "TCR02008_ZaterCapitalExchange_Fluxo_Configuracoes_Iniciar");
		test.log(Status.PASS, "Browser Carregado com Sucesso");	
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","TCR02008_ZaterCapitalExchange_Fluxo_Configuracoes_Iniciar-AbrirSiteComSucesso"));
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
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","TCR02008_ZaterCapitalExchange_Fluxo_Configuracoes_Iniciar-AbrirSiteComSucesso"));
		/** Report Extent **/
		
		} else {
								
			// Escrevendo no Console
			System.out.println("Abrir o Browser - ERROR ao abrir Site da Exchange da Zater Capital");
			
			/** Report Extent **/
			test.log(Status.ERROR, "Abrir o Browser - ERROR ao abrir Site da Exchange da Zater Capital");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","TCR02008_ZaterCapitalExchange_Fluxo_Configuracoes_Iniciar-ErroAbrirSite"));
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
				
				
				if (driver.findElement(By.xpath("/html/body/main/div/div/content-top/div/h1")).getAttribute("innerText").contains("DASHBOARD") && IsElementPresent("dashboard")) {
				
					// Funcao HighLight
					HighLightElement(driver.findElement(By.xpath("//*[@id='dashboard']/panel-data/div/div[1]/div/div/div/div/h3")));
					HighLightElement(driver.findElement(By.xpath("//*[@id='dashboard']/panel-data/div/div[2]/div/div/div/div/h3")));
					
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
	public void STP03_000_Navegar_Configuracoes() throws Exception {
		
		/** Report Extent **/
		test = extent.createTest("STP03_000_Navegar_Configuracoes");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		if(IsElementPresent("//*[@class='al-sidebar-list-link ng-scope']")) {

			// Procurando os Menus e colocando em uma Lista
			List<WebElement> ProcurarMenu = driver.findElements(By.xpath("//*[@class='al-sidebar-list-link ng-scope']"));
			
			// Buscar o elemento na página
			WebElement MenuConfiguracoes = ProcurarMenu.get(10);
			
			// Funcao HighLight
			HighLightElement(MenuConfiguracoes);

			//Clicar no Menu 'Configuracao'
			MenuConfiguracoes.click();
			Thread.sleep(2000);// esperar 2 segundo

	        /** Report Extent **/
			test.log(Status.PASS, "MENU 'Configuração' - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP03_000_Navegar_Configuracoes-MENUConfiguracaoVisivel"));
			/** Report Extent **/
			
			// Escrevendo no Console
			System.out.println("MENU 'Configuração' - Visivel");

			if(IsElementPresent("configurations")) {

		        /** Report Extent **/
				test.log(Status.PASS, "Configuração - Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP03_000_Navegar_Configuracoes-ConfiguracaoVisivel"));
				/** Report Extent **/

				// Escrevendo no Console
				System.out.println("Configuraçao - Visivel");
				
				if(driver.findElement(By.xpath("/html/body/main/div/div/content-top/div/h1")).getAttribute("innerText").contains("CONFIGURAÇÕES")) {
							
					// Funcao HighLight
					HighLightElement(driver.findElement(By.xpath("/html/body/main/div/div/content-top/div/h1")));
					
					// Escrevendo no Console
					System.out.println("Assert: " + driver.findElement(By.xpath("/html/body/main/div/div/content-top/div/h1")).getText());
					
				} else {
					
					// Escrevendo no Console
					System.out.println("Texto Não Visível");
					
				}
					
				if(driver.findElement(By.xpath("//*[@id='userProfile']/div/div/div/div[1]/div/div/h3")).getAttribute("innerText").contains("Perfil do Usuário")) {
				
					// Funcao HighLight
					HighLightElement(driver.findElement(By.xpath("//*[@id='userProfile']/div/div/div/div[1]/div/div/h3")));
					
					// Escrevendo no Console
					System.out.println("Assert: " + driver.findElement(By.xpath("//*[@id='userProfile']/div/div/div/div[1]/div/div/h3")).getText());

					
				} else {
					
					// Escrevendo no Console
					System.out.println("Texto Não Visível");
				
				}
				
				if(IsElementPresent("//*[text()='Clique aqui!']")) {
					
					// Buscar o elemento na página
					WebElement CliqueAqui = driver.findElement(By.xpath("//*[text()='Clique aqui!']"));

					// Funcao HighLight
					HighLightElement(CliqueAqui);

					//Clicar no Menu Configuracao
					CliqueAqui.click();
					Thread.sleep(2000);// esperar 2 segundo
					
					// Escrevendo no Console
					System.out.println("Clique Aqui! - Visivel");
					
			        /** Report Extent **/
					test.log(Status.PASS, "Clique Aqui! - Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP03_000_Navegar_Configuracoes-CliqueAquiVisivel"));
					/** Report Extent **/
					
					if(IsElementPresent("//button[@class='close']")) {
												
						// Buscar o elemento na página
						WebElement Texto = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]"));
						WebElement Close = driver.findElement(By.xpath("//button[@class='close']"));
						
						// Funcao HighLight
						HighLightElement(Texto);
						HighLightElement(Close);
						
						// Escrevendo no Console
						System.out.println("Texto: " + Texto.getAttribute("textContent").toString());
						
				        /** Report Extent **/
						test.log(Status.PASS, "Texto: " + Texto.getAttribute("textContent").toString());
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP03_000_Navegar_Configuracoes-TextoVisivel"));
						/** Report Extent **/
						
						//Clicar no Botão Fechar
						Close.click();
						Thread.sleep(2000);// esperar 2 segundo				
						
					} else {
						
						// Escrevendo no Console
						System.out.println("Texto - Não Visível");
						
				        /** Report Extent **/
						test.log(Status.ERROR, "Texto - Não Visível");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP03_000_Navegar_Configuracoes-TextoNaoVisivel"));
						/** Report Extent **/
						
					}
								
				} else {
					
					// Escrevendo no Console
					System.out.println("Clique Aqui! - Não Visível");
					
			        /** Report Extent **/
					test.log(Status.ERROR, "Clique Aqui! - Não Visível");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP03_000_Navegar_Configuracoes-CliqueAquiNaoVisivel"));
					/** Report Extent **/
					
				}
				
			} else {

				// Escrevendo no Console
				System.out.println("Configuraçao - Não Visivel");
				
		        /** Report Extent **/
				test.log(Status.ERROR, "Configuração - Não Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP03_000_Navegar_Configuracoes-ConfiguracaoNaoVisivel"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console
			System.out.println("MENU Configuraçao - Não Visivel");
			
	        /** Report Extent **/
			test.log(Status.ERROR, "MENU Configuração - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP03_000_Navegar_Configuracoes-MENUConfiguracaoNaoVisivel"));
			/** Report Extent **/

		}	
	}

	@Test
	public void STP04_000_Navegar_Configuracoes_Foto() throws Exception {
		
		/** Report Extent **/
		test = extent.createTest("STP04_Navegar_Configuracoes_Foto");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		if(IsElementPresent("userProfile")) {

			// Buscar o elemento na página
			WebElement UserProfile = driver.findElement(By.id("userProfile"));

			// Funcao HighLight
			HighLightElement(UserProfile);

	        /** Report Extent **/
			test.log(Status.PASS, "UserProfile - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP04_000_Navegar_Configuracoes_Foto-UserProfileVisivel"));
			/** Report Extent **/
			
			// Escrevendo no Console
			System.out.println("UserProfile - Visivel");

			if(IsElementPresent("//*[@id='userProfile']/div/div/div/div[1]/div/div/div/div/div[1]/a/img")) {

				// Buscar o elemento na página
				WebElement FotoProfile = driver.findElement(By.xpath("//*[@id='userProfile']/div/div/div/div[1]/div/div/div/div/div[1]/a/img"));
				
				// Funcao HighLight
				HighLightElement(FotoProfile);
			
				// Escrevendo no Console
				System.out.println("FotoProfile - Visivel");
				
		        /** Report Extent **/
				test.log(Status.PASS, "FotoProfile - Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP04_000_Navegar_Configuracoes_Foto-FotoProfileVisivel"));
				/** Report Extent **/
				
				//Clicar na Foto do Profile
				FotoProfile.click();
				Thread.sleep(2000);// esperar 2 segundo

				// Escrevendo no Console
				System.out.println("Configuraçao - Visivel");
				
					Robot robot = new Robot();
					robot.delay(1000);// esperar para digitar
				
				    // Inserindo o Caminho onde vai salvar a foto na Janela do Windows			   
				    robot.keyPress(KeyEvent.VK_C);			// Tecla C		- Pressionar o Botão
				    robot.keyRelease(KeyEvent.VK_C);		// Tecla C		- Soltar o Botão
				    robot.keyPress(KeyEvent.VK_SHIFT);		// Tecla SHIFT	- Pressionar o Botão  
				    robot.keyPress(KeyEvent.VK_SEMICOLON);	// Tecla ";"	- Pressionar o Botão
				    robot.keyRelease(KeyEvent.VK_SHIFT);  	// Tecla SHIFT	- Soltar o Botão
				    robot.keyRelease(KeyEvent.VK_SEMICOLON);// Tecla ";"	- Soltar o Botão
				    robot.delay(1000);// esperar para digitar
				    
				    // Continuando a Inserir o Caminho onde vai salvar a foto na Janela do Windows, porém utilizando a FuncoesReusaveis (senkeys)
				    // Como é montado a Função sendKeys(Robot robot, String keys)
				    // Etapa 2
				    SendKeys(robot, "\\Selenium WebDriver\\documentos\\profile\\ProfilePhoto.png");
				             
				    robot.keyPress(KeyEvent.VK_ENTER);		// Tecla ENTER	- Pressionar o Botão
				    robot.keyRelease(KeyEvent.VK_ENTER);	// Tecla ENTER	- Soltar o Botão
				    robot.delay(1000);
				    
				// Escrevendo no Console
				System.out.println("FotoProfile - Inserido");
				
		        /** Report Extent **/
				test.log(Status.PASS, "FotoProfile - Inserido");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP04_000_Navegar_Configuracoes_Foto-FotoProfileInserido"));
				/** Report Extent **/				    
				
			} else {

				// Escrevendo no Console
				System.out.println("FotoProfile - Não Visivel");
				
		        /** Report Extent **/
				test.log(Status.ERROR, "FotoProfile - Não Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP04_000_Navegar_Configuracoes_Foto-FotoProfileNaoVisivel"));
				/** Report Extent **/

			}

		} else {
			
			// Escrevendo no Console
			System.out.println("UserProfile - Não Visivel");

	        /** Report Extent **/
			test.log(Status.ERROR, "UserProfile - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP04_000_Navegar_Configuracoes_Foto-UserProfileNaoVisivel"));
			/** Report Extent **/
			
		}	
	}
		
	@Test
	public void STP05_000_Navegar_Configuracoes_Documentos() throws Exception {
		
		/** Report Extent **/
		test = extent.createTest("STP05_000_Navegar_Configuracoes_Documentos");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		if(IsElementPresent("//*[text()='Anexar documento']")) {

			// Buscar o elemento na página
			List<WebElement> EnviarDocumentos = driver.findElements(By.xpath("//*[text()='Anexar documento']"));
			
			if (EnviarDocumentos.get(0).isDisplayed()) {
			
				// Buscar o elemento na página
				WebElement PrimeiroDocumento = EnviarDocumentos.get(0);
	
				// Funcao HighLight
				HighLightElement(PrimeiroDocumento);
				
				//Clicar na Primeira Foto
				PrimeiroDocumento.click();
				Thread.sleep(2000);// esperar 2 segundo
				
					// Função ROBOT
					Robot robot = new Robot();
					robot.delay(1000);// esperar para digitar
				
				    // Inserindo o Caminho onde vai salvar a foto na Janela do Windows			   
				    robot.keyPress(KeyEvent.VK_C);			// Tecla C		- Pressionar o Botão
				    robot.keyRelease(KeyEvent.VK_C);		// Tecla C		- Soltar o Botão
				    robot.keyPress(KeyEvent.VK_SHIFT);		// Tecla SHIFT	- Pressionar o Botão  
				    robot.keyPress(KeyEvent.VK_SEMICOLON);	// Tecla ";"	- Pressionar o Botão
				    robot.keyRelease(KeyEvent.VK_SHIFT);  	// Tecla SHIFT	- Soltar o Botão
				    robot.keyRelease(KeyEvent.VK_SEMICOLON);// Tecla ";"	- Soltar o Botão
				    robot.delay(1000);// esperar para digitar
				    
				    // Continuando a Inserir o Caminho onde vai salvar a foto na Janela do Windows, porém utilizando a FuncoesReusaveis (senkeys)
				    // Como é montado a Função sendKeys(Robot robot, String keys)
				    // Etapa 2
				    SendKeys(robot, "\\Selenium WebDriver\\documentos\\docs\\documentopng.png");
				             
				    robot.keyPress(KeyEvent.VK_ENTER);		// Tecla ENTER	- Pressionar o Botão
				    robot.keyRelease(KeyEvent.VK_ENTER);	// Tecla ENTER	- Soltar o Botão
				    robot.delay(1000);
				
				// Escrevendo no Console
				System.out.println("Primeiro Documento Inserido");
	
		        /** Report Extent **/
				test.log(Status.PASS, "Primeiro Documento Inserido");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP05_000_Navegar_Configuracoes_Documentos-PrimeiroDocumentoInserido"));
				/** Report Extent **/
				
			} else {
				
				// Escrevendo no Console
				System.out.println("Primeiro Documento Não Inserido");
	
		        /** Report Extent **/
				test.log(Status.ERROR, "Primeiro Documento Não Inserido");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP05_000_Navegar_Configuracoes_Documentos-PrimeiroDocumentoNaoInserido"));
				/** Report Extent **/
				
			}
			
			if (EnviarDocumentos.get(1).isDisplayed()) {
				
				// Buscar o elemento na página
				WebElement SegundoDocumento = EnviarDocumentos.get(1);
	
				// Funcao HighLight
				HighLightElement(SegundoDocumento);
				
				//Clicar na Segunda Foto
				SegundoDocumento.click();
				Thread.sleep(2000);// esperar 2 segundo
				
					// Função ROBOT
					Robot robot = new Robot();
					robot.delay(1000);// esperar para digitar
				
				    // Inserindo o Caminho onde vai salvar a foto na Janela do Windows			   
				    robot.keyPress(KeyEvent.VK_C);			// Tecla C		- Pressionar o Botão
				    robot.keyRelease(KeyEvent.VK_C);		// Tecla C		- Soltar o Botão
				    robot.keyPress(KeyEvent.VK_SHIFT);		// Tecla SHIFT	- Pressionar o Botão  
				    robot.keyPress(KeyEvent.VK_SEMICOLON);	// Tecla ";"	- Pressionar o Botão
				    robot.keyRelease(KeyEvent.VK_SHIFT);  	// Tecla SHIFT	- Soltar o Botão
				    robot.keyRelease(KeyEvent.VK_SEMICOLON);// Tecla ";"	- Soltar o Botão
				    robot.delay(1000);// esperar para digitar
				    
				    // Continuando a Inserir o Caminho onde vai salvar a foto na Janela do Windows, porém utilizando a FuncoesReusaveis (senkeys)
				    // Como é montado a Função sendKeys(Robot robot, String keys)
				    // Etapa 2
				    SendKeys(robot, "\\Selenium WebDriver\\documentos\\docs\\documentojpg.jpg");
				             
				    robot.keyPress(KeyEvent.VK_ENTER);		// Tecla ENTER	- Pressionar o Botão
				    robot.keyRelease(KeyEvent.VK_ENTER);	// Tecla ENTER	- Soltar o Botão
				    robot.delay(1000);
				
				// Escrevendo no Console
				System.out.println("Segundo Documento Inserido");
	
		        /** Report Extent **/
				test.log(Status.PASS, "Segundo Documento Inserido");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP05_000_Navegar_Configuracoes_Documentos-SegundoDocumentoInserido"));
				/** Report Extent **/
				
			} else {
				
				// Escrevendo no Console
				System.out.println("Segundo Documento Não Inserido");
	
		        /** Report Extent **/
				test.log(Status.ERROR, "Segundo Documento Não Inserido");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP05_000_Navegar_Configuracoes_Documentos-SegundoDocumentoNaoInserido"));
				/** Report Extent **/
				
			}
			
			if (EnviarDocumentos.get(2).isDisplayed()) {
				
				// Buscar o elemento na página
				WebElement TerceiroDocumento = EnviarDocumentos.get(2);
	
				// Funcao HighLight
				HighLightElement(TerceiroDocumento);
				
				//Clicar na Terceira Foto
				TerceiroDocumento.click();
				Thread.sleep(2000);// esperar 2 segundo
				
					// Função ROBOT
					Robot robot = new Robot();
					robot.delay(1000);// esperar para digitar
				
				    // Inserindo o Caminho onde vai salvar a foto na Janela do Windows			   
				    robot.keyPress(KeyEvent.VK_C);			// Tecla C		- Pressionar o Botão
				    robot.keyRelease(KeyEvent.VK_C);		// Tecla C		- Soltar o Botão
				    robot.keyPress(KeyEvent.VK_SHIFT);		// Tecla SHIFT	- Pressionar o Botão  
				    robot.keyPress(KeyEvent.VK_SEMICOLON);	// Tecla ";"	- Pressionar o Botão
				    robot.keyRelease(KeyEvent.VK_SHIFT);  	// Tecla SHIFT	- Soltar o Botão
				    robot.keyRelease(KeyEvent.VK_SEMICOLON);// Tecla ";"	- Soltar o Botão
				    robot.delay(1000);// esperar para digitar
				    
				    // Continuando a Inserir o Caminho onde vai salvar a foto na Janela do Windows, porém utilizando a FuncoesReusaveis (senkeys)
				    // Como é montado a Função sendKeys(Robot robot, String keys)
				    // Etapa 2
				    SendKeys(robot, "\\Selenium WebDriver\\documentos\\docs\\documentopdf.pdf");
				             
				    robot.keyPress(KeyEvent.VK_ENTER);		// Tecla ENTER	- Pressionar o Botão
				    robot.keyRelease(KeyEvent.VK_ENTER);	// Tecla ENTER	- Soltar o Botão
				    robot.delay(1000);
				
				// Escrevendo no Console
				System.out.println("Terceiro Documento Inserido");
	
		        /** Report Extent **/
				test.log(Status.PASS, "Terceiro Documento Inserido");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP05_000_Navegar_Configuracoes_Documentos-TerceiroDocumentoInserido"));
				/** Report Extent **/
				
			} else {
				
				// Escrevendo no Console
				System.out.println("Terceiro Documento Não Inserido");
	
		        /** Report Extent **/
				test.log(Status.ERROR, "Terceiro Documento Não Inserido");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP05_000_Navegar_Configuracoes_Documentos-TerceiroDocumentoNaoInserido"));
				/** Report Extent **/
				
			}
			
			if (EnviarDocumentos.get(3).isDisplayed()) {
				
				// Buscar o elemento na página
				WebElement QuartoDocumento = EnviarDocumentos.get(3);
	
				// Funcao HighLight
				HighLightElement(QuartoDocumento);
				
				//Clicar na Quarta Foto
				QuartoDocumento.click();
				Thread.sleep(2000);// esperar 2 segundo
				
					// Função ROBOT
					Robot robot = new Robot();
					robot.delay(1000);// esperar para digitar
				
				    // Inserindo o Caminho onde vai salvar a foto na Janela do Windows			   
				    robot.keyPress(KeyEvent.VK_C);			// Tecla C		- Pressionar o Botão
				    robot.keyRelease(KeyEvent.VK_C);		// Tecla C		- Soltar o Botão
				    robot.keyPress(KeyEvent.VK_SHIFT);		// Tecla SHIFT	- Pressionar o Botão  
				    robot.keyPress(KeyEvent.VK_SEMICOLON);	// Tecla ";"	- Pressionar o Botão
				    robot.keyRelease(KeyEvent.VK_SHIFT);  	// Tecla SHIFT	- Soltar o Botão
				    robot.keyRelease(KeyEvent.VK_SEMICOLON);// Tecla ";"	- Soltar o Botão
				    robot.delay(1000);// esperar para digitar
				    
				    // Continuando a Inserir o Caminho onde vai salvar a foto na Janela do Windows, porém utilizando a FuncoesReusaveis (senkeys)
				    // Como é montado a Função sendKeys(Robot robot, String keys)
				    // Etapa 2
				    SendKeys(robot, "\\Selenium WebDriver\\documentos\\docs\\documentopng.png");
				             
				    robot.keyPress(KeyEvent.VK_ENTER);		// Tecla ENTER	- Pressionar o Botão
				    robot.keyRelease(KeyEvent.VK_ENTER);	// Tecla ENTER	- Soltar o Botão
				    robot.delay(1000);
				
				// Escrevendo no Console
				System.out.println("Quarto Documento Inserido");
	
		        /** Report Extent **/
				test.log(Status.PASS, "Quarto Documento Inserido");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP05_000_Navegar_Configuracoes_Documentos-QuartoDocumentoInserido"));
				/** Report Extent **/
				
			} else {
				
				// Escrevendo no Console
				System.out.println("Quarto Documento Não Inserido");
	
		        /** Report Extent **/
				test.log(Status.ERROR, "Quarto Documento Não Inserido");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP05_000_Navegar_Configuracoes_Documentos-QuartoDocumentoNaoInserido"));
				/** Report Extent **/
				
			}		
			
		} else {
			
			// Escrevendo no Console
			System.out.println("Documentos - Não Visivel");

	        /** Report Extent **/
			test.log(Status.ERROR, "Documentos - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP05_000_Navegar_Configuracoes_Documentos-DocumentosNaoVisivel"));
			/** Report Extent **/
			
		}	
	}
	
	@Test
	public void STP06_000_Navegar_Configuracoes_Dados_PessoaFisica() throws Exception {
		
		/** Report Extent **/
		test = extent.createTest("STP06_000_Navegar_Configuracoes_Dados_PessoaFisica");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		if(IsElementPresent("cpf")) {

			// Buscar o elemento na página
			WebElement cpf = driver.findElement(By.name("cpf"));

			// Funcao HighLight
			HighLightElement(cpf);
			
			// Escrevendo no Console
			System.out.println("Dados - Pessoa Física - Visivel");

	        /** Report Extent **/
			test.log(Status.PASS, "Dados - Pessoa Física - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP06_000_Navegar_Configuracoes_Dados_PessoaFisica-DadosPessoaFisicaVisivel"));
			/** Report Extent **/
			
			if(IsElementPresent("name")) {

				// Buscar o elemento na página
				WebElement nome = driver.findElement(By.name("name"));

				// Funcao HighLight
				HighLightElement(nome);
				
				//Clicar na Foto do Profile
				nome.clear();
				Thread.sleep(2000);// esperar 2 segundo
				nome.sendKeys("Jefferson");
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Nome");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir o Nome");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP06_000_Navegar_Configuracoes_Dados_PessoaFisica-AlterarInserirNome"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Nome - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir o Nome - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP06_000_Navegar_Configuracoes_Dados_PessoaFisica-AlterarInserirNomeNaoVisivel"));
				/** Report Extent **/

			}	

			if(IsElementPresent("lastname")) {

				// Buscar o elemento na página
				WebElement sobrenome = driver.findElement(By.name("lastname"));

				// Funcao HighLight
				HighLightElement(sobrenome);
				
				//Clicar na Foto do Profile
				sobrenome.clear();
				Thread.sleep(2000);// esperar 2 segundo
				sobrenome.sendKeys("Barbieri Campiol");
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Sobrenome");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir o Sobrenome");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP06_000_Navegar_Configuracoes_Dados_PessoaFisica-AlterarInserirSobrenome"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Sobrenome - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir o Sobrenome - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP06_000_Navegar_Configuracoes_Dados_PessoaFisica-AlterarInserirSobrenomeNaoVisivel"));
				/** Report Extent **/

			}	
			
			if(IsElementPresent("birthday")) {

				// Buscar o elemento na página
				WebElement nascimento = driver.findElement(By.name("birthday"));

				// Funcao HighLight
				HighLightElement(nascimento);
				
				//Clicar na Foto do Profile
				nascimento.clear();
				Thread.sleep(2000);// esperar 2 segundo
				nascimento.sendKeys("01051986");
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Nascimento");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir o Nascimento");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP06_000_Navegar_Configuracoes_Dados_PessoaFisica-AlterarInserirNascimento"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Nascimento - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir o Nascimento - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP06_000_Navegar_Configuracoes_Dados_PessoaFisica-AlterarInserirNascimentoNaoVisivel"));
				/** Report Extent **/

			}	
			
			if(IsElementPresent("address")) {

				// Buscar o elemento na página
				WebElement endereco = driver.findElement(By.name("address"));

				// Funcao HighLight
				HighLightElement(endereco);
				
				//Clicar na Foto do Profile
				endereco.clear();
				Thread.sleep(2000);// esperar 2 segundo
				endereco.sendKeys("Rua Amazonas, 116");
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Endereço");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir o Endereço");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP06_000_Navegar_Configuracoes_Dados_PessoaFisica-AlterarInserirEndereco"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Endereço - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir o Endereço - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP06_000_Navegar_Configuracoes_Dados_PessoaFisica-AlterarInserirEnderecoNaoVisivel"));
				/** Report Extent **/

			}	

			if (IsElementSelected("countryField")) {
				
				// Procurando o Elemento
				WebElement Estado = driver.findElement(By.id("countryField"));
	
				// Funcao HighLight
		        HighLightElement(Estado);
		        
		        // Procurando o Elemento Select
		        Select SelecionarEstado = new Select(Estado);
		        
		        // Selecionando o Estado
		        SelecionarEstado.selectByValue("SP");
		        Thread.sleep(1000); // Espera 1 segundo
		        
				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Estado");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir o Estado");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP06_000_Navegar_Configuracoes_Dados_PessoaFisica-AlterarInserirEstado"));
				/** Report Extent **/

			} else {
			
				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Estado - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir o Estado - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP06_000_Navegar_Configuracoes_Dados_PessoaFisica-AlterarInserirEstadoNaoVisivel"));
				/** Report Extent **/
							
			}
			
			if(IsElementPresent("city")) {

				// Buscar o elemento na página
				WebElement cidade = driver.findElement(By.name("city"));

				// Funcao HighLight
				HighLightElement(cidade);
				
				//Clicar na Foto do Profile
				cidade.clear();
				Thread.sleep(2000);// esperar 2 segundo
				cidade.sendKeys("Vinhedo");
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Alterar e Inserir a Cidade");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir a Cidade");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP06_000_Navegar_Configuracoes_Dados_PessoaFisica-AlterarInserirCidade"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Alterar e Inserir a Cidade - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir a Cidade - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP06_000_Navegar_Configuracoes_Dados_PessoaFisica-AlterarInserirCidadeNaoVisivel"));
				/** Report Extent **/

			}	
			
			if(IsElementPresent("cep")) {

				// Buscar o elemento na página
				WebElement cep = driver.findElement(By.name("cep"));

				// Funcao HighLight
				HighLightElement(cep);
				
				//Clicar na Foto do Profile
				cep.clear();
				Thread.sleep(2000);// esperar 2 segundo
				cep.sendKeys("13280000");
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Alterar e Inserir o CEP");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir o CEP");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP06_000_Navegar_Configuracoes_Dados_PessoaFisica-AlterarInserirCEP"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Alterar e Inserir o CEP - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir o CEP - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP06_000_Navegar_Configuracoes_Dados_PessoaFisica-AlterarInserirCEPNaoVisivel"));
				/** Report Extent **/

			}	
			
			if(IsElementPresent("cellphone")) {

				// Buscar o elemento na página
				WebElement celular = driver.findElement(By.name("cellphone"));

				// Funcao HighLight
				HighLightElement(celular);
				
				//Clicar na Foto do Profile
				celular.clear();
				Thread.sleep(2000);// esperar 2 segundo
				celular.sendKeys("19992524666");
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Celular");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir o Celular");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP06_000_Navegar_Configuracoes_Dados_PessoaFisica-AlterarInserirCelular"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Celular - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir o Celular - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP06_000_Navegar_Configuracoes_Dados_PessoaFisica-AlterarInserirCelularNaoVisivel"));
				/** Report Extent **/

			}	
			
			if (IsElementPresent("//*[@class='col-md-6 ng-hide']")) {
				
				// Escrevendo no Console
				System.out.println("IR - Não Visível");
				
			} else {
			
				if(IsElementPresent("impr") && IsElementEnabled("impr")) {
	
					// Buscar o elemento na página
					WebElement IR = driver.findElement(By.name("impr"));
	
					// Funcao HighLight
					HighLightElement(IR);
					
					//Clicar na Foto do Profile
					IR.clear();
					Thread.sleep(2000);// esperar 2 segundo
					IR.sendKeys("1234567890");
					Thread.sleep(2000);// esperar 2 segundo
					
					// Escrevendo no Console
					System.out.println("Alterar e Inserir o IR");
	
			        /** Report Extent **/
					test.log(Status.PASS, "Alterar e Inserir o IR");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP06_000_Navegar_Configuracoes_Dados_PessoaFisica-AlterarInserirIR"));
					/** Report Extent **/
	
				} else {
	
					// Escrevendo no Console
					System.out.println("Alterar e Inserir o IR - Não Visível");
	
			        /** Report Extent **/
					test.log(Status.ERROR, "Alterar e Inserir o IR - Não Visível");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP06_000_Navegar_Configuracoes_Dados_PessoaFisica-AlterarInserirIRNaoVisivel"));
					/** Report Extent **/
	
				}
			}
			
			if(IsElementPresent("//input[@value='Confirmar Dados']") && IsElementEnabled("//input[@value='Confirmar Dados']")) {

				// Buscar o elemento na página
				WebElement ConfirmarDados = driver.findElement(By.xpath("//input[@value='Confirmar Dados']"));

				// Funcao HighLight
				HighLightElement(ConfirmarDados);
				
				//Clicar no Botão 'Confirmar Dados'
				ConfirmarDados.click();
				Thread.sleep(10000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Clicar no Botão 'Confirmar Dados'");

		        /** Report Extent **/
				test.log(Status.PASS, "Clicar no Botão 'Confirmar Dados'");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP06_000_Navegar_Configuracoes_Dados_PessoaFisica-ConfirmarDados"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Botão 'Confirmar Dados' - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Botão 'Confirmar Dados' - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP06_000_Navegar_Configuracoes_Dados_PessoaFisica-ConfirmarDadosNaoVisivel"));
				/** Report Extent **/

			}
			
			if(IsElementPresent("//button[text()='OK!']")) { // '//*[@class='swal2-popup swal2-modal swal2-show']'

				// Buscar o elemento na página
				WebElement CadastroSucesso = driver.findElement(By.xpath("//button[text()='OK!']"));

				// Funcao HighLight
				HighLightElement(CadastroSucesso);
				
				//Clicar no Botão 'OK!'
				Thread.sleep(2000);// esperar 2 segundo
				CadastroSucesso.click();
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Clicar no Botão 'OK!' - Cadastro com Sucesso");

		        /** Report Extent **/
				test.log(Status.PASS, "Clicar no Botão 'OK!' - Cadastro com Sucesso");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP06_000_Navegar_Configuracoes_Dados_PessoaFisica-ConfirmarCadastro"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Botão 'OK!' - Não Visível - Alteração com Sucesso");

		        /** Report Extent **/
				test.log(Status.INFO, "Botão 'OK!' - Não Visível - Alteração com Sucesso");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP06_000_Navegar_Configuracoes_Dados_PessoaFisica-CadastroNaoRealizado"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console
			System.out.println("Dados - Pessoa Física - Não Visivel");

	        /** Report Extent **/
			test.log(Status.ERROR, "Dados - Pessoa Física - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP06_000_Navegar_Configuracoes_Dados_PessoaFisica-DadosPessoaFisicaNaoVisivel"));
			/** Report Extent **/

		}	
	}
	
	@Test
	public void STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica() throws Exception {
		
		/** Report Extent **/
		test = extent.createTest("STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		if(IsElementPresent("cnpj")) {

			// Buscar o elemento na página
			WebElement cnpj = driver.findElement(By.name("cnpj"));

			// Funcao HighLight
			HighLightElement(cnpj);
			
			// Escrevendo no Console
			System.out.println("Dados - Pessoa Jurídica - Visível");

	        /** Report Extent **/
			test.log(Status.PASS, "Dados - Pessoa Jurídica - Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica-DadosPessoaJuridicaVisivel"));
			/** Report Extent **/
			
			if(IsElementPresent("name")) {

				// Buscar o elemento na página
				WebElement nome_socio = driver.findElement(By.name("name"));

				// Funcao HighLight
				HighLightElement(nome_socio);
				
				//Clicar na Foto do Profile
				nome_socio.clear();
				Thread.sleep(2000);// esperar 2 segundo
				nome_socio.sendKeys("Jefferson Barbieri Campiol");
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Nome do Sócio");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir o Nome do Sócio");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirNomeSocio"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Nome do Sócio - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir o Nome do Sócio - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirNomeSocioNaoVisivel"));
				/** Report Extent **/

			}
			
			if(IsElementPresent("razaosocial")) {

				// Buscar o elemento na página
				WebElement razao_social = driver.findElement(By.name("razaosocial"));

				// Funcao HighLight
				HighLightElement(razao_social);
				
				//Clicar na Foto do Profile
				razao_social.clear();
				Thread.sleep(2000);// esperar 2 segundo
				razao_social.sendKeys("Automação1 S/A");
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Alterar e Inserir a Razão Sócial");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir a Razão Sócial");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirRazaoSocial"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Alterar e Inserir a Razão Sócial - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir a Razão Sócial - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirRazaoSocialNaoVisivel"));
				/** Report Extent **/

			}
			
			if(IsElementPresent("nomefantasia")) {

				// Buscar o elemento na página
				WebElement nome_fantasia = driver.findElement(By.name("nomefantasia"));

				// Funcao HighLight
				HighLightElement(nome_fantasia);
				
				//Clicar na Foto do Profile
				nome_fantasia.clear();
				Thread.sleep(2000);// esperar 2 segundo
				nome_fantasia.sendKeys("Zater Capital");
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Nome Fantasia");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir o Nome Fantasia");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirNomeFantasia"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Nome Fantasia - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir o Nome Fantasia - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirNomeFantasiaNaoVisivel"));
				/** Report Extent **/

			}
			
			if(IsElementPresent("corpAddress")) {

				// Buscar o elemento na página
				WebElement endereço = driver.findElement(By.name("corpAddress"));

				// Funcao HighLight
				HighLightElement(endereço);
				
				//Clicar No Campo 'Endereço'
				endereço.clear();
				Thread.sleep(2000);// esperar 2 segundo
				endereço.sendKeys("Av. Paulista, 2202");
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Endereço");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir o Endereço");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirEndereco"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Endereço - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir o Endereço - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirEnderecoNaoVisivel"));
				/** Report Extent **/

			}
			
			if (IsElementSelected("countryField")) {
				
				// Procurando o Elemento
				WebElement Estado = driver.findElement(By.id("countryField"));
	
				// Funcao HighLight
		        HighLightElement(Estado);
		        
		        // Procurando o Elemento Select
		        Select SelecionarEstado = new Select(Estado);
		        
		        // Selecionando o Estado
		        SelecionarEstado.selectByValue("SP");
		        Thread.sleep(1000); // Espera 1 segundo
		        
				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Estado");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir o Estado");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirEstado"));
				/** Report Extent **/

			} else {
			
				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Estado - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir o Estado - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirEstadoNaoVisivel"));
				/** Report Extent **/
							
			}
			
			if(IsElementPresent("city")) {

				// Buscar o elemento na página
				WebElement cidade = driver.findElement(By.name("city"));

				// Funcao HighLight
				HighLightElement(cidade);
				
				//Clicar na Foto do Profile
				cidade.clear();
				Thread.sleep(2000);// esperar 2 segundo
				cidade.sendKeys("São Paulo");
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Alterar e Inserir a Cidade");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir a Cidade");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirCidade"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Alterar e Inserir a Cidade - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir a Cidade - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirCidadeNaoVisivel"));
				/** Report Extent **/

			}
			
			if(IsElementPresent("ceppj")) {

				// Buscar o elemento na página
				WebElement cep = driver.findElement(By.name("corpCep"));

				// Funcao HighLight
				HighLightElement(cep);
				
				//Clicar na Foto do Profile
				cep.clear();
				Thread.sleep(2000);// esperar 2 segundo
				cep.sendKeys("01361000");
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Alterar e Inserir o CEP");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir o CEP");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirCep"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Alterar e Inserir o CEP - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir o CEP - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirCepNaoVisivel"));
				/** Report Extent **/

			}
			
			if(IsElementPresent("contactNameName")) {

				// Buscar o elemento na página
				WebElement ContactName = driver.findElement(By.name("contactNameName"));

				// Funcao HighLight
				HighLightElement(ContactName);
				
				//Clicar na Foto do Profile
				ContactName.clear();
				Thread.sleep(2000);// esperar 2 segundo
				ContactName.sendKeys("Automação de Testes - Zater Capital");
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Nome do Contato");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir o Nome do Contato");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirNomeContato"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Nome do Contato - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir o Nome do Contato - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirNomeContatoNaoVisivel"));
				/** Report Extent **/

			}
			
			if(IsElementPresent("emailpj")) {

				// Buscar o elemento na página
				WebElement ContactEMail = driver.findElement(By.id("emailpj"));

				// Funcao HighLight
				HighLightElement(ContactEMail);
				
				//Clicar na Foto do Profile
				ContactEMail.clear();
				Thread.sleep(2000);// esperar 2 segundo
				ContactEMail.sendKeys("automacao@netlolo.com");
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Alterar e Inserir o E-Mail do Contato");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir o E-Mail do Contato");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirEMailContato"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Alterar e Inserir o E-Mail do Contato - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir o E-Mail do Contato - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirEMailContatoNaoVisivel"));
				/** Report Extent **/

			}

			if(IsElementPresent("telefonepj")) {

				// Buscar o elemento na página
				WebElement Telefone = driver.findElement(By.id("telefonepj"));

				// Funcao HighLight
				HighLightElement(Telefone);
				
				//Clicar na Foto do Profile
				Telefone.clear();
				Thread.sleep(2000);// esperar 2 segundo
				Telefone.sendKeys("1138265876");
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Telefone");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir o Telefone");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirTelefone"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Telefone - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir o Telefone - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirTelefoneNaoVisivel"));
				/** Report Extent **/

			}
			
			if(IsElementPresent("//input[@value='Confirmar Dados']")) {

				// Buscar o elemento na página
				WebElement ConfirmarDados = driver.findElement(By.xpath("//input[@value='Confirmar Dados']"));

				// Funcao HighLight
				HighLightElement(ConfirmarDados);
				
				//Clicar no Botão 'Confirmar Dados'
				ConfirmarDados.click();
				Thread.sleep(10000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Clicar no Botão 'Confirmar Dados'");

		        /** Report Extent **/
				test.log(Status.PASS, "Clicar no Botão 'Confirmar Dados'");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica-ConfirmarDados"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Botão 'Confirmar Dados' - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Botão 'Confirmar Dados' - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica-ConfirmarDadosNaoVisivel"));
				/** Report Extent **/

			}
			
			if(IsElementPresent("//button[text()='OK!']")) { // '//*[@class='swal2-popup swal2-modal swal2-show']'

				// Buscar o elemento na página
				WebElement CadastroSucesso = driver.findElement(By.xpath("//button[text()='OK!']"));

				// Funcao HighLight
				HighLightElement(CadastroSucesso);
				
				//Clicar no Botão 'OK!'
				Thread.sleep(2000);// esperar 2 segundo
				CadastroSucesso.click();
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Clicar no Botão 'OK!' - Cadastro com Sucesso");

		        /** Report Extent **/
				test.log(Status.PASS, "Clicar no Botão 'OK!' - Cadastro com Sucesso");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica-ConfirmarCadastro"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Botão 'OK!' - Não Visível - Alteração com Sucesso");

		        /** Report Extent **/
				test.log(Status.INFO, "Botão 'OK!' - Não Visível - Alteração com Sucesso");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica-CadastroNaoRealizado"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console
			System.out.println("Dados - Pessoa Jurídica - Não Visível");

	        /** Report Extent **/
			test.log(Status.ERROR, "Dados - Pessoa Jurídica - Não Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP07_000_Navegar_Configuracoes_Dados_PessoaJuridica-DadosPessoaJuridicaNaoVisivel"));
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
		test = extent.createTest("TCR02008_ZaterCapitalExchange_Fluxo_Configuracoes_Finalizar");
		test.assignCategory("Regressão");
		/** Report Extent **/
                
		/** Report Extent **/
		test.log(Status.PASS, "Browser Encerrado com Sucesso");
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","TCR02008_ZaterCapitalExchange_Fluxo_Configuracoes_Finalizar-EncerrarSiteComSucesso"));
		/** Report Extent **/
        
        // Encerra o Report
        extent.flush();

		// Fechar o Browser
		driver.quit();
		//driver.close();

	}

}
