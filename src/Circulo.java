// Clase Circulo (que extiende Figura y implementa Dibujar)
// con el atributo radio
public class Circulo extends Figura implements Dibujable{
    private double radio;

    // Constructor
    public Circulo(double radio) {
        setRadio(radio);
    }

    // Setters y Getters
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        if (radio <= 0) {
            throw new IllegalArgumentException("El radio debe ser positivo.");
        }
        this.radio = radio;
    }

    // Metodos sobreescritos calcularArea y calcularPerimetro
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    // Metodo implementado dibujar
    @Override
    public void dibujar() {
        System.out.println("  ***  ");
        System.out.println(" *   * ");
        System.out.println("  ***  ");
    }
}
