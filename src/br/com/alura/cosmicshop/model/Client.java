package br.com.alura.cosmicshop.model;

import br.com.alura.cosmicshop.calculations.ItemCompra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    //Variaveis, construtor, getters e setters
    private String nome;
    private String planeta;
    private String descricaoDaCompra;
    private double valorDaCompra;
    private double limiteDoCartao;
    private String plano;
    private String sair; //para sair do menu ou inserir dados iniciais
    private String sair2;
    private String raridade; //Criado para remover o bug do nextInt (o nextInt() não consome a quebra de linha)
    private Scanner in = new Scanner(System.in); //Encapsulando Scanner
    private List<ItemCompra> itensDeCompra = new ArrayList<>(); //Aqui vai ser armazado o que for instanciado no adicionar item

    //Não vamos inserir diretamente no construtor, vamos inserir atráves de metodos para o usuario inserir pelo Scanner
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
        System.out.println("Digite a sua entidade: ");
        this.nome = this.in.nextLine();
        System.out.println("Digite seu planeta: ");
        this.planeta = this.in.nextLine();
        System.out.println("""
                Junte-se a nós e explore o cosmos infinito. 
                Quer participar? Digite 'QUERO!'
                Ou 'Sair' para voltar ao seu planeta...
                """);
        this.sair = this.in.nextLine();
        while (!this.sair.equals("Sair")) {
            System.out.println("""
                    Planos disponiveis: (Em breve teremos o plano Metaverso)
                    Astro studies 📚
                    Stellar transport 🚀
                    Centro de Apoio Interspacial (CAI) 🚰
                        """);
            this.plano = this.in.nextLine().toUpperCase(); //O to upper case vai servir pra ignorar se é minusculo ou maisculo quando o usuario digitar
            if (this.plano.equals("Astro studies".toUpperCase())) {
                this.limiteDoCartao = 50010.70;
                System.out.printf("""
                        Este grupo seria responsável por realizar pesquisas e estudos aprofundados no campo da astronomia e da astrofísica. 
                        Eles podem estar envolvidos em explorar novos planetas, investigar estrelas, identificar exoplanetas e estudar fenômenos cósmicos.
                        Você tem disponível %.2f Stelares disponiveis para suas pesquisas!🔭
                        """, this.limiteDoCartao);
                break;

            } else if (this.plano.equals("Stellar transport".toUpperCase())) {
                this.limiteDoCartao = 1000000;
                System.out.printf("""
                        Este grupo estaria encarregado de desenvolver tecnologias e infraestruturas para o transporte e exploração de sistemas estelares.
                        Eles seriam a espinha dorsal da exploração espacial.
                        Você tem disponível %.2f Stelares para suas viajens, explore e viva experiências únicas!🚀
                        %n""", this.limiteDoCartao);
                break;

            } else if (this.plano.equals(" Centro de Apoio Interspacial (CAI)".toUpperCase())) {
                this.limiteDoCartao = 300000.80;
                System.out.printf("""
                        A CAI é uma instalação dedicada a fornecer assistência, recursos e suporte para comunidades em ambientes interestelares
                        Você tem disponível %.2f Stelares. Cultive a harmonia nesse vasto universo!🕊️
                        """, this.limiteDoCartao);
                break;

            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
            //Se eu não colocar essa linha ficará em um loop infinito, pois preciso que o usuario digite, para o while ler o valor novamente
            //Pois assim que o loop se encerra, ele não volta na variavel da linha 87, ele executa o loop novamente, então tenho que perguntar novamente...
            this.plano = this.in.nextLine().toUpperCase();
        }

    }

    //Criando menu
    public void adicionarItem() {
        System.out.printf("""
                                
                                
                Olá %s!
                Digite 'continuar' caso queira adquirir algum item
                Ou 'sair' para encerrar agora o sistema
                """, nome);
        this.sair2 = this.in.nextLine();
        while (!this.sair2.equals("Sair")) {
            System.out.println("""
                                        
                    O que você procura?
                    """);
            this.descricaoDaCompra = this.in.nextLine();

            System.out.println("Digite o valor substimado: ");
            this.valorDaCompra = this.in.nextDouble();
            this.limiteDoCartao = this.limiteDoCartao - this.valorDaCompra;
            this.in.nextLine(); //Tratando enter pendente //Explicação: se você chamar nextLine() imediatamente após nextDouble(), o nextLine() irá consumir o Enter pendente, o que pode levar a comportamentos inesperados, como a leitura de uma linha vazia.

            System.out.println("Qual é a raridade desse item no seu planeta? ");
            this.raridade = this.in.nextLine();

            ItemCompra item = new ItemCompra(descricaoDaCompra, valorDaCompra, raridade);
            itensDeCompra.add(item);

            System.out.printf("""
                    Aqui está seu item:
                    %s
                    %.2f
                    %s
                                        
                    Limite disponível:
                    %.2f
                    """, descricaoDaCompra, valorDaCompra, raridade, limiteDoCartao);
            System.out.println("Digite qualquer coisa se quiser continuar, ou 'Sair' para finalizar as compras");
            this.sair2 = this.in.nextLine();
        }
    }

    public void mostrarItensDaCompra() {
        System.out.println("Todos os itens: ");
        for (ItemCompra item : itensDeCompra) {
            System.out.println("**************");
            System.out.printf("""
                    Descrição: %s
                    Valor: %.2f
                    Raridade: %s
                    """, item.getDescricao(), item.getValor(), item.getRaridade());
            System.out.println("**************");
        }
    }
}
