public class Voo {
    private int numero;
    private String localEmbarque;
    private String destino;
    private int qtdPassageiros;
    private Passageiro[] passageiros;

    public Voo(){
        this.passageiros = new Passageiro[50];
    }

    // Número
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    //Local de Embarque
    public String getLocalEmbarque() {
        return localEmbarque;
    }

    public void setLocalEmbarque(String localEmbarque) {
        this.localEmbarque = localEmbarque;
    }

    //Destino
    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    //Passageiros e Quantidade de Passageiros
    public  int getQtdPassageiros(){
        return qtdPassageiros;
    }

    public Passageiro getPassageiro(int pos){
        return passageiros[pos];
    }

    public void addPassageiro(Passageiro p){ //Adiciona um passageiro ao voo
        if (qtdPassageiros < 50){ //Verifica se ainda cabe mais 1
            this.passageiros[qtdPassageiros] = p; //Guarda passageiro na proxima posição do voo
            qtdPassageiros++; //Adiciona +1 na quantidade de passageiros
        }else {
            System.out.println("O voo já esgotou seus passageiros");
        }
    }

    public int getAssentosLivres(){ //Metodo que retorna a quantidade acento livre
        return 50 - qtdPassageiros;
    }
}
