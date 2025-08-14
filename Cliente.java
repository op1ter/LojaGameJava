import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String email;
    private double saldo;
    private List<Game> gamesComprados;

    public Cliente(String nome, String email, double saldo) {
        this.nome = nome;
        this.email = email;
        this.saldo = saldo;
        this.gamesComprados = new ArrayList<>();
    }

    public boolean comprarGame(Game game) {
        if (saldo >= game.getPreco()) {
            gamesComprados.add(game);
            saldo -= game.getPreco();
            System.out.println(nome + " comprou o jogo: " + game.getNome());
            return true;
        } else {
            System.out.println(nome + " não tem saldo suficiente para comprar: " + game.getNome());
            return false;
        }
    }

    public List<Game> getGamesComprados() {
        return new ArrayList<>(gamesComprados);
    }

    public void exibirGamesComprados() {
        System.out.println("Jogos comprados por " + nome + ":");
        for (Game g : gamesComprados) {
            Game.exibirInformacoes(g);
        }
        System.out.println("Saldo restante: R$" + saldo);
    }
}