package br.com.alura.cosmicshop.calculations;

public class ItemCompra {
    private String descricao;
    private double valor;
    private String raridade;

    public ItemCompra(String descricao, double valor, String raridade) {
        this.descricao = descricao;
        this.valor = valor;
        this.raridade = raridade;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getRaridade() {
        return raridade;
    }
}
