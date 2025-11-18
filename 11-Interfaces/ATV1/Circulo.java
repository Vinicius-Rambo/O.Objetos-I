public class Circulo implements FormaGeometrica{
    public float calcularArea(float lado1, float lado2 ){
        double area2 = 3.14 * (lado1 * lado2);
        float area = (float) area2;
        return area;
    }
}
