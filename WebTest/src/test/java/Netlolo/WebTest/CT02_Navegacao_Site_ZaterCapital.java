package Netlolo.WebTest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Reuso.Dados;
import Reuso.FuncoesReusaveis;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CT02_Navegacao_Site_ZaterCapital extends FuncoesReusaveis {

	@Before
	public void AbrirBrowser() throws Exception {
		
		// Chamando o Browser
		InitBrowser("Chrome");
		
		// Chamando o Site e configurando o Browser  
		driver.navigate().to(Dados.Site_ZaterCapital);	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// Pegando as URLs
		String url_site = driver.getCurrentUrl();
		String url_dados = Dados.Site_ZaterCapital;
		
		// Escrevendo no Console
		System.out.println(url_site);
		System.out.println(url_dados);
		
		// Assert para verificar se as URLs sao iguais
		//assertEquals(url_dados, url_site);
		
		if (url_site.equals(url_dados)) {	
		
		// Escrevendo no Console
		System.out.println("Abrir o Browser - Abrir o Site da Zater Capital");
		
		// Tirando SnapShot
		TakeScreenshot("Sucesso","CT02_Navegacao_Site_ZaterCapital-AbrirSiteComSucesso");

		
		} else {
			
			// Escrevendo no Console
			System.out.println("Abrir o Browser - ERROR ao abrir Site da Zater Capital");		
			
			// Tirando SnapShot
			TakeScreenshot("Erro","CT02_Navegacao_Site_ZaterCapital-ErroAbrirSite");

		}
	}

	@After
	public void FecharBrowser() throws Exception {
		
		// Função para fechar o Browser
		//driver.quit();
		//driver.close();
		// Escrevendo no Console
		System.out.println("Fechar o Browser");
		
	}

	@Test
	public void POP_UP() throws Exception {
		
		// Função para fechar o POP-UP
		if (IsElementPresent("modal")) {// Verificando se o elemento é verdadeiro
		
			// Verificar o Frame
			//driver.switchTo().defaultContent();
			//driver.switchTo().frame(driver.findElement(By.id("TB_iframeContent")));
			//driver.switchTo().frame(driver.findElement(By.name("msgconteudo")));
	
			// Buscar o elemento na página
			//WebElement close_popup = driver.findElement(By.linkText("close"));
			WebElement close_popup = driver.findElement(By.xpath("//*[@id='modal']/span"));
			
			// Usando a função Highlight
			HighLightElement(close_popup);
			
			Thread.sleep(1000);// esperar 1 segundo
			// Clicar no Botao FECHAR o POP-UP
			close_popup.click();
			
			// Usando a função de Screenshot
			TakeScreenshot("Sucesso", "ElementoPopUpFechado");
			
			// Escrevendo no Console
			System.out.println("COM POP-UP");
		} else {		
			// Usando a função de Screenshot
			TakeScreenshot("Erro", "ElementoPopUpNaoEncontrado");
			
			// Escrevendo no Console
			System.out.println("SEM POP-UP");
		}
		
	}
	
}
		
		

