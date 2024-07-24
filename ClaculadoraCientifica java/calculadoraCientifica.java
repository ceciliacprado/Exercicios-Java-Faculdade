import java.lang.Math;
import java.lang.Override;

public class calculadoraCientifica extends calculadora {

    calculadoraCientifica(int[] array, char op) {
        super(array, op);
    }

    @Override
    public void menu() {
        if (super.op == '^') {
            System.out.println("A operação é de potencia!");
            potencia();
        } else if (super.op == '%') {
            System.out.println("A opração é de Raiz Quadrada!");
            raizQuadrada();
        } else if (super.op == 'l') {
            System.out.println("A opração é de Logarítmo");
            log();
        } else {
            System.out.println("A opração não é válida");
        }

        System.out.println("O Símbolo é: " + super.op);

    }

    private void potencia() {
        super.resultado = (float) Math.pow(super.array[0], 2);
        for (int i = 1; i < super.array.length; i++) {
            super.resultado = super.resultado + (float) Math.pow(super.array[i], 2);
        }

    }

    private void raizQuadrada() {
        super.resultado = (float) Math.sqrt(array[0]);
    }

    private void log() {
        super.resultado = (float) Math.log(array[0]) / (float) Math.log(array[1]);
    }

    public float GetResultado() {
        return super.resultado;
    }
}
