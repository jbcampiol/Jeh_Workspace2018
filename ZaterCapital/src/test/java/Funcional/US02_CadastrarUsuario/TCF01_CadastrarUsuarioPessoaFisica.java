package Funcional.US02_CadastrarUsuario;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utilitarios.Dados_Windows;
import Utilitarios.FuncoesReusaveis_Windows;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class TCF01_CadastrarUsuarioPessoaFisica extends FuncoesReusaveis_Windows {

	@Given("^um usuario do tipo Pessoa Fisica na Tela de Cadastro da Exchange da Zater Capital\\.$")
	public void um_usuario_do_tipo_Pessoa_Fisica_na_Tela_de_Cadastro_da_Exchange_da_Zater_Capital() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		// Chamando o Browser
		InitBrowser("Chrome");
		
		// Chamando o Site e configurando o Browser  
		driver.navigate().to(Dados_Windows.Homologacao_Site_ZaterCapital_Signup);	// chamando o site
		driver.manage().window().maximize(); // maximizando o browser
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // esperando por até 20 segundos
		
		// Pegando as URLs
		String url_site = driver.getCurrentUrl(); // URL atual
		String url_dados = Dados_Windows.Homologacao_Site_ZaterCapital_Signup; // URL da class Dados
		
		// Escrevendo no Console
		System.out.println(url_site);
		System.out.println(url_dados);
		
		// Assert para verificar se as URLs sao iguais
		//assertEquals(url_dados, url_site);
		
		if (url_site.equals(url_dados)) {	
			
		// Tirando SnapShot
		TakeScreenshot("Sucesso","TCF01_CadastrarUsuarioPessoaFisica_STP01-AbrirSiteComSucesso");
		
		// Escrevendo no Console
		System.out.println("Abrir o Browser - Abrir o Site de Cadastro da Exchange da Zater Capital");
		
		} else {
						
			// Tirando SnapShot
			TakeScreenshot("Erro","TCF01_CadastrarUsuarioPessoaFisica_STP01-ErroAbrirSite");
			
			// Escrevendo no Console
			System.out.println("Abrir o Browser - ERROR ao abrir o Site de Cadastro da Exchange da Zater Capital");		
			
		}
		
	}
	
	@Given("^marcar o RadioButton PESSOAFISICA\\.$")
	public void marcar_o_RadioButton_PESSOAFISICA() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		if(IsElementPresent("/html/body/main/div/div/div/main/div/div[3]/label[1]/span")) {
			
			// Procurando o Elemento
			WebElement pessoa_fisica = driver.findElement(By.xpath("/html/body/main/div/div/div/main/div/div[3]/label[1]/span"));

			// Funcao HighLight
	        HighLightElement(pessoa_fisica);
	        
	        // Clicar no CheckBox
	        pessoa_fisica.click();
	        Thread.sleep(1000); // Espera 1 segundo
	        
	        // Tirando SnapShot
	        TakeScreenshot("Sucesso", "TCF01_CadastrarUsuarioPessoaFisica_STP01-RadioButtonPessoaFisicaSelecionado");
	        
	        // Escrevendo no Console
	        System.out.println("Cadastro - Pessoa Fisica Selecionado");
	        System.out.println("Pessoa Fisica:" + "True");
							
		} else {
			
			// Tirando SnapShot
			TakeScreenshot("Erro","TCF01_CadastrarUsuarioPessoaFisica_STP01-RadioButtonPessoaFisicaNaoSelecionado");
			
			// Escrevendo no Console
			System.out.println("Cadastro - Pessoa Fisica Não Selecionado");
			
		}
		
	}

	@When("^informar os dados \"([^\"]*)\", \"([^\"]*)\", \"([^\\\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" e \"([^\"]*)\" na Tela de Cadastro\\.$")
	public void informar_os_dados_e_na_Tela_de_Cadastro(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		if (IsElementPresent("createaccount")) {
	        			
			// Tirando SnapShot
			TakeScreenshot("Sucesso", "TCF01_CadastrarUsuarioPessoaFisica_STP02-TelaCadastroVisivel");
			
	        // Escrevendo no Console
	        System.out.println("Cadastro - Tela de Cadastro Visivel");
			
			if (IsElementPresent("nameField")) {
				
				// Procurando o Elemento
				WebElement nome = driver.findElement(By.id("nameField"));
	
				// Funcao HighLight
		        HighLightElement(nome);
		        
		        // Digitando o Nome
		        nome.sendKeys(arg1);
		        Thread.sleep(1000); // Espera 1 segundo
		        
		        // Tirando SnapShot
		        TakeScreenshot("Sucesso", "TCF01_CadastrarUsuarioPessoaFisica_STP02-CampoNomeInformado");
		        
		        // Escrevendo no Console
		        System.out.println("Cadastro - Nome Informado");
		        System.out.println("Nome:" + arg1);

			} else {
			
				// Tirando SnapShot
				TakeScreenshot("Erro","TCF01_CadastrarUsuarioPessoaFisica_STP02-CampoNomeNaoInformado");
				
				// Escrevendo no Console
				System.out.println("Cadastro - Nome Não Informado");
							
			}
			
			if (IsElementPresent("sobrenomeField")) {
				
				// Procurando o Elemento
				WebElement sobrenome = driver.findElement(By.id("sobrenomeField"));
	
				// Funcao HighLight
		        HighLightElement(sobrenome);
		        
		        // Digitando o Sobrenome
		        sobrenome.sendKeys(arg2);
		        Thread.sleep(1000); // Espera 1 segundo
		        
		        // Tirando SnapShot
		        TakeScreenshot("Sucesso", "TCF01_CadastrarUsuarioPessoaFisica_STP02-CampoSobrenomeInformado");
		        
		        // Escrevendo no Console
		        System.out.println("Cadastro - Sobrenome Informado");
		        System.out.println("Sobrenome:" + arg2);

			} else {
			
				// Tirando SnapShot
				TakeScreenshot("Erro","TCF01_CadastrarUsuarioPessoaFisica_STP02-CampoSobrenomeNaoInformado");
				
				// Escrevendo no Console
				System.out.println("Cadastro - Sobrenome Não Informado");
							
			}
			
			if (IsElementPresent("birthday")) {
				
				// Procurando o Elemento
				WebElement nascimento = driver.findElement(By.name("birthday"));
	
				// Funcao HighLight
		        HighLightElement(nascimento);
		        
		        // Digitando a Data de Nascimento
		        nascimento.sendKeys(arg3);
		        Thread.sleep(1000); // Espera 1 segundo
		        
		        // Tirando SnapShot
		        TakeScreenshot("Sucesso", "TCF01_CadastrarUsuarioPessoaFisica_STP02-CampoNascimentoInformado");
		        
		        // Escrevendo no Console
		        System.out.println("Cadastro - Data de Nascimento Informado");
		        System.out.println("Nascimento:" + arg3);

			} else {
			
				// Tirando SnapShot
				TakeScreenshot("Erro","TCF01_CadastrarUsuarioPessoaFisica_STP02-CampoNascimentoNaoInformado");
				
				// Escrevendo no Console
				System.out.println("Cadastro - Data de Nascimento Não Informado");
							
			}
			
			if (IsElementPresent("cpfField")) {
				
				// Procurando o Elemento
				WebElement cpf = driver.findElement(By.id("cpfField"));
	
				// Funcao HighLight
		        HighLightElement(cpf);
		        
		        // Digitando o CPF
		        cpf.sendKeys(arg4);
		        Thread.sleep(1000); // Espera 1 segundo
		        
		        // Tirando SnapShot
		        TakeScreenshot("Sucesso", "TCF01_CadastrarUsuarioPessoaFisica_STP02-CampoCPFInformado");
		        
		        // Escrevendo no Console
		        System.out.println("Cadastro - CPF Informado");
		        System.out.println("CPF:" + arg4);

			} else {
			
				// Tirando SnapShot
				TakeScreenshot("Erro","TCF01_CadastrarUsuarioPessoaFisica_STP02-CampoCPFNaoInformado");
				
				// Escrevendo no Console
				System.out.println("Cadastro - CPF Não Informado");
							
			}
			
			if (IsElementPresent("emailField")) {
				
				// Procurando o Elemento
				WebElement email = driver.findElement(By.id("emailField"));
	
				// Funcao HighLight
		        HighLightElement(email);
		        
		        // Digitando o EMAIL
		        email.sendKeys(arg5);
		        Thread.sleep(1000); // Espera 1 segundo
		        
		        // Tirando SnapShot
		        TakeScreenshot("Sucesso", "TCF01_CadastrarUsuarioPessoaFisica_STP02-CampoEMAILInformado");
		        
		        // Escrevendo no Console
		        System.out.println("Cadastro - Email Informado");
		        System.out.println("Email:" + arg5);

			} else {
			
				// Tirando SnapShot
				TakeScreenshot("Erro","TCF01_CadastrarUsuarioPessoaFisica_STP02-CampoEMAILNaoInformado");
				
				// Escrevendo no Console
				System.out.println("Cadastro - Email Não Informado");
							
			}
			
			if (IsElementPresent("emailConfirmField")) {
				
				// Procurando o Elemento
				WebElement confirmar_email = driver.findElement(By.id("emailConfirmField"));
	
				// Funcao HighLight
		        HighLightElement(confirmar_email);
		        
		        // Digitando o Confirmar EMAIL
		        confirmar_email.sendKeys(arg6);
		        Thread.sleep(1000); // Espera 1 segundo
		        
		        // Tirando SnapShot
		        TakeScreenshot("Sucesso", "TCF01_CadastrarUsuarioPessoaFisica_STP02-CampoConfirmarEMAILInformado");
		        
		        // Escrevendo no Console
		        System.out.println("Cadastro - Confirmar Email Informado");
		        System.out.println("Confirmar Email:" + arg6);

			} else {
			
				// Tirando SnapShot
				TakeScreenshot("Erro","TCF01_CadastrarUsuarioPessoaFisica_STP02-CampoConfirmarEMAILNaoInformado");
				
				// Escrevendo no Console
				System.out.println("Cadastro - Confirmar Email Não Informado");
							
			}
			
			if (IsElementPresent("passwordField")) {
				
				// Procurando o Elemento
				WebElement senha = driver.findElement(By.id("passwordField"));
	
				// Funcao HighLight
		        HighLightElement(senha);
		        
		        // Digitando a Senha
		        senha.sendKeys(arg7);
		        Thread.sleep(1000); // Espera 1 segundo
		        
		        // Tirando SnapShot
		        TakeScreenshot("Sucesso", "TCF01_CadastrarUsuarioPessoaFisica_STP02-CampoSenhaInformada");
		        
		        // Escrevendo no Console
		        System.out.println("Cadastro - Senha Informada");
		        System.out.println("Senha:" + arg7);

			} else {
			
				// Tirando SnapShot
				TakeScreenshot("Erro","TCF01_CadastrarUsuarioPessoaFisica_STP02-CampoSenhaNaoInformada");
				
				// Escrevendo no Console
				System.out.println("Cadastro - Senha Não Informada");
							
			}
			
			if (IsElementPresent("confPasswordField")) {
				
				// Procurando o Elemento
				WebElement confirmar_senha = driver.findElement(By.id("confPasswordField"));
	
				// Funcao HighLight
		        HighLightElement(confirmar_senha);
		        
		        // Digitando o Confirmar Senha
		        confirmar_senha.sendKeys(arg8);
		        Thread.sleep(1000); // Espera 1 segundo
		        
		        // Tirando SnapShot
		        TakeScreenshot("Sucesso", "TCF01_CadastrarUsuarioPessoaFisica_STP02-CampoConfirmarSenhaInformada");
		        
		        // Escrevendo no Console
		        System.out.println("Cadastro - Confirmar Senha Informada");
		        System.out.println("Confirmar Senha:" + arg8);

			} else {
			
				// Tirando SnapShot
				TakeScreenshot("Erro","TCF01_CadastrarUsuarioPessoaFisica_STP02-CampoConfirmarSenhaNaoInformada");
				
				// Escrevendo no Console
				System.out.println("Cadastro - Confirmar Senha Não Informada");
							
			}
			
			if (IsElementSelected("countryField")) {
				
				// Procurando o Elemento
				WebElement estado = driver.findElement(By.id("countryField"));
	
				// Funcao HighLight
		        HighLightElement(estado);
		        
		        // Procurando o Elemento Select
		        Select selecionar_estado = new Select(estado);
		        
		        // Selecionando o Estado
		        selecionar_estado.selectByValue(arg9);
		        Thread.sleep(1000); // Espera 1 segundo
		        
		        // Tirando SnapShot
		        TakeScreenshot("Sucesso", "TCF01_CadastrarUsuarioPessoaFisica_STP02-CampoEstadoSelecionado");
		        
		        // Escrevendo no Console
		        System.out.println("Cadastro - Estado Selecionado");
		        System.out.println("Estado Selecionado:" + arg9);

			} else {
			
				// Tirando SnapShot
				TakeScreenshot("Erro","TCF01_CadastrarUsuarioPessoaFisica_STP02-CampoEstadoNaoSelecionado");
				
				// Escrevendo no Console
				System.out.println("Cadastro - Estado Selecionado Não Selecionado");
							
			}
			
			if (IsElementPresent("Autocomplete")) {
				
				// Procurando o Elemento
				WebElement cidade = driver.findElement(By.id("Autocomplete"));
	
				// Funcao HighLight
		        HighLightElement(cidade);
		        
		        // Digitando a Cidade
		        cidade.sendKeys(arg10);
		        Thread.sleep(1000); // Espera 1 segundo
		        
		        // Tirando SnapShot
		        TakeScreenshot("Sucesso", "TCF01_CadastrarUsuarioPessoaFisica_STP02-CampoCidadeInformada");
		        
		        // Escrevendo no Console
		        System.out.println("Cadastro - Cidade Informada");
		        System.out.println("Cidade:" + arg10);

			} else {
			
				// Tirando SnapShot
				TakeScreenshot("Erro","TCF01_CadastrarUsuarioPessoaFisica_STP02-CampoCidadeNaoInformada");
				
				// Escrevendo no Console
				System.out.println("Cadastro - Cidade Informada");
							
			}
			
		} else {
			
			// Tirando SnapShot
			TakeScreenshot("Erro", "TCF01_CadastrarUsuarioPessoaFisica_STP02-TelaCadastroNaoVisivel");
			
	        // Escrevendo no Console
	        System.out.println("Cadastro - Tela de Cadastro Visivel");
			
		}
	}

	@When("^marcar a opcao ACEITO O TERMO\\.$")
	public void marcar_a_opcao_ACEITO_O_TERMO() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		if(IsElementEnabled("acceptTerms")) {
			
			// Procurando o Elemento
			WebElement aceito_termo = driver.findElement(By.id("acceptTerms"));

			// Funcao HighLight
	        HighLightElement(aceito_termo);
	        
	        // Clicar no CheckBox
	        aceito_termo.click();
	        Thread.sleep(1000); // Espera 1 segundo
	        
	        // Tirando SnapShot
	        TakeScreenshot("Sucesso", "TCF01_CadastrarUsuarioPessoaFisica_STP03-CampoAceitoTermoSelecionado");
	        
	        // Escrevendo no Console
	        System.out.println("Cadastro - Aceito o Termo Selecionado");
	        System.out.println("Aceito o Termo:" + "True");
							
		} else {
			
			// Tirando SnapShot
			TakeScreenshot("Erro","TCF01_CadastrarUsuarioPessoaFisica_STP03-CampoAceitoTermoNaoSelecionado");
			
			// Escrevendo no Console
			System.out.println("Cadastro - Aceito o Termo Não Selecionado");
			
		}
		
	}

	@When("^acionar o Botao CRIAR CONTA\\.$")
	public void acionar_o_Botao_CRIAR_CONTA() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		if(IsElementPresent("btn-criar")) {
			
			// Procurando o Elemento
			WebElement botao_criar = driver.findElement(By.id("btn-criar"));

			// Funcao HighLight
	        HighLightElement(botao_criar);
	        
	        // Clicando no Botão CRIAR
	        botao_criar.click();
	        Thread.sleep(10000); // Espera 1 segundo
	        
	        // Função Robot
	        // Tecla ENTER	- Pressionar o Botão
	        /*
	        Robot robot = new Robot();
	        robot.keyPress(KeyEvent.VK_ENTER);		
	        robot.delay(100);// esperar para digitar
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        robot.delay(100);// esperar para digitar
	        Thread.sleep(10000); // Espera 1 segundo
	        */
	        
	        // Tirando SnapShot
	        TakeScreenshot("Sucesso", "TCF01_CadastrarUsuarioPessoaFisica_STP04-BotaoCriarAcionado");
	        
	        // Escrevendo no Console
	        System.out.println("Cadastro - Botão CRIAR Acionado");
	        System.out.println("Botão Criar:" + "Acionado");
							
		} else {
			
			// Tirando SnapShot
			TakeScreenshot("Erro","TCF01_CadastrarUsuarioPessoaFisica_STP04-BotaoCriarNaoAcionado");
			
			// Escrevendo no Console
			System.out.println("Cadastro - Botão CRIAR Não Acionado");
			
		}
		
	}

	@Then("^o sistema deve permitir o cadastramento do usuario com sucesso e redirecionar o usuario para a Tela de LOGIN\\.$")
	public void o_sistema_deve_permitir_o_cadastramento_do_usuario_com_sucesso_e_redirecionar_o_usuario_para_a_Tela_de_LOGIN() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		// Pegando as URLs
		String url_site = driver.getCurrentUrl(); // URL atual
		String url_dados = Dados_Windows.Homologacao_Site_ZaterCapital_Exchange + "?newaccount=true"; // URL da class Dados
		
		// Escrevendo no Console
		System.out.println(url_site);
		System.out.println(url_dados);
		
		// Assert para verificar se as URLs sao iguais
		//assertEquals(url_dados, url_site);
		
		if (url_site.equals(url_dados) && IsElementPresent("btn-logar")) {	
		
		// Procurando o Elemento
		WebElement botao_logar = driver.findElement(By.id("btn-logar"));
		
		// Funcao HighLight
        HighLightElement(botao_logar);
        
		// Tirando SnapShot
		TakeScreenshot("Sucesso","TCF01_CadastrarUsuarioPessoaFisica_STP05-CadastroComSucesso");
		
		// Escrevendo no Console
		System.out.println("Cadastro - Realizado com Sucesso");
		
		// Esperar 1 segundo
		Thread.sleep(1000);
		
        // Fechar o Browser
        driver.quit();
		
		} else {
						
			// Tirando SnapShot
			TakeScreenshot("Erro","TCF01_CadastrarUsuarioPessoaFisica_STP05-CadastroSemSucesso");
			
			// Escrevendo no Console
			System.out.println("Cadastro - Não Realizado");		
			
		}
		
	}

}
