package Duratex_Group.SmartLink;

import java.util.Scanner;

/**
 * Hello world!
 *
 */

public class App{
	
         public static void main (String [ ] args){
          
        	 int dados;
        	 String Texto;
        	 
        	 // aceita int
        	 Scanner teclado = new Scanner (System.in);
        	 System.out.println("Insira dados: ");   // aqui deviam aparecer os dados logo com o espaço automático...
        	 dados = teclado.nextInt();
        	 
        	 System.out.println("Dados inseridos: " + dados);
        	 
        	 // aceita String
        	 Scanner teclado1 = new Scanner (System.in);
        	 System.out.println("Insira o Texto: ");
        	 Texto = teclado1.nextLine();
        	 
        	 System.out.println("Texto inseridos: " + Texto);      	         	 
        	 
    }
}