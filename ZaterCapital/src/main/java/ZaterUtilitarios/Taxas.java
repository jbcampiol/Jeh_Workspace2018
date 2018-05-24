package ZaterUtilitarios;

import java.math.BigDecimal;
import ZaterUtilitarios.FuncoesReusaveis_Windows;

public class Taxas {

	public static String TaxasZater(String ContaUsuario, String TipoMoeda, String TipoOperacao, String TipoTaxa, String BitcoinInformado, String DinheiroInformado, String ValorTaxaServico, String ValorLiquido) throws Exception {

		String Taxas = null;
		float taxa_passiva;
		float taxa_ativa;
		float taxa_fixa;
		
		// Coloando o Retorno da Função RequestURL dentro da variavel
		String LivroCaixa = FuncoesReusaveis_Windows.RequestURL(); 
		
    	// Inserindo os valores do JSon nas variaveis
		String SubStringCompra = LivroCaixa.substring(LivroCaixa.indexOf("\"" + "buy" + "\"" + ":"),LivroCaixa.lastIndexOf("," + "\"" + "fee" + "\""));
    	String Valor_Compra =  SubStringCompra.substring(6);
    	  	
    	String SubStringVenda = LivroCaixa.substring(LivroCaixa.indexOf("\"" + "sell" + "\"" + ":"),LivroCaixa.lastIndexOf("}"));
    	String Valor_Venda =  SubStringVenda.substring(7);
	
		// Escrevendo no Console
		System.out.println("Return JASON: " + LivroCaixa);
		System.out.println("SubString Compra: " + SubStringCompra);
		System.out.println("Livro Compra: " + Valor_Compra);
		System.out.println("SubString Venda: " + SubStringVenda);
		System.out.println("Livro Venda: " + Valor_Venda);
		
		// Convertendo String em float
		float Livro_Compra = Float.valueOf(Valor_Compra.replace(",", "."));
		float Livro_Venda = Float.valueOf(Valor_Venda.replace(",", "."));
		
		// Deixando Fixo os valores dos livros
		//float Livro_Compra = (float) 20000;
		//float Livro_Venda = (float) 20200;

		switch (ContaUsuario) {

		case "Normal":

			// Escrevendo no Console
			System.out.println("Taxas para o usuário Usuário Normal");

			if (TipoMoeda == "Money" && TipoOperacao == "Withdraw") {

				taxa_passiva = 0;
				taxa_ativa = (float) 0.0089;
				taxa_fixa = 10;

				if (TipoTaxa == "Ativa") {
					
					// Convertendo a String em Float
					float TaxaServico = Float.valueOf(ValorTaxaServico.replace(".", "").replace(",", "."));
					float ValorLiquido_ = Float.valueOf(ValorLiquido.replace(".", "").replace(",", "."));
					float Bitcoin_convertido = Float.valueOf(BitcoinInformado.replace(",", ".")); // --> Assumiu o valor da TaxaTed
					float Dinheiro_convertido = Float.valueOf(DinheiroInformado.replace(".", "").replace(",", "."));
					String Convertido = ValorTaxaServico.replace(",", ".");
					
					// Escrevendo no Console
					System.out.println("Bitcoin: " + Bitcoin_convertido + " " + "Dinheiro: " + Dinheiro_convertido);

					// Escrevendo no Console
					System.out.println("Moeda: " + TipoMoeda + " " + "Operacao: " + TipoOperacao + " " + "TipoTaxa: "
							+ TipoTaxa + " " + "Ativa: " + taxa_ativa + " " + "Fixa: " + taxa_fixa);
					
					// Escrevendo no Console
					System.out.println("ValorTaxaServico: " + TaxaServico);
					System.out.println("ValorTaxaServico: " + Convertido);
					System.out.println("ValorLiquido: " + ValorLiquido_);
					System.out.println("Bitcoin_convertido: " + Bitcoin_convertido);
					System.out.println("Dinheiro_convertido: " + Dinheiro_convertido);

					float CalculoTaxaServico = (Dinheiro_convertido * taxa_ativa);
					System.out.println("Calculo 1: " + CalculoTaxaServico);
					
					float CalculoValorLiquido = ((Dinheiro_convertido - CalculoTaxaServico)-Bitcoin_convertido);
					System.out.println("Calculo 2: " + CalculoValorLiquido);
					
					if (CalculoValorLiquido == ValorLiquido_) {

						System.out.println("TAXA OK");
						System.out.println("Valor Liquido OK");

						Taxas = new String("OK");

					} else {

						System.out.println("TAXA DIFERENTE");

						System.out.println("VALOR LIQUIDO DIFERENTE");

						Taxas = new String("NOK");
					}
					
				} 

			}

			if (TipoMoeda == "BTC" && TipoOperacao == "Withdraw") { // Precisa rever os Calculos

				taxa_passiva = 0;
				taxa_ativa = (float) 0.0089;
				taxa_fixa = 0;

				if (TipoTaxa == "Ativa") {
					
					// Convertendo a String em Float
					float TaxaServico = Float.valueOf(ValorTaxaServico.replace(".", "").replace(",", "."));
					float ValorLiquido_ = Float.valueOf(ValorLiquido.replace(".", "").replace(",", "."));
					float Bitcoin_convertido = Float.valueOf(BitcoinInformado.replace(",", ".")); 
					float Dinheiro_convertido = Float.valueOf(DinheiroInformado.replace(".", "").replace(",", ".")); // --> Assumiu o valor da TaxaTed
					String Convertido = ValorTaxaServico.replace(",", ".");
					
					// Escrevendo no Console
					System.out.println("Bitcoin: " + Bitcoin_convertido + " " + "Dinheiro: " + Dinheiro_convertido);

					// Escrevendo no Console
					System.out.println("Moeda: " + TipoMoeda + " " + "Operacao: " + TipoOperacao + " " + "TipoTaxa: "
							+ TipoTaxa + " " + "Ativa: " + taxa_ativa + " " + "Fixa: " + taxa_fixa);
					
					// Escrevendo no Console
					System.out.println("ValorTaxaServico: " + TaxaServico);
					System.out.println("ValorTaxaServico: " + Convertido);
					System.out.println("ValorLiquido: " + ValorLiquido_);
					System.out.println("Bitcoin_convertido: " + Bitcoin_convertido);
					System.out.println("Dinheiro_convertido: " + Dinheiro_convertido);
					
					
					// refazer os calculos
					
					float CalculoTaxaServico = (Dinheiro_convertido * taxa_ativa);
					System.out.println("Calculo 1: " + CalculoTaxaServico);
					
					float CalculoValorLiquido = ((Dinheiro_convertido - CalculoTaxaServico)-Bitcoin_convertido);
					System.out.println("Calculo 2: " + CalculoValorLiquido);
					
					if (CalculoValorLiquido == ValorLiquido_) {

						System.out.println("TAXA OK");
						System.out.println("Valor Liquido OK");

						Taxas = new String("OK");

					} else {

						System.out.println("TAXA DIFERENTE");

						System.out.println("VALOR LIQUIDO DIFERENTE");

						Taxas = new String("NOK");
					}
				}

			} 

			if (TipoMoeda == "BTC" && TipoOperacao == "Sell") {

				taxa_passiva = (float) 0.0019;
				taxa_ativa = (float) 0.0049;
				taxa_fixa = 0;

				if (TipoTaxa == "Passiva") {

					// Convertendo a String em Float
					float TaxaServico = Float.valueOf(ValorTaxaServico.replace(",", "."));
					float ValorLiquido_ = Float.valueOf(ValorLiquido.replace(",", "."));
					float Bitcoin_convertido = Float.valueOf(BitcoinInformado.replace(",", "."));
					float Dinheiro_convertido = Float.valueOf(DinheiroInformado.replace(".", "").replace(",", "."));

					// Escrevendo no Console
					System.out.println("Bitcoin: " + Bitcoin_convertido + " " + "Dinheiro: " + Dinheiro_convertido);

					// Escrevendo no Console
					System.out.println("Moeda: " + TipoMoeda + " " + "Operacao: " + TipoOperacao + " " + "TipoTaxa: "
							+ TipoTaxa + " " + "Passiva: " + taxa_passiva + " " + "Fixa: " + taxa_fixa);
					
					// Escrevendo no Console
					System.out.println("ValorTaxaServico: " + TaxaServico);
					System.out.println("ValorLiquido: " + ValorLiquido_);
					System.out.println("Bitcoin_convertido: " + Bitcoin_convertido);
					System.out.println("Dinheiro_convertido: " + Dinheiro_convertido);

					float CalculoTaxaServico = ((Bitcoin_convertido * Dinheiro_convertido) * taxa_passiva);
					System.out.println("Calculo 1: " + CalculoTaxaServico);

					float CalculoValorLiquido = ((Bitcoin_convertido * Dinheiro_convertido) - CalculoTaxaServico);
					System.out.println("Calculo 2: " + CalculoValorLiquido);

					if (CalculoTaxaServico == TaxaServico && CalculoValorLiquido == ValorLiquido_) {

						System.out.println("TAXA OK");
						System.out.println("Valor Liquido OK");

						Taxas = new String("OK");

					} else {

						System.out.println("TAXA DIFERENTE");

						System.out.println("VALOR LIQUIDO DIFERENTE");

						Taxas = new String("NOK");
					}
				}

				if (TipoTaxa == "Ativa") {

					// Convertendo a String em Float
					float TaxaServico = Float.valueOf(ValorTaxaServico.replace(",", "."));
					float ValorLiquido_ = Float.valueOf(ValorLiquido.replace(".", "").replace(",", "."));
					float Bitcoin_convertido = Float.valueOf(BitcoinInformado.replace(",", "."));
					float Dinheiro_convertido = Float.valueOf(DinheiroInformado.replace(".", "").replace(",", "."));
					String Convertido = ValorTaxaServico.replace(",", ".");

					// Escrevendo no Console
					System.out.println("Bitcoin: " + Bitcoin_convertido + " " + "Dinheiro: " + Dinheiro_convertido);

					// Escrevendo no Console
					System.out.println("Moeda: " + TipoMoeda + " " + "Operacao: " + TipoOperacao + " " + "TipoTaxa: "
							+ TipoTaxa + " " + "Ativa: " + taxa_ativa + " " + "Fixa: " + taxa_fixa);

					// Escrevendo no Console
					System.out.println("Taxa Serviço: " + TaxaServico);
					System.out.println("Taxa Serviço Convertida: " + Convertido);
					System.out.println("ValorLiquido: " + ValorLiquido_);
					System.out.println("Bitcoin_convertido: " + Bitcoin_convertido);
					System.out.println("Dinheiro_convertido: " + Dinheiro_convertido);

					//#.##,0000000

					/** Calculando e Convertendo em BigDecimal */
					float CalculoBitcoins = (Dinheiro_convertido/Livro_Compra);
					System.out.println("Calculo1: " + CalculoBitcoins);

					BigDecimal CalculoBitcoins_BIG = BigDecimal.valueOf(CalculoBitcoins);									
					CalculoBitcoins_BIG = CalculoBitcoins_BIG.setScale(8, BigDecimal.ROUND_HALF_EVEN);		

					System.out.println("Calculo1: " + CalculoBitcoins_BIG);
					/** */

					/** Calculando e Convertendo em BigDecimal */
					float CalculoTaxaServico = (Dinheiro_convertido * taxa_ativa);
					System.out.println("Calculo2: " + CalculoTaxaServico);
					/** */

					/** Calculando e Convertendo em BigDecimal */
					float CalculoValorLiquido = (Dinheiro_convertido - CalculoTaxaServico);
					System.out.println("Calculo3: " + CalculoValorLiquido);
					/** */

					/** Convertendo em BigDecimal */
					BigDecimal Bitcoin_convertido_BIG = BigDecimal.valueOf(Bitcoin_convertido);									
					Bitcoin_convertido_BIG = Bitcoin_convertido_BIG.setScale(8, BigDecimal.ROUND_HALF_DOWN);

					System.out.println("BitcoinConvertido: " + Bitcoin_convertido_BIG);
					/** */


					if ((CalculoBitcoins_BIG.equals(Bitcoin_convertido_BIG) && CalculoTaxaServico == TaxaServico && CalculoValorLiquido == ValorLiquido_)) { // (CalculoBitcoins_BIG.equals(Bitcoin_convertido_BIG)

						System.out.println("BICOIN OK");
						System.out.println("TAXA OK");
						System.out.println("Valor Liquido OK");

						Taxas = new String("OK");

					} else {

						System.out.println("BICOIN DIFERENTE");
						System.out.println("TAXA DIFERENTE");
						System.out.println("VALOR LIQUIDO DIFERENTE");

						Taxas = new String("NOK");
					}
				}	
			} 

			if (TipoMoeda == "BTC" && TipoOperacao == "Buy") {

				taxa_passiva = (float) 0.0019;
				taxa_ativa = (float) 0.0049;
				taxa_fixa = 0;

				if (TipoTaxa == "Passiva") {

					// Convertendo a String em Float
					float TaxaServico = Float.valueOf(ValorTaxaServico.replace(",", "."));
					float ValorLiquido_ = Float.valueOf(ValorLiquido.replace(",", "."));
					float Bitcoin_convertido = Float.valueOf(BitcoinInformado.replace(",", "."));
					float Dinheiro_convertido = Float.valueOf(DinheiroInformado.replace(".", "").replace(",", "."));

					// Escrevendo no Console
					System.out.println("Bitcoin: " + Bitcoin_convertido + " " + "Dinheiro: " + Dinheiro_convertido);

					// Escrevendo no Console
					System.out.println("Moeda: " + TipoMoeda + " " + "Operacao: " + TipoOperacao + " " + "TipoTaxa: "
							+ TipoTaxa + " " + "Passiva: " + taxa_passiva + " " + "Fixa: " + taxa_fixa);
					
					// Escrevendo no Console
					System.out.println("ValorTaxaServico: " + TaxaServico);
					System.out.println("ValorLiquido: " + ValorLiquido_);
					System.out.println("Bitcoin_convertido: " + Bitcoin_convertido);
					System.out.println("Dinheiro_convertido: " + Dinheiro_convertido);

					float CalculoTaxaServico = (taxa_passiva * Bitcoin_convertido);
					System.out.println("Calculo: " + CalculoTaxaServico);

					float CalculoValorLiquido = (Bitcoin_convertido - TaxaServico);
					System.out.println("Calculo: " + CalculoValorLiquido);

					if (CalculoTaxaServico == TaxaServico && CalculoValorLiquido == ValorLiquido_) {

						System.out.println("TAXA OK");
						System.out.println("Valor Liquido OK");

						Taxas = new String("OK");

					} else {

						System.out.println("TAXA DIFERENTE");

						System.out.println("VALOR LIQUIDO DIFERENTE");

						Taxas = new String("NOK");
					}
				}

				if (TipoTaxa == "Ativa") {

					// Convertendo a String em Float
					float TaxaServico = Float.valueOf(ValorTaxaServico.replace(",", "."));
					float ValorLiquido_ = Float.valueOf(ValorLiquido.replace(",", "."));
					float Bitcoin_convertido = Float.valueOf(BitcoinInformado.replace(",", "."));
					float Dinheiro_convertido = Float.valueOf(DinheiroInformado.replace(".", "").replace(",", "."));
					String Convertido = ValorTaxaServico.replace(",", ".");

					// Escrevendo no Console
					System.out.println("Bitcoin: " + Bitcoin_convertido + " " + "Dinheiro: " + Dinheiro_convertido);

					// Escrevendo no Console
					System.out.println("Moeda: " + TipoMoeda + " " + "Operacao: " + TipoOperacao + " " + "TipoTaxa: "
							+ TipoTaxa + " " + "Ativa: " + taxa_ativa + " " + "Fixa: " + taxa_fixa);

					// Escrevendo no Console
					System.out.println("Taxa Serviço: " + TaxaServico);
					System.out.println("Taxa Serviço: " + Convertido);
					System.out.println("ValorLiquido: " + ValorLiquido_);
					System.out.println("Bitcoin_convertido: " + Bitcoin_convertido);
					System.out.println("Dinheiro_convertido: " + Dinheiro_convertido);

					/** Calculando e Convertendo em BigDecimal */
					float CalculoBitcoins = (Dinheiro_convertido/Livro_Venda);
					System.out.println("Calculo1: " + CalculoBitcoins);

					BigDecimal CalculoBitcoins_BIG = BigDecimal.valueOf(CalculoBitcoins);									
					CalculoBitcoins_BIG = CalculoBitcoins_BIG.setScale(8, BigDecimal.ROUND_HALF_DOWN);		

					System.out.println("Calculo1: " + CalculoBitcoins_BIG);
					/** */

					/** Calculando e Convertendo em BigDecimal */
					float CalculoTaxaServico = (CalculoBitcoins * taxa_ativa);
					System.out.println("Calculo2: " + CalculoTaxaServico);

					BigDecimal CalculoTaxaServico_BIG = BigDecimal.valueOf(CalculoTaxaServico);									
					CalculoTaxaServico_BIG = CalculoTaxaServico_BIG.setScale(8, BigDecimal.ROUND_HALF_DOWN);		

					System.out.println("Calculo2: " + CalculoTaxaServico_BIG);
					/** */

					/** Calculando e Convertendo em BigDecimal */
					float CalculoValorLiquido = (CalculoBitcoins - CalculoTaxaServico);
					System.out.println("Calculo3: " + CalculoValorLiquido);

					BigDecimal CalculoValorLiquido_BIG = BigDecimal.valueOf(CalculoValorLiquido);									
					CalculoValorLiquido_BIG = CalculoValorLiquido_BIG.setScale(8, BigDecimal.ROUND_HALF_DOWN);

					System.out.println("Calculo3: " + CalculoValorLiquido_BIG);
					/** */

					/** Convertendo em BigDecimal */
					BigDecimal Bitcoin_convertido_BIG = BigDecimal.valueOf(Bitcoin_convertido);									
					Bitcoin_convertido_BIG = Bitcoin_convertido_BIG.setScale(8, BigDecimal.ROUND_HALF_DOWN);

					System.out.println("BitcoinConvertido: " + Bitcoin_convertido_BIG);
					/** */

					/** Convertendo em BigDecimal */
					BigDecimal TaxaServico_BIG = BigDecimal.valueOf(TaxaServico);									
					TaxaServico_BIG = TaxaServico_BIG.setScale(8, BigDecimal.ROUND_HALF_DOWN);

					System.out.println("TaxaServicoConvertido: " + TaxaServico_BIG);
					/** */

					/** Convertendo em BigDecimal */
					BigDecimal ValorLiquido_BIG = BigDecimal.valueOf(ValorLiquido_);									
					ValorLiquido_BIG = ValorLiquido_BIG.setScale(8, BigDecimal.ROUND_HALF_DOWN);

					System.out.println("ValorLiquidoConvertido: " + ValorLiquido_BIG);

					/** */

					if (CalculoTaxaServico_BIG.equals(TaxaServico_BIG) && CalculoValorLiquido_BIG.equals(ValorLiquido_BIG) && (CalculoBitcoins_BIG.equals(Bitcoin_convertido_BIG))) { // (CalculoBitcoins_BIG.equals(Bitcoin_convertido_BIG)

						System.out.println("BICOIN OK");
						System.out.println("TAXA OK");
						System.out.println("Valor Liquido OK");

						Taxas = new String("OK");

					} else {

						System.out.println("BICOIN DIFERENTE");
						System.out.println("TAXA DIFERENTE");
						System.out.println("VALOR LIQUIDO DIFERENTE");

						Taxas = new String("NOK");
					}
				}	
			}
			
			break;
			
		case "Vip":

			// Escrevendo no Console
			System.out.println("Taxas para o usuário Usuário Vip");

			break;

		case "Zater":

			// Escrevendo no Console
			System.out.println("Taxas para o usuário Usuário Zater");

			break;

		case "Premium":

			// Escrevendo no Console
			System.out.println("Taxas para o usuário Usuário Premium");

			break;


		default:

			// Escrevendo no Console
			System.out.println("Não existe Taxas para esse usuário");

			Taxas = new String("NOK");

			break;


		}
		return Taxas; 	
	}

}

