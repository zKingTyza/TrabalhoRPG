public class ItemCura extends Item {
    private int quantidadeCura;

    public ItemCura(String nome, int quantidadeCura){
        super(nome);
        this.quantidadeCura = quantidadeCura;
    }

    @Override
    public void usar(Personagem usuario, Personagem alvo) {
        alvo.setVida(alvo.getVida() + quantidadeCura);
        System.out.println(alvo.getNome() + " usou " + getNome() + " e curou " + quantidadeCura + " pontos de vida.");
    }


}
