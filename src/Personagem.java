public abstract class Personagem implements Atacavel, Curavel {
    private String nome;
    private int vida;
    private int forca;
    private int defesa;
    private static final int MAX_VIDA = 100;


    public Personagem(String nome, int vida, int forca, int defesa){
        this.nome = nome;
        this.vida = vida;
        this.forca = forca;
        this.defesa = defesa;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getForca() {
        return forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public abstract void usarHabilidade();
    public abstract int getMana();
    public abstract void gastarMana(int quantidade);

    public void atacar(Personagem alvo){
        int dano = this.forca - alvo.getDefesa();
        if(dano > 0){
            alvo.setVida(alvo.getVida() - dano);
            System.out.println(this.nome + " atacou " + alvo.getNome() + " e causou " + dano + " de dano.");
        } else {
            System.out.println(this.nome + " atacou " + alvo.getNome() + " mas nao causou dano.");
        }
    }

    @Override
    public void receberDano(int dano) {
        this.vida -= dano;
        System.out.println(this.nome + " recebeu " + dano + " pontos de dano.");
    }

    @Override
    public void receberCura(int cura) throws VidaExcedidaException {
        if (this.vida + cura > MAX_VIDA){
            throw new VidaExcedidaException("A vida excedeu o maximo permitido!");
        }
        this.vida +=cura;
        System.out.println(this.nome + " recebeu " + cura + " pontos de cura.");
    }
}
