import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int numRodadas = 3;
        int numVitoriasJogador = 0;
        int numVitoriasMaquina = 0;

        System.out.println("-------------------JOGO DE CARTAS-------------------\n");

        Cartas j1 = new Cartas();
        System.out.println("Suas cartas são essas: ");
        j1.cartasJ1();

        ArrayList<String> cartasJogador = new ArrayList<>();
        cartasJogador.add(j1.getCarta1());
        cartasJogador.add(j1.getCarta2());
        cartasJogador.add(j1.getCarta3());

        Scanner jogador = new Scanner(System.in);

        for (int i = 0; i < numRodadas; i++) {
            System.out.println("\nEscolha a carta que deseja jogar (1, 2 ou 3): ");
            int cartaEscolhida = jogador.nextInt();

            boolean cartaValida = false;
            String cartaJogador = null;
            while (!cartaValida) {
                cartaJogador = cartasJogador.get(cartaEscolhida - 1);
                if (cartaJogador == null) {
                    System.out.println("Essa carta já foi escolhida, escolha outra: ");
                    cartaEscolhida = jogador.nextInt();
                } else {
                    cartaValida = true;
                }
            }

            int posicaoCarta = cartasJogador.indexOf(cartaJogador);
            cartasJogador.set(posicaoCarta, null);

            Cartas maquina = new Cartas();
            maquina.cartaMaquina();
            String cartaMaquina = maquina.getCartaMaquina();

            System.out.println("\nCarta da máquina: " + cartaMaquina);

            int valorJogador = j1.getValorCarta(cartaJogador);
            int valorMaquina = maquina.getValorCarta(cartaMaquina);

            if (valorJogador > valorMaquina) {
                System.out.println("Você venceu essa partida!");
                numVitoriasJogador++;
            } else if (valorJogador < valorMaquina) {
                System.out.println("A máquina venceu essa partida!");
                numVitoriasMaquina++;
            } else {
                System.out.println("Empate nessa partida!");
            }
        }

        System.out.println("\nNumero de vitórias do jogador: " + numVitoriasJogador);
        System.out.println("Numero de vitórias da máquina: " + numVitoriasMaquina);

        if (numVitoriasJogador > numVitoriasMaquina) {
            System.out.println("\nParabéns, você ganhou o jogo! :D ");
        } else if (numVitoriasJogador < numVitoriasMaquina) {
            System.out.println("\nA máquina ganhou o jogo :( Tente novamente!");
        } else {
            System.out.println("\nEmpate, tente novamente!");
        }
    }
}