package Funcional.Cucumber;

import PagesObjects.PageObject_Dashboard;
import PagesObjects.PageObject_Login;
import PagesObjects.PageObject_Painel;
import Utilitarios.Dados;
import Utilitarios.FuncoesReusaveis;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TCF03001_SelecaoCotexto extends FuncoesReusaveis {
	
	@Given("^um usuario logado e ja com a instalacao e instanciacao do dispositovo IoT SmartLink realizado$")
	public void um_usuario_logado_e_ja_com_a_instalacao_e_instanciacao_do_dispositovo_IoT_SmartLink_realizado()
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();

		/** Report Extent **/
		StartReport("TCF03001_SelecaoCotexto_TestResult");
		CreateTestCaseAndCategoryReport("TCF03001_SelecaoLeitura", "Funcional", "Cucumber");
		/** Report Extent **/

		InitBrowser("Chrome", Dados.Producao_Site_SmartLink);
		PageObject_Login.CampoUsuario(Dados.Producao_Usuario_SmartLink);
		PageObject_Login.CampoSenha(Dados.Producao_Senha_SmartLink);
		PageObject_Login.ButtonEntrar();

	}

	@When("^acessar o Menu PAINEL$")
	public void acessar_o_Menu_PAINEL() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();

		PageObject_Dashboard.MenuPainel();

	}

	@When("^acionar o opção SELECAO DE LEITURA$")
	public void acionar_o_opção_SELECAO_DE_LEITURA() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();

		PageObject_Painel.PainelSelecaoLeitura();

	}

	@Then("^o sistema deve exibir a Tela CONFIGURACOES DE LOCAIS para que o usuario possa configurar o Local/Ambiente/Dispositivo IoT SmartLink$")
	public void o_sistema_deve_exibir_a_Tela_CONFIGURACOES_DE_LOCAIS_para_que_o_usuario_possa_configurar_o_Local_Ambiente_Dispositivo_IoT_SmartLink()
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();

		PageObject_Painel.PainelCheckConfiguracoesLocais();

	}

	@Given("^um usuario do sistema que está na Tela CONFIGURACOES DE LOCAIS$")
	public void um_usuario_do_sistema_que_está_na_Tela_CONFIGURACOES_DE_LOCAIS() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();

		/** Report Extent **/
		CreateTestCaseAndCategoryReport("TCF03001_SelecaoCotexto", "Funcional", "Cucumber");
		/** Report Extent **/
		
		PageObject_Painel.PainelCheckConfiguracoesLocais();
		
	}

	@When("^selecionar o Menu LOCAL$")
	public void selecionar_o_Menu_LOCAL() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		PageObject_Painel.PainelSelecaoLocal();
		
	}

	@When("^selecionar a Opção do LOCAL \"([^\"]*)\"$")
	public void selecionar_a_Opção_do_LOCAL(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		PageObject_Painel.PainelSelecaoOpcaoLocal(arg1);
		
	}

	@Then("^o sistema deve exibir o Menu AMBIENTE$")
	public void o_sistema_deve_exibir_o_Menu_AMBIENTE() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();	
		
		System.out.println("Menu Ambiente - Teste OK");
		
	}

	@When("^selecionar o Menu AMBIENTE$")
	public void selecionar_o_Menu_AMBIENTE() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		PageObject_Painel.PainelSelecaoAmbiente();
		
	}

	@When("^selecionar a Opção do AMBIENTE \"([^\"]*)\"$")
	public void selecionar_a_Opção_do_AMBIENTE(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		PageObject_Painel.PainelSelecaoOpcaoAmbiente(arg1);
		
	}

	@Then("^o sistema deve exibir o Menu DISPOSITIVO$")
	public void o_sistema_deve_exibir_o_Menu_DISPOSITIVO() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		System.out.println("Menu Dispositivo - Teste OK");
		
	}

	@When("^selecionar o Menu DISPOSITIVO$")
	public void selecionar_o_Menu_DISPOSITIVO() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
			
		PageObject_Painel.PainelSelecaoDispositivo();
		
	}

	@When("^selecionar a Opção DISPOSITIVO \"([^\"]*)\"$")
	public void selecionar_a_Opção_DISPOSITIVO(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		PageObject_Painel.PainelSelecaoOpcaoDispositivo(arg1);
		
	}

	@When("^acionor o Botao SALVAR CONFIGURACOES DE LOCAIS$")
	public void acionor_o_Botao_SALVAR_CONFIGURACOES_DE_LOCAIS() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		PageObject_Painel.ButtonSalvarConfiguracoes();
		
	}

	@When("^o sistema deve salvar com sucesso as configuracoes Local/Ambiente/Dispositivo$")
	public void o_sistema_deve_salvar_com_sucesso_as_configuracoes_Local_Ambiente_Dispositivo() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		PageObject_Painel.PainelCheckSelecaoContexto();
		
		PageObject_Painel.PainelSelecaoLeitura();
		
		/** Report Extent **/
		StopReport();
		/** Report Extent **/
		
	}
	
	
}
