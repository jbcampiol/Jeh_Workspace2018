package Duratex_Group.SmartLink;


import static org.junit.Assert.assertEquals;

import java.net.URL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestExternAplication {
	
	public static WiniumDriver driver;
	
	@Before
	public void AbrirPrograma() {
		
		/*
		 * try
	      {
	         //Runtime.getRuntime().exec("cmd.exe /c start winword.exe");
	         Runtime.getRuntime().exec("cmd.exe /c start calc.exe");
	      }
	      catch(IOException iOException)
	      {
	         iOException.printStackTrace();
	      }
	      
	      */
		
		DesktopOptions options = new DesktopOptions();
		//options.setApplicationPath("C:\\WINDOWS\\system32\\calc.exe");
		options.setApplicationPath("C:\\WINDOWS\\system32\\notepad.exe");
		  
		try{
			
			driver = new WiniumDriver(new URL("http://localhost:9999"),options);
			Thread.sleep(2000);
		   
		  }
		  	catch(Exception e){
		  	
		  		System.out.println(e.getMessage());
		  		
		  }
		
		 }
		
	@Ignore
	@Test
	public void Calculadora() throws Exception {
		
		
		WebElement numero0 = driver.findElement(By.id("num0Button"));
		numero0.click();
		
		WebElement multiplicador = driver.findElement(By.id("multiplyButton"));
		multiplicador.click();
		
		WebElement numero3 = driver.findElement(By.id("num3Button"));
		numero3.click();
		
		WebElement igual = driver.findElement(By.id("equalButton"));
		igual.click();
		
		Thread.sleep(2000);
		
        Assert.assertTrue("0", driver.findElement(By.id("CalculatorResults")).isDisplayed());
        
        System.out.println(driver.findElement(By.id("CalculatorResults")).isDisplayed());
	
        
		assertEquals("Exibição é 0",

				driver.findElement(By.id("CalculatorResults")).getAttribute("Name"));
		
		System.out.println(driver.findElement(By.id("CalculatorResults")).getAttribute("Name"));
        
		driver.close();
		
	}
	
	@Test
	public void NotePad() throws Exception {
		
		driver.findElementByClassName("Edit").sendKeys("This is sample test");
		Thread.sleep(2000);
		
		driver.findElementById("CommandButton_7").click();
			
		System.out.println("Finalizado");
		
		driver.close();
		
		
		
	}
	
	@Ignore
	@Test
	public void FecharPrograma() throws Exception {
		
		//driver.quit();
		driver.close();
		
		//driver.findElementById("CommandButton_7").click();
		
	}
	
	
	
	
}
