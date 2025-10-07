public class Conversoes {
    public static void main(String args[]){
        String s1 = "10";
        System.out.println("s1:" + s1);
        
        //Converter de String para Int
        int i1 = Integer.parseInt(s1);
        System.out.println("il:" + i1);

        //converter de Integer para String
        Integer i2 = 5;
        s1 = i2.toString();
        s1 = Integer.toString(i2);
        //s1 = i1.toString(); Não funciona pois i1 é tipo primitivo.
        
        // converter para Float

        float f1 = i2.floatValue() / 3;
        System.out.println("f1: " + f1);
        System.out.println("f1: " + String.format("%.02f", f1));
        
        //comparação
        Integer i3 = 10;
        int i4 = 10;
        System.out.println(i3 == i4); // Ideal para string
        System.out.println(i3.equals(i4)); //Funciona da mesma forma.
    }    
}
