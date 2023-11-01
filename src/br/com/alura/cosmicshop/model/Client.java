package br.com.alura.cosmicshop.model;

public class Client {
    //Variaveis, construtor, getters e setters
    private String nome;
    private String planeta;
    private String descricaoDaCompra;
    private double valorDaCompra;
    private double limiteDoCartao; //Definido pelo Cliente


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
}
