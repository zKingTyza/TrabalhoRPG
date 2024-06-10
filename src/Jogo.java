import java.util.Scanner;

public class Jogo {
    private Jogador jogador;


    public void iniciarNovoJogo(){
        Scanner prompt = new Scanner(System.in);
        System.out.println("Digite o nome do seu personagem: ");
        String nome = prompt.nextLine();


        jogador = new Jogador(nome, 100, 30, 50, 10, 1);

        jogador.adicionarHabilidade(new HabilidadeAtaque("Golpe pesado",10,30));
        jogador.adicionarHabilidade(new HabilidadeCura("Proteçao Divina", 25, 50));


        jogador.adicionarItem(new ItemCura("Poção de vida", 10));

        System.out.println("Jogo iniciado! Bem vindo, " + jogador.getNome() + "!");

        inciarBatalha();
    }

    public void exibirInstrucoes(){
        System.out.println("==== Instruçoes do Jogo ====");
        System.out.println("1. Ataque os inimigos usando suas habilidades.");
        System.out.println("2. Cure-se usando habilidades de cura.");
        System.out.println("3. Suba de nivel matando inimigos e ganhando experiencia.");
        System.out.println("4. Derrote todos os inimigos para vencer o jogo.");
        System.out.println("============================");
    }

    public void sairDoJogo(){
        System.out.println("Até a proxima :)");
    }

    private void inciarBatalha(){
        Inimigo troll = new Inimigo("Troll", 40, 15, 25, 90);
        try {
            jogador.atacar(troll);
            troll.atacar(jogador);

            if(troll.getVida() <= 0){
                jogador.ganharExperiencia(troll.getRecompensa());
            }
            jogador.usarHabilidade();
            jogador.usarItem(0, jogador);
        } catch (VidaExcedidaException | ManaInsuficienteException | IndexOutOfBoundsException e){
            System.out.println("Ocorreu um erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}
