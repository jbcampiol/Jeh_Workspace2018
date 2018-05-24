package Duratex_Group.SmartLink;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LendoArquivo1 {

	public static void main(String[] args) {
	    
		Scanner ler = new Scanner(System.in);
		
		//C:\Users\jefferson.campinol\Desktop\Teste.txt

	    System.out.printf("Informe o nome de arquivo texto:\n");
	    String nome = ler.nextLine();

	    System.out.printf("\nConteúdo do arquivo texto:\n");
	    try {
	        /**
	         * VAMOS CRIAR A LISTA DE STRINGS ONDE VAMOS ARMAZENAR
	         */
	    	ArrayList <String> listPalavras = new ArrayList<>();

	      FileReader arq = new FileReader(nome);
	      BufferedReader lerArq = new BufferedReader(arq);

	      String linha = lerArq.readLine(); // lê a primeira linha

	      while (linha != null) {
	        System.out.printf("%s\n", linha);
	          /**
	           * PARA PEGARMOS AS PALAVRAS,VAMOS SEPARAR A LINHA POR ESPAÇOS!
	           */
	        String[] palavrasDaLinha = linha.split(",");
	        /**
	           * VAMOS ARAMZENAR O ARRAY NA LISTA
	           */
	        for(String palavra : palavrasDaLinha) {
	              /**
	               * VAMOS CONSIDERAR PALAVRAS APENAS O QUE TENHA UM TAMANHO MAIOR QUE 1 
	               * ESPACOS VAZIOS, TAMBÉM NAO SÃO CONSIDERADOS
	               */
	            if( palavra.trim().length() > 1 && !"".equals(palavra.trim())) {
	                listPalavras.add(palavra);  
	            }

	        }

	        linha = lerArq.readLine(); // lê da segunda até a última linha
	      }

	      arq.close();
	      /**
	       * VAMOS INFORMAR O TAMANHO DA LISTA, POR EXEMPLO
	       */
	      System.out.println("\n\n");
	      System.out.printf("Total de palavras no arquivo: %s\n", listPalavras.size());

	    } catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: %s.\n",
	          e.getMessage());
	    }

	    System.out.println();
	  }
	
}
