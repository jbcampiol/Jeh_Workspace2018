package Duratex_Group.SmartLink;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LendoArquivo {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		System.out.println("Informe o caminho e o nome de arquivo texto: ");
		String nome = ler.nextLine();

		System.out.println("Conteúdo do arquivo texto: ");
		try {

			FileReader arq = new FileReader(nome);
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine(); // lê a primeira linha
			// a variável "linha" recebe o valor "null" quando o processo
			// de repetição atingir o final do arquivo texto
			
			while (linha != null) {
				System.out.printf("%s\n", linha);

				linha = lerArq.readLine(); // lê da segunda até a última linha
			}

			arq.close();
			
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

		System.out.println();
	}

}
