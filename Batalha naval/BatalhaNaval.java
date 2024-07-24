import java.util.*;

public class BatalhaNaval {
    private char[][] mapa;
    private char[][] mapaOculto;
    private int tamanhoMapa;
    private int totalEmbarcacoes;
    private Map<Character, Integer> embarcacoesCompletasJogador1;
    private Map<Character, Integer> embarcacoesCompletasJogador2;
    private Set<String> posicoesJogadas;
    private Set<String> posicoesBombas;
    private int bombasEncontradasJogador1;
    private int bombasEncontradasJogador2;
    private int embarcacoesCompletasJogador1Count;
    private int embarcacoesCompletasJogador2Count;

    // Tipos e tamanhos das embarcações
    private final String[] tiposEmbarcacoes = {"S", "A", "D", "F", "B"};
    private final int[] tamanhosEmbarcacoes = {4, 8, 5, 3, 2};

    public BatalhaNaval(int tamanhoMapa, int totalEmbarcacoes) {
        this.tamanhoMapa = (int) Math.ceil(tamanhoMapa * 1.7); // Mapa 70% maior
        this.totalEmbarcacoes = totalEmbarcacoes;
        inicializarMapas();
        embarcacoesCompletasJogador1 = new HashMap<>();
        embarcacoesCompletasJogador2 = new HashMap<>();
        posicoesJogadas = new HashSet<>();
        posicoesBombas = new HashSet<>();
        bombasEncontradasJogador1 = 0;
        bombasEncontradasJogador2 = 0;
        embarcacoesCompletasJogador1Count = 0;
        embarcacoesCompletasJogador2Count = 0;
        for (String tipo : tiposEmbarcacoes) {
            embarcacoesCompletasJogador1.put(tipo.charAt(0), 0);
            embarcacoesCompletasJogador2.put(tipo.charAt(0), 0);
        }
    }

    private void inicializarMapas() {
        mapa = new char[tamanhoMapa][tamanhoMapa];
        mapaOculto = new char[tamanhoMapa][tamanhoMapa];
        for (int i = 0; i < tamanhoMapa; i++) {
            Arrays.fill(mapa[i], 'V'); // Preencher com espaços vazios
            Arrays.fill(mapaOculto[i], 'O'); // Preencher com espaços ocultos
        }
    }

    public void colocarEmbarcacoes() {
        Random random = new Random();
        for (int i = 0; i < totalEmbarcacoes; i++) {
            int tipoIndex = random.nextInt(tiposEmbarcacoes.length);
            String tipo = tiposEmbarcacoes[tipoIndex];
            int tamanho = tamanhosEmbarcacoes[tipoIndex];
            colocarEmbarcacao(tipo, tamanho);
        }
    }

    private void colocarEmbarcacao(String tipo, int tamanho) {
        Random random = new Random();
        boolean horizontal = random.nextBoolean();
        int linha, coluna;

        do {
            linha = random.nextInt(tamanhoMapa - tamanho) + 1;
            coluna = random.nextInt(tamanhoMapa - tamanho) + 1;
        } while (!verificarPosicaoDisponivel(linha, coluna, tamanho, horizontal));

        for (int i = 0; i < tamanho; i++) {
            if (horizontal) {
                mapa[linha][coluna + i] = tipo.charAt(0);
            } else {
                mapa[linha + i][coluna] = tipo.charAt(0);
            }
        }
    }

    private boolean verificarPosicaoDisponivel(int linha, int coluna, int tamanho, boolean horizontal) {
        if (horizontal) {
            if (coluna + tamanho > tamanhoMapa) {
                return false;
            }
            for (int i = 0; i < tamanho; i++) {
                if (mapa[linha][coluna + i] != 'V') {
                    return false;
                }
            }
        } else {
            if (linha + tamanho > tamanhoMapa) {
                return false;
            }
            for (int i = 0; i < tamanho; i++) {
                if (mapa[linha + i][coluna] != 'V') {
                    return false;
                }
            }
        }
        return true;
    }

    public void colocarBombas() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int linha, coluna;
            do {
                linha = random.nextInt(tamanhoMapa - 1) + 1;
                coluna = random.nextInt(tamanhoMapa - 1) + 1;
            } while (!verificarPosicaoBombaDisponivel(linha, coluna));

