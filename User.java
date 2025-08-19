import java.util.ArrayList;
import java.util.List;

public class User {
    private String nome;
    private double saldo;
    private List<Game> jogosComprados;

    // Construtor
    public User(String nome, double saldo) {
        this.nome = nome;
        this.saldo = saldo;
        this.jogosComprados = new ArrayList<>();
    }

    // Método para adicionar saldo
    public void adicionarSaldo(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor deve ser positivo.");
        }
        this.saldo += valor;
    }

    // Método para comprar jogo
    public void comprarJogo(Game jogo) throws SaldoInsuficienteException {
        if (this.saldo < jogo.getPreco()) {
            throw new SaldoInsuficienteException("Saldo insuficiente para comprar este jogo.");
        }
        this.saldo -= jogo.getPreco();
        jogosComprados.add(jogo);
    }

    // Exibir saldo
    public void exibirSaldo() {
        System.out.println("Saldo atual: " + saldo);
    }

    // Exibir jogos comprados
    public void exibirJogosComprados() {
        if (jogosComprados.isEmpty()) {
            System.out.println("Nenhum jogo comprado ainda.");
        } else {
            System.out.println("Jogos comprados:");
            for (Game jogo : jogosComprados) {
                jogo.exibirDetalhes();
                System.out.println();
            }
        }
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }
}
