package Regressao;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import Utilitarios.Dados_Windows;
import Utilitarios.FuncoesReusaveis_Windows;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TCR02001_ZaterCapitalExchange_Fluxo_Deposito extends FuncoesReusaveis_Windows {

	@BeforeClass
	public static void AbrirBrowser() throws Exception {

		// Chamando o Browser
		InitBrowser("Chrome");

		/** Report Extent **/
		StartReport("TCR02001_ZaterCapitalExchange_Fluxo_Deposito_TestResult");
		test = extent.createTest("TCR02001_ZaterCapitalExchange_Fluxo_Deposito");
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
		test.log(Status.INFO, "TCR02001_ZaterCapitalExchange_Fluxo_Deposito_Iniciar");
		test.log(Status.PASS, "Browser Carregado com Sucesso");	
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","TCR02001_ZaterCapitalExchange_Fluxo_Deposito_Iniciar-AbrirSiteComSucesso"));
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
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","TCR02001_ZaterCapitalExchange_Fluxo_Deposito_Iniciar-AbrirSiteComSucesso"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("Abrir o Browser - ERROR ao abrir Site da Exchange da Zater Capital");

			/** Report Extent **/
			test.log(Status.ERROR, "Abrir o Browser - ERROR ao abrir Site da Exchange da Zater Capital");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","TCR02001_ZaterCapitalExchange_Fluxo_Deposito_Iniciar-ErroAbrirSite"));
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
				//Login.sendKeys(Dados_Windows.Homologacao_Exchange_EMAIL);
				Login.sendKeys("felipe.silva@netlolo.com");
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
				//Password.sendKeys(Dados_Windows.Homologacao_Exchange_Senha);  
				Password.sendKeys("123456"); 
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
  	
	@Ignore
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
	public void STP03_000_Navegar_Depositos() throws Exception {
		
		/** Report Extent **/
		test = extent.createTest("STP03_000_Navegar_Depositos");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		if(IsElementPresent("//*[@class='al-sidebar-list-link ng-scope']")) {
			
			// Procurando os Menus e colocando em uma Lista
			List<WebElement> ProcurarMenu = driver.findElements(By.xpath("//*[@class='al-sidebar-list-link ng-scope']"));
			
			// Buscar o elemento na página
			WebElement MenuDepositos = ProcurarMenu.get(2);
				
	        // Funcao HighLight
			HighLightElement(MenuDepositos);
			
			//Clicar no Menu 'Depositos'
			MenuDepositos.click();
			Thread.sleep(2000);// esperar 2 segundo
        
	        // Escrevendo no Console
	        System.out.println("MENU 'Deposito' - Visivel");
			
			/** Report Extent **/
			test.log(Status.PASS, "MENU 'Deposito' - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Depositos-MENUDepositoVisivel"));
			/** Report Extent **/
	        			
	        if(IsElementPresent("deposits")) {
	        	
		        // Funcao HighLight
		        HighLightElement(driver.findElement(By.xpath("/html/body/main/div/div/content-top/div/h1")));
		        
		        // Escrevendo no Console
		        System.out.println("Deposito - Visivel");
		        
				/** Report Extent **/
				test.log(Status.PASS, "Depósito - Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Depositos-DepositoVisivel"));
				/** Report Extent **/
				
				if(IsElementPresent("//button[text()='Deposite em Reais']")) {
								     
			        // Funcao HighLight
			        HighLightElement(driver.findElement(By.xpath("//button[text()='Deposite em Reais']")));
			        HighLightElement(driver.findElement(By.xpath("//*[@id='deposits']/money-deposits/div/div[1]/div/div/div[1]/h3")));
					
			        // Escrevendo no Console
			        System.out.println("Depósito de Dinheiro - Visivel");
			        
					/** Report Extent **/
					test.log(Status.PASS, "Depósito de Dinheiro - Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Depositos-DepositoDinheiroVisivel"));
					/** Report Extent **/  
			        
				} else {
					
			        // Escrevendo no Console
			        System.out.println("Depósito de Dinheiro - Não Visivel");
			        
					/** Report Extent **/
					test.log(Status.ERROR, "Depósito de Dinheiro - Não Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Depositos-DepositoDinheiroNaoVisivel"));
					/** Report Extent **/  
					
				}
				
				if(IsElementPresent("//button[text()='Deposite em Bitcoins']")) {
						
			        // Funcao HighLight
			        HighLightElement(driver.findElement(By.xpath("//button[text()='Deposite em Bitcoins']")));
			        HighLightElement(driver.findElement(By.xpath("//*[@id='deposits']/bitcoin-deposits/div/div[1]/div/div/div[1]/h3")));
					
			        // Escrevendo no Console
			        System.out.println("Depósito de Bitcoins - Visivel");
			        
					/** Report Extent **/
					test.log(Status.PASS, "Depósito de Bitcoins - Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Depositos-DepositoBitcoinsVisivel"));
					/** Report Extent **/  
					
				} else {
					
			        // Escrevendo no Console
			        System.out.println("Depósito de Bitcoins - Não Visivel");
			        
					/** Report Extent **/
					test.log(Status.PASS, "Depósito de Bitcoins - Não Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Depositos-DepositoBitcoinsNaoVisivel"));
					/** Report Extent **/  
					
				}
					        
	        } else {
		        
		        // Escrevendo no Console
		        System.out.println("Depósito - Não Visivel");
		        
				/** Report Extent **/
				test.log(Status.ERROR, "Depósito - Não Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Depositos-DepositoNaoVisivel"));
				/** Report Extent **/
	        	
	        }
			
		} else {
				        
	        // Escrevendo no Console
	        System.out.println("MENU 'Depósito' - Não Visivel");
	        
			/** Report Extent **/
			test.log(Status.ERROR, "MENU 'Depósito' - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Depositos-MENUDepositoNaoVisivel"));
			/** Report Extent **/
	        
		}
		
	}

	@Test
	public void STP04_000_Depositos_Dinheiro() throws Exception {

		/** Report Extent **/
		test = extent.createTest("STP04_000_Depositos_Dinheiro");
		test.assignCategory("Regressão");
		/** Report Extent **/

		if (IsElementPresent("deposits")) {

			// Buscar o elemento na página
			WebElement DepositeReais = driver.findElement(By.xpath("//button[text()='Deposite em Reais']"));

			// Funcao HighLight
			HighLightElement(DepositeReais);

			//Clicar no Botao Deposite em Reais
			DepositeReais.click();
			Thread.sleep(2000);// esperar 2 segundo

			// Escrevendo no Console
			System.out.println("Botão Deposite em Reais - Visivel");
			
			/** Report Extent **/
			test.log(Status.PASS, "Botão Deposite em Reais - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Depositos_Dinheiro-BotaoDepositoReaisVisivel"));
			/** Report Extent **/	

		} else {

			// Escrevendo no Console
			System.out.println("Botão Deposite em Reais - Não Visivel");

			/** Report Extent **/
			test.log(Status.ERROR, "Botão Deposite em Reais - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Depositos_Dinheiro-BotaoDepositoReaisNaoVisivel"));
			/** Report Extent **/

		}

	}
	
	@Test
	public void STP05_000_Confirmar_Depositos_Dinheiro() throws Exception {

		/** Report Extent **/
		test = extent.createTest("STP05_000_Confirmar_Depositos_Dinheiro");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		String Dinheiro = new String("10000");
		
		if (IsElementPresent("modal-dialog")) {

			// Buscar o elemento na página
			WebElement FormularioDeposito = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/h4/span"));

			// Funcao HighLight
			HighLightElement(FormularioDeposito);
			
			// Escrevendo no Console
			System.out.println("Formulário Depositos - Visivel");

			/** Report Extent **/
			test.log(Status.PASS, "Formulário Deposito - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Confirmar_Depositos_Dinheiro-FormularioDepositoVisivel"));
			/** Report Extent **/		

			if (IsElementSelected("bancos")) {

				// Buscar o elemento na página
				WebElement SelecionarBancos = driver.findElement(By.name("bancos"));

				// Funcao HighLight
				HighLightElement(SelecionarBancos);

				// Procurando o Elemento Select
				Select Banco = new Select(SelecionarBancos);
				
				// Escrevendo no Console
				System.out.println("Banco - Visível");
				
				/** Report Extent **/
				test.log(Status.PASS, "Banco - Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Confirmar_Depositos_Dinheiro-BancoVisivel"));
				/** Report Extent **/	
				
				// Escrevendo no Console
				System.out.println("Possui o Banco Bradesco: " + SelecionarBancos.getAttribute("textContent").contains("Bradesco"));
				System.out.println("Possui outro Banco: " + SelecionarBancos.getAttribute("textContent").contains("Banco Teste"));
				
				if(SelecionarBancos.getAttribute("textContent").contains("Banco Teste")) {
					
					// Selecionando o Banco
					Banco.selectByVisibleText("Banco Teste");
					Thread.sleep(2000); // Espera 1 segundo
	
					// Escrevendo no Console
					System.out.println("Banco - Selecionado");
					
					/** Report Extent **/
					test.log(Status.PASS, "Banco - Selecionado");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Confirmar_Depositos_Dinheiro-BancoSelecionado"));
					/** Report Extent **/		
				
				} else {
					
					// Buscar o elemento na página
					WebElement ButtonCancelar = driver.findElement(By.xpath("//button[text()='Cancelar']"));

					// Funcao HighLight
					HighLightElement(ButtonCancelar);

					// Acionar o Botão 'Cancelar'
					ButtonCancelar.click();
					Thread.sleep(2000); // Espera 1 segundo

					// Escrevendo no Console
					System.out.println("Botão 'Cancelar' - Acionado");
					
					/** Report Extent **/
					test.log(Status.ERROR, "Botão 'Cancelar' - Acionado");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Confirmar_Depositos_Dinheiro-BotaoCancelarAcionado"));
					/** Report Extent **/					
					
				}
				
			} else {

				// Escrevendo no Console
				System.out.println("Banco - Não Visivel");

				/** Report Extent **/
				test.log(Status.ERROR, "Banco - Não Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Confirmar_Depositos_Dinheiro-BancoNaoVisivel"));
				/** Report Extent **/

			}

			if (IsElementPresent("valor")) {

				// Buscar o elemento na página
				WebElement Valor = driver.findElement(By.id("valor"));

				// Funcao HighLight
				HighLightElement(Valor);

				// Inserir Valor
				Valor.sendKeys(Dinheiro);
				Thread.sleep(2000); // Espera 2 segundo
				
				// Escrevendo no Console
				System.out.println("Valor - Inserido");
				
				/** Report Extent **/
				test.log(Status.PASS, "Valor - Inserido");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Confirmar_Depositos_Dinheiro-ValorInserido"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Valor - Não Inserido");

				/** Report Extent **/
				test.log(Status.ERROR, "Valor - Não Inserido");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Confirmar_Depositos_Dinheiro-ValorNaoInserido"));
				/** Report Extent **/

			}

			if (IsElementPresent("//button[text()='Confirmar']")) {

				// Buscar o elemento na página
				WebElement ButtonConfirmar = driver.findElement(By.xpath("//button[text()='Confirmar']"));

				// Funcao HighLight
				HighLightElement(ButtonConfirmar);

				// Inserir Valor
				ButtonConfirmar.click();
				Thread.sleep(2000); // Espera 1 segundo

				// Escrevendo no Console
				System.out.println("Botão Confirmar - Acionado");
				
				/** Report Extent **/
				test.log(Status.PASS, "Botão Confirmar - Acionado");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Confirmar_Depositos_Dinheiro-BotaoConfirmarAcionado"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Botão Confirmar - Não Acionado");

				/** Report Extent **/
				test.log(Status.ERROR, "Botão Confirmar - Não Acionado");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Confirmar_Depositos_Dinheiro-BotaoConfirmarNaoAcionado"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console
			System.out.println("Formulário Depositos - Não Visivel");
			
			/** Report Extent **/
			test.log(Status.ERROR, "Formulário Deposito - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Confirmar_Depositos_Dinheiro-FormularioDepositoNaoVisivel"));
			/** Report Extent **/		

		}

	}

	@Test
	public void STP06_000_Validar_Tabela_Depositos() throws Exception { 
		
		/** Report Extent **/
		test = extent.createTest("STP06_000_Validar_Tabela_Depositos");
		test.assignCategory("Regressão");
		/** Report Extent **/

		// Chamando a Data
		Date date = new Date();

		// Formatando a Data
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");		

		if(IsElementPresent("deposits")) {

			// Buscar o elemento na página
			WebElement TableDepositoDinheiro = driver.findElement(By.xpath("//*[@id='deposits']/money-deposits/div/div[2]/div/div/div"));

			// Funcao HighLight
			HighLightElement(TableDepositoDinheiro);
			
			// Escrevendo no Console
			System.out.println("Tabela Deposito em Dinheiro - Visivel");

			/** Report Extent **/
			test.log(Status.PASS, "Tabela Deposito em Dinheiro - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP06_000_Validar_Tabela_Depositos-TabelaDepositoDinheiroVisivel"));
			/** Report Extent **/ 
		
			// Buscar o elemento na página
			WebElement Tabela = driver.findElement(By.xpath("//*[@id='deposits']/money-deposits/div/div[2]/div/div/div/table"));
			
			// Coloca o elemento em uma Lista
			List<WebElement> tr = Tabela.findElements(By.cssSelector("tr"));
			//List<WebElement> td = tabela.findElements(By.cssSelector("td"));

			for (WebElement linha : tr) { // Verifica quantos Elementos foram encontrados
				
				// Escrevendo no Console
				System.out.println("Linha" + linha.getText());

				if (linha.getText().contains("Aguardando")) { // Condição para o Status
					
					// Funcao HighLight
					HighLightElement(linha);
					
					// Escrevendo no Console
					System.out.println("Contém Deposito no Status de Aguardando");
					
					/** Report Extent **/
					test.log(Status.PASS, "Contém Deposito no Status de Aguardando");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP06_000_Validar_Tabela_Depositos-ContemDepositoAguardando"));
					/** Report Extent **/ 
								

				} else {

					// Escrevendo no Console
					System.out.println("Não Contem Depositos no Status Aguardando");
					
					/** Report Extent **/
					test.log(Status.INFO, "Não Contém Deposito no Status de Aguardando");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP06_000_Validar_Tabela_Depositos-NaoContemDepositoAguardando"));
					/** Report Extent **/ 				

				}

				if (linha.getText().contains(dateFormat.format(date))) { // Condição para o a DATA
					
					// Funcao HighLight
					HighLightElement(linha);
					
					// Escrevendo no Console
					System.out.println("Contém Depositos em Dinheiro no dia de Hoje: " + dateFormat.format(date));
					
					/** Report Extent **/
					test.log(Status.PASS, "Contém Depositos em Dinheiro no dia de Hoje");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP06_000_Validar_Tabela_Depositos-ContemDepositoNodiaHoje"));
					/** Report Extent **/ 
			
				} else {
					
					// Escrevendo no Console
					System.out.println("Não Contém Depositos em Dinheiro no dia de Hoje: " + dateFormat.format(date));
					
					/** Report Extent **/
					test.log(Status.INFO, "Não Contém Depositos em Dinheiro no dia de Hoje");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP06_000_Validar_Tabela_Depositos-NaoContemDepositoNodiaHije"));
					/** Report Extent **/ 
					
				}
			}
			
		} else {

			// Escrevendo no Console
			System.out.println("Tabela Deposito em Dinheiro - Não Visivel");

			/** Report Extent **/
			test.log(Status.ERROR, "Tabela Deposito em Dinheiro - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP06_000_Validar_Tabela_Depositos-TabelaDepositoDinheiroNaoVisivel"));
			/** Report Extent **/ 

		}
	}

	@Test
	public void STP07_000_Incluir_Comprovante() throws Exception { 
		
		/** Report Extent **/
		test = extent.createTest("STP07_000_Incluir_Comprovante");
		test.assignCategory("Regressão");
		/** Report Extent **/

		// Buscar o elemento na página
		WebElement Tabela = driver.findElement(By.xpath("//*[@id='deposits']/money-deposits/div/div[2]/div/div/div/table"));

		// Coloca o elemento em uma Lista
		List<WebElement> tr = Tabela.findElements(By.cssSelector("tr"));
		//List<WebElement> td = tabela.findElements(By.cssSelector("td"));

		for (WebElement linha : tr) { // Verifica quantos Elementos foram encontrados

			// Escrevendo no Console
			System.out.println("Linha:" + linha.getText());

			// Escrevendo no Console
			System.out.println("Possui Deposito Aguardando validação do ADMIN");

			/** Report Extent **/
			test.log(Status.PASS, "Possui Deposito Aguardando validação do ADMIN");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP07_000_Incluir_Comprovante-PossuiDepositoAguardandoAdmin"));
			/** Report Extent **/ 

			// Verificando o Botão "Incluir Comprovante" e inserindo em uma Lista
			List<WebElement> IncluirComprovante = driver.findElements(By.xpath("//input[@type='file'][@class='form-control']"));

			// Escrevendo no Console
			System.out.println("Quantos Elementos: " + IncluirComprovante.size());

			for (int i=0; i < IncluirComprovante.size(); i++) {

				if(IncluirComprovante.get(i).isEnabled() && IncluirComprovante.get(i).getAttribute("name").contains("inputComrpovante")) { //&& incluir_comprovante.get(i).getSize().hashCode() > 0) {

					// Escrevendo no Console
					System.out.println("Elemento: " + IncluirComprovante.get(i));
					System.out.println("Elemento: " + IncluirComprovante.get(i).isEnabled());
					System.out.println("Elemento: " + IncluirComprovante.get(i).getSize());
					System.out.println("Elemento: " + IncluirComprovante.get(i).getSize().hashCode());
					System.out.println("Elemento: " + IncluirComprovante.get(i).getSize().getClass());

					// Buscar o elemento na página
					WebElement EscolherArquivo = IncluirComprovante.get(i);

					// Funcao HighLight
					HighLightElement(EscolherArquivo);

					// Clicar no Botao Escolher arquivo
					EscolherArquivo.click();
					Thread.sleep(5000); // Espera 1 segundo

						/** ROBOT **/
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
						SendKeys(robot, "\\Selenium WebDriver\\pdf\\ProfilePhoto.png");
	
						robot.keyPress(KeyEvent.VK_ENTER);		// Tecla ENTER	- Pressionar o Botão
						robot.keyRelease(KeyEvent.VK_ENTER);	// Tecla ENTER	- Soltar o Botão
						robot.delay(1000);
						/** ROBOT **/

					// Escrevendo no Console
					System.out.println("Incluído o Comprovante com Sucesso");

					/** Report Extent **/
					test.log(Status.PASS, "Incluído o Comprovante com Sucesso");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP07_000_Incluir_Comprovante-IncluidoComprovanteComSucesso"));
					/** Report Extent **/ 

				} else {

					// Escrevendo no Console
					System.out.println("Elemento não visivel");
					
					/** Report Extent **/
					test.log(Status.INFO, "Elemento não visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP07_000_Incluir_Comprovante-ElementoNaoVisivel"));
					/** Report Extent **/ 				

				}								
			}

		} 

	}
	
	@Test
	public void STP08_000_Abrir_Comprovante() throws Exception {	

		/** Report Extent **/
		test = extent.createTest("STP08_000_Abrir_Comprovante");
		test.assignCategory("Regressão");
		/** Report Extent **/

		// Verificando o Botão "Incluir Comprovante" e inserindo em uma Lista
		List<WebElement> Comprovante = driver.findElements(By.xpath("//*[text()='Abrir comprovante']"));

		// Escrevendo no Console
		System.out.println("Quantos Elementos 1: " + Comprovante.size());

		for (int i = Comprovante.size() ; i == Comprovante.size(); i++) {

			if (i == 0) {

				// Escrevendo no Console
				System.out.println("Não Possui Comprovantes");

				/** Report Extent **/
				test.log(Status.INFO, "Não Possui Comprovantes");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP08_000_Abrir_Comprovante-NaoPossuiComprovante"));
				/** Report Extent **/ 

			} else {

				// Escrevendo no Console
				System.out.println("Quantos Elementos 2: " + Comprovante.size());
				System.out.println("Quantos Elementos 3: " + i);

				// Buscar o elemento na página
				WebElement AbrirComprovante = Comprovante.get(i - 1);

				// Funcao HighLight
				HighLightElement(AbrirComprovante);

				if (AbrirComprovante.isDisplayed()) {

					// Clicar no Botao 'Abrir Comprovante'
					AbrirComprovante.click();
					Thread.sleep(5000); // Espera 5 segundo

					if (IsElementPresent("//*[text()='Cancelar']")) {

						// Escrevendo no Console
						System.out.println("Comprovante Aberto com Sucesso");

						/** Report Extent **/
						test.log(Status.PASS, "Comprovante Aberto com Sucesso");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP08_000_Abrir_Comprovante-ComprovanteAbertoComSucesso"));
						/** Report Extent **/ 

						// Buscar o elemento na página
						WebElement FecharComprovante = driver.findElement(By.xpath("//*[text()='Cancelar']"));

						// Funcao HighLight
						HighLightElement(FecharComprovante);

						// Clicar no Botao 'Fechar'
						FecharComprovante.click();
						Thread.sleep(2000); // Espera 2 segundo

						// Escrevendo no Console
						System.out.println("Comprovante Fechado com Sucesso");

						/** Report Extent **/
						test.log(Status.PASS, "Comprovante Fechado com Sucesso");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP08_000_Abrir_Comprovante-ComprovanteFechadoComSucesso"));
						/** Report Extent **/ 

					} else {

						// Escrevendo no Console
						System.out.println("Comprovante Não Aberto com Sucesso");

						/** Report Extent **/
						test.log(Status.ERROR, "Comprovante Não Aberto com Sucesso");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP08_000_Abrir_Comprovante-ComprovanteNaoAberto"));
						/** Report Extent **/ 

					}
				} else {
					
					// Escrevendo no Console
					System.out.println("Abrir Comprovante não Visível");

					/** Report Extent **/
					test.log(Status.ERROR, "Abrir Comprovante não Visível");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP08_000_Abrir_Comprovante-ComprovanteNaoVisivel"));
					/** Report Extent **/ 
					
				}
			}

		}

	}	

	
	@Ignore
	@Test
	public void STP09_Aprovar_Deposito_Dinheiro() throws Exception {	
	
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
		test = extent.createTest("TCR02001_ZaterCapitalExchange_Fluxo_Deposito_Finalizar");
		test.assignCategory("Regressão");
		/** Report Extent **/

		/** Report Extent **/
		test.log(Status.PASS, "Browser Encerrado com Sucesso");
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","TCR02001_ZaterCapitalExchange_Fluxo_Deposito_Finalizar-EncerrarSiteComSucesso"));
		/** Report Extent **/

		// Encerra o Report
		extent.flush();

		// Fechar o Browser
		//driver.quit();
		//driver.close();
		
	}

}
