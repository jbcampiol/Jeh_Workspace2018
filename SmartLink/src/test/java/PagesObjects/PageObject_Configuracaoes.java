package PagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;

import Utilitarios.FuncoesReusaveis;

public class PageObject_Configuracaoes extends FuncoesReusaveis {

	
	public static void LogOut() throws Exception {

		if (IsElementPresent("configurations_content")) {

			// Escrevendo no Console
			System.out.println("Configurações - está Visiveis");

			/** Report Extent **/
			test.log(Status.PASS, "Configurações - está Visiveis");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "LogOut-ConfiguracoesVisivel"));
			/** Report Extent **/

			if (IsElementPresent("//*[text()='Sair do aplicativo']")) {

				// Procurando o Elemento
				WebElement logOut = driver.findElement(By.xpath("//*[text()='Sair do aplicativo']"));

				// Funcao HighLight
				HighLightElement(logOut);

				// Clicar no Botão
				//logOut.click();
				
				Actions buttonLogOut = new Actions(driver);   
				buttonLogOut.moveToElement(logOut).click().build().perform();
				
				Thread.sleep(1000); // Espera 1 segundo

				// Escrevendo no Console
				System.out.println("Configurações - LogOut");

				/** Report Extent **/
				test.log(Status.PASS, "Configurações - LogOut");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "LogOut-AcionadoBotaoLogOutComSucesso"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("Configurações - LogOut não Visível");

				/** Report Extent **/
				test.log(Status.FAIL, "Configurações - LogOut não Visível");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "LogOut-NaoVisivel"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console
			System.out.println("Configurações - Não está Visível");

			/** Report Extent **/
			test.log(Status.FAIL, "Configurações - Não está Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "LogOut-ConfiguracoesNaoVisivel"));
			/** Report Extent **/

		}

	}

	
	
}
