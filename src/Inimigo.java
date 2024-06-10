public class Inimigo extends Personagem {
    private int recompensa;

    public Inimigo(String nome, int vida, int forca, int defesa, int recompensa) {
        super(nome, vida, forca, defesa);
        this.recompensa = recompensa;
    }

    public int getRecompensa(){
        return recompensa;
    }

    @Override
    public void usarHabilidade() {
       // sem efeitos de habilidade para os inimigos
    }

    @Override
    public int getMana() {
        return 0;
    }

    @Override
    public void gastarMana(int quantidade) {

    }
}
