public class Funcionario extends Pessoa{
    private String registro;
    private String setor;
    private String filial;
    private float salario;
    private String login;
    private String senha;


    public Funcionario(){} //Contrutor top

    //Registro
    public String getRegistro() {
        return registro;
    }
    public void setRegistro(String registro) {
        this.registro = registro;
    }

    //Setor
    public String getSetor() {
        return setor;
    }
    public void setSetor(String setor) {
        this.setor = setor;
    }

    //Filial
    public String getFilial() {
        return filial;
    }
    public void setFilial(String filial) {
        this.filial = filial;
    }

    //Salario
    public float getSalario() {
        return salario;
    }
    public void setSalario(float salario) {
        this.salario = salario;
    }

    //Login
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    //Senha
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    

}
