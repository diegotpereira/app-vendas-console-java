package br.com.java.view;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import br.com.java.modelo.Cliente;
import br.com.java.modelo.Data;
import br.com.java.modelo.Diretor;
import br.com.java.modelo.Funcionario;
import br.com.java.modelo.MateriaPrima;
import br.com.java.modelo.Produto;
import br.com.java.modelo.Registro;
import br.com.java.modelo.StatusProduto;
import br.com.java.modelo.TipoProduto;
import br.com.java.modelo.TipoUsuario;
import br.com.java.modelo.Venda;

public class Empresa {
    
    public String nome;
    List<Cliente> clientes;
    List<Funcionario> funcionarios;
    List<Venda> vendas;
    List<Produto> produtos;
    List<MateriaPrima> estoque;
    List<Registro> registros;
    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    Menu menu = new Menu();
    private Random randomGenerator;

    public Empresa(String nome) {
        this.nome = nome;
        clientes = new ArrayList<>();
        funcionarios = new ArrayList<>();
        produtos = new ArrayList<>();
        vendas = new ArrayList<>();
        randomGenerator = new Random();
        estoque = new ArrayList<>();
        registros = new ArrayList<>();
        
    }

    public void inicializa() {

        Cliente cliente1 = new Cliente(1, "Frank Castle", new Data(12, 05, 1986), "05430939983", 150);
        Cliente cliente2 = new Cliente(2, "Matt Murdock", new Data(5, 4, 1995), "02245678951", 250);
        Cliente cliente3 = new Cliente(3, "Jessica Jones", new Data(1, 12, 1946), "06340950943", 350);
        Cliente cliente4 = new Cliente(4, "Elektra Natchios", new Data(14, 7, 1992), "05450987451", 450);
        Cliente cliente5 = new Cliente(5, "Danny Rand", new Data(25, 1, 1999), "54012055819", 550);

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);
        clientes.add(cliente5);

        Funcionario funcionario1 = new Funcionario(1, "Bruce Banner", new Data(12, 05, 1986), "02193998352", 100, new BigDecimal(1000));
        Funcionario funcionario2 = new Funcionario(2, "Steve Rogers", new Data(5, 4, 1995), "02215478966", 200, new BigDecimal(1500));
        Funcionario funcionario3 = new Funcionario(3, "Natasha Romanoff", new Data(1, 12, 1946), "02660394871", 300, new BigDecimal(1250));
        Funcionario funcionario4 = new Funcionario(4, "Wanda Maximoff", new Data(14, 7, 1992), "02845785520", 400, new BigDecimal(1900));
        Funcionario funcionario5 = new Funcionario(5, "Tony Stark", new Data(25, 1, 1999), "60340913085", 500, new BigDecimal(1800));
        
        Funcionario admin = new Diretor(6, "Wilterson Garcia", new Data(5,4,1995), "05415988844", 666, new BigDecimal(12000));

        funcionarios.add(funcionario1);
        funcionarios.add(funcionario2);
        funcionarios.add(funcionario3);
        funcionarios.add(funcionario4);
        funcionarios.add(funcionario5);

        funcionarios.add(admin);


