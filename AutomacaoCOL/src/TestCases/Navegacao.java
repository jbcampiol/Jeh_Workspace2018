package TestCases;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import Reuso.Dados;
//import Reuso.FuncoesReusaveis;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Navegacao extends Reuso.FuncoesReusaveis { //extends FuncoesReusaveis

	public static WebDriver driver; // Deixando a variavel driver publica

	@BeforeClass // Executa antes de qualquer Caso de Teste.
	public static void AbrirBrowser() throws Exception {

		// SETUP do Browser Chrome
		String Chrome_Browser = "C:\\Users\\jefferson\\Desktop\\Teste\\Ferramentas\\Selenium WebDriver\\path\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", Chrome_Browser);

		// SETUP do Browser FireFox
		// String Firefox_Browser =
		// "C:\\selenium-java-3.0.1\\path\\geckodriver.exe";
		// System.setProperty ("webdriver.gecko.driver", Firefox_Browser);

		// Chamada para o Browser e o Site
		// driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.navigate().to("http://centralonline.prosoft.com.br/login/log_login/log_login.asp");
		// driver.get("http://www.google.com.br/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Escrevendo no Console
		System.out.println("Abrir o Browser");

		// Função de reprodução de audio
		// ReproduzirAudio("Abrir o Browser");

		try {
			// Verificando se o elemento está visivel.
			driver.findElement(By.xpath("/html/body/div/div/div/h1/img")).isDisplayed();

			// Usando a Função Highlight
			WebElement elemento_logo = driver.findElement(By.xpath("/html/body/div/div/div/h1/img"));
			HighLightElement(driver, elemento_logo);

			// Usando a função de Screenshot
			TakeScreenshot(driver, "AbrirPaginaComSucesso");
		} catch (Exception e) {
			// Usando a função de Screenshot
			TakeScreenshot(driver, "AbrirPaginaComErro");
			
			// Escrevendo no Console
			System.out.println("Erro ao abrir a Pagina");
		}

	}

	@Test // Usado para identificar o que é o Caso de Teste.
	public void CT01_Login() throws Exception {
		
		// Função para o Campo Login
		try {
			// Veirificar se o elemento está visivel
			driver.findElement(By.xpath("//*[@type='text']")).isDisplayed();

			// Buscar o elemento na página
			WebElement login = driver.findElement(By.xpath("//*[@type='text']"));

			// Usando a função Highlight
			HighLightElement(driver, login);

			// Inserir o valores no campo LOGIN
			login.sendKeys(Reuso.Dados.CPF);

			// Usando a função de Screenshot
			TakeScreenshot(driver, "ElementoLoginEncontrado");
		} catch (Exception e) {
			// Usando a função de Screenshot
			TakeScreenshot(driver, "ElementoLoginNaoEncontrado");
			
			// Escrevendo no Console
			System.out.println("Elemento LOGIN não encontrado");
		}

		// Função para o Campo Senha
		try {
			// Veirificar se o elemento está visivel
			driver.findElement(By.xpath("//*[@type='password']")).isDisplayed();

			// Buscar o elemento na página
			WebElement password = driver.findElement(By.xpath("//*[@type='password']"));

			// Usando a função Highlight
			HighLightElement(driver, password);

			// Inserir o valores no campo SENHA
			password.sendKeys(Reuso.Dados.Password);

			// Usando a função de Screenshot
			TakeScreenshot(driver, "ElementoSenhaEncontrado");
		} catch (Exception e) {
			// Usando a função de Screenshot
			TakeScreenshot(driver, "ElementoSenhaNaoEncontrado");
			
			// Escrevendo no Console
			System.out.println("Elemento SENHA não encontrado");
		}

		// Função para o Botão Entrar do Login
		try {
			// Veirificar se o elemento está visivel
			driver.findElement(By.xpath("//*[@type='submit']")).isDisplayed();

			// Buscar o elemento na página
			WebElement bttEntrar = driver.findElement(By.xpath("//*[@type='submit']"));

			// Usando a função Highlight
			HighLightElement(driver, bttEntrar);

			// Usando a função de Screenshot
			TakeScreenshot(driver, "ElementoButtonLoginEncontrado");

			Thread.sleep(1000); // esperar 1 segundo
			// Clicar no Botão ENTRAR
			bttEntrar.click();
		} catch (Exception e) {
			// Usando a função de Screenshot
			TakeScreenshot(driver, "ElementoButtonLoginNaoEncontrado");
			
			// Escrevendo no Console
			System.out.println("Elemento BUTTON ENTRAR não encontrado");
			
		}

		if (Reuso.FuncoesReusaveis.IsTestElementPresent(driver, "TB_iframeContent") || Reuso.FuncoesReusaveis.IsTestElementPresent(driver, "coldisplay")){				
			// Usando a função de Screenshot
			TakeScreenshot(driver, "LoginEfetuadoComSucesso");
			
			// Escrevendo no Console
			System.out.println("LOGIN efetuado com sucesso");			
		} else {		
			// Usando a função de Screenshot
			TakeScreenshot(driver, "LoginNaoEfetuado");
			
			// Escrevendo no Console
			System.out.println("LOGIN NÃO efetuado");
		}
		
	}

	@Test // Usado para identificar o que é o Caso de Teste.
	public void CT02_FecharPopUp() throws Exception {

		// Função para fechar o POP-UP
		if (Reuso.FuncoesReusaveis.IsTestElementPresent(driver, "TB_iframeContent")) // Verificando se o elemento é verdadeiro
		{
			// Verificar o Frame
			driver.switchTo().frame(driver.findElement(By.id("TB_iframeContent")));
			driver.switchTo().frame(driver.findElement(By.name("msgconteudo")));
	
			// Buscar o elemento na página
			WebElement close_popup = driver.findElement(By.xpath("html/body/table/tbody/tr[1]/td/table/tbody/tr/td[2]/a/img"));
			
			// Usando a função Highlight
			HighLightElement(driver, close_popup);
			
			Thread.sleep(1000);// esperar 1 segundo
			// Clicar no Botao FECHAR o POP-UP
			close_popup.click();
			
			// Usando a função de Screenshot
			TakeScreenshot(driver, "ElementoPopUpFechado");
			
			// Escrevendo no Console
			System.out.println("COM POP-UP");
		} else {		
			// Usando a função de Screenshot
			TakeScreenshot(driver, "ElementoPopUpNaoEncontrado");
			
			// Escrevendo no Console
			System.out.println("SEM POP-UP");
		}
	}
	
	@Test // Usado para identificar o que é o Caso de Teste.	
	public void CT03_MenuTreeMenuGerais() throws Exception {
		
		// Função para o Botão Entrar do Login
		try {
			// Função que volta para o Frame Default
			//driver.switchTo().window(driver.getWindowHandle());
			driver.switchTo().defaultContent();
			
			// Verificar o Frame
	        driver.switchTo().frame(driver.findElement(By.name("iFraConteudo0")));
	
	        // Buscar o elemento na página
	        WebElement menu_gerais = driver.findElement(By.xpath("//*[@id='sd1']"));
	        
	        // Usando a função Highlight
	        HighLightElement(driver, menu_gerais);
	        
	        Thread.sleep(1000);// esperar 1 segundo
	        // Clicar no Botao MENU GERAIS
	        menu_gerais.click();
	
	        // Usando a função de Screenshot
	        TakeScreenshot(driver, "ElementoMenuGeraisEncontrado");
	     	
	     	// Escrevendo no Console
	        System.out.println ("Menu Gerais");
			
		} catch (Exception e) {
			// Usando a função de Screenshot
			TakeScreenshot(driver, "ElementoMenuGeraisnNaoEncontrado");
			
			// Escrevendo no Console
			System.out.println("Elemento MENU GERAIS não encontrado");
		}
	}
	
	@Test // Usado para identificar o que é o Caso de Teste.	
	public void CT04_MenuTreeProPessoal() throws Exception {
		
		// Função para o Botão Entrar do Login
		try {
	        // Buscar o elemento na página
	        WebElement menu_propessoal = driver.findElement(By.id("sd5"));
	        
	        // Usando a função Highlight
	        HighLightElement(driver, menu_propessoal);
	        
	        Thread.sleep(1000);// esperar 1 segundo
	        // Clicar no Botao MENU GERAIS
	        menu_propessoal.click();
	
	        // Usando a função de Screenshot
	        TakeScreenshot(driver, "ElementoMenuProPessoalEncontrado");
	     	
	     	// Escrevendo no Console
	        System.out.println ("Menu ProPessoal");
			
		} catch (Exception e) {
			// Usando a função de Screenshot
			TakeScreenshot(driver, "ElementoMenuProPessoalNaoEncontrado");
			
			// Escrevendo no Console
			System.out.println("Elemento MENU PROPESSOAL não encontrado");
		}
	}
	
	@Test // Usado para identificar o que é o Caso de Teste.	
	public void CT05_AbaParametroUnidade() throws Exception {
		
		// Função para o Botão Entrar do Login
		try {
	        // Buscar o elemento na página
	        WebElement menu_propessoal = driver.findElement(By.id("sd5"));
	        
	        // Usando a função Highlight
	        HighLightElement(driver, menu_propessoal);
	        
	        Thread.sleep(1000);// esperar 1 segundo
	        // Clicar no Botao MENU GERAIS
	        menu_propessoal.click();
	
	        // Usando a função de Screenshot
	        TakeScreenshot(driver, "ElementoMenuProPessoalEncontrado");
	     	
	     	// Escrevendo no Console
	        System.out.println ("Menu ProPessoal");
			
		} catch (Exception e) {
			// Usando a função de Screenshot
			TakeScreenshot(driver, "ElementoMenuProPessoalNaoEncontrado");
			
			// Escrevendo no Console
			System.out.println("Elemento MENU PROPESSOAL não encontrado");
		}
	}
	
	@AfterClass
	public static void FecharBrowser() throws Exception {

		// Função para fechar o Browser
		// driver.quit();
		// driver.close();
		// Escrevendo no Console
		System.out.println("Encerrado");

	}

}