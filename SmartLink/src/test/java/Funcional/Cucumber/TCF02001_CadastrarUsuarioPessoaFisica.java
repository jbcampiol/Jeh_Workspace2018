package Funcional.Cucumber;

import PagesObjects.PageObject_Login;
import PagesObjects.PageObject_Signup;
import Utilitarios.Dados;
import Utilitarios.FuncoesReusaveis;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class TCF02001_CadastrarUsuarioPessoaFisica extends FuncoesReusaveis {
		
	@Given("^um usuario do tipo Pessoa Fisica na Tela de Cadastro do Sistema SmartLink$")
	public void um_usuario_do_tipo_Pessoa_Fisica_na_Tela_de_Cadastro_do_Sistema_SmartLink() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		/** Report Extent **/
		StartReport("TCF02001_CadastrarUsuarioPessoaFisica_TestResult");
		CreateTestCaseAndCategoryReport("TCF02001_CadastrarUsuarioPessoaFisica","Funcional","Positivo");
		/** Report Extent **/	
		
		InitBrowser("Chrome", Dados.Producao_Site_SmartLink);
		PageObject_Login.ButtonCadastrarSe();
		PageObject_Signup.CheckSignupPage();
		
	}

	@Given("^marcar o RadioButton PESSOAFISICA$")
	public void marcar_o_RadioButton_PESSOAFISICA() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		PageObject_Signup.CheckBoxPessoaFisica();	
		
	}

	@When("^informar os dados \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" e \"([^\"]*)\" na Tela de Cadastro$")
	public void informar_os_dados_e_na_Tela_de_Cadastro(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
					
		PageObject_Signup.CampoNomeCompleto(arg1);
		PageObject_Signup.CampoCPF(arg2);
		PageObject_Signup.CampoCEPPessoaFisica(arg3);	
		PageObject_Signup.CampoNumeroPessoaFisica(arg4);
		PageObject_Signup.CampoComplementoPessoaFisica(arg5);
		PageObject_Signup.CampoTelefoneContatoPessoaFisica(arg6);
		PageObject_Signup.CampoEmailPessoaFisica(arg7);
		PageObject_Signup.CampoSenhaPessoaFisica(arg8);
		PageObject_Signup.CampoConfirmarSenhaPessoaFisica(arg9);		
		
	}

	@When("^marcar a opcao TERMOS_USO para o usuario fisico$")
	public void marcar_a_opcao_TERMOS_USO_para_o_usuario_fisico() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		PageObject_Signup.CheckTermosPessoaFisica();		
		
	}

	@When("^acionar o Botao CONCLUIR_MEU_CADASTRO para o usuario fisico$")
	public void acionar_o_Botao_CONCLUIR_MEU_CADASTRO_para_o_usuario_fisico() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		PageObject_Signup.ButtonConcluirPessoaFisica();
		
	}

	@Then("^o sistema deve permitir o cadastramento do usuario com sucesso e redirecionar o usuario para a Tela de LOGIN\\.$")
	public void o_sistema_deve_permitir_o_cadastramento_do_usuario_com_sucesso_e_redirecionar_o_usuario_para_a_Tela_de_LOGIN() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		PageObject_Signup.CheckConfirmacaoCadastro();
		CloseBrowser();
		
		/** Report Extent **/
		StopReport();
		/** Report Extent **/	
		
	}

}