/**********************************************************************************************
 * 	 *	*	*	*	*	*	*	* 	 *	*	*	*	*	*	*	* 	*	*	*	*	*	*	* */
/**	Conta			Tipo   			Operações   		Passiva  		Ativa  			Fixa ***
		normal 			btc    			withdraw     		0       		0.0089  		0 
		normal 			money 			withdraw 			0 				0.0089 			10 
		normal 			btc 			sell 				0.0019 			0.0049 			0 
		normal 			btc 			buy 				0.0019 			0.0049 			0 
		vip 			money 			withdraw 			0 				0.01 			0 
		vip 			btc 			withdraw 			0 				0.01 			0 
		vip 			btc 			sell 				0 				0 				0 
		vip 			btc 			buy 				0 				0 				0 
		zater 			money 			withdraw 			0 				0 				0 
		zater 			btc 			withdraw 			0 				0 				0 
		zater 			btc 			sell 				0 				0 				0 
		zater 			btc 			buy 				0 				0 				0 
		premium 		money 			withdraw 			0.001 			0 				0 
		premium 		btc 			withdraw 			0.001 			0 				0 
		premium 		btc 			sell 				0.001 			0.001 			0 
 ***	premium 		btc 			buy 				0.001 			0.001 			0	**/ 

/**********************************************************************************************/

