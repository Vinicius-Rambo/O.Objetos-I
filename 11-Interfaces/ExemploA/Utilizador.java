package ExemploA;
public class Utilizador {
    public static void main(String[] args) {
        //Relogio
        System.out.println("Relogio de pulso");
        RelogioDePulso rp = new RelogioDePulso();
        System.out.println(rp.getHoras());
        System.out.println(rp.iniciarCronometro());


        //Por padrão não se pode instanciar uma interface a menos que faça na hora uma implementação dos métodos, recurso mais restrito e estranho.
        Relogio r = new Relogio(){ //Que bizarro
            public String getHoras(){
                return "Essa bizarrice";
            }
        };

        //Radio
        System.err.println("\n".repeat(10)); //Só para eu ver as diferentes partes do codigo
        System.out.println("[Rádio Relógio]");
        RadioRelogio rr = new RadioRelogio();
        System.out.println(rr.ligar());
        System.out.println(rr.getHoras());
        System.out.println(rr.trocarEstacao(101.8f));
        System.out.println(rr.desligar());
    }
}
