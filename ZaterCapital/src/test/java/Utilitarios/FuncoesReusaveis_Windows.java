package Utilitarios;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.sarxos.webcam.Webcam;
import com.google.common.io.Files;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;


public class FuncoesReusaveis_Windows {

	public static WebDriver driver; // Deixando a variavel driver publica
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlReporter;

	public static void InitBrowser(String browserName) throws Exception {
		switch (browserName) {
		case "Chrome":
			// SETUP do Browser Chrome
			String Chrome_Browser = Dados_Windows.Browser_Chrome;
			System.setProperty("webdriver.chrome.driver", Chrome_Browser);

			// Chamada para o Browser e o Site
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Escrevendo no Console
			System.out.println("Abrir o Browser - Chrome");

			break;
		case "Firefox":
			// SETUP do Browser Firefox
			String Firefox_Browser = Dados_Windows.Browser_Firefox;
			System.setProperty("webdriver.gecko.driver", Firefox_Browser);

			// Chamada para o Browser e o Site
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Escrevendo no Console
			System.out.println("Abrir o Browser - Firefox");

			break;
		case "IE":
			// SETUP do Browser IE
			String IE_Browser = Dados_Windows.Browser_IE;
			System.setProperty("webdriver.ie.driver", IE_Browser);

			// Chamada para o Browser e o Site
			driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Escrevendo no Console
			System.out.println("Abrir o Browser - IE");

			break;
		case "Edge":
			// SETUP do Browser IE
			String Edge_Browser = Dados_Windows.Browser_Edge;
			System.setProperty("webdriver.edge.driver", Edge_Browser);

			// Chamada para o Browser e o Site
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Escrevendo no Console
			System.out.println("Abrir o Browser - Edge");

			break;
		case "Safari":
			// SETUP do Browser IE
			// String Safari_Browser = Dados.Browser_Safari;
			System.setProperty("webdriver.safari.driver", "true");
			// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Chamada para o Browser e o Site
			driver = new SafariDriver();

			// Escrevendo no Console
			System.out.println("Abrir o Browser - Safari");

			break;
		default:

			// Escrevendo no Console
			System.out.println("ERROR - Nenhum Browser encontrado");

			// Tirando SnapShot
			TakeScreenshot("Erro", "ErroAbrirBrowser");

			break;
		}
	}

	public static String TakeScreenshot(String Resultado, String nameImage) throws Exception {
		
		// Coloando as variaveis fora do switch
		String PATH = null;
		String Arquivo = null;
		File directory;
		DateFormat dateFormat_pasta;
		DateFormat dateFormat_arquivo;
		Date date;

		switch (Resultado) {
		case "Sucesso":

			// Escrevendo no Console
			System.out.println("Screenshot com Sucesso");

			// Formatando a Data
			dateFormat_pasta = new SimpleDateFormat("dd_MM_yyyy");
			dateFormat_arquivo = new SimpleDateFormat("yyyy_MM_dd_HH_mm");

			// Chamando a Data
			date = new Date();

			// System.out.println(dateFormat.format(date));

			// Informando o diretorio
			PATH = "C:\\Selenium WebDriver\\Reports\\ScreenShot\\ZaterCapital\\" + dateFormat_pasta.format(date) + "\\Sucesso\\";
			
			// Informando o arquivo
			directory = new File(PATH);

			if (!directory.exists()) // Condicao verificando o diretorio
			{

				// Comando que cria o diretorio
				directory.mkdirs();
				// Funcao para tirar o Screenshot
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile,
						new File(PATH + nameImage + "_" + dateFormat_arquivo.format(date) + ".jpg"));
				Arquivo = new String(PATH + nameImage + "_" + dateFormat_arquivo.format(date) + ".jpg");

			} else {

				// Funcao para tirar o Screenshot
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile,
						new File(PATH + nameImage + "_" + dateFormat_arquivo.format(date) + ".jpg"));
				Arquivo = new String(PATH + nameImage + "_" + dateFormat_arquivo.format(date) + ".jpg");

			}
			break;
		case "Erro":

