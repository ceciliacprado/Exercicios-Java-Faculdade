import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        System.out.println("Teste calculadora");
        int[] array = { 0, 1, 0, 0, 2, 3, 4 };
        calculadora c = new calculadora(array, '+');
        System.out.println("Resultado da soma: " + c.GetResultado());

        calculadora c1 = new calculadora(array, '-');
        System.out.println("Resultado da subtração: " + c1.GetResultado());

        calculadora c2 = new calculadora(array, '*');
        System.out.println("Resultado da multiplicação: " + c2.GetResultado());

        calculadora c3 = new calculadora(array, '/');
        System.out.println("Resultado da divisão: " + c3.GetResultado());

    }
}