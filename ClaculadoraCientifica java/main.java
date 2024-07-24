import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        System.out.println("Teste calculadora \n");
        int[] array = { 1, 2, 3, 4, 0 };
        calculadoraCientifica c = new calculadoraCientifica(array, '+');
        c.menu();
        System.out.println("Resultado da soma: " + c.GetResultado() + "\n");

        calculadoraCientifica c1 = new calculadoraCientifica(array, '-');
        c1.menu();
        System.out.println("Resultado da subtração: " + c1.GetResultado() + "\n");

        calculadoraCientifica c5 = new calculadoraCientifica(array, '^');
        c5.menu();
        System.out.println("Resultado da Potenciação: " + c5.GetResultado() + "\n");
        /*
         * calculadoraCientifica c2 = new calculadoraCientifica(array, '*');
         * System.out.println("Resultado da multiplicação: " + c2.GetResultado() +
         * "\n");
         * 
         * calculadoraCientifica c3 = new calculadoraCientifica(array, '/');
         * System.out.println("Resultado da divisão: " + c3.GetResultado() + "\n");
         * 
         * calculadoraCientifica c4 = new calculadoraCientifica(array, '^');
         * System.out.println("Resultado da Potenciação: " + c4.GetResultado() + "\n");
         * 
         * calculadoraCientifica c5 = new calculadoraCientifica(array, '%');
         * System.out.println("Resultado da Potenciação: " + c5.GetResultado() + "\n");
         * 
         * calculadoraCientifica c6 = new calculadoraCientifica(array, 'l');
         * System.out.println("Resultado da Potenciação: " + c6.GetResultado() + "\n");
         */

    }
}