        Produto produto1 = new Produto(TipoProduto.COMIDAS, new BigDecimal(2.50), "Cachorro Quente Simples");
        Produto produto2 = new Produto(TipoProduto.COMIDAS, new BigDecimal(4), "Cachorro Quente Plus");
        Produto produto3 = new Produto(TipoProduto.COMIDAS, new BigDecimal(5.60), "Cachorro Quente Plus Catupiry");
        Produto produto4 = new Produto(TipoProduto.COMIDAS, new BigDecimal(10.90), "Cachorro Quente Plus Cheddar");
        Produto produto5 = new Produto(TipoProduto.COMIDAS, new BigDecimal(12.50), "Cachorro Quente Master Vina");
        Produto produto6 = new Produto(TipoProduto.COMIDAS, new BigDecimal(25), "Cachorro Quente Master Premium");
        Produto produto7 = new Produto(TipoProduto.BEBIDAS, new BigDecimal(4.50), "Coca-Cola Lata");
        Produto produto8 = new Produto(TipoProduto.BEBIDAS, new BigDecimal(5.50), "Coca-Cola 1 L");
        Produto produto9 = new Produto(TipoProduto.BEBIDAS, new BigDecimal(1.50), "Água");
        Produto produto10 = new Produto(TipoProduto.BEBIDAS, new BigDecimal(3.50), "Suco Natural");

        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);
        produtos.add(produto5);
        produtos.add(produto6);
        produtos.add(produto7);
        produtos.add(produto8);
        produtos.add(produto9);
        produtos.add(produto10);

        List<Produto> itensVenda = new ArrayList<>();
        itensVenda.add(produto1);
        itensVenda.add(produto2);
        itensVenda.add(produto10);

        Venda venda1 = new Venda(cliente1, itensVenda, funcionario1);
        vendas.add(venda1);

        BigDecimal valorTotal = new BigDecimal(0).add(produto1.getValor()).add(produto2.getValor()).add(produto10.getValor());
        funcionario1.setComissao(valorTotal);

        List<Produto> itensVenda2 = new ArrayList<>();
        itensVenda2.add(produto6);
        itensVenda2.add(produto10);
        itensVenda2.add(produto8);

        Venda venda2 = new Venda(cliente1, itensVenda2, funcionario1);
        vendas.add(venda2);

        BigDecimal valorTotal2 = new BigDecimal(0).add(produto6.getValor()).add(produto10.getValor()).add(produto8.getValor());
        funcionario1.setComissao(valorTotal2);

        List<Produto> itensVenda3 = new ArrayList<>();
        itensVenda3.add(produto5);
        itensVenda3.add(produto4);
        itensVenda3.add(produto7);

        Venda venda3 = new Venda(cliente1, itensVenda3, funcionario2);
        vendas.add(venda3);


        BigDecimal valorTotal3 = new BigDecimal(0).add(produto5.getValor()).add(produto4.getValor()).add(produto7.getValor());
        funcionario2.setComissao(valorTotal3);

        List<Produto> itensVenda4 = new ArrayList<>();
        itensVenda3.add(produto3);
        itensVenda3.add(produto5);
        itensVenda3.add(produto9);

        Venda venda4 = new Venda(cliente2, itensVenda4, funcionario4);
        vendas.add(venda4);


        BigDecimal valorTotal4 = new BigDecimal(0).add(produto3.getValor()).add(produto5.getValor()).add(produto9.getValor());
        funcionario4.setComissao(valorTotal4);

        List<Produto> itensVenda5 = new ArrayList<>();
        itensVenda5.add(produto6);
        itensVenda5.add(produto3);
        itensVenda5.add(produto7);

        Venda venda5 = new Venda(cliente3, itensVenda5, funcionario5);
        vendas.add(venda5);

        BigDecimal valorTotal5 = new BigDecimal(0).add(produto6.getValor()).add(produto3.getValor()).add(produto7.getValor());
        funcionario5.setComissao(valorTotal5);

        List<Produto> itensVenda6 = new ArrayList<>();
        itensVenda5.add(produto5);
        itensVenda5.add(produto4);
        itensVenda5.add(produto7);

        Venda venda6 = new Venda(cliente4, itensVenda6, funcionario3);
        vendas.add(venda6);


        BigDecimal valorTotal6 = new BigDecimal(0).add(produto5.getValor()).add(produto4.getValor()).add(produto7.getValor());
        funcionario3.setComissao(valorTotal6);

        MateriaPrima materia1 = new MateriaPrima("Salsichas", 500, new BigDecimal(250), funcionario1);
        MateriaPrima materia2 = new MateriaPrima("Pão para Cachorro Quente", 1500, new BigDecimal(150), funcionario1);
        MateriaPrima materia3 = new MateriaPrima("Catchup", 15, new BigDecimal(90), funcionario2);
        MateriaPrima materia4 = new MateriaPrima("Mostarda", 15, new BigDecimal(98), funcionario5);
        MateriaPrima materia5 = new MateriaPrima("Tomates", 30, new BigDecimal(45), funcionario4);
        MateriaPrima materia6 = new MateriaPrima("Catupiry", 5, new BigDecimal(28), funcionario2);

        estoque.add(materia1);
        estoque.add(materia2);
        estoque.add(materia3);
        estoque.add(materia4);
        estoque.add(materia5);
        estoque.add(materia6);

    }

    public List getClientes() {
        return clientes;
    }

    public List getFuncionarios() {
        return funcionarios;
    }

    public void getCardapio(TipoProduto tipo) {

        TipoProduto tipoProduto = TipoProduto.COMIDAS;

        if (tipo == TipoProduto.BEBIDAS) {
            tipoProduto = TipoProduto.BEBIDAS;
        }

        Menu.mostraCabecalhoCardapio(tipoProduto);

        for(int i =0; i < produtos.size(); i++) {
            if (produtos.get(i).getTipo() == tipoProduto) {
                
                System.out.format("%-6s | %-30s | %-15s \n",
                produtos.get(i).getCod(),
                produtos.get(i).getNome(),
                formatter.format(produtos.get(i).getValor()));
            }
        }
    }

    public void comprar() {
        int codComida;
        int codBebida = 0;
        int escolha;
        int usuarioAtivo = Menu.getUsuarioAtivo();
        int index = randomGenerator.nextInt(funcionarios.size());
        boolean compraValida = true;

        BigDecimal valorTotal = new BigDecimal(0);

        Funcionario funcionario = funcionarios.get(index);

        Scanner teclado = new Scanner(System.in);
        List<Produto> itensVenda = new ArrayList<>();

        getCardapio(TipoProduto.COMIDAS);
        codComida = menu.getEscolhaMenu();

        do {
            System.out.println("Deseja alguma bebida ? (1 - Sim / 2 - Não): ");
            escolha = teclado.nextInt();
            itensVenda.add(produtos.get(codComida-1));

            if (escolha == 1) {
                Menu.limpaTela();
                getCardapio(TipoProduto.BEBIDAS);
                codBebida = menu.getEscolhaMenu();

                itensVenda.add(produtos.get(codBebida -1));
            }
        } while (escolha != 1 && escolha != 2);

        for(int i = 0; i < itensVenda.size(); i++) {
            valorTotal = valorTotal.add(itensVenda.get(i).getValor());
        }

        for(int i = 0; i < vendas.size(); i++) {
            if (vendas.get(vendas.size() -1).getCodComprador() == Menu.getUsuarioAtivo() && vendas.get(vendas.size() -1).getValorTotal().equals(valorTotal)) {
                compraValida = false;
            }
        }

        if (compraValida) {
            Venda venda = new Venda(clientes.get(usuarioAtivo-1), itensVenda, funcionario);
            vendas.add(venda);
            funcionario.setComissao(valorTotal);

            System.out.println("Compra efetuada com sucesso! Aguarde seu pedido na mesa.");

            Registro log = new Registro("Compra efetuada no valor de R$" + valorTotal, Menu.getNomeUsuarioAtivo());
            registros.add(log);

        } else {
            System.out.println("Não foi possível realizar a compra.");
            System.out.println("Valor idêntico ao já cobrado.");
        }

        if (Menu.continuar()) {
            Menu.limpaTela();
        }
    }

    public void visualizarCardapio(TipoProduto tipoProduto) {
        getCardapio(tipoProduto);
        Menu.continuar();
    }

    public void visualizarVendasCliente() {
        for(int i = 0; i < vendas.size(); i++ ) {
            if (vendas.get(i).getCodComprador() == Menu.usuarioAtivo ) {
                System.out.format("%-10s %-25s\n", "Código: " + i, "Data da Venda: " + vendas.get(i).getDatavenda());
                System.out.println();

                for(int j = 0; j < vendas.get(i).getItensVenda().size(); j++) {

                    Produto produto = vendas.get(i).getItensVenda().get(j);

                    if (j == 0) { 
                        System.out.format("%-25s | %-10s\n", "Produto", "Valor");
                    }

                    System.out.format("%-25s | %-10s\n", produto.getNome(), formatter.format(produto.getValor()));
                }

                System.out.println("____________________________");
                System.out.format("%-25s | %-10s\n", "Total: ", formatter.format(vendas.get(i).getValorTotal()));
                System.out.println("\n");
            }
        }

        Menu.continuar();
    }

    // Menu para Funcionário
    public void addCardapioItem() {
        int tipo;
        String nome;
        BigDecimal valor;

        TipoProduto tipoProduto = TipoProduto.COMIDAS;
        Scanner tecladoTipo = new Scanner(System.in);
        Scanner tecladoNome = new Scanner(System.in);
        Scanner tecladoValor = new Scanner(System.in);

        System.out.println("Adicionar novo item ao cardápio.");
        System.out.println("1 - Comidas");
        System.out.println("2 - Bebidas");
        System.out.print("Opção: ");
        
        tipo = tecladoTipo.nextInt();

        if (tipo == 2) {
            tipoProduto = TipoProduto.BEBIDAS;
        }

        do {

            System.out.print("Nome: ");
            nome = tecladoNome.nextLine();

        } while (itemCardapioUnico(nome));

        System.out.print("Valor: R$");
        valor = tecladoValor.nextBigDecimal();

        Produto produto = new Produto(tipoProduto, valor, nome);
        produtos.add(produto);

        System.out.println("\nProduto cadastrado com sucesso!");

        Registro log2 = new Registro("Item adicionado ao cardápio.", Menu.getNomeUsuarioAtivo());
        registros.add(log2);

        Menu.continuar();
    }

    private boolean itemCardapioUnico(String nome) {
        boolean temp = false;

        for(int i = 0; i < produtos.size(); i++) {
            temp = produtos.get(i).getNome().contains(nome);
        }

        if (temp) {
            System.out.println("Produto já cadastrado.");

            return temp;
        }

        return temp;
    }

    public void verRendimentos() {
        for(int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getCodigo() == Menu.getUsuarioAtivo()) {
                if (i == 0) {
                    System.out.println("Ficha Financeira: " + funcionarios.get(i).getNome());
                }

                BigDecimal salario = funcionarios.get(i).getSalario();
                BigDecimal comissao = funcionarios.get(i).getComissao();

                System.out.format("%-15s | %-15s\n", "Salário", formatter.format(salario));
                System.out.format("%-15s | %-15s\n", "Comissões", formatter.format(comissao));
                System.out.format("%-15s | %-15s\n", "Total Líquido", formatter.format(salario.add(comissao)));
            }
        }

        Menu.continuar();
    }

    public void requisitarCompras() {
        Menu.limpaTela();

        boolean produtoExiste = false;
        
        String nome;
        Scanner tecladoNome = new Scanner(System.in);

        BigDecimal valor;
        Scanner tecladoValor = new Scanner(System.in);

        int quantidade;
        Scanner tecladoQtd = new Scanner(System.in);

        System.out.println("Requisitar compra de materia prima");;
        System.out.print("Nome: ");
        nome = tecladoNome.nextLine();

        System.out.print("Valor: ");
        valor = tecladoValor.nextBigDecimal();

        System.out.print("Quantidade: ");
        quantidade = tecladoQtd.nextInt();

        for(int i = 0; i < estoque.size(); i++) {
            if (nome.equals(estoque.get(i).getNome())) {
                produtoExiste = estoque.get(i).getQuantidade() > 0 ;
            }
        }

        if (!produtoExiste) {
            for(int i = 0; i < funcionarios.size(); i++) {
                if (funcionarios.get(i).getCodigo() ==  Menu.getUsuarioAtivo()) {
                    Funcionario autor = funcionarios.get(i);
                    MateriaPrima materiaPrima = new MateriaPrima(nome, quantidade, valor, autor);
                    estoque.add(materiaPrima);
    
                    Registro log5 = new Registro("Registrada nova requisição", Menu.getNomeUsuarioAtivo());
                    registros.add(log5);
    
                    System.out.println("\nRequisição enviada com sucesso!");
                } else {
                    System.out.println("Só é possível realizar o pedido de produtos já esgotados.");
                }
                Menu.continuar();
            }
        }   
    }

    public void addNovoCliente() {
        int login;
        int senha;
        int dia;
        int mes;
        int ano;
        String nome;
        Data dataNasc;
        String cpf;

        Scanner tecladoLogin = new Scanner(System.in);
        Scanner tecladoSenha = new Scanner(System.in);
        Scanner tecladoDia = new Scanner(System.in);
        Scanner tecladoMes = new Scanner(System.in);
        Scanner tecladoAno = new Scanner(System.in);
        Scanner tecladoNome = new Scanner(System.in);
        Scanner tecladoCpf = new Scanner(System.in);
        Scanner tecladoSalario = new Scanner(System.in);

        System.out.println("Adicionar novo cliente.");
        System.out.print("Nome: ");
        nome = tecladoNome.nextLine();

        do {
            
            System.out.print("Login: ");
            login = tecladoLogin.nextInt();

        } while (!validaLogin(login, TipoUsuario.CLIENTE));

        System.out.print("Senha: ");
        senha = tecladoSenha.nextInt();
        
        System.out.print("Data Nascimento: ");
        dia = tecladoDia.nextInt();

        System.out.print("Mês do Nascimento: ");
        mes = tecladoMes.nextInt();

        System.out.print("Ano do Nascimento: ");
        ano = tecladoAno.nextInt();

        dataNasc = new Data(dia, mes, ano);

        do {
            
            System.out.print("CPF: ");
            cpf = tecladoCpf.next();

        } while (!validaCpfUnico(cpf, TipoUsuario.FUNCIONARIO));

        Cliente cliente = new Cliente(login, nome, dataNasc, cpf, senha);
        clientes.add(cliente);

        Registro log4 = new Registro("Adicionado novo cliente.", Menu.getNomeUsuarioAtivo());
        registros.add(log4);

        System.out.println("\nCliente cadastrado com sucesso!");
        Menu.continuar();
    }

    private boolean validaLogin(int login, TipoUsuario tipoUsuario) {
        if (tipoUsuario == TipoUsuario.FUNCIONARIO) {
            for(int i =0; i < funcionarios.size(); i++) {
                if (funcionarios.get(i).getLogin() == login) {
                    System.out.println("Login já usado para funcionário, por favor escolha outro.");

                    return false;
                }
            }

        } else {
            for(int j = 0; j < clientes.size(); j++) {
                if (clientes.get(j).getLogin() == login) {
                    System.out.println("Login já usado para cliente, por favor escolha outro!.");

                    return false;
                }
            }
        }

        return true;
    }

    private boolean validaCpfUnico(String cpf, TipoUsuario tipoUsuario) {
        if (cpf.length() < 11) {
            System.out.println("O CPF precisa ter apenas 11 dígitos!.");

            return false;
        }

        if (tipoUsuario == TipoUsuario.FUNCIONARIO) {
            for(int i =0; i < funcionarios.size(); i++) {
                if (funcionarios.get(i).getCpf().equals(cpf)) {
                    System.out.println("Esse CPF já foi cadastrado para funcionário!.");

                    return false;
                }
            } 

        } else {
            for(int j = 0; j < clientes.size(); j++) {
                if (clientes.get(j).getCpf().equals(cpf)) {
                    
                    System.out.println("Esse CPF já com cadastrado para cliente!.");

                    return false;
                }
            }
        }

        return true;
    }

    public void visualizarEstoque() {
        for(int i = 0; i < estoque.size(); i++) {
            if (Menu.getUsuarioAtivoRole() == TipoUsuario.FUNCIONARIO) {
                if (i == 0) {
                    System.out.format("%-8s | %-15s | %-25s | %-10s | %-10s\n",
                                       "Código",
                                       "Data Alteração",
                                       "Item",
                                       "Quantidade",
                                       "Valor");
                }

                if (estoque.get(i).getStatusProduto() == StatusProduto.APROVADO) {
                    System.out.format("%-8s | %-15s | %-25s | %-10s | %-10s\n",
                                        estoque.get(i).getCodigo(),
                                        estoque.get(i).getDataAlteracao(),
                                        estoque.get(i).getNome(),
                                        estoque.get(i).getQuantidade(),
                                        formatter.format(estoque.get(i).getValor()));
                }

            } else {
                if (i == 0) {
                    System.out.format("%-8s | %-15s | %-25s | %-10s | %-10s\n",
                                       estoque.get(i).getCodigo(),
                                       estoque.get(i).getDataAlteracao(),
                                       estoque.get(i).getNome(),
                                       estoque.get(i).getQuantidade(),
                                       formatter.format(estoque.get(i).getValor()));
                } else {
                    if (i == 0) {
                        System.out.format("%-8s | %-15s | %-25s | %-10s | %-10s | %-15s\n",
                                            "Código",
                                            "Data Alteração",
                                            "Item",
                                            "Status",
                                            "Quantidade",
                                            "Valor");
                    }

                    System.out.format("%-8s | %-15s | %-25s | %-10s | %-10s | %-15s\n",
                                      estoque.get(i).getCodigo(),
                                      estoque.get(i).getDataAlteracao(),
                                      estoque.get(i).getNome(),
                                      estoque.get(i).getStatusProduto(),
                                      estoque.get(i).getQuantidade(),
                                      formatter.format(estoque.get(i).getValor()));

                                      if (i == estoque.size() -1) {
                                          Scanner teclado = new Scanner(System.in);
                                          int escolha;

                                          System.out.println("\nDigite 1 para escolher um produto para aprovar/recusar");
                                          System.out.println("Digite 0 para sair");

                                          escolha = teclado.nextInt();

                                          if (escolha == 1) {
                                              aprovarRequisicao();
                                          }

                                          break;
                                      }
                           }
            }

            Menu.continuar();
        }
    }

    public void aprovarRequisicao() {
        Menu.limpaTela();

        Scanner teclado = new Scanner(System.in);
        Scanner entrada = new Scanner(System.in);
        
        int codigoProduto;
        int escolha;
        BigDecimal valorMaterial = new BigDecimal(0);
        String responsavel = "";

        for(int i = 0; i < estoque.size(); i++) {
            if (estoque.get(i).getStatusProduto() == StatusProduto.PENDENTE) {
                valorMaterial = estoque.get(i).getValor();
                responsavel = estoque.get(i).getResponsavel();

                if (i == 0) {
                    System.out.format("%-8s | %-15s | %-25s | %-10s | %-10s | %-15s | %-15s\n",
                                    "Código",
                                    "Data Alteração",
                                    "Item",
                                    "Status",
                                    "Quantidade",
                                    "Valor",
                                    "Funcionário Responsável");
                }

                System.out.format("%-8s | %-15s | %-25s | %-10s | %-10s | %-15s | %-15s\n",
                                estoque.get(i).getCodigo(),
                                estoque.get(i).getDataAlteracao(),
                                estoque.get(i).getNome(),
                                estoque.get(i).getStatusProduto(),
                                estoque.get(i).getQuantidade(),
                                formatter.format(estoque.get(i).getValor()),
                                estoque.get(i).getResponsavel());
            }
        }

        System.out.print("\nDigite o código do produto que vc deseja alterar: ");
        codigoProduto = teclado.nextInt();

        System.out.println("\n1 - Aprovado");
        System.out.println("\n2 - Recusar");
        System.out.println("Opção: ");
        escolha = entrada.nextInt();

        for(int i = 0; i< estoque.size(); i++) {
            if (codigoProduto == estoque.get(i).getCodigo()) {
                if (escolha == 1) {
                    estoque.get(i).aprovaAquisicao();

                    Registro log6 = new Registro("Aprovado requisição de compra de material no valor de R$ " + valorMaterial, Menu.getNomeUsuarioAtivo());
                    registros.add(log6);

                    System.out.println("Aprovado com sucesso!.");

                } else {
                    estoque.get(i).recusaAquisicao();

                    Registro log6 = new Registro("Recusado requisição de compra de material no valor de R$ " + valorMaterial, Menu.getNomeUsuarioAtivo());
                    registros.add(log6);

                    System.out.println("Recusado com sucesso");
                }
            }
        }
        Menu.continuar();
    }

    // Menu para Admin
    public void visualizarVendas() {
        for(int i = 0; i < vendas.size(); i++) {
            System.out.format("%-10s %-25s\n", "Código: " + i, "Data da Venda: " + vendas.get(i).getDatavenda());
            System.out.println("Cliente: " + vendas.get(i).getCodComprador());
            System.out.println("Funcionário: " + vendas.get(i).getFuncionarioAtendimento());
            System.out.println();

            for(int j = 0; j < vendas.get(i).getItensVenda().size(); j++) {
                Produto produto = vendas.get(i).getItensVenda().get(j);

                if (j == 0) {
                    System.out.format("%-25s | %-10s\n", "Produto", "Valor");
                }

                System.out.format("%-25s | %-10s\n",
                                  produto.getNome(),
                                  formatter.format(produto.getValor()));
            }

            System.out.println("___________________________");
            System.out.format("%-25s | %-10s\n", "Total: ", formatter.format(vendas.get(i).getValorTotal()));
        }

        Menu.continuar();
    }

    public void addNovoFuncionario() {
        int login;
        int senha;
        int dia;
        int mes;
        int ano;
        String nome;
        Data dataNasc;
        String cpf;
        BigDecimal salario;

        Scanner tecladoLogin = new Scanner(System.in);
        Scanner tecladoSenha = new Scanner(System.in);
        Scanner tecladoDia = new Scanner(System.in);
        Scanner tecladoMes = new Scanner(System.in);
        Scanner tecladoAno = new Scanner(System.in);
        Scanner tecladoNome = new Scanner(System.in);
        Scanner tecladoCpf = new Scanner(System.in);
        Scanner tecladoSalario = new Scanner(System.in);

        System.out.println("Adicionar novo funcionário.");
        System.out.print("Nome: ");
        nome = tecladoNome.nextLine();

        do {
            
            System.out.print("Login: ");
            login = tecladoLogin.nextInt();

        } while (!validaLogin(login, TipoUsuario.FUNCIONARIO));

        System.out.print("Senha: ");
        senha = tecladoSenha.nextInt();

        System.out.print("Salário: R$");
        salario = tecladoSalario.nextBigDecimal();
        
        System.out.print("Data Nascimento: ");
        dia = tecladoDia.nextInt();

        System.out.print("Mês do Nascimento: ");
        mes = tecladoMes.nextInt();

        System.out.print("Ano do Nascimento: ");
        ano = tecladoAno.nextInt();

        dataNasc = new Data(dia, mes, ano);

        do {
            
            System.out.print("CPF: ");
            cpf = tecladoCpf.next();

        } while (!validaCpfUnico(cpf, TipoUsuario.FUNCIONARIO));

        Funcionario funcionario = new Funcionario(login, nome, dataNasc, cpf, senha, salario);
        funcionarios.add(funcionario);

        Registro log3 = new Registro("Adicionado novo funcionário.", Menu.getNomeUsuarioAtivo());
        registros.add(log3);

        System.out.println("Funcionário cadastrado com sucesso!");
        Menu.continuar();

    }

    public void visualizarFuncionarios() {
        for(int i = 0; i < funcionarios.size(); i++) {
            if (i == 0) {
                System.out.format("%-8s | %-8s | %-25s | %-12s | %-10s\n", 
                                  "Código",
                                  "Login",
                                  "Nome",
                                  "CPF",
                                  "Salário");
            }

            System.out.format("%-8s | %-8s | %-25s | %-12s | %-10s\n",
                              funcionarios.get(i).getCodigo(),
                              funcionarios.get(i).getLogin(),
                              funcionarios.get(i).getNome(),
                              funcionarios.get(i).getCpf(),
                              formatter.format(funcionarios.get(i).getSalario()));
        }
        Menu.continuar();
    }

    public void visualizarClientes() {
        for(int i = 0; i < clientes.size(); i++) {
            if (i == 0) {
                System.out.format("%-8s | %-8s | %-25s | %-15s | %-15s\n",
                                  clientes.get(i).getCodigo(),
                                  clientes.get(i).getLogin(),
                                  clientes.get(i).getNome(),
                                  clientes.get(i).getCpf(),
                                  clientes.get(i).getDtNasc());
            }
            Menu.continuar();
        }
    }
}
