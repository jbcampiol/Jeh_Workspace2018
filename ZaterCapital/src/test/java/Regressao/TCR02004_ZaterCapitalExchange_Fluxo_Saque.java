package Regressao;

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
import Utilitarios.Taxas;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TCR02004_ZaterCapitalExchange_Fluxo_Saque extends FuncoesReusaveis_Windows {

	@BeforeClass
	public static void AbrirBrowser() throws Exception {

		// Chamando o Browser
		InitBrowser("Chrome");

		/** Report Extent **/
		StartReport("TCR02004_ZaterCapitalExchange_Fluxo_Saque_TestResult");
		test = extent.createTest("TCR02004_ZaterCapitalExchange_Fluxo_Saque_Iniciar");
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
		test.log(Status.INFO, "TCR02004_ZaterCapitalExchange_Fluxo_Saque_Iniciar");
		test.log(Status.PASS, "Browser Carregado com Sucesso");	
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","TCR02004_ZaterCapitalExchange_Fluxo_Saque_Iniciar-AbrirSiteComSucesso"));
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
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","TCR02004_ZaterCapitalExchange_Fluxo_Saque_Iniciar-AbrirSiteComSucesso"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("Abrir o Browser - ERROR ao abrir Site da Exchange da Zater Capital");

			/** Report Extent **/
			test.log(Status.ERROR, "Abrir o Browser - ERROR ao abrir Site da Exchange da Zater Capital");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","TCR02004_ZaterCapitalExchange_Fluxo_Saque_Iniciar-ErroAbrirSite"));
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
	public void STP03_000_Navegar_Saques() throws Exception {

		/** Report Extent **/
		test = extent.createTest("STP03_000_Navegar_Saques");
		test.assignCategory("Regressão");
		/** Report Extent **/

		if(IsElementPresent("//*[@class='al-sidebar-list-link ng-scope']")) {

			// Procurando os Menus e colocando em uma Lista
			List<WebElement> ProcurarMenu = driver.findElements(By.xpath("//*[@class='al-sidebar-list-link ng-scope']"));
			
			// Buscar o elemento na página
			WebElement MenuSaques = ProcurarMenu.get(6);

			// Funcao HighLight
			HighLightElement(MenuSaques);

			//Clicar no Menu 'Saques'
			MenuSaques.click();
			Thread.sleep(2000);// esperar 2 segundo
			
			// Escrevendo no Console
			System.out.println("MENU 'Saques' - Visivel");

			/** Report Extent **/
			test.log(Status.PASS, "MENU 'Saques' - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Saques-MENUSaquesVisivel"));
			/** Report Extent **/

			if(IsElementPresent("withdraws")) {

				// Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("/html/body/main/div/div/content-top/div/h1")));
				HighLightElement(driver.findElement(By.xpath("//*[@id='withdraws']/money-withdraws/div/div[1]/div/div/div[1]/h3")));

				// Escrevendo no Console
				System.out.println("Assert: " + driver.findElement(By.xpath("/html/body/main/div/div/content-top/div/h1")).getText());
				System.out.println("Assert: " + driver.findElement(By.xpath("//*[@id='withdraws']/money-withdraws/div/div[1]/div/div/div[1]/h3")).getText());
				
				// Escrevendo no Console
				System.out.println("Saques - Visivel");
				
				/** Report Extent **/
				test.log(Status.PASS, "Saques - Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Saques-SaquesVisivel"));
				/** Report Extent **/		

			} else {

				// Escrevendo no Console
				System.out.println("Saques - Não Visivel");

				/** Report Extent **/
				test.log(Status.ERROR, "Saques - Não Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Saques-SaquesNaoVisivel"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console
			System.out.println("MENU 'Saques' - Não Visivel");

			/** Report Extent **/
			test.log(Status.ERROR, "MENU 'Saques' - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Saques-MENUSaquesNaoVisivel"));
			/** Report Extent **/

		}

	}

	@Test
	public void STP04_000_Saques_Dinheiro() throws Exception  {

		/** Report Extent **/
		test = extent.createTest("STP04_000_Saques_Dinheiro");
		test.assignCategory("Regressão");
		/** Report Extent **/

		String Dinheiro = new String("10000");
		//String Bitcoin = new String("100000000");
		String BitcoinInformado;
		String DinheiroInformado;
		String ValorTaxaServico;
		String ValorLiquido;
		String TaxaTed;

		// Buscar o elemento na pagina
		String saldo_dinheiro = driver.findElement(By.xpath("/html/body/main/page-top/div/div[2]/div[4]")).getText().substring(4);
		String saldo_bitcoin = driver.findElement(By.xpath("/html/body/main/page-top/div/div[2]/div[3]")).getText().substring(4);

		System.out.println("Saldo em Dinheiro: " + saldo_dinheiro);

		// Convertendo a String em Float
		float SaldoBitcoin = Float.valueOf(saldo_bitcoin.replace(",","."));
		float SaldoDinheiro = Float.valueOf(saldo_dinheiro.replace(".", "").replace(",", "."));

		// Informando os valores Minimos
		float ValorMinimoDinheiro = (float) 1000.00;
		float ValorMinimoBitcoin = (float) 0.00000001;

		// Escrevendo no Console	
		System.out.println("Saldo em Dinheiro: " + SaldoDinheiro);
		System.out.println("Saldo em Bitcoins: " + SaldoBitcoin);       
		System.out.println("Saldo Minimo em Dinheiro: " + ValorMinimoDinheiro);
		System.out.println("Saldo Minimo em Bitcoin: " + ValorMinimoBitcoin);

		if (SaldoDinheiro >= ValorMinimoDinheiro ) {

			/** Report Extent **/
			test.log(Status.PASS, "Saque - Saldo Disponivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Saques_Dinheiro-SaqueSaldoDisponivel"));
			/** Report Extent **/

			// Escrevendo no Console	
			System.out.println("Saldo igual ao Minimo: " + SaldoDinheiro + " " + "Minimo: " + ValorMinimoDinheiro);			
			System.out.println("OU");			
			System.out.println("Saldo em Dinheiro: " + SaldoDinheiro + " " + "Maior que o Minimo: " + ValorMinimoDinheiro);

			if(IsElementPresent("//button[text()='Saque']")) {

				// Procurando o Elemento e colocando em uma Lista
				List <WebElement> ButtonSaque = driver.findElements(By.xpath("//button[text()='Saque']"));

				// Colocando o Elemento na variavel
				WebElement SaqueDinheiro = ButtonSaque.get(0);

				// Funcao HighLight
				HighLightElement(SaqueDinheiro);

				// Clicar no Botão 'Saque Dinheiro'
				SaqueDinheiro.click();
				Thread.sleep(2000);// esperar 2 segundo

				// Escrevendo no Console	
				System.out.println("Botão 'Saque Dinheiro' - Visivel");

				/** Report Extent **/
				test.log(Status.PASS, "Botão 'Saque Dinheiro' - Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Saques_Dinheiro-BotaoSaqueDinheiroVisivel"));
				/** Report Extent **/

				if (IsElementSelected("bancos")) {

					// Procurando o Elemento
					WebElement Bancos = driver.findElement(By.name("bancos"));

					// Funcao HighLight
					HighLightElement(Bancos);

					// Escrevendo no Console	
					System.out.println("Banco - Visivel");

					/** Report Extent **/
					test.log(Status.PASS, "Banco - Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Saques_Dinheiro-BancoVisivel"));
					/** Report Extent **/
					
					// Procurando da opção
					Select BancoSelect = new Select(driver.findElement(By.name("bancos")));
					
					// Inserindo em uma lista
					List <WebElement> SelectBancos = BancoSelect.getOptions();
					
					// Escrevendo no Console
					System.out.println("Tamanho: " + SelectBancos.size());
					System.out.println("Select Bancos: " + SelectBancos.size());
					System.out.println("Select Bancos: " + BancoSelect.getOptions());


					/** Função alternativa
						WebElement select = driver.findElement(By.id("gender"));
						List<WebElement> options = select.findElements(By.tagName("option"));

						for (WebElement option : options) {

						if("Germany".equals(option.getText().trim()))

						 option.click();   
						}
					 */
					
					
					if (SelectBancos.size() == 1) { // Rever essa Função
	
						// Procurando o Elemento
						WebElement NovaConta = driver.findElement(By.linkText("Nova Conta"));

						// Funcao HighLight
						HighLightElement(NovaConta);

						// Clicar no Menu 'Nova Conta'
						NovaConta.click();
						Thread.sleep(2000);// esperar 2 segundo

						// Escrevendo no Console	
						System.out.println("Nova Conta - Visivel");

						/** Report Extent **/
						test.log(Status.PASS, "Nova Conta - Visivel");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Saques_Dinheiro-NovaContaVisivel"));
						/** Report Extent **/

						if (IsElementPresent("nome-banco")) {

							// Procurando o Elemento
							WebElement NomeBanco = driver.findElement(By.name("nome-banco"));

							// Funcao HighLight
							HighLightElement(NomeBanco);

							// Inserindo o Nome do Banco
							NomeBanco.sendKeys("Itaú");
							Thread.sleep(2000);// esperar 2 segundo

							// Escrevendo no Console	
							System.out.println("Campo 'Nome Banco' - Visivel");

							/** Report Extent **/
							test.log(Status.PASS, "Campo 'Nome Banco' - Visivel");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Saques_Dinheiro-NomeBancoVisivel"));
							/** Report Extent **/

						} else {

							// Escrevendo no Console	
							System.out.println("Campo 'Nome Banco' - Não Visivel");

							/** Report Extent **/
							test.log(Status.ERROR, "Campo 'Nome Banco' - Não Visivel");
							test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Saques_Dinheiro-NomeBancoNaoVisivel"));
							/** Report Extent **/

						}

						if (IsElementPresent("numero-agencia")) {

							// Procurando o Elemento
							WebElement NumeroAgencia = driver.findElement(By.name("numero-agencia"));

							// Funcao HighLight
							HighLightElement(NumeroAgencia);

							// Inserindo o Numero da Agencia
							NumeroAgencia.sendKeys("0136");
							Thread.sleep(2000);// esperar 2 segundo

							// Escrevendo no Console	
							System.out.println("Campo 'Número da Agência'- Visivel");

							/** Report Extent **/
							test.log(Status.PASS, "Campo 'Número da Agência'- Visivel");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Saques_Dinheiro-NumeroAgenciaVisivel"));
							/** Report Extent **/

						} else {

							// Escrevendo no Console	
							System.out.println("Campo 'Número da Agência'- Não Visivel");

							/** Report Extent **/
							test.log(Status.ERROR, "Campo 'Número da Agência'- Não Visivel");
							test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Saques_Dinheiro-NumeroAgenciaNaoVisivel"));
							/** Report Extent **/

						}

						if (IsElementPresent("conta-corrente")) {

							// Procurando o Elemento
							WebElement ContaCorrente = driver.findElement(By.name("conta-corrente"));

							// Funcao HighLight
							HighLightElement(ContaCorrente);

							// Inserindo o Numero da Conta Corrente
							ContaCorrente.sendKeys("12076-3");
							Thread.sleep(2000);// esperar 2 segundo

							// Escrevendo no Console	
							System.out.println("Campo 'Conta Corrente'- Visivel");

							/** Report Extent **/
							test.log(Status.PASS, "Campo 'Conta Corrente'- Visivel");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Saques_Dinheiro-ContaCorrenteVisivel"));
							/** Report Extent **/

						} else {

							// Escrevendo no Console	
							System.out.println("Campo 'Conta Corrente'- Não Visivel");

							/** Report Extent **/
							test.log(Status.ERROR, "Campo 'Conta Corrente'- Não Visivel");
							test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Saques_Dinheiro-ContaCorrenteNaoVisivel"));
							/** Report Extent **/

						}

						if (IsElementPresent("codigo-banco")) {

							// Procurando o Elemento
							WebElement CodigoBanco = driver.findElement(By.name("codigo-banco"));

							// Funcao HighLight
							HighLightElement(CodigoBanco);

							// Inserindo o Código do Banco
							CodigoBanco.sendKeys("341");
							Thread.sleep(2000);// esperar 2 segundo

							// Escrevendo no Console	
							System.out.println("Campo 'Código do Banco'- Visivel");

							/** Report Extent **/
							test.log(Status.PASS, "Campo 'Código do Banco'- Visivel");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Saques_Dinheiro-CodigoBancoVisivel"));
							/** Report Extent **/

						} else {

							// Escrevendo no Console	
							System.out.println("Campo 'Código do Banco'- Não Visivel");

							/** Report Extent **/
							test.log(Status.ERROR, "Campo 'Código do Banco'- Não Visivel");
							test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Saques_Dinheiro-CodigoBancoNaoVisivel"));
							/** Report Extent **/

						}

						if (IsElementPresent("//button[text()='Cadastrar banco']")) {

							// Procurando o Elemento
							WebElement CadastrarBanco = driver.findElement(By.xpath("//button[text()='Cadastrar banco']"));

							// Funcao HighLight
							HighLightElement(CadastrarBanco);

							// Clicar no Botão 'Cadastrar'
							CadastrarBanco.click();
							Thread.sleep(2000);// esperar 2 segundo

							// Escrevendo no Console	
							System.out.println("Botão 'Cadastrar banco'- Visivel");

							/** Report Extent **/
							test.log(Status.PASS, "Botão 'Cadastrar banco'- Visivel");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Saques_Dinheiro-BotaoCadastrarBancoVisivel"));
							/** Report Extent **/

						} else {

							// Escrevendo no Console	
							System.out.println("Botão 'Cadastrar banco'- Não Visivel");

							/** Report Extent **/
							test.log(Status.ERROR, "Campo 'Código do Banco'- Não Visivel");
							test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Saques_Dinheiro-BotaoCadastrarBancoNaoVisivel"));
							/** Report Extent **/

						}

					}	
					
					// Selecionando o Banco
					BancoSelect.selectByVisibleText("Itaú");
					Thread.sleep(2000); // Espera 2 segundo

					// Escrevendo no Console	
					System.out.println("Selecionar Banco");

					/** Report Extent **/
					test.log(Status.PASS, "Selecionar Banco");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Saques_Dinheiro-SelecionarBanco"));
					/** Report Extent **/

					if (IsElementPresent("valor-retirada")) {

						// Procurando o Elemento
						WebElement ValorRetirada = driver.findElement(By.name("valor-retirada"));

						// Funcao HighLight
						HighLightElement(ValorRetirada);

						// Inserindo o Valor para Retirada
						ValorRetirada.sendKeys(Dinheiro);
						Thread.sleep(2000);// esperar 2 segundo

						// Escrevendo no Console	
						System.out.println("Campo 'Valor da Retirada' - Visivel");

						/** Report Extent **/
						test.log(Status.PASS, "Campo 'Valor da Retirada' - Não Visivel");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Saques_Dinheiro-ValorRetiradaVisivel"));
						/** Report Extent **/

					} else {

						// Escrevendo no Console	
						System.out.println("Campo 'Valor da Retirada' - Não Visivel");

						/** Report Extent **/
						test.log(Status.ERROR, "Campo 'Valor da Retirada' - Não Visivel");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Saques_Dinheiro-ValorRetiradaNaoVisivel"));
						/** Report Extent **/

					}

					if (IsElementPresent("//button[text()='Confirmar']")) {

						// Lista contendo os Elementos
						List <WebElement> ListaConfirmar = driver.findElements(By.xpath("//button[text()='Confirmar']"));

						// Procurando o Elemento
						WebElement Confirmar = ListaConfirmar.get(1);

						// Escrevendo no Console	
						System.out.println("Botão 'Confirmar' - Visivel");

						/** Report Extent **/
						test.log(Status.PASS, "Botão 'Confirmar' - Visivel");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Saques_Dinheiro-BotaoCofirmarVisivel"));
						/** Report Extent **/

							/** Armazenando os valores as Taxas	 */		
							// Procurando o Elemento e colocando em uma Lista
							List <WebElement> Taxa = driver.findElements(By.id("valor-taxado"));
	
							// Buscar o elemento na pagina
							TaxaTed = Taxa.get(0).getAttribute("value").substring(3);
							BitcoinInformado = TaxaTed; // BitcoinInformado está assumindo o Campo TaxaTed para otimizar a variavel
							
							ValorTaxaServico = Taxa.get(1).getAttribute("value").substring(0,4);
							ValorLiquido = Taxa.get(2).getAttribute("value").substring(3);
	
							// Procurando o Elemento
							DinheiroInformado = driver.findElement(By.name("valor-retirada")).getAttribute("value").substring(3);
	
							// Escrevendo no Console	
							System.out.println(BitcoinInformado); 
							System.out.println(DinheiroInformado); 
							System.out.println(TaxaTed);
							System.out.println(ValorTaxaServico); 
							System.out.println(ValorLiquido);
							/** */

						// Função que retorna a String OK ou NOK
						String ValidadorTaxa = Taxas.TaxasZater("Normal", "Money", "Withdraw", "Ativa", BitcoinInformado, DinheiroInformado, ValorTaxaServico, ValorLiquido);
						String StatusTaxa = "OK";

						// Escrevendo no Console
						System.out.println(ValidadorTaxa);	
						System.out.println(StatusTaxa);

						if (ValidadorTaxa.equals(StatusTaxa)) {

							// Funcao HighLight
							HighLightElement(Confirmar);

							// Clicar no Botão 'Confirmar'
							Confirmar.click();
							Thread.sleep(2000);// esperar 2 segundo

							// Escrevendo no Console
							System.out.println("TAXA SAQUE ATIVA OK");

							/** Report Extent **/
							test.log(Status.PASS, "TAXA SAQUE ATIVA OK");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Saques_Dinheiro-TAXASAQUEATIVAOK"));
							/** Report Extent **/

						} else {

							// Lista contendo os Elementos
							List <WebElement> ListaCancelar = driver.findElements(By.xpath("//button[text()='Cancelar']"));

							// Procurando o Elemento
							WebElement Cancelar = ListaCancelar.get(1);

							// Escrevendo no Console	
							System.out.println("Botão 'Confirmar' - Visivel");
							
							// Funcao HighLight
							HighLightElement(Cancelar);

							// Clicar no Botão 'Cancelar'
							Cancelar.click();
							Thread.sleep(2000);// esperar 2 segundo

							// Escrevendo no Console
							System.out.println("TAXA SAQUE ATIVA NOK");
							System.out.println("SAQUE CANCELADO");

							/** Report Extent **/
							test.log(Status.ERROR, "TAXA SAQUE ATIVA NOK");
							test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Saques_Dinheiro-TAXASAQUEATIVANOK"));
							/** Report Extent **/

						}

					} else {

						// Escrevendo no Console	
						System.out.println("Botão 'Confirmar' - Não Visivel");

						/** Report Extent **/
						test.log(Status.ERROR, "Botão 'Confirmar' - Não Visivel");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Saques_Dinheiro-BotaoCofirmarNaoVisivel"));
						/** Report Extent **/

					}

				} else {

					// Escrevendo no Console	
					System.out.println("Banco - Não Visivel");

					/** Report Extent **/
					test.log(Status.ERROR, "Banco - Não Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Saques_Dinheiro-BancoNaoVisivel"));
					/** Report Extent **/

				}

			} else {

				// Escrevendo no Console	
				System.out.println("Botão 'Saque Dinheiro' - Não Visivel");

				/** Report Extent **/
				test.log(Status.ERROR, "Botão 'Saque Dinheiro' - Não Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Saques_Dinheiro-BotaoSaqueDinheiroNaoVisivel"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console	
			System.out.println("Saldo em Dinheiro nao permitido: " + "Saldo Atual: " + SaldoDinheiro + " " + "Minimo: " + ValorMinimoDinheiro);

			/** Report Extent **/
			test.log(Status.ERROR, "Saque - Saldo Não Disponivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Saques_Dinheiro-SaqueSaldoNaoDisponivel"));
			/** Report Extent **/
			
		} 

	}

	@Test
	public void STP05_000_Saques_Bitcoin() throws Exception {

		/** Report Extent **/
		test = extent.createTest("STP05_000_Saques_Bitcoin");
		test.assignCategory("Regressão");
		/** Report Extent **/

		String Bitcoin = new String("100000000");
		String Wallet = new String("2N3jR4XaH9rPdJ7dVZSEukLaDqzECKfV4Cu");
		//String Dinheiro = new String("100000");	
		
		String BitcoinInformado;
		String DinheiroInformado;
		String ValorTaxaServico;
		String ValorLiquido;
		//String TaxaOperacao;

		// Buscar o elemento na pagina
		String saldo_dinheiro = driver.findElement(By.xpath("/html/body/main/page-top/div/div[2]/div[4]")).getText().substring(4);
		String saldo_bitcoin = driver.findElement(By.xpath("/html/body/main/page-top/div/div[2]/div[3]")).getText().substring(4);

		System.out.println("Saldo em Dinheiro: " + saldo_dinheiro);

		// Convertendo a String em Float
		float SaldoBitcoin = Float.valueOf(saldo_bitcoin.replace(",","."));
		float SaldoDinheiro = Float.valueOf(saldo_dinheiro.replace(".", "").replace(",", "."));

		// Informando os valores Minimos
		float ValorMinimoDinheiro = (float) 1000.00;
		float ValorMinimoBitcoin = (float) 0.00000001;

		// Escrevendo no Console	
		System.out.println("Saldo em Dinheiro: " + SaldoDinheiro);
		System.out.println("Saldo em Bitcoins: " + SaldoBitcoin);       
		System.out.println("Saldo Minimo em Dinheiro: " + ValorMinimoDinheiro);
		System.out.println("Saldo Minimo em Bitcoin: " + ValorMinimoBitcoin);

		if (SaldoBitcoin >= ValorMinimoBitcoin ) {
		
			/** Report Extent **/
			test.log(Status.PASS, "Saque - Saldo Em BitCoins Disponivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Saques_Bitcoin-SaqueSaldoDisponivel"));
			/** Report Extent **/

			// Escrevendo no Console	
			System.out.println("Saldo igual ao Minimo: " + SaldoBitcoin + " " + "Minimo: " + ValorMinimoBitcoin);			
			System.out.println("OU");			
			System.out.println("Saldo em Bitcoin: " + SaldoBitcoin + " " + "Maior que o Minimo: " + ValorMinimoBitcoin);
			
			if(IsElementPresent("//button[text()='Saque']")) {

				// Procurando o Elemento e colocando em uma Lista
				List <WebElement> BotaoSaque = driver.findElements(By.xpath("//button[text()='Saque']"));

				// Colocando o Elemento na variavel
				WebElement SaqueBitcoin = BotaoSaque.get(1);

				// Funcao HighLight
				HighLightElement(SaqueBitcoin);

				// Clicar no Botão 'Saque de Bitcoins'
				SaqueBitcoin.click();
				Thread.sleep(2000);// esperar 2 segundo

				// Escrevendo no Console	
				System.out.println("Botão 'Saque Bitcoin' - Visivel");

				/** Report Extent **/
				test.log(Status.PASS, "Botão 'Saque Bitcoin' - Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Saques_Bitcoin-BotaoSaqueBitcoinVisivel"));
				/** Report Extent **/
					
				//if (IsElementPresent("activate-two-steps")) {
				//while (driver.findElement(By.xpath("/html/body/div[1]/div/div")).getAttribute("innerText").contains("Autenticação de dois fatores")) {
				
				while (driver.findElement(By.xpath("//*[@id='activate-two-steps']/div[2]/form/fieldset/div[1]/img")).isDisplayed()) {
								
					// Escrevendo no Console	
					System.out.println("Texto: " + driver.findElement(By.xpath("/html/body/div[1]/div/div")).getAttribute("innerText"));
					System.out.println("Active Visivel");
					
					/** Report Extent **/
					test.log(Status.PASS, "QRCode' - Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Saques_Bitcoin-QRCodeVisivel"));
					/** Report Extent **/
					
					// Colocando o Elemento na variavel
					WebElement QRCode = driver.findElement(By.xpath("//*[@id='activate-two-steps']/div[2]/form/fieldset/div[1]/img"));
					
					// Funcao HighLight
					HighLightElement(QRCode);
								
					// Colocando o Elemento na variavel
					String QRCode_Html = QRCode.getAttribute("src");
					String QRCode_format = QRCode.getAttribute("src").substring(67);
					String QRCode_AccountName = QRCode.getAttribute("src").substring(82,88);
					String QRCode_SecretKey = QRCode.getAttribute("src").substring(96);
					
					// Escrevendo no Console	
					System.out.println(QRCode_Html);
					System.out.println(QRCode_format);
					System.out.println(QRCode_AccountName);
					System.out.println(QRCode_SecretKey);
					
					// Chamando a Função para validar o QRCode
					String Validador = Gauth(QRCode_AccountName, QRCode_SecretKey);
					
					// Escrevendo no Console	
					System.out.println("Google: " + Validador);
					
					if (QRCode.isDisplayed()) {
						
						// Funcao HighLight
						HighLightElement(QRCode);
						
						// Colocando o Elemento na variavel
						WebElement InserirQRCode = driver.findElement(By.xpath("//*[@id='activate-two-steps']/div[2]/form/fieldset/div[2]/input"));
						
						// Funcao HighLight
						HighLightElement(InserirQRCode);
						
						// Inserir o Código
						InserirQRCode.sendKeys(Validador);
						Thread.sleep(2000);// esperar 2 segundo
						
						// Escrevendo no Console	
						System.out.println("Inserindo o Validador" + Validador);
						
						// Colocando o Elemento na variavel
						WebElement ButtonHabilitar = driver.findElement(By.xpath("//*[@id='activate-two-steps']/div[2]/form/fieldset/div[3]/button"));
						
						// Funcao HighLight
						HighLightElement(ButtonHabilitar);
						
						// Clicar no Botão Habilitar
						ButtonHabilitar.click();
						Thread.sleep(5000);// esperar 2 segundo
						
						// Escrevendo no Console	
						System.out.println("Clicar no Botão 'Habilitar'");

						/** Report Extent **/
						test.log(Status.PASS, "Habilitar QRCode");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Saques_Bitcoin-QRCodeHabilitado"));
						/** Report Extent **/
						
					} else {
					
						// Escrevendo no Console	
						System.out.println("QRCode Não Habilitado");

						/** Report Extent **/
						test.log(Status.ERROR, "Botão 'Habilitar' - Não Visivel");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Saques_Bitcoin-QRCodeNaoHabilitado"));
						/** Report Extent **/
						
					}
					
				}
								
				if (IsElementPresent("valor-desejado")) {
					
					// Colocando o Elemento na variavel
					WebElement ValorDesejado = driver.findElement(By.id("valor-desejado"));
					
					// Funcao HighLight
					HighLightElement(ValorDesejado);
					
					// Inserir o Valor Desejado
					ValorDesejado.sendKeys(Bitcoin);
					Thread.sleep(2000);// esperar 2 segundo
					
					// Escrevendo no Console	
					System.out.println("Inserindo Valor Desejado");

					/** Report Extent **/
					test.log(Status.PASS, "Inserindo Valor Desejado");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Saques_Bitcoin-ValorDesejadoInserido"));
					/** Report Extent **/
					
				} else {
					
					// Escrevendo no Console	
					System.out.println("Campo 'Valor Desejado' - Não Visivel");

					/** Report Extent **/
					test.log(Status.ERROR, "Campo 'Valor Desejado' - Não Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Saques_Bitcoin-CampoValorDesejadoNaoVisivel"));
					/** Report Extent **/
					
				}
				
				if (IsElementPresent("wallet")) {
					
					// Colocando o Elemento na variavel
					WebElement CampoWallet = driver.findElement(By.id("wallet"));
					
					// Funcao HighLight
					HighLightElement(CampoWallet);
					
					// Inserir o Número da Wallet
					CampoWallet.sendKeys(Wallet);
					Thread.sleep(2000);// esperar 2 segundo
					
					// Escrevendo no Console	
					System.out.println("Inserindo Número da Wallet");

					/** Report Extent **/
					test.log(Status.PASS, "Inserindo Número da Wallet");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Saques_Bitcoin-WalletInserido"));
					/** Report Extent **/;
					
				} else {
					
					// Escrevendo no Console	
					System.out.println("Campo 'Wallet' - Não Visível");

					/** Report Extent **/
					test.log(Status.ERROR, "Campo 'Wallet' - Não Visível");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Saques_Bitcoin-CampoWalletNaoVisivil"));
					/** Report Extent **/
					
				}
				
				if (IsElementEnabled("/html/body/div[1]/div/div/div[1]/div/form/div[2]/button[2]")) {
					
					// Procurando o Elemento e colocando em uma Lista
					List <WebElement> ButtonConfirmar = driver.findElements(By.xpath("//button[text()='Confirmar']"));

					// Colocando o Elemento na variavel
					WebElement Confirmar = ButtonConfirmar.get(0);
				
					// Escrever no Console
					System.out.println("Botão 'Confirmar' - Visível"); 
					
					/** Report Extent **/
					test.log(Status.PASS, "Botão 'Confirmar' - Visível");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Saques_Bitcoin-BotaoConfirmarVisivel"));
					/** Report Extent **/
					
						/** Armazenando os valores as Taxas	 */								
						// Procurando o Elemento
						BitcoinInformado = driver.findElement(By.id("valor-desejado")).getAttribute("value");
	
						// Buscar o elemento na pagina
						ValorTaxaServico = driver.findElement(By.id("valor-desejado")).getAttribute("value").substring(0, 4);
						
						// Buscar o elemento na pagina
						ValorLiquido = driver.findElement(By.id("valor-desejado")).getAttribute("value");
							
						// Variavel
						DinheiroInformado = "0"; // DinheiroInformado está assumindo o Campo TaxaOpercao para otimizar a variavel	
					
						// Escrevendo no Console	
						System.out.println(BitcoinInformado); 
						System.out.println(DinheiroInformado); 
						//System.out.println(TaxaTed);
						System.out.println(ValorTaxaServico); 
						System.out.println(ValorLiquido);
						/** */
	
						// Função que retorna a String OK ou NOK
						String ValidadorTaxa = Taxas.TaxasZater("Normal", "Money", "Withdraw", "Ativa", BitcoinInformado, DinheiroInformado, ValorTaxaServico, ValorLiquido);
						String StatusTaxa = "OK";
	
						// Escrevendo no Console
						System.out.println(ValidadorTaxa);	
						System.out.println(StatusTaxa);
						
						if (ValidadorTaxa.equals(StatusTaxa)) {

							// Funcao HighLight
							HighLightElement(Confirmar);

							// Clicar no Botão Confirmar
							Confirmar.click();
							Thread.sleep(2000);// esperar 2 segundo

							// Escrevendo no Console
							System.out.println("TAXA SAQUE ATIVA OK");
							System.out.println("SAQUE CANCELADO");

							/** Report Extent **/
							test.log(Status.PASS, "TAXA SAQUE ATIVA OK");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Saques_Bitcoin-TAXASAQUEATIVAOK"));
							/** Report Extent **/
												
						} else {

							// Lista contendo os Elementos
							List <WebElement> ButtonCancelar = driver.findElements(By.xpath("//button[text()='Cancelar']"));

							// Procurando o Elemento
							WebElement Cancelar = ButtonCancelar.get(0);

							// Escrevendo no Console	
							System.out.println("Botão 'Cancelar' - Visivel");
							
							// Funcao HighLight
							HighLightElement(Cancelar);

							// Clicar no Botão Confirmar
							Cancelar.click();
							Thread.sleep(2000);// esperar 2 segundo

							// Escrevendo no Console
							System.out.println("TAXA SAQUE ATIVA NOK");
							System.out.println("SAQUE CANCELADO");

							/** Report Extent **/
							test.log(Status.ERROR, "TAXA SAQUE ATIVA NOK");
							test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Saques_Bitcoin-TAXASAQUEATIVANOK"));
							/** Report Extent **/
							
						}
		
				} else {
					
					// Escrevendo no Console	
					System.out.println("Botão 'Confirmar' - Não Visível");

					/** Report Extent **/
					test.log(Status.ERROR, "Botão 'Confirmar' - Não Visível");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Saques_Bitcoin-BotaoConfirmarNaoVisivel"));
					/** Report Extent **/
					
				}
				
			} else {
				
				// Escrevendo no Console	
				System.out.println("Botão 'Saque Bitcoin' - Não Visivel");

				/** Report Extent **/
				test.log(Status.ERROR, "Botão 'Saque Bitcoin' - Não Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Saques_Bitcoin-BotaoSaqueBitcoinNaoVisivel"));
				/** Report Extent **/
			
			}
			
		} else {
			
			// Escrevendo no Console	
			System.out.println("Saldo em Bitcoin Não Permitido: " + "Saldo Atual: " + SaldoBitcoin + " " + "Minimo: " + ValorMinimoBitcoin);

			/** Report Extent **/
			test.log(Status.ERROR, "Saque - Saldo em Bitcoin Não Disponivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Saques_Bitcoin-SaqueSaldoBitcoinNaoDisponivel"));
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
		test = extent.createTest("TCR02004_ZaterCapitalExchange_Fluxo_Saque_Finalizar");
		test.assignCategory("Regressão");
		/** Report Extent **/

		/** Report Extent **/
		test.log(Status.PASS, "Browser Encerrado com Sucesso");
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","TCR02004_ZaterCapitalExchange_Fluxo_Saque_Finalizar-EncerrarSiteComSucesso"));
		/** Report Extent **/

		// Encerra o Report
		extent.flush();

		// Fechar o Browser
		driver.quit();
		//driver.close();

	}

}
