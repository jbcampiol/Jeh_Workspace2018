package Funcional;
import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AbrirApp {
	
	//AndroidDriver driver;
	public static DesiredCapabilities capacidade;	
	public static AndroidDriver<WebElement> driver; // Deixando a variavel driver publica

	@Before
	public void preCondicao() throws MalformedURLException, InterruptedException {
		
		capacidade = new DesiredCapabilities();
		
		// Caminho do Aplicativo
		//File diretorioAplicacao = new File("C:\\app\triangulo");
		//File diretorioAplicacao = new File("C:\\Users\\jefferson.campiol.WKBRAZIL\\Desktop\\WorkSpace_Eclipse\\ProjectAppium");
		//File arquivoAplicacao = new File(diretorioAplicacao, "TrianguloApp.apk");
		
		// Capacidade de inicializacao da app
		DesiredCapabilities capacidade = new DesiredCapabilities();
		capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, "MobilePlatform.ANDROID");
		capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "device"); //"AVD_for_Galaxy_Nexus_by_Google"
		capacidade.setCapability(MobileCapabilityType.PLATFORM_VERSION,"6.0");
		//capacidade.setCapability(MobileCapabilityType.APP, arquivoAplicacao.getAbsolutePath());
		//capacidade.setCapability(MobileCapabilityType.APP, "com.eliasnogueira.trianguloapp");
		
		//capacidade.setCapability("appPackage", "com.eliasnogueira.trianguloapp");
		//capacidade.setCapability("appActivity", "MainActivity");
		
		// Capacidade de inicializacao da app
		//DesiredCapabilities capacidade = new DesiredCapabilities();
		//capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, "MobilePlatform.ANDROID");
		//capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "device");		
		//capacidade.setCapability(MobileCapabilityType.PLATFORM_VERSION,"4.4.4");
		//adb devices
		//capacidade.setCapability(MobileCapabilityType.UDID, "169.254.109.177:5555");
		//capacidade.setCapability(MobileCapabilityType.UDID, "AVD_for_Galaxy_Nexus_by_Google:5554");
		
		
		capacidade.setCapability("appPackage", "com.android.calculator2");
		capacidade.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		
		//capacidade.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
		
		// URL
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		
		// Abri a conexao com o servidor
		driver = new AndroidDriver<WebElement>(url,capacidade);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capacidade);
		//Thread.sleep(1000); // esperar 1 segundo
		
	}
	
	
	@Test
	public void Triangulo() throws MalformedURLException, InterruptedException {
						
		// Buscar o elemento no app
		WebElement campo_lado1 = driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/txtLado1"));
		Thread.sleep(1000); // esperar 1 segundo
		
		// Digita o valor
		campo_lado1.sendKeys("3");
			
		// Escrevendo no Console
		System.out.println("Elemento Campo Lado1 Informado");
		
		//
		driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/txtLado2")).sendKeys("3");
		Thread.sleep(1000); // esperar 1 segundo
		
		//
		driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/txtLado3")).sendKeys("3");
		Thread.sleep(1000); // esperar 1 segundo

		//
		driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/btnCalcular")).click();
		Thread.sleep(1000); // esperar 1 segundo
		
		//
		Thread.sleep(1000); // esperar 1 segundo
		assertEquals("O tri�ngulo � Equil�tero",

				driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/txtResultado")).getText());
	
	}
	
	@After

	public void posCondicao() throws InterruptedException {

		Thread.sleep(1000); // esperar 1 segundo
		driver.quit();
		
		System.out.println("Fechar App");

	}
	
}
