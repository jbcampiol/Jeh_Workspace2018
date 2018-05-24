package Runner;

import PagesObjects.PageObject_Login;
import Utilitarios.Dados;
import Utilitarios.FuncoesReusaveis;

public class TestApplication {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		/** Report Extent **/
		FuncoesReusaveis.StartReport("TC01000_SmartLink_Logar_TestResult");
		FuncoesReusaveis.CreateTestCaseAndCategoryReport("STP01001_Logar_Sucesso","Funcional","Positivo");
		/** Report Extent **/			
		
		/** Steps do TestCase **/
		
		// Iniciar o Browser e Informar a URL
		FuncoesReusaveis.InitBrowser("Chrome", Dados.Producao_Site_SmartLink);
		
		// Página de Login
		PageObject_Login.CampoUsuario(Dados.Producao_Usuario_SmartLink);
		PageObject_Login.CampoSenha(Dados.Producao_Senha_SmartLink);
		PageObject_Login.ButtonEntrar();	
		PageObject_Login.CheckLoginSucess();
		
		// Encerrar o Browser
		FuncoesReusaveis.CloseBrowser();
		
		/** Steps do TestCase **/		
		
		/** Report Extent **/
		FuncoesReusaveis.StopReport();
		/** Report Extent **/
		
	}

}
