public class Pessoa { // Inicia a classe

    private String nome; // variáveis
    private int rg; // public, private, etc é modificador de acesso

    public Pessoa(String nome, int rg) { // Método para a classe
        this.nome = nome; // this. para se referir as variáveis
        this.rg = rg;
    }

    public void setNome(String nome) { // Para alterar as informações futuramente, void para o método não retornar
        this.nome = nome;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public String getNome() { // Sem o void pois ele retorna um valor, get para pegar os nomes da variável
        return this.nome; // esse método retorna a String nome
    }

    public int getRg() {
        return this.rg;
    }

}