            mapa[linha][coluna] = 'B'; // Marcar a posição da bomba no mapa
            posicoesBombas.add(linha + "," + coluna); // Adicionar a posição da bomba ao conjunto de posições de bombas
        }
    }

    private boolean verificarPosicaoBombaDisponivel(int linha, int coluna) {
        String posicao = linha + "," + coluna;
        if (mapa[linha][coluna] != 'V' || posicoesBombas.contains(posicao)) {
            return false;
        }
        return true;
    }

    public String jogada(int jogador, int linha, int coluna) {
        String posicao = linha + "," + coluna;
        if (linha < 1 || linha >= tamanhoMapa || coluna < 1 || coluna >= tamanhoMapa) {
            return "A posição não é válida, pois está fora do mapa. Por favor, escolha outra posição.";
        }

        if (posicoesJogadas.contains(posicao)) {
            return "Essa jogada já foi feita. Por favor, escolha outra posição.";
        }

        char valor = mapa[linha][coluna];
        char valorOculto = mapaOculto[linha][coluna];
        if (valor != 'V') {
            if (valor == 'B') {
                if (jogador == 1) {
                    bombasEncontradasJogador1++;
                } else {
                    bombasEncontradasJogador2++;
                }
                if (bombasEncontradasJogador1 >= 3 || bombasEncontradasJogador2 >= 3) {
                    return "Você achou uma bomba. Tome cuidado! Você encontrou 3 bombas e perdeu o jogo.";
                } else {
                    mapaOculto[linha][coluna] = 'X'; // Identificar a bomba no mapa oculto
                    return "Você achou uma bomba. Tome cuidado!";
                }
            } else {
                Map<Character, Integer> mapaEmbarcacoes = jogador == 1 ? embarcacoesCompletasJogador1 : embarcacoesCompletasJogador2;
                int count = mapaEmbarcacoes.getOrDefault(valor, 0) + 1;
                mapaEmbarcacoes.put(valor, count);
                if (count == tamanhosEmbarcacoes[Arrays.asList(tiposEmbarcacoes).indexOf(Character.toString(valor))]) {
                    if (jogador == 1) {
                        embarcacoesCompletasJogador1Count++;
                    } else {
                        embarcacoesCompletasJogador2Count++;
                    }
                    if (embarcacoesCompletasJogador1Count == 5 || embarcacoesCompletasJogador2Count == 5) {
                        return "Você achou uma embarcação inteira: " + valor + ". Você completou 5 embarcações. Parabéns, você venceu!";
                    } else {
                        return "Você achou uma embarcação inteira: " + valor + ". Você completou " + count + " posições.";
                    }
                } else {
                    mapaOculto[linha][coluna] = valor; // Revelar o tipo de embarcação no mapa oculto
                    return "Você achou uma posição: " + valor;
                }
            }
        } else {
            mapaOculto[linha][coluna] = '~'; // Marcar posição no mapa oculto como água
            posicoesJogadas.add(posicao); // Adicionar posição às jogadas
            return "AGUA";
        }
    }

    public boolean verificarGanhador() {
        return embarcacoesCompletasJogador1Count == 5 || embarcacoesCompletasJogador2Count == 5 ||
                bombasEncontradasJogador1 >= 3 || bombasEncontradasJogador2 >= 3;
    }

    public void exibirMapa(int jogador) {
        char[][] mapaExibicao = jogador == 1 ? mapaOculto : mapaOculto;
        for (int i = 1; i < tamanhoMapa; i++) {
            for (int j = 1; j < tamanhoMapa; j++) {
                System.out.print(mapaExibicao[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BatalhaNaval jogo = new BatalhaNaval(10, 20); // Tamanho do mapa: 10x10
        jogo.colocarEmbarcacoes();
        jogo.colocarBombas();

        Scanner scanner = new Scanner(System.in);
        int jogadorAtual = 1;

        while (!jogo.verificarGanhador()) {
            System.out.println("Jogador " + jogadorAtual + ", é sua vez:");
            jogo.exibirMapa(jogadorAtual);

            boolean continuarJogando = true;
            while (continuarJogando) {
                System.out.print("Digite a linha: ");
                int linha = scanner.nextInt();
                System.out.print("Digite a coluna: ");
                int coluna = scanner.nextInt();
                String resultado = jogo.jogada(jogadorAtual, linha, coluna);
                System.out.println(resultado);
                jogo.exibirMapa(jogadorAtual);

                if (resultado.equals("Essa jogada já foi feita. Por favor, escolha outra posição.") ||
                        resultado.equals("A posição não é válida, pois está fora do mapa. Por favor, escolha outra posição.")) {
                    // Se a jogada já foi feita ou está fora do mapa, continue com o mesmo jogador
                    continuarJogando = true;
                } else if (resultado.contains("Você achou uma posição")) {
                    // Se encontrou parte de uma embarcação, continue jogando até encontrar água ou bomba
                    continuarJogando = true;
                } else {
                    // Se a jogada foi válida e não encontrou parte de uma embarcação, mude para o próximo jogador
                    continuarJogando = false;
                    jogadorAtual = jogadorAtual == 1 ? 2 : 1; // Mudar de jogador
                }
            }
        }

        System.out.println("Jogo encerrado!");
        if (jogo.verificarGanhador()) {
            if (jogo.bombasEncontradasJogador1 >= 3 || jogo.bombasEncontradasJogador2 >= 3) {
                System.out.println("Jogador " + jogadorAtual + " encontrou 3 bombas e perdeu o jogo!");
            } else {
                System.out.println("Jogador " + jogadorAtual + " venceu o jogo!");
            }
        }
    }
}
