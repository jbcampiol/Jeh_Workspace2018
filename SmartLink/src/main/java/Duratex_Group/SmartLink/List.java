package Duratex_Group.SmartLink;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class List {
	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		
		
		//C:\Users\jefferson.campinol\Desktop\Teste.txt

		System.out.println("Informe o caminho e o nome de arquivo texto: ");
		String nome = ler.nextLine();


		System.out.println("Conteúdo do arquivo texto: ");
		try {

			FileReader arq = new FileReader(nome);
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine(); // lê a primeira linha
			// a variável "linha" recebe o valor "null" quando o processo
			// de repetição atingir o final do arquivo texto
			
			String foo = linha;
			String[] split = foo.split(",");
			
			System.out.println(split.length);
			
			System.out.println(split[0]);
			System.out.println(split[1]);
			System.out.println(split[2]);
			
			System.out.println(split.toString());
			
			System.out.println(split);
			
			while (linha != null) {
				System.out.printf("%s\n", linha);

				linha = lerArq.readLine(); // lê da segunda até a última linha
				
				System.out.println(linha);
				
			}

			arq.close();
			
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
		
		

		System.out.println();
	}

}
