package Reuso;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FuncoesReusaveis {

	// public WebDriver driver; // Deixando a variavel driver publica

	// region TakeScreenshot

	public static void TakeScreenshot(WebDriver driver, String nameImage) throws Exception {
		try {
			// Informando o diretório
			String PATH = "C:\\ScreenShot\\JAVA\\";
			// Informando o arquivo
			File directory = new File(PATH);

			// Formatando a Data
			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
			// Chamando a Data
			Date date = new Date();
			// System.out.println(dateFormat.format(date));

			if (directory.exists()) // Condição verificando o diretório
			{
				// Função para tirar o Screenshot
				directory.mkdirs(); 
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(PATH + nameImage + "_" + dateFormat.format(date) + ".jpg"));
			} else {
				//directory.mkdirs(); // Cria o diretório
				// Função para tirar o Screenshot
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(PATH + nameImage + "_" + date.toString() + ".jpg"));
				// FileUtils.copyFile(scrFile, new File(PATH + nameImage + "_" +
				// System.currentTimeMillis() + ".jpg"));
			}

		} catch (Exception e) {
			// Escrevendo no Console
			System.out.println(e.getMessage());
		}
	}

	// endregion

	// region Highlight

	public static void HighLightElement(WebDriver driver, WebElement element) {

		// Função para Highligth

		String originalStyle = element.getAttribute("style");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		try {

			Thread.sleep(3000);

		}

		catch (InterruptedException e) {
		}

		js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", element);

	}

	// endregion

	// region VerificarElemento

	public static boolean IsTestElementPresent(WebDriver driver, String elemento) {
		try {
			driver.findElement(By.id(elemento)).isDisplayed();		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return true;
			// WebElement menusobre = driver.findElement(By.id(elemento));
			// assertTrue(menusobre.getText().contains("SOBRE"));
		} catch (Exception e) {
			try{
				driver.findElement(By.name(elemento)).isDisplayed();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				return true;
			} catch (Exception f){
				System.out.println (e.getMessage());
				return false;
			}
		}
	}

	// endregion
	
	// region ReproduzirAudio
	/*
	 * public void ReproduzirAudio (String speak) { // Função para reproduzir o
	 * audio Synthesizer reproducao = new Synthesizer(); reproducao.speak(speak,
	 * null); }
	 */
	// endregion
}
