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
        //Validação
        while (!(nivelDeControleElemental > 0 && nivelDeControleElemental <= 3)) {
            System.out.println("Digite novamente, apenas um número de 1 a 3");
            nivelDeControleElemental = getIn().nextInt();
        }
        if (nivelDeControleElemental <= 2) {
            System.out.println("Temos treinamentos no nosso mundo em metaverso!");
            System.out.println("Também temos equipamentos mais facéis de manusear!");
        } else {
            System.out.printf("Então você é um mestre elemental! Que massa %s! \n", getEntidade());
            System.out.println("Temos equipamentos para aprimorar as suas habilidades!");
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
}
