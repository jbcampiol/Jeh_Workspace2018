package Regressao;


import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"html:output/cucumber-html-report","json:output/cucumber-json-report.json"}
		,features = {"feature/US01-LogarExchange/TCF01-LogarExchange.feature", 
					"feature/US02-CadastrarUsuario/TCF01-CadastrarUsuarioPessoaFisica.feature", 
					"feature/US01-LogarExchange/TCF02-LogOut.feature"}
		,glue= {"Funcional"}
		,dryRun = false
		,tags = {"@Logar,@CadastrarPessoaFisica,@LogOut"}

		)

		/*
		
		//,tags = {"@Logar,@CadastrarPessoaFisica,@LogOut"}

		,tags = {"@Logar,"
		+ "@CadastrarPessoaFisica,"
		+ "@LogOut"}
		
		*/
			
	
@FixMethodOrder(MethodSorters.DEFAULT)
public class FuncionalTestRunner {

}
