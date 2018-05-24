package Duratex_Group.SmartLink;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class calculoAlgoritmo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		10 – Crie um método chamado ‘calculoAlgoritimo’, onde recebe um número 
		em formato ‘String’ e o programa multiplique esse valor por 10, imprime 
		essa mensagem no console e retorne o resultado no final do tipo ‘Int’.
		*/
		
		String numero = null;
		String multiplicador = "10";
		int calculo = 0;
		
		// Chamando para ler o Console
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// Informando no Console o Número
		System.out.print("Digite o Número: ");    
		
		try {
			numero = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Número Informada: " + numero);
						
		switch(numero) {
		case "1":
			
			calculo = Integer.parseInt(numero) * Integer.parseInt(multiplicador);
			
			System.out.println("Valor do Calculo: " + calculo);
		
		break;
		
		case "2":
			
			calculo = Integer.parseInt(numero) * Integer.parseInt(multiplicador)/2;
			
			System.out.println("Valor do Calculo: " + calculo);
		
			
		break;
		
		case "3":
			
			calculo = Integer.parseInt(numero) * Integer.parseInt(multiplicador)-3;
			
			System.out.println("Valor do Calculo: " + calculo);
		
			
		break;
		
		
		default:

		// Escrevendo no Console
		System.out.println("ERROR - Numeros não aceitaveis");

		break;
		
				
		}
				
	}

}
