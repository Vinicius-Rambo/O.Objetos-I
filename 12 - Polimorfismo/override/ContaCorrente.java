public class ContaCorrente {
    private int numConta;
    private String nome;
    private double saldo;

    //Metodos 

    public void depositar(double deposito){
        this.saldo += deposito;
    }

    public boolean sacar(double valor){
        boolean resultado = false;
        double taxa = 0.005d;
        if(this.saldo >= (valor + (valor * taxa))){
            this.saldo = this.saldo - valor - (valor * taxa);
            resultado = true;
        }

        return resultado;

    }
    //Gets e setter 

    //Número da conta
    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    //Nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //Saldo
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    
}