import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner prompt = new Scanner(System.in);
        Jogo jogo = new Jogo();

        int opcao;
        do {
            exibirMenu();
            opcao = prompt.nextInt();
            prompt.nextLine();

            switch (opcao) {
                case 1:
                    jogo.iniciarNovoJogo();
                    break;
                case 2:
                    jogo.exibirInstrucoes();
                    break;
                case 3:
                    jogo.sairDoJogo();
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 3);


    }

    private static void exibirMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Iniciar novo jogo");
        System.out.println("2. Exibir instruções");
        System.out.println("3. Sair do jogo");
        System.out.print("Escolha uma opção: ");
    }


}
