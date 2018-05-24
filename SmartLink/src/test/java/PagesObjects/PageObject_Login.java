package PagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import Utilitarios.FuncoesReusaveis;

public class PageObject_Login extends FuncoesReusaveis {

	public static void CampoUsuario(String Usuario) throws Exception {

		if (IsElementPresent("loginContainer")) {
			
			// Escrevendo no Console
			System.out.println("LoginPage - Formulário de Login está Visível");

			/** Report Extent **/
			test.log(Status.PASS, "LoginPage - Formulário de Login está Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CampoUsuario-FormularioVisivel"));
			/** Report Extent **/			

			if (IsElementPresent("login_page_mail")) {

				// Procurando o Elemento
				WebElement Login = driver.findElement(By.id("login_page_mail"));

				// Funcao HighLight
				HighLightElement(Login);

				// Digitando o Usuário
				Login.sendKeys(Usuario);
				Thread.sleep(1000); // Espera 1 segundo

				// Escrevendo no Console
				System.out.println("LoginPage - Usuário Informado");
				System.out.println("Usuário: " + Usuario);

				/** Report Extent **/
				test.log(Status.PASS, "LoginPage - Usuário Informado");
				test.log(Status.PASS, "Usuário: " + Usuario);
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CampoUsuario-InformadoComSucesso"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("LoginPage - Usuário Não Informado");

				/** Report Extent **/
				test.log(Status.ERROR, "LoginPage - Usuário Não Informado");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CampoUsuario-NaoInformado"));
				/** Report Extent **/

			}

		} else {
			
			// Escrevendo no Console
			System.out.println("LoginPage - Formulário de Login Não está Visível");

			/** Report Extent **/
			test.log(Status.ERROR, "LoginPage - Formulário de Login Não está Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CampoUsuario-FormularioNaoVisivel"));
			/** Report Extent **/	
			
		}
	}
	
	public static void CampoSenha(String Senha) throws Exception {

		if (IsElementPresent("loginContainer")) {

			// Escrevendo no Console
			System.out.println("LoginPage - Formulário de Login está Visível");

			/** Report Extent **/
			test.log(Status.PASS, "LoginPage - Formulário de Login está Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CampoUsuario-FormularioVisivel"));
			/** Report Extent **/

			if (IsElementPresent("login_page_pass")) {

				// Procurando o Elemento
				WebElement Password = driver.findElement(By.id("login_page_pass"));

				// Funcao HighLight
				HighLightElement(Password);

				// Digitando a Senha
				Password.sendKeys(Senha);
				Thread.sleep(1000); // Espera 1 segundo

				// Escrevendo no Console
				System.out.println("LoginPage - Senha Informada");
				System.out.println("Senha: " + Senha);

				/** Report Extent **/
				test.log(Status.PASS, "LoginPage - Senha Informada");
				test.log(Status.PASS, "Senha: " + Senha);
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CampoSenha-InformadoComSucesso"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("LoginPage - Senha Não Informada");

				/** Report Extent **/
				test.log(Status.ERROR, "LoginPage - Senha Não Informada");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CampoSenha-NaoInformado"));
				/** Report Extent **/

			}

		} else {

			// Escrevendo no Console
			System.out.println("LoginPage - Formulário de Login Não está Visível");

			/** Report Extent **/
			test.log(Status.ERROR, "LoginPage - Formulário de Login Não está Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CampoUsuario-FormularioNaoVisivel"));
			/** Report Extent **/

		}

	}

	public static void ButtonEntrar() throws Exception {

		if (IsElementPresent("loginContainer")) {

			// Escrevendo no Console
			System.out.println("LoginPage - Formulário de Login está Visível");

			/** Report Extent **/
			test.log(Status.PASS, "LoginPage - Formulário de Login está Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CampoUsuario-FormularioVisivel"));
			/** Report Extent **/

			if (IsElementPresent("login_button")) {

				// Procurando o Elemento
				WebElement ButtonLogar = driver.findElement(By.id("login_button"));

				// Funcao HighLight
				HighLightElement(ButtonLogar);

				// Clicando no Botão LOGAR
				ButtonLogar.click();
				Thread.sleep(2000); // Espera 2 segundo

				// Escrevendo no Console
				System.out.println("LoginPage - Acionando o Botão LOGAR");

				/** Report Extent **/
				test.log(Status.PASS, "LoginPage - Acionando o Botão LOGAR");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "ButtonEntrar-Acionado"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("LoginPage - Botão LOGAR Não Acionado");

				/** Report Extent **/
				test.log(Status.ERROR, "LoginPage - Botão LOGAR Não Acionado");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "ButtonEntrar-NaoAcionado"));
				/** Report Extent **/

			}
		} else {

			// Escrevendo no Console
			System.out.println("LoginPage - Formulário de Login Não está Visível");

			/** Report Extent **/
			test.log(Status.ERROR, "LoginPage - Formulário de Login Não está Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CampoUsuario-FormularioNaoVisivel"));
			/** Report Extent **/

		}

	}
	
	public static void CheckLoginSucess() throws Exception {
		
		if (IsElementPresent("header_containerweb_content") 
				&& driver.findElement(By.id("header_containerweb_content")).getAttribute("innerText").contains("Olá")) {
			
			// Escrevendo no Console
			System.out.println("Logado com Sucesso");

			/** Report Extent **/
			test.log(Status.PASS, "Logado com Sucesso");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CheckLoginSucess-LogadoComSucesso"));
			/** Report Extent **/
			
		} else {
			
			// Escrevendo no Console
			System.out.println("Falha ao Logar");

			/** Report Extent **/
			test.log(Status.FAIL, "Falha ao Logar");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CheckLoginSucess-FalhaAoLogar"));
			/** Report Extent **/	
			
		}
		
	}

	public static void ButtonCadastrarSe() throws Exception {
			
		if (IsElementPresent("login_forget_options_container")) {

			// Escrevendo no Console
			System.out.println("LoginPage - Botão de Cadastro está Visível");

			/** Report Extent **/
			test.log(Status.PASS, "LoginPage - Botão de Cadastro está Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "ButtonCadastrarSe-ButtonVisivel"));
			/** Report Extent **/

			if (IsElementPresent("//*[text()='Cadastre-se']")) {

				// Procurando o Elemento
				WebElement ButtonCadastrarSe = driver.findElement(By.xpath("//*[text()='Cadastre-se']"));

				// Funcao HighLight
				HighLightElement(ButtonCadastrarSe);

				// Clicando no Botão CADASTRAR-SE
				ButtonCadastrarSe.click();
				Thread.sleep(2000); // Espera 2 segundo

				// Escrevendo no Console
				System.out.println("LoginPage - Acionando o Botão CADASTRAR-SE");

				/** Report Extent **/
				test.log(Status.PASS, "LoginPage - Acionando o Botão CADASTRAR-SE");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "ButtonCadastrarSe-Acionado"));
				/** Report Extent **/

			} else {

				// Escrevendo no Console
				System.out.println("LoginPage - Botão CADASTRAR-SE Não Acionado");

				/** Report Extent **/
				test.log(Status.ERROR, "LoginPage - Botão CADASTRAR-SE Não Acionado");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "ButtonCadastrarSe-NaoAcionado"));
				/** Report Extent **/

			}
		} else {

			// Escrevendo no Console
			System.out.println("LoginPage - Botão de Cadastro Não está Visível");

			/** Report Extent **/
			test.log(Status.ERROR, "LoginPage - Botão de Cadastro Não está Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "ButtonCadastrarSe-ButtonNaoVisivel"));
			/** Report Extent **/

		}
		
		
	}
	
}
