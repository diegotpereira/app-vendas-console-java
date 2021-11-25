package br.com.java;

import br.com.java.modelo.TipoProduto;
import br.com.java.modelo.TipoUsuario;
import br.com.java.view.Empresa;
import br.com.java.view.Menu;
import br.com.java.view.MenuAdmin;
import br.com.java.view.MenuCliente;
import br.com.java.view.MenuFuncionario;

public class App {
    public static void main(String[] args) throws Exception {

        Empresa empresa = new Empresa("Hot Dog Expresso");
        empresa.inicializa();

        Menu menu = new Menu();

        int logado = 0;
        int escolha = 0;

        do {
            if (logado == 0) {
                menu.login();

                int cod = menu.getCodigo();
                int senha = menu.getSenha();

                if (menu.doLogin(cod, senha, empresa.getClientes()) == TipoUsuario.CLIENTE) {
                    logado = 1;

                    MenuCliente menuCliente = new MenuCliente();
                    menuCliente.display();

                    escolha = menuCliente.getEscolhaMenu();

                    switch (escolha) {
                        case 1:
                            Menu.limpaTela();
                            empresa.comprar();
                            break;

                        case 2:
                            Menu.limpaTela();
                            empresa.visualizarCardapio(TipoProduto.COMIDAS);
                            break;

                        case 3:
                            Menu.limpaTela();
                            empresa.visualizarCardapio(TipoProduto.BEBIDAS);
                            break;

                        case 4:
                            Menu.limpaTela();
                            empresa.visualizarVendasCliente();
                            break;


                        case 5:
                            Menu.limpaTela();
                            menu.doLogout();
                            menu.setCodigo(0);
                            menu.setSenha(0);
                            logado = 0;
                            break;
                    }
                } else if (menu.doLogin(cod, senha, empresa.getFuncionarios()) == TipoUsuario.FUNCIONARIO) {
                    logado = 1;
                    MenuFuncionario menuFuncionario = new MenuFuncionario();
                    menuFuncionario.display();

                    escolha = menu.getEscolhaMenu();

                    switch (escolha) {
                        case 1:
                            Menu.limpaTela();
                            empresa.addCardapioItem();
                            break;

                        case 2:
                            Menu.limpaTela();
                            empresa.verRendimentos();
                            break;

                        case 3:
                            Menu.limpaTela();
                            empresa.requisitarCompras();
                            break;

                        case 4:
                            Menu.limpaTela();
                            empresa.addNovoCliente();
                            break;

                        case 5:
                            Menu.limpaTela();
                            empresa.visualizarEstoque();
                            break;

                        case 6:
                            menu.doLogout();
                            menu.setCodigo(0);
                            menu.setSenha(0);
                            logado = 0;
                            break;
                    }

                } else if (menu.doLogin(cod, senha, empresa.getFuncionarios()) == TipoUsuario.ADMINISTRADOR) {
                    logado = 1;
                    MenuAdmin menuAdmin = new MenuAdmin();
                    Menu.limpaTela();
                    menuAdmin.display();
                    escolha = menu.getEscolhaMenu();

                    switch (escolha) {
                        case 1:
                            Menu.limpaTela();
                            empresa.visualizarVendas();
                            break;

                        case 2:
                            Menu.limpaTela();
                            empresa.aprovarRequisicao();
                            break;

                        case 3:
                            Menu.limpaTela();
                            empresa.addNovoFuncionario();
                            break;

                        case 4:
                            Menu.limpaTela();
                            empresa.visualizarFuncionarios();
                            break;

                        case 5:
                            Menu.limpaTela();
                            empresa.visualizarClientes();
                            break;

                        case 6:
                            
                            break;

                        case 7:
                            
                            break;
                    
                        case 8:
                            break;
                    }
                } else {
                    System.out.println("\n*** Erro no login! *** \nUsuário e/ou senha incorretos!");
                    escolha = 100;
                    Menu.continuar();
                }
            }
        } while (escolha != 0);
    }
}
