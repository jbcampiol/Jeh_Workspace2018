package Regressao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
//import Utilitarios.Dados_Linux;
//import Utilitarios.FuncoesReusaveis_Linux;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TCR01_Navegacao_Site_ZaterCapital extends FuncoesReusaveis_Windows {
	
	@BeforeClass
	public static void AbrirBrowser() throws Exception {
	
		// Chamando o Browser
		InitBrowser("Chrome");
		
		/** Report Extent **/
		StartReport("TCR01_Navegacao_Site_ZaterCapital_TestResult");
		test = extent.createTest("TCR01_Navegacao_Site_ZaterCapital_Iniciar");
		test.assignCategory("Regressão");
		/** Report Extent **/
			
		// Chamando o Site e configurando o Browser  
		//driver.navigate().to(Dados.Producao_Site_ZaterCapital);	// chamando o site
		driver.get(Dados_Windows.Producao_Site_ZaterCapital);
		driver.manage().window().maximize(); // maximizando o browser
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // esperando por até 20 segundos
		
		// Pegando as URLs
		String url_site = driver.getCurrentUrl(); // URL atual
		String url_dados = Dados_Windows.Producao_Site_ZaterCapital; // URL da class Dados
		
		// Escrevendo no Console
		System.out.println(url_site);
		System.out.println(url_dados);
		
		/** Report Extent **/
		test.log(Status.INFO, "TCR01_Navegacao_Site_ZaterCapital_Iniciar");
		test.log(Status.PASS, "Browser Carregado com Sucesso");	
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","TCR01_Navegacao_Site_ZaterCapital_Iniciar-AbrirSiteComSucesso"));
		/** Report Extent **/
		
		// Assert para verificar se as URLs sao iguais
		//assertEquals(url_dados, url_site);
		
		if (url_site.equals(url_dados)) {	// || IsElementPresent("Zater Capital")
					
		// Escrevendo no Console
		System.out.println("Abrir o Browser - Abrir o Site da Zater Capital");
		
		/** Report Extent **/
		test.log(Status.PASS, "Abrir o Browser - Abrir o Site da Zater Capital");
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","TCR01_Navegacao_Site_ZaterCapital_Iniciar-AbrirSiteComSucesso"));
		/** Report Extent **/
		
		/** Report Extent **/
		StartReport("TCR01_Navegacao_Site_ZaterCapital_TestResult");
		test = extent.createTest("TCR01_Navegacao_Site_ZaterCapital_Iniciar");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		} else {
						
			// Escrevendo no Console
			System.out.println("Abrir o Browser - ERROR ao abrir Site da Zater Capital");
			
			/** Report Extent **/
			test.log(Status.ERROR, "Abrir o Browser - ERROR ao abrir Site da Zater Capital");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","TCR01_Navegacao_Site_ZaterCapital_Iniciar-ErroAbrirSite"));
			/** Report Extent **/
			
			/** Report Extent **/
			StartReport("TCR01_Navegacao_Site_ZaterCapital_TestResult");
			test = extent.createTest("TCR01_Navegacao_Site_ZaterCapital_Iniciar");
			test.assignCategory("Regressão");
			/** Report Extent **/
	
		}
		
	}
	
    @Test
	public void STP00_Json() throws Exception {

		/** Report Extent **/
		test = extent.createTest("STP00_Json");
		test.assignCategory("Regressão");
		/** Report Extent **/
    	
    	// Buscando classe Json e passando url
    	String ReturnURL = Json(Dados_Windows.Producao_JSON);

    	// Escrevendo no Console
    	System.out.println("Retorno real: " + ReturnURL);
    	
    	// Inserindo os valores do JSon nas variaveis
		String SubStringCompra = ReturnURL.substring(ReturnURL.indexOf("\"" + "buy" + "\"" + ":"),ReturnURL.lastIndexOf("," + "\"" + "fee" + "\""));
    	String buy =  SubStringCompra.substring(6);
    	  	
    	String SubStringVenda = ReturnURL.substring(ReturnURL.indexOf("\"" + "sell" + "\"" + ":"),ReturnURL.lastIndexOf("}"));
    	String sell =  SubStringVenda.substring(7);
    	
    	// Escrevendo no Console
    	System.out.println("Retorno BUY: " + buy);
    	System.out.println("Retorno SELL: " + sell);

    	// Especificando o local da string no json e formatando  
    	String seller = driver.findElement(By.xpath("//*[@id='sellTop']")).getText().substring(3,12).replace(".", "").replace(",", ".");	
    	String buyer  = driver.findElement(By.xpath("//*[@id='buyTop']")).getText().substring(3,12).replace(".", "").replace(",", ".");	
    	
    	// Escrevendo no Console
    	System.out.println("Buy: " + buyer);
    	System.out.println("Sell: " + seller);

    	// Igualando xpath com variavel 
    	if (seller.equals(sell))  {
    		
    		// Buscar o elemento na página
    		WebElement sellTop = driver.findElement(By.xpath("//*[@id='sellTop']"));
    		  		
    		// Usando a função Highlight
    		HighLightElement(sellTop);
    		
    		// Escrevendo no Console
    		System.out.println("Valor de venda igual ao livro");
    		
        	// Escrevendo no Console
        	System.out.println(seller);
    		   		
    		/** Report Extent **/
    		test.log(Status.PASS, "Valor de venda igual ao livro - Visivel");
    		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP00_Json-ValorVendaIgualLivro"));
    		/** Report Extent **/
    		
    		/** Report Extent **/
    		test = extent.createTest("STP00_Json");
    		test.assignCategory("Regressão");
    		/** Report Extent **/

    	} else {
    		
    		// Escrevendo no Console
    		System.out.println("Valor de venda não é igual ao livro");
    		
        	// Escrevendo no Console
        	System.out.println(seller);
    		   		
    		/** Report Extent **/
    		test.log(Status.ERROR, "Valor de venda não é igual ao livro - Não Visivel");
    		test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP00_Json-ValorVendaNaoIgualLivro"));
    		/** Report Extent **/
    		
    		/** Report Extent **/
    		test = extent.createTest("STP00_Json");
    		test.assignCategory("Regressão");
    		/** Report Extent **/
    		
    	}
    	
    	if (buyer.equals(buy)) {
    		
    		// Buscar o elemento na página
    		WebElement buyTop = driver.findElement(By.xpath("//*[@id='buyTop']"));
    		
    		// Usando a função Highlight
    		HighLightElement(buyTop);
    		
    		// Escrevendo no Console
    		System.out.println("Valor de compra igual ao livro");
    		
        	// Escrevendo no Console
        	System.out.println(buyer);
    		   		
    		/** Report Extent **/
    		test.log(Status.PASS, "Valor de compra igual ao livro - Visivel");
    		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP00_Json-ValorCompraIgualLivro"));
    		/** Report Extent **/
    		
    		/** Report Extent **/
    		test = extent.createTest("STP00_Json");
    		test.assignCategory("Regressão");
    		/** Report Extent **/
    		
    	} else {
    		
    		// Escrevendo no Console
    		System.out.println("Valor de compra não é igual ao livro");
    		
        	// Escrevendo no Console
        	System.out.println(buyer);
    		   		
    		/** Report Extent **/
    		test.log(Status.ERROR, "Valor de compra não é igual ao livro - Não Visivel");
    		test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP00_Json-ValorCompraNaoIgualLivro"));
    		/** Report Extent **/
    		
    		/** Report Extent **/
    		test = extent.createTest("STP00_Json");
    		test.assignCategory("Regressão");
    		/** Report Extent **/
    		
    	}
    }

	@Test
	public void STP01_Navegar_HOME() throws Exception {
		
		if (IsElementPresent("Zater Capital")) {// Verificando se o elemento é verdadeiro
	
			/** Report Extent **/
			test = extent.createTest("STP01_Navegar_HOME");
			test.assignCategory("Regressão");
			/** Report Extent **/
			
			// Buscar o elemento na página
			WebElement logo_home = driver.findElement(By.linkText("Zater Capital"));
			
			// Usando a função Highlight
			HighLightElement(logo_home);			
			
			/** Report Extent **/
			test.log(Status.PASS, "HOME - Logo Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP01_Navegar_HOME-LogoHomeVisivel"));
			/** Report Extent **/
						
			//Clicar no Logo da Home
			logo_home.click();
			Thread.sleep(2000);// esperar 1 segundo
			
			// Verifica o assert
			assertTrue("Zater Capital", true);
			assertEquals("Zater Capital", driver.findElement(By.xpath("//*[@id='home']/header/div[1]/div/div/div[1]/a")).getText());
			//assertEquals("O que você precisa?", driver.findElement(By.id("page-header-title")).getText());
			//assertTrue(driver.findElement(By.id("ht-posts-widget-plugin-2")).getText().contains("sobre a Netlolo"));
			
			// Escrevendo no Console
			System.out.println("Assert: " + driver.findElement(By.xpath("//*[@id='home']/header/div[1]/div/div/div[1]/a")).getText());
						
			// Escrevendo no Console
			System.out.println("HOME - Logo Visivel");
			
		} else {		
						
			// Escrevendo no Console
			System.out.println("HOME - Logo Nao Visivel");
			
			// Usando a função de Screenshot
			//TakeScreenshot("Erro", "TCR01_Navegacao_Site_ZaterCapital_STP01_Navegar_HOME-LogoHomeNaoVisivel");
			
			/** Report Extent **/
			test.log(Status.ERROR, "HOME - Logo Nao Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP01_Navegar_HOME-LogoNaoHomeVisivel"));
			/** Report Extent **/
			
			/** Report Extent **/
			test = extent.createTest("STP01_Navegar_HOME");
			test.assignCategory("Regressão");
			/** Report Extent **/

		}
		
	}
	
	@Test
	public void STP02_Navegar_SobreNos() throws Exception {
		
		if (IsElementPresent("Sobre Nós")) {// Verificando se o elemento é verdadeiro
	
			/** Report Extent **/
			test = extent.createTest("STP02_Navegar_SobreNos");
			test.assignCategory("Regressão");
			/** Report Extent **/
			
			// Buscar o elemento na página
			WebElement menu_sobre_nos = driver.findElement(By.linkText("Sobre Nós"));
			
			// Usando a função Highlight
			HighLightElement(menu_sobre_nos);
			
			//Clicar no Menu Sobre Nos
			menu_sobre_nos.click();
			Thread.sleep(2000);// esperar 1 segundo
			
			// Verifica se o Texto é verdadeiro
			assertTrue(driver.findElement(By.id("aboutUs")).getText().contains("A Zater Capital é uma empresa"));
			//assertTrue("ZaterX", true);
			//assertEquals("ZaterX", driver.findElement(By.xpath("//*[@id='banner']/div/div[2]/div[1]/div/div/div/div/div/h1")).getText());
			
			// Escrevendo no Console
			System.out.println("Assert: " + driver.findElement(By.id("aboutUs")).getText().contains("A Zater Capital é uma empresa"));
			System.out.println("Assert: " + driver.findElement(By.id("aboutUs")).getText());
			
			/** Report Extent **/
			test.log(Status.PASS, "Sobre Nós - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP02_Navegar_SobreNos-MenuSobreNosVisivel"));
			/** Report Extent **/
						
			// Escrevendo no Console
			System.out.println("Sobre Nós - Visivel");
			
		} else {		
						
			// Escrevendo no Console
			System.out.println("Sobre Nós - Nao Visivel");
			
			// Usando a função de Screenshot
			//TakeScreenshot("Erro", "TCR01_Navegacao_Site_ZaterCapital_STP02_Navegar_SobreNos-MenuSobreNosNaoVisivel");
			
			/** Report Extent **/
			test.log(Status.ERROR, "Sobre Nós - Nao Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP02_Navegar_SobreNos-MenuSobreNosNaoVisivel"));
			/** Report Extent **/

			/** Report Extent **/
			test = extent.createTest("STP02_Navegar_SobreNos");
			test.assignCategory("Regressão");
			/** Report Extent **/
		}
		
	}
	
	@Test
	public void STP03_Navegar_Vantagens() throws Exception {

		if (IsElementPresent("Vantagens")) {// Verificando se o elemento é verdadeiro
	
			// Buscar o elemento na página
			WebElement menu_vantagens = driver.findElement(By.linkText("Vantagens"));
			
			// Usando a função Highlight
			HighLightElement(menu_vantagens);
			
			//Clicar no Menu Vantagens
			menu_vantagens.click();
			Thread.sleep(2000);// esperar 1 segundo
			
			// Verifica se o Texto é verdadeiro
			assertTrue(driver.findElement(By.id("services")).getText().contains("Vantagens de comprar e vender conosco"));
			//assertTrue("ZaterX", true);
			//assertEquals("ZaterX", driver.findElement(By.xpath("//*[@id='banner']/div/div[2]/div[1]/div/div/div/div/div/h1")).getText());
			
			// Escrevendo no Console
			System.out.println("Assert: " + driver.findElement(By.id("services")).getText().contains("Vantagens de comprar e vender conosco"));
			System.out.println("Assert: " + driver.findElement(By.id("services")).getText());
					
			/** Report Extent **/
			test.log(Status.PASS, "Vantages - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP03_Navegar_Vantagens-MenuVantagensVisivel"));
			/** Report Extent **/
			
			// Escrevendo no Console
			System.out.println("Vantages - Visivel");
			

			/** Report Extent **/
			test = extent.createTest("STP03_Navegar_Vantagens");
			test.assignCategory("Regressão");
			/** Report Extent **/
			
			
		} else {		
						
			// Escrevendo no Console
			System.out.println("Vantages -  Nao Visivel");
			
			/** Report Extent **/
			test.log(Status.ERROR, "Vantages -  Nao Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP03_Navegar_Vantagens-MenuVantagensNaoVisivel"));
			/** Report Extent **/
			

			/** Report Extent **/
			test = extent.createTest("STP03_Navegar_Vantagens");
			test.assignCategory("Regressão");
			/** Report Extent **/

		}
		
	}
	
	@Test
	public void STP04_Navegar_APresidencia() throws Exception {

		if (IsElementPresent("A Presidência")) {// Verificando se o elemento é verdadeiro
	
			/** Report Extent **/
			test = extent.createTest("STP04_Navegar_APresidencia");
			test.assignCategory("Regressão");
			/** Report Extent **/
			
			// Buscar o elemento na página
			WebElement menu_presidencia = driver.findElement(By.linkText("A Presidência"));
			
			// Usando a função Highlight
			HighLightElement(menu_presidencia);
			
			//Clicar no Menu A Presidencia
			menu_presidencia.click();
			Thread.sleep(2000);// esperar 1 segundo
			
			// Verifica se o Texto é verdadeiro
			assertTrue(driver.findElement(By.id("ourPresident")).getText().contains("Fernando Zanatta"));
			//assertTrue("ZaterX", true);
			//assertEquals("ZaterX", driver.findElement(By.xpath("//*[@id='banner']/div/div[2]/div[1]/div/div/div/div/div/h1")).getText());
			
			// Escrevendo no Console
			System.out.println("Assert: " + driver.findElement(By.id("ourPresident")).getText().contains("Fernando Zanatta"));
			System.out.println("Assert: " + driver.findElement(By.id("ourPresident")).getText());
			
			/** Report Extent **/
			test.log(Status.PASS, "A APresidencia - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP04_Navegar_APresidencia-MenuAPresidenciaVisivel"));
			/** Report Extent **/
						
			// Escrevendo no Console
			System.out.println("A Presidencia - Visivel");
			
		} else {		
						
			// Escrevendo no Console
			System.out.println("A Presidencia - Nao Visivel");
			
			/** Report Extent **/
			test.log(Status.ERROR, "A Presidencia - Nao Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP04_Navegar_APresidencia-MenuAPresidenciaNaoVisivel"));
			/** Report Extent **/
			
			/** Report Extent **/
			test = extent.createTest("STP04_Navegar_APresidencia");
			test.assignCategory("Regressão");
			/** Report Extent **/

		}
		
	}
	
	@Test
	public void STP05_Navegar_Bitcoin() throws Exception {

		if (IsElementPresent("O que é Bitcoin?")) {// Verificando se o elemento é verdadeiro
	
			/** Report Extent **/
			test = extent.createTest("STP05_Navegar_Bitcoin");
			test.assignCategory("Regressão");
			/** Report Extent **/
			
			// Buscar o elemento na página
			WebElement menu_bitcoin = driver.findElement(By.linkText("O que é Bitcoin?"));
			
			// Usando a função Highlight
			HighLightElement(menu_bitcoin);
			
			//Clicar no Menu Bitcoin
			menu_bitcoin.click();
			Thread.sleep(2000);// esperar 1 segundo
			
			// Verifica se o Texto é verdadeiro
			assertTrue(driver.findElement(By.id("bitcoinBlock")).getText().contains("Como comprar Bitcoins?"));
			//assertTrue("ZaterX", true);
			//assertEquals("ZaterX", driver.findElement(By.xpath("//*[@id='banner']/div/div[2]/div[1]/div/div/div/div/div/h1")).getText());
			
			// Escrevendo no Console
			System.out.println("Assert: " + driver.findElement(By.id("bitcoinBlock")).getText().contains("Como comprar Bitcoins?"));
			System.out.println("Assert: " + driver.findElement(By.id("bitcoinBlock")).getText());
			
			/** Report Extent **/
			test.log(Status.PASS, "O que é Bitcoin? - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP05_Navegar_Bitcoin-MenuBitcoinVisivel"));
			/** Report Extent **/
						
			// Escrevendo no Console
			System.out.println("O que é Bitcoin? - Visivel");
			
		} else {		
						
			// Escrevendo no Console
			System.out.println("O que é Bitcoin? - Visivel");
			
			/** Report Extent **/
			test.log(Status.ERROR, "O que é Bitcoin? - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP05_Navegar_Bitcoin-MenuBitcoinNaoVisivel"));
			/** Report Extent **/
			
			/** Report Extent **/
			test = extent.createTest("STP05_Navegar_Bitcoin");
			test.assignCategory("Regressão");
			/** Report Extent **/

		}
		
	}
	
	@Test	
	public void STP06_Navegar_Bitcoin_VoceSabe() throws Exception {

		if (IsElementPresent("//*[text()='Mais detalhes']")) {

			/** Report Extent **/
			test = extent.createTest("STP06_Navegar_Bitcoin_VoceSabe");
			test.assignCategory("Regressão");
			/** Report Extent **/
			
			// Buscar o elemento e inserindo na Lista na página
			List<WebElement> MaisDetalhes = driver.findElements(By.xpath("//*[text()='Mais detalhes']"));			
			
			// Buscar o elemento na página
			WebElement VoceSabe = MaisDetalhes.get(0);
			
			// Usando a função Highlight
			HighLightElement(VoceSabe);
			
			//Clicar no Menu Bitcoin
			VoceSabe.click();
			Thread.sleep(2000); // esperar 2 segundo
			
			// Escrevendo no Console
			System.out.println("Você sabe o que é Bitcoin? - Visivel");

			/** Report Extent **/
			test.log(Status.PASS, "Voce Sabe o que é BTC - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP06_Navegar_Bitcoin_VoceSabe-VoceSabeBitcoin"));
			/** Report Extent **/			
					
			if (IsElementPresent("Zater Capital")) {// Verificando se o elemento é verdadeiro			// Buscar o elemento na página
				
				// Buscar o elemento na página
				WebElement bitcoin = driver.findElement(By.linkText("Voltar"));
				
				// Usando a função Highlight
				HighLightElement(bitcoin);
				
				// Usando a função Highlight
				HighLightElement(driver.findElement(By.xpath("/html/body/section[2]/div")));
				
				//Clicar no Menu Bitcoin
				bitcoin.click();
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Voltar 'O que é Bitcoin?' - Visivel");

				/** Report Extent **/
				test.log(Status.PASS, "O que é Bitcoin? - Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP06_Navegar_Bitcoin_VoceSabe-VoltarOQueEBitcoinNaoVisivel"));
				/** Report Extent **/
			
				/** Report Extent **/
				test = extent.createTest("STP06_Navegar_Bitcoin_VoceSabe");
				test.assignCategory("Regressão");
				/** Report Extent **/
				

			} else {
				
				// Escrevendo no Console
				System.out.println("Voltar 'O que é Bitcoin?' - Não Visivel");

				/** Report Extent **/
				test.log(Status.ERROR, "O que é Bitcoin? - Não Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP06_Navegar_Bitcoin_VoceSabe-VoltarOQueEBitcoinNaoVisivel"));
				/** Report Extent **/

				/** Report Extent **/
				test = extent.createTest("STP06_Navegar_Bitcoin_VoceSabe");
				test.assignCategory("Regressão");
				/** Report Extent **/
				
			}
					
		} else {		
						
			// Escrevendo no Console
			System.out.println("Você sabe o que é Bitcoin? - Não Visivel");

			/** Report Extent **/
			test.log(Status.ERROR, "Voce Sabe o que é Bitcoin - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP06_Navegar_Bitcoin_VoceSabe-VoceSabeBitcoinNaoVisivel"));
			/** Report Extent **/

			/** Report Extent **/
			test = extent.createTest("STP06_Navegar_Bitcoin_VoceSabe");
			test.assignCategory("Regressão");
			/** Report Extent **/
			

		}
		
	}
	
	@Test
	public void STP07_Navegar_Bitcoin_ComoCompraBitcoin() throws Exception  {
		
		if (IsElementPresent("//*[text()='Mais detalhes']")) { 
	
			// Buscar o elemento e inserindo na Lista na página
			List<WebElement> MaisDetalhes = driver.findElements(By.xpath("//*[text()='Mais detalhes']"));			
			
			// Buscar o elemento na página
			WebElement ComoComprar = MaisDetalhes.get(1);
			
			// Usando a função Highlight
			HighLightElement(ComoComprar);
			
			//Clicar no Menu Bitcoin
			ComoComprar.click();
			Thread.sleep(2000); // esperar 2 segundo
			
			// Escrevendo no Console
			System.out.println("Como Comprar Bitcoin? - Visivel");

			/** Report Extent **/
			test.log(Status.PASS, "Como Comprar Bitcoin? - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP07_Navegar_Bitcoin_ComoCompraBitcoin-ComoComprarBitcoin"));
			/** Report Extent **/
			
			/** Report Extent **/
			test = extent.createTest("STP07_Navegar_Bitcoin_ComoCompraBitcoin");
			test.assignCategory("Regressão");
			/** Report Extent **/
					
			if (IsElementPresent("Zater Capital")) {
				
				// Buscar o elemento na página
				WebElement bitcoin = driver.findElement(By.linkText("Voltar"));
				
				// Usando a função Highlight
				HighLightElement(bitcoin);
				
				// Usando a função Highlight
				HighLightElement(driver.findElement(By.xpath("/html/body/section[2]/div")));
				
				//Clicar no Menu Bitcoin
				bitcoin.click();
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Voltar 'O que é Bitcoin?' - Visivel");

				/** Report Extent **/
				test.log(Status.PASS, "O que é Bitcoin? - Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP07_Navegar_Bitcoin_ComoCompraBitcoin-VoltarOQueEBitcoinNaoVisivel"));
				/** Report Extent **/
				
				/** Report Extent **/
				test = extent.createTest("STP07_Navegar_Bitcoin_ComoCompraBitcoin");
				test.assignCategory("Regressão");
				/** Report Extent **/

			} else {
				
				// Escrevendo no Console
				System.out.println("Voltar 'O que é Bitcoin?' - Não Visivel");

				/** Report Extent **/
				test.log(Status.ERROR, "O que é Bitcoin? - Não Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP07_Navegar_Bitcoin_ComoCompraBitcoin-VoltarOQueEBitcoinNaoVisivel"));
				/** Report Extent **/
				
				/** Report Extent **/
				test = extent.createTest("STP07_Navegar_Bitcoin_ComoCompraBitcoin");
				test.assignCategory("Regressão");
				/** Report Extent **/
				
			}
					
		} else {		
						
			// Escrevendo no Console
			System.out.println("Como Comprar Bitcoin? - Não Visivel");

			/** Report Extent **/
			test.log(Status.PASS, "Como Comprar Bitcoin? - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP07_Navegar_Bitcoin_ComoCompraBitcoin-ComoComprarBitcoinNaoVisivel"));
			/** Report Extent **/	
			
			/** Report Extent **/
			test = extent.createTest("STP07_Navegar_Bitcoin_ComoCompraBitcoin");
			test.assignCategory("Regressão");
			/** Report Extent **/

		}
		
	}

	@Test	
	public void STP08_Navegar_Bitcoin_ComoVenderBitcoin() throws Exception {
		
		if (IsElementPresent("//*[text()='Mais detalhes']")) { 
	
			// Buscar o elemento e inserindo na Lista na página
			List<WebElement> MaisDetalhes = driver.findElements(By.xpath("//*[text()='Mais detalhes']"));			
			
			// Buscar o elemento na página
			WebElement ComoVender = MaisDetalhes.get(2);
			
			// Usando a função Highlight
			HighLightElement(ComoVender);
			
			//Clicar no Menu Bitcoin
			ComoVender.click();
			Thread.sleep(2000); // esperar 2 segundo
			
			// Escrevendo no Console
			System.out.println("Como Vender Bitcoin? - Visivel");

			/** Report Extent **/
			test.log(Status.PASS, "Como Comprar Bitcoin? - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP08_Navegar_Bitcoin_ComoVenderBitcoin-ComoVenderBitcoin"));
			/** Report Extent **/	

			/** Report Extent **/
			test = extent.createTest("STP08_Navegar_Bitcoin_ComoVenderBitcoin");
			test.assignCategory("Regressão");
			/** Report Extent **/
					
			if (IsElementPresent("Zater Capital")) {
				
				// Buscar o elemento na página
				WebElement bitcoin = driver.findElement(By.linkText("Voltar"));
				
				// Usando a função Highlight
				HighLightElement(bitcoin);
				
				// Usando a função Highlight
				HighLightElement(driver.findElement(By.xpath("/html/body/section[2]/div")));
				
				//Clicar no Menu Bitcoin
				bitcoin.click();
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Voltar 'O que é Bitcoin?' - Visivel");

				/** Report Extent **/
				test.log(Status.PASS, "O que é Bitcoin? - Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP08_Navegar_Bitcoin_ComoVenderBitcoin-VoltarOQueEBitcoinNaoVisivel"));
				/** Report Extent **/

				/** Report Extent **/
				test = extent.createTest("STP08_Navegar_Bitcoin_ComoVenderBitcoin");
				test.assignCategory("Regressão");
				/** Report Extent **/

			} else {
				
				// Escrevendo no Console
				System.out.println("Voltar 'O que é Bitcoin?' - Não Visivel");

				/** Report Extent **/
				test.log(Status.ERROR, "O que é Bitcoin? - Não Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP08_Navegar_Bitcoin_ComoVenderBitcoin-VoltarOQueEBitcoinNaoVisivel"));
				/** Report Extent **/
				
				/** Report Extent **/
				test = extent.createTest("STP08_Navegar_Bitcoin_ComoVenderBitcoin");
				test.assignCategory("Regressão");
				/** Report Extent **/
			}
					
		} else {		
						
			// Escrevendo no Console
			System.out.println("Como Vender Bitcoin? - Não Visivel");

			/** Report Extent **/
			test.log(Status.ERROR, "Como Comprar Bitcoin? - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP08_Navegar_Bitcoin_ComoVenderBitcoin-ComoVenderBitcoinNaoVisivel"));
			/** Report Extent **/	

			/** Report Extent **/
			test = extent.createTest("STP08_Navegar_Bitcoin_ComoVenderBitcoin");
			test.assignCategory("Regressão");
			/** Report Extent **/

		}
		
	}

	@Test
	public void STP09_Navegar_Bitcoin_ValeInvestir() throws Exception {
		
		if (IsElementPresent("//*[text()='Mais detalhes']")) { 
	
			// Buscar o elemento e inserindo na Lista na página
			List<WebElement> MaisDetalhes = driver.findElements(By.xpath("//*[text()='Mais detalhes']"));			
			
			// Buscar o elemento na página
			WebElement ValePena = MaisDetalhes.get(3);
			
			// Usando a função Highlight
			HighLightElement(ValePena);
			
			//Clicar no Menu Bitcoin
			ValePena.click();
			Thread.sleep(2000); // esperar 2 segundo
			
			// Escrevendo no Console
			System.out.println("Vale a penas Investir em Bitcoins? - Visivel");

			/** Report Extent **/
			test.log(Status.PASS, "Vale a penas Investir em Bitcoins? - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP09_Navegar_Bitcoin_ValeInvestir-ValePenaInvestirBitcoin"));
			/** Report Extent **/			
					
			/** Report Extent **/
			test = extent.createTest("STP09_Navegar_Bitcoin_ValeInvestir");
			test.assignCategory("Regressão");
			/** Report Extent **/
			if (IsElementPresent("Zater Capital")) {
				
				// Buscar o elemento na página
				WebElement bitcoin = driver.findElement(By.linkText("Voltar"));
				
				// Usando a função Highlight
				HighLightElement(bitcoin);
				
				// Usando a função Highlight
				HighLightElement(driver.findElement(By.xpath("/html/body/section[2]/div")));
				
				//Clicar no Menu Bitcoin
				bitcoin.click();
				Thread.sleep(2000);// esperar 2 segundo
				
				// Escrevendo no Console
				System.out.println("Voltar 'O que é Bitcoin?' - Visivel");

				/** Report Extent **/
				test.log(Status.PASS, "O que é Bitcoin? - Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP09_Navegar_Bitcoin_ValeInvestir-VoltarOQueEBitcoinNaoVisivel"));
				/** Report Extent **/
				
				/** Report Extent **/
				test = extent.createTest("STP09_Navegar_Bitcoin_ValeInvestir");
				test.assignCategory("Regressão");
				/** Report Extent **/

			} else {
				
				// Escrevendo no Console
				System.out.println("Voltar 'O que é Bitcoin?' - Não Visivel");

				/** Report Extent **/
				test.log(Status.ERROR, "O que é Bitcoin? - Não Visivel");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP09_Navegar_Bitcoin_ValeInvestir-VoltarOQueEBitcoinNaoVisivel"));
				/** Report Extent **/

				/** Report Extent **/
				test = extent.createTest("STP09_Navegar_Bitcoin_ValeInvestir");
				test.assignCategory("Regressão");
				/** Report Extent **/
				
			}
					
		} else {		
						
			// Escrevendo no Console
			System.out.println("Vale a penas Investir em Bitcoins? - Não Visivel");

			/** Report Extent **/
			test.log(Status.ERROR, "Vale a penas Investir em Bitcoins? - Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP09_Navegar_Bitcoin_ValeInvestir-ValePenaInvestirBitcoinNaoVisivel"));
			/** Report Extent **/	

			/** Report Extent **/
			test = extent.createTest("STP09_Navegar_Bitcoin_ValeInvestir");
			test.assignCategory("Regressão");
			/** Report Extent **/

		}
		
	}
	
	@Test
	public void STP10_Navegar_Seguranca() throws Exception {
		
		if (IsElementPresent("Segurança")) {// Verificando se o elemento é verdadeiro
	
			// Buscar o elemento na página
			WebElement menu_Seguranca = driver.findElement(By.linkText("Segurança"));
			
			// Usando a função Highlight
			HighLightElement(menu_Seguranca);
			
			//Clicar no Menu Seguranca
			menu_Seguranca.click();
			Thread.sleep(2000);// esperar 1 segundo
			
			// Verifica se o Texto é verdadeiro
			assertTrue(driver.findElement(By.id("security")).getText().contains("Como protegemos suas moedas digitais"));
			//assertTrue("ZaterX", true);
			//assertEquals("ZaterX", driver.findElement(By.xpath("//*[@id='banner']/div/div[2]/div[1]/div/div/div/div/div/h1")).getText());
			
			// Escrevendo no Console
			System.out.println("Assert: " + driver.findElement(By.id("security")).getText().contains("Nossa Segurança"));
			System.out.println("Assert: " + driver.findElement(By.id("security")).getText());
			
			/** Report Extent **/
			test.log(Status.PASS, "Seguranca - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP06_Navegar_Seguranca-MenuSegurancaVisivel"));
			/** Report Extent **/

			/** Report Extent **/
			test = extent.createTest("STP10_Navegar_Seguranca");
			test.assignCategory("Regressão");
			/** Report Extent **/
						
			// Escrevendo no Console
			System.out.println("Seguranca - Visivel");
			
		} else {		
						
			// Escrevendo no Console
			System.out.println("Seguranca - Nao Visivel");
			
			/** Report Extent **/
			test.log(Status.ERROR, "Seguranca - Nao Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP10_Navegar_Seguranca-MenuSegurancaNaoVisivel"));
			/** Report Extent **/

			/** Report Extent **/
			test = extent.createTest("STP10_Navegar_Seguranca");
			test.assignCategory("Regressão");
			/** Report Extent **/

		}
		
	}

	@Test
	public void STP11_Navegar_Taxas() throws Exception {
		
		if (IsElementPresent("Taxas")) {// Verificando se o elemento é verdadeiro
	
			// Buscar o elemento na página
			WebElement menu_taxas = driver.findElement(By.linkText("Taxas"));
			
			// Usando a função Highlight
			HighLightElement(menu_taxas);
			
			//Clicar no Menu Taxas
			menu_taxas.click();
			Thread.sleep(2000);// esperar 1 segundo
			
			// Verifica se o Texto é verdadeiro
			assertTrue(driver.findElement(By.id("taxes")).getText().contains("Taxas e Prazos da Zater Capital"));
			//assertTrue("ZaterX", true);
			//assertEquals("ZaterX", driver.findElement(By.xpath("//*[@id='banner']/div/div[2]/div[1]/div/div/div/div/div/h1")).getText());
			
			// Escrevendo no Console
			System.out.println("Assert: " + driver.findElement(By.id("taxes")).getText().contains("Taxas e Prazos da Zater Capital"));
			System.out.println("Assert: " + driver.findElement(By.id("taxes")).getText());
			
			/** Report Extent **/
			test.log(Status.PASS, "Taxas - Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP11_Navegar_Taxas-MenuTaxasVisivel"));
			/** Report Extent **/
						
			/** Report Extent **/
			test = extent.createTest("STP11_Navegar_Taxas");
			test.assignCategory("Regressão");
			/** Report Extent **/
			
			// Escrevendo no Console
			System.out.println("Taxas - Visivel");
			
		} else {		
						
			// Escrevendo no Console
			System.out.println("Taxas - Nao Visivel");
			
			/** Report Extent **/
			test.log(Status.ERROR, "Taxas - Nao Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP11_Navegar_Taxas-MenuTaxasNaoVisivel"));
			/** Report Extent **/
			
			/** Report Extent **/
			test = extent.createTest("STP11_Navegar_Taxas");
			test.assignCategory("Regressão");
			/** Report Extent **/

		}
		
	}
	
	@Test
	public void STP12_Navegar_CentralAjuda() throws Exception {

		/** Report Extent **/
		test = extent.createTest("STP12_Navegar_CentralAjuda");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		if (IsElementPresent("Central de Ajuda")) {// Verificando se o elemento é verdadeiro
	
			// Buscar o elemento na página
			WebElement menu_central_ajuda = driver.findElement(By.linkText("Central de Ajuda"));
			
			// Usando a função Highlight
			HighLightElement(menu_central_ajuda);
			
			//Clicar no Menu Central de Ajuda
			menu_central_ajuda.click();
			Thread.sleep(10000);// esperar 1 segundo
			
			/** Report Extent **/
			test.log(Status.PASS, "Central de Ajuda - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP12_Navegar_CentralAjuda-MenuCentralAjudaVisivel"));
			/** Report Extent **/
						
			//Escrevendo no Console
			System.out.println("Central de Ajuda - Visivel");
			
		} else {		
						
			// Escrevendo no Console
			System.out.println("Central de Ajuda - Nao Visivel");
			
			/** Report Extent **/
			test.log(Status.ERROR, "Central de Ajuda - Nao Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP12_Navegar_CentralAjuda-MenuCentralAjudaNaoVisivel"));
			/** Report Extent **/

		}
		
	}
		
	@Test
	public void STP13_Navegar_Contato() throws Exception {

		/** Report Extent **/
		test = extent.createTest("STP13_Navegar_Contato");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		if (IsElementPresent("Contato")) {// Verificando se o elemento é verdadeiro
	
			// Buscar o elemento na página
			WebElement menu_contato = driver.findElement(By.linkText("Contato"));
			
			// Usando a função Highlight
			HighLightElement(menu_contato);
			
			//Clicar no Menu Contato
			menu_contato.click();
			Thread.sleep(2000);// esperar 1 segundo
			
			// Verifica se o Texto é verdadeiro
			assertTrue(driver.findElement(By.id("contactList")).getText().contains("Endereço"));
			//assertTrue("ZaterX", true);
			//assertEquals("ZaterX", driver.findElement(By.xpath("//*[@id='banner']/div/div[2]/div[1]/div/div/div/div/div/h1")).getText());
			
			// Escrevendo no Console
			System.out.println("Assert: " + driver.findElement(By.id("contactList")).getText().contains("Endereço"));
			System.out.println("Assert: " + driver.findElement(By.id("contactList")).getText());
			
			/** Report Extent **/
			test.log(Status.PASS, "Contato - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP13_Navegar_Contato-MenuContatoVisivel"));
			/** Report Extent **/
			
			// Escrevendo no Console
			System.out.println("Contato - Visivel");
			
		} else {		
						
			// Escrevendo no Console
			System.out.println("Contato - Nao Visivel");
			
			/** Report Extent **/
			test.log(Status.ERROR, "Contato - Nao Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP13_Navegar_Contato-MenuContatoNaoVisivel"));
			/** Report Extent **/

		}
		
	}

	@Test
	public void STP14_Navegar_Cadastrar() throws Exception {

		/** Report Extent **/
		test = extent.createTest("STP14_Navegar_Cadastrar");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		if (IsElementPresent("Cadastrar")) {// Verificando se o elemento é verdadeiro
	
			// Buscar o elemento na página
			WebElement botao_cadastar = driver.findElement(By.linkText("Cadastrar"));
			
			// Usando a função Highlight
			HighLightElement(botao_cadastar);
			
			//Clicar no Botao CADASTRAR
			botao_cadastar.click();
			Thread.sleep(10000);// esperar 1 segundo
			
				/** Verificar essa Questão do switch e do assert */
				/**
				  driver.navigate().refresh();
				  driver.switchTo().defaultContent();
				  driver.switchTo().window("ZaterX | A sua exchange");
				
				  String pagina = driver.getWindowHandle();
				  System.out.println(pagina);
				
				  driver.switchTo().window(pagina);
				
			      WebElement classe = driver.findElement(By.xpath("//*[@id='btn-criar']"));
				  HighLightElement(classe);
			
				
				  Verifica se o Texto é verdadeiro
				  assertTrue(driver.findElement(By.xpath("/html/body/main/div/div/div/main/div/h1")).getText().contains("Cadastre-se na Zater"));
				  assertTrue("ZaterX", true);
				  assertEquals("ZaterX", driver.findElement(By.xpath("//*[@id='banner']/div/div[2]/div[1]/div/div/div/div/div/h1")).getText());
				
				  Escrevendo no Console
				  System.out.println("Assert: " + driver.findElement(By.xpath("/html/body/main/div/div/div/main/div/h1")).getText().contains("Cadastre-se na Zater"));
				  System.out.println("Assert: " + driver.findElement(By.xpath("/html/body/main/div/div/div/main/div/h1")).getText());
				*/			
			
			// Pegando as URLs
			String url_site = driver.getCurrentUrl(); // URL atual
			
			// Escrevendo no Console
			System.out.println(url_site);
			
			/** Report Extent **/
			test.log(Status.PASS, "Cadastro - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP14_Navegar_Cadastrar-PaginaCadastroVisivel"));
			/** Report Extent **/
						
			// Escrevendo no Console
			System.out.println("Cadastro - Visivel");
			
		} else {		
						
			// Escrevendo no Console
			System.out.println("Cadastro - Nao Visivel");
			
			/** Report Extent **/
			test.log(Status.ERROR, "Cadastro - Nao Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP14_Navegar_Cadastrar-PaginaCadastroNaoVisivel"));
			/** Report Extent **/

		}
		
	}
	
	@Test
	public void STP15_Navegar_Logar() throws Exception {

		/** Report Extent **/
		test = extent.createTest("STP15_Navegar_Logar");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		if (IsElementPresent("Logar")) {// Verificando se o elemento é verdadeiro
	
			// Buscar o elemento na página
			WebElement botao_logar = driver.findElement(By.linkText("Logar"));
			
			// Usando a função Highlight
			HighLightElement(botao_logar);
			
			//Clicar no Botao LOGAR
			botao_logar.click();
			Thread.sleep(10000);// esperar 1 segundo
			
				/** Verificar essa Questão do switch e do assert */
				/**
				//driver.navigate().refresh();
				//driver.switchTo().defaultContent();
				//driver.switchTo().window("ZaterX | A sua exchange");
				
				//String pagina = driver.getWindowHandle();
				//System.out.println(pagina);
				
				//driver.switchTo().window(pagina);
				
				//WebElement classe = driver.findElement(By.xpath("//*[@id='btn-criar']"));
				//HighLightElement(classe);
			
				
				// Verifica se o Texto é verdadeiro
				//assertTrue(driver.findElement(By.xpath("/html/body/main/div/div/div/main/div/h1")).getText().contains("Cadastre-se na Zater"));
				//assertTrue("ZaterX", true);
				//assertEquals("ZaterX", driver.findElement(By.xpath("//*[@id='banner']/div/div[2]/div[1]/div/div/div/div/div/h1")).getText());
				
				// Escrevendo no Console
				//System.out.println("Assert: " + driver.findElement(By.xpath("/html/body/main/div/div/div/main/div/h1")).getText().contains("Cadastre-se na Zater"));
				//System.out.println("Assert: " + driver.findElement(By.xpath("/html/body/main/div/div/div/main/div/h1")).getText());
				 
				// Pegando as URLs
				//String url_site = driver.getCurrentUrl(); // URL atual
				//System.out.println(url_site);
				*/			
			
			/** Report Extent **/
			test.log(Status.PASS, "Logar - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP15_Navegar_Logar-PaginaLogarVisivel"));
			/** Report Extent **/
						
			// Escrevendo no Console
			System.out.println("Logar - Visivel");
			
		} else {		
						
			// Escrevendo no Console
			System.out.println("Logar - Nao Visivel");
			
			/** Report Extent **/
			test.log(Status.ERROR, "Logar - Nao Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP15_Navegar_Logar-PaginaLogarNaoVisivel"));
			/** Report Extent **/

		}
		
	}
	
	@Test
	public void STP16_Navegar_TermosUso() throws Exception {

		/** Report Extent **/
		test = extent.createTest("STP16_Navegar_TermosUso");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		if (IsElementPresent("Termos de Uso")) {// Verificando se o elemento é verdadeiro
	
			// Buscar o elemento na página
			WebElement termos_uso = driver.findElement(By.linkText("Termos de Uso"));
			
			// Usando a função Highlight
			HighLightElement(termos_uso);
			
			//Clicar no Logo da Home
			termos_uso.click();
			Thread.sleep(2000);// esperar 1 segundo
				
			// Verifica se o Texto é verdadeiro
			assertTrue(driver.findElement(By.id("terms-privacy")).getText().contains("Termos de Uso da Zater Capital"));
			//assertTrue("ZaterX", true);
			//assertEquals("ZaterX", driver.findElement(By.xpath("//*[@id='banner']/div/div[2]/div[1]/div/div/div/div/div/h1")).getText());
			
			// Escrevendo no Console
			System.out.println("Assert: " + driver.findElement(By.id("terms-privacy")).getText().contains("Termos de Uso da Zater Capital"));
			System.out.println("Assert: " + driver.findElement(By.id("terms-privacy")).getText());
			
			/** Report Extent **/
			test.log(Status.PASS, "Termos de Uso - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP16_Navegar_TermosUso-PaginaTermosUsoVisivel"));
			/** Report Extent **/
						
			// Escrevendo no Console
			System.out.println("Termos de Uso - Visivel");
			
		} else {		
						
			// Escrevendo no Console
			System.out.println("Termos de Uso - Nao Visivel");
			
			/** Report Extent **/
			test.log(Status.ERROR, "Termos de Uso - Nao Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP16_Navegar_TermosUso-PaginaTermosUsoNaoVisivel"));
			/** Report Extent **/

		}
		
	}
	
	@Test
	public void STP17_Navegar_PoliticaPrivacidade() throws Exception {

		/** Report Extent **/
		test = extent.createTest("STP17_Navegar_PoliticaPrivacidade");
		test.assignCategory("Regressão");
		/** Report Extent **/
		
		if (IsElementPresent("Política de Privacidade")) {// Verificando se o elemento é verdadeiro
	
			// Buscar o elemento na página
			WebElement politica_privacidade = driver.findElement(By.linkText("Política de Privacidade"));
			
			// Usando a função Highlight
			HighLightElement(politica_privacidade);
			
			//Clicar no Logo da Home
			politica_privacidade.click();
			Thread.sleep(2000);// esperar 1 segundo
		
			// Verifica se o Texto é verdadeiro
			assertTrue(driver.findElement(By.id("terms-privacy")).getText().contains("Política de Privacidade da Zater Capital"));
			//assertTrue("ZaterX", true);
			//assertEquals("ZaterX", driver.findElement(By.xpath("//*[@id='banner']/div/div[2]/div[1]/div/div/div/div/div/h1")).getText());
			
			// Escrevendo no Console
			System.out.println("Assert: " + driver.findElement(By.id("terms-privacy")).getText().contains("Política de Privacidade da Zater Capital"));
			System.out.println("Assert: " + driver.findElement(By.id("terms-privacy")).getText());
			
			/** Report Extent **/
			test.log(Status.PASS, "Politica de Privacidade - Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","STP17_Navegar_PoliticaPrivacidade-PaginaPoliticaPrivacidadeVisivel"));
			/** Report Extent **/
						
			// Escrevendo no Console
			System.out.println("Politica de Privacidade - Visivel");
			
		} else {		
						
			// Escrevendo no Console
			System.out.println("Politica de Privacidade - Nao Visivel");
			
			/** Report Extent **/
			test.log(Status.ERROR, "Politica de Privacidade - Nao Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","STP17_Navegar_PoliticaPrivacidade-PaginaPoliticaPrivacidadeVisivel"));
			/** Report Extent **/

		}
		
	}
		
	@AfterClass
	public static void FecharBrowser() throws Exception {
		
        // Escrevendo no Console
        System.out.println("Fechar o Browser");
        
		/** Report Extent **/
		test = extent.createTest("TCR01_Navegacao_Site_ZaterCapital_Finalizar");
		test.assignCategory("Regressão");
		/** Report Extent **/
                
		/** Report Extent **/
		test.log(Status.PASS, "Browser Encerrado com Sucesso");
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","TCR01_Navegacao_Site_ZaterCapital_Finalizar-EncerrarSiteComSucesso"));
		/** Report Extent **/
        
        // Encerra o Report
        extent.flush();
        
        // Fechar o Browser
        driver.quit();
        //driver.close();
        
	}

}
