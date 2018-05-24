package Duratex_Group.SmartLink;

import java.util.Scanner;

public class Arrays {

	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);

		System.out.println("Informe a idade: ");
		
		String ConsoleIdade = ler.nextLine();
		
		int idade = Integer.parseInt(ConsoleIdade);
		
		int[] idades = new int[idade];
		
		for (int i = 0; i < idade; i++) {
			idades[i] = i * idade;
		}

		// imprimindo toda a array
		for (int x : idades) {
			System.out.println(x);
		}
	}
}
