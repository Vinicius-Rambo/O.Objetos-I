public class ContaEspecial extends ContaCorrente{

    @Override //annotion que força o polimorfismo de sobreposição (herança)
    public boolean sacar(double valor){
        boolean resultado = false;
        double taxa = 0.003d;

        if(this.getSaldo() >= (valor + (valor * taxa))){
            this.setSaldo(this.getSaldo() - valor - (valor * taxa));
            resultado = true;
        }
        return resultado;
    }

    //Polimorfismo por sobrecarga de método
    public boolean sacar(double valor, double taxa){
        boolean resultado = false;

        if(this.getSaldo() >= (valor + (valor * taxa))){
            this.setSaldo(this.getSaldo() - valor - (valor * taxa));
            resultado = true;
        }
        return resultado;
    }

}
