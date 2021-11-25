package br.com.java.view;

public class MenuAdmin extends Menu {

    public void display() {
        Menu.limpaTela();
        System.out.println("********* MENU ADMINISTRADOR **********");
        System.out.println("Olá " + super.getNomeUsuarioAtivo() + ", o que você deseja?");
        System.out.println("Opções ");
        System.out.println("1 - Visualizar Vendas");
        System.out.println("2 - Visualizar requisições de compra");
        System.out.println("3 - Cadastrar novo funcionário");
        System.out.println("4 - Visualizar funcionários");
        System.out.println("5 - Visualizar clientes");
        System.out.println("6 - Visualizar itens no estoque");
        System.out.println("7 - Visualizar Registros do sistema");
        System.out.println("8 - Logout");
    }
    
}
