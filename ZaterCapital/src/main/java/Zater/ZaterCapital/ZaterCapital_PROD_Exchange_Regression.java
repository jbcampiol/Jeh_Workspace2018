package Zater.ZaterCapital;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

//import ZaterUtilitarios.Dados_Linux;
//import ZaterUtilitarios.FuncoesReusaveis_Linux;
import ZaterUtilitarios.Dados_Windows;
import ZaterUtilitarios.FuncoesReusaveis_Windows;
import ZaterUtilitarios.Taxas;

public class ZaterCapital_PROD_Exchange_Regression extends FuncoesReusaveis_Windows {

	/*
	public static String URL;
	public static String User;
	public static String Password;
	public static String Sell_Book;
	public static String Buy_Book;
	*/
	
	public static void main(String[] args) throws Exception {   

		/** Console */
		/*
		// Chamando para ler o Console
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// Informando no Console a URL
		System.out.print("Digite a URL : ");    
		try {
			URL = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("URL Informada: " + URL + "\n");

		// Informando no Console o Usuário
		System.out.print("Digite o Usuário : ");    
		try {
			User = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("Usuário Informado : " + User + "\n");

		// Informando no Console a Senha
		System.out.print("Digite a Senha : ");    
		try {
			Password = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("Senha Informada : " + Password + "\n");

		// Informando no Console o Livro de Venda
		System.out.print("Digite o Valor para o Livro de Venda : ");    
		try {
			Sell_Book = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("Valor para o Livro de Venda Informado : " + Sell_Book + "\n");

		// Informando no Console o Livro de Compra
		System.out.print("Digite o Valor para o Livro de Compra : ");    
		try {
			Buy_Book = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("Valor para o Livro de Compra Informado : " + Buy_Book + "\n");
		*/
		/** Console */
		
	
		/** Iniciar */
		AbrirBrowser();
		STP01_000_LogarExchange();
		
		/** Dashboard */		
		STP02_000_Navegar_Dashboard();
		STP02_001_VerificarUltimaTransacao();

		/** Fluxo Configurações */
		STP03_000_Navegar_Configuracoes();
		STP03_001_Navegar_Configuracoes_Foto();
		STP03_002_Navegar_Configuracoes_Documentos();
		STP03_003_Navegar_Configuracoes_Dados_PessoaFisica();
		STP03_004_Navegar_Configuracoes_Dados_PessoaJuridica();
		
		/** Fluxo Minha Carteira */
		STP04_000_Navegar_Minha_Carteira();
			
		/** Fluxo Depositar */
		STP05_000_Navegar_Depositos();
		STP05_001_Depositos_Dinheiro();
		STP05_002_Confirmar_Depositos_Dinheiro();
		STP05_003_Validar_Tabela_Depositos();
		STP05_004_Incluir_Comprovante();
		STP05_005_Abrir_Comprovante();
			
		/** Fluxo Livro de Ofertas */
		STP06_000_Navegar_Livro_Ofertas();

		/** Fluxo Comprar */
		STP07_000_Navegar_Comprar();
		STP07_001_Comprar();
		STP07_002_Comprar_Mercado();
		STP07_003_CancelarOfertasCompra();

		/** Fluxo Vender */
		STP08_000_Navegar_Vender();
		STP08_001_Vender();
		STP08_002_Vender_Mercado();
		STP08_003_CancelarOfertasVenda();

		/** Fluxo Saque */
		STP09_000_Navegar_Saques();
		STP09_001_Saques_Dinheiro();
		STP09_002_Saques_Bitcoin();

		/** Fluxo Historico */
		STP10_000_Navegar_Historico();

		/** Fluxo Taxas e Prazos */
		STP11_000_Navegar_Taxas_Prazos();

		/** Fluxo Suporte */
		STP12_000_Navegar_Suporte();
		
		/** Fluxo Resetar Senha */
		//STP14_000_ResetarSenha();

		/** Finalizar */
		STP99_000_LogOutExchange();
		FecharBrowser();

	}


	/** Iniciar */

