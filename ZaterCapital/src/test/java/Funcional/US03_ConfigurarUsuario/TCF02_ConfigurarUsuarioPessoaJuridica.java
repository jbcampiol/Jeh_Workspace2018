package Funcional.US03_ConfigurarUsuario;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import Utilitarios.Dados_Windows;
import Utilitarios.FuncoesReusaveis_Windows;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class TCF02_ConfigurarUsuarioPessoaJuridica extends FuncoesReusaveis_Windows {

	@Given("^um usuario do tipo Pessoa Fisica\\.$")
	public void um_usuario_do_tipo_Pessoa_Fisica() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		//throw new PendingException();
		
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
		
		// Chamando o Browser
		InitBrowser("Chrome");

		/** Report Extent **/
		StartReport("TCF02_ConfigurarUsuarioPessoaJuridica_TestResult_" + dateFormat.format(date));	
		test = extent.createTest("TCF02_ConfigurarUsuarioPessoaJuridica_Iniciar");
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
		test.log(Status.INFO, "TCF01_ConfigurarUsuarioPessoaFisica_Iniciar");
		test.log(Status.PASS, "Browser Carregado com Sucesso");	
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","TCF02_ConfigurarUsuarioPessoaJuridica_Iniciar-AbrirSiteComSucesso"));
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
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","TCF02_ConfigurarUsuarioPessoaJuridica_Iniciar-AbrirSiteComSucesso"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("Abrir o Browser - ERROR ao abrir Site da Exchange da Zater Capital");

			/** Report Extent **/
			test.log(Status.ERROR, "Abrir o Browser - ERROR ao abrir Site da Exchange da Zater Capital");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","TCF02_ConfigurarUsuarioPessoaJuridica_Iniciar-ErroAbrirSite"));
			/** Report Extent **/

		}


	}

	@When("^logar na Exchange da Zater Capital com o \"([^\"]*)\" valido e uma \"([^\"]*)\" valida\\.$")
	public void logar_na_Exchange_da_Zater_Capital_com_o_valido_e_uma_valida(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		//throw new PendingException();

		/** Report Extent **/
		test = extent.createTest("STP01_LogarExchange");
		test.assignCategory("Regressão");
		/** Report Extent **/

		if (IsElementPresent("Page-1")) {

			// Escrevendo no Console
			System.out.println("LoginPage - Logo ZATERX Visivel");

			/** Report Extent **/
			test.log(Status.PASS, "LoginPage - Logo Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP01_LogarExchange-LoginVisivel"));
			/** Report Extent **/

			if (IsElementPresent("inputEmail3")) {

				// Procurando o Elemento
				WebElement login = driver.findElement(By.id("inputEmail3"));

				// Funcao HighLight
				HighLightElement(login);

				// Digitando o Usuário
				login.sendKeys(arg1);
				//login.sendKeys("automacao1@netlolo.com");
				Thread.sleep(1000); // Espera 1 segundo

				/** Report Extent **/
				test.log(Status.PASS, "LoginPage - Usuário Informado");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP01_LogarExchange-UsuarioInformado"));
				/** Report Extent **/

				// Escrevendo no Console
				System.out.println("LoginPage - Usuário Informado");
				System.out.println("Usuário: " + arg1);
				//System.out.println("Usuário: " + "automacao1@netlolo.com");

			} else {

				// Escrevendo no Console
				System.out.println("LoginPage - Usuário Não Informado");

				/** Report Extent **/
				test.log(Status.ERROR, "LoginPage - Usuário Não Informado");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP01_LogarExchange-UsuarioNaoInformado"));
				/** Report Extent **/

			}

			if (IsElementPresent("inputPassword3")) {

				// Procurando o Elemento
				WebElement password = driver.findElement(By.id("inputPassword3"));

				// Funcao HighLight
				HighLightElement(password);

				// Digitando a Senha
				password.sendKeys(arg2);   
				//password.sendKeys("Automacao@123");
				Thread.sleep(1000); // Espera 1 segundo

				/** Report Extent **/
				test.log(Status.PASS, "LoginPage - Senha Informada");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP01_LogarExchange-SenhaInformada"));
				/** Report Extent **/

				// Escrevendo no Console
				System.out.println("LoginPage - Senha Informada");
				System.out.println("Senha: " + arg2);
				//System.out.println("Senha: " + "Automacao@123");

			} else {

				// Escrevendo no Console
				System.out.println("LoginPage - Senha Não Informada");

				/** Report Extent **/
				test.log(Status.ERROR, "LoginPage - Senha Não Informada");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP01_LogarExchange-SenhaNaoInformada"));
				/** Report Extent **/

			}

			if(IsElementPresent("btn-logar")) {

				// Procurando o Elemento
				WebElement ButtonLogar = driver.findElement(By.id("btn-logar"));

				// Funcao HighLight
				HighLightElement(ButtonLogar);

				/** Report Extent **/
				test.log(Status.PASS, "LoginPage - Acionando o Botão LOGAR");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP01_LogarExchange-AcionarBotaoLogar"));
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
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP01_LogarExchange-NaoAcionarBotaoLogar"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console
			System.out.println("LoginPage - Logo ZATERX Não Visivel");

			/** Report Extent **/
			test.log(Status.PASS, "LoginPage - Logo ZATERX Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP01_LogarExchange-LoginNaoVisivel"));
			/** Report Extent **/

		}		

	}

	@When("^clicar na opção CONFIGURACOES\\.$")
	public void clicar_na_opção_CONFIGURACOES() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
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
		
		
		// Entrando em outra Funcção
		Thread.sleep(5000); // Esperando 5 segundo
		
		
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

	@When("^inserir a FOTO do PERFIL\\.$")
	public void inserir_a_FOTO_do_PERFIL() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
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
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP04_Navegar_Configuracoes_Foto-UserProfileVisivel"));
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
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP04_Navegar_Configuracoes_Foto-FotoProfileVisivel"));
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
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP04_Navegar_Configuracoes_Foto-FotoProfileInserido"));
				/** Report Extent **/				    
				
			} else {

				// Escrevendo no Console
				System.out.println("FotoProfile - Não Visivel");
				
		        /** Report Extent **/
				test.log(Status.ERROR, "FotoProfile - Não Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP04_Navegar_Configuracoes_Foto-FotoProfileNaoVisivel"));
				/** Report Extent **/

			}

		} else {
			
			// Escrevendo no Console
			System.out.println("UserProfile - Não Visivel");

	        /** Report Extent **/
			test.log(Status.ERROR, "UserProfile - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP04_Navegar_Configuracoes_Foto-UserProfileNaoVisivel"));
			/** Report Extent **/
			
		}	
		
	}

	@When("^inserir as FOTOS dos DOCUMENTOS, ANEXO(\\d+), ANEXO(\\d+), ANEXO(\\d+) e ANEXO(\\d+)\\.$")
	public void inserir_as_FOTOS_dos_DOCUMENTOS_ANEXO_ANEXO_ANEXO_e_ANEXO(int arg1, int arg2, int arg3, int arg4) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		/** Report Extent **/
		test = extent.createTest("STP05_Navegar_Configuracoes_Documentos");
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
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP05_Navegar_Configuracoes_Documentos-PrimeiroDocumentoInserido"));
				/** Report Extent **/
				
			} else {
				
				// Escrevendo no Console
				System.out.println("Primeiro Documento Não Inserido");
	
		        /** Report Extent **/
				test.log(Status.ERROR, "Primeiro Documento Não Inserido");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP05_Navegar_Configuracoes_Documentos-PrimeiroDocumentoNaoInserido"));
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
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP05_Navegar_Configuracoes_Documentos-SegundoDocumentoInserido"));
				/** Report Extent **/
				
			} else {
				
				// Escrevendo no Console
				System.out.println("Segundo Documento Não Inserido");
	
		        /** Report Extent **/
				test.log(Status.ERROR, "Segundo Documento Não Inserido");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP05_Navegar_Configuracoes_Documentos-SegundoDocumentoNaoInserido"));
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
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP05_Navegar_Configuracoes_Documentos-TerceiroDocumentoInserido"));
				/** Report Extent **/
				
			} else {
				
				// Escrevendo no Console
				System.out.println("Terceiro Documento Não Inserido");
	
		        /** Report Extent **/
				test.log(Status.ERROR, "Terceiro Documento Não Inserido");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP05_Navegar_Configuracoes_Documentos-TerceiroDocumentoNaoInserido"));
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
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP05_Navegar_Configuracoes_Documentos-QuartoDocumentoInserido"));
				/** Report Extent **/
				
			} else {
				
				// Escrevendo no Console
				System.out.println("Quarto Documento Não Inserido");
	
		        /** Report Extent **/
				test.log(Status.ERROR, "Quarto Documento Não Inserido");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP05_Navegar_Configuracoes_Documentos-QuartoDocumentoNaoInserido"));
				/** Report Extent **/
				
			}		
			
		} else {
			
			// Escrevendo no Console
			System.out.println("Documentos - Não Visivel");

	        /** Report Extent **/
			test.log(Status.ERROR, "Documentos - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP05_Navegar_Configuracoes_Documentos-DocumentosNaoVisivel"));
			/** Report Extent **/
			
		}	
		
	}

	@When("^informar os Dados \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" e \"([^\"]*)\" na Tela de CONFIGURACOES\\.$")
	public void informar_os_Dados_e_na_Tela_de_CONFIGURACOES(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		/** Report Extent **/
		test = extent.createTest("STP07_Navegar_Configuracoes_Dados_PessoaJuridica");
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
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP07_Navegar_Configuracoes_Dados_PessoaJuridica-DadosPessoaJuridicaVisivel"));
			/** Report Extent **/
			
			if(IsElementPresent("name")) {

				// Buscar o elemento na página
				WebElement nome_socio = driver.findElement(By.name("name"));

				// Funcao HighLight
				HighLightElement(nome_socio);
				
				//Clicar na Foto do Profile
				nome_socio.clear();
				Thread.sleep(2000);// esperar 2 segundo
				nome_socio.sendKeys(arg1);
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Nome do Sócio");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir o Nome do Sócio");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP07_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirNomeSocio"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Nome do Sócio - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir o Nome do Sócio - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP07_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirNomeSocioNaoVisivel"));
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
				razao_social.sendKeys(arg2);
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Alterar e Inserir a Razão Sócial");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir a Razão Sócial");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP07_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirRazaoSocial"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Alterar e Inserir a Razão Sócial - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir a Razão Sócial - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP07_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirRazaoSocialNaoVisivel"));
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
				nome_fantasia.sendKeys(arg3);
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Nome Fantasia");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir o Nome Fantasia");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP07_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirNomeFantasia"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Nome Fantasia - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir o Nome Fantasia - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP07_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirNomeFantasiaNaoVisivel"));
				/** Report Extent **/

			}
			
			if(IsElementPresent("corpAddress")) {

				// Buscar o elemento na página
				WebElement endereço = driver.findElement(By.name("corpAddress"));

				// Funcao HighLight
				HighLightElement(endereço);
				
				//Clicar na Foto do Profile
				endereço.clear();
				Thread.sleep(2000);// esperar 2 segundo
				endereço.sendKeys(arg4);
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Endereço");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir o Endereço");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP07_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirEndereco"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Endereço - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir o Endereço - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP07_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirEnderecoNaoVisivel"));
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
		        SelecionarEstado.selectByValue(arg5);
		        Thread.sleep(1000); // Espera 1 segundo
		        
				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Estado");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir o Estado");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP07_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirEstado"));
				/** Report Extent **/

			} else {
			
				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Estado - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir o Estado - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP07_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirEstadoNaoVisivel"));
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
				cidade.sendKeys(arg6);
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Alterar e Inserir a Cidade");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir a Cidade");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP07_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirCidade"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Alterar e Inserir a Cidade - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir a Cidade - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP07_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirCidadeNaoVisivel"));
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
				cep.sendKeys(arg7);
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Alterar e Inserir o CEP");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir o CEP");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP07_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirCep"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Alterar e Inserir o CEP - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir o CEP - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP07_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirCepNaoVisivel"));
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
				ContactName.sendKeys(arg8);
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Nome do Contato");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir o Nome do Contato");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP07_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirNomeContato"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Nome do Contato - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir o Nome do Contato - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP07_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirNomeContatoNaoVisivel"));
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
				ContactEMail.sendKeys(arg9);
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Alterar e Inserir o E-Mail do Contato");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir o E-Mail do Contato");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP07_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirEMailContato"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Alterar e Inserir o E-Mail do Contato - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir o E-Mail do Contato - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP07_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirEMailContatoNaoVisivel"));
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
				Telefone.sendKeys(arg10);
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Telefone");

		        /** Report Extent **/
				test.log(Status.PASS, "Alterar e Inserir o Telefone");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP07_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirTelefone"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Alterar e Inserir o Telefone - Não Visível");

		        /** Report Extent **/
				test.log(Status.ERROR, "Alterar e Inserir o Telefone - Não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP07_Navegar_Configuracoes_Dados_PessoaJuridica-AlterarInserirTelefoneNaoVisivel"));
				/** Report Extent **/

			}
		}
		
	}

	@When("^acionar o BOTAO CONFIRMAR DADOS$")
	public void acionar_o_BOTAO_CONFIRMAR_DADOS() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		/** Report Extent **/
		test = extent.createTest("STP06_Navegar_Configuracoes_Dados_PessoaFisica");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
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
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP06_Navegar_Configuracoes_Dados_PessoaFisica-ConfirmarDados"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("Botão 'Confirmar Dados' - Não Visível");

	        /** Report Extent **/
			test.log(Status.ERROR, "Botão 'Confirmar Dados' - Não Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP06_Navegar_Configuracoes_Dados_PessoaFisica-ConfirmarDadosNaoVisivel"));
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
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP07_Navegar_Configuracoes_Dados_PessoaJuridica-ConfirmarCadastro"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("Botão 'OK!' - Não Visível - Alteração com Sucesso");

	        /** Report Extent **/
			test.log(Status.INFO, "Botão 'OK!' - Não Visível - Alteração com Sucesso");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP07_Navegar_Configuracoes_Dados_PessoaJuridica-CadastroNaoRealizado"));
			/** Report Extent **/

		}
		
	}

	@Then("^o sistema deve permitir a atualização dos dados cadastrais do usuario com sucesso e alterar o nivel do usuario$")
	public void o_sistema_deve_permitir_a_atualização_dos_dados_cadastrais_do_usuario_com_sucesso_e_alterar_o_nivel_do_usuario() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		/** Report Extent **/
		test = extent.createTest("STP99_LogOutExchange");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		if(IsElementPresent("//*[@class='profile-toggle-link dropdown-toggle']")) {
			
			// Buscar o elemento na página
			//WebElement menu_log_out = driver.findElement(By.xpath("/html/body/main/page-top/div/div[2]/div[1]/a/img"));
			WebElement menu_log_out = driver.findElement(By.xpath("//*[@class='profile-toggle-link dropdown-toggle']"));
			
	        // Funcao HighLight
	        HighLightElement(menu_log_out);
	        
			//Clicar no Menu LogOut
	        menu_log_out.click();
			Thread.sleep(2000);// esperar 2 segundo
	        
	        /** Report Extent **/
			test.log(Status.PASS, "LogOut - MENU LOGOUT Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP99_LogOutExchange-MenuLogOutVisivel"));
			/** Report Extent **/
	        
	        // Escrevendo no Console
	        System.out.println("LogOut - MENU LOGOUT Visivel!!!");
	        
			
	        if(IsElementPresent("//*[text()='Sair']")) {
	        	
				// Buscar o elemento na página
				//WebElement log_out = driver.findElement(By.xpath("/html/body/main/page-top/div/div[2]/div[1]/ul/li[3]/a"));
	        	WebElement log_out = driver.findElement(By.xpath("//*[text()='Sair']"));
	        	
		        // Funcao HighLight
		        HighLightElement(log_out);
		        
				//Clicar no Menu LogOut
		        log_out.click();
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
		
		
		// Entrando em outra Funcção
		Thread.sleep(5000); // Esperando 5 segundo
		
		
		// Escrevendo no Console
		System.out.println("Fechar o Browser");
		
		/** Report Extent **/
		test = extent.createTest("TCF02_ConfigurarUsuarioPessoaJuridica_Finalizar");
		test.assignCategory("Regressão");
		/** Report Extent **/
                
		/** Report Extent **/
		test.log(Status.PASS, "Browser Encerrado com Sucesso");
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","TCF02_ConfigurarUsuarioPessoaJuridica_Finalizar-EncerrarSiteComSucesso"));
		/** Report Extent **/
        
        // Encerra o Report
        extent.flush();

		// Fechar o Browser
		driver.quit();
		//driver.close();
		
	}
	
}
