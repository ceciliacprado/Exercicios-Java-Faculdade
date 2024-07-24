public class pessoa {

    protected int rg = 0;
    protected int idade = 0;
    /* private Arraylist nomeFamiliares; */

    public pessoa(int rg, int idade) {
        this.rg = rg;
        this.idade = idade;
        /* nomeFamiliares = new Arraylist<>(); */
    }

    public pessoa(int rg) {
        this.rg = rg;
        this.idade = 0;
        /* nomeFamiliares = new Arraylist<>(); */
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getrg() {
        return rg;
    }

    public void setrg(int rg) {
        this.rg = rg;
    }

}