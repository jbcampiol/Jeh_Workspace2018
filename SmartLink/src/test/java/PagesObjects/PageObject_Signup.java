package PagesObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import Utilitarios.FuncoesReusaveis;

public class PageObject_Signup extends FuncoesReusaveis {

	public static void CheckSignupPage() throws Exception {
		
		if (IsElementPresent("signup_formcontainer")) {
			
			// Escrevendo no Console
			System.out.println("SignupPage está Visível");

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage está Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CheckSignupPage-FormularioVisivel"));
			/** Report Extent **/
			
		} else {
			
			// Escrevendo no Console
			System.out.println("SignupPage Não está Visível");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage Não está Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CheckSignupPage-FormularioNaoVisivel"));
			/** Report Extent **/	
			
		}
		
	}
	
	public static void ButtonConcluirPessoaFisica() throws Exception {
		
		if (IsElementPresent("//*[text()='Concluir meu cadastro']")) {

			// Buscar o elemento na página
			List <WebElement> buttonConcluirPessoaFisica = driver.findElements(By.xpath("//*[text()='Concluir meu cadastro']"));
			
			// Procurando o Elemento
			WebElement concluirCadastro = buttonConcluirPessoaFisica.get(1);
			
			// Funcao HighLight
			HighLightElement(concluirCadastro);

			// Click no Botão 'Concluir Cadastro'
			concluirCadastro.click();
			Thread.sleep(10000); // Espera 10 segundo

			// Escrevendo no Console
			System.out.println("SignupPage - Button 'Concluir meu cadastro' - Acionado com Sucesso");

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage - Button 'Concluir meu cadastro' - Acionado com Sucesso");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "buttonConcluir-AcionadoComSucesso"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("SignupPage - Button 'Concluir meu cadastro' - Não Acionado");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage - Button 'Concluir meu cadastro' - Não Acionado");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "buttonConcluir-NaoAcionado"));
			/** Report Extent **/

		}
		
	}
	
	public static void ButtonConcluirPessoaJuridica() throws Exception {
		
		if (IsElementPresent("//*[text()='Concluir meu cadastro']")) {

			// Buscar o elemento na página
			List <WebElement> buttonConcluirPessoaJuridica = driver.findElements(By.xpath("//*[text()='Concluir meu cadastro']"));
			
			// Procurando o Elemento
			WebElement concluirCadastro = buttonConcluirPessoaJuridica.get(0);
			
			// Funcao HighLight
			HighLightElement(concluirCadastro);

			// Click no Botão 'Concluir Cadastro'
			concluirCadastro.click();
			Thread.sleep(10000); // Espera 10 segundo

			// Escrevendo no Console
			System.out.println("SignupPage - Button 'Concluir meu cadastro' - Acionado com Sucesso");

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage - Button 'Concluir meu cadastro' - Acionado com Sucesso");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "buttonConcluir-AcionadoComSucesso"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("SignupPage - Button 'Concluir meu cadastro' - Não Acionado");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage - Button 'Concluir meu cadastro' - Não Acionado");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "buttonConcluir-NaoAcionado"));
			/** Report Extent **/

		}
		
	}
	
	public static void CheckConfirmacaoCadastro() throws Exception {
				
		// Pegando as URLs
		String GetURLSiteConfirmacaoCadastro = driver.getCurrentUrl(); // URL atual
		String URLSiteConfirmacaoCadastro = "https://iot.deca.com.br/validateaccount"; // URL da class Dados
		
		// Escrevendo no Console
		System.out.println(GetURLSiteConfirmacaoCadastro);
		System.out.println(URLSiteConfirmacaoCadastro);
		
		if (GetURLSiteConfirmacaoCadastro.equals(URLSiteConfirmacaoCadastro) && driver.findElement(By.xpath("//*[@id='Header_TitleContainer_web']")).getAttribute("textContent").contains("Confirmação de email")) {
		
			// Escrevendo no Console
			System.out.println("SignupPage - Cadastro realizado com Sucesso");

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage - Cadastro realizado com Sucesso");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CheckConfirmacaoCadastro-CadastroComSucesso"));
			/** Report Extent **/
			
			//"//*[@errormessage_bg']"
						
		} else {
			
			// Escrevendo no Console
			System.out.println("SignupPage - Cadastro Não realizado");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage - Cadastro Não realizado");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CheckConfirmacaoCadastro-CadastroNaoRealizado"));
			/** Report Extent **/
			
			if (IsElementPresent("errormessage_bg") && driver.findElement(By.id("errormessage_bg")).getAttribute("innerText").contains("ER_DUP_ENTRY")) {
				//ER_DUP_ENTRY: Duplicate entry 'jefferson.campiol@fcamara.com.br' for key 'unique_email'
				
				// Escrevendo no Console
				System.out.println("SignupPage - Imagem do Erro do Cadastro");

				/** Report Extent **/
				test.log(Status.PASS, "SignupPage - Imagem do Erro do Cadastro");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CheckConfirmacaoCadastro-ImagemErro"));
				/** Report Extent **/			
				
			} else {
				
				// Escrevendo no Console
				System.out.println("SignupPage - Imagem do Erro do Cadastro Não Tirada");

				/** Report Extent **/
				test.log(Status.PASS, "SignupPage - Imagem do Erro do Cadastro Não Tirad");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CheckConfirmacaoCadastro-ImagemErroSemSucesso"));
				/** Report Extent **/		
				
			}
			
		}
		
	}
	
	
	/** Pessoa Física */
	
	public static void CheckBoxPessoaFisica() throws Exception {

		if (IsElementPresent("signup_typeSelector_container")) {

			// Escrevendo no Console
			System.out.println("SignupPage - radioButton Pessoa Fisíca está Visível");

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage - radioButton Pessoa Fisíca está Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CheckBoxPessoaFisica-RadioButtonPessoaFisicaVisivel"));
			/** Report Extent **/

			if (IsElementPresent("signup_radio_icon_pf")) {
				
				// Procurando o Elemento
				//WebElement radioButton = driver.findElement(By.id("signup_radio_icon_pf"));
				WebElement radioButton = driver.findElement(By.xpath("//*[@id='signup_typeSelector_container']/div[2]"));
				
				//((JavascriptExecutor) driver).executeScript("arguments[0].click()", radioButton);
				//((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", radioButton);
				
				// Funcao HighLight
				HighLightElement(radioButton);
				
				// Clicando no radioButton Pessoa Fisíca
				radioButton.click();
				Thread.sleep(2000); // Espera 2 segundo		
				
				// Escrevendo no Console
				System.out.println("SignupPage - Pessoa Fisíca selecionado");

				/** Report Extent **/
				test.log(Status.PASS, "SignupPage - Pessoa Fisíca selecionado");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CheckBoxPessoaFisica-RadioButtonPessoaFisicaSelecionada"));
				/** Report Extent **/				
				
			} else {

				// Escrevendo no Console
				System.out.println("SignupPage - Pessoa Fisíca Não selecionada");

				/** Report Extent **/
				test.log(Status.FAIL, "SignupPage - Pessoa Fisíca Não selecionada");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CheckBoxPessoaFisica-RadioButtonPessoaFisicaNaoSelecionada"));
				/** Report Extent **/
			
			}

		} else {

			// Escrevendo no Console
			System.out.println("SignupPage - radioButton Pessoa Fisíca Não está Visível");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage - radioButton Pessoa Fisíca Não está Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CheckBoxPessoaFisica-RadioButtonPessoaFisicaNaoVisivel"));
			/** Report Extent **/
						
		}

	}
	
	public static void CampoNomeCompleto(String NomeCompleto) throws Exception {

		if (IsElementPresent("signup_pf_name")) {

			// Procurando o Elemento
			WebElement campoNomeCompleto = driver.findElement(By.id("signup_pf_name"));

			// Funcao HighLight
			HighLightElement(campoNomeCompleto);

			// Inserindo o Nome Completo do Usuário
			campoNomeCompleto.sendKeys(NomeCompleto);
			Thread.sleep(2000); // Espera 2 segundo

			// Escrevendo no Console
			System.out.println("SignupPage - Inserindo Nome do Usuário");
			System.out.println("Nome do Usuário: " + NomeCompleto);

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage - Inserindo Nome do Usuário");
			test.log(Status.PASS, "Nome do Usuário: " + NomeCompleto);
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CampoNomeCompleto-NomeCompletoUsuarioInserido"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("SignupPage - Campo Nome Completo Não Visivel");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage - Campo Nome Completo Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CampoNomeCompleto-NomeCompletoNaoVisivel"));
			/** Report Extent **/

		}

	}
	
	public static void CampoCPF(String CPF) throws Exception {

		if (IsElementPresent("signup_cpfnum")) {

			// Procurando o Elemento
			WebElement campoCPF = driver.findElement(By.id("signup_cpfnum"));

			// Funcao HighLight
			HighLightElement(campoCPF);

			// Inserindo o CPF
			campoCPF.sendKeys(CPF);
			Thread.sleep(2000); // Espera 2 segundo

			// Escrevendo no Console
			System.out.println("SignupPage - Inserindo o CPF");
			System.out.println("CPF: " + CPF);

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage - Inserindo o CPF");
			test.log(Status.PASS, "CPF: " + CPF);
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CampoCPF-CPFInserido"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("SignupPage - Campo CPF Não Visivel");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage - Campo CPF Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CampoCPF-CPFNaoVisivel"));
			/** Report Extent **/

		}

	}
	
	public static void CampoCEPPessoaFisica(String CEP) throws Exception {

		if (IsElementPresent("signup_cep_inputpf")) {

			// Procurando o Elemento
			WebElement campoCEPPessoaFisica = driver.findElement(By.id("signup_cep_inputpf"));

			// Funcao HighLight
			HighLightElement(campoCEPPessoaFisica);

			// Inserindo o CEP
			campoCEPPessoaFisica.sendKeys(CEP);
			Thread.sleep(2000); // Espera 2 segundo

			// Escrevendo no Console
			System.out.println("SignupPage - Inserindo o CEP Pessoa Física");
			System.out.println("CEP: " + CEP);

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage - Inserindo o CEP Pessoa Física");
			test.log(Status.PASS, "CEP: " + CEP);
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CampoCEP-CEPInserido"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("SignupPage - Campo CEP Pessoa Física Não Visivel");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage - Campo CEP Pessoa Física Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CampoCEP-CEPNaoVisivel"));
			/** Report Extent **/

		}

	}
		
	public static void CampoNumeroPessoaFisica(String Numero) throws Exception {

		if (IsElementPresent("signup_pfnum")) {

			// Procurando o Elemento
			WebElement campoNumeroPessoaFisica = driver.findElement(By.id("signup_pfnum"));

			// Funcao HighLight
			HighLightElement(campoNumeroPessoaFisica);

			// Inserindo o Número
			campoNumeroPessoaFisica.sendKeys(Numero);
			Thread.sleep(2000); // Espera 2 segundo

			// Escrevendo no Console
			System.out.println("SignupPage - Inserindo o Número da Residência da Pessoa Física");
			System.out.println("Número: " + Numero);

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage - Inserindo o Número da Residência da Pessoa Física");
			test.log(Status.PASS, "Número: " + Numero);
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CampoNumero-NumeroInserido"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("SignupPage - Campo Número da Residência da Pessoa Física Não Visivel");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage - Campo Número da Residência da Pessoa Física Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CampoNumero-NumeroNaoVisivel"));
			/** Report Extent **/

		}
	
	}

	public static void CampoComplementoPessoaFisica(String Complemento) throws Exception {

		if (IsElementPresent("signup_pf_complement")) {

			// Procurando o Elemento
			WebElement campoComplementoPessoaFisica = driver.findElement(By.id("signup_pf_complement"));

			// Funcao HighLight
			HighLightElement(campoComplementoPessoaFisica);

			// Inserindo o Complemento
			campoComplementoPessoaFisica.sendKeys(Complemento);
			Thread.sleep(2000); // Espera 2 segundo

			// Escrevendo no Console
			System.out.println("SignupPage - Inserindo o Complemento da Residência da Pessoa Física");
			System.out.println("Complemento: " + Complemento);

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage - Inserindo o Complemento da Residência da Pessoa Física");
			test.log(Status.PASS, "Complemento: " + Complemento);
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CampoComplemento-ComplementoInserido"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("SignupPage - Campo Complemento da Residência da Pessoa Física Não Visivel");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage - Campo Complemento da Residência da Pessoa Física Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CampoComplemento-ComplementoNaoVisivel"));
			/** Report Extent **/

		}
	
	}

	public static void CampoTelefoneContatoPessoaFisica(String TelefoneContado) throws Exception {

		if (IsElementPresent("signup_tel_inputPF")) {

			// Procurando o Elemento
			WebElement campoTelefoneContatoPessoaFisica = driver.findElement(By.id("signup_tel_inputPF"));

			// Funcao HighLight
			HighLightElement(campoTelefoneContatoPessoaFisica);

			// Inserindo o Telefone
			campoTelefoneContatoPessoaFisica.sendKeys(TelefoneContado);
			Thread.sleep(2000); // Espera 2 segundo

			// Escrevendo no Console
			System.out.println("SignupPage - Inserindo o Telefone de Contato da Pessoa Física");
			System.out.println("Telefone Contato: " + TelefoneContado);

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage - Inserindo o Telefone de Contato da Pessoa Física");
			test.log(Status.PASS, "Telefone Contato: " + TelefoneContado);
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CampoTelefoneContato-TelefoneContatoInserido"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("SignupPage - Campo Telefone de Contato da Pessoa Física Não Visivel");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage - Campo Telefone de Contato da Pessoa Física Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CampoTelefoneContato-TelefoneContatoNaoVisivel"));
			/** Report Extent **/

		}
	
	}

	public static void CampoEmailPessoaFisica(String Email) throws Exception {

		if (IsElementPresent("signup_emailpf")) {

			// Procurando o Elemento
			WebElement campoEmailPessoaFisica = driver.findElement(By.id("signup_emailpf"));

			// Funcao HighLight
			HighLightElement(campoEmailPessoaFisica);

			// Inserindo o E-Mail
			campoEmailPessoaFisica.sendKeys(Email);
			Thread.sleep(2000); // Espera 2 segundo

			// Escrevendo no Console
			System.out.println("SignupPage - Inserindo o E-Mail da Pessoa Física");
			System.out.println("E-Mail: " + Email);

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage - Inserindo o E-Mail da Pessoa Física");
			test.log(Status.PASS, "E-Mail: " + Email);
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CampoEMail-EMailInserido"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("SignupPage - Campo E-Mail da Pessoa Física Não Visivel");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage - Campo E-Mail da Pessoa Física Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CampoEMail-EMailNaoVisivel"));
			/** Report Extent **/

		}
	
	}

	public static void CampoSenhaPessoaFisica(String Senha) throws Exception {

		if (IsElementPresent("signup_pf_password")) {

			// Procurando o Elemento
			WebElement campoSenhaPessoaFisica = driver.findElement(By.id("signup_pf_password"));

			// Funcao HighLight
			HighLightElement(campoSenhaPessoaFisica);

			// Inserindo a Senha
			campoSenhaPessoaFisica.sendKeys(Senha);
			Thread.sleep(2000); // Espera 2 segundo

			// Escrevendo no Console
			System.out.println("SignupPage - Inserindo a Senha da Pessoa Física");
			System.out.println("Senha: " + Senha);

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage - Inserindo a Senha da Pessoa Física");
			test.log(Status.PASS, "Senha: " + Senha);
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CampoSenha-SenhaInserido"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("SignupPage - Campo Senha da Pessoa Física Não Visivel");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage - Campo Senha da Pessoa Física Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CampoSenha-SenhaNaoVisivel"));
			/** Report Extent **/

		}
	
	}

	public static void CampoConfirmarSenhaPessoaFisica(String ConfirmarSenha) throws Exception {

		if (IsElementPresent("signup_pf_passwordConfirmation")) {

			// Procurando o Elemento
			WebElement campoConfirmarSenhaPessoaFisica = driver.findElement(By.id("signup_pf_passwordConfirmation"));

			// Funcao HighLight
			HighLightElement(campoConfirmarSenhaPessoaFisica);

			// Inserindo o Confirmar Senha
			campoConfirmarSenhaPessoaFisica.sendKeys(ConfirmarSenha);
			Thread.sleep(2000); // Espera 2 segundo

			// Escrevendo no Console
			System.out.println("SignupPage - Inserindo o Confirmar Senha da Pessoa Física");
			System.out.println("Confirmar Senha: " + ConfirmarSenha);

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage - Inserindo o Confirmar Senha da Pessoa Física");
			test.log(Status.PASS, "Confirmar Senha: " + ConfirmarSenha);
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CampoConfirmarSenha-ConfirmarSenhaInserido"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("SignupPage - Campo Confirmar Senha da Pessoa Física Não Visivel");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage - Campo Confirmar Senha da Pessoa Física Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CampoConfirmarSenha-ConfirmarSenhaNaoVisivel"));
			/** Report Extent **/

		}
	
	}
	
	public static void CheckTermosPessoaFisica() throws Exception {

		if (IsElementPresent("signup_pf_checkbox")) {

			// Procurando o Elemento
			WebElement checkTermosPessoaFisica = driver.findElement(By.id("signup_pf_checkbox"));

			// Funcao HighLight
			HighLightElement(checkTermosPessoaFisica);

			// Click no Check Box dos Termos
			checkTermosPessoaFisica.click();;
			Thread.sleep(2000); // Espera 2 segundo

			// Escrevendo no Console
			System.out.println("SignupPage - Aceitando os Termos da Pessoa Física");

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage - Aceitando os Termos da Pessoa Física");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CheckTermos-ConfirmarTermos"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("SignupPage - Check Termos da Pessoa Física Não Visivel");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage - Check Termos da Pessoa Física Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CheckTermos-ConfirmarTermosNaoVisivel"));
			/** Report Extent **/

		}
	
	}

	
	/** Pessoa Jurídica */
	
	public static void CheckBoxPessoaJuridica() throws Exception {

		if (IsElementPresent("signup_typeSelector_container")) {

			// Escrevendo no Console
			System.out.println("SignupPage - radioButton Pessoa Jurídica está Visível");

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage - radioButton Pessoa Jurídica está Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CheckBoxPessoaJuridica-RadioButtonPessoaJuridicaVisivel"));
			/** Report Extent **/

			if (IsElementPresent("signup_radio_icon_pj")) {
				
				// Procurando o Elemento
				//WebElement radioButton = driver.findElement(By.id("signup_radio_icon_pj"));
				WebElement radioButton = driver.findElement(By.xpath("//*[@id='signup_typeSelector_container']/div[1]"));
				
				//((JavascriptExecutor) driver).executeScript("arguments[0].click()", radioButton);
				//((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", radioButton);
				
				// Funcao HighLight
				HighLightElement(radioButton);
				
				// Clicando no radioButton Pessoa Jurídica
				radioButton.click();
				Thread.sleep(2000); // Espera 2 segundo		
				
				// Escrevendo no Console
				System.out.println("SignupPage - Pessoa Jurídica selecionado");

				/** Report Extent **/
				test.log(Status.PASS, "SignupPage - Pessoa Jurídica selecionado");
				test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CheckBoxPessoaJuridica-RadioButtonPessoaJuridicaSelecionada"));
				/** Report Extent **/				
				
			} else {

				// Escrevendo no Console
				System.out.println("SignupPage - Pessoa Jurídica Não selecionada");

				/** Report Extent **/
				test.log(Status.FAIL, "SignupPage - Pessoa Jurídica Não selecionada");
				test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CheckBoxPessoaJuridica-RadioButtonPessoaJuridicaNaoSelecionada"));
				/** Report Extent **/
			
			}

		} else {

			// Escrevendo no Console
			System.out.println("SignupPage - radioButton Pessoa Jurídica Não está Visível");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage - radioButton Pessoa Jurídica Não está Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CheckBoxPessoaJuridica-RadioButtonPessoaJuridicaNaoVisivel"));
			/** Report Extent **/
						
		}

	}

	public static void CampoRazaoSocial(String RazaoSocial) throws Exception {

		if (IsElementPresent("signup_pj_name")) {

			// Procurando o Elemento
			WebElement campoRazaoSocial = driver.findElement(By.id("signup_pj_name"));

			// Funcao HighLight
			HighLightElement(campoRazaoSocial);

			// Inserindo a Razão Social
			campoRazaoSocial.sendKeys(RazaoSocial);
			Thread.sleep(2000); // Espera 2 segundo

			// Escrevendo no Console
			System.out.println("SignupPage - Inserindo Razão Social");
			System.out.println("Razão Social: " + RazaoSocial);

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage - Inserindo Razão Social");
			test.log(Status.PASS, "Razão Social: " + RazaoSocial);
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CampoRazaoSocial-RazaoSocialInserido"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("SignupPage - Inserindo Razão Social Não Visivel");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage - Inserindo Razão Social Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CampoRazaoSocial-RazaoSocialNaoVisivel"));
			/** Report Extent **/

		}

	}

	public static void CampoCNPJ(String CNPJ) throws Exception {

		if (IsElementPresent("signup_cnpj_input")) {

			// Procurando o Elemento
			WebElement campoCNPJ = driver.findElement(By.id("signup_cnpj_input"));

			// Funcao HighLight
			HighLightElement(campoCNPJ);

			// Inserindo o CNPJ
			campoCNPJ.sendKeys(CNPJ);
			Thread.sleep(2000); // Espera 2 segundo

			// Escrevendo no Console
			System.out.println("SignupPage - Inserindo o CNPJ");
			System.out.println("CNPJ: " + CNPJ);

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage - Inserindo o CNPJ");
			test.log(Status.PASS, "CNPJ: " + CNPJ);
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CampoCNPJ-CNPJInserido"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("SignupPage - Campo CNPJ Não Visivel");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage - Campo CNPJ Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CampoCNPJ-CNPJNaoVisivel"));
			/** Report Extent **/

		}

	}

	public static void CampoSegmento(String Segmento) throws Exception {
		
		/** Valores do DropDown List */
		/**
			Hotelaria = 2
			Comércio = 1
			Industria = 3
			Predial = 5
		*/
		/** Valores do DropDown List */
		
		if (IsElementSelected("signup_segment_pj_select")) {
			
			// Procurando o Elemento
			WebElement campoSegmento = driver.findElement(By.id("signup_segment_pj_select"));

			// Funcao HighLight
	        HighLightElement(campoSegmento);
	        
	        // Procurando o Elemento Select
	        Select selecionarSegmento = new Select(campoSegmento);
	        
	        // Selecionando o Segmento
	        selecionarSegmento.selectByVisibleText(Segmento);
	        //selecionarSegmento.selectByValue(Segmento);
	        Thread.sleep(2000); // Espera 2 segundo
	        
			// Escrevendo no Console
			System.out.println("SignupPage - Selecionado o Segmento");
			System.out.println("Segmento: " + Segmento);

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage - Inserindo o CNPJ");
			test.log(Status.PASS, "Segmento: " + Segmento);
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CampoSegmento-SegmentoSelecionado"));
			/** Report Extent **/

		} else {
		
			// Escrevendo no Console
			System.out.println("SignupPage - Segmento Não Visível");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage - Segmento Não Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CampoSegmento-SegmentoNaoVisivel"));
			/** Report Extent **/
						
		}
				
	}
	
	public static void CampoCEPPessoaJuridica(String CEP) throws Exception {

		if (IsElementPresent("signup_cep_inputpj")) {

			// Procurando o Elemento
			WebElement campoCEPPessoaJuridica = driver.findElement(By.id("signup_cep_inputpj"));

			// Funcao HighLight
			HighLightElement(campoCEPPessoaJuridica);

			// Inserindo o CEP
			campoCEPPessoaJuridica.sendKeys(CEP);
			Thread.sleep(2000); // Espera 2 segundo

			// Escrevendo no Console
			System.out.println("SignupPage - Inserindo o CEP Pessoa Jurídica");
			System.out.println("CEP: " + CEP);

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage - Inserindo o CEP Pessoa Jurídica");
			test.log(Status.PASS, "CEP: " + CEP);
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CampoCEP-CEPInserido"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("SignupPage - Campo CEP Pessoa Jurídica Não Visivel");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage - Campo CEP Pessoa Jurídica Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CampoCEP-CEPNaoVisivel"));
			/** Report Extent **/

		}

	}

	public static void CampoNumeroPessoaJuridica(String Numero) throws Exception {

		if (IsElementPresent("signup_pjnum")) {

			// Procurando o Elemento
			WebElement campoNumeroPessoaJuridica = driver.findElement(By.id("signup_pjnum"));

			// Funcao HighLight
			HighLightElement(campoNumeroPessoaJuridica);

			// Inserindo o Número
			campoNumeroPessoaJuridica.sendKeys(Numero);
			Thread.sleep(2000); // Espera 2 segundo

			// Escrevendo no Console
			System.out.println("SignupPage - Inserindo o Número da Empresa da Pessoa Jurídica");
			System.out.println("Número: " + Numero);

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage - Inserindo o Número da Empresa da Pessoa Jurídica");
			test.log(Status.PASS, "Número: " + Numero);
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CampoNumero-NumeroInserido"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("SignupPage - Campo Número da Empresa da Pessoa Jurídica Não Visivel");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage - Campo Número da Empresa da Pessoa Jurídica Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CampoNumero-NumeroNaoVisivel"));
			/** Report Extent **/

		}
	
	}

	public static void CampoComplementoPessoaJuridica(String Complemento) throws Exception {

		if (IsElementPresent("signup_pj_complement")) {

			// Procurando o Elemento
			WebElement campoComplementoPessoaJuridica = driver.findElement(By.id("signup_pj_complement"));

			// Funcao HighLight
			HighLightElement(campoComplementoPessoaJuridica);

			// Inserindo o Complemento
			campoComplementoPessoaJuridica.sendKeys(Complemento);
			Thread.sleep(2000); // Espera 2 segundo

			// Escrevendo no Console
			System.out.println("SignupPage - Inserindo o Complemento da Empresa da Pessoa Jurídica");
			System.out.println("Complemento: " + Complemento);

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage - Inserindo o Complemento da Empresa da Pessoa Jurídica");
			test.log(Status.PASS, "Complemento: " + Complemento);
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CampoComplemento-ComplementoInserido"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("SignupPage - Campo Complemento da Empresa da Pessoa Jurídica Não Visivel");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage - Campo Complemento da Empresa da Pessoa Jurídica Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CampoComplemento-ComplementoNaoVisivel"));
			/** Report Extent **/

		}
	
	}

	public static void CampoTelefoneContatoPessoaJuridica(String TelefoneContado) throws Exception {

		if (IsElementPresent("signup_tel_inputPJ")) {

			// Procurando o Elemento
			WebElement campoTelefoneContatoPessoaJuridica = driver.findElement(By.id("signup_tel_inputPJ"));

			// Funcao HighLight
			HighLightElement(campoTelefoneContatoPessoaJuridica);

			// Inserindo o Telefone
			campoTelefoneContatoPessoaJuridica.sendKeys(TelefoneContado);
			Thread.sleep(2000); // Espera 2 segundo

			// Escrevendo no Console
			System.out.println("SignupPage - Inserindo o Telefone da Empresa da Pessoa Jurídica");
			System.out.println("Telefone da Empresa: " + TelefoneContado);

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage - Inserindo o Telefone da Empresa da Pessoa Jurídica");
			test.log(Status.PASS, "Telefone da Empresa: " + TelefoneContado);
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CampoTelefoneEmpresa-TelefoneEmpresaInserido"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("SignupPage - Campo Telefone da Empresa da Pessoa Jurídica Não Visivel");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage - Campo Telefone da Empresa da Pessoa Jurídica Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CampoTelefoneEmpresa-TelefoneEmpresaNaoVisivel"));
			/** Report Extent **/

		}
	
	}

	public static void CampoNomeGestor(String NomeGestor) throws Exception {

		if (IsElementPresent("signup_pj_responsiblename")) {

			// Procurando o Elemento
			WebElement campoNomeGestor = driver.findElement(By.id("signup_pj_responsiblename"));

			// Funcao HighLight
			HighLightElement(campoNomeGestor);

			// Inserindo o Nome do Gestor
			campoNomeGestor.sendKeys(NomeGestor);
			Thread.sleep(2000); // Espera 2 segundo

			// Escrevendo no Console
			System.out.println("SignupPage - Inserindo o Nome do Gestor da Pessoa Jurídica");
			System.out.println("Nome do Gestor: " + NomeGestor);

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage - Inserindo o Nome do Gestor da Pessoa Jurídica");
			test.log(Status.PASS, "Nome do Gestor: " + NomeGestor);
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CampoNomeGestor-NomeGestorInserido"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("SignupPage - Nome do Gestor Não Visível");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage - Nome do Gestor Não Visível");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CampoNomeGestor-NomeGestorNaoVisível"));
			/** Report Extent **/

		}
	
	}

	public static void CampoEmailPessoaJuridica(String Email) throws Exception {

		if (IsElementPresent("signup_emailpj")) {

			// Procurando o Elemento
			WebElement campoEmailPessoaJuridica = driver.findElement(By.id("signup_emailpj"));

			// Funcao HighLight
			HighLightElement(campoEmailPessoaJuridica);

			// Inserindo o E-Mail
			campoEmailPessoaJuridica.sendKeys(Email);
			Thread.sleep(2000); // Espera 2 segundo

			// Escrevendo no Console
			System.out.println("SignupPage - Inserindo o E-Mail da Pessoa Jurídica");
			System.out.println("E-Mail: " + Email);

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage - Inserindo o E-Mail da Pessoa Jurídica");
			test.log(Status.PASS, "E-Mail: " + Email);
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CampoEMail-EMailInserido"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("SignupPage - Campo E-Mail da Pessoa Jurídica Não Visivel");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage - Campo E-Mail da Pessoa Jurídica Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CampoEMail-EMailNaoVisivel"));
			/** Report Extent **/

		}
	
	}

	public static void CampoSenhaPessoaJuridica(String Senha) throws Exception {

		if (IsElementPresent("signup_pj_password")) {

			// Procurando o Elemento
			WebElement campoSenhaPessoaJuridica = driver.findElement(By.id("signup_pj_password"));

			// Funcao HighLight
			HighLightElement(campoSenhaPessoaJuridica);

			// Inserindo a Senha
			campoSenhaPessoaJuridica.sendKeys(Senha);
			Thread.sleep(2000); // Espera 2 segundo

			// Escrevendo no Console
			System.out.println("SignupPage - Inserindo a Senha da Pessoa Jurídica");
			System.out.println("Senha: " + Senha);

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage - Inserindo a Senha da Pessoa Jurídica");
			test.log(Status.PASS, "Senha: " + Senha);
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CampoSenha-SenhaInserido"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("SignupPage - Campo Senha da Pessoa Jurídica Não Visivel");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage - Campo Senha da Pessoa Jurídica Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CampoSenha-SenhaNaoVisivel"));
			/** Report Extent **/

		}
	
	}

	public static void CampoConfirmarSenhaPessoaJuridica(String ConfirmarSenha) throws Exception {

		if (IsElementPresent("signup_pj_passwordConfirmation")) {

			// Procurando o Elemento
			WebElement campoConfirmarSenhaPessoaJuridica = driver.findElement(By.id("signup_pj_passwordConfirmation"));

			// Funcao HighLight
			HighLightElement(campoConfirmarSenhaPessoaJuridica);

			// Inserindo o Confirmar Senha
			campoConfirmarSenhaPessoaJuridica.sendKeys(ConfirmarSenha);
			Thread.sleep(2000); // Espera 2 segundo

			// Escrevendo no Console
			System.out.println("SignupPage - Inserindo o Confirmar Senha da Pessoa Jurídica");
			System.out.println("Confirmar Senha: " + ConfirmarSenha);

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage - Inserindo o Confirmar Senha da Pessoa Jurídica");
			test.log(Status.PASS, "Confirmar Senha: " + ConfirmarSenha);
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CampoConfirmarSenha-ConfirmarSenhaInserido"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("SignupPage - Campo Confirmar Senha da Pessoa Jurídica Não Visivel");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage - Campo Confirmar Senha da Pessoa Jurídica Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CampoConfirmarSenha-ConfirmarSenhaNaoVisivel"));
			/** Report Extent **/

		}
	
	}

	public static void CheckTermosPessoaJuridica() throws Exception {

		if (IsElementPresent("signup_pj_checkbox")) {

			// Procurando o Elemento
			WebElement checkTermosPessoaJuridica = driver.findElement(By.id("signup_pj_checkbox"));

			// Funcao HighLight
			HighLightElement(checkTermosPessoaJuridica);

			// Click no Check Box dos Termos
			checkTermosPessoaJuridica.click();;
			Thread.sleep(2000); // Espera 2 segundo

			// Escrevendo no Console
			System.out.println("SignupPage - Aceitando os Termos da Pessoa Jurídica");

			/** Report Extent **/
			test.log(Status.PASS, "SignupPage - Aceitando os Termos da Pessoa Jurídica");
			test.addScreenCaptureFromPath(TakeScreenshot("Sucesso", "CheckTermos-ConfirmarTermos"));
			/** Report Extent **/

		} else {

			// Escrevendo no Console
			System.out.println("SignupPage - Check Termos da Pessoa Jurídica Não Visivel");

			/** Report Extent **/
			test.log(Status.FAIL, "SignupPage - Check Termos da Pessoa Jurídica Não Visivel");
			test.addScreenCaptureFromPath(TakeScreenshot("Erro", "CheckTermos-ConfirmarTermosNaoVisivel"));
			/** Report Extent **/

		}
	
	}
	
}
