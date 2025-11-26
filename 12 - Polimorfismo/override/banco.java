public class banco {
    public static void main(String[] args) {
        System.out.println("Conta corrente");
        ContaCorrente cc1 = new ContaCorrente();
        cc1.depositar(1000);
        System.out.println("Saldo: " + cc1.getSaldo());
        boolean sacou = cc1.sacar(100);
        if(sacou){
            System.out.println("Sacou, saldo atual" + cc1.getSaldo());
        }else{
            System.out.println("não sacou");
        }


        System.out.println("Conta Especial");
        ContaEspecial ce1 = new ContaEspecial();
        ce1.depositar(2000);
        System.out.println("Saldo: " + ce1.getSaldo());
        sacou = ce1.sacar(200);
        if(sacou){
            System.out.println("Sacou, saldo atual" + cc1.getSaldo());
        }else{
            System.out.println("não sacou");
        }

        System.out.println("Conta Especial2");
        ContaEspecial ce2 = new ContaEspecial();
        ce2.depositar(2000);
        System.out.println("Saldo: " + ce2.getSaldo());
        sacou = ce2.sacar(200, 10);
        if(sacou){
            System.out.println("Sacou, saldo atual" + cc1.getSaldo());
        }else{
            System.out.println("não sacou");
        }

        


    }
}
