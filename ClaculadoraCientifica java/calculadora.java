public class calculadora {

    protected char op;
    protected float resultado;
    protected int[] array;

    calculadora(int[] array, char op) {
        this.array = array;
        this.op = op;
    }

    public void menu() {
        if (this.op == '+') {
            System.out.println("A operação é de soma!");
            soma();
        } else if (this.op == '-') {
            System.out.println("A opração é de subtração!");
            subtracao();
        } else if (this.op == '*') {
            System.out.println("A opração é de multiplicação!");
            multipiclacao();
        } else if (this.op == '/') {
            System.out.println("A opração é de divisão!");
            divisao();
        } else {
            System.out.println("A opração não é válida");
        }

        System.out.println("O Símbolo é: " + this.op);
    }

    private void soma() {

        for (int i = 0; i < this.array.length; i++) {
            this.resultado = resultado + this.array[i];
        }
    }

    private void subtracao() {

        this.resultado = array[0];
        for (int i = 1; i < this.array.length; i++) {
            this.resultado = resultado - this.array[i];
        }
    }

    private void multipiclacao() {

        this.resultado = 1;
        for (int i = 0; i < this.array.length; i++) {
            this.resultado = resultado * this.array[i];
        }
    }

    private void divisao() {

        this.resultado = 1;
        for (int i = 0; i < this.array.length; i++) {
            if (array[i] != 0) {
                this.resultado = resultado / this.array[i];
            }
        }
    }

    public float GetResultado() {
        return this.resultado;
    }

}