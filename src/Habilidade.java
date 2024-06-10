public abstract class Habilidade implements Usavel {
    private String nome;
    private int custoMana;

    public Habilidade(String nome, int custoMana) {
        this.nome = nome;
        this.custoMana = custoMana;
    }

    public String getNome() {
        return nome;
    }

    public int getCustoMana() {
        return custoMana;
    }

    public abstract void usar(Personagem usuario, Personagem alvo) throws ManaInsuficienteException, VidaExcedidaException;


}
