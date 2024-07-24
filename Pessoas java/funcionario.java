public class funcionario extends pessoa {
    private int codMatricula;

    public funcionario(int rg, int idade, int codMatricula) {
        super(rg, idade);
        this.codMatricula = codMatricula;
    }

    public int getcodMatricula() {
        return codMatricula;
    }

    public void setIdade(int idade) {
        if (idade >= 18) {
            super.idade = idade;
        } else {
            System.out.println(
                    "O funcionário não pode ser menor de idade, ovalor: " + idade + "para a idade foi rejeitado");
        }
    }

}
