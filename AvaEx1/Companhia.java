public class Companhia {
    private String nome;
    private int qtdVoos;
    private Voo[] voos;

    public Companhia(){ // Metodo construtor
        this.voos = new Voo[10]; //Inicia o Vetor de voo com 10 posições
        this.qtdVoos = 0; //Inica quantidade em 0;
    }
    //Nome da companhia
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //Métodos relacionaod aos voos
    public int getQtdVoos(){
        return qtdVoos;
    }

    public Voo getVoo(int pos){
        if(pos >= 0 && pos < qtdVoos){ //posição se for valida
            return voos[pos]; //Retorna a posição
        }else {
            System.out.println("Posição Inválida!");
            return null;
        }
    }

    public void addVoo(Voo v){ 
        if (v == null){ //Verifica se o voo não é nulo
            System.out.println("Voo inválido");
            return;
        }
        if(qtdVoos < 10){ //Verifica se ainda a espaço para o voo
            this.voos[qtdVoos] = v;
            qtdVoos++;
        } else{
            System.out.println("Limite de Voos atingido");
        }
    }

    //Metodo alternativo por número
    public Voo getVooPorNumero(int numero){
        for (int i = 0; i < qtdVoos; i++){ //Percore todos os voos
            if(voos[i].getNumero() == numero){ //Se achar numero buscado
                return voos[i];
            }
        }
        return null; // se não achar retorna nulo.
    }
}