			// Escrevendo no Console
			System.out.println("Screenshot com Sucesso do Erro");

			// Formatando a Data
			dateFormat_pasta = new SimpleDateFormat("dd_MM_yyyy");
			dateFormat_arquivo = new SimpleDateFormat("yyyy_MM_dd_HH_mm");

			// Chamando a Data
			date = new Date();

			// System.out.println(dateFormat.format(date));

			// Informando o diretorio
			PATH = "C:\\Selenium WebDriver\\Reports\\ScreenShot\\ZaterCapital\\" + dateFormat_pasta.format(date) + "\\Erro\\";
			
			// Informando o arquivo
			directory = new File(PATH);

			if (!directory.exists()) // Condicao verificando o diretorio
			{

				// Comando que cria o diretorio
				directory.mkdirs();
				// Funcao para tirar o Screenshot
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				Files.copy(scrFile, new File(PATH + nameImage + "_" + dateFormat_arquivo.format(date) + ".jpg"));
				Arquivo = new String(PATH + nameImage + "_" + dateFormat_arquivo.format(date) + ".jpg");

			} else {

				// Funcao para tirar o Screenshot
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				Files.copy(scrFile, new File(PATH + nameImage + "_" + dateFormat_arquivo.format(date) + ".jpg"));
				Arquivo = new String(PATH + nameImage + "_" + dateFormat_arquivo.format(date) + ".jpg");

			}

			break;
		default:

			// Escrevendo no Console
			System.out.println("ERROR - Caminho não encontrado ou Screenshot não tirado");

