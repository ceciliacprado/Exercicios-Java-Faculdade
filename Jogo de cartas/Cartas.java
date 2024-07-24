import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Cartas {

    private String carta1;
    private String carta2;
    private String carta3;
    private String cartaMaquina;
    private int valorTotal; 

    ArrayList<String> baralho = new ArrayList<>();

    public Cartas() {

        String[] cartas = { "A", "2", "3", "4", "5", "6", "7", "Q", "J", "K" };
        String[] cartasValor = { "9", "7", "8", "0", "1", "2", "3", "4", "5", "6" };
        String[] naipes = { "OURO", "COPAS", "ESPADA", "PAUS" };
        String[] naipesValor = { "1", "3", "2", "4" };

        for (int i = 0; i < cartas.length; i++) {
            for (int j = 0; j < naipes.length; j++) {
                int valorCarta = Integer.parseInt(cartasValor[i]);
                int valorNaipe = Integer.parseInt(naipesValor[j]);
                valorTotal = valorCarta + valorNaipe;
                String cartaCompleta = cartas[i] + " de " + naipes[j] + " (Valor da carta = " + valorTotal + ")";
                baralho.add(cartaCompleta);
            }
        }
    }

    public int getValorCarta(String carta) {
        String[] partes = carta.split(" \\(Valor da carta = ");
        int valor = Integer.parseInt(partes[1].replace(")", ""));
        return valor;
    }

    public void cartasJ1() {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(baralho.size());
            if (i == 0) {
                this.carta1 = baralho.get(randomIndex);
            } else if (i == 1) {
                this.carta2 = baralho.get(randomIndex);
            } else {
                this.carta3 = baralho.get(randomIndex);
            }
            baralho.remove(randomIndex);
        }
        System.out.println("Sua carta 1: " + this.carta1);
        System.out.println("Sua carta 2: " + this.carta2);
        System.out.println("Sua carta 3: " + this.carta3);
    }

    public void cartaMaquina() {
        Random random = new Random();
        for (int i = 0; i < 1; i++) {
            int randomIndex = random.nextInt(baralho.size());
            if (i == 0) {
                this.cartaMaquina = baralho.get(randomIndex);
            }
            baralho.remove(randomIndex);
        }
    }

    public void imprimirBaralho() {
        Collections.shuffle(baralho);
        for (String baralho : baralho) {
            System.out.println(baralho);
        }
    }

    public ArrayList<String> getBaralho() {
        return baralho;
    }

    public String getCarta1() {
        return this.carta1;
    }

    public String getCarta2() {
        return this.carta2;
    }

    public String getCarta3() {
        return this.carta3;
    }

    public String getCartaMaquina() {
        return this.cartaMaquina;
    }

    public void setCarta1(String carta1) {
        this.carta1 = carta1;
    }

    public void setCarta2(String carta2) {
        this.carta2 = carta2;
    }

    public void setCarta3(String carta3) {
        this.carta3 = carta3;
    }

}