package Funcional.US01_LogarExchange;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Utilitarios.Dados_Windows;
import Utilitarios.FuncoesReusaveis_Windows;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class TCF01_LogarExchange extends FuncoesReusaveis_Windows {
	
	
	@Given("^usuario do da Zater Capital$")
	public void usuario_do_da_Zater_Capital() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		// Chamando o Browser
		InitBrowser("Chrome");
		
		// Chamando o Site e configurando o Browser  
		driver.navigate().to(Dados_Windows.Producao_Site_ZaterCapital_Exchange);	// chamando o site
		driver.manage().window().maximize(); // maximizando o browser
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // esperando por até 20 segundos
		
		// Pegando as URLs
		String url_site = driver.getCurrentUrl(); // URL atual
		String url_dados = Dados_Windows.Producao_Site_ZaterCapital_Exchange; // URL da class Dados
		
		// Escrevendo no Console
		System.out.println(url_site);
		System.out.println(url_dados);
		
		// Assert para verificar se as URLs sao iguais
		//assertEquals(url_dados, url_site);
		
		if (url_site.equals(url_dados) && IsElementPresent("btn-logar")) {	
			
		// Tirando SnapShot
		TakeScreenshot("Sucesso","LogarExchange-AbrirSiteComSucesso");
		
		// Escrevendo no Console
		System.out.println("Abrir o Browser - Abrir o Site da Exchange da Zater Capital");
		
		} else {
						
			// Tirando SnapShot
			TakeScreenshot("Erro","LogarExchange-ErroAbrirSite");
			
			// Escrevendo no Console
			System.out.println("Abrir o Browser - ERROR ao abrir Site da Exchange da Zater Capital");		
			
		}
		
	}

	@When("^informar um \"([^\"]*)\" valido e uma \"([^\"]*)\" valida$")
	public void informar_um_valido_e_uma_valida(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		if (IsElementPresent("Page-1")) {
			
			// Tirando SnapShot
			TakeScreenshot("Sucesso", "LogarExchange-LoginVisivel");
			
	        // Escrevendo no Console
	        System.out.println("LoginPage - Logo ZATERX Visivel");
			
			if (IsElementPresent("inputEmail3")) {
				
				// Procurando o Elemento
				WebElement login = driver.findElement(By.id("inputEmail3"));
	
				// Funcao HighLight
		        HighLightElement(login);
		        
		        // Digitando o Usuário
		        login.sendKeys(arg1);
		        Thread.sleep(1000); // Espera 1 segundo
		        
		        // Tirando SnapShot
		        TakeScreenshot("Sucesso", "LogarExchange-UsuarioInformado");
		        
		        // Escrevendo no Console
		        System.out.println("LoginPage - Usuário Informado");
		        System.out.println("Usuário" + arg1);

			} else {
			
				// Tirando SnapShot
				TakeScreenshot("Erro","LogarExchange-UsuarioNaoInformado");
				
				// Escrevendo no Console
				System.out.println("LoginPage - Usuário Não Informado");
							
			}
			
			if (IsElementPresent("inputPassword3")) {
		        
				// Procurando o Elemento
	       		WebElement password = driver.findElement(By.id("inputPassword3"));
		        
	       		// Funcao HighLight
	       		HighLightElement(password);
	       		
	       		// Digitando a Senha
		        password.sendKeys(arg2);        
		        Thread.sleep(1000); // Espera 1 segundo
		        
		        // Tirando SnapShot
		        TakeScreenshot("Sucesso", "LogarExchange-SenhaInformada");
		        
		        // Escrevendo no Console
		        System.out.println("LoginPage - Senha Informada");
		        System.out.println("Senha" + arg2);
		        
				} else {
					
					// Tirando SnapShot
					TakeScreenshot("Erro","LogarExchange-SenhaNaoInformada");
					
					// Escrevendo no Console
					System.out.println("LoginPage - Senha Não Informada");
					
				}
		
		} else {
			
			// Tirando SnapShot
			TakeScreenshot("Erro", "LogarExchange-LoginNaoVisivel");
			
	        // Escrevendo no Console
	        System.out.println("LoginPage - Logo ZATERX Não Visivel");
			
		}
	}

	@When("^acionar o Botao de LOGAR$")
	public void acionar_o_Botao_de_LOGAR() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		if(IsElementPresent("btn-logar")) {
		
		// Procurando o Elemento
        WebElement ButtonLogar = driver.findElement(By.xpath("//*[@type='submit']"));
        
        // Funcao HighLight
        HighLightElement(ButtonLogar);
        
        // Tirando SnapShot
        TakeScreenshot("Sucesso", "LogarExchange-AcionarBotaoLogar");
        
        // Clicando no Botão LOGAR
        ButtonLogar.click();
        Thread.sleep(1000); // Espera 1 segundo
        
        // Escrevendo no Console
        System.out.println("LoginPage - Acionando o Botão LOGAR");
        
		} else {
			
			// Tirando SnapShot
			TakeScreenshot("Erro", "LogarExchange-NaoAcionarBotaoLogar");
			
	        // Escrevendo no Console
	        System.out.println("LoginPage - Não Acionando o Botão LOGAR");
			
		}
	}

	@Then("^o sistema deve permitir a autenticao do usuario na exchange com sucesso$")
	public void o_sistema_deve_permitir_a_autenticao_do_usuario_na_exchange_com_sucesso() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		// Procurando o Elemento
		//WebElement LogadoSucesso = driver.findElement(By.xpath("/html/body/main/page-top/div/div[2]/div[1]/a/img"));
		
		if(IsElementPresent("/html/body/main/page-top/div/div[2]/div[1]/a/img")) {
		
	        // Funcao HighLight
	        HighLightElement(driver.findElement(By.xpath("/html/body/main/page-top/div/div[2]/div[1]/a/img")));
	        
	        // Tirando SnapShot
	        TakeScreenshot("Sucesso", "LogarExchange-LogadoComSucesso");
	        
	        // Escrevendo no Console
	        System.out.println("Logado com Sucesso!!!");
	        
	        // Fechar o Browser
	        driver.quit();
	        
		} else {
			
	        // Tirando SnapShot
	        TakeScreenshot("Erro", "LogarExchange-ErroLogar");
	        
	        // Escrevendo no Console
	        System.out.println("Erro ao Logar!!!");
	        
	        // Fechar o Browser
	        //driver.quit();
			
		}
	        
	}

	
}
