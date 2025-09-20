package Aula;
public class Pessoa {
    
    private String nome;
    private String email;
    private int idade;

    public Pessoa(){}

    public Pessoa(String n, String e, int i){
        this.nome = n;
        this.email = e;
        this.idade = i;
    }
    //Nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //E-mail
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Idade
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