	@BeforeClass
	public static void AbrirBrowser() throws Exception {

		// Chamando o Browser
		InitBrowser("Chrome");

		/** Report Extent **/
		StartReport("ZaterCapital_PROD_Exchange_Regression_TestResult");	
		test = extent.createTest("STP00_AbrirBrowser");
		test.assignCategory("Regressão");
		/** Report Extent **/

		// Chamando o Site e configurando o Browser  
		//driver.navigate().to(Dados.Producao_Site_ZaterCapital);	// chamando o site
		driver.get(Dados_Windows.Producao_Site_ZaterCapital_Exchange);
		//driver.get(Dados_Windows.P_Site_ZaterCapital_Exchange);
		driver.manage().window().maximize(); // maximizando o browser
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // esperando por até 20 segundos

		// Pegando as URLs
		String url_site = driver.getCurrentUrl(); // URL atual
		String url_dados = Dados_Windows.Producao_Site_ZaterCapital_Exchange; // URL da class Dados

		/** Report Extent **/
		test.log(Status.INFO, "STP00_AbrirBrowser_Iniciar");
		test.log(Status.PASS, "Browser Carregado com Sucesso");	
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP00_AbrirBrowser-AbrirSiteComSucesso"));
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
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP00_AbrirBrowser-AbrirSiteComSucesso"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("Abrir o Browser - ERROR ao abrir Site da Exchange da Zater Capital");

			/** Report Extent **/
			test.log(Status.ERROR, "Abrir o Browser - ERROR ao abrir Site da Exchange da Zater Capital");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP00_AbrirBrowser-ErroAbrirSite"));
			/** Report Extent **/

		}

	}

	@Test
	public static void STP01_000_LogarExchange() throws Exception {
	
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
				Login.sendKeys(Dados_Windows.Producao_Exchange_Automacao1_EMAIL);
				//Login.sendKeys("teste@teste.com");
				Thread.sleep(1000); // Espera 1 segundo
				
				/** Report Extent **/
				test.log(Status.PASS, "LoginPage - Usuário Informado");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP01_000_LogarExchange-UsuarioInformado"));
				/** Report Extent **/

				// Escrevendo no Console
				System.out.println("LoginPage - Usuário Informado");
				System.out.println("Usuário: " + Dados_Windows.Producao_Exchange_Automacao1_EMAIL);
				
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
				Password.sendKeys(Dados_Windows.Producao_Exchange_Automacao1_Senha);   
				//Password.sendKeys("123456"); 
				Thread.sleep(1000); // Espera 1 segundo

				/** Report Extent **/
				test.log(Status.PASS, "LoginPage - Senha Informada");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP01_000_LogarExchange-SenhaInformada"));
				/** Report Extent **/
				
				// Escrevendo no Console
				System.out.println("LoginPage - Senha Informada");
				System.out.println("Senha: " + Dados_Windows.Producao_Exchange_Automacao1_Senha);

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
  
	
	/** Dashboard */
	
	@Test
	public static void STP02_000_Navegar_Dashboard() throws Exception {

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
	public static void STP02_001_VerificarUltimaTransacao()throws Exception{
		
		/** Report Extent **/
		test = extent.createTest("STP02_001_VerificarUltimaTransacao");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		//Buscando classe Json e passando url
    	String ReturnURL = Json(Dados_Windows.Producao_JSON);
    	
    	//Populando a variavel com o urq que contem Json 
    	System.out.println("Retorno da URL do JSon: " + ReturnURL);
    	
    	//Apontando aonde esta a substring "last" e atribuindo a variavel last 
    	String ReturnLast = ReturnURL.substring(ReturnURL.indexOf("\"" + "last" +  "\"" + ":"),ReturnURL.lastIndexOf("," + "\"" + "low" + "\""));
    	String LastJSon =  ReturnLast.substring(7);
    	
    	//Escrevendo no console  
    	System.out.println("Valor da Ultima Transação no JSON: " + LastJSon);
    	
    	//Atribuindo o xpath a lastweb 
    	String LastWeb = driver.findElement(By.xpath("/html/body/main/page-top/div/div[1]/p/strong")).getText().substring(2, 8).replace(".", "").replaceAll(",", ".");
    	//String LastWeb = driver.findElement(By.xpath("/html/body/main/page-top/div/div[1]/p/strong")).getText();
    	
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

	
	/** Fluxo Configurações */

	@Test
	public static void STP03_000_Navegar_Configuracoes() throws Exception {
		
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
	public static void STP03_001_Navegar_Configuracoes_Foto() throws Exception {
		
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
	public static void STP03_002_Navegar_Configuracoes_Documentos() throws Exception {
		
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
	public static void STP03_003_Navegar_Configuracoes_Dados_PessoaFisica() throws Exception {
		
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
				nome.sendKeys("Automação 2");
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
				sobrenome.sendKeys("Netlolo");
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
				nascimento.sendKeys("01012000");
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
				endereco.sendKeys("Av. Paulista, 2202");
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
				cidade.sendKeys("São Paulo");
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
				cep.sendKeys("01361000");
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
				celular.sendKeys("11987654321");
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
	public static void STP03_004_Navegar_Configuracoes_Dados_PessoaJuridica() throws Exception {
		
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
				razao_social.sendKeys("Barbieri Campiol LTDA");
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
				nome_fantasia.sendKeys("Exchange BITCOINS THE BEST - Zater Capital");
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
				
				//Clicar na Foto do Profile
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
				cep.sendKeys("001361000");
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
				ContactName.sendKeys("Zater Capital Contact Name (Netlolo) - 1");
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
				ContactEMail.sendKeys("jefferson.campiol@netlolo.com");
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
				Telefone.sendKeys("19992524666");
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
	

	/** Fluxo Minha Carteira */
	
	@Test
	public static void STP04_000_Navegar_Minha_Carteira() throws Exception {
		
		/** Report Extent **/
		test = extent.createTest("STP03_000_Navegar_Minha_Carteira");
		test.assignCategory("Regressão");
		/** Report Extent **/	
		
		if(IsElementPresent("//*[@class='al-sidebar-list-link ng-scope']")) {
			
			// Procurando os Menus e colocando em uma Lista
			List<WebElement> ProcurarMenu = driver.findElements(By.xpath("//*[@class='al-sidebar-list-link ng-scope']"));
			
			// Buscar o elemento na página
			WebElement MenuMinhaCarteira = ProcurarMenu.get(0);
			
	        // Funcao HighLight
			HighLightElement(MenuMinhaCarteira);
			
			//Clicar no Menu 'Minha Carteira'
			MenuMinhaCarteira.click();
			Thread.sleep(2000);// esperar 2 segundo
			
	        // Escrevendo no Console
	        System.out.println("MENU 'Minha Carteira' - Visível");
	        
			/** Report Extent **/
			test.log(Status.PASS, "MENU 'Minha Carteira' - Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Minha_Carteira-MENUMinhaCarteiraVisivel"));
			/** Report Extent **/
	       	
			if(driver.findElement(By.xpath("//*[@class='al-title ng-binding']")).getAttribute("innerText").contains("MINHA CARTEIRA") && IsElementPresent("mywallet")) {
						
				// Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("/html/body/main/div/div/content-top/div/h1")));
				
		        // Escrevendo no Console
		        System.out.println("'Minha Carteira' - Visível");
		        
				/** Report Extent **/
				test.log(Status.PASS, "'Minha Carteira' - Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Minha_Carteira-MinhaCarteiraVisivel"));
				/** Report Extent **/
				
				if(IsElementPresent("//*[@class='row my-wallet ng-scope']")) {
					
					// Funcao HighLight
					HighLightElement(driver.findElement(By.xpath("//*[@class='main-wallet grey-box']")));
					
					List<WebElement> ProcurarMoedas = driver.findElements(By.xpath("//*[@class='coins-list__item']"));
					
					// Buscar o elemento na página
					WebElement MoedaReal = ProcurarMoedas.get(0);
					WebElement MoedaBitcoin = ProcurarMoedas.get(1);
					WebElement MoedasLitecoin = ProcurarMoedas.get(2);
					WebElement MoedaDogecoin = ProcurarMoedas.get(3);
					
					// Funcao HighLight
					HighLightElement(MoedaReal);
					HighLightElement(MoedaBitcoin);
					HighLightElement(MoedasLitecoin);
					HighLightElement(MoedaDogecoin);
									
			        // Escrevendo no Console
			        System.out.println("'Cateiras e Moedas' - Visível");
			        
					/** Report Extent **/
					test.log(Status.PASS, "'Carteiras e Moedas' - Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Minha_Carteira-CarteirasEMoedasVisivel"));
					/** Report Extent **/
					
					
				} else {
					
			        // Escrevendo no Console
			        System.out.println("'Cateiras e Moedas' - Não Visível");
			        
					/** Report Extent **/
					test.log(Status.ERROR, "'Carteiras e Moedas' - Não Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Minha_Carteira-CarteirasEMoedasNaoVisivel"));
					/** Report Extent **/
					
				}
							
			} else {
				
		        // Escrevendo no Console
		        System.out.println("'Minha Carteira' - Não Visível");
		        
				/** Report Extent **/
				test.log(Status.ERROR, "'Minha Carteira' - Não Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Minha_Carteira-MinhaCarteiraNaoVisivel"));
				/** Report Extent **/
				
			}
			
		} else {
			
	        // Escrevendo no Console
	        System.out.println("MENU 'Minha Carteira' - Não Visível");
	        
			/** Report Extent **/
			test.log(Status.ERROR, "MENU 'Minha Carteira' - Não Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Minha_Carteira-MENUMinhaCarteiraNaoVisivel"));
			/** Report Extent **/
			
		}
		
	}
	
	
	/** Fluxo Depositar */

	@Test
	public static void STP05_000_Navegar_Depositos() throws Exception {
		
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
	public static void STP05_001_Depositos_Dinheiro() throws Exception {

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
	public static void STP05_002_Confirmar_Depositos_Dinheiro() throws Exception {

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
				
				if(SelecionarBancos.getAttribute("textContent").contains("Bradesco")) {
					
					// Selecionando o Banco
					Banco.selectByVisibleText("Bradesco");
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
	public static void STP05_003_Validar_Tabela_Depositos() throws Exception { 
		
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
	public static void STP05_004_Incluir_Comprovante() throws Exception { 
		
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
	public static void STP05_005_Abrir_Comprovante() throws Exception {	

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

	
	/** Fluxo Livro de Compra */
	
	@Test
	public static void STP06_000_Navegar_Livro_Ofertas() throws Exception {
		
		/** Report Extent **/
		test = extent.createTest("STP03_000_Navegar_Livro_Ofertas");
		test.assignCategory("Regressão");
		/** Report Extent **/	
		
		if(IsElementPresent("//*[@class='al-sidebar-list-link ng-scope']")) {
			
			// Procurando os Menus e colocando em uma Lista
			List<WebElement> ProcurarMenu = driver.findElements(By.xpath("//*[@class='al-sidebar-list-link ng-scope']"));
			
			// Buscar o elemento na página
			WebElement MenuLivroOfertas = ProcurarMenu.get(3);
	
	        // Funcao HighLight
			HighLightElement(MenuLivroOfertas);
			
			//Clicar no Menu 'Livro de Ofertas'
			MenuLivroOfertas.click();
			Thread.sleep(2000);// esperar 2 segundo
			
	        // Escrevendo no Console
	        System.out.println("MENU 'Livro de Ofertas' - Visível");
	        
			/** Report Extent **/
			test.log(Status.PASS, "MENU 'Livro de Ofertas' - Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Livro_Ofertas-MENULivroOfertasVisivel"));
			/** Report Extent **/
	       	
			if(IsElementPresent("book")) {
						
				// Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("/html/body/main/div/div/content-top/div/h1")));
				
		        // Escrevendo no Console
		        System.out.println("'Livro de Ofertas' - Visível");
		        
				/** Report Extent **/
				test.log(Status.PASS, "'Livro de Ofertas' - Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Livro_Ofertas-LivroOfertasVisivel"));
				/** Report Extent **/
				
				// Buscar o elemento na página
				List<WebElement> Ofertas = driver.findElements(By.xpath("//*[@class='panel-body']"));
				
				if(Ofertas.get(0).getAttribute("innerText").contains("Ofertas de Compra")) {
							
					// Buscar o elemento na página
					WebElement OfertasCompra = Ofertas.get(0);
					
					// Funcao HighLight
					HighLightElement(OfertasCompra);
					
			        // Escrevendo no Console
			        System.out.println("'Livro de Ofertas de Compra' - Visível");
			        
					/** Report Extent **/
					test.log(Status.PASS, "'Livro de Ofertas de Compra' - Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Livro_Ofertas-LivroOfertasCompraVisivel"));
					/** Report Extent **/
		
				} else {
					
			        // Escrevendo no Console
			        System.out.println("'Livro de Ofertas de Compra' - Não Visível");
			        
					/** Report Extent **/
					test.log(Status.ERROR, "'Livro de Ofertas de Compra' - Não Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Livro_Ofertas-LivroOfertasCompraNaoVisivel"));
					/** Report Extent **/
					
				}
				
				if(Ofertas.get(1).getAttribute("innerText").contains("Ofertas de Venda")) {
					
					// Buscar o elemento na página
					WebElement OfertasVenda = Ofertas.get(1);
					
					// Funcao HighLight
					HighLightElement(OfertasVenda);
					
			        // Escrevendo no Console
			        System.out.println("'Livro de Ofertas de Venda' - Visível");
			        
					/** Report Extent **/
					test.log(Status.PASS, "'Livro de Ofertas de Venda' - Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Livro_Ofertas-LivroOfertasVendaVisivel"));
					/** Report Extent **/
		
				} else {
					
			        // Escrevendo no Console
			        System.out.println("'Livro de Ofertas de Venda' - Não Visível");
			        
					/** Report Extent **/
					test.log(Status.ERROR, "'Livro de Ofertas de Venda' - Não Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Livro_Ofertas-LivroOfertasVendaNaoVisivel"));
					/** Report Extent **/
					
				}
							
			} else {
				
		        // Escrevendo no Console
		        System.out.println("'Livro de Ofertas' - Não Visível");
		        
				/** Report Extent **/
				test.log(Status.ERROR, "'Livro de Ofertas' - Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Livro_Ofertas-LivroOfertasNaoVisivel"));
				/** Report Extent **/
				
			}
			
		} else {
			
	        // Escrevendo no Console
	        System.out.println("MENU 'Livro de Ofertas' - Não Visível");
	        
			/** Report Extent **/
			test.log(Status.ERROR, "MENU 'Livro de Ofertas' - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Livro_Ofertas-MENULivroOfertasNaoVisivel"));
			/** Report Extent **/
			
		}
		
	}
	
	
	/** Fluxo Comprar */

	@Test
	public static void STP07_000_Navegar_Comprar() throws Exception {
		
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
	        	        			
	        if(IsElementPresent("buy")) {
	        	
		        // Funcao HighLight
		        HighLightElement(driver.findElement(By.xpath("/html/body/main/div/div/content-top/div/h1")));
		        HighLightElement(driver.findElement(By.xpath("//*[@id='buy']/buy-exchange/div/div/div/div/div[1]/h3")));
		        
				// Escrevendo no Console
				System.out.println("Assert: " + driver.findElement(By.xpath("/html/body/main/div/div/content-top/div/h1")).getText());
				System.out.println("Assert: " + driver.findElement(By.xpath("//*[@id='buy']/buy-exchange/div/div/div/div/div[1]/h3")).getText());
				System.out.println("Comprar - Visivel");
				
				/** Report Extent **/
				test.log(Status.PASS, "Comprar - Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Comprar-ComprarVisivel"));
				/** Report Extent **/
		        
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

	@Test
	public static void STP07_001_Comprar() throws Exception{
		
		String Dinheiro = new String("100000");
		String Bitcoin = new String("100000000");
		String BitcoinInformado;
		String DinheiroInformado;
		String ValorTaxaServico;
		String ValorLiquido;
		
		/** Report Extent **/
		test = extent.createTest("STP04_000_Comprar");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
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

		if (SaldoDinheiro >= ValorMinimoDinheiro ) {

			/** Report Extent **/
			test.log(Status.PASS, "Comprar - Saldo Disponivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar-ComprarSaldoDisponivel"));
			/** Report Extent **/

			// Escrevendo no Console	
			System.out.println("Saldo igual ao Minimo: " + SaldoDinheiro + " " + "Minimo: " + ValorMinimoDinheiro);			
			System.out.println("OU");			
			System.out.println("Saldo em Dinheiro: " + SaldoDinheiro + " " + "Maior que o Minimo: " + ValorMinimoDinheiro);

			if (IsElementPresent("buy")) {

				// Escrevendo no Console	
				System.out.println("Formulario de Comprar esta Visivel");

				/** Report Extent **/
				test.log(Status.PASS, "Formulario de Comprar esta Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar-FormularioComprarVisivel"));
				/** Report Extent **/

				if(driver.findElement(By.xpath("//*[@id='buy']/buy-exchange/div/div/div/div/div[3]")).getText().contains("Não existe ordem de venda no livro.")) {

					// Escrevendo no Console	
					System.out.println("Não existe ordem de venda no livro.");

					/** Report Extent **/
					test.log(Status.PASS, "Não existe ordem de venda no livro.");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar-NaoExiteOrdemDeVendaNoLivro"));
					/** Report Extent **/
					
					// Compra Mercado
					if (IsElementEnabled("//*[@id='buy']/buy-exchange/div/div/div/div/div[3]/form/fieldset/div[2]/a") && IsElementPresent("//*[@id='buy']/buy-exchange/div/div/div/div/div[3]/form/fieldset/div[2]/a")) {
					
						// Escrevendo no Console	
						System.out.println("Botao 'Opcao Avancada' Visivel");
						
						// Colocando o Elemento na variavel
						WebElement opcao_avancada = driver.findElement(By.xpath("//*[@id='buy']/buy-exchange/div/div/div/div/div[3]/form/fieldset/div[2]/a"));
						
						// Funcao HighLight
						HighLightElement(opcao_avancada);
						
						// Clicar no Botao Comprar
						opcao_avancada.click();
						Thread.sleep(2000);// esperar 1 segundo
						
						/** Report Extent **/
						test.log(Status.PASS, "Botao 'Opcao Avancada' Visivel");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar-BotaoOpcaoAvancadaVisivel"));
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
								test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar-QuantidadeBTCVisivel"));
								/** Report Extent **/
								
								// Escrevendo no Console	
								System.out.println("Campo 'Insira a quantidade de Bitcoins que deseja comprar' - Visivel - Compra no Mercado");
								
							} else {
		
								// Escrevendo no Console	
								System.out.println("Campo 'Insira quantos Bitcoins deseja comprar' nao Visivel ou nao Editavel - Compra no Mercado");
								
								/** Report Extent **/
								test.log(Status.ERROR, "Campo 'Insira a quantidade de Bitcoins que deseja comprar'- Não Visivel - Compra no Mercado");
								test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar-QuantidadeBTCNaoVisivel"));
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
								test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar-ValorBTCInteiroVisivel"));
								/** Report Extent **/
								
								// Escrevendo no Console	
								System.out.println("Campo 'Insira o valor que deseja pagar pelo BTC Inteiro' - Visivel - Compra no Mercado");
		
							} else {
		
								// Escrevendo no Console	
								System.out.println("Campo 'Insira o valor que deseja pagar pelo BTC Inteiro' - Não Visivel - Compra no Mercado");
								
								/** Report Extent **/
								test.log(Status.ERROR, "Campo 'Insira o valor que deseja pagar pelo BTC Inteiro' - Não Visivel - Compra no Mercado");
								test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar-ValorBTCInteiroNaoVisivel"));
								/** Report Extent **/
								
							}	
																					
							if (IsElementEnabled("//button[@type='submit']") && IsElementPresent("//button[@type='submit']")) {
								
								// Escrevendo no Console	
								System.out.println("Botao 'Comprar' Visivel - Compra no Mercado");
								
								/** Report Extent **/
								test.log(Status.PASS, "Botao 'Comprar' Visivel - Compra no Mercado");
								test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar-BotaoComprarVisivelMercado"));
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
									
									/** Report Extent **/
									test.log(Status.PASS, "TAXA PASSIVA OK - Compra no Mercado");
									test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar-TaxaPassivaOKMercado"));
									/** Report Extent **/
		
									} else {
										
										// Escrevendo no Console	
										System.out.println("Taxa PASSIVA NOK");
										
										/** Report Extent **/
										test.log(Status.ERROR, "TAXA PASSIVA NOK - Compra no Mercado");
										test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar-TaxaPassivaNOKMercado"));
										/** Report Extent **/
										
									}
		
							} else {
		
								// Escrevendo no Console	
								System.out.println("Botao 'Comprar' Não Visivel ou nao Habilitado - Compra no Mercado");
								
								/** Report Extent **/
								test.log(Status.ERROR, "Botao 'Comprar' Não Visivel - Compra no Mercado");
								test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar-BotaoComprarNaoVisivelMercado"));
								/** Report Extent **/
								
							}
							
					} else {
						
						// Escrevendo no Console	
						System.out.println("Botao 'Opcao Avancada' Não Visivel ou nao Habilitado - Compra no Mercado");
						
						/** Report Extent **/
						test.log(Status.ERROR, "Botao 'Opcao Avancada' Não Visivel");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar-BotaoOpcaoAvancadaNaoVisivel"));
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
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar-EuQueroComprar"));
						/** Report Extent **/
						
					} else {

						// Escrevendo no Console	
						System.out.println("Campo 'Insira quantos Bitcoins deseja comprar' Não Visivel ou nao Editavel - Comprar Imediatamente");
						
						/** Report Extent **/
						test.log(Status.ERROR, "Campo 'Insira quantos Bitcoins deseja comprar' - Não Visivel - Comprar Imediatamente");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar-EuQueroComprar"));
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
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar-EuQueroComprar"));
						/** Report Extent **/

					} else {

						// Escrevendo no Console	
						System.out.println("Campo 'Insira quantos Reais deseja comprar em Bitcoins' - Não Visivel - Comprar Imediatamente");
						
						/** Report Extent **/
						test.log(Status.ERROR, "Campo 'Insira quantos Reais deseja comprar em Bitcoins' - Não Visivel - Comprar Imediatamente");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar-EuQueroComprar"));
						/** Report Extent **/
						
					}

					if (IsElementEnabled("//button[@type='submit']") && IsElementPresent("//button[@type='submit']")) {

						// Escrevendo no Console	
						System.out.println("Botao 'Comprar' Visivel - Comprar Imediatamente");
						
						/** Report Extent **/
						test.log(Status.PASS, "Botao 'Comprar' Visivel - Comprar Imediatamente");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar-BotaoComprarVisivelImediatamente"));
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
							
							/** Report Extent **/
							test.log(Status.PASS, "TAXA ATIVA OK - Comprar Imediatamente");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_000_Comprar-TaxaAtivaOKImediatamente"));
							/** Report Extent **/
							
							
							} else {
								
								// Escrevendo no Console	
								System.out.println("Taxa ATIVA NOK");
								
								/** Report Extent **/
								test.log(Status.ERROR, "TAXA ATIVA NOK - Comprar Imediatamente");
								test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar-TaxaAtivaNOKImediatamente"));
								/** Report Extent **/
								
							}
						
					} else {

						// Escrevendo no Console	
						System.out.println("Botao 'Comprar' Não Visivel ou nao Habilitado - Comprar Imediatamente");

						/** Report Extent **/
						test.log(Status.ERROR, "Botao 'Comprar' Não Visivel ou nao Habilitado - Comprar Imediatamente");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar-BotaoComprarNaoVisivelImediatamente"));
						/** Report Extent **/
						
					}

				}

			} else {

				// Escrevendo no Console	
				System.out.println("Formulario de Comprar - Nao esta Visivel");
				
				/** Report Extent **/
				test.log(Status.ERROR, "Formulario de Comprar - Nao esta Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar-FormularioComprarNaoVisivel"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console	
			System.out.println("Saldo em Dinheiro nao permitido: " + "Saldo Atual: " + SaldoDinheiro + " " + "Minimo: " + ValorMinimoDinheiro);
			
			/** Report Extent **/
			test.log(Status.ERROR, "Comprar - Saldo Não Disponivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_000_Comprar-ComprarSaldoNaoDisponivel"));
			/** Report Extent **/
		} 

	}
	
	@Test
	public static void STP07_002_Comprar_Mercado() throws Exception{
		
		String Dinheiro = new String("100000");
		String Bitcoin = new String("100000000");
		String BitcoinInformado;
		String DinheiroInformado;
		String ValorTaxaServico;
		String ValorLiquido;
		
		/** Report Extent **/
		test = extent.createTest("STP05_000_Comprar_Mercado");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
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

		if (SaldoDinheiro >= ValorMinimoDinheiro) {

			/** Report Extent **/
			test.log(Status.PASS, "Comprar - Saldo Disponivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Comprar_Mercado-ComprarSaldoDisponivel"));
			/** Report Extent **/

			// Escrevendo no Console	
			System.out.println("Saldo igual ao Minimo: " + SaldoDinheiro + " " + "Minimo: " + ValorMinimoDinheiro);			
			System.out.println("OU");			
			System.out.println("Saldo em Dinheiro: " + SaldoDinheiro + " " + "Maior que o Minimo: " + ValorMinimoDinheiro);

			if (IsElementPresent("buy")) {

				// Escrevendo no Console	
				System.out.println("Formulario de Comprar esta Visivel");

				/** Report Extent **/
				test.log(Status.PASS, "Formulario de Comprar esta Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Comprar_Mercado-FormularioComprarVisivel"));
				/** Report Extent **/
				
					// Compra Mercado
					if (IsElementEnabled("//*[@id='buy']/buy-exchange/div/div/div/div/div[3]/form/fieldset/div[2]/a") && IsElementPresent("//*[@id='buy']/buy-exchange/div/div/div/div/div[3]/form/fieldset/div[2]/a")) {
					
						// Escrevendo no Console	
						System.out.println("Botao 'Opcao Avancada' Visivel");
						
						// Colocando o Elemento na variavel
						WebElement opcao_avancada = driver.findElement(By.xpath("//*[@id='buy']/buy-exchange/div/div/div/div/div[3]/form/fieldset/div[2]/a"));
						
						// Funcao HighLight
						HighLightElement(opcao_avancada);
						
						// Clicar no Botao Comprar
						opcao_avancada.click();
						Thread.sleep(2000);// esperar 1 segundo
						
						/** Report Extent **/
						test.log(Status.PASS, "Botao 'Opcao Avancada' - Visivel");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Comprar_Mercado-BotaoOpcaoAvancadaVisivel"));
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
								test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Comprar_Mercado-QuantidadeBTCVisivel"));
								/** Report Extent **/
								
							} else {
		
								// Escrevendo no Console	
								System.out.println("Campo 'Insira a quantidade de Bitcoins que deseja comprar' nao Visivel ou nao Editavel - Compra Mercado");
		
								/** Report Extent **/
								test.log(Status.ERROR, "Campo 'Insira a quantidade de Bitcoins que deseja comprar' - Não Visivel - Comprar no Mercado");
								test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Comprar_Mercado-QuantidadeBTCNaoVisivel"));
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
								test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Comprar_Mercado-ValorBTCInteiroVisivel"));
								/** Report Extent **/
								
							} else {
		
								// Escrevendo no Console	
								System.out.println("Campo 'Insira quantos Reais deseja comprar em Bitcoins' Não Visivel ou nao Editavel - Compra Mercado");
								
								/** Report Extent **/
								test.log(Status.ERROR, "Campo 'Insira o valor que deseja pagar pelo BTC Inteiro' Não Visivel - Comprar no Mercado");
								test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Comprar_Mercado-ValorBTCInteiroNaoVisivel"));
								/** Report Extent **/
								
							}	
																					
							if (IsElementEnabled("//button[@type='submit']") && IsElementPresent("//button[@type='submit']")) {
								
								// Escrevendo no Console	
								System.out.println("Botao 'Comprar' Visivel - Comprar Mercado");
								
								/** Report Extent **/
								test.log(Status.PASS, "Botao 'Comprar' Visivel - Comprar no Mercado");
								test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Comprar_Mercado-BotaoComprarVisivelMercado"));
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
									
									/** Report Extent **/
									test.log(Status.PASS, "TAXA PASSIVA OK - Compra no Mercado");
									test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Comprar_Mercado-TaxaPassivaOKMercado"));
									/** Report Extent **/
									
									} else {
										
										// Escrevendo no Console	
										System.out.println("TAXA PASSIVA NOK");
										
										/** Report Extent **/
										test.log(Status.PASS, "TAXA PASSIVA NOK - Compra no Mercado");
										test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_000_Comprar_Mercado-TaxaPassivaNOKMercado"));
										/** Report Extent **/
										
									}
		
							} else {
		
								// Escrevendo no Console	
								System.out.println("Botao 'Comprar' Não Visivel ou nao Habilitado - Compra no Mercado");
		
								/** Report Extent **/
								test.log(Status.ERROR, "Botao 'Comprar' Não Visivel - Comprar no Mercado");
								test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Comprar_Mercado-BotaoComprarNaoVisivelMercado"));
								/** Report Extent **/
								
							}
							
					} else {
						
						// Escrevendo no Console	
						System.out.println("Botao 'Opcao Avancada' Não Visivel ou nao Habilitado - Compra no Mercado");
						
						/** Report Extent **/
						test.log(Status.ERROR, "Botao 'Opcao Avancada' - Não Visivel");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Comprar_Mercado-BotaoOpcaoAvancadaNaoVisivel"));
						/** Report Extent **/
						
					}

			} else {

				// Escrevendo no Console	
				System.out.println("Formulario de Comprar - Nao esta Visivel");
				
				/** Report Extent **/
				test.log(Status.ERROR, "Formulario de Comprar - Nao esta Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Comprar_Mercado-FormularioComprarNaoVisivel"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console	
			System.out.println("Saldo em Dinheiro nao permitido: " + "Saldo Atual: " + SaldoDinheiro + " " + "Minimo: " + ValorMinimoDinheiro);
			
			/** Report Extent **/
			test.log(Status.ERROR, "Comprar - Saldo Não Disponivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_000_Comprar_Mercado-ComprarSaldoNaoDisponivel"));
			/** Report Extent **/
			
		} 

	}
	
	@Test
	public static void STP07_003_CancelarOfertasCompra() throws Exception{

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


	/** Fluxo Vender */

	@Test
	public static void STP08_000_Navegar_Vender() throws Exception {

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
	public static void STP08_001_Vender() throws Exception{

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
	public static void STP08_002_Vender_Mercado() throws Exception{

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
	public static void STP08_003_CancelarOfertasVenda() throws Exception{

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


	/** Fluxo Sacar */

	@Test
	public static void STP09_000_Navegar_Saques() throws Exception {

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
	public static void STP09_001_Saques_Dinheiro() throws Exception  {

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
	public static void STP09_002_Saques_Bitcoin() throws Exception {

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


	/** Fluxo Historico */

	@Test
	public static void STP10_000_Navegar_Historico() throws Exception {

		/** Report Extent **/
		test = extent.createTest("STP03_000_Navegar_Historico");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		if(IsElementPresent("//*[@class='al-sidebar-list-link ng-scope']")) {

			// Procurando os Menus e colocando em uma Lista
			List<WebElement> ProcurarMenu = driver.findElements(By.xpath("//*[@class='al-sidebar-list-link ng-scope']"));
			
			// Buscar o elemento na página
			WebElement MenuHistorico = ProcurarMenu.get(7);
			
			// Funcao HighLight
			HighLightElement(MenuHistorico);

			//Clicar no Menu Historico
			MenuHistorico.click();
			Thread.sleep(2000);// esperar 2 segundo
			
			// Escrevendo no Console
			System.out.println("MENU 'Historico' - Visivel");
			
	        /** Report Extent **/
			test.log(Status.PASS, "MENU 'Historico' - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Historico-MENUHistoricoVisivel"));
			/** Report Extent **/

			if(IsElementPresent("history")) {

				// Funcao HighLight
				HighLightElement(driver.findElement(By.xpath("/html/body/main/div/div/content-top/div/h1")));
				HighLightElement(driver.findElement(By.id("historyType")));
				
				// Escrevendo no Console
				System.out.println("Historico - Filtro - Visivel");
				
		        /** Report Extent **/
				test.log(Status.PASS, "Historico - Filtro - Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Historico-HistoricoFiltroVisivel"));
				/** Report Extent **/	
				
				if (IsElementSelected("historyType")) {
					
					// Procurando o Elemento
					WebElement FilterHistorico = driver.findElement(By.id("historyType"));
		
					// Funcao HighLight
			        HighLightElement(FilterHistorico);
			        
			        // Procurando o Elemento Select
			        Select HistoricoDeposit = new Select(FilterHistorico);
			        
			        // Selecionando o Estado
			        HistoricoDeposit.selectByValue("deposit");
			        Thread.sleep(2000); // Espera 2 segundo			
			        
					// Escrevendo no Console
					System.out.println("Historico 'Deposit' - Visivel");
					
			        /** Report Extent **/
					test.log(Status.PASS, "Historico 'Deposit' - Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Historico-HistoricoDepositVisivel"));
					/** Report Extent **/
			        
			        if(IsElementPresent("//*[@id='history']/div[2]/div/div/h3")) {
			        	
				        // Funcao HighLight
				        HighLightElement(driver.findElement(By.xpath("//*[@id='history']/div[2]/div/div/h3")));
				        
						// Escrevendo no Console
						System.out.println("Texto - Visivel");
						
				        /** Report Extent **/
						test.log(Status.PASS, "Texto - Visivel");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Historico-TextoVisivel"));
						/** Report Extent **/
			        	
			        } else {
			        	
						// Escrevendo no Console
						System.out.println("Texto - Não Visivel");
						
				        /** Report Extent **/
						test.log(Status.INFO, "Texto - Não Visivel");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Historico-TextoNãoVisivel"));
						/** Report Extent **/
			        	
			        }

				} else {
				
					// Escrevendo no Console
					System.out.println("Historico 'Deposit' - Não Visivel");
					
			        /** Report Extent **/
					test.log(Status.ERROR, "Historico 'Deposit' - Não Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Historico-HistoricoDepositNaoVisivel"));
					/** Report Extent **/
								
				}
				
				if (IsElementSelected("historyType")) {
					
					// Procurando o Elemento
					WebElement FilterHistorico = driver.findElement(By.id("historyType"));
		
					// Funcao HighLight
			        HighLightElement(FilterHistorico);
			        
			        // Procurando o Elemento Select
			        Select HistoricoWithdraw = new Select(FilterHistorico);
			        
			        // Selecionando o Estado
			        HistoricoWithdraw.selectByValue("withdraw");
			        Thread.sleep(2000); // Espera 2 segundo
			        
					// Escrevendo no Console
					System.out.println("Historico 'Withdraw' - Visivel");
					
			        /** Report Extent **/
					test.log(Status.PASS, "Historico 'Withdraw' - Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Historico-HistoricoWithdrawVisivel"));
					/** Report Extent **/
			        			        
			        if(IsElementPresent("//*[@id='history']/div[2]/div/div/h3")) {
			        	
				        // Funcao HighLight
				        HighLightElement(driver.findElement(By.xpath("//*[@id='history']/div[2]/div/div/h3")));
				        
						// Escrevendo no Console
						System.out.println("Texto - Visivel");
						
				        /** Report Extent **/
						test.log(Status.PASS, "Texto - Visivel");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Historico-TextoVisivel"));
						/** Report Extent **/
			        	
			        } else {
			        	
						// Escrevendo no Console
						System.out.println("Texto - Não Visivel");
						
				        /** Report Extent **/
						test.log(Status.INFO, "Texto - Não Visivel");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Historico-TextoNãoVisivel"));
						/** Report Extent **/
			        	
			        }

				} else {
				
					// Escrevendo no Console
					System.out.println("Historico 'Withdraw' - Não Visivel");
					
			        /** Report Extent **/
					test.log(Status.ERROR, "Historico 'Withdraw' - Não Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Historico-HistoricoWithdrawNaoVisivel"));
					/** Report Extent **/
								
				}
				
				if (IsElementSelected("historyType")) {
					
					// Procurando o Elemento
					WebElement FilterHistorico = driver.findElement(By.id("historyType"));
		
					// Funcao HighLight
			        HighLightElement(FilterHistorico);
			        
			        // Procurando o Elemento Select
			        Select HistoricoBuy = new Select(FilterHistorico);
			        
			        // Selecionando o Estado
			        HistoricoBuy.selectByValue("buy");
			        Thread.sleep(2000); // Espera 2 segundo
			        
					// Escrevendo no Console
					System.out.println("Historico 'Buy' - Visivel");
					
			        /** Report Extent **/
					test.log(Status.PASS, "Historico 'Buy' - Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Historico-HistoricoBuyVisivel"));
					/** Report Extent **/
			        			        
			        if(IsElementPresent("//*[@id='history']/div[2]/div/div/h3")) {
			        	
				        // Funcao HighLight
				        HighLightElement(driver.findElement(By.xpath("//*[@id='history']/div[2]/div/div/h3")));
				        
						// Escrevendo no Console
						System.out.println("Texto - Visivel");
						
				        /** Report Extent **/
						test.log(Status.PASS, "Texto - Visivel");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Historico-TextoVisivel"));
						/** Report Extent **/
			        	
			        } else {
			        	
						// Escrevendo no Console
						System.out.println("Texto - Não Visivel");
						
				        /** Report Extent **/
						test.log(Status.INFO, "Texto - Não Visivel");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Historico-TextoNãoVisivel"));
						/** Report Extent **/
			        	
			        }

				} else {
				
					// Escrevendo no Console
					System.out.println("Historico 'Buy' - Não Visivel");
					
			        /** Report Extent **/
					test.log(Status.ERROR, "Historico 'Buy' - Não Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Historico-HistoricoBuyNaoVisivel"));
					/** Report Extent **/
								
				}
				
				if (IsElementSelected("historyType")) {
					
					// Procurando o Elemento
					WebElement FilterHistorico = driver.findElement(By.id("historyType"));
		
					// Funcao HighLight
			        HighLightElement(FilterHistorico);
			        
			        // Procurando o Elemento Select
			        Select HistoricoSell = new Select(FilterHistorico);
			        
			        // Selecionando o Estado
			        HistoricoSell.selectByValue("sell");
			        Thread.sleep(2000); // Espera 2 segundo
			        
			        // Escrevendo no Console
					System.out.println("Historico 'Sell' - Visivel");
					
			        /** Report Extent **/
					test.log(Status.PASS, "Historico 'Sell' - Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Historico-HistoricoSellVisivel"));
					/** Report Extent **/
			        			        
			        if(IsElementPresent("//*[@id='history']/div[2]/div/div/h3")) {
			        	
				        // Funcao HighLight
				        HighLightElement(driver.findElement(By.xpath("//*[@id='history']/div[2]/div/div/h3")));
				        
						// Escrevendo no Console
						System.out.println("Texto - Visivel");
						
				        /** Report Extent **/
						test.log(Status.PASS, "Texto - Visivel");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Historico-TextoVisivel"));
						/** Report Extent **/
			        	
			        } else {
			        	
						// Escrevendo no Console
						System.out.println("Texto - Não Visivel");
						
				        /** Report Extent **/
						test.log(Status.INFO, "Texto - Não Visivel");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Historico-TextoNãoVisivel"));
						/** Report Extent **/
			        	
			        }

				} else {
				
					// Escrevendo no Console
					System.out.println("Historico 'Sell' - Não Visivel");
					
			        /** Report Extent **/
					test.log(Status.ERROR, "Historico 'Sell' - Não Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Historico-HistoricoSellNaoVisivel"));
					/** Report Extent **/
								
				}

			} else {

				// Escrevendo no Console
				System.out.println("Historico - Filtro - Não Visivel");
				
		        /** Report Extent **/
				test.log(Status.ERROR, "Historico - Filtro - Não Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Historico-HistoricoFiltroNaoVisivel"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console
			System.out.println("MENU 'Histórico' - Não Visivel");
			
	        /** Report Extent **/
			test.log(Status.ERROR, "MENU 'Historico' - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Historico-MENUHistoricoNaoVisivel"));
			/** Report Extent **/

		}

	}


	/** Fluxo Taxas e Prazos */

	@Test
	public static void STP11_000_Navegar_Taxas_Prazos() throws Exception {
		
		/** Report Extent **/
		test = extent.createTest("STP03_000_Navegar_Taxas_Prazos");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		if(IsElementPresent("//*[@class='al-sidebar-list-link ng-scope']")) {
			
			// Procurando os Menus e colocando em uma Lista
			List<WebElement> ProcurarMenu = driver.findElements(By.xpath("//*[@class='al-sidebar-list-link ng-scope']"));
			
			// Buscar o elemento na página
			WebElement MenuTaxasPrazos = ProcurarMenu.get(8);
			
	        // Funcao HighLight
			HighLightElement(MenuTaxasPrazos);
			
			//Clicar no Menu Taxas e Prazos
			MenuTaxasPrazos.click();
			Thread.sleep(2000);// esperar 2 segundo
	        
	        // Escrevendo no Console
	        System.out.println("MENU 'Taxas e Prazos' - Visivel");
			
	        /** Report Extent **/
			test.log(Status.PASS, "MENU 'Taxas e Prazos' - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Taxas_Prazos-MENUTaxasPrazosVisivel"));
			/** Report Extent **/
	                			
	        if(IsElementPresent("fee")) {
	        			        
		        // Funcao HighLight
		        HighLightElement(driver.findElement(By.xpath("/html/body/main/div/div/content-top/div/h1")));
		        
				// Escrevendo no Console
		        System.out.println("Taxas e Prazos - Visivel");
		        
		        /** Report Extent **/
				test.log(Status.PASS, "Taxas e Prazos - Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Taxas_Prazos-TaxasPrazosVisivel"));
				/** Report Extent **/
				
				// Procurando os Elementos e inserindo na Lista
				List<WebElement> ProcurarTables = driver.findElements(By.xpath("//*[@class='table-responsive ng-scope']"));
				
				if(driver.findElement(By.xpath("//*[@id='fee']/div/div/div/div/h2[1]")).getAttribute("innerText").contains("Taxas")) {
					
			        // Funcao HighLight
			        HighLightElement(driver.findElement(By.xpath("//*[@id='fee']/div/div/div/div/h2[1]")));
					
					// Buscar o elemento na página
					WebElement TableTaxas = ProcurarTables.get(0);
					
					// Funcao HighLight
			        HighLightElement(TableTaxas);
					
			        // Escrevendo no Console
			        System.out.println("Table Taxas - Visivel");
			        
			        /** Report Extent **/
					test.log(Status.PASS, "Table Taxas - Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Taxas_Prazos-TableTaxasVisivel"));
					/** Report Extent **/
					
				} else {
					
			        // Escrevendo no Console
			        System.out.println("Table Taxas - Não Visivel");
			        
			        /** Report Extent **/
					test.log(Status.ERROR, "Table Taxas - Não Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Taxas_Prazos-TableTaxasNaoVisivel"));
					/** Report Extent **/
					
				}
		        
				if(driver.findElement(By.xpath("//*[@id='fee']/div/div/div/div/h2[2]")).getAttribute("innerText").contains("Taxas Regressivas")) {
					
			        // Funcao HighLight
			        HighLightElement(driver.findElement(By.xpath("//*[@id='fee']/div/div/div/div/h2[2]")));
					
					// Buscar o elemento na página
					WebElement TableTaxasRegressivas = ProcurarTables.get(1);
					
					// Funcao HighLight
			        HighLightElement(TableTaxasRegressivas);
					
			        // Escrevendo no Console
			        System.out.println("Table Taxas Regressivas - Visivel");
			        
			        /** Report Extent **/
					test.log(Status.PASS, "Table Taxas Regressivas - Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Taxas_Prazos-TableTaxasRegressivasVisivel"));
					/** Report Extent **/
					
				} else {
					
			        // Escrevendo no Console
			        System.out.println("Table Taxas Regressivas - Não Visivel");
			        
			        /** Report Extent **/
					test.log(Status.ERROR, "Table Taxas Regressivas - Não Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Taxas_Prazos-TableTaxasRegressivasNaoVisivel"));
					/** Report Extent **/
					
				}
   
	        } else {
		        
		        // Escrevendo no Console
		        System.out.println("Taxas e Prazos - Não Visivel");
		        
		        /** Report Extent **/
				test.log(Status.ERROR, "Taxas e Prazos - Não Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Taxas_Prazos-TaxasPrazosNaoVisivel"));
				/** Report Extent **/
	        	
	        }
			
		} else {
	        
	        // Escrevendo no Console
	        System.out.println("MENU 'Taxas e Prazos' - Não Visivel");
	        
	        /** Report Extent **/
			test.log(Status.ERROR, "MENU 'Taxas e Prazos' - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Taxas_Prazos-MENUTaxasPrazosNaoVisivel"));
			/** Report Extent **/
	        
		}
		
	}
		

	/** Fluxo Suporte */

	@Test
	public static void STP12_000_Navegar_Suporte() throws Exception {
		
		/** Report Extent **/
		test = extent.createTest("STP03_000_Navegar_Suporte");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		if(IsElementPresent("//*[@class='al-sidebar-list-link ng-scope']")) {
			
			// Procurando os Menus e colocando em uma Lista
			List<WebElement> ProcurarMenu = driver.findElements(By.xpath("//*[@class='al-sidebar-list-link ng-scope']"));
			
			// Buscar o elemento na página
			WebElement MenuSuporte = ProcurarMenu.get(9);

	        // Funcao HighLight
			HighLightElement(MenuSuporte);
			
			//Clicar no Menu 'Suporte'
			MenuSuporte.click();
			Thread.sleep(2000);// esperar 2 segundo
	        
	        /** Report Extent **/
			test.log(Status.PASS, "MENU Suporte - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Suporte-MENUSuporteVisivel"));
			/** Report Extent **/
	        
	        // Escrevendo no Console
	        System.out.println("MENU Suporte - Visivel");
	        			
	        if(IsElementPresent("support")) {
	        	
	        	// Buscar o elemento na página
				WebElement SuporteTitulo = driver.findElement(By.xpath("/html/body/main/div/div/content-top/div/h1"));
	        	
				// Funcao HighLight
		        HighLightElement(SuporteTitulo);
				
				// Escrevendo no Console
		        System.out.println("Suporte - Visivel");
		        
		        /** Report Extent **/
				test.log(Status.PASS, "Taxas e Prazos - Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Suporte-SuporteVisivel"));
				/** Report Extent **/
				
				if(IsElementPresent("//*[@class='btn btn-primary ng-scope'][text()='Central de Ajuda']")) {
					
		        	// Buscar o elemento na página
					WebElement LinkCentralDeAujda = driver.findElement(By.linkText("Central de Ajuda"));
					WebElement ButtonCentralDeAujda = driver.findElement(By.xpath("//*[@class='btn btn-primary ng-scope'][text()='Central de Ajuda']"));
					
					// Funcao HighLight
			        HighLightElement(LinkCentralDeAujda);
			        HighLightElement(ButtonCentralDeAujda);
					
			        // Escrevendo no Console
			        System.out.println("'Central de Ajuda' - Visivel");
			        
			        /** Report Extent **/
					test.log(Status.PASS, "'Central de Ajuda'- Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_000_Navegar_Suporte-CentralDeAjudaVisivel"));
					/** Report Extent **/
					
				} else {
					
			        // Escrevendo no Console
			        System.out.println("'Central de Ajuda' - Não Visivel");
			        
			        /** Report Extent **/
					test.log(Status.ERROR, "'Central de Ajuda'- Não Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Suporte-CentralDeAjudaNaoVisivel"));
					/** Report Extent **/
					
				}
		        
	        } else {
		        
		        // Escrevendo no Console
		        System.out.println("Suporte - Não Visivel");
		        
		        /** Report Extent **/
				test.log(Status.ERROR, "Suporte- Não Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Suporte-SuporteNaoVisivel"));
				/** Report Extent **/
	        	
	        }
			
		} else {
	        
	        // Escrevendo no Console
	        System.out.println("MENU 'Suporte' - Não Visivel");
	        
	        /** Report Extent **/
			test.log(Status.ERROR, "MENU 'Suporte' - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_000_Navegar_Suporte-MENUSuporteNaoVisivel"));
			/** Report Extent **/
	        
		}
		
	}

	
	/** Fluxo Resetar Senha */
	
	@Ignore
	@Test
	public static void STP14_000_ResetarSenha() throws Exception{
		
		/** Report Extent **/
		test = extent.createTest("STP12_ResetarSenha");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		// Pegando as URLs
		String url_site = driver.getCurrentUrl(); // URL atual
		String url_dados = Dados_Windows.Homologacao_Site_ZaterCapital_Exchange; // URL da class Dados
		
		// Escrevendo no Console
		System.out.println(url_site);
		System.out.println(url_dados);
		
		if (url_site.equals(url_dados)) {
		
			// Escrevendo no Console
	        System.out.println("URL - Iguais");
			
			/** Report Extent **/
			test.log(Status.PASS, "URL - Iguais");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP12_ResetarSenha-URLIguais"));
			/** Report Extent **/
			
			if(IsElementPresent("esqueci-minha-senha")) {
						
				// Procurando o Elemento
				WebElement EsqueceuSenha =(driver.findElement(By.id("esqueci-minha-senha")));
				
				// Funcao HighLight
				HighLightElement(EsqueceuSenha);
				
				// Clicar no Botão 'Esqueci a senha'
				EsqueceuSenha.click();
				Thread.sleep(1000); // esperar 1 segundo
				
				// Escrevendo no Console
		        System.out.println("Esqueceu a senha - Visivel");
				
				/** Report Extent **/
				test.log(Status.PASS, "Esqueceu a senha - Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP12_ResetarSenha-EsquecerSenhaVisivel"));
				/** Report Extent **/
			
				if (IsElementPresent("email")) {
					
					// Procurando o Elemento
					WebElement email =(driver.findElement(By.id("email")));
					
					// Funcao HighLight
					HighLightElement(email);
					
					//Inserir o E-Mail
					email.sendKeys(Dados_Windows.Homologacao_Exchange_EMAIL_fake);
					Thread.sleep(1000); // esperar 1 segundo 
					
					// Escrevendo no Console
			        System.out.println("E-Mail - Informado");
					
					/** Report Extent **/
					test.log(Status.PASS, "E-Mail - Informado");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP12_ResetarSenha-EmailInformado"));
					/** Report Extent **/				
				
				}else {
					
					// Escrevendo no Console
			        System.out.println("E-Mail - Não Visivel");
					
					/** Report Extent **/
					test.log(Status.ERROR, "E-Mail - Não Visivel");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP12_ResetarSenha-EmailNaoVisivel"));
					/** Report Extent **/
					
				}
				
				if (IsElementPresent("//*[text()='Confirmar']")) {
					
					// Procurando o Elemento
					WebElement confirma =(driver.findElement(By.xpath("//*[text()='Confirmar']")));
					
					// Funcao HighLight
					HighLightElement(confirma);
					
					// Clicar no Botão 'Confirmar'
					confirma.click();
					Thread.sleep(1000); // esperar 1 segundo
					
					// Escrevendo no Console
			        System.out.println("E-Mail - Acionar o Botão 'Confirmar'");
					
					/** Report Extent **/
					test.log(Status.PASS, "E-Mail - Acionar o Botão 'Conformar'");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP12_ResetarSenha-BotaoConfirmar"));
					/** Report Extent **/	
					
				} else {
					
					// Escrevendo no Console
			        System.out.println("E-Mail - Acionar o Botão 'Confirmar' - Não Visível");
					
					/** Report Extent **/
					test.log(Status.ERROR, "E-Mail - Acionar o Botão 'Conformar' - Não Visível");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP12_ResetarSenha-BotaoConfirmarNaoVisivel"));
					/** Report Extent **/	
					
				}
				
				if (IsElementPresent("//button[@class='close']")) {
					
					// Procurando o Elemento
					WebElement CloseEsqueciSenha =(driver.findElement(By.xpath("//button[@class='close']")));
					
					// Funcao HighLight
					HighLightElement(CloseEsqueciSenha);
					
					// Cliar no Botão 'X'
					CloseEsqueciSenha.click();
					Thread.sleep(1000); // esperar 1 segundo
					
					// Escrevendo no Console
			        System.out.println("Fechar 'Esqueci a senha'");
					
					/** Report Extent **/
					test.log(Status.PASS, "Fechar 'Esqueci a senha'");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "STP12_ResetarSenha-FecharEsqueciSenha"));
					/** Report Extent **/			
					
				} else {
					
					// Escrevendo no Console
			        System.out.println("Fechar 'Esqueci a senha' - Não Visível");
					
					/** Report Extent **/
					test.log(Status.ERROR, "Fechar 'Esqueci a senha' - Não Visível");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP12_ResetarSenha-FecharEsqueciSenhaNaoVisivel"));
					/** Report Extent **/	
					
				}
										
			} else {
				
				// Escrevendo no Console
		        System.out.println("Esqueceu a senha - Não Visivel");
				
				/** Report Extent **/
				test.log(Status.ERROR, "Esqueceu a senha - Não Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP12_ResetarSenha-EsquecerSenhaNaoVisivel"));
				/** Report Extent **/
							
			}
		
		} else {
			
			// Escrevendo no Console
	        System.out.println("URL - Diferentes");
			
			/** Report Extent **/
			test.log(Status.ERROR, "URL - Iguais");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "STP12_ResetarSenha-URLDiferentes"));
			/** Report Extent **/
			
		}
			
	}

	
	/** Finalizar */	
	
	@Test
	public static void STP99_000_LogOutExchange() throws Exception {
		
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
		test = extent.createTest("ZaterCapital_PROD_Exchange_Regression_Finalizar");
		test.assignCategory("Regressão");
		/** Report Extent **/

		/** Report Extent **/
		test.log(Status.PASS, "Browser Encerrado com Sucesso");
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","ZaterCapital_PROD_Exchange_Regression_Finalizar-EncerrarSiteComSucesso"));
		/** Report Extent **/

		// Encerra o Report
		extent.flush();

		// Fechar o Browser
		driver.quit();
		//driver.close();

	}

}