// Clase Rectangulo (que extiende Figura y implementa Dibujar)
// con los atributos lado1, lado2 y lado3
public class Triangulo extends Figura implements Dibujable {

    private double lado1, lado2, lado3;

    // Constructor
    public Triangulo(double lado1, double lado2, double lado3) {
        setLados(lado1, lado2, lado3);
    }

    // Setters, en este caso no necesitamos los getters
    public void setLados(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0)
            throw new IllegalArgumentException("Los lados deben ser positivos.");

        if (a + b <= c || a + c <= b || b + c <= a)
            throw new IllegalArgumentException("Los lados NO forman un triángulo válido.");

        lado1 = a; lado2 = b; lado3 = c;
    }

    // Metodos sobreescritos calcularArea y calcularPerimetro
    @Override
    public double calcularArea() {
        double s = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3)); // Fórmula de Herón
    }

    @Override
    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }

    // Metodo implementado dibujar
    @Override
    public void dibujar() {
        System.out.println("  *  ");
        System.out.println(" *** ");
        System.out.println("*****");
    }
}
