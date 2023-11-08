package br.com.alura.cosmicshop.model;

//Para aplicar conceito de polimorfismo
public class Elemental extends Client {
    private String especie;
    private String tipoElemental;
    private int nivelDeControleElemental;

    @Override
    public void inserirDadosIniciais() {
        super.inserirDadosIniciais();
        System.out.println("Digite sua espécie: ");
        especie = getIn().nextLine();
        System.out.println("Digite o seu tipo elemental: ");
        tipoElemental = getIn().next();
        System.out.println("Qual é o seu nível de controle, sobre o seu elemental?");
        System.out.println("Digite um número de 1 a 3");
        nivelDeControleElemental = getIn().nextInt();
        while((nivelDeControleElemental == 1 || nivelDeControleElemental == 2 || nivelDeControleElemental == 3)) {
            if (3 >= nivelDeControleElemental) {
                System.out.println("Temos treinamentos no nosso mundo em metaverso!");
                System.out.println("Aprenda a controlar sua habilidades, sem machucar ninguém!");
                break;
            } else if(nivelDeControleElemental >= 4) {
                System.out.printf("Parabéns %s", getEntidade());
                System.out.println("Temos equipamentos para aprimorar as suas habilidades!");
                break;
            } else {
                System.out.println("Digite novamente, apenas um número de 1 a 3");
                break;
            }
        }

    }

    @Override
    public void exibirCliente() {
        System.out.println("Entidade: " + getEntidade());
        System.out.println("Planeta: " + getPlaneta());
        System.out.println("Espécie: " + especie);
        System.out.println("Tipo elemental: " + tipoElemental);
        System.out.println("Nivel de controle do elemental: " + nivelDeControleElemental);
    }

    @Override
    public void adicionarItens() {
        super.adicionarItens();
    }
}
