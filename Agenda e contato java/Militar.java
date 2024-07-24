public class Militar extends Pessoa { // para a classe militar ter as informações da classe pessoa usamos o extends

    private int matricula;
    private String cargo;

    public Militar(String nome, int rg, String cargo, int matricula) {// dentro do () ficam as variáveis que esse metodo
                                                                      // recebe
        super(nome, rg); // super serve para chamar as variáveis da classe mãe
        this.matricula = matricula;
        this.cargo = cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() { // get não tem parâmetro
        return this.cargo;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getMatricula() {
        return this.matricula;
    }

}
