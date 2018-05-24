package Funcional;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import Utilitarios.Dados;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TC00001_SmartLink_Android {

	//AndroidDriver driver;
	public static DesiredCapabilities capacidade;	
	public static AndroidDriver<WebElement> driver; // Deixando a variavel driver publica
	
	@Before
	public void AbrirBrowserAndroid() throws MalformedURLException, InterruptedException {
		
		capacidade = new DesiredCapabilities();
		
		// Capacidade de inicializacao da app
		DesiredCapabilities capacidade = new DesiredCapabilities();
		capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, "MobilePlatform.ANDROID");
		capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capacidade.setCapability(MobileCapabilityType.PLATFORM_VERSION,"6.0");
		
		//capacidade.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		//capacidade.setCapability("app", "Deca Smart Link");
		capacidade.setCapability("appPackage", "android.widget.TextView[@index='3']");
		//capacidade.setCapability("appActivity", "MainActivity);		
		
		// LocalHost
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		
		// Abrindo a conexao com o servidor APPIUM
		driver = new AndroidDriver<WebElement>(url,capacidade);
		//driver.get(Dados.Producao_Site_SmartLink);
		//driver.navigate().to(Dados.Producao_Site_SmartLink);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
	}
	
	@After
	public void FecharBrowser() {
		
		driver.close();
		
	}

	
	@Ignore
	@Test
	public void Login() throws Exception {
		
		// Buscar o elemento no app
		WebElement botaoEntrar = driver.findElement(By.id("walkthrough_buttonentrar"));
		//WebElement botaoEntrar = driver.findElement(By.xpath("//android.view.View[@content-desc='Entrar'"))	
		//WebElement botaoEntrar = driver.findElementByXPath("//android.widget.TextView[@index='3']));
		//WebElement botaoEntrar = driver.findElement(By.xpath("//android.widget.RelativeLayout[@clickable='true']")).click();
		
		//
		Thread.sleep(1000); // esperar 1 segundo
		
		// Clicar no Botão "Entrar"
		botaoEntrar.click();
			
		// Escrevendo no Console
		System.out.println("Entrar");
		
		
		
		// Buscar o elemento no app
		WebElement campoLogin = driver.findElement(By.id("login_page_mail"));
		Thread.sleep(1000); // esperar 1 segundo
		
		// Digita o valor
		campoLogin.sendKeys(Dados.Producao_Usuario_SmartLink);
			
		// Escrevendo no Console
		System.out.println("Usuário informado");
		
		
		// Buscar o elemento no app
		WebElement campoPass = driver.findElement(By.id("login_page_pass"));
		Thread.sleep(1000); // esperar 1 segundo
		
		// Digita o valor
		campoPass.sendKeys(Dados.Producao_Senha_SmartLink);
			
		// Escrevendo no Console
		System.out.println("Senha informado");
		
		
		// Buscar o elemento no app
		WebElement botaoLogin = driver.findElement(By.id("login_button"));
		Thread.sleep(1000); // esperar 1 segundo
		
		// Digita o valor
		botaoLogin.click();
		
		
		Thread.sleep(40000); // esperar 40 segundo
			
		// Escrevendo no Console
		System.out.println("Click");
		
	}
	

	@Test
	public void LoginHomeLink() throws Exception {
		
		// Buscar o elemento no app
		//WebElement botaoEntrar = driver.findElement(By.id("walkthrough_buttonentrar"));
		//WebElement botaoEntrar = driver.findElement(By.xpath("//android.view.View[@content-desc='Entrar'"))	
		WebElement logo = driver.findElement(By.xpath("//android.widget.TextView[@index='3']"));
		//WebElement botaoEntrar = driver.findElement(By.xpath("//android.widget.RelativeLayout[@clickable='true']")).click();
		Thread.sleep(1000); // esperar 1 segundo
		
		logo.click();
		Thread.sleep(1000); // esperar 1 segundo
		
		
		// Buscar o elemento no app
		WebElement campoLogin = driver.findElement(By.id("login_page_mail"));
		Thread.sleep(1000); // esperar 1 segundo
		
		// Digita o valor
		campoLogin.sendKeys(Dados.Producao_Usuario_SmartLink);
			
		// Escrevendo no Console
		System.out.println("Usuário informado");
		
		
		// Buscar o elemento no app
		WebElement campoPass = driver.findElement(By.id("login_page_pass"));
		Thread.sleep(1000); // esperar 1 segundo
		
		// Digita o valor
		campoPass.sendKeys(Dados.Producao_Senha_SmartLink);
			
		// Escrevendo no Console
		System.out.println("Senha informado");
		
		
		// Buscar o elemento no app
		WebElement botaoLogin = driver.findElement(By.id("login_button"));
		Thread.sleep(1000); // esperar 1 segundo
		
		// Digita o valor
		botaoLogin.click();
		
		
		Thread.sleep(40000); // esperar 40 segundo
			
		// Escrevendo no Console
		System.out.println("Click");
		
	}
		

	
}
