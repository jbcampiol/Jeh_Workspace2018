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

import com.aventstack.extentreports.Status;

import Utilitarios.Dados_Windows;
import Utilitarios.FuncoesReusaveis_Windows;
import Utilitarios.Taxas;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TCR02003_ZaterCapitalExchange_Fluxo_Vender extends FuncoesReusaveis_Windows {

	@BeforeClass
	public static void AbrirBrowser() throws Exception {

		// Chamando o Browser
		InitBrowser("Chrome");

		/** Report Extent **/
		StartReport("TCR02003_ZaterCapitalExchange_Fluxo_Vender_TestResult");
		test = extent.createTest("TCR02003_ZaterCapitalExchange_Fluxo_Vender_Iniciar");
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
		test.log(Status.INFO, "TCR02003_ZaterCapitalExchange_Fluxo_Vender_Iniciar");
		test.log(Status.PASS, "Browser Carregado com Sucesso");	
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","TCR02003_ZaterCapitalExchange_Fluxo_Vender_Iniciar-AbrirSiteComSucesso"));
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
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","TCR07_ZaterCapitalExchange_Fluxo_Vender_Iniciar-AbrirSiteComSucesso"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("Abrir o Browser - ERROR ao abrir Site da Exchange da Zater Capital");

			/** Report Extent **/
			test.log(Status.ERROR, "Abrir o Browser - ERROR ao abrir Site da Exchange da Zater Capital");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","TCR02003_ZaterCapitalExchange_Fluxo_Vender_Iniciar-ErroAbrirSite"));
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
	public void STP03_000_Navegar_Vender() throws Exception {

		/** Report Extent **/
		test = extent.createTest("STP03_000_Navegar_Vender");
		test.assignCategory("Regressão");
		/** Report Extent **/

		if(IsElementPresent("//*[@class='al-sidebar-list-link ng-scope']")) {

			// Procurando os Menus e colocando em uma Lista
			List<WebElement> ProcurarMenu = driver.findElements(By.xpath("//*[@class='al-sidebar-list-link ng-scope']"));
			
			// Buscar o elemento na página
			WebElement MenuVender = ProcurarMenu.get(5);
			
			// Funcao HighLight
			HighLightElement(MenuVender);

			//Clicar no Menu 'Vender'
			MenuVender.click();
			Thread.sleep(2000);// esperar 2 segundo
			
			// Escrevendo no Console
			System.out.println("MENU Vender - Visivel");

			/** Report Extent **/
			test.log(Status.PASS, "MENU Vender - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_Navegar_Vender-MENUVenderVisivel"));
			/** Report Extent **/

			if(IsElementPresent("sell")) {

				// Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("/html/body/main/div/div/content-top/div/h1")));
				HighLightElement(driver.findElement(By.xpath("//*[@id='sell']/sell-exchange/div/div/div/div/div[1]/h3")));

				// Escrevendo no Console
				System.out.println("Assert: " + driver.findElement(By.xpath("/html/body/main/div/div/content-top/div/h1")).getText());
				System.out.println("Assert: " + driver.findElement(By.xpath("//*[@id='sell']/sell-exchange/div/div/div/div/div[1]/h3")).getText());
				System.out.println("Vender - Visivel");
				
				/** Report Extent **/
				test.log(Status.PASS, "Vender - Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_Navegar_Vender-VenderVisivel"));
				/** Report Extent **/				

			} else {

				// Escrevendo no Console
				System.out.println("Vender - Não Visivel");

				/** Report Extent **/
				test.log(Status.ERROR, "Vender - Não Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_Navegar_Vender-VenderNaoVisivel"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console
			System.out.println("MENU Vender - Não Visivel");

			/** Report Extent **/
			test.log(Status.ERROR, "MENU Vender - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_Navegar_Vender-MENUVenderNaoVisivel"));
			/** Report Extent **/

		}

	}

	@Test
	public void STP04_000_Vender() throws Exception{

		/** Report Extent **/
		test = extent.createTest("STP04_000_Vender");
		test.assignCategory("Regressão");
		/** Report Extent **/

		String Dinheiro = new String("100000");
		String Bitcoin = new String("100000000");
		String BitcoinInformado;
		String DinheiroInformado;
		String ValorTaxaServico;
		String ValorLiquido;

		// Buscar o elemento na pagina
		String saldo_dinheiro = driver.findElement(By.xpath("/html/body/main/page-top/div/div[2]/div[4]")).getText().substring(4);
		String saldo_bitcoin = driver.findElement(By.xpath("/html/body/main/page-top/div/div[2]/div[3]")).getText().substring(4);

		System.out.println("Saldo em Dinheiro: " + saldo_dinheiro);
		System.out.println("Saldo em Bitcoin: " + saldo_bitcoin);

		// Convertendo a String em Float
		float SaldoBitcoin = Float.valueOf(saldo_bitcoin.replace(",","."));
		float SaldoDinheiro = Float.valueOf(saldo_dinheiro.replace(".", "").replace(",", "."));

		// Informando os valores Minimos
		double ValorMinimoDinheiro = 1000.00;
		double ValorMinimoBitcoin = 0.00000001;

		// Escrevendo no Console	
		System.out.println("Saldo em Dinheiro: " + SaldoDinheiro);
		System.out.println("Saldo em Bitcoins: " + SaldoBitcoin);       
		System.out.println("Saldo Minimo em Dinheiro: " + ValorMinimoDinheiro);
		System.out.println("Saldo Minimo em Bitcoin: " + ValorMinimoBitcoin);

		/**
		 * // Comprando as Strings
		 * //int permitido = Collator.getInstance().compare(saldo_dinheiro, valor_minimo_dinheiro);
		 * // Escrevendo no Console
		 * //System.out.println(permitido);
		 * //if (permitido == 0 || permitido == 1) {}
		 */

		/** 
		 * retorna -1 se a primeira string vier antes da outra na ordem do dicionario
		 * retorna 1 se a primeira string vier depois da outra na ordem do dicionario
		 * retorna 0 se as duas strings forem exatamente iguais !
		 */

		if (SaldoBitcoin >= ValorMinimoBitcoin ) {

			/** Report Extent **/
			test.log(Status.PASS, "Vender - Saldo Disponivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Vender-ComprarSaldoDisponivel"));
			/** Report Extent **/

			// Escrevendo no Console	
			System.out.println("Saldo igual ao Minimo: " + SaldoBitcoin + " " + "Minimo: " + ValorMinimoBitcoin);			
			System.out.println("OU");			
			System.out.println("Saldo em Dinheiro: " + SaldoBitcoin + " " + "Maior que o Minimo: " + ValorMinimoBitcoin);

			if (IsElementPresent("sell")) {

				// Escrevendo no Console	
				System.out.println("Formulario de Venda esta Visivel");

				/** Report Extent **/
				test.log(Status.PASS, "Formulario de Venda esta Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Vender-FormularioVendaVisivel"));
				/** Report Extent **/

				if(driver.findElement(By.xpath("//*[@id='sell']/sell-exchange/div/div/div/div/div[3]")).getText().contains("Não existe ordem de compra no livro.")) {

					// Escrevendo no Console	
					System.out.println("Não existe ordem de venda no livro.");

					/** Report Extent **/
					test.log(Status.PASS, "Não existe ordem de venda no livro.");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Vender-NaoExiteOrdemDeVendaNoLivro"));
					/** Report Extent **/

					// Compra Mercado
					if (IsElementEnabled("//*[@id='sell']/sell-exchange/div/div/div/div/div[3]/form/fieldset/div[2]/a") && IsElementPresent("//*[@id='sell']/sell-exchange/div/div/div/div/div[3]/form/fieldset/div[2]/a")) {

						// Escrevendo no Console	
						System.out.println("Botao 'Opcao Avancada' Visivel");

						// Colocando o Elemento na variavel
						WebElement opcao_avancada = driver.findElement(By.xpath("//*[@id='sell']/sell-exchange/div/div/div/div/div[3]/form/fieldset/div[2]/a"));

						// Funcao HighLight
						HighLightElement(opcao_avancada);

						// Clicar no Botao Comprar
						opcao_avancada.click();
						Thread.sleep(2000);// esperar 1 segundo

						/** Report Extent **/
						test.log(Status.PASS, "Botao 'Opcao Avancada' Visivel");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Vender-BotaoOpcaoAvancadaVisivel"));
						/** Report Extent **/

						if (IsElementEnabled("quantidade-btc") && IsElementPresent("quantidade-btc")) {

							// Procurando o Elemento e colocando em uma Lista
							List <WebElement> vender_bitcoins = driver.findElements(By.id("quantidade-btc"));

							// Colocando o Elemento na variavel
							WebElement sell_quantidade = vender_bitcoins.get(1);

							// Funcao HighLight
							HighLightElement(sell_quantidade);

							// Inserindo o Valor para Comprar
							sell_quantidade.sendKeys(Bitcoin);
							Thread.sleep(2000);// esperar 2 segundo

							// Escrevendo no Console	
							System.out.println("Campo 'Insira a quantidade de BItcoins que deseja vender' - Visivel - Vender no Mercado");

							/** Report Extent **/
							test.log(Status.PASS, "Campo 'Insira a quantidade de BItcoins que deseja vender' - Visivel - Vender no Mercado");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Vender-QuantidadeBTCVisivel"));
							/** Report Extent **/

						} else {

							// Escrevendo no Console	
							System.out.println("Campo 'Insira a quantidade de BItcoins que deseja vender' Não Visivel ou nao Editavel - Vender no Mercado");

							/** Report Extent **/
							test.log(Status.ERROR, "Campo 'Insira a quantidade de BItcoins que deseja vender' Não Visivel ou nao Editavel - Vender no Mercado");
							test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Vender-QuantidadeBTCNaoVisivel"));
							/** Report Extent **/

						}

						if (IsElementEnabled("//*[@id='sell-on-board']/div/div/div/div/div[3]/form/fieldset/div[1]/div/div[2]/div/input") && IsElementPresent("//*[@id='sell-on-board']/div/div/div/div/div[3]/form/fieldset/div[1]/div/div[2]/div/input")) {

							// Buscando o Elemento
							WebElement campo_vender_reais = driver.findElement(By.xpath("//*[@id='sell-on-board']/div/div/div/div/div[3]/form/fieldset/div[1]/div/div[2]/div/input"));

							// Funcao HighLight
							HighLightElement(campo_vender_reais);

							// Inserindo o Valor para Comprar
							campo_vender_reais.sendKeys(Dinheiro);
							Thread.sleep(2000);// esperar 2 segundo

							// Escrevendo no Console	
							System.out.println("Campo 'Insira o valor que deseja receber pelo BTC Inteiro' - Visivel - Vender no Mercado");

							/** Report Extent **/
							test.log(Status.PASS, "Campo 'Insira o valor que deseja receber pelo BTC Inteiro' - Visivel - Vender no Mercado");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Vender-ValorBTCInteiroVisivel"));
							/** Report Extent **/

						} else {

							// Escrevendo no Console	
							System.out.println("Campo 'Insira o valor que deseja receber pelo BTC Inteiro' - Não Visivel - Vender no Mercado");

							/** Report Extent **/
							test.log(Status.ERROR, "Campo 'Insira o valor que deseja receber pelo BTC Inteiro' - Não Visivel - Vender no Mercado");
							test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Vender-ValorBTCInteiroNaoVisivel"));
							/** Report Extent **/

						}	

						if (IsElementEnabled("//button[@type='submit']") && IsElementPresent("//button[@type='submit']")) {

							// Escrevendo no Console	
							System.out.println("Botao 'Vender' Visivel - Vender no Mercado");

							/** Report Extent **/
							test.log(Status.PASS, "Botao 'Vender' Visivel - Vender no Mercado");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Vender-BotaoVenderMercadoVisivel"));
							/** Report Extent **/

							/** Armazenando os valores as Taxas	 */
							// Procurando o Elemento e colocando em uma Lista
							List <WebElement> bitcoins_informado = driver.findElements(By.id("quantidade-btc"));

							// Buscar o elemento na pagina
							BitcoinInformado = bitcoins_informado.get(1).getAttribute("value");

							// Buscar o elemento na pagina
							DinheiroInformado = driver.findElement(By.xpath("//*[@id='sell-on-board']/div/div/div/div/div[3]/form/fieldset/div[1]/div/div[2]/div/input")).getAttribute("value").substring(3);

							// Procurando o Elemento e colocando em uma Lista
							List <WebElement> valor_taxa = driver.findElements(By.id("total-btc"));

							// Colocando o Elemento na variavel
							ValorTaxaServico = valor_taxa.get(2).getAttribute("value").substring(3);
							ValorLiquido = valor_taxa.get(3).getAttribute("value").substring(3);

							// Escrevendo no Console	
							System.out.println(BitcoinInformado); 
							System.out.println(DinheiroInformado); 
							System.out.println(ValorTaxaServico); 
							System.out.println(ValorLiquido);
							/** */

							// Função que retorna a String OK ou NOK
							String ValidadorTaxa = Taxas.TaxasZater("Normal", "BTC", "Sell", "Passiva", BitcoinInformado, DinheiroInformado, ValorTaxaServico, ValorLiquido);
							String StatusTaxa = "OK";

							// Escrevendo no Console
							System.out.println(ValidadorTaxa);	
							System.out.println(StatusTaxa);

							if (ValidadorTaxa.equals(StatusTaxa)) {

								// Procurando o Elemento e colocando em uma Lista
								List <WebElement> botao_vender = driver.findElements(By.xpath("//button[@type='submit']"));

								// Colocando o Elemento na variavel
								WebElement button_sell = botao_vender.get(1);

								// Funcao HighLight
								HighLightElement(button_sell);

								// Clicar no Botao Comprar
								button_sell.click();
								Thread.sleep(2000);// esperar 2 segundo

								// Escrevendo no Console	
								System.out.println("TAXA PASSIVA OK");

								/** Report Extent **/
								test.log(Status.PASS, "TAXA PASSIVA OK");
								test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Vender-TaxaPassivaOK"));
								/** Report Extent **/

							} else {

								// Escrevendo no Console	
								System.out.println("TAXA PASSIVA NOK");

								/** Report Extent **/
								test.log(Status.ERROR, "TAXA PASSIVA OK");
								test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Vender-TaxaPassivaNOK"));
								/** Report Extent **/

							}

						} else {

							// Escrevendo no Console	
							System.out.println("Botao 'Vender' Visivel ou Não Habilitado - Vender no Mercado");

							/** Report Extent **/
							test.log(Status.ERROR, "Botao 'Vender' Visivel ou Não Habilitado - Vender no Mercado");
							test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Vender-BotaoVenderMercadoNaoVisivel"));
							/** Report Extent **/

						}

					} else {

						// Escrevendo no Console	
						System.out.println("Botao 'Opcao Avancada' Não Visivel ou nao Habilitado - Vender Mercado");

						/** Report Extent **/
						test.log(Status.ERROR, "Botao 'Opcao Avancada' Não Visivel");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Vender-BotaoOpcaoAvancadaNaoVisivel"));
						/** Report Extent **/

					}

				} else { // Vender Imediatamente

					if (IsElementEnabled("quantidade-btc") && IsElementPresent("quantidade-btc")) {

						// Procurando o Elemento e colocando em uma Lista
						List <WebElement> vender_bitcoins = driver.findElements(By.id("quantidade-btc"));

						// Colocando o Elemento na variavel
						WebElement sell_quantidade = vender_bitcoins.get(0);

						// Funcao HighLight
						HighLightElement(sell_quantidade);

						// Escrevendo no Console	
						System.out.println("Campo 'Insira quantos Bitcoins deseja vender' Visivel - Vender Imediatamente");

						/** Report Extent **/
						test.log(Status.PASS, "Campo 'Insira quantos Bitcoins deseja vender' Visivel - Vender Imediatamente");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Vender-EuQueroVenderVisivel"));
						/** Report Extent **/

					} else {

						// Escrevendo no Console	
						System.out.println("Campo 'Insira quantos Bitcoins deseja vender' Não Visivel - Vender Imediatamente");

						/** Report Extent **/
						test.log(Status.ERROR, "Campo 'Insira quantos Bitcoins deseja vender' Não Visivel - Vender Imediatamente");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Vender-EuQueroVenderNaoVisivel"));
						/** Report Extent **/

					}

					if (IsElementEnabled("//*[@id='sell']/sell-exchange/div/div/div/div/div[3]/form/fieldset/div[1]/div/div[2]/div/input") && IsElementPresent("//*[@id='sell']/sell-exchange/div/div/div/div/div[3]/form/fieldset/div[1]/div/div[2]/div/input")) {

						// Procurando o Elemento e colocando em uma Lista
						WebElement campo_vender_reais  = driver.findElement(By.xpath("//*[@id='sell']/sell-exchange/div/div/div/div/div[3]/form/fieldset/div[1]/div/div[2]/div/input"));

						// Funcao HighLight
						HighLightElement(campo_vender_reais);

						// Inserindo o Valor para Comprar
						campo_vender_reais.sendKeys(Dinheiro);
						Thread.sleep(2000);// esperar 2 segundo

						// Escrevendo no Console	
						System.out.println("Campo 'Insira quantos Reais deseja vender em Bitcoins' - Visivel - Vender Imediatamente");

						/** Report Extent **/
						test.log(Status.PASS, "Campo 'Insira quantos Reais deseja vender em Bitcoins' - Visivel - Vender Imediatamente");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Vender-EuQueroVenderVisivel"));
						/** Report Extent **/

					} else {

						// Escrevendo no Console	
						System.out.println("Campo 'Insira quantos Reais deseja vender em Bitcoins' - Não Visivel - Vender Imediatamente");

						/** Report Extent **/
						test.log(Status.ERROR, "Campo 'Insira quantos Reais deseja vender em Bitcoins' - Não Visivel - Vender Imediatamente");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Vender-EuQueroVenderNaoVisivel"));
						/** Report Extent **/

					}

					if (IsElementEnabled("//button[@type='submit']") && IsElementPresent("//button[@type='submit']")) {

						// Escrevendo no Console	
						System.out.println("Botao 'Vender' Visivel - Vender Imediatamente");

						/** Report Extent **/
						test.log(Status.PASS, "Botao 'Vender' Visivel - Vender Imediatamente");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Vender-BotaoVenderImediatamenteVisivel"));
						/** Report Extent **/

						/** Armazenando os valores as Taxas	 */
						// Procurando o Elemento e colocando em uma Lista
						List <WebElement> bitcoins_informado = driver.findElements(By.id("quantidade-btc"));

						// Buscar o elemento na pagina
						BitcoinInformado = bitcoins_informado.get(0).getAttribute("value");

						// Buscar o elemento na pagina
						DinheiroInformado = driver.findElement(By.xpath("//*[@id='sell']/sell-exchange/div/div/div/div/div[3]/form/fieldset/div[1]/div/div[2]/div/input")).getAttribute("value").substring(3);

						// Procurando o Elemento e colocando em uma Lista
						List <WebElement> valor_taxa = driver.findElements(By.id("total-btc"));

						// Colocando o Elemento na variavel
						ValorTaxaServico = valor_taxa.get(0).getAttribute("value").substring(3);
						ValorLiquido = valor_taxa.get(1).getAttribute("value").substring(3);

						// Escrevendo no Console	
						System.out.println(BitcoinInformado); 
						System.out.println(DinheiroInformado); 
						System.out.println(ValorTaxaServico); 
						System.out.println(ValorLiquido);
						/** */

						// Função que retorna a String OK ou NOK	
						String ValidadorTaxa = Taxas.TaxasZater("Normal", "BTC", "Sell", "Ativa", BitcoinInformado, DinheiroInformado, ValorTaxaServico, ValorLiquido);
						String StatusTaxa = "OK";

						// Escrevendo no Console	
						System.out.println(ValidadorTaxa);
						System.out.println(StatusTaxa);

						if (ValidadorTaxa.equals(StatusTaxa)) {

							// Procurando o Elemento e colocando em uma Lista
							List <WebElement> botao_vender = driver.findElements(By.xpath("//button[@type='submit']"));

							// Colocando o Elemento na variavel
							WebElement button_sell = botao_vender.get(0);

							// Funcao HighLight
							HighLightElement(button_sell);

							// Clicar no Botao Comprar
							button_sell.click();
							Thread.sleep(2000);// esperar 2 segundo

							// Escrevendo no Console	
							System.out.println("TAXA ATIVA OK");

							/** Report Extent **/
							test.log(Status.PASS, "TAXA ATIVA OK");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Vender-TaxaAtivaOK"));
							/** Report Extent **/

						} else {

							// Escrevendo no Console	
							System.out.println("TAXA ATIVA NOK");

							/** Report Extent **/
							test.log(Status.ERROR, "TAXA ATIVA NOK");
							test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Vender-TaxaAtivaNOK"));
							/** Report Extent **/

						}

					} else {

						// Escrevendo no Console	
						System.out.println("Botao 'Vender' Não Visivel - Vender Imediatamente");

						/** Report Extent **/
						test.log(Status.ERROR, "Botao 'Vender' Não Visivel - Vender Imediatamente");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Vender-BotaoVenderImediatamenteNaoVisivel"));
						/** Report Extent **/

					}
				}

			} else {

				// Escrevendo no Console	
				System.out.println("Formulario de Venda Nao esta Visivel");

				/** Report Extent **/
				test.log(Status.ERROR, "Formulario de Venda Nao esta Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Vender-FormularioVenderNaoVisivel"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console	
			System.out.println("Saldo em Bitcoin nao permitido: " + "Saldo Atual: " + SaldoBitcoin + " " + "Minimo: " + ValorMinimoBitcoin);

			/** Report Extent **/
			test.log(Status.ERROR, "Saldo em Bitcoin nao permitido");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Vender-SaldoBitcoinNaoPermitido"));
			/** Report Extent **/
		} 

	}

	@Test
	public void STP05_000_Vender_Mercado() throws Exception{

		/** Report Extent **/
		test = extent.createTest("STP05_000_Vender_Mercado");
		test.assignCategory("Regressão");
		/** Report Extent **/

		String Dinheiro = new String("100000");
		String Bitcoin = new String("010000000");
		String BitcoinInformado;
		String DinheiroInformado;
		String ValorTaxaServico;
		String ValorLiquido;

		// Buscar o elemento na pagina
		String saldo_dinheiro = driver.findElement(By.xpath("/html/body/main/page-top/div/div[2]/div[4]")).getText().substring(4);
		String saldo_bitcoin = driver.findElement(By.xpath("/html/body/main/page-top/div/div[2]/div[3]")).getText().substring(4);

		System.out.println("Saldo em Dinheiro: " + saldo_dinheiro);
		System.out.println("Saldo em Bitcoin: " + saldo_bitcoin);

		// Convertendo a String em Float
		float SaldoBitcoin = Float.valueOf(saldo_bitcoin.replace(",","."));
		float SaldoDinheiro = Float.valueOf(saldo_dinheiro.replace(".", "").replace(",", "."));

		// Informando os valores Minimos
		double ValorMinimoDinheiro = 1000.00;
		double ValorMinimoBitcoin = 0.00000001;

		// Escrevendo no Console	
		System.out.println("Saldo em Dinheiro: " + SaldoDinheiro);
		System.out.println("Saldo em Bitcoins: " + SaldoBitcoin);       
		System.out.println("Saldo Minimo em Dinheiro: " + ValorMinimoDinheiro);
		System.out.println("Saldo Minimo em Bitcoin: " + ValorMinimoBitcoin);

		/**
		 * // Comprando as Strings
		 * //int permitido = Collator.getInstance().compare(saldo_dinheiro, valor_minimo_dinheiro);
		 * // Escrevendo no Console
		 * //System.out.println(permitido);
		 * //if (permitido == 0 || permitido == 1) {}
		 */

		/** 
		 * retorna -1 se a primeira string vier antes da outra na ordem do dicionario
		 * retorna 1 se a primeira string vier depois da outra na ordem do dicionario
		 * retorna 0 se as duas strings forem exatamente iguais !
		 */

		if (SaldoBitcoin >= ValorMinimoBitcoin ) {

			/** Report Extent **/
			test.log(Status.PASS, "Vender - Saldo Disponivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Vender_Mercado-VenderSaldoDisponivel"));
			/** Report Extent **/

			// Escrevendo no Console	
			System.out.println("Saldo igual ao Minimo: " + SaldoBitcoin + " " + "Minimo: " + ValorMinimoBitcoin);			
			System.out.println("OU");			
			System.out.println("Saldo em Dinheiro: " + SaldoBitcoin + " " + "Maior que o Minimo: " + ValorMinimoBitcoin);

			if (IsElementPresent("sell")) {

				// Escrevendo no Console	
				System.out.println("Formulario de Venda esta Visivel");

				/** Report Extent **/
				test.log(Status.PASS, "Formulario de Venda esta Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Vender_Mercado-FormularioVendaVisivel"));
				/** Report Extent **/

				// Compra Mercado
				if (IsElementEnabled("//*[@id='sell']/sell-exchange/div/div/div/div/div[3]/form/fieldset/div[2]/a") && IsElementPresent("//*[@id='sell']/sell-exchange/div/div/div/div/div[3]/form/fieldset/div[2]/a")) {

					// Escrevendo no Console	
					System.out.println("Botao 'Opcao Avancada' - Visivel");

					// Colocando o Elemento na variavel
					WebElement opcao_avancada = driver.findElement(By.xpath("//*[@id='sell']/sell-exchange/div/div/div/div/div[3]/form/fieldset/div[2]/a"));

					// Funcao HighLight
					HighLightElement(opcao_avancada);

					// Clicar no Botao Comprar
					opcao_avancada.click();
					Thread.sleep(2000);// esperar 2 segundo

					/** Report Extent **/
					test.log(Status.PASS, "Botão 'Opcao Avancada' - Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Vender_Mercado-BotaoOpcaoAvancadaVisivel"));
					/** Report Extent **/

					if (IsElementEnabled("quantidade-btc") && IsElementPresent("quantidade-btc")) {

						// Procurando o Elemento e colocando em uma Lista
						List <WebElement> vender_bitcoins = driver.findElements(By.id("quantidade-btc"));

						// Colocando o Elemento na variavel
						WebElement sell_quantidade = vender_bitcoins.get(1);

						// Funcao HighLight
						HighLightElement(sell_quantidade);

						// Inserindo o Valor para Comprar
						sell_quantidade.sendKeys(Bitcoin);
						Thread.sleep(2000);// esperar 1 segundo

						// Escrevendo no Console	
						System.out.println("Campo 'Insira a quantidade de BItcoins que deseja vender' - Visivel - Vender no Mercado");

						/** Report Extent **/
						test.log(Status.PASS, "Campo 'Insira a quantidade de BItcoins que deseja vender' - Visivel - Vender no Mercado");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Vender_Mercado-QuantidadeBTCVisivel"));
						/** Report Extent **/

					} else {

						// Escrevendo no Console	
						System.out.println("Campo 'Insira a quantidade de BItcoins que deseja vender' Não Visivel ou nao Editavel - Vender no Mercado");

						/** Report Extent **/
						test.log(Status.ERROR, "Campo 'Insira a quantidade de BItcoins que deseja vender' Não Visivel ou nao Editavel - Vender no Mercado");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Vender_Mercado-QuantidadeBTCNaoVisivel"));
						/** Report Extent **/

					}

					if (IsElementEnabled("//*[@id='sell-on-board']/div/div/div/div/div[3]/form/fieldset/div[1]/div/div[2]/div/input") && IsElementPresent("//*[@id='sell-on-board']/div/div/div/div/div[3]/form/fieldset/div[1]/div/div[2]/div/input")) {

						// Buscando o Elemento
						WebElement campo_vender_reais = driver.findElement(By.xpath("//*[@id='sell-on-board']/div/div/div/div/div[3]/form/fieldset/div[1]/div/div[2]/div/input"));

						// Funcao HighLight
						HighLightElement(campo_vender_reais);

						// Inserindo o Valor para Comprar
						campo_vender_reais.sendKeys(Dinheiro);
						Thread.sleep(2000);// esperar 1 segundo

						// Escrevendo no Console	
						System.out.println("Campo 'Insira o valor que deseja receber pelo BTC Inteiro' - Visivel - Vender no Mercado");

						/** Report Extent **/
						test.log(Status.PASS, "Campo 'Insira o valor que deseja receber pelo BTC Inteiro' - Visivel - Vender no Mercado");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Vender_Mercado-ValorBTCInteiroVisivel"));
						/** Report Extent **/

					} else {

						// Escrevendo no Console	
						System.out.println("Campo 'Insira o valor que deseja receber pelo BTC Inteiro' - Não Visivel - Vender no Mercado");

						/** Report Extent **/
						test.log(Status.PASS, "Campo 'Insira o valor que deseja receber pelo BTC Inteiro' - Não Visivel - Vender no Mercado");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Vender_Mercado-ValorBTCInteiroNaoVisivel"));
						/** Report Extent **/

					}	

					if (IsElementEnabled("//button[@type='submit']") && IsElementPresent("//button[@type='submit']")) {

						// Escrevendo no Console	
						System.out.println("Botao 'Vender' Visivel - Vender no Mercado");

						/** Report Extent **/
						test.log(Status.PASS, "Botao 'Vender' Visivel - Vender no Mercado");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Vender_Mercado-BotaoVenderMercadoVisivel"));
						/** Report Extent **/

						/** Armazenando os valores as Taxas	 */
						// Procurando o Elemento e colocando em uma Lista
						List <WebElement> bitcoins_informado = driver.findElements(By.id("quantidade-btc"));

						// Buscar o elemento na pagina
						BitcoinInformado = bitcoins_informado.get(1).getAttribute("value");

						// Buscar o elemento na pagina
						DinheiroInformado = driver.findElement(By.xpath("//*[@id='sell-on-board']/div/div/div/div/div[3]/form/fieldset/div[1]/div/div[2]/div/input")).getAttribute("value").substring(3);

						// Procurando o Elemento e colocando em uma Lista
						List <WebElement> valor_taxa = driver.findElements(By.id("total-btc"));

						// Colocando o Elemento na variavel
						ValorTaxaServico = valor_taxa.get(2).getAttribute("value").substring(3);
						ValorLiquido = valor_taxa.get(3).getAttribute("value").substring(3);

						// Escrevendo no Console	
						System.out.println(BitcoinInformado); 
						System.out.println(DinheiroInformado); 
						System.out.println(ValorTaxaServico); 
						System.out.println(ValorLiquido);
						/** */

						String ValidadorTaxa = Taxas.TaxasZater("Normal", "BTC", "Sell", "Passiva", BitcoinInformado, DinheiroInformado, ValorTaxaServico, ValorLiquido);
						String StatusTaxa = "OK";

						// Escrevendo no Console
						System.out.println(ValidadorTaxa);								
						System.out.println(StatusTaxa);

						if (ValidadorTaxa.equals(StatusTaxa)) {

							// Procurando o Elemento e colocando em uma Lista
							List <WebElement> botao_vender = driver.findElements(By.xpath("//button[@type='submit']"));

							// Colocando o Elemento na variavel
							WebElement button_sell = botao_vender.get(1);

							// Funcao HighLight
							HighLightElement(button_sell);

							// Clicar no Botao Comprar
							button_sell.click();
							Thread.sleep(2000);// esperar 2 segundo

							// Escrevendo no Console	
							System.out.println("TAXA PASSIVA OK");

							/** Report Extent **/
							test.log(Status.PASS, "TAXA PASSIVA OK");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Vender_Mercado-TaxaPassivaOK"));
							/** Report Extent **/

						} else {

							// Escrevendo no Console	
							System.out.println("TAXA PASSIVA NOK");

							/** Report Extent **/
							test.log(Status.PASS, "TAXA PASSIVA NOK");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Vender_Mercado-TaxaPassivaOK"));
							/** Report Extent **/

						}

					} else {

						// Escrevendo no Console	
						System.out.println("Botao 'Vender' Visivel ou Não Habilitado - Vender no Mercado");

						/** Report Extent **/
						test.log(Status.ERROR, "Botao 'Vender' Visivel ou Não Habilitado - Vender no Mercado");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Vender_Mercado-BotaoVenderMercadoNaoVisivel"));
						/** Report Extent **/

					}

				} else {

					// Escrevendo no Console	
					System.out.println("Botao 'Opcao Avancada' Não Visivel ou nao Habilitado - Vender Mercado");

					/** Report Extent **/
					test.log(Status.ERROR, "Botao 'Opcao Avancada' Não Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Vender_Mercado-BotaoOpcaoAvancadaNaoVisivel"));
					/** Report Extent **/

				}

			} else {

				// Escrevendo no Console	
				System.out.println("Formulario de Venda Não esta Visivel");

				/** Report Extent **/
				test.log(Status.ERROR, "Formulario de Venda Não esta Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_Vender_Mercado-FormularioVenderNaoVisivel"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console	
			System.out.println("Saldo em Bitcoin nao permitido: " + "Saldo Atual: " + SaldoBitcoin + " " + "Minimo: " + ValorMinimoBitcoin);

			/** Report Extent **/
			test.log(Status.ERROR, "Saldo em Bitcoin nao permitido");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Vender_Mercado-SaldoBitcoinNaoPermitido"));
			/** Report Extent **/

		} 

	}

	@Test
	public void STP06_000_CancelarOfertasVenda() throws Exception{

		/** Report Extent **/
		test = extent.createTest("STP06_000_CancelarOfertasVenda");
		test.assignCategory("Regressão");
		/** Report Extent **/

		if (IsElementPresent("sell")) {

			// Escrever no Console
			System.out.println("Ofertas de Venda - Visivel");

			// Buscar o elemento na página
			WebElement tabela = driver.findElement(By.xpath("//*[@id='sell']/sell-table/div/div/div/div/div/table"));

			// Funcao HighLight
			HighLightElement(tabela);

			/** Report Extent **/
			test.log(Status.PASS, "Ofertas de Venda - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP06_000_CancelarOfertasVenda-OfertasVendaVisivel"));
			/** Report Extent **/

			// Coloca o elemento em uma Lista
			List <WebElement> tr = tabela.findElements(By.cssSelector("tr"));
			//List<WebElement> td = tabela.findElements(By.cssSelector("td"));

			for (WebElement linha : tr) { // Verifica quantos Elementos foram encontrados

				// Escrevendo no Console
				//System.out.println("Linha" + linha.getText());
				//System.out.println("Linha Tamanho" + linha.getSize());

				if (linha.getText().contains("Aguardando") && linha.getText().contains("Cancelar")) { // Condição para o Status Melhorar

					// Funcao HighLight
					HighLightElement(linha);

					/** Report Extent **/
					test.log(Status.PASS, "Contém Ofertas no Status de Aguardando ou para Cancelar");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP06_000_CancelarOfertasVenda-ContemDepositoAguardando"));
					/** Report Extent **/ 

					// Escrevendo no Console
					System.out.println("Possui Ofertas para Cancelar");

					while ((linha.getText().contains("Aguardando") && linha.getText().contains("Cancelar"))) {//(IsElementPresent("//button[text()='Cancelar']") && IsElementPresent("//button[text()='Cancelar']")) {

						// Buscar o elemento na página
						List<WebElement> cancelar_oferta = driver.findElements(By.xpath("//button[text()='Cancelar']"));

						// Escrevendo no Console
						System.out.println("Quantos Elementos: " + cancelar_oferta.size());

						// Funcao HighLight
						HighLightElement(driver.findElement(By.xpath("//button[text()='Cancelar']")));

						int i;

						for (i=0; i < cancelar_oferta.size(); i++) {

							// Clicar no Botão Cancelar
							cancelar_oferta.get(i).click();

						}
					}

				} else {

					// Escrevendo no Console
					System.out.println("Não Contém Ofertas no Status de Aguardando ou para Cancelar");

				}

			}


		} else {

			// Escrevendo no Console
			System.out.println("Ofertas de Venda - Não Visivel");

			/** Report Extent **/
			test.log(Status.ERROR, "Ofertas de Venda - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP06_000_CancelarOfertasVenda-OfertasVendaNaoVisivel"));
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
		test = extent.createTest("TCR02003_ZaterCapitalExchange_Fluxo_Vender_Finalizar");
		test.assignCategory("Regressão");
		/** Report Extent **/

		/** Report Extent **/
		test.log(Status.PASS, "Browser Encerrado com Sucesso");
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","TCR02003_ZaterCapitalExchange_Fluxo_Vender_Finalizar-EncerrarSiteComSucesso"));
		/** Report Extent **/

		// Encerra o Report
		extent.flush();

		// Fechar o Browser
		driver.quit();
		//driver.close();

	}

}
