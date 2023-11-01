package br.com.alura.cosmicshop.model;

public class Cliente {
    //Variaveis, construtor, getters e setters
    private String nome;
    private String planeta;
    private String descricaoDaCompra;
    private double valorDaCompra;
    private double limiteInicialDoCartao; //Definido pelo Cliente


    public Cliente(String nome, String planeta, String descricaoDaCompra, double valorDaCompra, double limiteDoCartao) {

        this.nome = nome;
        this.planeta = planeta;
        this.descricaoDaCompra = descricaoDaCompra;
        this.valorDaCompra = valorDaCompra;
        this.limiteInicialDoCartao = limiteDoCartao;
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

    public double getLimiteInicialDoCartao() {
        return limiteInicialDoCartao;
    }

    public void setLimiteInicialDoCartao(double limiteInicialDoCartao) {
        this.limiteInicialDoCartao = limiteInicialDoCartao;
    }


}
