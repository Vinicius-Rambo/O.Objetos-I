import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sistema {
    public static void main(String[] args) throws Exception {
        BufferedReader teclado =  new BufferedReader(new inputStreamReader(System.in));
        System.out.println("Calculador de Área");

        System.out.println("\nQuadrado = Lado * Lado");
        Quadrado q = new Quadrado();
        System.out.println("Informe o lado: ");
        float lado = Float.valueOf(teclado.readline());
        System.out.println("Área do quadrado: " + q.calcularArea(lado, lado));

        System.out.println("\nRetangulo = Base * Altura");
        Retangulo r = new Retangulo();
        System.out.println("Informe a Altura: ");
        float altura = Float.valueOf(teclado.readline());
        System.out.println("Informe a base: ");
        float base = Float.valueOf(teclado.readline());
        System.out.println("Área do Retangulo: " + r.calcularArea(altura , base));


        System.out.println("\nCirculo = 2 * Pi * Raio");
        Circulo c = new Circulo();
        System.out.println("Informe o Raio");
        float raio = Float.valueOf(teclado.readline());
        System.out.println("Área do Circulo: " + c.calcularArea(raio, raio));


    }
}
