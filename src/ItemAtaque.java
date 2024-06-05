public class ItemAtaque extends Item {

    private int dano;
    public ItemAtaque(String nome, int dano){
        super(nome);
        this.dano = dano;
    }

    @Override
    public void usar(Personagem usuario, Personagem alvo) {
        int vidaRestante = alvo.getVida() - dano;
        alvo.setVida(vidaRestante > 0 ? vidaRestante: 0);
        System.out.println(alvo.getNome() + " usou " + getNome() + " e causou" + dano + " pontos de dano.");
    }


}
