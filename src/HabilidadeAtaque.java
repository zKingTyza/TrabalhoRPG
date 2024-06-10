public class HabilidadeAtaque extends Habilidade {
    private int dano;

    public HabilidadeAtaque(String nome, int custoMana, int dano) {
        super(nome, custoMana);
        this.dano = dano;
    }

    @Override
    public void usar(Personagem usuario, Personagem alvo) throws ManaInsuficienteException {
        if (usuario.getMana() < getCustoMana()){
            throw new ManaInsuficienteException("Mana insuficiente para usar a habilidade");
        }
        usuario.gastarMana(getCustoMana());
        alvo.receberDano(dano);
        System.out.println(usuario.getNome() + " usou " + getNome() + " e causou " + dano + " pontos de dano a " + alvo.getNome());
    }
}
