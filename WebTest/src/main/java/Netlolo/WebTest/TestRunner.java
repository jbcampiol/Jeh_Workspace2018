package Netlolo.WebTest;

import java.util.concurrent.TimeUnit;

import TestRunner_Reuso.Dados;
import TestRunner_Reuso.FuncoesReusaveis;

public class TestRunner extends FuncoesReusaveis{
	
	//public static WebDriver driver; // Deixando a variavel driver publica
	
	public static void main(String[] args)  throws Exception  {
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
}

