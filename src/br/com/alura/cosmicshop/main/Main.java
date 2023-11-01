package br.com.alura.cosmicshop.main;

import br.com.alura.cosmicshop.model.Client;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Client cliente = new Client();
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o limite");
        cliente.inserirLimite(in.nextDouble());
        System.out.println(cliente.getLimiteDoCartao());
    }
}