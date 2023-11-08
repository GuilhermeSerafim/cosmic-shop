package br.com.alura.cosmicshop.main;

import br.com.alura.cosmicshop.model.Client;
import br.com.alura.cosmicshop.model.Elemental;
import br.com.alura.cosmicshop.model.Humano;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Bem vindo a Cosmic Shop");
//        Humano guilherme = new Humano();
//        guilherme.inserirDadosIniciais();
//        guilherme.adicionarItens();
//        guilherme.mostrarItensDaCompraComparados();

        Elemental nexastral = new Elemental();
        nexastral.inserirDadosIniciais();
        nexastral.adicionarItens();
        nexastral.mostrarItensDaCompraComparados();

        //A ordenação para mostrar os clientes são em ordem alfabética, enquanto a dos itens é por valor
        List<Client> clientes = new ArrayList<>();
//        clientes.add(guilherme);
        clientes.add(nexastral);

        //Ordenação alfabética pelo nome do cliente
        Collections.sort(clientes);
        for(Client client: clientes) {
            System.out.println("---------------");
            client.exibirCliente();
            System.out.println("---------------");
        }
    }
}