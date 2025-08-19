import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Inicialização de usuários e jogos
        User user1 = new User("João", 100.0);

        // Criar alguns jogos
        Game jogo1 = new Game("FIFA 23", 60.0, "Esportes", "Jogo de futebol.");
        Game jogo2 = new Game("Minecraft", 45.0, "Aventura", "Jogo de construção e sobrevivência.");

        // Menu interativo
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Adicionar saldo");
            System.out.println("2. Comprar jogo");
            System.out.println("3. Exibir saldo");
            System.out.println("4. Exibir jogos comprados");
            System.out.println("5. Exibir detalhes do jogo");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Informe o valor para adicionar ao saldo: ");
                    double valor = scanner.nextDouble();
                    try {
                        user1.adicionarSaldo(valor);
                        System.out.println("Saldo atualizado!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Escolha o jogo para comprar:");
                    System.out.println("1. FIFA 23");
                    System.out.println("2. Minecraft");
                    System.out.print("Escolha uma opção: ");
                    int opcaoJogo = scanner.nextInt();
                    try {
                        if (opcaoJogo == 1) {
                            user1.comprarJogo(jogo1);
                            System.out.println("Você comprou o jogo: " + jogo1.getNome());
                        } else if (opcaoJogo == 2) {
                            user1.comprarJogo(jogo2);
                            System.out.println("Você comprou o jogo: " + jogo2.getNome());
                        }
                    } catch (SaldoInsuficienteException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 3:
                    user1.exibirSaldo();
                    break;

                case 4:
                    user1.exibirJogosComprados();
                    break;

                case 5:
                    System.out.println("Escolha o jogo para ver detalhes:");
                    System.out.println("1. FIFA 23");
                    System.out.println("2. Minecraft");
                    System.out.print("Escolha uma opção: ");
                    int opcaoDetalhes = scanner.nextInt();
                    if (opcaoDetalhes == 1) {
                        jogo1.exibirDetalhes();
                    } else if (opcaoDetalhes == 2) {
                        jogo2.exibirDetalhes();
                    }
                    break;

                case 6:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
