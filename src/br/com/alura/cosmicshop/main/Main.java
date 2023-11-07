package br.com.alura.cosmicshop.main;

import br.com.alura.cosmicshop.model.Client;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem vindo a Cosmic Shop");
        Client guilherme = new Client();
        guilherme.inserirDadosIniciais();
        guilherme.adicionarItem();
        guilherme.mostrarItensDaCompra();

//        Client anderson = new Client();
//        anderson.inserirDadosIniciais();
//        anderson.adicionarItem();
    }
}