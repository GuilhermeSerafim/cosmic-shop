package br.com.alura.cosmicshop.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Client implements Comparable<Client> {
    //Variaveis, construtor, getters e setters
    private String entidade;
    private String planeta;
    private double limiteDoCartao;
    private String plano;
    private String sair; //para sair do menu ou inserir dados iniciais
    private final Scanner in = new Scanner(System.in); //Encapsulando Scanner
    private final List<ItemCompra> arrayItensDeCompras = new ArrayList<>(); //Aqui vai ser armazado o que for instanciado no adicionar item

    public Client() {

    }

    public String getEntidade() {
        return entidade;
    }

    public String getPlaneta() {
        return planeta;
    }

    public Scanner getIn() {
        return in;
    }

    //Forma mais otimizada e objetiva
    public void inserirDadosIniciais() {
        System.out.println("Digite a sua entidade: ");
        this.entidade = this.in.nextLine();
        System.out.println("Digite seu planeta: ");
        this.planeta = this.in.nextLine();
        System.out.println("""
                Faça compras e participe de um plano da nossa loja cósmica!
                Quer participar? Aperte enter!
                Ou 'Sair' para voltar ao seu planeta...
                """);
        this.sair = this.in.nextLine();
        while (!this.sair.equals("Sair")) {
            System.out.println("""
                    Digite o seu plano:
                    Astro studies 📚
                    Stellar transport 🚀
                    Centro de Apoio Interspacial (CAI) 🚰
                    (Em breve teremos o plano Metaverso)
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

            } else if (this.plano.equals("Centro de Apoio Interspacial".toUpperCase())) {
                this.limiteDoCartao = 300000.80;
                System.out.printf("""
                        A CAI é uma instalação dedicada a fornecer assistência, recursos e suporte para comunidades em ambientes interestelares.
                        A CAI dá suporte à vidas complexas espalhada pelo universo!
                        Você tem disponível %.2f Stelares. Cultive a harmonia nesse vasto universo!🕊️
                        """, this.limiteDoCartao);
                break;

            } else {
                System.out.println("Opção inválida. Aperte enter e tente novamente.");
            }
            //Se eu não colocar essa linha ficará em um loop infinito, pois preciso que o usuario digite, para o while ler o valor novamente
            //Pois assim que o loop se encerra, ele não volta na variavel da linha 87, ele executa o loop novamente, então tenho que perguntar novamente...
            this.plano = this.in.nextLine().toUpperCase();
        }

    }

    //Criando menu
    public void adicionarItens() {


        System.out.printf("""
                                
                                
                Olá %s!
                Aperte enter para comprar itens da nossa loja
                Ou 'sair' para encerrar agora o sistema
                """, entidade);
        this.sair = this.in.nextLine();
        while (!this.sair.equals("Sair")) {
            System.out.println("""
                                        
                    O que você procura?
                    """);
            String descricaoDaCompra = this.in.nextLine();

            System.out.println("Digite o valor da sua compra: ");
            double valorDaCompra = this.in.nextDouble();
            //Validações
            if (limiteDoCartao <= 0) {
                System.out.println("Você não tem stelares");
                break;
            } else if (valorDaCompra > this.limiteDoCartao) {
                System.out.println("Saldo insuficiente | Limite do cartão estelar");
                System.out.println(this.limiteDoCartao);
                this.in.nextLine(); // Consumir a quebra de linha da linha 168
                continue;
            }
            this.limiteDoCartao = this.limiteDoCartao - valorDaCompra;
            this.in.nextLine(); //Tratando enter pendente //Explicação: se você chamar nextLine() imediatamente após nextDouble(), o nextLine() irá consumir o Enter pendente, o que pode levar a comportamentos inesperados, como a leitura de uma linha vazia.

            System.out.println("Qual é a raridade desse item no seu planeta? ");
            //Criado para remover o bug do nextInt (o nextInt() não consome a quebra de linha)
            String raridade = this.in.nextLine();

            ItemCompra item = new ItemCompra(descricaoDaCompra, valorDaCompra, raridade);
            arrayItensDeCompras.add(item);

            System.out.printf("""
                    Aqui está seu item:
                    %s
                    %.2f
                    %s
                                        
                    Limite disponível:
                    %.2f
                    """, descricaoDaCompra, valorDaCompra, raridade, limiteDoCartao);
            System.out.println("Aperte enter para continuar comprando ou digite 'Sair' para finalizar as compras");
            this.sair = this.in.nextLine();
        }
    }

    public void mostrarItensDaCompraComparados() {
        //Comparador para ordenar preço
        Comparator<ItemCompra> itensComparador = Comparator.comparing(ItemCompra::getValor);
        arrayItensDeCompras.sort(itensComparador);

        System.out.println("Todos os itens: ");
        for (ItemCompra item : arrayItensDeCompras) {
            System.out.println("**************");
            System.out.printf("""
                    Descrição: %s
                    Valor: %.2f
                    Raridade: %s
                    """, item.getDescricao(), item.getValor(), item.getRaridade());
            System.out.println("**************");
        }
    }

    public void exibirCliente() {
        System.out.println(getEntidade());
        System.out.println(getPlaneta());
        System.out.println(plano);
        System.out.println(limiteDoCartao);
    }

    @Override
    public int compareTo(Client outroClient) {
        return this.getEntidade().compareTo(outroClient.getEntidade());
    }
}
