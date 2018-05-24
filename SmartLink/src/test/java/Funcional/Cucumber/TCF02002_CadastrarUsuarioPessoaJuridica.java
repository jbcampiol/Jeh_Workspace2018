package Funcional.Cucumber;

import PagesObjects.PageObject_Login;
import PagesObjects.PageObject_Signup;
import Utilitarios.Dados;
import Utilitarios.FuncoesReusaveis;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class TCF02002_CadastrarUsuarioPessoaJuridica  extends FuncoesReusaveis {
	
	@Given("^um usuario do tipo Pessoa Juridica na Tela de Cadastro do Sistema SmartLink$")
	public void um_usuario_do_tipo_Pessoa_Juridica_na_Tela_de_Cadastro_do_Sistema_SmartLink() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		/** Report Extent **/
		StartReport("TCF02002_CadastrarUsuarioPessoaJuridica_TestResult");
		CreateTestCaseAndCategoryReport("TCF02002_CadastrarUsuarioPessoaJuridica","Funcional","Positivo");
		/** Report Extent **/	
		
		InitBrowser("Chrome", Dados.Producao_Site_SmartLink);
		PageObject_Login.ButtonCadastrarSe();
		PageObject_Signup.CheckSignupPage();		
		
	}

	@Given("^marcar o RadioButton PESSOAJURIDICA$")
	public void marcar_o_RadioButton_PESSOAJURIDICA() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		PageObject_Signup.CheckBoxPessoaFisica();	
		
	}

	@When("^informar os dados \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" e \"([^\"]*)\" na Tela de Cadastro$")
	public void informar_os_dados_e_na_Tela_de_Cadastro(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();

		PageObject_Signup.CampoRazaoSocial(arg1);
		PageObject_Signup.CampoCNPJ(arg2);
		PageObject_Signup.CampoSegmento(arg3);
		PageObject_Signup.CampoCEPPessoaJuridica(arg4);
		PageObject_Signup.CampoNumeroPessoaJuridica(arg5);
		PageObject_Signup.CampoComplementoPessoaJuridica(arg6);
		PageObject_Signup.CampoTelefoneContatoPessoaJuridica(arg7);
		PageObject_Signup.CampoNomeGestor(arg8);
		PageObject_Signup.CampoEmailPessoaJuridica(arg9);
		PageObject_Signup.CampoSenhaPessoaJuridica(arg10);
		PageObject_Signup.CampoConfirmarSenhaPessoaJuridica(arg11);
			
	}

	@When("^marcar a opcao TERMOS_USO para o usuario juridico$")
	public void marcar_a_opcao_TERMOS_USO_para_o_usuario_juridico() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		PageObject_Signup.CheckTermosPessoaFisica();
		
	}
	
	@When("^acionar o Botao CONCLUIR_MEU_CADASTRO para o usuario juridico$")
	public void acionar_o_Botao_CONCLUIR_MEU_CADASTRO_para_o_usuario_juridico() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		PageObject_Signup.ButtonConcluirPessoaFisica();
		
	}
	
	@Then("^o sistema deve permitir o cadastramento do usuario juridico com sucesso e redirecionar o usuario para a Tela de LOGIN\\.$")
	public void o_sistema_deve_permitir_o_cadastramento_do_usuario_juridico_com_sucesso_e_redirecionar_o_usuario_para_a_Tela_de_LOGIN() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		PageObject_Signup.CheckConfirmacaoCadastro();
		CloseBrowser();
		
		/** Report Extent **/
		StopReport();
		/** Report Extent **/	
		
	}

}
