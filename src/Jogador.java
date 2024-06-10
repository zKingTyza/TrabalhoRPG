import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogador extends Personagem {
    private int nivel;
    private int experiencia;
    private int mana;
    private List<Item> inventario;
    private List<Habilidade> habilidades;

    public Jogador(String nome, int vida, int forca, int defesa, int nivel, int experiencia) {
        super(nome, vida, forca, defesa);
        this.nivel = nivel;
        this.inventario = new ArrayList<>();
        this.habilidades = new ArrayList<>();
        this.experiencia = 0;
        this.mana = 100;
    }

    public int getMana() {
        return mana;
    }

    public int getNivel(){
        return nivel;
    }

    public int getExperiencia(){
        return experiencia;
    }

    public void gastarMana(int quantidade){
        this.mana -= quantidade;
    }

    public void ganharExperiencia(int xp){
        this.experiencia += xp;
        if (this.experiencia >= 100){
            this.nivel++;
            this.experiencia = 0;
            System.out.println(this.getNome() + " subiu para o nivel " + this.nivel + "!");
        }
    }

    public void usarItem(int indice, Personagem alvo) throws IndexOutOfBoundsException, ManaInsuficienteException, VidaExcedidaException {
        if (indice < 0 || indice >= inventario.size()) {
            throw new IndexOutOfBoundsException("Índice de item inválido.");
        }
        Item item = inventario.get(indice);
        if (item instanceof Usavel) {
            ((Usavel) item).usar(this, alvo);
            inventario.remove(indice);
        } else {
            System.out.println("Item não pode ser usado.");
        }
    }

    public void adicionarHabilidade(Habilidade habilidade){
        habilidades.add(habilidade);
    }

    public void adicionarItem(Item item){
        inventario.add(item);
    }

    @Override
    public void usarHabilidade() {
        Scanner prompt = new Scanner(System.in);

        System.out.println("Escolha uma habilidade para usar: ");
        for (int i = 0; i < habilidades.size(); i++){
            System.out.println(i + ": " + habilidades.get(i).getNome());
        }

        int indiceHabilidade = prompt.nextInt();

        if (indiceHabilidade < 00 || indiceHabilidade >= habilidades.size()) {
            System.out.println("Habilidade invalida.");
            return;
        }

        Habilidade habilidade = habilidades.get(indiceHabilidade);

        System.out.println("Escolha um alvo:");
        System.out.println("0: " + this.getNome());
        System.out.println("1: Inimigo");

        int indiceAlvo = prompt.nextInt();
        Personagem alvo;
        if(indiceAlvo == 0){
            alvo = this;
        } else {
            alvo = new Inimigo("Goblin", 50, 15,10, 90);
        }

        try{
            habilidade.usar(this, alvo);
        } catch (ManaInsuficienteException | VidaExcedidaException e){
            System.out.println(e.getMessage());
        }

    }
}
