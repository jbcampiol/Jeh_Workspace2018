package Funcional.Cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import Utilitarios.Dados;
import Utilitarios.FuncoesReusaveis;
import PagesObjects.PageObject_Login;

public class TCF01000_Logar extends FuncoesReusaveis {

	@Given("^usuario do Sistema SmartLink Deca, PJ ou PF$")
	public void usuario_do_Sistema_SmartLink_Deca_PJ_ou_PF() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		/** Report Extent **/
		StartReport("US01000_SmartLink_Logar_TestResult");
		CreateTestCaseAndCategoryReport("STP01001_Logar_Sucesso","Funcional","Cucumber");
		/** Report Extent **/			
		
		// Iniciar o Browser e Informar a URL
		InitBrowser("Chrome", Dados.Producao_Site_SmartLink);		
		
	}

	@When("^informar um \"([^\"]*)\" valido e uma \"([^\"]*)\" valida$")
	public void informar_um_valido_e_uma_valida(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		PageObject_Login.CampoUsuario(arg1);
		PageObject_Login.CampoSenha(arg2);
		
	}

	@When("^acionar o Botao de ENTRAR$")
	public void acionar_o_Botao_de_ENTRAR() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		PageObject_Login.ButtonEntrar();	
		
	}

	@Then("^o sistema deve permitir a autenticao do usuario no sistema SmartLink Deca$")
	public void o_sistema_deve_permitir_a_autenticao_do_usuario_no_sistema_SmartLink_Deca() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		PageObject_Login.CheckLoginSucess();
		
		// Encerrar o Browser
		CloseBrowser();
		
		/** Report Extent **/
		StopReport();
		/** Report Extent **/		
		
	}
	
}
