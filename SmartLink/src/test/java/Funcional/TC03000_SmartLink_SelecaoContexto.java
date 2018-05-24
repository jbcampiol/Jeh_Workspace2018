package Funcional;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import PagesObjects.PageObject_Configuracaoes;
import PagesObjects.PageObject_Dashboard;
import PagesObjects.PageObject_Login;
import PagesObjects.PageObject_Painel;
import Utilitarios.Dados;
import Utilitarios.FuncoesReusaveis;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TC03000_SmartLink_SelecaoContexto extends FuncoesReusaveis {
	
	@Before
	public void AbrirBrowser() throws Exception {
			
		// Iniciar o Browser e Informar a URL
		InitBrowser("Chrome", Dados.Producao_Site_SmartLink);
		
	}
	
	
	@Ignore
	@Test
	public void TC03000_NavegacaoDashboard() throws Exception {
		
		
		/** Report Extent **/
		StartReport("TC03000_SmartLink_SelecaoContexto_TestResult");
		CreateTestCaseAndCategoryReport("TC03000_NavegacaoDashboard","Funcional","Positivo");
		/** Report Extent **/		

		
		/** Steps do TestCase **/
		
		PageObject_Login.CampoUsuario(Dados.Producao_Usuario_SmartLink);
		PageObject_Login.CampoSenha(Dados.Producao_Senha_SmartLink);
		PageObject_Login.ButtonEntrar();	
		PageObject_Login.CheckLoginSucess();

		
		PageObject_Dashboard.MenuPainel();
		PageObject_Dashboard.MenuDispositivos();
		PageObject_Dashboard.MenuAlarmes();
		PageObject_Dashboard.MenuConfiguracoes();
		PageObject_Dashboard.MenuInicio();
		
		
		PageObject_Dashboard.MenuConfiguracoes();
		PageObject_Configuracaoes.LogOut();
				
		/** Steps do TestCase **/
				
	}

	@Test
	public void TC03001_SelecaoContexto() throws Exception {
		
		
		/** Report Extent **/
		StartReport("TC03001_SelecaoContexto_TestResult");
		CreateTestCaseAndCategoryReport("TC03001_SelecaoContexto","Funcional","Positivo");
		/** Report Extent **/		

		
		/** Steps do TestCase **/
		
		PageObject_Login.CampoUsuario(Dados.Producao_Usuario_SmartLink);
		PageObject_Login.CampoSenha(Dados.Producao_Senha_SmartLink);
		PageObject_Login.ButtonEntrar();	
		PageObject_Login.CheckLoginSucess();
		

		PageObject_Dashboard.MenuPainel();
		PageObject_Painel.PainelSelecaoLeitura();	
		PageObject_Painel.PainelSelecaoLocal();
		PageObject_Painel.PainelSelecaoOpcaoLocal("Duratex paulista");	
		PageObject_Painel.PainelSelecaoAmbiente();
		PageObject_Painel.PainelSelecaoOpcaoAmbiente("Cozinha 10˚ andar - edit540");	
		PageObject_Painel.PainelSelecaoDispositivo();
		PageObject_Painel.PainelSelecaoOpcaoDispositivo("Torneira pia b392");
		PageObject_Painel.ButtonSalvarConfiguracoes();	
		
		
		PageObject_Dashboard.MenuConfiguracoes();
		PageObject_Configuracaoes.LogOut();
			
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
