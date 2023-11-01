package br.com.alura.cosmicshop.model;

import java.util.Scanner;

public class Client {
    //Variaveis, construtor, getters e setters
    private String nome;
    private String planeta;
    private String descricaoDaCompra;
    private double valorDaCompra;
    private double limiteDoCartao;
    private String plano;
    private Scanner in = new Scanner(System.in); //Encapsulando Scanner


    public Client(String nome, String planeta, String descricaoDaCompra, double valorDaCompra, double limiteDoCartao) {

        this.nome = nome;
        this.planeta = planeta;
        this.descricaoDaCompra = descricaoDaCompra;
        this.valorDaCompra = valorDaCompra;
        this.limiteDoCartao = limiteDoCartao;
    }

    public Client() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlaneta() {
        return planeta;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }

    public String getDescricaoDaCompra() {
        return descricaoDaCompra;
    }

    public void setDescricaoDaCompra(String descricaoDaCompra) {
        this.descricaoDaCompra = descricaoDaCompra;
    }

    public double getValorDaCompra() {
        return valorDaCompra;
    }

    public void setValorDaCompra(double valorDaCompra) {
        this.valorDaCompra = valorDaCompra;
    }

    public double getLimiteDoCartao() {
        return limiteDoCartao;
    }

    public void setLimiteDoCartao(double limiteDoCartao) {
        this.limiteDoCartao = limiteDoCartao;
    }

    //Metodos mais genericos da classe mae
    public void inserirLimite(double limiteDoCartao) {
        this.limiteDoCartao += limiteDoCartao;
    }

    //Forma mais otimizada e objetiva
    public void inserirDadosIniciais() {
        System.out.println("Digite o seu nome: ");
        this.nome = this.in.nextLine();
        System.out.println("Digite seu planeta: ");
        this.planeta = this.in.nextLine();
        System.out.println("""
                Digite seu plano ou Sair para sair do sistema:
                Planos disponiveis:
                Astro studies 📚
                Stellar transport 🚀
                Centro de Apoio Interspacial (CAI) 🚰
                """);
        this.plano = this.in.nextLine().toUpperCase(); //O to upper case vai servir pra ignorar se é minusculo ou maisculo quando o usuario digitar
        while (!this.plano.equals("Sair")) {
            if (this.plano.equals("Astro studies".toUpperCase())) {
                this.limiteDoCartao = 50010.70;
                System.out.printf("""
                        Este grupo seria responsável por realizar pesquisas e estudos aprofundados no campo da astronomia e da astrofísica. 
                        Eles podem estar envolvidos em explorar novos planetas, investigar estrelas, identificar exoplanetas e estudar fenômenos cósmicos.
                        Você tem disponível %.2f Stelares disponiveis para suas pesquisas!🔭
                        """, this.limiteDoCartao);

            } else if (this.plano.equals("Stellar transport".toUpperCase())) {
                this.limiteDoCartao = 1000000;
                System.out.printf("""
                        Este grupo estaria encarregado de desenvolver tecnologias e infraestruturas para o transporte e exploração de sistemas estelares.
                        Eles seriam a espinha dorsal da exploração espacial.
                        Você tem disponível %.2f Stelares para suas viajens, explore e viva experiências únicas!🚀
                        %n""", this.limiteDoCartao);

            } else if (this.plano.equals(" Centro de Apoio Interspacial (CAI)".toUpperCase())) {
                this.limiteDoCartao = 300000.80;
                System.out.printf("""
                        A CAI é uma instalação dedicada a fornecer assistência, recursos e suporte para comunidades em ambientes interestelares
                        Você tem disponível 300.000.30 Stelares. Cultive a harmonia nesse vasto universo!🕊️
                        """, this.limiteDoCartao);

            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
            //Se eu não colocar essa linha ficará em um loop infinito, pois preciso que o usuario digite, para o while ler o valor novamente
            //Pois assim que o loop se encerra, ele não volta na variavel da linha 87, ele executa o loop novamente, então tenho que perguntar novamente...
            this.plano = this.in.nextLine().toUpperCase();
        }
    }
}
