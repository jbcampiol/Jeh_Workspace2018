package Regressao;

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
import Utilitarios.Taxas;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TCR02002_ZaterCapitalExchange_Fluxo_Comprar extends FuncoesReusaveis_Windows {

	@BeforeClass
	public static void AbrirBrowser() throws Exception {

		// Chamando o Browser
		InitBrowser("Chrome");

		/** Report Extent **/
		StartReport("TCR02002_ZaterCapitalExchange_Fluxo_Comprar_TestResult");
		test = extent.createTest("TCR02002_ZaterCapitalExchange_Fluxo_Comprar_Iniciar");
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
		String url_dados = Dados_Windows.Homologacao_Site_ZaterCapital_Exchange; // URL da class Dados

		/** Report Extent **/
		test.log(Status.INFO, "TCR02002_ZaterCapitalExchange_Fluxo_Comprar_Iniciar");
		test.log(Status.PASS, "Browser Carregado com Sucesso");	
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","TCR02002_ZaterCapitalExchange_Fluxo_Comprar_Iniciar-AbrirSiteComSucesso"));
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
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","TCR02002_ZaterCapitalExchange_Fluxo_Comprar_Iniciar-AbrirSiteComSucesso"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("Abrir o Browser - ERROR ao abrir Site da Exchange da Zater Capital");

			/** Report Extent **/
			test.log(Status.ERROR, "Abrir o Browser - ERROR ao abrir Site da Exchange da Zater Capital");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","TCR02002_ZaterCapitalExchange_Fluxo_Comprar_Iniciar-ErroAbrirSite"));
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
	public void STP03_000_Navegar_Comprar() throws Exception {
		
		/** Report Extent **/
		test = extent.createTest("STP03_000_Navegar_Comprar");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		if(IsElementPresent("//*[@class='al-sidebar-list-link ng-scope']")) {
			
			// Procurando os Menus e colocando em uma Lista
			List<WebElement> ProcurarMenu = driver.findElements(By.xpath("//*[@class='al-sidebar-list-link ng-scope']"));
			
			// Buscar o elemento na página
			WebElement MenuComprar = ProcurarMenu.get(4);
			
	        // Funcao HighLight
			HighLightElement(MenuComprar);
			
			//Clicar no Menu 'Comprar'
			MenuComprar.click();
			Thread.sleep(2000);// esperar 2 segundo
	        
			// Escrevendo no Console
	        System.out.println("MENU - 'Comprar' - Visivel");
			
			/** Report Extent **/
			test.log(Status.PASS, "MENU - 'Comprar' - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Comprar-MENUComprarVisivel"));
			/** Report Extent **/
	        	        			
	        if(IsElementPresent("typebuy")) {
	        	
		        // Funcao HighLight
		        HighLightElement(driver.findElement(By.xpath("//*[@class='content-coins__title']")));
		        
				// Escrevendo no Console
				System.out.println("Assert: " + driver.findElement(By.xpath("//*[@class='content-coins__title']")).getText());
				System.out.println("Comprar - Visivel");
				
				/** Report Extent **/
				test.log(Status.PASS, "Comprar - Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Comprar-ComprarVisivel"));
				/** Report Extent **/
							
				if(IsElementPresent("//*[@id='typebuy']/coins-list-buy/ul")) {
				
					// Buscar o elemento na página
					WebElement tabela = driver.findElement(By.xpath("//*[@id='typebuy']/coins-list-buy/ul"));
	
					// Coloca o elemento em uma Lista
					List<WebElement> li = tabela.findElements(By.cssSelector("li"));
					
					System.out.println("Linha: " + li.size());
					
					for (WebElement linha : li) {					
						
				        // Funcao HighLight
				        HighLightElement(linha);
				        
				        // Escrevendo no Console
						System.out.println("Linha: " + linha);
				        
						/** Report Extent **/
						test.log(Status.PASS, "Comprar - Visivel");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Comprar-ComprarMoedasVisivel"));
						/** Report Extent **/
						
					}		
				
				} else {
					
			        // Escrevendo no Console
					System.out.println("Moedas Não Visíveis");
			        
					/** Report Extent **/
					test.log(Status.ERROR, "Moedas Não Visíveis");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Comprar-ComprarMoedasNaoVisivel"));
					/** Report Extent **/
					
				}
		        
	        } else {
		        
		        // Escrevendo no Console
		        System.out.println("Comprar - Nao Visivel");
		        
				/** Report Extent **/
				test.log(Status.ERROR, "Comprar - Não Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Comprar-ComprarNaoVisivel"));
				/** Report Extent **/
	        	
	        }
			
		} else {

	        // Escrevendo no Console
	        System.out.println("MENU - 'Comprar' - Não Visivel");
	        
			/** Report Extent **/
			test.log(Status.ERROR, "MENU - 'Comprar' - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Comprar-MENUComprarNaoVisivel"));
			/** Report Extent **/
	        
		}
		
	}

	@Ignore
	@Test
	public void STP04_000_Comprar_Bitcoin() throws Exception{
		
		// Variaveis
		String Dinheiro = new String("100000");
		String Bitcoin = new String("100000000");
		String CriptomoedaInformado;
		String DinheiroInformado;
		String ValorTaxaServico;
		String ValorLiquido;
		
		/** Report Extent **/
		test = extent.createTest("STP04_000_Comprar_Bitcoin");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		// Buscar o elemento na pagina
		String Valor_Total = driver.findElement(By.xpath("/html/body/main/page-top/div/div[2]/div[3]/p[1]/strong")).getText().substring(4);
		String Moedas_Valor_Total = driver.findElement(By.xpath("/html/body/main/page-top/div/div[2]/div[3]/p[2]/strong")).getText().substring(4);

		// Escrevendo no Console
		System.out.println("Valor Total em Dinheiro: " + Valor_Total);
		System.out.println("Valor Total em Moedas: " + Moedas_Valor_Total);
		
		// Convertendo a String em Float
		float ValorTotal = Float.valueOf(Valor_Total.replace(".", "").replace(",","."));
		float MoedasValorTotal = Float.valueOf(Moedas_Valor_Total.replace(".", "").replace(",", "."));
		
		// Informando os valores Minimos
		float ValorMinimoDinheiro = (float) 0000.00;
		float ValorMinimoMoedas = (float) 0.00000000;

		// Escrevendo no Console	
		System.out.println("Valor Total em Dinheiro: " + ValorTotal);
		System.out.println("Valor Total em Moedas: " + MoedasValorTotal);       
		System.out.println("Saldo Minimo em Dinheiro: " + ValorMinimoDinheiro);
		System.out.println("Saldo Minimo em Moedas: " + ValorMinimoMoedas);

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

		if (ValorTotal >= ValorMinimoDinheiro ) {

			/** Report Extent **/
			test.log(Status.PASS, "Comprar - Saldo Disponivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-ComprarSaldoDisponivel"));
			/** Report Extent **/

			// Escrevendo no Console	
			System.out.println("Saldo igual ao Minimo: " + ValorTotal + " " + "Minimo: " + ValorMinimoDinheiro);			
			System.out.println("OU");			
			System.out.println("Saldo em Dinheiro: " + ValorTotal + " " + "Maior que o Minimo: " + ValorMinimoDinheiro);
			
			if(IsElementPresent("qa-btc")) {
				
				// Colocando o Elemento na variavel
				WebElement Comprar = driver.findElement(By.xpath("//*[@id='qa-btc']/div[2]/button"));
				
				// Funcao HighLight
				HighLightElement(Comprar);
				
				// Clicar no Botao Comprar
				Comprar.click();
				Thread.sleep(2000);// esperar 1 segundo
				
				// Escrevendo no Console	
				System.out.println("Comprar Bitcoin está Visível");

				/** Report Extent **/
				test.log(Status.PASS, "Comprar Bitcoin está Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-ComprarBitcoinVisivel"));
				/** Report Extent **/

				if (IsElementPresent("buy")) {
	
					// Escrevendo no Console	
					System.out.println("Formulario de Comprar esta Visivel");
	
					/** Report Extent **/
					test.log(Status.PASS, "Formulario de Comprar esta Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-FormularioComprarVisivel"));
					/** Report Extent **/
					
					// Buscar o elemento na página
					List<WebElement> ListMoeda = driver.findElements(By.name("selectCoin"));
					
					// Procurando o Elemento
					WebElement SelectCoin = ListMoeda.get(0);
					
					if(SelectCoin.getAttribute("textContent").contains("Bitcoin")) { 
			
						// Funcao HighLight
				        HighLightElement(SelectCoin);
				        
				        // Procurando o Elemento Select
				        Select Coin = new Select(SelectCoin);
				        
				        // Selecionando a Moeda
				        Coin.selectByValue("Bitcoin");
				        Thread.sleep(1000); // Espera 1 segundo
		
						// Escrevendo no Console	
						System.out.println("Moeda selecionada é valida");
						
						/** Report Extent **/
						test.log(Status.PASS, "Moeda selecionadaé valida");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-MoedaSelecionadaValida"));
						/** Report Extent **/

						if(driver.findElement(By.xpath("//*[@id='buy']/buy-exchange/div/div/div/div/div[3]")).getText().contains("Não existe ordem de venda no livro.")) {
		
							// Escrevendo no Console	
							System.out.println("Não existe ordem de venda no livro.");
		
							/** Report Extent **/
							test.log(Status.PASS, "Não existe ordem de venda no livro.");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-NaoExiteOrdemDeVendaNoLivro"));
							/** Report Extent **/
							
							// Compra Mercado
							if (IsElementEnabled("//button[text()='Opções avançadas']") && IsElementPresent("//button[text()='Opções avançadas']")) {
							
								// Escrevendo no Console	
								System.out.println("Botao 'Opcao Avancada' Visivel");
								
								// Colocando o Elemento na variavel
								WebElement opcao_avancada = driver.findElement(By.xpath("//button[text()='Opções avançadas']"));
								
								// Funcao HighLight
								HighLightElement(opcao_avancada);
								
								// Clicar no Botao Comprar
								opcao_avancada.click();
								Thread.sleep(2000);// esperar 1 segundo
								
								/** Report Extent **/
								test.log(Status.PASS, "Botao 'Opcao Avancada' Visivel");
								test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-BotaoOpcaoAvancadaVisivel"));
								/** Report Extent **/
								
								// Buscar o elemento na página
								List<WebElement> ListMoeda_ = driver.findElements(By.name("selectCoin"));
								
								// Procurando o Elemento
								WebElement SelectCoin_ = ListMoeda_.get(1);
								
								if(SelectCoin_.getAttribute("textContent").contains("Bitcoin")) { 
												
									// Funcao HighLight
							        HighLightElement(SelectCoin_);
							        
							        // Procurando o Elemento Select
							        Select Coin_ = new Select(SelectCoin_);
							        
							        // Selecionando a Moeda
							        Coin_.selectByValue("Bitcoin");
							        Thread.sleep(1000); // Espera 1 segundo
					
									// Escrevendo no Console	
									System.out.println("Moeda selecionada é valida");
									
									/** Report Extent **/
									test.log(Status.PASS, "Moeda selecionadaé valida");
									test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-MoedaSelecionadaValida"));
									/** Report Extent **/	
								
									if (IsElementEnabled("buy-quantidade") && IsElementPresent("buy-quantidade")) {
				
										// Procurando o Elemento e colocando em uma Lista
										List <WebElement> comprar_bitcoins = driver.findElements(By.id("buy-quantidade"));
				
										// Colocando o Elemento na variavel
										WebElement buy_quantidade = comprar_bitcoins.get(1);
				
										// Funcao HighLight
										HighLightElement(buy_quantidade);
										
										// Inserindo o Valor para Comprar
										buy_quantidade.sendKeys(Bitcoin);
										Thread.sleep(2000);// esperar 2 segundo
										
										/** Report Extent **/
										test.log(Status.PASS, "Campo 'Insira a quantidade de Bitcoins que deseja comprar' - Visivel - Compra no Mercado");
										test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-QuantidadeBTCVisivel"));
										/** Report Extent **/
										
										// Escrevendo no Console	
										System.out.println("Campo 'Insira a quantidade de Bitcoins que deseja comprar' - Visivel - Compra no Mercado");
										
									} else {
				
										// Escrevendo no Console	
										System.out.println("Campo 'Insira quantos Bitcoins deseja comprar' nao Visivel ou nao Editavel - Compra no Mercado");
										
										/** Report Extent **/
										test.log(Status.ERROR, "Campo 'Insira a quantidade de Bitcoins que deseja comprar'- Não Visivel - Compra no Mercado");
										test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-QuantidadeBTCNaoVisivel"));
										/** Report Extent **/
										
									}
									
									if (IsElementEnabled("valor-venda") && IsElementPresent("valor-venda")) {
				
										// Procurando o Elemento e colocando em uma Lista
										List <WebElement> comprar_reais = driver.findElements(By.id("valor-venda"));
				
										// Colocando o Elemento na variavel
										WebElement campo_comprar_reais = comprar_reais.get(1);
				
										// Funcao HighLight
										HighLightElement(campo_comprar_reais);
										
										// Inserindo o Valor para Comprar
										campo_comprar_reais.sendKeys(Dinheiro);
										Thread.sleep(2000);// esperar 2 segundo
				
										/** Report Extent **/
										test.log(Status.PASS, "Campo 'Insira o valor que deseja pagar pelo BTC Inteiro' - Visivel - Compra no Mercado");
										test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-ValorBTCInteiroVisivel"));
										/** Report Extent **/
										
										// Escrevendo no Console	
										System.out.println("Campo 'Insira o valor que deseja pagar pelo BTC Inteiro' - Visivel - Compra no Mercado");
				
									} else {
				
										// Escrevendo no Console	
										System.out.println("Campo 'Insira o valor que deseja pagar pelo BTC Inteiro' - Não Visivel - Compra no Mercado");
										
										/** Report Extent **/
										test.log(Status.ERROR, "Campo 'Insira o valor que deseja pagar pelo BTC Inteiro' - Não Visivel - Compra no Mercado");
										test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-ValorBTCInteiroNaoVisivel"));
										/** Report Extent **/
										
									}	
																							
									if (IsElementEnabled("//button[@type='submit']") && IsElementPresent("//button[@type='submit']")) {
										
										// Escrevendo no Console	
										System.out.println("Botao 'Comprar' Visivel - Compra no Mercado");
										
										/** Report Extent **/
										test.log(Status.PASS, "Botao 'Comprar' Visivel - Compra no Mercado");
										test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-BotaoComprarVisivelMercado"));
										/** Report Extent **/
										
											/** Armazenando os valores as Taxas	 */
											// Procurando o Elemento e colocando em uma Lista
											List <WebElement> bitcoins_informado = driver.findElements(By.id("buy-quantidade"));
											
											// Buscar o elemento na pagina
											CriptomoedaInformado = bitcoins_informado.get(1).getAttribute("value");
											
											// Procurando o Elemento e colocando em uma Lista
											List <WebElement> dinheiro_informado = driver.findElements(By.id("valor-venda"));
											
											// Buscar o elemento na pagina
											DinheiroInformado = dinheiro_informado.get(1).getAttribute("value").substring(3);
											
											// Procurando o Elemento e colocando em uma Lista
											List <WebElement> valor_taxa = driver.findElements(By.xpath("//*[@id='valor-taxa']"));
					
											// Colocando o Elemento na variavel
											ValorTaxaServico = valor_taxa.get(2).getAttribute("value");
											ValorLiquido = valor_taxa.get(3).getAttribute("value");
			
											// Escrevendo no Console	
											System.out.println(CriptomoedaInformado); 
											System.out.println(DinheiroInformado); 
											System.out.println(ValorTaxaServico); 
											System.out.println(ValorLiquido);
											/** Armazenando os valores as Taxas */
										
										// Função que retorna a String OK ou NOK
										String ValidadorTaxa = Taxas.TaxasZater("Normal", "BTC", "Buy", "Passiva", CriptomoedaInformado, DinheiroInformado, ValorTaxaServico, ValorLiquido);
										String StatusTaxa = "OK";	
										
										// Escrevendo no Console	
										System.out.println(ValidadorTaxa);									
										System.out.println(StatusTaxa);
										
											if (ValidadorTaxa.equals(StatusTaxa)) {
											
											// Procurando o Elemento e colocando em uma Lista
											List <WebElement> botao_comprar = driver.findElements(By.xpath("//button[@type='submit']"));
					
											// Colocando o Elemento na variavel
											WebElement button_buy = botao_comprar.get(1);
					
											// Funcao HighLight
											HighLightElement(button_buy);
								
											// Clicar no Botao Comprar
											button_buy.click();
											Thread.sleep(2000);// esperar 2 segundo
											
											// Escrevendo no Console	
											System.out.println("Taxa PASSIVA OK");
											System.out.println("Acionando o Botão 'Comprar'");
											
											/** Report Extent **/
											test.log(Status.PASS, "TAXA PASSIVA OK - Compra no Mercado");
											test.log(Status.PASS, "Acionando o Botão 'Comprar'");
											test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-TaxaPassivaOKMercado"));
											/** Report Extent **/
				
											} else {
												
												// Escrevendo no Console	
												System.out.println("Taxa PASSIVA NOK");
												
												/** Report Extent **/
												test.log(Status.ERROR, "TAXA PASSIVA NOK - Compra no Mercado");
												test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-TaxaPassivaNOKMercado"));
												/** Report Extent **/
												
											}
				
									} else {
				
										// Escrevendo no Console	
										System.out.println("Botao 'Comprar' Não Visivel ou nao Habilitado - Compra no Mercado");
										
										/** Report Extent **/
										test.log(Status.ERROR, "Botao 'Comprar' Não Visivel - Compra no Mercado");
										test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-BotaoComprarNaoVisivelMercado"));
										/** Report Extent **/
										
									}
									
								} else {
									
									// Escrevendo no Console	
									System.out.println("Comprar Bitcoin Não está Visível");

									/** Report Extent **/
									test.log(Status.ERROR, "Comprar Bitcoin Não está Visível");
									test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-ComprarBitcoinNaoVisivel"));
									/** Report Extent **/
									
								}
									
							} else {
								
								// Escrevendo no Console	
								System.out.println("Botao 'Opcao Avancada' Não Visivel ou nao Habilitado - Compra no Mercado");
								
								/** Report Extent **/
								test.log(Status.ERROR, "Botao 'Opcao Avancada' Não Visivel");
								test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-BotaoOpcaoAvancadaNaoVisivel"));
								/** Report Extent **/
								
							}
		
						} else { // Comprar Imediatamente
		
							if (IsElementEnabled("buy-quantidade") && IsElementPresent("buy-quantidade")) {
		
								// Procurando o Elemento e colocando em uma Lista
								List <WebElement> comprar_bitcoins = driver.findElements(By.id("buy-quantidade"));
		
								// Colocando o Elemento na variavel
								WebElement buy_quantidade = comprar_bitcoins.get(0);
		
								// Funcao HighLight
								HighLightElement(buy_quantidade);
		
								// Escrevendo no Console	
								System.out.println("Campo 'Insira quantos Bitcoins deseja comprar' - Visivel - Comprar Imediatamente");
		
								/** Report Extent **/
								test.log(Status.PASS, "Campo 'Insira a quantidade de Bitcoins que deseja comprar' - Visivel - Comprar Imediatamente");
								test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-EuQueroComprar"));
								/** Report Extent **/
								
							} else {
		
								// Escrevendo no Console	
								System.out.println("Campo 'Insira quantos Bitcoins deseja comprar' Não Visivel ou nao Editavel - Comprar Imediatamente");
								
								/** Report Extent **/
								test.log(Status.ERROR, "Campo 'Insira quantos Bitcoins deseja comprar' - Não Visivel - Comprar Imediatamente");
								test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-EuQueroComprar"));
								/** Report Extent **/
								
							}
		
							if (IsElementEnabled("valor-venda") && IsElementPresent("valor-venda")) {
		
								// Procurando o Elemento e colocando em uma Lista
								List <WebElement> comprar_reais = driver.findElements(By.id("valor-venda"));
		
								// Colocando o Elemento na variavel
								WebElement campo_comprar_reais = comprar_reais.get(0);
		
								// Funcao HighLight
								HighLightElement(campo_comprar_reais);
		
								// Inserindo o Valor para Comprar
								campo_comprar_reais.sendKeys(Dinheiro);
								Thread.sleep(2000);// esperar 2 segundo
								
								// Escrevendo no Console	
								System.out.println("Campo 'Insira quantos Reais deseja comprar em Bitcoins' - Visivel - Comprar Imediatamente");
								
								/** Report Extent **/
								test.log(Status.PASS, "Campo 'Insira quantos Reais deseja comprar em Bitcoins' - Visivel - Comprar Imediatamente");
								test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-EuQueroComprar"));
								/** Report Extent **/
		
							} else {
		
								// Escrevendo no Console	
								System.out.println("Campo 'Insira quantos Reais deseja comprar em Bitcoins' - Não Visivel - Comprar Imediatamente");
								
								/** Report Extent **/
								test.log(Status.ERROR, "Campo 'Insira quantos Reais deseja comprar em Bitcoins' - Não Visivel - Comprar Imediatamente");
								test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-EuQueroComprar"));
								/** Report Extent **/
								
							}
		
							if (IsElementEnabled("//button[@type='submit']") && IsElementPresent("//button[@type='submit']")) {
		
								// Escrevendo no Console	
								System.out.println("Botao 'Comprar' Visivel - Comprar Imediatamente");
								
								/** Report Extent **/
								test.log(Status.PASS, "Botao 'Comprar' Visivel - Comprar Imediatamente");
								test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-BotaoComprarVisivelImediatamente"));
								/** Report Extent **/
								
									/** Armazenando os valores as Taxas	 */
									// Procurando o Elemento e colocando em uma Lista
									List <WebElement> bitcoins_informado = driver.findElements(By.id("buy-quantidade"));
									
									// Buscar o elemento na pagina
									CriptomoedaInformado = bitcoins_informado.get(0).getAttribute("value");
									
									// Procurando o Elemento e colocando em uma Lista
									List <WebElement> dinheiro_informado = driver.findElements(By.id("valor-venda"));
									
									// Buscar o elemento na pagina
									DinheiroInformado = dinheiro_informado.get(0).getAttribute("value").substring(3);
									
									// Procurando o Elemento e colocando em uma Lista
									List <WebElement> valor_taxa = driver.findElements(By.xpath("//*[@id='valor-taxa']"));
			
									// Colocando o Elemento na variavel
									ValorTaxaServico = valor_taxa.get(0).getAttribute("value");
									ValorLiquido = valor_taxa.get(1).getAttribute("value");
			
									// Escrevendo no Console	
									System.out.println(CriptomoedaInformado); 
									System.out.println(DinheiroInformado); 
									System.out.println(ValorTaxaServico); 
									System.out.println(ValorLiquido);
									/** Armazenando os valores as Taxas */
								
								// Função que retorna a String OK ou NOK
								String ValidadorTaxa = Taxas.TaxasZater("Normal", "BTC", "Buy", "Ativa", CriptomoedaInformado, DinheiroInformado, ValorTaxaServico, ValorLiquido);
								String StatusTaxa = "OK";
								
								// Escrevendo no Console	
								System.out.println(ValidadorTaxa);	
								System.out.println(StatusTaxa);			
								
								if (ValidadorTaxa.equals(StatusTaxa)) {
									
									// Procurando o Elemento e colocando em uma Lista
									List <WebElement> botao_comprar = driver.findElements(By.xpath("//button[@type='submit']"));
			
									// Colocando o Elemento na variavel
									WebElement button_buy = botao_comprar.get(0);
			
									// Funcao HighLight
									HighLightElement(button_buy);
			
									// Clicar no Botao Comprar
									button_buy.click();
									Thread.sleep(2000);// esperar 2 segundo
									
									// Escrevendo no Console	
									System.out.println("Taxa ATIVA OK");
									System.out.println("Acionando o Botão 'Comprar'");
									
									/** Report Extent **/
									test.log(Status.PASS, "TAXA ATIVA OK - Comprar Imediatamente");
									test.log(Status.PASS, "Acionando o Botão 'Comprar'");
									test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-TaxaAtivaOKImediatamente"));
									/** Report Extent **/
																		
									} else {
										
										// Escrevendo no Console	
										System.out.println("Taxa ATIVA NOK");
										
										/** Report Extent **/
										test.log(Status.ERROR, "TAXA ATIVA NOK - Comprar Imediatamente");
										test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-TaxaAtivaNOKImediatamente"));
										/** Report Extent **/
										
									}
								
							} else {
		
								// Escrevendo no Console	
								System.out.println("Botao 'Comprar' Não Visivel ou nao Habilitado - Comprar Imediatamente");
		
								/** Report Extent **/
								test.log(Status.ERROR, "Botao 'Comprar' Não Visivel ou nao Habilitado - Comprar Imediatamente");
								test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-BotaoComprarNaoVisivelImediatamente"));
								/** Report Extent **/
								
							}
		
						}
						
					} else {
						
						// Escrevendo no Console	
						System.out.println("Moeda selecionada não é valida");
						
						/** Report Extent **/
						test.log(Status.ERROR, "Moeda selecionada não é valida");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-MoedaSelecionadaNaoValida"));
						/** Report Extent **/
						
					}
	
				} else {
	
					// Escrevendo no Console	
					System.out.println("Formulario de Comprar - Nao esta Visivel");
					
					/** Report Extent **/
					test.log(Status.ERROR, "Formulario de Comprar - Nao esta Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-FormularioComprarNaoVisivel"));
					/** Report Extent **/
	
				}
				
			} else {
				
				// Escrevendo no Console	
				System.out.println("Comprar Bitcoin Não está Visível");

				/** Report Extent **/
				test.log(Status.ERROR, "Comprar Bitcoin Não está Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-ComprarBitcoinNaoVisivel"));
				/** Report Extent **/
				
			}
			
		} else {

			// Escrevendo no Console	
			System.out.println("Saldo em Dinheiro não permitido: " + "Saldo Atual: " + ValorTotal + " " + "Minimo: " + ValorMinimoDinheiro);
			
			/** Report Extent **/
			test.log(Status.ERROR, "Comprar - Saldo Não Disponivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-ComprarSaldoNaoDisponivel"));
			/** Report Extent **/
			
		} 

	}
	
	@Ignore
	@Test
	public void STP05_000_Comprar_Bitcoin_Mercado() throws Exception{
		
		// Variaveis
		String Dinheiro = new String("100000");
		String Bitcoin = new String("100000000");
		String CriptomoedaInformado;
		String DinheiroInformado;
		String ValorTaxaServico;
		String ValorLiquido;
		
		/** Report Extent **/
		test = extent.createTest("STP05_000_Comprar_Bitcoin_Mercado");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		// Buscar o elemento na pagina
		String Valor_Total = driver.findElement(By.xpath("/html/body/main/page-top/div/div[2]/div[3]/p[1]/strong")).getText().substring(4);
		String Moedas_Valor_Total = driver.findElement(By.xpath("/html/body/main/page-top/div/div[2]/div[3]/p[2]/strong")).getText().substring(4);
			
		// Escrevendo no Console
		System.out.println("Valor Total em Dinheiro: " + Valor_Total);
		System.out.println("Valor Total em Moedas: " + Moedas_Valor_Total);
		
		// Convertendo a String em Float
		float ValorTotal = Float.valueOf(Valor_Total.replace(".", "").replace(",","."));
		float MoedasValorTotal = Float.valueOf(Moedas_Valor_Total.replace(".", "").replace(",", "."));
		
		// Informando os valores Minimos
		float ValorMinimoDinheiro = (float) 0000.00;
		float ValorMinimoMoedas = (float) 0.00000000;

		// Escrevendo no Console	
		System.out.println("Valor Total em Dinheiro: " + ValorTotal);
		System.out.println("Valor Total em Moedas: " + MoedasValorTotal);       
		System.out.println("Saldo Minimo em Dinheiro: " + ValorMinimoDinheiro);
		System.out.println("Saldo Minimo em Moedas: " + ValorMinimoMoedas);

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

		if (ValorTotal >= ValorMinimoDinheiro ) {

			/** Report Extent **/
			test.log(Status.PASS, "Comprar - Saldo Disponivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Comprar_Bitcoin_Mercado-ComprarSaldoDisponivel"));
			/** Report Extent **/

			// Escrevendo no Console	
			System.out.println("Saldo igual ao Minimo: " + ValorTotal + " " + "Minimo: " + ValorMinimoDinheiro);			
			System.out.println("OU");			
			System.out.println("Saldo em Dinheiro: " + ValorTotal + " " + "Maior que o Minimo: " + ValorMinimoDinheiro);
				
			if (IsElementPresent("buy")) {

				// Escrevendo no Console	
				System.out.println("Formulario de Comprar esta Visivel");

				/** Report Extent **/
				test.log(Status.PASS, "Formulario de Comprar esta Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Comprar_Bitcoin_Mercado-FormularioComprarVisivel"));
				/** Report Extent **/			
				
				// Compra Mercado
				if (IsElementEnabled("//button[text()='Opções avançadas']") && IsElementPresent("//button[text()='Opções avançadas']")) {
				
					// Escrevendo no Console	
					System.out.println("Botao 'Opcao Avancada' Visivel");
					
					// Colocando o Elemento na variavel
					WebElement opcao_avancada = driver.findElement(By.xpath("//button[text()='Opções avançadas']"));
					
					// Funcao HighLight
					HighLightElement(opcao_avancada);
					
					// Clicar no Botao Comprar
					opcao_avancada.click();
					Thread.sleep(2000);// esperar 1 segundo
					
					/** Report Extent **/
					test.log(Status.PASS, "Botao 'Opcao Avancada' - Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Comprar_Bitcoin_Mercado-BotaoOpcaoAvancadaVisivel"));
					/** Report Extent **/
				
					// Buscar o elemento na página
					List<WebElement> ListMoeda = driver.findElements(By.name("selectCoin"));
					
					// Procurando o Elemento
					WebElement SelectCoin = ListMoeda.get(1);
					
					if(SelectCoin.getAttribute("textContent").contains("Bitcoin")) { 
									
						// Funcao HighLight
				        HighLightElement(SelectCoin);
				        
				        // Procurando o Elemento Select
				        Select Coin = new Select(SelectCoin);
				        
				        // Selecionando a Moeda
				        Coin.selectByValue("Bitcoin");
				        Thread.sleep(1000); // Espera 1 segundo
		
						// Escrevendo no Console	
						System.out.println("Moeda selecionada é valida");
						
						/** Report Extent **/
						test.log(Status.PASS, "Moeda selecionadaé valida");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Comprar_Bitcoin_Mercado-MoedaSelecionadaValida"));
						/** Report Extent **/	
							
						if (IsElementEnabled("buy-quantidade") && IsElementPresent("buy-quantidade")) {
	
							// Procurando o Elemento e colocando em uma Lista
							List <WebElement> comprar_bitcoins = driver.findElements(By.id("buy-quantidade"));
	
							// Colocando o Elemento na variavel
							WebElement buy_quantidade = comprar_bitcoins.get(1);
	
							// Funcao HighLight
							HighLightElement(buy_quantidade);
							
							// Inserindo o Valor para Comprar
							buy_quantidade.sendKeys(Bitcoin);
							Thread.sleep(2000);// esperar 1 segundo
	
							// Escrevendo no Console	
							System.out.println("Campo 'Insira a quantidade de Bitcoins que deseja comprar' - Visivel - Comprar no Mercado");
							
							/** Report Extent **/
							test.log(Status.PASS, "Campo 'Insira a quantidade de Bitcoins que deseja comprar' - Visivel - Comprar no Mercado");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Comprar_Bitcoin_Mercado-QuantidadeBTCVisivel"));
							/** Report Extent **/
							
						} else {
	
							// Escrevendo no Console	
							System.out.println("Campo 'Insira a quantidade de Bitcoins que deseja comprar' - Não Visivel ou nao Editavel - Compra Mercado");
	
							/** Report Extent **/
							test.log(Status.ERROR, "Campo 'Insira a quantidade de Bitcoins que deseja comprar' - Não Visivel - Comprar no Mercado");
							test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Comprar_Bitcoin_Mercado-QuantidadeBTCNaoVisivel"));
							/** Report Extent **/
							
						}
						
						if (IsElementEnabled("valor-venda") && IsElementPresent("valor-venda")) {
	
							// Procurando o Elemento e colocando em uma Lista
							List <WebElement> comprar_reais = driver.findElements(By.id("valor-venda"));
	
							// Colocando o Elemento na variavel
							WebElement campo_comprar_reais = comprar_reais.get(1);
	
							// Funcao HighLight
							HighLightElement(campo_comprar_reais);
							
							// Inserindo o Valor para Comprar
							campo_comprar_reais.sendKeys(Dinheiro);
							Thread.sleep(2000);// esperar 1 segundo
	
							// Escrevendo no Console	
							System.out.println("Campo 'Insira o valor que deseja pagar pelo BTC Inteiro' Visivel - Comprar no Mercado");
	
							/** Report Extent **/
							test.log(Status.PASS, "Campo 'Insira o valor que deseja pagar pelo BTC Inteiro' Visivel - Comprar no Mercado");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Comprar_Bitcoin_Mercado-ValorBTCInteiroVisivel"));
							/** Report Extent **/
							
						} else {
	
							// Escrevendo no Console	
							System.out.println("Campo 'Insira quantos Reais deseja comprar em Bitcoins' Não Visivel ou nao Editavel - Compra Mercado");
							
							/** Report Extent **/
							test.log(Status.ERROR, "Campo 'Insira quantos Reais deseja comprar em Bitcoins' Não Visivel ou nao Editavel - Compra Mercado");
							test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Comprar_Bitcoin_Mercado-ValorBTCInteiroNaoVisivel"));
							/** Report Extent **/
							
						}	
																				
						if (IsElementEnabled("//button[@type='submit']") && IsElementPresent("//button[@type='submit']")) {
							
							// Escrevendo no Console	
							System.out.println("Botao 'Comprar' Visivel - Comprar Mercado");
							
							/** Report Extent **/
							test.log(Status.PASS, "Botao 'Comprar' Visivel - Comprar no Mercado");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Comprar_Bitcoin_Mercado-BotaoComprarVisivelMercado"));
							/** Report Extent **/
							
								/** Armazenando os valores as Taxas	 */
								// Procurando o Elemento e colocando em uma Lista
								List <WebElement> bitcoins_informado = driver.findElements(By.id("buy-quantidade"));
								
								// Buscar o elemento na pagina
								CriptomoedaInformado = bitcoins_informado.get(1).getAttribute("value");
								
								// Procurando o Elemento e colocando em uma Lista
								List <WebElement> dinheiro_informado = driver.findElements(By.id("valor-venda"));
								
								// Buscar o elemento na pagina
								DinheiroInformado = dinheiro_informado.get(1).getAttribute("value").substring(3);
								
								// Procurando o Elemento e colocando em uma Lista
								List <WebElement> valor_taxa = driver.findElements(By.xpath("//*[@id='valor-taxa']"));
		
								// Colocando o Elemento na variavel
								ValorTaxaServico = valor_taxa.get(2).getAttribute("value");
								ValorLiquido = valor_taxa.get(3).getAttribute("value");

								// Escrevendo no Console	
								System.out.println(CriptomoedaInformado); 
								System.out.println(DinheiroInformado); 
								System.out.println(ValorTaxaServico); 
								System.out.println(ValorLiquido);
								/** Armazenando os valores as Taxas */
							
							// Função que retorna a String OK ou NOK
							String ValidadorTaxa = Taxas.TaxasZater("Normal", "BTC", "Buy", "Passiva", CriptomoedaInformado, DinheiroInformado, ValorTaxaServico, ValorLiquido);
							String StatusTaxa = "OK";
							
							// Escrevendo no Console
							System.out.println(ValidadorTaxa);									
							System.out.println(StatusTaxa);
							
								if (ValidadorTaxa.equals(StatusTaxa)) {
								
								// Procurando o Elemento e colocando em uma Lista
								List <WebElement> botao_comprar = driver.findElements(By.xpath("//button[@type='submit']"));
		
								// Colocando o Elemento na variavel
								WebElement button_buy = botao_comprar.get(1);
		
								// Funcao HighLight
								HighLightElement(button_buy);
		
								// Clicar no Botao Comprar
								button_buy.click();
								Thread.sleep(2000);// esperar 1 segundo
								
								// Escrevendo no Console	
								System.out.println("Taxa PASSIVA OK");
								System.out.println("Acionando o Botão 'Comprar'");
								
								
								/** Report Extent **/
								test.log(Status.PASS, "TAXA PASSIVA OK - Compra no Mercado");
								test.log(Status.PASS, "Acionando o Botão 'Comprar'");
								test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Comprar_Bitcoin_Mercado-TaxaPassivaOKMercado"));
								/** Report Extent **/
								
								} else {
									
									// Escrevendo no Console	
									System.out.println("TAXA PASSIVA NOK");
									
									/** Report Extent **/
									test.log(Status.PASS, "TAXA PASSIVA NOK - Compra no Mercado");
									test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Comprar_Bitcoin_Mercado-TaxaPassivaNOKMercado"));
									/** Report Extent **/
									
								}
	
						} else {
	
							// Escrevendo no Console	
							System.out.println("Botao 'Comprar' Não Visivel ou nao Habilitado - Compra no Mercado");
	
							/** Report Extent **/
							test.log(Status.ERROR, "Botao 'Comprar' Não Visivel ou nao Habilitado - Compra no Mercado");
							test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Comprar_Bitcoin_Mercado-BotaoComprarNaoVisivelMercado"));
							/** Report Extent **/
							
						}
						
					} else {
						
						// Escrevendo no Console	
						System.out.println("Comprar Bitcoin Não está Visível");

						/** Report Extent **/
						test.log(Status.ERROR, "Comprar Bitcoin Não está Visível");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Comprar_Bitcoin_Mercado-ComprarBitcoinNaoVisivel"));
						/** Report Extent **/
						
					}
						
				} else {
					
					// Escrevendo no Console	
					System.out.println("Botao 'Opcao Avancada' Não Visivel ou nao Habilitado - Compra no Mercado");
					
					/** Report Extent **/
					test.log(Status.ERROR, "Botao 'Opcao Avancada' - Não Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Comprar_Bitcoin_Mercado-BotaoOpcaoAvancadaNaoVisivel"));
					/** Report Extent **/
					
				}

			} else {
				
				// Escrevendo no Console	
				System.out.println("Formulario de Comprar - Nao esta Visivel");
				
				/** Report Extent **/
				test.log(Status.ERROR, "Formulario de Comprar - Nao esta Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Comprar_Bitcoin_Mercado-FormularioComprarNaoVisivel"));
				/** Report Extent **/

			}
							
		} else {

			// Escrevendo no Console	
			System.out.println("Saldo em Dinheiro não permitido: " + "Saldo Atual: " + ValorTotal + " " + "Minimo: " + ValorMinimoDinheiro);
			
			/** Report Extent **/
			test.log(Status.ERROR, "Comprar - Saldo Não Disponivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Comprar_Bitcoin_Mercado-ComprarSaldoNaoDisponivel"));
			/** Report Extent **/
			
		} 

	}
	

	@Test
	public void STP06_000_Comprar_Dogecoin() throws Exception{
		
		// Variaveis
		String Dinheiro = new String("100000");
		String Dogecoin = new String("100000000");
		String CriptomoedaInformado;
		String DinheiroInformado;
		String ValorTaxaServico;
		String ValorLiquido;
		
		/** Report Extent **/
		test = extent.createTest("STP06_000_Comprar_Dogecoin");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		// Buscar o elemento na pagina
		String Valor_Total = driver.findElement(By.xpath("/html/body/main/page-top/div/div[2]/div[3]/p[1]/strong")).getText().substring(4);
		String Moedas_Valor_Total = driver.findElement(By.xpath("/html/body/main/page-top/div/div[2]/div[3]/p[2]/strong")).getText().substring(4);

		// Escrevendo no Console
		System.out.println("Valor Total em Dinheiro: " + Valor_Total);
		System.out.println("Valor Total em Moedas: " + Moedas_Valor_Total);
		
		// Convertendo a String em Float
		float ValorTotal = Float.valueOf(Valor_Total.replace(".", "").replace(",","."));
		float MoedasValorTotal = Float.valueOf(Moedas_Valor_Total.replace(".", "").replace(",", "."));
		
		// Informando os valores Minimos
		float ValorMinimoDinheiro = (float) 0000.00;
		float ValorMinimoMoedas = (float) 0.00000000;

		// Escrevendo no Console	
		System.out.println("Valor Total em Dinheiro: " + ValorTotal);
		System.out.println("Valor Total em Moedas: " + MoedasValorTotal);       
		System.out.println("Saldo Minimo em Dinheiro: " + ValorMinimoDinheiro);
		System.out.println("Saldo Minimo em Moedas: " + ValorMinimoMoedas);

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

		if (ValorTotal >= ValorMinimoDinheiro ) {

			/** Report Extent **/
			test.log(Status.PASS, "Comprar - Saldo Disponivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP06_000_Comprar_Dogecoin-ComprarSaldoDisponivel"));
			/** Report Extent **/

			// Escrevendo no Console	
			System.out.println("Saldo igual ao Minimo: " + ValorTotal + " " + "Minimo: " + ValorMinimoDinheiro);			
			System.out.println("OU");			
			System.out.println("Saldo em Dinheiro: " + ValorTotal + " " + "Maior que o Minimo: " + ValorMinimoDinheiro);
			
			if(IsElementPresent("qa-doge")) {
				
				// Colocando o Elemento na variavel
				WebElement Comprar = driver.findElement(By.xpath("//*[@id='qa-doge']/div[2]/button"));
				
				// Funcao HighLight
				HighLightElement(Comprar);
				
				// Clicar no Botao Comprar
				Comprar.click();
				Thread.sleep(2000);// esperar 1 segundo
				
				// Escrevendo no Console	
				System.out.println("Comprar Bitcoin está Visível");

				/** Report Extent **/
				test.log(Status.PASS, "Comprar Bitcoin está Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP06_000_Comprar_Dogecoin-ComprarBitcoinVisivel"));
				/** Report Extent **/

				if (IsElementPresent("buy")) {
	
					// Escrevendo no Console	
					System.out.println("Formulario de Comprar esta Visivel");
	
					/** Report Extent **/
					test.log(Status.PASS, "Formulario de Comprar esta Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP06_000_Comprar_Dogecoin-FormularioComprarVisivel"));
					/** Report Extent **/
					
					// Buscar o elemento na página
					List<WebElement> ListMoeda = driver.findElements(By.name("selectCoin"));
					
					// Procurando o Elemento
					WebElement SelectCoin = ListMoeda.get(0);
					
					if(SelectCoin.getAttribute("textContent").contains("Dogecoin")) { 
			
						// Funcao HighLight
				        HighLightElement(SelectCoin);
				        
				        // Procurando o Elemento Select
				        Select Coin = new Select(SelectCoin);
				        
				        // Selecionando a Moeda
				        Coin.selectByValue("Dogecoin");
				        Thread.sleep(1000); // Espera 1 segundo
		
						// Escrevendo no Console	
						System.out.println("Moeda selecionada é valida");
						
						/** Report Extent **/
						test.log(Status.PASS, "Moeda selecionada é valida");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP06_000_Comprar_Dogecoin-MoedaSelecionadaValida"));
						/** Report Extent **/

						if(driver.findElement(By.xpath("//*[@id='buy']/buy-exchange/div/div/div/div/div[3]")).getText().contains("Não existe ordem de venda no livro.")) {
		
							// Escrevendo no Console	
							System.out.println("Não existe ordem de venda no livro.");
		
							/** Report Extent **/
							test.log(Status.PASS, "Não existe ordem de venda no livro.");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP06_000_Comprar_Dogecoin-NaoExiteOrdemDeVendaNoLivro"));
							/** Report Extent **/
							
							// Compra Mercado
							if (IsElementEnabled("//button[text()='Opções avançadas']") && IsElementPresent("//button[text()='Opções avançadas']")) {
							
								// Escrevendo no Console	
								System.out.println("Botao 'Opcao Avancada' Visivel");
								
								// Colocando o Elemento na variavel
								WebElement opcao_avancada = driver.findElement(By.xpath("//button[text()='Opções avançadas']"));
								
								// Funcao HighLight
								HighLightElement(opcao_avancada);
								
								// Clicar no Botao Comprar
								opcao_avancada.click();
								Thread.sleep(2000);// esperar 1 segundo
								
								/** Report Extent **/
								test.log(Status.PASS, "Botao 'Opcao Avancada' Visivel");
								test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP06_000_Comprar_Dogecoin-BotaoOpcaoAvancadaVisivel"));
								/** Report Extent **/
								
								// Buscar o elemento na página
								List<WebElement> ListMoeda_ = driver.findElements(By.name("selectCoin"));
								
								// Procurando o Elemento
								WebElement SelectCoin_ = ListMoeda_.get(1);
								
								if(SelectCoin_.getAttribute("textContent").contains("Dogecoin")) { 
												
									// Funcao HighLight
							        HighLightElement(SelectCoin_);
							        
							        // Procurando o Elemento Select
							        Select Coin_ = new Select(SelectCoin_);
							        
							        // Selecionando a Moeda
							        Coin_.selectByValue("Bitcoin");
							        Thread.sleep(1000); // Espera 1 segundo
					
									// Escrevendo no Console	
									System.out.println("Moeda selecionada é valida");
									
									/** Report Extent **/
									test.log(Status.PASS, "Moeda selecionada é valida");
									test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP06_000_Comprar_Dogecoin-MoedaSelecionadaValida"));
									/** Report Extent **/	
								
									if (IsElementEnabled("buy-quantidade") && IsElementPresent("buy-quantidade")) {
				
										// Procurando o Elemento e colocando em uma Lista
										List <WebElement> comprar_dogecoin = driver.findElements(By.id("buy-quantidade"));
				
										// Colocando o Elemento na variavel
										WebElement buy_quantidade = comprar_dogecoin.get(1);
				
										// Funcao HighLight
										HighLightElement(buy_quantidade);
										
										// Inserindo o Valor para Comprar
										buy_quantidade.sendKeys(Dogecoin);
										Thread.sleep(2000);// esperar 2 segundo
										
										/** Report Extent **/
										test.log(Status.PASS, "Campo 'Insira a quantidade de Dogecoin que deseja comprar' - Visivel - Compra no Mercado");
										test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP06_000_Comprar_Dogecoin-QuantidadeDogecoinVisivel"));
										/** Report Extent **/
										
										// Escrevendo no Console	
										System.out.println("Campo 'Insira a quantidade de Dogecoin que deseja comprar' - Visivel - Compra no Mercado");
										
									} else {
				
										// Escrevendo no Console	
										System.out.println("Campo 'Insira quantos Dogecoin deseja comprar' nao Visivel ou nao Editavel - Compra no Mercado");
										
										/** Report Extent **/
										test.log(Status.ERROR, "Campo 'Insira a quantidade de Dogecoin que deseja comprar'- Não Visivel - Compra no Mercado");
										test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP06_000_Comprar_Dogecoin-QuantidadeDogecoinNaoVisivel"));
										/** Report Extent **/
										
									}
									
									if (IsElementEnabled("valor-venda") && IsElementPresent("valor-venda")) {
				
										// Procurando o Elemento e colocando em uma Lista
										List <WebElement> comprar_reais = driver.findElements(By.id("valor-venda"));
				
										// Colocando o Elemento na variavel
										WebElement campo_comprar_reais = comprar_reais.get(1);
				
										// Funcao HighLight
										HighLightElement(campo_comprar_reais);
										
										// Inserindo o Valor para Comprar
										campo_comprar_reais.sendKeys(Dinheiro);
										Thread.sleep(2000);// esperar 2 segundo
				
										/** Report Extent **/
										test.log(Status.PASS, "Campo 'Insira o valor que deseja pagar pelo Dogecoin Inteiro' - Visivel - Compra no Mercado");
										test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP06_000_Comprar_Dogecoin-ValorDogecoinInteiroVisivel"));
										/** Report Extent **/
										
										// Escrevendo no Console	
										System.out.println("Campo 'Insira o valor que deseja pagar pelo Dogecoin Inteiro' - Visivel - Compra no Mercado");
				
									} else {
				
										// Escrevendo no Console	
										System.out.println("Campo 'Insira o valor que deseja pagar pelo Dogecoin Inteiro' - Não Visivel - Compra no Mercado");
										
										/** Report Extent **/
										test.log(Status.ERROR, "Campo 'Insira o valor que deseja pagar pelo Dogecoin Inteiro' - Não Visivel - Compra no Mercado");
										test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP06_000_Comprar_Dogecoin-ValorDogecoinInteiroNaoVisivel"));
										/** Report Extent **/
										
									}	
																							
									if (IsElementEnabled("//button[@type='submit']") && IsElementPresent("//button[@type='submit']")) {
										
										// Escrevendo no Console	
										System.out.println("Botao 'Comprar' Visivel - Compra no Mercado");
										
										/** Report Extent **/
										test.log(Status.PASS, "Botao 'Comprar' Visivel - Compra no Mercado");
										test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP06_000_Comprar_Dogecoin-BotaoComprarVisivelMercado"));
										/** Report Extent **/
										
											/** Armazenando os valores as Taxas	 */
											// Procurando o Elemento e colocando em uma Lista
											List <WebElement> dogecoin_informado = driver.findElements(By.id("buy-quantidade"));
											
											// Buscar o elemento na pagina
											CriptomoedaInformado = dogecoin_informado.get(1).getAttribute("value");
											
											// Procurando o Elemento e colocando em uma Lista
											List <WebElement> dinheiro_informado = driver.findElements(By.id("valor-venda"));
											
											// Buscar o elemento na pagina
											DinheiroInformado = dinheiro_informado.get(1).getAttribute("value").substring(3);
											
											// Procurando o Elemento e colocando em uma Lista
											List <WebElement> valor_taxa = driver.findElements(By.xpath("//*[@id='valor-taxa']"));
					
											// Colocando o Elemento na variavel
											ValorTaxaServico = valor_taxa.get(2).getAttribute("value");
											ValorLiquido = valor_taxa.get(3).getAttribute("value");
			
											// Escrevendo no Console	
											System.out.println(CriptomoedaInformado); 
											System.out.println(DinheiroInformado); 
											System.out.println(ValorTaxaServico); 
											System.out.println(ValorLiquido);
											/** Armazenando os valores as Taxas */
										
										// Função que retorna a String OK ou NOK
										String ValidadorTaxa = Taxas.TaxasZater("Normal", "DOGE", "Buy", "Passiva", CriptomoedaInformado, DinheiroInformado, ValorTaxaServico, ValorLiquido);
										String StatusTaxa = "OK";	
										
										// Escrevendo no Console	
										System.out.println(ValidadorTaxa);									
										System.out.println(StatusTaxa);
										
											if (ValidadorTaxa.equals(StatusTaxa)) {
											
											// Procurando o Elemento e colocando em uma Lista
											List <WebElement> botao_comprar = driver.findElements(By.xpath("//button[@type='submit']"));
					
											// Colocando o Elemento na variavel
											WebElement button_buy = botao_comprar.get(1);
					
											// Funcao HighLight
											HighLightElement(button_buy);
								
											// Clicar no Botao Comprar
											button_buy.click();
											Thread.sleep(2000);// esperar 2 segundo
											
											// Escrevendo no Console	
											System.out.println("Taxa PASSIVA OK");
											System.out.println("Acionando o Botão 'Comprar'");
											
											/** Report Extent **/
											test.log(Status.PASS, "TAXA PASSIVA OK - Compra no Mercado");
											test.log(Status.PASS, "Acionando o Botão 'Comprar'");
											test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP06_000_Comprar_Dogecoin-TaxaPassivaOKMercado"));
											/** Report Extent **/
				
											} else {
												
												// Escrevendo no Console	
												System.out.println("Taxa PASSIVA NOK");
												
												/** Report Extent **/
												test.log(Status.ERROR, "TAXA PASSIVA NOK - Compra no Mercado");
												test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP06_000_Comprar_Dogecoin-TaxaPassivaNOKMercado"));
												/** Report Extent **/
												
											}
				
									} else {
				
										// Escrevendo no Console	
										System.out.println("Botao 'Comprar' Não Visivel ou nao Habilitado - Compra no Mercado");
										
										/** Report Extent **/
										test.log(Status.ERROR, "Botao 'Comprar' Não Visivel - Compra no Mercado");
										test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP06_000_Comprar_Dogecoin-BotaoComprarNaoVisivelMercado"));
										/** Report Extent **/
										
									}
									
								} else {
									
									// Escrevendo no Console	
									System.out.println("Comprar Dogecoin Não está Visível");

									/** Report Extent **/
									test.log(Status.ERROR, "Comprar Dogecoin Não está Visível");
									test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP06_000_Comprar_Dogecoin-ComprarDogecoinNaoVisivel"));
									/** Report Extent **/
									
								}
									
							} else {
								
								// Escrevendo no Console	
								System.out.println("Botao 'Opcao Avancada' Não Visivel ou nao Habilitado - Compra no Mercado");
								
								/** Report Extent **/
								test.log(Status.ERROR, "Botao 'Opcao Avancada' Não Visivel");
								test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP06_000_Comprar_Dogecoin-BotaoOpcaoAvancadaNaoVisivel"));
								/** Report Extent **/
								
							}
		
						} else { // Comprar Imediatamente
		
							if (IsElementEnabled("buy-quantidade") && IsElementPresent("buy-quantidade")) {
		
								// Procurando o Elemento e colocando em uma Lista
								List <WebElement> comprar_dogecoin = driver.findElements(By.id("buy-quantidade"));
		
								// Colocando o Elemento na variavel
								WebElement buy_quantidade = comprar_dogecoin.get(0);
		
								// Funcao HighLight
								HighLightElement(buy_quantidade);
		
								// Escrevendo no Console	
								System.out.println("Campo 'Insira quantos Dogecoin deseja comprar' - Visivel - Comprar Imediatamente");
		
								/** Report Extent **/
								test.log(Status.PASS, "Campo 'Insira a quantidade de Dogecoin que deseja comprar' - Visivel - Comprar Imediatamente");
								test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP06_000_Comprar_Dogecoin-EuQueroComprar"));
								/** Report Extent **/
								
							} else {
		
								// Escrevendo no Console	
								System.out.println("Campo 'Insira quantos Dogecoin deseja comprar' Não Visivel ou nao Editavel - Comprar Imediatamente");
								
								/** Report Extent **/
								test.log(Status.ERROR, "Campo 'Insira quantos Dogecoin deseja comprar' - Não Visivel - Comprar Imediatamente");
								test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP06_000_Comprar_Dogecoin-EuQueroComprar"));
								/** Report Extent **/
								
							}
		
							if (IsElementEnabled("valor-venda") && IsElementPresent("valor-venda")) {
		
								// Procurando o Elemento e colocando em uma Lista
								List <WebElement> comprar_reais = driver.findElements(By.id("valor-venda"));
		
								// Colocando o Elemento na variavel
								WebElement campo_comprar_reais = comprar_reais.get(0);
		
								// Funcao HighLight
								HighLightElement(campo_comprar_reais);
		
								// Inserindo o Valor para Comprar
								campo_comprar_reais.sendKeys(Dinheiro);
								Thread.sleep(2000);// esperar 2 segundo
								
								// Escrevendo no Console	
								System.out.println("Campo 'Insira quantos Reais deseja comprar em Dogecoin' - Visivel - Comprar Imediatamente");
								
								/** Report Extent **/
								test.log(Status.PASS, "Campo 'Insira quantos Reais deseja comprar em Dogecoin' - Visivel - Comprar Imediatamente");
								test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP06_000_Comprar_Dogecoin-EuQueroComprar"));
								/** Report Extent **/
		
							} else {
		
								// Escrevendo no Console	
								System.out.println("Campo 'Insira quantos Reais deseja comprar em Dogecoin' - Não Visivel - Comprar Imediatamente");
								
								/** Report Extent **/
								test.log(Status.ERROR, "Campo 'Insira quantos Reais deseja comprar em Dogecoin' - Não Visivel - Comprar Imediatamente");
								test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP06_000_Comprar_Dogecoin-EuQueroComprar"));
								/** Report Extent **/
								
							}
		
							if (IsElementEnabled("//button[@type='submit']") && IsElementPresent("//button[@type='submit']")) {
		
								// Escrevendo no Console	
								System.out.println("Botao 'Comprar' Visivel - Comprar Imediatamente");
								
								/** Report Extent **/
								test.log(Status.PASS, "Botao 'Comprar' Visivel - Comprar Imediatamente");
								test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP06_000_Comprar_Dogecoin-BotaoComprarVisivelImediatamente"));
								/** Report Extent **/
								
									/** Armazenando os valores as Taxas	 */
									// Procurando o Elemento e colocando em uma Lista
									List <WebElement> dogecoin_informado = driver.findElements(By.id("buy-quantidade"));
									
									// Buscar o elemento na pagina
									CriptomoedaInformado = dogecoin_informado.get(0).getAttribute("value");
									
									// Procurando o Elemento e colocando em uma Lista
									List <WebElement> dinheiro_informado = driver.findElements(By.id("valor-venda"));
									
									// Buscar o elemento na pagina
									DinheiroInformado = dinheiro_informado.get(0).getAttribute("value").substring(3);
									
									// Procurando o Elemento e colocando em uma Lista
									List <WebElement> valor_taxa = driver.findElements(By.xpath("//*[@id='valor-taxa']"));
			
									// Colocando o Elemento na variavel
									ValorTaxaServico = valor_taxa.get(0).getAttribute("value");
									ValorLiquido = valor_taxa.get(1).getAttribute("value");
			
									// Escrevendo no Console	
									System.out.println(CriptomoedaInformado); 
									System.out.println(DinheiroInformado); 
									System.out.println(ValorTaxaServico); 
									System.out.println(ValorLiquido);
									/** Armazenando os valores as Taxas */
								
								// Função que retorna a String OK ou NOK
								String ValidadorTaxa = Taxas.TaxasZater("Normal", "DOGE", "Buy", "Ativa", CriptomoedaInformado, DinheiroInformado, ValorTaxaServico, ValorLiquido);
								String StatusTaxa = "OK";
								
								// Escrevendo no Console	
								System.out.println(ValidadorTaxa);	
								System.out.println(StatusTaxa);			
								
								if (ValidadorTaxa.equals(StatusTaxa)) {
									
									// Procurando o Elemento e colocando em uma Lista
									List <WebElement> botao_comprar = driver.findElements(By.xpath("//button[@type='submit']"));
			
									// Colocando o Elemento na variavel
									WebElement button_buy = botao_comprar.get(0);
			
									// Funcao HighLight
									HighLightElement(button_buy);
			
									// Clicar no Botao Comprar
									button_buy.click();
									Thread.sleep(2000);// esperar 2 segundo
									
									// Escrevendo no Console	
									System.out.println("Taxa ATIVA OK");
									System.out.println("Acionando o Botão 'Comprar'");
									
									/** Report Extent **/
									test.log(Status.PASS, "TAXA ATIVA OK - Comprar Imediatamente");
									test.log(Status.PASS, "Acionando o Botão 'Comprar'");
									test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP06_000_Comprar_Dogecoin-TaxaAtivaOKImediatamente"));
									/** Report Extent **/
																		
									} else {
										
										// Escrevendo no Console	
										System.out.println("Taxa ATIVA NOK");
										
										/** Report Extent **/
										test.log(Status.ERROR, "TAXA ATIVA NOK - Comprar Imediatamente");
										test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP06_000_Comprar_Dogecoin-TaxaAtivaNOKImediatamente"));
										/** Report Extent **/
										
									}
								
							} else {
		
								// Escrevendo no Console	
								System.out.println("Botao 'Comprar' Não Visivel ou nao Habilitado - Comprar Imediatamente");
		
								/** Report Extent **/
								test.log(Status.ERROR, "Botao 'Comprar' Não Visivel ou nao Habilitado - Comprar Imediatamente");
								test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP06_000_Comprar_Dogecoin-BotaoComprarNaoVisivelImediatamente"));
								/** Report Extent **/
								
							}
		
						}
						
					} else {
						
						// Escrevendo no Console	
						System.out.println("Moeda selecionada não é valida");
						
						/** Report Extent **/
						test.log(Status.ERROR, "Moeda selecionada não é valida");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP06_000_Comprar_Dogecoin-MoedaSelecionadaNaoValida"));
						/** Report Extent **/
						
					}
	
				} else {
	
					// Escrevendo no Console	
					System.out.println("Formulario de Comprar - Nao esta Visivel");
					
					/** Report Extent **/
					test.log(Status.ERROR, "Formulario de Comprar - Nao esta Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP06_000_Comprar_Dogecoin-FormularioComprarNaoVisivel"));
					/** Report Extent **/
	
				}
				
			} else {
				
				// Escrevendo no Console	
				System.out.println("Comprar Dogecoin Não está Visível");

				/** Report Extent **/
				test.log(Status.ERROR, "Comprar Dogecoin Não está Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP06_000_Comprar_Dogecoin-ComprarDogecoinNaoVisivel"));
				/** Report Extent **/
				
			}
			
		} else {

			// Escrevendo no Console	
			System.out.println("Saldo em Dinheiro não permitido: " + "Saldo Atual: " + ValorTotal + " " + "Minimo: " + ValorMinimoDinheiro);
			
			/** Report Extent **/
			test.log(Status.ERROR, "Comprar - Saldo Não Disponivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP06_000_Comprar_Dogecoin-ComprarSaldoNaoDisponivel"));
			/** Report Extent **/
			
		} 

	}
	
	@Test
	public void STP07_000_Comprar_Dogecoin_Mercado() throws Exception{
		
		// Variaveis
		String Dinheiro = new String("100000");
		String Dogecoin = new String("100000000");
		String CriptomoedaInformado;
		String DinheiroInformado;
		String ValorTaxaServico;
		String ValorLiquido;
		
		/** Report Extent **/
		test = extent.createTest("STP07_000_Comprar_Dogecoin_Mercado");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		// Buscar o elemento na pagina
		String Valor_Total = driver.findElement(By.xpath("/html/body/main/page-top/div/div[2]/div[3]/p[1]/strong")).getText().substring(4);
		String Moedas_Valor_Total = driver.findElement(By.xpath("/html/body/main/page-top/div/div[2]/div[3]/p[2]/strong")).getText().substring(4);
			
		// Escrevendo no Console
		System.out.println("Valor Total em Dinheiro: " + Valor_Total);
		System.out.println("Valor Total em Moedas: " + Moedas_Valor_Total);
		
		// Convertendo a String em Float
		float ValorTotal = Float.valueOf(Valor_Total.replace(".", "").replace(",","."));
		float MoedasValorTotal = Float.valueOf(Moedas_Valor_Total.replace(".", "").replace(",", "."));
		
		// Informando os valores Minimos
		float ValorMinimoDinheiro = (float) 0000.00;
		float ValorMinimoMoedas = (float) 0.00000000;

		// Escrevendo no Console	
		System.out.println("Valor Total em Dinheiro: " + ValorTotal);
		System.out.println("Valor Total em Moedas: " + MoedasValorTotal);       
		System.out.println("Saldo Minimo em Dinheiro: " + ValorMinimoDinheiro);
		System.out.println("Saldo Minimo em Moedas: " + ValorMinimoMoedas);

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

		if (ValorTotal >= ValorMinimoDinheiro ) {

			/** Report Extent **/
			test.log(Status.PASS, "Comprar - Saldo Disponivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP07_000_Comprar_Dogecoin_Mercado-ComprarSaldoDisponivel"));
			/** Report Extent **/

			// Escrevendo no Console	
			System.out.println("Saldo igual ao Minimo: " + ValorTotal + " " + "Minimo: " + ValorMinimoDinheiro);			
			System.out.println("OU");			
			System.out.println("Saldo em Dinheiro: " + ValorTotal + " " + "Maior que o Minimo: " + ValorMinimoDinheiro);
				
			if (IsElementPresent("buy")) {

				// Escrevendo no Console	
				System.out.println("Formulario de Comprar esta Visivel");

				/** Report Extent **/
				test.log(Status.PASS, "Formulario de Comprar esta Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP07_000_Comprar_Dogecoin_Mercado-FormularioComprarVisivel"));
				/** Report Extent **/			
				
				// Compra Mercado
				if (IsElementEnabled("//button[text()='Opções avançadas']") && IsElementPresent("//button[text()='Opções avançadas']")) {
				
					// Escrevendo no Console	
					System.out.println("Botao 'Opcao Avancada' Visivel");
					
					// Colocando o Elemento na variavel
					WebElement opcao_avancada = driver.findElement(By.xpath("//button[text()='Opções avançadas']"));
					
					// Funcao HighLight
					HighLightElement(opcao_avancada);
					
					// Clicar no Botao Comprar
					opcao_avancada.click();
					Thread.sleep(2000);// esperar 1 segundo
					
					/** Report Extent **/
					test.log(Status.PASS, "Botao 'Opcao Avancada' - Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP07_000_Comprar_Dogecoin_Mercado-BotaoOpcaoAvancadaVisivel"));
					/** Report Extent **/
				
					// Buscar o elemento na página
					List<WebElement> ListMoeda = driver.findElements(By.name("selectCoin"));
					
					// Procurando o Elemento
					WebElement SelectCoin = ListMoeda.get(1);
					
					if(SelectCoin.getAttribute("textContent").contains("Dogecoin")) { 
									
						// Funcao HighLight
				        HighLightElement(SelectCoin);
				        
				        // Procurando o Elemento Select
				        Select Coin = new Select(SelectCoin);
				        
				        // Selecionando a Moeda
				        Coin.selectByValue("Dogecoin");
				        Thread.sleep(1000); // Espera 1 segundo
		
						// Escrevendo no Console	
						System.out.println("Moeda selecionada é valida");
						
						/** Report Extent **/
						test.log(Status.PASS, "Moeda selecionada é valida");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP07_000_Comprar_Dogecoin_Mercado-MoedaSelecionadaValida"));
						/** Report Extent **/	
							
						if (IsElementEnabled("buy-quantidade") && IsElementPresent("buy-quantidade")) {
	
							// Procurando o Elemento e colocando em uma Lista
							List <WebElement> comprar_dogecoin = driver.findElements(By.id("buy-quantidade"));
	
							// Colocando o Elemento na variavel
							WebElement buy_quantidade = comprar_dogecoin.get(1);
	
							// Funcao HighLight
							HighLightElement(buy_quantidade);
							
							// Inserindo o Valor para Comprar
							buy_quantidade.sendKeys(Dogecoin);
							Thread.sleep(2000);// esperar 1 segundo
	
							// Escrevendo no Console	
							System.out.println("Campo 'Insira a quantidade de Dogecoin que deseja comprar' - Visivel - Comprar no Mercado");
							
							/** Report Extent **/
							test.log(Status.PASS, "Campo 'Insira a quantidade de Dogecoin que deseja comprar' - Visivel - Comprar no Mercado");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP07_000_Comprar_Dogecoin_Mercado-QuantidadeDogecoinVisivel"));
							/** Report Extent **/
							
						} else {
	
							// Escrevendo no Console	
							System.out.println("Campo 'Insira a quantidade de Dogecoin que deseja comprar' nao Visivel ou nao Editavel - Compra Mercado");
	
							/** Report Extent **/
							test.log(Status.ERROR, "Campo 'Insira a quantidade de Dogecoin que deseja comprar' - Não Visivel - Comprar no Mercado");
							test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP07_000_Comprar_Dogecoin_Mercado-QuantidadeDogecoinNaoVisivel"));
							/** Report Extent **/
							
						}
						
						if (IsElementEnabled("valor-venda") && IsElementPresent("valor-venda")) {
	
							// Procurando o Elemento e colocando em uma Lista
							List <WebElement> comprar_reais = driver.findElements(By.id("valor-venda"));
	
							// Colocando o Elemento na variavel
							WebElement campo_comprar_reais = comprar_reais.get(1);
	
							// Funcao HighLight
							HighLightElement(campo_comprar_reais);
							
							// Inserindo o Valor para Comprar
							campo_comprar_reais.sendKeys(Dinheiro);
							Thread.sleep(2000);// esperar 1 segundo
	
							// Escrevendo no Console	
							System.out.println("Campo 'Insira o valor que deseja pagar pelo Dogecoin Inteiro' Visivel - Comprar no Mercado");
	
							/** Report Extent **/
							test.log(Status.PASS, "Campo 'Insira o valor que deseja pagar pelo Dogecoin Inteiro' Visivel - Comprar no Mercado");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP07_000_Comprar_Dogecoin_Mercado-ValorDogecoinInteiroVisivel"));
							/** Report Extent **/
							
						} else {
	
							// Escrevendo no Console	
							System.out.println("Campo 'Insira quantos Reais deseja comprar em Dogecoin' Não Visivel ou nao Editavel - Compra Mercado");
							
							/** Report Extent **/
							test.log(Status.ERROR, "Campo 'Insira quantos Reais deseja comprar em Dogecoin' Não Visivel ou nao Editavel - Compra Mercado");
							test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Comprar_Bitcoin_Mercado-ValorDogecoinInteiroNaoVisivel"));
							/** Report Extent **/
							
						}	
																				
						if (IsElementEnabled("//button[@type='submit']") && IsElementPresent("//button[@type='submit']")) {
							
							// Escrevendo no Console	
							System.out.println("Botao 'Comprar' Visivel - Comprar Mercado");
							
							/** Report Extent **/
							test.log(Status.PASS, "Botao 'Comprar' Visivel - Comprar no Mercado");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP07_000_Comprar_Dogecoin_Mercado-BotaoComprarVisivelMercado"));
							/** Report Extent **/
							
								/** Armazenando os valores as Taxas	 */
								// Procurando o Elemento e colocando em uma Lista
								List <WebElement> dogecoin_informado = driver.findElements(By.id("buy-quantidade"));
								
								// Buscar o elemento na pagina
								CriptomoedaInformado = dogecoin_informado.get(1).getAttribute("value");
								
								// Procurando o Elemento e colocando em uma Lista
								List <WebElement> dinheiro_informado = driver.findElements(By.id("valor-venda"));
								
								// Buscar o elemento na pagina
								DinheiroInformado = dinheiro_informado.get(1).getAttribute("value").substring(3);
								
								// Procurando o Elemento e colocando em uma Lista
								List <WebElement> valor_taxa = driver.findElements(By.xpath("//*[@id='valor-taxa']"));
		
								// Colocando o Elemento na variavel
								ValorTaxaServico = valor_taxa.get(2).getAttribute("value");
								ValorLiquido = valor_taxa.get(3).getAttribute("value");

								// Escrevendo no Console	
								System.out.println(CriptomoedaInformado); 
								System.out.println(DinheiroInformado); 
								System.out.println(ValorTaxaServico); 
								System.out.println(ValorLiquido);
								/** Armazenando os valores as Taxas */
							
							// Função que retorna a String OK ou NOK
							String ValidadorTaxa = Taxas.TaxasZater("Normal", "DOGE", "Buy", "Passiva", CriptomoedaInformado, DinheiroInformado, ValorTaxaServico, ValorLiquido);
							String StatusTaxa = "OK";
							
							// Escrevendo no Console
							System.out.println(ValidadorTaxa);									
							System.out.println(StatusTaxa);
							
								if (ValidadorTaxa.equals(StatusTaxa)) {
								
								// Procurando o Elemento e colocando em uma Lista
								List <WebElement> botao_comprar = driver.findElements(By.xpath("//button[@type='submit']"));
		
								// Colocando o Elemento na variavel
								WebElement button_buy = botao_comprar.get(1);
		
								// Funcao HighLight
								HighLightElement(button_buy);
		
								// Clicar no Botao Comprar
								button_buy.click();
								Thread.sleep(2000);// esperar 1 segundo
								
								// Escrevendo no Console	
								System.out.println("Taxa PASSIVA OK");
								System.out.println("Acionando o Botão 'Comprar'");
												
								/** Report Extent **/
								test.log(Status.PASS, "TAXA PASSIVA OK - Compra no Mercado");
								test.log(Status.PASS, "Acionando o Botão 'Comprar'");
								test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP07_000_Comprar_Dogecoin_Mercado-TaxaPassivaOKMercado"));
								/** Report Extent **/
								
								} else {
									
									// Escrevendo no Console	
									System.out.println("TAXA PASSIVA NOK");
									
									/** Report Extent **/
									test.log(Status.PASS, "TAXA PASSIVA NOK - Compra no Mercado");
									test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP07_000_Comprar_Dogecoin_Mercado-TaxaPassivaNOKMercado"));
									/** Report Extent **/
									
								}
	
						} else {
	
							// Escrevendo no Console	
							System.out.println("Botao 'Comprar' Não Visivel ou nao Habilitado - Compra no Mercado");
	
							/** Report Extent **/
							test.log(Status.ERROR, "Botao 'Comprar' Não Visivel ou nao Habilitado - Compra no Mercado");
							test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP07_000_Comprar_Dogecoin_Mercado-BotaoComprarNaoVisivelMercado"));
							/** Report Extent **/
							
						}
						
					} else {
						
						// Escrevendo no Console	
						System.out.println("Comprar Dogecoin Não está Visível");

						/** Report Extent **/
						test.log(Status.ERROR, "Comprar Dogecoin Não está Visível");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP07_000_Comprar_Dogecoin_Mercado-ComprarDogecoinNaoVisivel"));
						/** Report Extent **/
						
					}
						
				} else {
					
					// Escrevendo no Console	
					System.out.println("Botao 'Opcao Avancada' Não Visivel ou nao Habilitado - Compra no Mercado");
					
					/** Report Extent **/
					test.log(Status.ERROR, "Botao 'Opcao Avancada' - Não Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP07_000_Comprar_Dogecoin_Mercado-BotaoOpcaoAvancadaNaoVisivel"));
					/** Report Extent **/
					
				}

			} else {
				
				// Escrevendo no Console	
				System.out.println("Formulario de Comprar - Nao esta Visivel");
				
				/** Report Extent **/
				test.log(Status.ERROR, "Formulario de Comprar - Nao esta Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP07_000_Comprar_Dogecoin_Mercado-FormularioComprarNaoVisivel"));
				/** Report Extent **/

			}
							
		} else {

			// Escrevendo no Console	
			System.out.println("Saldo em Dinheiro não permitido: " + "Saldo Atual: " + ValorTotal + " " + "Minimo: " + ValorMinimoDinheiro);
			
			/** Report Extent **/
			test.log(Status.ERROR, "Comprar - Saldo Não Disponivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP07_000_Comprar_Dogecoin_Mercado-ComprarSaldoNaoDisponivel"));
			/** Report Extent **/
			
		} 

	}

	@Ignore
	@Test
	public void STP08_000_Comprar_Litecoin() throws Exception{
		
		// Variaveis
		String Dinheiro = new String("100000");
		String Bitcoin = new String("100000000");
		String BitcoinInformado;
		String DinheiroInformado;
		String ValorTaxaServico;
		String ValorLiquido;
		
		/** Report Extent **/
		test = extent.createTest("STP04_000_Comprar_Bitcoin");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		// Buscar o elemento na pagina
		String Valor_Total = driver.findElement(By.xpath("/html/body/main/page-top/div/div[2]/div[3]/p[1]/strong")).getText().substring(4);
		String Moedas_Valor_Total = driver.findElement(By.xpath("/html/body/main/page-top/div/div[2]/div[3]/p[2]/strong")).getText().substring(4);

		// Escrevendo no Console
		System.out.println("Valor Total em Dinheiro: " + Valor_Total);
		System.out.println("Valor Total em Moedas: " + Moedas_Valor_Total);
		
		// Convertendo a String em Float
		float ValorTotal = Float.valueOf(Valor_Total.replace(".", "").replace(",","."));
		float MoedasValorTotal = Float.valueOf(Moedas_Valor_Total.replace(".", "").replace(",", "."));
		
		// Informando os valores Minimos
		float ValorMinimoDinheiro = (float) 0000.00;
		float ValorMinimoMoedas = (float) 0.00000000;

		// Escrevendo no Console	
		System.out.println("Valor Total em Dinheiro: " + ValorTotal);
		System.out.println("Valor Total em Moedas: " + MoedasValorTotal);       
		System.out.println("Saldo Minimo em Dinheiro: " + ValorMinimoDinheiro);
		System.out.println("Saldo Minimo em Moedas: " + ValorMinimoMoedas);

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

		if (ValorTotal >= ValorMinimoDinheiro ) {

			/** Report Extent **/
			test.log(Status.PASS, "Comprar - Saldo Disponivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-ComprarSaldoDisponivel"));
			/** Report Extent **/

			// Escrevendo no Console	
			System.out.println("Saldo igual ao Minimo: " + ValorTotal + " " + "Minimo: " + ValorMinimoDinheiro);			
			System.out.println("OU");			
			System.out.println("Saldo em Dinheiro: " + ValorTotal + " " + "Maior que o Minimo: " + ValorMinimoDinheiro);
			
			if(IsElementPresent("qa-btc")) {
				
				// Colocando o Elemento na variavel
				WebElement Comprar = driver.findElement(By.xpath("//*[@id='qa-btc']/div[2]/button"));
				
				// Funcao HighLight
				HighLightElement(Comprar);
				
				// Clicar no Botao Comprar
				Comprar.click();
				Thread.sleep(2000);// esperar 1 segundo
				
				// Escrevendo no Console	
				System.out.println("Comprar Bitcoin está Visível");

				/** Report Extent **/
				test.log(Status.PASS, "Comprar Bitcoin está Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-ComprarBitcoinVisivel"));
				/** Report Extent **/

				if (IsElementPresent("buy")) {
	
					// Escrevendo no Console	
					System.out.println("Formulario de Comprar esta Visivel");
	
					/** Report Extent **/
					test.log(Status.PASS, "Formulario de Comprar esta Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-FormularioComprarVisivel"));
					/** Report Extent **/
					
					// Buscar o elemento na página
					List<WebElement> ListMoeda = driver.findElements(By.name("selectCoin"));
					
					// Procurando o Elemento
					WebElement SelectCoin = ListMoeda.get(0);
					
					if(SelectCoin.getAttribute("textContent").contains("Bitcoin")) { 
			
						// Funcao HighLight
				        HighLightElement(SelectCoin);
				        
				        // Procurando o Elemento Select
				        Select Coin = new Select(SelectCoin);
				        
				        // Selecionando a Moeda
				        Coin.selectByValue("Bitcoin");
				        Thread.sleep(1000); // Espera 1 segundo
		
						// Escrevendo no Console	
						System.out.println("Moeda selecionada é valida");
						
						/** Report Extent **/
						test.log(Status.PASS, "Moeda selecionadaé valida");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-MoedaSelecionadaValida"));
						/** Report Extent **/

						if(driver.findElement(By.xpath("//*[@id='buy']/buy-exchange/div/div/div/div/div[3]")).getText().contains("Não existe ordem de venda no livro.")) {
		
							// Escrevendo no Console	
							System.out.println("Não existe ordem de venda no livro.");
		
							/** Report Extent **/
							test.log(Status.PASS, "Não existe ordem de venda no livro.");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-NaoExiteOrdemDeVendaNoLivro"));
							/** Report Extent **/
							
							// Compra Mercado
							if (IsElementEnabled("//button[text()='Opções avançadas']") && IsElementPresent("//button[text()='Opções avançadas']")) {
							
								// Escrevendo no Console	
								System.out.println("Botao 'Opcao Avancada' Visivel");
								
								// Colocando o Elemento na variavel
								WebElement opcao_avancada = driver.findElement(By.xpath("//button[text()='Opções avançadas']"));
								
								// Funcao HighLight
								HighLightElement(opcao_avancada);
								
								// Clicar no Botao Comprar
								opcao_avancada.click();
								Thread.sleep(2000);// esperar 1 segundo
								
								/** Report Extent **/
								test.log(Status.PASS, "Botao 'Opcao Avancada' Visivel");
								test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-BotaoOpcaoAvancadaVisivel"));
								/** Report Extent **/
								
								// Buscar o elemento na página
								List<WebElement> ListMoeda_ = driver.findElements(By.name("selectCoin"));
								
								// Procurando o Elemento
								WebElement SelectCoin_ = ListMoeda_.get(1);
								
								if(SelectCoin_.getAttribute("textContent").contains("Bitcoin")) { 
												
									// Funcao HighLight
							        HighLightElement(SelectCoin_);
							        
							        // Procurando o Elemento Select
							        Select Coin_ = new Select(SelectCoin_);
							        
							        // Selecionando a Moeda
							        Coin_.selectByValue("Bitcoin");
							        Thread.sleep(1000); // Espera 1 segundo
					
									// Escrevendo no Console	
									System.out.println("Moeda selecionada é valida");
									
									/** Report Extent **/
									test.log(Status.PASS, "Moeda selecionadaé valida");
									test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-MoedaSelecionadaValida"));
									/** Report Extent **/	
								
									if (IsElementEnabled("buy-quantidade") && IsElementPresent("buy-quantidade")) {
				
										// Procurando o Elemento e colocando em uma Lista
										List <WebElement> comprar_bitcoins = driver.findElements(By.id("buy-quantidade"));
				
										// Colocando o Elemento na variavel
										WebElement buy_quantidade = comprar_bitcoins.get(1);
				
										// Funcao HighLight
										HighLightElement(buy_quantidade);
										
										// Inserindo o Valor para Comprar
										buy_quantidade.sendKeys(Bitcoin);
										Thread.sleep(2000);// esperar 2 segundo
										
										/** Report Extent **/
										test.log(Status.PASS, "Campo 'Insira a quantidade de Bitcoins que deseja comprar' - Visivel - Compra no Mercado");
										test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-QuantidadeBTCVisivel"));
										/** Report Extent **/
										
										// Escrevendo no Console	
										System.out.println("Campo 'Insira a quantidade de Bitcoins que deseja comprar' - Visivel - Compra no Mercado");
										
									} else {
				
										// Escrevendo no Console	
										System.out.println("Campo 'Insira quantos Bitcoins deseja comprar' nao Visivel ou nao Editavel - Compra no Mercado");
										
										/** Report Extent **/
										test.log(Status.ERROR, "Campo 'Insira a quantidade de Bitcoins que deseja comprar'- Não Visivel - Compra no Mercado");
										test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-QuantidadeBTCNaoVisivel"));
										/** Report Extent **/
										
									}
									
									if (IsElementEnabled("valor-venda") && IsElementPresent("valor-venda")) {
				
										// Procurando o Elemento e colocando em uma Lista
										List <WebElement> comprar_reais = driver.findElements(By.id("valor-venda"));
				
										// Colocando o Elemento na variavel
										WebElement campo_comprar_reais = comprar_reais.get(1);
				
										// Funcao HighLight
										HighLightElement(campo_comprar_reais);
										
										// Inserindo o Valor para Comprar
										campo_comprar_reais.sendKeys(Dinheiro);
										Thread.sleep(2000);// esperar 2 segundo
				
										/** Report Extent **/
										test.log(Status.PASS, "Campo 'Insira o valor que deseja pagar pelo BTC Inteiro' - Visivel - Compra no Mercado");
										test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-ValorBTCInteiroVisivel"));
										/** Report Extent **/
										
										// Escrevendo no Console	
										System.out.println("Campo 'Insira o valor que deseja pagar pelo BTC Inteiro' - Visivel - Compra no Mercado");
				
									} else {
				
										// Escrevendo no Console	
										System.out.println("Campo 'Insira o valor que deseja pagar pelo BTC Inteiro' - Não Visivel - Compra no Mercado");
										
										/** Report Extent **/
										test.log(Status.ERROR, "Campo 'Insira o valor que deseja pagar pelo BTC Inteiro' - Não Visivel - Compra no Mercado");
										test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-ValorBTCInteiroNaoVisivel"));
										/** Report Extent **/
										
									}	
																							
									if (IsElementEnabled("//button[@type='submit']") && IsElementPresent("//button[@type='submit']")) {
										
										// Escrevendo no Console	
										System.out.println("Botao 'Comprar' Visivel - Compra no Mercado");
										
										/** Report Extent **/
										test.log(Status.PASS, "Botao 'Comprar' Visivel - Compra no Mercado");
										test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-BotaoComprarVisivelMercado"));
										/** Report Extent **/
										
											/** Armazenando os valores as Taxas	 */
											// Procurando o Elemento e colocando em uma Lista
											List <WebElement> bitcoins_informado = driver.findElements(By.id("buy-quantidade"));
											
											// Buscar o elemento na pagina
											BitcoinInformado = bitcoins_informado.get(1).getAttribute("value");
											
											// Procurando o Elemento e colocando em uma Lista
											List <WebElement> dinheiro_informado = driver.findElements(By.id("valor-venda"));
											
											// Buscar o elemento na pagina
											DinheiroInformado = dinheiro_informado.get(1).getAttribute("value").substring(3);
											
											// Procurando o Elemento e colocando em uma Lista
											List <WebElement> valor_taxa = driver.findElements(By.xpath("//*[@id='valor-taxa']"));
					
											// Colocando o Elemento na variavel
											ValorTaxaServico = valor_taxa.get(2).getAttribute("value");
											ValorLiquido = valor_taxa.get(3).getAttribute("value");
			
											// Escrevendo no Console	
											System.out.println(BitcoinInformado); 
											System.out.println(DinheiroInformado); 
											System.out.println(ValorTaxaServico); 
											System.out.println(ValorLiquido);
											/** Armazenando os valores as Taxas */
										
										// Função que retorna a String OK ou NOK
										String ValidadorTaxa = Taxas.TaxasZater("Normal", "BTC", "Buy", "Passiva", BitcoinInformado, DinheiroInformado, ValorTaxaServico, ValorLiquido);
										String StatusTaxa = "OK";	
										
										// Escrevendo no Console	
										System.out.println(ValidadorTaxa);									
										System.out.println(StatusTaxa);
										
											if (ValidadorTaxa.equals(StatusTaxa)) {
											
											// Procurando o Elemento e colocando em uma Lista
											List <WebElement> botao_comprar = driver.findElements(By.xpath("//button[@type='submit']"));
					
											// Colocando o Elemento na variavel
											WebElement button_buy = botao_comprar.get(1);
					
											// Funcao HighLight
											HighLightElement(button_buy);
								
											// Clicar no Botao Comprar
											button_buy.click();
											Thread.sleep(2000);// esperar 2 segundo
											
											// Escrevendo no Console	
											System.out.println("Taxa PASSIVA OK");
											System.out.println("Acionando o Botão 'Comprar'");
											
											/** Report Extent **/
											test.log(Status.PASS, "TAXA PASSIVA OK - Compra no Mercado");
											test.log(Status.PASS, "Acionando o Botão 'Comprar'");
											test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-TaxaPassivaOKMercado"));
											/** Report Extent **/
				
											} else {
												
												// Escrevendo no Console	
												System.out.println("Taxa PASSIVA NOK");
												
												/** Report Extent **/
												test.log(Status.ERROR, "TAXA PASSIVA NOK - Compra no Mercado");
												test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-TaxaPassivaNOKMercado"));
												/** Report Extent **/
												
											}
				
									} else {
				
										// Escrevendo no Console	
										System.out.println("Botao 'Comprar' Não Visivel ou nao Habilitado - Compra no Mercado");
										
										/** Report Extent **/
										test.log(Status.ERROR, "Botao 'Comprar' Não Visivel - Compra no Mercado");
										test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-BotaoComprarNaoVisivelMercado"));
										/** Report Extent **/
										
									}
									
								} else {
									
									// Escrevendo no Console	
									System.out.println("Comprar Bitcoin Não está Visível");

									/** Report Extent **/
									test.log(Status.ERROR, "Comprar Bitcoin Não está Visível");
									test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-ComprarBitcoinNaoVisivel"));
									/** Report Extent **/
									
								}
									
							} else {
								
								// Escrevendo no Console	
								System.out.println("Botao 'Opcao Avancada' Não Visivel ou nao Habilitado - Compra no Mercado");
								
								/** Report Extent **/
								test.log(Status.ERROR, "Botao 'Opcao Avancada' Não Visivel");
								test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-BotaoOpcaoAvancadaNaoVisivel"));
								/** Report Extent **/
								
							}
		
						} else { // Comprar Imediatamente
		
							if (IsElementEnabled("buy-quantidade") && IsElementPresent("buy-quantidade")) {
		
								// Procurando o Elemento e colocando em uma Lista
								List <WebElement> comprar_bitcoins = driver.findElements(By.id("buy-quantidade"));
		
								// Colocando o Elemento na variavel
								WebElement buy_quantidade = comprar_bitcoins.get(0);
		
								// Funcao HighLight
								HighLightElement(buy_quantidade);
		
								// Escrevendo no Console	
								System.out.println("Campo 'Insira quantos Bitcoins deseja comprar' - Visivel - Comprar Imediatamente");
		
								/** Report Extent **/
								test.log(Status.PASS, "Campo 'Insira a quantidade de Bitcoins que deseja comprar' - Visivel - Comprar Imediatamente");
								test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-EuQueroComprar"));
								/** Report Extent **/
								
							} else {
		
								// Escrevendo no Console	
								System.out.println("Campo 'Insira quantos Bitcoins deseja comprar' Não Visivel ou nao Editavel - Comprar Imediatamente");
								
								/** Report Extent **/
								test.log(Status.ERROR, "Campo 'Insira quantos Bitcoins deseja comprar' - Não Visivel - Comprar Imediatamente");
								test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-EuQueroComprar"));
								/** Report Extent **/
								
							}
		
							if (IsElementEnabled("valor-venda") && IsElementPresent("valor-venda")) {
		
								// Procurando o Elemento e colocando em uma Lista
								List <WebElement> comprar_reais = driver.findElements(By.id("valor-venda"));
		
								// Colocando o Elemento na variavel
								WebElement campo_comprar_reais = comprar_reais.get(0);
		
								// Funcao HighLight
								HighLightElement(campo_comprar_reais);
		
								// Inserindo o Valor para Comprar
								campo_comprar_reais.sendKeys(Dinheiro);
								Thread.sleep(2000);// esperar 2 segundo
								
								// Escrevendo no Console	
								System.out.println("Campo 'Insira quantos Reais deseja comprar em Bitcoins' - Visivel - Comprar Imediatamente");
								
								/** Report Extent **/
								test.log(Status.PASS, "Campo 'Insira quantos Reais deseja comprar em Bitcoins' - Visivel - Comprar Imediatamente");
								test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-EuQueroComprar"));
								/** Report Extent **/
		
							} else {
		
								// Escrevendo no Console	
								System.out.println("Campo 'Insira quantos Reais deseja comprar em Bitcoins' - Não Visivel - Comprar Imediatamente");
								
								/** Report Extent **/
								test.log(Status.ERROR, "Campo 'Insira quantos Reais deseja comprar em Bitcoins' - Não Visivel - Comprar Imediatamente");
								test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-EuQueroComprar"));
								/** Report Extent **/
								
							}
		
							if (IsElementEnabled("//button[@type='submit']") && IsElementPresent("//button[@type='submit']")) {
		
								// Escrevendo no Console	
								System.out.println("Botao 'Comprar' Visivel - Comprar Imediatamente");
								
								/** Report Extent **/
								test.log(Status.PASS, "Botao 'Comprar' Visivel - Comprar Imediatamente");
								test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-BotaoComprarVisivelImediatamente"));
								/** Report Extent **/
								
									/** Armazenando os valores as Taxas	 */
									// Procurando o Elemento e colocando em uma Lista
									List <WebElement> bitcoins_informado = driver.findElements(By.id("buy-quantidade"));
									
									// Buscar o elemento na pagina
									BitcoinInformado = bitcoins_informado.get(0).getAttribute("value");
									
									// Procurando o Elemento e colocando em uma Lista
									List <WebElement> dinheiro_informado = driver.findElements(By.id("valor-venda"));
									
									// Buscar o elemento na pagina
									DinheiroInformado = dinheiro_informado.get(0).getAttribute("value").substring(3);
									
									// Procurando o Elemento e colocando em uma Lista
									List <WebElement> valor_taxa = driver.findElements(By.xpath("//*[@id='valor-taxa']"));
			
									// Colocando o Elemento na variavel
									ValorTaxaServico = valor_taxa.get(0).getAttribute("value");
									ValorLiquido = valor_taxa.get(1).getAttribute("value");
			
									// Escrevendo no Console	
									System.out.println(BitcoinInformado); 
									System.out.println(DinheiroInformado); 
									System.out.println(ValorTaxaServico); 
									System.out.println(ValorLiquido);
									/** Armazenando os valores as Taxas */
								
								// Função que retorna a String OK ou NOK
								String ValidadorTaxa = Taxas.TaxasZater("Normal", "BTC", "Buy", "Ativa", BitcoinInformado, DinheiroInformado, ValorTaxaServico, ValorLiquido);
								String StatusTaxa = "OK";
								
								// Escrevendo no Console	
								System.out.println(ValidadorTaxa);	
								System.out.println(StatusTaxa);			
								
								if (ValidadorTaxa.equals(StatusTaxa)) {
									
									// Procurando o Elemento e colocando em uma Lista
									List <WebElement> botao_comprar = driver.findElements(By.xpath("//button[@type='submit']"));
			
									// Colocando o Elemento na variavel
									WebElement button_buy = botao_comprar.get(0);
			
									// Funcao HighLight
									HighLightElement(button_buy);
			
									// Clicar no Botao Comprar
									button_buy.click();
									Thread.sleep(2000);// esperar 2 segundo
									
									// Escrevendo no Console	
									System.out.println("Taxa ATIVA OK");
									System.out.println("Acionando o Botão 'Comprar'");
									
									/** Report Extent **/
									test.log(Status.PASS, "TAXA ATIVA OK - Comprar Imediatamente");
									test.log(Status.PASS, "Acionando o Botão 'Comprar'");
									test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar_Bitcoin-TaxaAtivaOKImediatamente"));
									/** Report Extent **/
																		
									} else {
										
										// Escrevendo no Console	
										System.out.println("Taxa ATIVA NOK");
										
										/** Report Extent **/
										test.log(Status.ERROR, "TAXA ATIVA NOK - Comprar Imediatamente");
										test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-TaxaAtivaNOKImediatamente"));
										/** Report Extent **/
										
									}
								
							} else {
		
								// Escrevendo no Console	
								System.out.println("Botao 'Comprar' Não Visivel ou nao Habilitado - Comprar Imediatamente");
		
								/** Report Extent **/
								test.log(Status.ERROR, "Botao 'Comprar' Não Visivel ou nao Habilitado - Comprar Imediatamente");
								test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-BotaoComprarNaoVisivelImediatamente"));
								/** Report Extent **/
								
							}
		
						}
						
					} else {
						
						// Escrevendo no Console	
						System.out.println("Moeda selecionada não é valida");
						
						/** Report Extent **/
						test.log(Status.ERROR, "Moeda selecionada não é valida");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-MoedaSelecionadaNaoValida"));
						/** Report Extent **/
						
					}
	
				} else {
	
					// Escrevendo no Console	
					System.out.println("Formulario de Comprar - Nao esta Visivel");
					
					/** Report Extent **/
					test.log(Status.ERROR, "Formulario de Comprar - Nao esta Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-FormularioComprarNaoVisivel"));
					/** Report Extent **/
	
				}
				
			} else {
				
				// Escrevendo no Console	
				System.out.println("Comprar Bitcoin Não está Visível");

				/** Report Extent **/
				test.log(Status.ERROR, "Comprar Bitcoin Não está Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-ComprarBitcoinNaoVisivel"));
				/** Report Extent **/
				
			}
			
		} else {

			// Escrevendo no Console	
			System.out.println("Saldo em Dinheiro não permitido: " + "Saldo Atual: " + ValorTotal + " " + "Minimo: " + ValorMinimoDinheiro);
			
			/** Report Extent **/
			test.log(Status.ERROR, "Comprar - Saldo Não Disponivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-ComprarSaldoNaoDisponivel"));
			/** Report Extent **/
			
		} 

	}
	
	@Ignore
	@Test
	public void STP09_000_Comprar_Litecoin_Mercado() throws Exception{
		
		// Variaveis
		String Dinheiro = new String("100000");
		String Bitcoin = new String("100000000");
		String BitcoinInformado;
		String DinheiroInformado;
		String ValorTaxaServico;
		String ValorLiquido;
		
		/** Report Extent **/
		test = extent.createTest("STP05_000_Comprar_Bitcoin_Mercado");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		// Buscar o elemento na pagina
		String Valor_Total = driver.findElement(By.xpath("/html/body/main/page-top/div/div[2]/div[3]/p[1]/strong")).getText().substring(4);
		String Moedas_Valor_Total = driver.findElement(By.xpath("/html/body/main/page-top/div/div[2]/div[3]/p[2]/strong")).getText().substring(4);
			
		// Escrevendo no Console
		System.out.println("Valor Total em Dinheiro: " + Valor_Total);
		System.out.println("Valor Total em Moedas: " + Moedas_Valor_Total);
		
		// Convertendo a String em Float
		float ValorTotal = Float.valueOf(Valor_Total.replace(".", "").replace(",","."));
		float MoedasValorTotal = Float.valueOf(Moedas_Valor_Total.replace(".", "").replace(",", "."));
		
		// Informando os valores Minimos
		float ValorMinimoDinheiro = (float) 0000.00;
		float ValorMinimoMoedas = (float) 0.00000000;

		// Escrevendo no Console	
		System.out.println("Valor Total em Dinheiro: " + ValorTotal);
		System.out.println("Valor Total em Moedas: " + MoedasValorTotal);       
		System.out.println("Saldo Minimo em Dinheiro: " + ValorMinimoDinheiro);
		System.out.println("Saldo Minimo em Moedas: " + ValorMinimoMoedas);

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

		if (ValorTotal >= ValorMinimoDinheiro ) {

			/** Report Extent **/
			test.log(Status.PASS, "Comprar - Saldo Disponivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Comprar_Bitcoin_Mercado-ComprarSaldoDisponivel"));
			/** Report Extent **/

			// Escrevendo no Console	
			System.out.println("Saldo igual ao Minimo: " + ValorTotal + " " + "Minimo: " + ValorMinimoDinheiro);			
			System.out.println("OU");			
			System.out.println("Saldo em Dinheiro: " + ValorTotal + " " + "Maior que o Minimo: " + ValorMinimoDinheiro);
				
			if (IsElementPresent("buy")) {

				// Escrevendo no Console	
				System.out.println("Formulario de Comprar esta Visivel");

				/** Report Extent **/
				test.log(Status.PASS, "Formulario de Comprar esta Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Comprar_Bitcoin_Mercado-FormularioComprarVisivel"));
				/** Report Extent **/			
				
				// Compra Mercado
				if (IsElementEnabled("//button[text()='Opções avançadas']") && IsElementPresent("//button[text()='Opções avançadas']")) {
				
					// Escrevendo no Console	
					System.out.println("Botao 'Opcao Avancada' Visivel");
					
					// Colocando o Elemento na variavel
					WebElement opcao_avancada = driver.findElement(By.xpath("//button[text()='Opções avançadas']"));
					
					// Funcao HighLight
					HighLightElement(opcao_avancada);
					
					// Clicar no Botao Comprar
					opcao_avancada.click();
					Thread.sleep(2000);// esperar 1 segundo
					
					/** Report Extent **/
					test.log(Status.PASS, "Botao 'Opcao Avancada' - Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Comprar_Bitcoin_Mercado-BotaoOpcaoAvancadaVisivel"));
					/** Report Extent **/
				
					// Buscar o elemento na página
					List<WebElement> ListMoeda = driver.findElements(By.name("selectCoin"));
					
					// Procurando o Elemento
					WebElement SelectCoin = ListMoeda.get(1);
					
					if(SelectCoin.getAttribute("textContent").contains("Bitcoin")) { 
									
						// Funcao HighLight
				        HighLightElement(SelectCoin);
				        
				        // Procurando o Elemento Select
				        Select Coin = new Select(SelectCoin);
				        
				        // Selecionando a Moeda
				        Coin.selectByValue("Bitcoin");
				        Thread.sleep(1000); // Espera 1 segundo
		
						// Escrevendo no Console	
						System.out.println("Moeda selecionada é valida");
						
						/** Report Extent **/
						test.log(Status.PASS, "Moeda selecionadaé valida");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Comprar_Bitcoin_Mercado-MoedaSelecionadaValida"));
						/** Report Extent **/	
							
						if (IsElementEnabled("buy-quantidade") && IsElementPresent("buy-quantidade")) {
	
							// Procurando o Elemento e colocando em uma Lista
							List <WebElement> comprar_bitcoins = driver.findElements(By.id("buy-quantidade"));
	
							// Colocando o Elemento na variavel
							WebElement buy_quantidade = comprar_bitcoins.get(1);
	
							// Funcao HighLight
							HighLightElement(buy_quantidade);
							
							// Inserindo o Valor para Comprar
							buy_quantidade.sendKeys(Bitcoin);
							Thread.sleep(2000);// esperar 1 segundo
	
							// Escrevendo no Console	
							System.out.println("Campo 'Insira a quantidade de Bitcoins que deseja comprar' - Visivel - Comprar no Mercado");
							
							/** Report Extent **/
							test.log(Status.PASS, "Campo 'Insira a quantidade de Bitcoins que deseja comprar' - Visivel - Comprar no Mercado");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Comprar_Bitcoin_Mercado-QuantidadeBTCVisivel"));
							/** Report Extent **/
							
						} else {
	
							// Escrevendo no Console	
							System.out.println("Campo 'Insira a quantidade de Bitcoins que deseja comprar' nao Visivel ou nao Editavel - Compra Mercado");
	
							/** Report Extent **/
							test.log(Status.ERROR, "Campo 'Insira a quantidade de Bitcoins que deseja comprar' - Não Visivel - Comprar no Mercado");
							test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Comprar_Bitcoin_Mercado-QuantidadeBTCNaoVisivel"));
							/** Report Extent **/
							
						}
						
						if (IsElementEnabled("valor-venda") && IsElementPresent("valor-venda")) {
	
							// Procurando o Elemento e colocando em uma Lista
							List <WebElement> comprar_reais = driver.findElements(By.id("valor-venda"));
	
							// Colocando o Elemento na variavel
							WebElement campo_comprar_reais = comprar_reais.get(1);
	
							// Funcao HighLight
							HighLightElement(campo_comprar_reais);
							
							// Inserindo o Valor para Comprar
							campo_comprar_reais.sendKeys(Dinheiro);
							Thread.sleep(2000);// esperar 1 segundo
	
							// Escrevendo no Console	
							System.out.println("Campo 'Insira o valor que deseja pagar pelo BTC Inteiro' Visivel - Comprar no Mercado");
	
							/** Report Extent **/
							test.log(Status.PASS, "Campo 'Insira o valor que deseja pagar pelo BTC Inteiro' Visivel - Comprar no Mercado");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Comprar_Bitcoin_Mercado-ValorBTCInteiroVisivel"));
							/** Report Extent **/
							
						} else {
	
							// Escrevendo no Console	
							System.out.println("Campo 'Insira quantos Reais deseja comprar em Bitcoins' Não Visivel ou nao Editavel - Compra Mercado");
							
							/** Report Extent **/
							test.log(Status.ERROR, "Campo 'Insira o valor que deseja pagar pelo BTC Inteiro' Não Visivel - Comprar no Mercado");
							test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Comprar_Bitcoin_Mercado-ValorBTCInteiroNaoVisivel"));
							/** Report Extent **/
							
						}	
																				
						if (IsElementEnabled("//button[@type='submit']") && IsElementPresent("//button[@type='submit']")) {
							
							// Escrevendo no Console	
							System.out.println("Botao 'Comprar' Visivel - Comprar Mercado");
							
							/** Report Extent **/
							test.log(Status.PASS, "Botao 'Comprar' Visivel - Comprar no Mercado");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Comprar_Bitcoin_Mercado-BotaoComprarVisivelMercado"));
							/** Report Extent **/
							
								/** Armazenando os valores as Taxas	 */
								// Procurando o Elemento e colocando em uma Lista
								List <WebElement> bitcoins_informado = driver.findElements(By.id("buy-quantidade"));
								
								// Buscar o elemento na pagina
								BitcoinInformado = bitcoins_informado.get(1).getAttribute("value");
								
								// Procurando o Elemento e colocando em uma Lista
								List <WebElement> dinheiro_informado = driver.findElements(By.id("valor-venda"));
								
								// Buscar o elemento na pagina
								DinheiroInformado = dinheiro_informado.get(1).getAttribute("value").substring(3);
								
								// Procurando o Elemento e colocando em uma Lista
								List <WebElement> valor_taxa = driver.findElements(By.xpath("//*[@id='valor-taxa']"));
		
								// Colocando o Elemento na variavel
								ValorTaxaServico = valor_taxa.get(2).getAttribute("value");
								ValorLiquido = valor_taxa.get(3).getAttribute("value");

								// Escrevendo no Console	
								System.out.println(BitcoinInformado); 
								System.out.println(DinheiroInformado); 
								System.out.println(ValorTaxaServico); 
								System.out.println(ValorLiquido);
								/** Armazenando os valores as Taxas */
							
							// Função que retorna a String OK ou NOK
							String ValidadorTaxa = Taxas.TaxasZater("Normal", "BTC", "Buy", "Passiva", BitcoinInformado, DinheiroInformado, ValorTaxaServico, ValorLiquido);
							String StatusTaxa = "OK";
							
							// Escrevendo no Console
							System.out.println(ValidadorTaxa);									
							System.out.println(StatusTaxa);
							
								if (ValidadorTaxa.equals(StatusTaxa)) {
								
								// Procurando o Elemento e colocando em uma Lista
								List <WebElement> botao_comprar = driver.findElements(By.xpath("//button[@type='submit']"));
		
								// Colocando o Elemento na variavel
								WebElement button_buy = botao_comprar.get(1);
		
								// Funcao HighLight
								HighLightElement(button_buy);
		
								// Clicar no Botao Comprar
								button_buy.click();
								Thread.sleep(2000);// esperar 1 segundo
								
								// Escrevendo no Console	
								System.out.println("Taxa PASSIVA OK");
								System.out.println("Acionando o Botão 'Comprar'");
								
								
								/** Report Extent **/
								test.log(Status.PASS, "TAXA PASSIVA OK - Compra no Mercado");
								test.log(Status.PASS, "Acionando o Botão 'Comprar'");
								test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Comprar_Bitcoin_Mercado-TaxaPassivaOKMercado"));
								/** Report Extent **/
								
								} else {
									
									// Escrevendo no Console	
									System.out.println("TAXA PASSIVA NOK");
									
									/** Report Extent **/
									test.log(Status.PASS, "TAXA PASSIVA NOK - Compra no Mercado");
									test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Comprar_Bitcoin_Mercado-TaxaPassivaNOKMercado"));
									/** Report Extent **/
									
								}
	
						} else {
	
							// Escrevendo no Console	
							System.out.println("Botao 'Comprar' Não Visivel ou nao Habilitado - Compra no Mercado");
	
							/** Report Extent **/
							test.log(Status.ERROR, "Botao 'Comprar' Não Visivel - Comprar no Mercado");
							test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Comprar_Bitcoin_Mercado-BotaoComprarNaoVisivelMercado"));
							/** Report Extent **/
							
						}
						
					} else {
						
						// Escrevendo no Console	
						System.out.println("Comprar Bitcoin Não está Visível");

						/** Report Extent **/
						test.log(Status.ERROR, "Comprar Bitcoin Não está Visível");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar_Bitcoin-ComprarBitcoinNaoVisivel"));
						/** Report Extent **/
						
					}
						
				} else {
					
					// Escrevendo no Console	
					System.out.println("Botao 'Opcao Avancada' Não Visivel ou nao Habilitado - Compra no Mercado");
					
					/** Report Extent **/
					test.log(Status.ERROR, "Botao 'Opcao Avancada' - Não Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Comprar_Bitcoin_Mercado-BotaoOpcaoAvancadaNaoVisivel"));
					/** Report Extent **/
					
				}

			} else {
				
				// Escrevendo no Console	
				System.out.println("Formulario de Comprar - Nao esta Visivel");
				
				/** Report Extent **/
				test.log(Status.ERROR, "Formulario de Comprar - Nao esta Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Comprar_Bitcoin_Mercado-FormularioComprarNaoVisivel"));
				/** Report Extent **/

			}
							
		} else {

			// Escrevendo no Console	
			System.out.println("Saldo em Dinheiro não permitido: " + "Saldo Atual: " + ValorTotal + " " + "Minimo: " + ValorMinimoDinheiro);
			
			/** Report Extent **/
			test.log(Status.ERROR, "Comprar - Saldo Não Disponivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Comprar_Bitcoin_Mercado-ComprarSaldoNaoDisponivel"));
			/** Report Extent **/
			
		} 

	}
	
	@Test
	public void STP10_000_CancelarOfertasCompra() throws Exception{

		/** Report Extent **/
		test = extent.createTest("STP06_000_CancelarOfertasCompra");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		if (IsElementPresent("buy")) {

			// Escrever no Console
			System.out.println("Ofertas de Compra - Visivel");

			// Buscar o elemento na página
			WebElement tabela = driver.findElement(By.xpath("//*[@id='buy']/buy-table/div/div/div/div/div/table"));

			// Funcao HighLight
			HighLightElement(tabela);
			
			/** Report Extent **/
			test.log(Status.PASS, "Ofertas de Compra - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP06_000_CancelarOfertasCompra-OfertasComprasVisivel"));
			/** Report Extent **/
					
			// Coloca o elemento em uma Lista
			List<WebElement> tr = tabela.findElements(By.cssSelector("tr"));
			//List<WebElement> td = tabela.findElements(By.cssSelector("td"));
			
			for (WebElement linha : tr) { // Verifica quantos Elementos foram encontrados

				// Escrevendo no Console
				//System.out.println("Linha" + linha.getText());
				//System.out.println("Linha Tamanho" + linha.getSize());
				
				if (linha.getText().contains("Aguardando") && linha.getText().contains("Cancelar")) { // Condição para o Status Melhorar

					// Funcao HighLight
					HighLightElement(linha);
					
					/** Report Extent **/
					test.log(Status.PASS, "Possui Ofertas para Cancelar");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP06_000_CancelarOfertasCompra-PossuiOfertasCancelar"));
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
				System.out.println("Não Possui Ofertas para Cancelar");
				
				/** Report Extent **/
				test.log(Status.INFO, "Não Possui Ofertas para Cancelar");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP06_000_CancelarOfertasCompra-NaoPossuiOfertasCancelar"));
				/** Report Extent **/
			}

		}
		
		
		} else {
			
			// Escrever no Console
			System.out.println("Ofertas de Compra - Visivel");
			
			/** Report Extent **/
			test.log(Status.ERROR, "Ofertas de Compra - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP06_000_CancelarOfertasCompra-OfertasComprasNaoVisivel"));
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
		test = extent.createTest("TCR02002_ZaterCapitalExchange_Fluxo_Comprar_Finalizar");
		test.assignCategory("Regressão");
		/** Report Extent **/
                
		/** Report Extent **/
		test.log(Status.PASS, "Browser Encerrado com Sucesso");
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","TCR02002_ZaterCapitalExchange_Fluxo_Comprar_Finalizar-EncerrarSiteComSucesso"));
		/** Report Extent **/
        
        // Encerra o Report
        extent.flush();

		// Fechar o Browser
		driver.quit();
		//driver.close();
		
	}


}
