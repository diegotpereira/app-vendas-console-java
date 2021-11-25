package br.com.java.view;

public class MenuFuncionario extends Menu {
    
    public void display() {
        Menu.limpaTela();
        System.out.println("***************** MENU FUNCIONÁRIO ****************\n");
        System.out.println("Olá " + super.getNomeUsuarioAtivo() + ", o que deseja fazer?");
        System.out.println("Opções ");
        System.out.println("1 - Cadastrar item no cardápio");
        System.out.println("2 - Ver meus rendimentos");
        System.out.println("3 - Solicitar aquisição de materiais");
        System.out.println("4 - Cadastrar novo cliente");
        System.out.println("5 - Visualizar itens no estoque");
        System.out.println("6 - Logout");
    }
}
