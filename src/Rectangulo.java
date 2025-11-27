// Clase Rectangulo (que extiende Figura y implementa Dibujar)
// con los atributos base y altura
public class Rectangulo extends Figura implements Dibujable {

    private double base;
    private double altura;

    // Constructor
    public Rectangulo(double base, double altura) {
        setBase(base);
        setAltura(altura);
    }

    // Setters y Getters
    public double getBase() { return base; }
    public double getAltura() { return altura; }

    public void setBase(double base) {
        if (base <= 0) throw new IllegalArgumentException("La base debe ser positiva.");
        this.base = base;
    }

    public void setAltura(double altura) {
        if (altura <= 0) throw new IllegalArgumentException("La altura debe ser positiva.");
        this.altura = altura;
    }

    // Metodos sobreescritos calcularArea y calcularPerimetro
    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    // Metodo implementado dibujar
    @Override
    public void dibujar() {
        System.out.println("******");
        System.out.println("*    *");
        System.out.println("******");
    }
}
