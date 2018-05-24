package TestRunner_Reuso;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.google.common.io.Files;

public class FuncoesReusaveis {

	public static WebDriver driver; // Deixando a variavel driver publica

	public static void InitBrowser(String browserName) throws Exception
    {   		
        switch (browserName)
        {
            case "Chrome":    
    			// SETUP do Browser Chrome
    			String Chrome_Browser = Dados.Browser_Chrome;
    			System.setProperty("webdriver.chrome.driver", Chrome_Browser);
    			
    			// Chamada para o Browser e o Site
    			driver = new ChromeDriver();    
    			
    			// Escrevendo no Console
    			System.out.println("Abrir o Browser - Chrome");  
    			
                break;
            case "Firefox":
            	// SETUP do Browser Firefox
    			String Firefox_Browser = Dados.Browser_Firefox;
    			System.setProperty ("webdriver.gecko.driver", Firefox_Browser);
    			
    			// Chamada para o Browser e o Site
    			driver = new FirefoxDriver();   
    			
    			// Escrevendo no Console
    			System.out.println("Abrir o Browser - Firefox");  
    			
                break;
            case "IE":
    			// SETUP do Browser IE
    			String IE_Browser = Dados.Browser_IE;
    			System.setProperty ("webdriver.ie.driver", IE_Browser);
    			
    			// Chamada para o Browser e o Site
    			driver = new InternetExplorerDriver();   
    			
    			// Escrevendo no Console
    			System.out.println("Abrir o Browser - IE");  
    			
                break;
                
            case "Safari":
    			// SETUP do Browser IE
    			//String Safari_Browser = Dados.Browser_Safari;
    			//System.setProperty ("webdriver.ie.driver", Safari_Browser);
    			
    			// Chamada para o Browser e o Site
    			driver = new SafariDriver(); 
    			
    			// Escrevendo no Console
    			System.out.println("Abrir o Browser - Safari");  
    			
                break;
            default:
            	// Escrevendo no Console
            	System.out.println("ERROR - Nenhum Browser encontrado");
            	
    			// Tirando SnapShot
    			TakeScreenshot("C:\\ScreenShot\\JAVA\\Netlolo\\Erro\\","CT01_Navegacao_Site_Netlolo-ErroAbrirBrowser");
            	
                break;
        }
    }
	
	public static void TakeScreenshot(String Resultado, String nameImage) throws Exception {
		
		// Coloando as variaveis fora do switch
		String PATH;
		File directory;	
		DateFormat dateFormat;	
		Date date;
		
		 switch (Resultado)
	        {
            case "Sucesso":    

				System.out.println("Screenshot com Sucesso");
				
				// Informando o diretorio
				PATH = "C:\\ScreenShot\\JAVA\\Netlolo\\Sucesso\\";
				
				// Informando o diretorio
				//String PATH = Caminho;
				// Informando o arquivo
				directory = new File(PATH);

				// Formatando a Data
				dateFormat = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss");
				// Chamando a Data
				date = new Date();
				// System.out.println(dateFormat.format(date));

				if (!directory.exists()) // Condicao verificando o diretorio
				{
					
					// Comando que cria o diretorio
					directory.mkdirs();
					// Funcao para tirar o Screenshot
					File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(scrFile, new File(PATH + nameImage + "_" + dateFormat.format(date) + ".jpg"));
					
				} else {
					
					// Funcao para tirar o Screenshot
					File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(scrFile, new File(PATH + nameImage + "_" + dateFormat.format(date) + ".jpg"));
					
				}   			
                break;
            case "Erro":    
            	
            	System.out.println("Screenshot com Sucesso do Erro");
				
				// Informando o diretorio
				PATH = "C:\\ScreenShot\\JAVA\\Netlolo\\Erro\\";
				
				// Informando o arquivo
				directory = new File(PATH);

				// Formatando a Data
				dateFormat = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss");
				// Chamando a Data
				date = new Date();
				// System.out.println(dateFormat.format(date));

				if (!directory.exists()) // Condicao verificando o diretorio
				{
					
					// Comando que cria o diretorio
					directory.mkdirs(); 
					// Funcao para tirar o Screenshot
					File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					Files.copy(scrFile, new File(PATH + nameImage + "_" + dateFormat.format(date) + ".jpg"));
					
				} else {
					
					// Funcao para tirar o Screenshot
					File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					Files.copy(scrFile, new File(PATH + nameImage + "_" + dateFormat.format(date) + ".jpg"));
					
					}    
				
                break;                
            default:
            	
            	// Escrevendo no Console
            	System.out.println("ERROR - Caminho não encontrado ou Screenshot não tirado");
            	
                break;
	        }
	}
	
	public static void HighLightElement(WebElement element) {
	
			// Fun��o para Highligth
	
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
			
	public static boolean IsElementPresent(String elemento) {
			try {
				driver.findElement(By.id(elemento)).isDisplayed();		
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				return true;			
			} catch (Exception e) {
				try{
					driver.findElement(By.name(elemento)).isDisplayed();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					return true;
				} catch (Exception f){
					try{
						driver.findElement(By.linkText(elemento)).isDisplayed();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						return true;
					} catch (Exception g){
						System.out.println (g.getMessage());
						return false;
					}				
				}
			}
		}
			
	public static void SendKeys(Robot robot, String keys) {
	    for (char c : keys.toCharArray()) {
	        int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
	        if (KeyEvent.CHAR_UNDEFINED == keyCode) {
	            throw new RuntimeException(
	                "Key code not found for character '" + c + "'");
	        }
	        robot.keyPress(keyCode);
	        robot.delay(100);
	        robot.keyRelease(keyCode);
	        robot.delay(100);
	    }
	}
	

	// region ReproduzirAudio
	/*
	 * public void ReproduzirAudio (String speak) { // Fun��o para reproduzir o
	 * audio Synthesizer reproducao = new Synthesizer(); reproducao.speak(speak,
	 * null); }
	 */
	// endregion
	
}
