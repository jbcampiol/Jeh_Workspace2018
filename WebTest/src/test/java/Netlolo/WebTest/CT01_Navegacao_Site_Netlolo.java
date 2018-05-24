package Netlolo.WebTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Reuso.Dados;
import Reuso.FuncoesReusaveis;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CT01_Navegacao_Site_Netlolo extends FuncoesReusaveis {

	//public static WebDriver driver; // Deixando a variavel driver publica
	
	@BeforeClass // Executa antes de qualquer Caso de Teste.
	public static void AbrirBrowser() throws Exception {
		
		// Chamando o Browser
		InitBrowser("Chrome");
		
		// Chamando o Site e configurando o Browser  
		driver.navigate().to(Dados.Site_Netlolo);	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// Pegando as URLs
		String url_site = driver.getCurrentUrl();
		String url_dados = Dados.Site_Netlolo;
		
		// Escrevendo no Console
		System.out.println(url_site);
		System.out.println(url_dados);
		
		// Assert para verificar se as URLs sao iguais
		//assertEquals(url_dados, url_site);
		
		if (url_site.equals(url_dados)) {	
		
		// Escrevendo no Console
		System.out.println("Abrir o Browser - Abrir o Site da Netlolo");
		
		// Tirando SnapShot
		TakeScreenshot("Sucesso","CT01_Navegacao_Site_Netlolo-AbrirSiteComSucesso");

		
		} else {
			
			// Escrevendo no Console
			System.out.println("Abrir o Browser - ERROR ao abrir Site da Netlolo");		
			
			// Tirando SnapShot
			TakeScreenshot("Erro","CT01_Navegacao_Site_Netlolo-ErroAbrirSite");

		}
	}

	@Test
	public void STP01_Verificar_Assert() throws Exception {
		
		// Verificar o assert
		assertEquals("O que você precisa?", driver.findElement(By.id("page-header-title")).getText());
		
		//Verifica o assert
		assertTrue(driver.findElement(By.id("ht-posts-widget-plugin-2")).getText().contains("sobre a Netlolo"));
		
		// Funcao HighLigth
		HighLightElement(driver.findElement(By.id("page-header-title")));
		
		// Tirando SnapShot
		TakeScreenshot("Sucesso","CT01_Navegacao_Site_Netlolo_STP01_Verificar_Assert_Sucesso");
		
		// Escrevendo no Console
		System.out.println("Assert - 'O que você precisa?'");
		
		// Escrevendo no Console
		System.out.println("Assert - 'sobre a Netlolo'");

	}
		
	@Test
	public void STP02_NavegarMenu_Celulares() throws Exception {
		
		while (IsElementPresent("homepage-widgets") == false){
			
			// Funcao HighLigth
			HighLightElement(driver.findElement(By.id("logo")));
			
			// Procurar o Logo
			WebElement logo = driver.findElement(By.id("logo"));
			logo.click();
			
		}	
			if (IsElementPresent("homepage-widgets1")) {
			
				// Funcao HighLigth
				//HighLightElement(driver.findElement(By.linkText("Celulares")));
				HighLightElement(driver.findElement(By.xpath("//*[@id='page-categories-top']/li[1]/a/img")));
							
				// Procurar o Menu Celulares
				WebElement menu_celulares = driver.findElement(By.linkText("Celulares"));
				menu_celulares.click();
				
				// Tirando SnapShot
				TakeScreenshot("Sucesso","CT01_Navegacao_Site_Netlolo_STP02_NavegarMenu_Celulares_Sucesso");
				
				// Escrevendo no Console
				System.out.println("Menu 'Celulares' encontrado com sucesso");		
				
					
				} else {
					
					// Escrevendo no Console
					System.out.println("Menu 'Celulares' não encontrado");		
					
					// Tirando SnapShot
					TakeScreenshot("Erro","CT01_Navegacao_Site_Netlolo_STP02_NavegarMenu_Celulares_Erro");
					
			}
		
		}
	
	@Test
	public void STP03_NavegarMenu_SmartTVs() throws Exception {
		
		while (IsElementPresent("homepage-widgets") == false){
			
			// Funcao HighLigth
			HighLightElement(driver.findElement(By.id("logo")));
			
			// Procurar o Logo
			WebElement logo = driver.findElement(By.id("logo"));
			logo.click();
			
		}
			if (IsElementPresent("homepage-widgets")) {
				
				// Funcao HighLigth
				//HighLightElement(driver.findElement(By.linkText("Smart TVs")));
				HighLightElement(driver.findElement(By.xpath("//*[@id='page-categories-top']/li[2]/a/img")));
				
				// Procurar o Menu Celulares
				WebElement menu_smart_tv = driver.findElement(By.linkText("Smart TVs"));
				menu_smart_tv.click();
								
				// Tirando SnapShot
				TakeScreenshot("Sucesso","CT01_Navegacao_Site_Netlolo_STP03_NavegarMenu_SmartTVs_Sucesso");
				
				// Escrevendo no Console
				System.out.println("Menu 'Smart TVs' encontrado com sucesso");		
				
					
				} else {
					
					// Escrevendo no Console
					System.out.println("Menu 'Smart TVs' não encontrado");		
					
					// Tirando SnapShot
					TakeScreenshot("Erro","CT01_Navegacao_Site_Netlolo_STP03_NavegarMenu_SmartTVs_Erro");
								
				}
			
		}
	
	@Test
	public void STP04_NavegarMenu_Notebooks() throws Exception {
		
		while (IsElementPresent("homepage-widgets") == false){
			
			// Funcao HighLigth
			HighLightElement(driver.findElement(By.id("logo")));
			
			// Procurar o Logo
			WebElement logo = driver.findElement(By.id("logo"));
			logo.click();
			
		}
			if (IsElementPresent("homepage-widgets")) {
				
				// Funcao HighLigth
				HighLightElement(driver.findElement(By.linkText("Notebooks")));
				//HighLightElement(driver.findElement(By.xpath("//*[@id='page-categories-top']/li[3]/a/img")));
				
				// Procurar o Menu Celulares
				WebElement menu_notebooks = driver.findElement(By.linkText("Notebooks"));
				menu_notebooks.click();
				
				// Tirando SnapShot
				TakeScreenshot("Sucesso","CT01_Navegacao_Site_Netlolo_STP04_NavegarMenu_Notebooks_Sucesso");
				
				// Escrevendo no Console
				System.out.println("Menu 'Notebooks' encontrado com sucesso");		
				
					
				} else {
					
					// Escrevendo no Console
					System.out.println("Menu 'Notebooks' não encontrado");		
					
					// Tirando SnapShot
					TakeScreenshot("Erro","CT01_Navegacao_Site_Netlolo_STP04_NavegarMenu_Notebooks_Erro");
								
				}
			
		}
	
	@Test
	public void STP05_NavegarMenu_ArCondicionado() throws Exception {
		
		while (IsElementPresent("homepage-widgets") == false){
			
			// Funcao HighLigth
			HighLightElement(driver.findElement(By.id("logo")));
			
			// Procurar o Logo
			WebElement logo = driver.findElement(By.id("logo"));
			logo.click();
			
		}
			if (IsElementPresent("homepage-widgets")) {
				
				// Funcao HighLigth
				//HighLightElement(driver.findElement(By.linkText("Ar Condicionado")));
				HighLightElement(driver.findElement(By.xpath("//*[@id='page-categories-top']/li[4]/a/img")));
				
				// Procurar o Menu Celulares
				WebElement menu_notebooks = driver.findElement(By.linkText("Ar Condicionado"));
				menu_notebooks.click();
				
				// Tirando SnapShot
				TakeScreenshot("Sucesso","CT01_Navegacao_Site_Netlolo_STP05_NavegarMenu_ArCondicionado_Sucesso");
				
				// Escrevendo no Console
				System.out.println("Menu 'Ar Condicionado' encontrado com sucesso");		
				
					
				} else {
					
					// Escrevendo no Console
					System.out.println("Menu 'Ar Condicionado' não encontrado");		
					
					// Tirando SnapShot
					TakeScreenshot("Erro","CT01_Navegacao_Site_Netlolo_STP05_NavegarMenu_ArCondicionado_Erro");
								
				}
			
		}
	
	@Test
	public void STP06_NavegarMenu_Calcados() throws Exception {
		
		while (IsElementPresent("homepage-widgets") == false){
			
			// Funcao HighLigth
			HighLightElement(driver.findElement(By.id("logo")));
			
			// Procurar o Logo
			WebElement logo = driver.findElement(By.id("logo"));
			logo.click();
			
		}
			if (IsElementPresent("homepage-widgets")) {
				
				// Funcao HighLigth
				//HighLightElement(driver.findElement(By.linkText("Calçados")));
				HighLightElement(driver.findElement(By.xpath("//*[@id='page-categories-top']/li[5]/a/img")));
				
				// Procurar o Menu Celulares
				WebElement menu_notebooks = driver.findElement(By.linkText("Calçados"));
				menu_notebooks.click();
				
				// Tirando SnapShot
				TakeScreenshot("Sucesso","CT01_Navegacao_Site_Netlolo_STP06_NavegarMenu_Calcados_Sucesso");
				
				// Escrevendo no Console
				System.out.println("Menu 'Calçados' encontrado com sucesso");		
				
					
				} else {
					
					// Escrevendo no Console
					System.out.println("Menu 'Calçados' não encontrado");		
					
					// Tirando SnapShot
					TakeScreenshot("Erro","CT01_Navegacao_Site_Netlolo_STP06_NavegarMenu_Calcados_Erro");
								
				}
			
		}

	@Test
	public void STP07_NavegarMenu_Roupas() throws Exception {
		
		while (IsElementPresent("homepage-widgets") == false){
			
			// Funcao HighLigth
			HighLightElement(driver.findElement(By.id("logo")));
			
			// Procurar o Logo
			WebElement logo = driver.findElement(By.id("logo"));
			logo.click();
			
		}
			if (IsElementPresent("homepage-widgets")) {
				
				// Funcao HighLigth
				//HighLightElement(driver.findElement(By.linkText("Roupas")));
				HighLightElement(driver.findElement(By.xpath("//*[@id='page-categories-top']/li[6]/a/img")));
				
				// Procurar o Menu Celulares
				WebElement menu_notebooks = driver.findElement(By.linkText("Roupas"));
				menu_notebooks.click();
				
				// Tirando SnapShot
				TakeScreenshot("Sucesso","CT01_Navegacao_Site_Netlolo_STP07_NavegarMenu_Roupas_Sucesso");
				
				// Escrevendo no Console
				System.out.println("Menu 'Roupas' encontrado com sucesso");		
				
					
				} else {
					
					// Escrevendo no Console
					System.out.println("Menu 'Roupas' não encontrado");		
					
					// Tirando SnapShot
					TakeScreenshot("Erro","CT01_Navegacao_Site_Netlolo_STP07_NavegarMenu_Roupas_Erro");
								
				}
			
		}
	
	@Test
	public void STP08_NavegarMenu_Bikes() throws Exception {
		
		while (IsElementPresent("homepage-widgets") == false){
			
			// Funcao HighLigth
			HighLightElement(driver.findElement(By.id("logo")));
			
			// Procurar o Logo
			WebElement logo = driver.findElement(By.id("logo"));
			logo.click();
			
		}
			if (IsElementPresent("homepage-widgets")) {
				
				// Funcao HighLigth
				//HighLightElement(driver.findElement(By.linkText("Roupas")));
				HighLightElement(driver.findElement(By.xpath("//*[@id='page-categories-top']/li[7]/a/img")));
				
				// Procurar o Menu Celulares
				WebElement menu_notebooks = driver.findElement(By.linkText("Bikes"));
				menu_notebooks.click();
				
				// Tirando SnapShot
				TakeScreenshot("Sucesso","CT01_Navegacao_Site_Netlolo_STP08_NavegarMenu_Bikes_Sucesso");
				
				// Escrevendo no Console
				System.out.println("Menu 'Bikes' encontrado com sucesso");		
				
					
				} else {
					
					// Escrevendo no Console
					System.out.println("Menu 'Bikes' não encontrado");		
					
					// Tirando SnapShot
					TakeScreenshot("Erro","CT01_Navegacao_Site_Netlolo_STP08_NavegarMenu_Bikes_Erro");
								
				}
			
		}
	
	@AfterClass
	public static void FecharBrowser() throws Exception {
	
		// Função para fechar o Browser
		driver.quit();
		//driver.close();
		// Escrevendo no Console
		System.out.println("Fechar o Browser");
	
	}

}
