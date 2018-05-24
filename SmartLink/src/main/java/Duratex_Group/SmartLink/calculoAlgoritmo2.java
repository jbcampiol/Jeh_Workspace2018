package Duratex_Group.SmartLink;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class calculoAlgoritmo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		10 – Crie um método chamado ‘calculoAlgoritimo’, onde recebe um número 
		em formato ‘String’ e o programa multiplique esse valor por 10, imprime 
		essa mensagem no console e retorne o resultado no final do tipo ‘Int’.
		*/
		
		String numero = null;
		String multiplicador = "10";
		
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
				
		int calculo = Integer.parseInt(numero) * Integer.parseInt(multiplicador);
		
		System.out.println("Valor do Calculo: " + calculo);
		
	}

}
