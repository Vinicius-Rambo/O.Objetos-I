public class Escola {
    private String nome;
    private String fone;
    private int qtdTurmas;
    private Turma[] vetorTurmas;

    public Escola(){
        this.vetorTurmas = new Turma[20];
    }

    //Nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    
    }

    //Fone
    public String getFone() {
        return fone;

    }

    public void setFone(String fone) {
        this.fone = fone;
    
    }

    //Quantidade de turmas
    public int getQtdTurmas() {
        return qtdTurmas;

    }

    public void setQtdTurmas(int qtdTurmas) {
        this.qtdTurmas = qtdTurmas;
    
    }

    //Vetor turmas
    public Turma getTurma(int pos) {
        return vetorTurmas[pos];
    }

    public void setTurmas(Turma t) {
        if(qtdTurmas < 20){
            this.vetorTurmas[qtdTurmas] = t; //Ultima posição pela quantidade de alunos
            qtdTurmas++;
        }
    }

    
}
