public class Decisao {
    public static void main(String args[]){

        if (args.length < 2){
            System.out.println("Precisa de 2 parametros.");
            System.exit(0);
        }
        int val1 = Integer.parseInt(args[0]); //Converte String para INT
        int val2 = Integer.parseInt(args[1]);
        OpMath opMath = new OpMath();

        System.out.println(args[0] + "*" + args[1] + "="  + opMath.multiplicar(val1, val2));
    }
}
