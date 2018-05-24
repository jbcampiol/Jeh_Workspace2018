package Funcional;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import PagesObjects.PageObject_Configuracaoes;
import PagesObjects.PageObject_Dashboard;
import PagesObjects.PageObject_Login;
import PagesObjects.PageObject_Painel;
import PagesObjects.PageObject_Signup;
import Utilitarios.Dados;
import Utilitarios.FuncoesReusaveis;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TC00001_SmartLink extends FuncoesReusaveis {

	
	@Before
	public void AbrirBrowser() throws Exception {
			
		// Iniciar o Browser e Informar a URL
		InitBrowser("Chrome", Dados.Producao_Site_SmartLink);
		
	}
	
	@After
	public void FecharBrowser() throws Exception {
		
		// Encerrar o Browser
		CloseBrowser();
		
	}
	
	@Test
	public void TC00001_CadastrarUsuarioPessoaFisica() throws Exception {
		
		/** Report Extent **/
		StartReport("TC00001_SmartLink_TestResult");
		CreateTestCaseAndCategoryReport("TC00001_CadastrarUsuarioPessoaFisica","Funcional","Positivo");
		/** Report Extent **/		

		
		/** Steps do TestCase **/
		
		PageObject_Login.ButtonCadastrarSe();
		PageObject_Signup.CheckSignupPage();
		PageObject_Signup.CheckBoxPessoaFisica();		
		PageObject_Signup.CampoNomeCompleto("Jefferson Barbieri Campiol");
		PageObject_Signup.CampoCPF("33777302813");
		PageObject_Signup.CampoCEPPessoaFisica("13280268");	
		PageObject_Signup.CampoNumeroPessoaFisica("116");
		PageObject_Signup.CampoComplementoPessoaFisica("Bairro 1234");
		PageObject_Signup.CampoTelefoneContatoPessoaFisica("19992524666");
		PageObject_Signup.CampoEmailPessoaFisica("jefferson.campiol@fcamara.com.br");
		PageObject_Signup.CampoSenhaPessoaFisica("1234@4321");
		PageObject_Signup.CampoConfirmarSenhaPessoaFisica("1234@4321");
		PageObject_Signup.CheckTermosPessoaFisica();
		PageObject_Signup.ButtonConcluirPessoaFisica();
		PageObject_Signup.CheckConfirmacaoCadastro();
						
		/** Steps do TestCase **/		
		
	}
	
	@Test
	public void TC00002_CadastrarUsuarioPessoaJuridica() throws Exception {
		
		/** Report Extent **/
		//StartReport("TC02002_CadastrarUsuarioPessoaJuridica_TestResult");
		CreateTestCaseAndCategoryReport("TC00002_CadastrarUsuarioPessoaJuridica","Funcional","Positivo");
		/** Report Extent **/		

		
		/** Steps do TestCase **/
		
		PageObject_Login.ButtonCadastrarSe();
		PageObject_Signup.CheckSignupPage();
		PageObject_Signup.CheckBoxPessoaJuridica();	
		PageObject_Signup.CampoRazaoSocial("Testes Automatizados LTDA");
		PageObject_Signup.CampoCNPJ("40217414000191");
		PageObject_Signup.CampoSegmento("Hotelaria");
		PageObject_Signup.CampoCEPPessoaJuridica("13280268");
		PageObject_Signup.CampoNumeroPessoaJuridica("116");
		PageObject_Signup.CampoComplementoPessoaJuridica("1234567890 0987654321");
		PageObject_Signup.CampoTelefoneContatoPessoaJuridica("11992345678");
		PageObject_Signup.CampoNomeGestor("Jefferson B Campiol");
		PageObject_Signup.CampoEmailPessoaJuridica("automacao@fcamara.com.br");
		PageObject_Signup.CampoSenhaPessoaJuridica("1234@4321");
		PageObject_Signup.CampoConfirmarSenhaPessoaJuridica("1234@43");
		PageObject_Signup.CheckTermosPessoaJuridica();
		PageObject_Signup.ButtonConcluirPessoaJuridica();
		PageObject_Signup.CheckConfirmacaoCadastro();
				
		/** Steps do TestCase **/		
		
	}
	
	@Test
	public void TC00003_NavegacaoDashboard() throws Exception {
		
		
		/** Report Extent **/
		//StartReport("TC03000_SmartLink_SelecaoContexto_TestResult");
		CreateTestCaseAndCategoryReport("TC00003_NavegacaoDashboard","Funcional","Positivo");
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
	public void TC00004_SelecaoContexto() throws Exception {
		
		
		/** Report Extent **/
		//StartReport("TC03001_SelecaoContexto_TestResult");
		CreateTestCaseAndCategoryReport("TC00004_SelecaoContexto","Funcional","Positivo");
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
	
}
