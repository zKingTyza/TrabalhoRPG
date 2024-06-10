public class HabilidadeCura extends Habilidade {
    private int quantidadeCura;

    public HabilidadeCura(String nome, int custoMana, int quantidadeCura) {
        super(nome, custoMana);
        this.quantidadeCura = quantidadeCura;
    }

    @Override
    public void usar(Personagem usuario, Personagem alvo) throws ManaInsuficienteException, VidaExcedidaException{
        if(usuario.getMana() < getCustoMana()){
            throw new ManaInsuficienteException("Mana insuficiente para usar a habiliodade.");
        }
        usuario.gastarMana(getCustoMana());
        alvo.receberCura(quantidadeCura);
        System.out.println(usuario.getNome() + " usou " + getNome() + " e curou " + quantidadeCura + " pontos de vida de" +
                alvo.getNome());
    }
}
