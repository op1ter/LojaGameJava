public class Game {
    private String nome;
    private double preco;
    private String categoria;
    private String descricao;

    // Construtor
    public Game(String nome, double preco, String categoria, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.descricao = descricao;
    }

    // Getters
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public String getCategoria() { return categoria; }
    public String getDescricao() { return descricao; }
    
    // Método para exibir detalhes
    public void exibirDetalhes() {
        System.out.println("Jogo: " + nome);
        System.out.println("Preço: " + preco);
        System.out.println("Categoria: " + categoria);
        System.out.println("Descrição: " + descricao);
    }
}
