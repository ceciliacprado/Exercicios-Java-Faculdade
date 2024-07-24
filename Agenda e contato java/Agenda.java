import java.util.ArrayList;

public class Agenda {
    private ArrayList<Militar> listaAgenda; // os operadores <> São para fazer a tipagem da lista, a array utilizada é
                                            // uma classe do java para fazer uma lista

    public Agenda() {
        listaAgenda = new ArrayList<>(); // como ela é uma classe do java devemos inicializar ela.
    }

    public void AdicionarMilitar(Militar M) { // método para adicionar militar (void pois não retorna nenhum valor)
        listaAgenda.add(M); // inicializa a lista com os valores de Militar. Add é para ir adicionando os
                            // alores na lista.
    }

    public void listaMilitar() {
        for (int i = 0; i < listaAgenda.size(); i++) { // size é para pegar o tamanho da lista.
            System.out.println("O nome é: " + listaAgenda.get(i).getNome() + "O Rg é: " + listaAgenda.get(i).getRg()
                    + "O cargo do militar é: " + listaAgenda.get(i).getCargo() + "A matrícula do militar é: "
                    + listaAgenda.get(i).getMatricula()); // utilizamos listaAgenda.get(i).getNome() para percorrer os
                                                          // elementos da lista e printar os valores do get de cada
                                                          // linha da lista.
        }
    }
}
