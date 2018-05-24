package Duratex_Group.SmartLink;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Arquivo {
	public static void main(String[] args) throws Exception {

        final String caminhoDoArquivo = "C:\\Users\\jefferson.campinol\\Desktop\\Teste.txt";

        String leitura;

        File arqv1 = new File(caminhoDoArquivo);

        System.out.println("Dados do arquivo txt:");

        System.out.println("");

        BufferedReader entrada = new BufferedReader(new FileReader(arqv1));

        String linha = null;

        LineNumberReader lnr = new LineNumberReader(new FileReader(arqv1));
        lnr.skip(arqv1.length());
        int qtd = lnr.getLineNumber();
        int qtdLinhas = qtd + 1;
        System.out.println("Quantidade de linhas no arquivo txt: " + qtdLinhas + " linhas.");

        System.out.println("");

        Scanner scn1 = new Scanner(new File(caminhoDoArquivo));

        System.out.println("");

        ArrayList<String> recebeNumerosTxt = new ArrayList<String>();
        ArrayList<String> recebeNumerosSeparados = new ArrayList<String> ();


        for (int i = 0; (linha = entrada.readLine()) != null; i++) {

            recebeNumerosTxt.add(linha);

            for (int j = 0; j < recebeNumerosTxt.size(); j++)
            {
                //recebeNumerosSeparados.add(Double.parseDouble(recebeNumerosTxt[j]));
                System.out.println(recebeNumerosSeparados);
                
            }
        }

        System.out.println(recebeNumerosSeparados);
    }

}
