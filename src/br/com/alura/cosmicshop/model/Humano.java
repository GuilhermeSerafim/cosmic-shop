    package br.com.alura.cosmicshop.model;

    //Para aplicar conceito de polimorfismo
    public class Humano extends Client {
        private String pais;
        private String estado;

        @Override
        public void inserirDadosIniciais() {
            super.inserirDadosIniciais();
            System.out.println("Digite seu país: ");
            pais = getIn().nextLine();
            System.out.println("Digite seu estado: ");
            estado = getIn().nextLine();
        }

        @Override
        public void exibirCliente() {
            System.out.println("Entidade: " + getEntidade());
            System.out.println("Planeta: " + getPlaneta());
            System.out.printf("""
                    Localização:
                    País - %s
                    Estado - %s
                    """, pais, estado);
        }
    }
