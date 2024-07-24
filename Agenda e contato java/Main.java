public class Main { // abre a classe
    public static void main(String[] args) { // método para abrir a classe main
        Pessoa vitor = new Pessoa("Vitor Campos", 1234); // adiciona as informações as variáveis
        System.out.println("O nome é " + vitor.getNome());// o get é para pegar as informações privadas, esse é o print
        vitor.setNome("Rafael");
        System.out.println("O nome é: " + vitor.getNome());
        Militar c = new Militar("Gabriel", 7890, "Tenente", 1);
        Militar c1 = new Militar("Heitor", 7891, "Coronel", 2);
        Militar c2 = new Militar("Igor", 7892, "Cabo", 3);
        Agenda a = new Agenda();
        a.AdicionarMilitar(c);
        a.AdicionarMilitar(c1);
        a.AdicionarMilitar(c2);
        a.listaMilitar();
    }

}