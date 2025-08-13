public class exemplo4 {
    public static void main(String args[]){
        OpMath opMath = new OpMath();

        System.out.println("5 - 6 = " + opMath.subtrair(5, 6));
        System.out.println("15 + 16 = " + opMath.somar(15, 16));
        System.out.println("8 * 6 = " + opMath.multiplicar(8, 6));
        System.out.println("57 / 0 = " + opMath.dividir(57, 0));
        System.out.println("57 / 19 = " + opMath.dividir(57, 19));
    }
}
