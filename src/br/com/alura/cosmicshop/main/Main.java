package br.com.alura.cosmicshop.main;

import br.com.alura.cosmicshop.model.Client;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem vindo a Cosmic Shop");
        Client cliente = new Client();
        cliente.inserirDadosIniciais();
    }
}