public class Passageiro {
    private String nome;    
    private String cpf;
    private String telefone;
    private String endereco;
    private String assento;
    private int idade;
    private int peso;
    private String numPassaporte;

    //Nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    //CPF
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    ///Telefone
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    //Endereço (Isso seria melhor como uma Struct.)
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    //Assento (implementação interressante seria forçar isso a ser unico)
    public String getAssento() {
        return assento;
    }
    public void setAssento(String assento) {
        this.assento = assento;
    }
    
    //Idade
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    //Peso
    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    //Passaporte
    public String getNumPassaporte() {
        return numPassaporte;
    }
    public void setNumPassaporte(String numPassaporte) {
        this.numPassaporte = numPassaporte;
    }
}

