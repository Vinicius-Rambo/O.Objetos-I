public class Turma {
    private int numTurma;
    private String nomeCurso;
    private int anoIngresso;
    private int qtdAlunos;
    private Aluno[] vetAlunos;

    public Turma(){
        this.vetAlunos = new Aluno[40];
    }

    //NumTurma
    public int getNumTurma() {
        return numTurma;
    }

    public void setNumTurma(int numTurma) {
        this.numTurma = numTurma;
    }

    //nome Curso
    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    //Ano ingresso
    public int getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    // Quantidade de alunos
    public int getQtdAlunos() {
        return qtdAlunos;
    }

    public void setQtdAlunos(int qtdAlunos) {
        this.qtdAlunos = qtdAlunos;
    }

    //Vet Alunos
    public Aluno getVetAlunos(int pos) {
        return vetAlunos[pos];
    }

    public void setVetAlunos(Aluno a) {
        if(qtdAlunos < 40){
            this.vetAlunos[qtdAlunos] = a; //Ultima posição pela quantidade de alunos
            qtdAlunos++;
        }
    }

    
}
