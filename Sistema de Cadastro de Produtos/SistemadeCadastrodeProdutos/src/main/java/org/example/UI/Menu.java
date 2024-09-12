package org.example.UI;

import org.example.product.ProductItem;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    ArrayList<ProductItem> itens = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public void inicio() {
        int op = 0;

        do {

            System.out.println("""
                    1 - Adicionar um novo produto.
                    2 - Atualizar o preço de um produto.
                    3 - Remover um produto.
                    4 - Listar todos os produtos.
                    
                    5 - Sair.
                    """);
            op = sc.nextInt();
            switch (op) {
                case 1: {
                    addItem();
                    break;
                }

                case 2: {
                    atualizar();
                    break;
                }
                case 3: {
                    remover();
                    break;
                }
                case 4: {
                    listar();
                    break;
                }
                case 5: {
                    System.out.println("saindo");
                    break;
                }
                default: {
                    System.out.println("Op invalida");
                    break;
                }
            }
            System.out.println("\n\n");
        } while (!(op == 5));
        sc.close();
    }

    public void addItem() {
        boolean sucesso = false;
        while (!sucesso) {
            try {
                System.out.print("ID do produto: ");
                int id = sc.nextInt();

                System.out.print("Nome do produto: ");
                String nome = sc.next();

                System.out.print("Valor do produto: ");
                Double valor = sc.nextDouble();

                itens.add(new ProductItem(id, nome, valor));

                System.out.println("Produto adicionado com sucesso!: " + itens.toString());
                sucesso = true;
            } catch (Exception e) {
                System.out.println("erro: " + e.getCause());
                sc.nextLine(); // para lipar o buffer se nao buga tudo dai só com deus
            }
        }
    }

    public void atualizar() {
        boolean sucesso = false;
        System.out.println("Qual o id do produto que deseja atualizar? ");
        int id = sc.nextInt();

        while (!sucesso) {
            try {

                for (ProductItem productItem : itens) {
                    if (productItem.getId() == id) {

                        System.out.println("""
                                Deseja atualizar qual dado?
                                1 - Nome.
                                2 - Valor.
                                3 - Retornar ao inicio.
                                """);
                        int x = sc.nextInt();


                        switch (x) {
                            case 1: {
                                System.out.print("Qual o novo nome?: ");
                                String novoNome = sc.next();
                                productItem.setName(novoNome);
                                System.out.println("Nome atualizado com sucesso!: " + productItem.getName());
                                sucesso = true;
                                break;
                            }
                            case 2: {
                                System.out.print("Qual o novo valor?: ");
                                Double novoValor = sc.nextDouble();
                                productItem.setPrice(novoValor);
                                System.out.println("Valor atualizado com sucesso!: " + productItem.getPrice());
                                sucesso = true;
                                break;
                            }
                            case 3: {
                                System.out.println("Voltando ao inico");
                                sucesso = true;
                                break;
                            }
                            default: {
                                System.out.println("Opção invalida");
                                break;
                            }

                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("erro: " + e.getCause());
                sc.nextLine();
            }

        }
    }

    public void remover() {
        boolean sucesso = false;
        System.out.print("Qual o id do produto que deseja remover? ");
        int id = sc.nextInt();
        try {
            for (ProductItem productItem : itens) {
                if (productItem.getId() == id) {
                    itens.remove(productItem);
                    System.out.println("Produto removido com sucesso!: ");
                } else {
                    System.out.println("Produto não encontrado! ");
                }
            }
        } catch (Exception e) {
            System.out.println("erro: " + e.getCause());
            sc.nextLine();
        }
    }

    public void listar() {
        for (ProductItem productItem : itens) {
            System.out.println(productItem.toString());
        }
    }
}

