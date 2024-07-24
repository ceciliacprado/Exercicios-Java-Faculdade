import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        funcionario func1 = new funcionario(6543, 28, 1010);
        System.out.println("Funcioário 1");
        System.out.println("Idade: " + func1.getIdade());
        System.out.println("Rg: " + func1.getrg());
        System.out.println("Matrícula: " + func1.getcodMatricula());

    }
}
