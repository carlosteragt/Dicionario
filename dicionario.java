package br.edu.univas;

import java.util.Scanner;

public class dicionario {
    public static void main(String[] args) {
        String palavra[] = new String[100];
        String traducao[] = new String[100];
        int opçao = 1;
        Scanner Scanner = new Scanner(System.in);
        while (opçao != 5) {
            System.out.println("Escolha uma opçao: ");
            System.out.println("1 - Registrar uma nova palavra ");
            System.out.println("2 - Encontrar uma palavra ");
            System.out.println("3 - Editar uma palavra ");
            System.out.println("4 - Excluir uma palavra ");
            System.out.println("0 - Sair");
            System.out.println("-------------------------------------");
            opçao = Scanner.nextInt();
            System.out.println("");

            if (opçao == 1) {
                registro(palavra);
                registroTraducao(traducao, palavra);
                System.out.println("-------------------------------------");
            } else if (opçao == 2) {
                encontrarPalavra(palavra,traducao);
                System.out.println("-------------------------------------");
            } else if (opçao == 3) {
                editarPalavra(palavra, traducao);
                System.out.println("-------------------------------------");
            }else if (opçao == 4) {
                excluirPalavra(palavra, traducao);
                System.out.println("-------------------------------------");
            } else {
                break;
            }
        }


    }

    public static String[] registro(String palavra[]) {
        Scanner Scanner = new Scanner(System.in);
        System.out.println("Digite uma palavra em ingles: ");
        for (int x = 0; x < 100; x++) {
            if (palavra[x] == null) {
                palavra[x] = Scanner.next();
                return verificarRegistro(palavra);
            }
        }
        return palavra;
    }

    public static String[] verificarRegistro(String palavra[]) {
        for (int x = 0; x < 100; x++) {
            int i = 1;
            for (i = i + x; i < 100; i++) {
                if (palavra[x] == null) {

                } else if (palavra[x].equals(palavra[i])) {
                    palavra[i] = null;
                    System.out.println("Essa palavra já esta registrada ");
                    return palavra;
                }
            }
        }
        return palavra;
    }
    public static String[] registroTraducao(String traducao[], String palavra[]) {
        Scanner Scanner = new Scanner(System.in);
        for (int x = 0; x < 100; x++) {
            if (palavra[x] == null) {
                return traducao;
            }
            else if(traducao[x] == null){
                System.out.println("Digite sua traducao: ");
                traducao[x] = Scanner.next();
                return traducao;
            }
        }
        return traducao;
    }
    public static void encontrarPalavra(String palavra[], String traducao[]){
        Scanner Scanner = new Scanner(System.in);
        System.out.println("Escolha um metodo de busca: ");
        System.out.println("1 - Para encontrar uma palavra no dicionario ");
        System.out.println("2 - Para digitar uma palavra do dicionario ");
        int opcao = Scanner.nextInt();
        if(opcao == 1){
            System.out.println("Digite um numero de 0 a 99 para ver uma palavra: ");
            int numero = Scanner.nextInt();
            System.out.println(palavra[numero]);
            System.out.println(traducao[numero]);
        }
        else if(opcao == 2)
        {
            System.out.println("Digite a palavra: ");
            String p = Scanner.next();
            for(int x = 0; x < 100;x++){
                if(palavra[x] == null){
                    System.out.println("Essa palavra não esta no dicionario");
                    break;
                }
                else if(palavra[x].equals(p)){
                    System.out.println(traducao[x]);
                    break;
                }
                else if(x == 99){
                    System.out.println("Essa palavra não esta no dicionario");
                }
            }
        }

    }

    public static void editarPalavra(String palavra[], String traducao[]){
        Scanner Scanner = new Scanner(System.in);
        System.out.println("Digite um numero de 0 a 99 para ver uma palavra: ");
        int numero = Scanner.nextInt();
        System.out.println(palavra[numero]);
        System.out.println("Deseja editar essa palavra? ");
        System.out.println("1 - Sim ");
        System.out.println("2 - Não ");
        int opcao = Scanner.nextInt();
        if (opcao == 1){
            System.out.println("Digite a nova palavra: ");
            String Palavra = Scanner.next();
            palavra[numero] = Palavra;
            verificarRegistro(palavra);
            if (palavra[numero] == null){
                traducao[numero] = null;
            }else{
                System.out.println("Digite sua traduçao: ");
                String Traducao = Scanner.next();
                traducao[numero] = Traducao;
            }
        }
    }
    public static String[] excluirPalavra(String palavra[], String traducao[]){
        Scanner Scanner = new Scanner(System.in);
        System.out.println("Digite um numero de 0 a 99 para ver uma palavra: ");
        int numero = Scanner.nextInt();
        System.out.println(palavra[numero]);
        System.out.println("Deseja excluir essa palavra? ");
        System.out.println("1 - Sim ");
        System.out.println("2 - Não ");
        int opcao = Scanner.nextInt();
        if (opcao == 1){
            System.out.println("A palavra foi excluida ");
            palavra[numero] = null;
            traducao[numero] = null;
            return palavra;
        }else{
            return palavra;
        }
    }
}