			break;
		}
		return Arquivo.toString();
	}

	public static void HighLightElement(WebElement element) {

		// Funcao para Highligth

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
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			return true;
		} catch (Exception e) {
			try {
				driver.findElement(By.name(elemento)).isDisplayed();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				return true;
			} catch (Exception f) {
				try {
					driver.findElement(By.linkText(elemento)).isDisplayed();
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					return true;
				} catch (Exception g) {
					try {
						driver.findElement(By.xpath(elemento)).isDisplayed();
						driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
						return true;
					} catch (Exception h) {
						try {
							driver.findElement(By.className(elemento)).isDisplayed();
							driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
							return true;
						} catch (Exception i) {
							System.out.println(i.getMessage());
							return false;
						}
					}
				}
			}
		}
	}

	public static boolean IsElementSelected(String elemento) {
		try {
			driver.findElement(By.id(elemento)).isSelected();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			return true;
		} catch (Exception e) {
			try {
				driver.findElement(By.name(elemento)).isSelected();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				return true;
			} catch (Exception f) {
				try {
					driver.findElement(By.linkText(elemento)).isSelected();
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					return true;
				} catch (Exception g) {
					try {
						driver.findElement(By.xpath(elemento)).isSelected();
						driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
						return true;
					} catch (Exception h) {
						try {
							driver.findElement(By.className(elemento)).isSelected();
							driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
							return true;
						} catch (Exception i) {
							System.out.println(i.getMessage());
							return false;
						}
					}
				}
			}
		}
	}

	public static boolean IsElementEnabled(String elemento) {
		try {
			driver.findElement(By.id(elemento)).isEnabled();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			return true;
		} catch (Exception e) {
			try {
				driver.findElement(By.name(elemento)).isEnabled();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				return true;
			} catch (Exception f) {
				try {
					driver.findElement(By.linkText(elemento)).isEnabled();
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					return true;
				} catch (Exception g) {
					try {
						driver.findElement(By.xpath(elemento)).isEnabled();
						driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
						return true;
					} catch (Exception h) {
						try {
							driver.findElement(By.className(elemento)).isEnabled();
							driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
							return true;
						} catch (Exception i) {
							System.out.println(i.getMessage());
							return false;
						}
					}
				}
			}
		}
	}

	public static void SendKeys(Robot robot, String keys) {
		for (char c : keys.toCharArray()) {
			int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
			if (KeyEvent.CHAR_UNDEFINED == keyCode) {
				throw new RuntimeException("Key code not found for character '" + c + "'");
			}
			robot.keyPress(keyCode);
			robot.delay(100);
			robot.keyRelease(keyCode);
			robot.delay(100);
		}
	}
			
	public static void StartReport(String NomeArquivo){
		
		File directory;
		String PATH;
		
		// Informando o diretorio
		PATH = "C:\\Selenium WebDriver\\Reports\\Regressao\\";

		// Informando o diretorio
		directory = new File(PATH);
		
			if (!directory.exists()) // Condicao verificando o diretorio
			{
	
				// Comando que cria o diretorio
				directory.mkdirs();
				// Funcao para gerar o HTML
				htmlReporter = new ExtentHtmlReporter(PATH + NomeArquivo + ".html");
	
			} else {
	
				// Funcao para gerar o HTML
				htmlReporter = new ExtentHtmlReporter("C:\\Selenium WebDriver\\Reports\\Regressao\\" + NomeArquivo + ".html");
	
			}
				
		//htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/" + NomeArquivo + ".html");
		//htmlReporter = new ExtentHtmlReporter("C:/Reports/" + NomeArquivo + ".html");
		extent = new ExtentReports ();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Zater Capital");
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", "Automation");
		
		htmlReporter.config().setDocumentTitle("Regressão - Zater Capital");
		htmlReporter.config().setReportName("QA TEAM");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);

	}
	
	public static String Gauth(String QRCode_AccountName, String QRCode_SecretKey) throws Exception {
		
	// Chamando o Browser
	// SETUP do Browser Chrome
	String Chrome_Browser1 = Dados_Windows.Browser_Chrome;
	System.setProperty("webdriver.chrome.driver", Chrome_Browser1);

	// Chamada para o Browser e o Site
	WebDriver driver1 = new ChromeDriver();
	driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	// Escrevendo no Console
	System.out.println("Abrir o Browser - Chrome");
	
	String AccountName = new String (QRCode_AccountName);
	String SecretKey = new String (QRCode_SecretKey);
	
	String ReturnGoogleAuth = null;
	
	// Escrevendo no Console
	System.out.println(AccountName);
	System.out.println(SecretKey);
	
	// Chamando o Site e configurando o Browser  
	//driver.navigate().to("https://gauth.apps.gbraad.nl/#main");	// chamando o site
	driver1.get("https://gauth.apps.gbraad.nl/#main");
	//driver1.manage().window().maximize(); // maximizando o browser
	driver1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // esperando por até 20 segundos
	
	// Pegando as URLs
	String url_site = driver1.getCurrentUrl(); // URL atual
	String url_dados = "https://gauth.apps.gbraad.nl/#main"; // URL da class Dados

	/** Report Extent **/
	test.log(Status.INFO, "Site Validador do QRCode");
	test.log(Status.PASS, "Site Validador do QRCode - Aberto com Sucesso");	
	test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","QRCode-AbrirSiteValidadorQRComSucesso"));
	/** Report Extent **/

	// Escrevendo no Console
	System.out.println(url_site);
	System.out.println(url_dados);

	// Assert para verificar se as URLs sao iguais
	//assertEquals(url_dados, url_site);
	
	if (url_site.equals(url_dados)) {
		
		// Escrevendo no Console
		System.out.println("Pagina - Validador QRCode");

		/** Report Extent **/
		test.log(Status.PASS, "Pagina - Validador QRCode");
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","QRCode-PaginaValidadorQRCodeVisivel"));
		/** Report Extent **/
		
		// Buscar o elemento na página
		WebElement tabela = driver1.findElement(By.xpath("//*[@id='accounts']"));
		
		// Coloca o elemento em uma Lista
		List <WebElement> li = tabela.findElements(By.cssSelector("li"));
		
		// Escrevendo no Console 
		System.out.println("Linha: " + li.size());
		
		for (WebElement linha : li) { // Verifica quantos Elementos foram encontrados
				
			// Funcao HighLight
			//HighLightElement(linha);

			if (driver1.findElement(By.xpath("//*[@id='accounts']")).getAttribute("innerText").contains("ZaterX")) { // Condição para o Status
				
				// Buscar o elemento na página
				String texto = driver1.findElement(By.xpath("//*[@id='accounts']")).getAttribute("innerText");
				
				// Escrevendo no Console 
				System.out.println("Código1: " + texto);
				System.out.println("Código2: " + texto.toString());
				System.out.println("Código3: " + texto.toString().substring(45, 52));
				
				System.out.println("Código4: " + linha);
				
				
				ReturnGoogleAuth = new String (texto.toString().substring(45, 52));
				
				// Escrevendo no Console 
				System.out.println("GoogleAuth: " + ReturnGoogleAuth);
					
			} else {
				
				if (driver1.findElement(By.id("edit")).isDisplayed()) {
					
					// Buscar o elemento na página
					WebElement edit = driver1.findElement(By.id("edit"));
					
					// Clicando no Botão LOGAR
					edit.click();
					Thread.sleep(2000); // Espera 2 segundo
					
					// Escrevendo no Console 
					System.out.println("Clicar no Botão 'Editar'");
					
					/** Report Extent **/
					test.log(Status.PASS, "Clicar no Botão 'Editar'");
					test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","QRCode-ClickBotaoEditar"));
					/** Report Extent **/
					
					if (driver1.findElement(By.id("addButton")).isDisplayed()) {
						
						// Buscar o elemento na página
						WebElement add = driver1.findElement(By.id("addButton"));

						// Clicando no Botão LOGAR
						add.click();
						Thread.sleep(2000); // Espera 2 segundo
						
						// Escrevendo no Console 
						System.out.println("Clicar no Botão '+Add'");
						
						/** Report Extent **/
						test.log(Status.PASS, "Clicar no Botão '+Add'");
						test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","QRCode-ClickBotaoAdd"));
						/** Report Extent **/
						
						if (driver1.findElement(By.id("keyAccount")).isDisplayed()) {
							
							// Buscar o elemento na página
							WebElement keyAccount = driver1.findElement(By.id("keyAccount"));
							
							// Clicando no Botão LOGAR
							keyAccount.sendKeys(AccountName);
							Thread.sleep(2000); // Espera 2 segundo
							
							// Escrevendo no Console 
							System.out.println("Inserir AccountName");
							
							/** Report Extent **/
							test.log(Status.PASS, "Inserir AccountName");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","QRCode-InserirAccountName"));
							/** Report Extent **/
							
						} else {
							
							// Escrevendo no Console 
							System.out.println("Campo 'AccountName' - Não Visível");
							
							/** Report Extent **/
							test.log(Status.ERROR, "Campo 'AccountName' - Não Visível");
							test.addScreenCaptureFromPath(TakeScreenshot("Erro","QRCode-CampoAccountNameNaoVisivel"));
							/** Report Extent **/
							
						}
						
						if (driver1.findElement(By.id("keySecret")).isDisplayed()) {
							
							// Buscar o elemento na página
							WebElement keySecret = driver1.findElement(By.id("keySecret"));
							
							// Clicando no Botão LOGAR
							keySecret.sendKeys(SecretKey);
							Thread.sleep(2000); // Espera 2 segundo
							
							// Escrevendo no Console 
							System.out.println("Inserir SecretKey");
							
							/** Report Extent **/
							test.log(Status.PASS, "Inserir SecretKey");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","QRCode-InserirSecretKey"));
							/** Report Extent **/
							
						} else {
							
							// Escrevendo no Console 
							System.out.println("Campo 'SecretKey' - Não Visível");
							
							/** Report Extent **/
							test.log(Status.ERROR, "Campo 'SecretKey' - Não Visível");
							test.addScreenCaptureFromPath(TakeScreenshot("Erro","QRCode-CampoSecretKeyNaoVisivel"));
							/** Report Extent **/
							
						}
						
						if (driver1.findElement(By.id("addKeyButton")).isDisplayed()) {
							
							// Buscar o elemento na página
							WebElement addKeyButton = driver1.findElement(By.id("addKeyButton"));
							
							// Clicando no Botão LOGAR
							addKeyButton.click();
							Thread.sleep(2000); // Espera 2 segundo
							
							// Escrevendo no Console 
							System.out.println("Clicar no Botão '+Add'");
							
							/** Report Extent **/
							test.log(Status.PASS, "Clicar no Botão '+Add'");
							test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","QRCode-ClickBotaoAdd"));
							/** Report Extent **/
							
						} else {
							
							// Escrevendo no Console 
							System.out.println("Botão '+Add' - Não Visível");
							
							/** Report Extent **/
							test.log(Status.ERROR, "Botão '+Add' - Não Visível");
							test.addScreenCaptureFromPath(TakeScreenshot("Erro","QRCode-BotaoAddNaoVisivel"));
							/** Report Extent **/
							
						}
						
						
					} else {
						
						// Escrevendo no Console 
						System.out.println("Botão '+Add' - Não Visível");
						
						/** Report Extent **/
						test.log(Status.ERROR, "Botão '+Add' - Não Visível");
						test.addScreenCaptureFromPath(TakeScreenshot("Erro","QRCode-BotaoAddNaoVisivel"));
						/** Report Extent **/
						
					}
					
					
				} else {
					
					// Escrevendo no Console 
					System.out.println("Botão 'Editar' - Não Visível");
					
					/** Report Extent **/
					test.log(Status.ERROR, "Botão 'Editar' - Não Visível");
					test.addScreenCaptureFromPath(TakeScreenshot("Erro","QRCode-BotaoEditarNaoVisivel"));
					/** Report Extent **/
					
				}
				
			}
						
		}
		
	} else {
		
		// Escrevendo no Console
		System.out.println("Pagina - Validador QRCode Não Visível");

		/** Report Extent **/
		test.log(Status.ERROR, "Pagina - Validador QRCode Não Visível");
		test.addScreenCaptureFromPath(TakeScreenshot("Erro","QRCode-PaginaValidadorQRCodeNaoVisivel"));
		/** Report Extent **/
		
	}
	
	
	// Fechar o Browser
	driver1.close();
	
	return ReturnGoogleAuth;
	
	}
     	
	public static String Json (String URL) throws Exception {
		
		// Chamando o Browser
		// SETUP do Browser Chrome
		String Chrome_Browser_New = Dados_Windows.Browser_Chrome;
		System.setProperty("webdriver.chrome.driver", Chrome_Browser_New);

		// Chamada para o Browser e o Site
		WebDriver driver_new = new ChromeDriver();
		driver_new.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Escrevendo no Console
		System.out.println("Abrir o Browser - Chrome");
		
		// Variavel NULA
		String RetornoJson = null;
		
		// Chamando o Site e configurando o Browser  
		//driver.navigate().to("https://gauth.apps.gbraad.nl/#main");	// chamando o site
		driver_new.get(URL);
		//driver1.manage().window().maximize(); // maximizando o browser
		driver_new.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // esperando por até 20 segundos
		
		// Pegando as URLs
		String url_site = driver_new.getCurrentUrl(); // URL atual
		String url_dados = URL; // URL da class Dados

		/** Report Extent **/
		test.log(Status.INFO, "Site Json");
		test.log(Status.PASS, "Site Json - Aberto com Sucesso");	
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","Json-AbrirSiteJsonComSucesso"));
		/** Report Extent **/

		// Escrevendo no Console
		System.out.println(url_site);
		System.out.println(url_dados);

		if (url_site.equals(url_dados)) {
			
			// Escrevendo no Console
			System.out.println("Pagina - Json");

			/** Report Extent **/
			test.log(Status.PASS, "Pagina - Json");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","Json-PaginaJsonVisivel"));
			/** Report Extent **/
			
			// Buscar o elemento na página
			String informacao = driver_new.findElement(By.xpath("/html/body/pre")).getAttribute("textContent");		
			
			// Criando uma Váriavel
			RetornoJson = new String (informacao);
			
			// Escrevendo no Console 
			System.out.println("GoogleAuth: " + RetornoJson);
			System.out.println("GoogleAuth: " + RetornoJson.toString());
			
			/** Report Extent **/
			test.log(Status.PASS, "Retorno JSon: " + RetornoJson);	
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso","Json-RetornoJSon"));
			/** Report Extent **/
				
		} else {
			
			// Escrevendo no Console
			System.out.println("Pagina - Json");

			/** Report Extent **/
			test.log(Status.ERROR, "Pagina - Json");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro","Json-PaginaJsonVisivel"));
			/** Report Extent **/
						
		}
		
		// Fechar o Browser
		driver_new.close();
		
		// Return com a Variavel
		return RetornoJson;		
		
	}
	
	public static String RequestURL() throws IOException, Exception {
		
		// Inserir a URL
		String url = Dados_Windows.Homologacao_JSON;
		
		String ReturnURL = new String("");
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
		
		ReturnURL = new String(response.toString());
		
		return ReturnURL;
			
	}
	
	public static void Camera() throws IOException { // Não está em uso
		
		Webcam webcam = Webcam.getDefault();
		webcam.open();
		ImageIO.write(webcam.getImage(), "PNG", new File("C:\\Selenium WebDriver\\QRCode\\hello-world.png"));				
		webcam.close();
	}
		
	public static void QRCode1() throws Exception, NotFoundException, FileNotFoundException{ // Não está em uso
		 
		String code;
		//String imgPath = "C:\\Selenium WebDriver\\QRCode\\chart_prod.png";
		
		File file = new File("C:\\Selenium WebDriver\\QRCode\\chart_staging.png");

		//Create instance of Reader
		Reader reader = new MultiFormatReader();

		// Pass the image a parameter, which converts the image into binary bitmap
		InputStream barCodeIS = new FileInputStream(file);
		BufferedImage buffImage = ImageIO.read(barCodeIS);

		LuminanceSource lsrc = new BufferedImageLuminanceSource(buffImage);
		BinaryBitmap bitmapimg = new BinaryBitmap(new HybridBinarizer(lsrc));

		// Reader decodes the bitmap & extract the data
		Result result = reader.decode(bitmapimg);

		code = result.getText();
		System.out.println("Image Barcode / QR Code : " + code);
	
	}
	
	public static void QRCode2() throws Exception { // Não está em uso
		
		try {
			//File file = new File(TakeScreenshot("Sucesso", "QRCODE"));
			//File file = new File("C:\\Selenium WebDriver\\QRCode\\chart_prod.png");
			File file = new File("C:\\Selenium WebDriver\\QRCode\\chart_staging.png");
			String decodedText = decodeQRCode(file);
			if(decodedText == null) {
				System.out.println("No QR Code found in the image");
			} else {
				System.out.println("Decoded text = " + decodedText);
			}
		} catch (IOException e) {
			System.out.println("Could not decode QR Code, IOException :: " + e.getMessage());
		}
	}
	
	private static String decodeQRCode(File qrCodeimage) throws IOException { // Não está em uso

		BufferedImage bufferedImage = ImageIO.read(qrCodeimage);
		LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

		try {
			Result result = new MultiFormatReader().decode(bitmap);
			System.out.println("Image Barcode / QR Code : " + result.getText());
			return result.getText();
		} catch (NotFoundException e) {
			System.out.println("There is no QR code in the image");
			return null;
		}
	}

	public static void Zxing() throws Exception { // Não está em uso
	
	// SETUP do Browser Chrome
	String Chrome_Browser = Dados_Windows.Browser_Chrome;
	System.setProperty("webdriver.chrome.driver", Chrome_Browser);

	// Chamada para o Browser e o Site
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	// Escrevendo no Console
	System.out.println("Abrir o Browser - Chrome");
	
	// Chamando o Site e configurando o Browser  
	//driver.navigate().to(Dados.Producao_Site_ZaterCapital);	// chamando o site
	driver.get("https://zxing.org/w/decode.jspx");
	driver.manage().window().maximize(); // maximizando o browser
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // esperando por até 20 segundos

		
	// Fechar o Browser
	driver.close();
	
	}
	
}
			
	

// region ReproduzirAudio
/*
 * public void ReproduzirAudio (String speak) { // Fun��o para reproduzir o
 * audio Synthesizer reproducao = new Synthesizer(); reproducao.speak(speak,
 * null); }
 */
// endregion
