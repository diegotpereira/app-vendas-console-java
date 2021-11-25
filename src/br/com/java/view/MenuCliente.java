package br.com.java.view;

public class MenuCliente extends Menu {
    
    public void display() {

        Menu.limpaTela();
        System.out.println("************** MENU CLIENTE **************\n");
        System.out.println("Olá " + super.getNomeUsuarioAtivo() + ", o que você deseja?");
        System.out.println("Opções ");
        System.out.println("1 - Comprar Hot Dog");
        System.out.println("2 - Visualizar cardápio de comidas");
        System.out.println("3 - Visualizar cardápio de bebidas");
        System.out.println("4 - Visualizar minhas compras");
        System.out.println("5 - Logout");
    }
}
