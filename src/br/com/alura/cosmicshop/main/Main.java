package br.com.alura.cosmicshop.main;

import br.com.alura.cosmicshop.model.Client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem vindo a Cosmic Shop");
        Client guilherme = new Client();
        guilherme.inserirDadosIniciais();
        guilherme.adicionarItens();
        guilherme.mostrarItensDaCompraComparados();

        Client anderson = new Client();
        anderson.inserirDadosIniciais();
        anderson.adicionarItens();
        anderson.mostrarItensDaCompraComparados();

        //A ordenação para mostrar os clientes são em ordem alfabética, enquanto a dos itens é por valor
        List<Client> clientes = new ArrayList<>();
        clientes.add(guilherme);
        clientes.add(anderson);
        //Ordenação alfabética pelo nome do cliente
        Collections.sort(clientes);
        for(Client client: clientes) {
            System.out.println("---------------");
            client.exibirCliente();
            System.out.println("---------------");
        }
    }
}