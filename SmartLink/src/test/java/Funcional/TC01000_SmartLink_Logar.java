package Funcional;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.aventstack.extentreports.Status;

import Utilitarios.Dados;
import Utilitarios.FuncoesReusaveis;
import PagesObjects.PageObject_Login;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TC01000_SmartLink_Logar extends FuncoesReusaveis {
	
	@Before
	public void AbrirBrowser() throws Exception {
			
		// Iniciar o Browser e Informar a URL
		InitBrowser("Chrome", Dados.Producao_Site_SmartLink);
		
	}

	
	@Test
	public void TC01001_Logar_Sucesso() throws Exception {
		
		
		/** Report Extent **/
		StartReport("TC01001_Logar_Sucesso_TestResult");
		CreateTestCaseAndCategoryReport("TC01001_Logar_Sucesso","Funcional","Positivo");
		test.log(Status.PASS, "Site Aberto com Sucesso");
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "Site-AbertoComSucesso"));
		/** Report Extent **/	
			
		
		/** Steps do TestCase **/
		
		PageObject_Login.CampoUsuario(Dados.Producao_Usuario_SmartLink);
		PageObject_Login.CampoSenha(Dados.Producao_Senha_SmartLink);
		PageObject_Login.ButtonEntrar();	
		PageObject_Login.CheckLoginSucess();
				
		/** Steps do TestCase **/		
		
		
		/** Report Extent **/
		StopReport();
		/** Report Extent **/
				
	}

	@Ignore
	@Test
	public void CT01002_Logar_Falha() throws Exception {
		
		/** Report Extent **/
		StartReport("CT01002_Logar_Falha_TestResult");
		CreateTestCaseAndCategoryReport("CT01002_Logar_Falha","Funcional","Positivo");
		test.log(Status.PASS, "Site Aberto com Sucesso");
		test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "Site-AbertoComSucesso"));
		/** Report Extent **/	
			
		
		/** Steps do TestCase **/
		
		PageObject_Login.CampoUsuario("");
		PageObject_Login.CampoSenha("");
		PageObject_Login.ButtonEntrar();	
		PageObject_Login.CheckLoginSucess();
				
		/** Steps do TestCase **/		
		
		
		/** Report Extent **/
		StopReport();
		/** Report Extent **/
				
	}

	
	@After
	public void FecharBrowser() throws Exception {
		
		// Encerrar o Browser
		CloseBrowser();
		
	}

	
	
}
