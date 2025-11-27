import java.util.InputMismatchException;
import java.util.Scanner;

// Clase Main con el metodo main para ejecutar el codigo
public class Main {

    public static void main(String[] args) {

        // Declaramos un scanner
        Scanner sc = new Scanner(System.in);

        // Creamos un array de Figuras con limite de 20
        Figura[] figuras = new Figura[20];

        // Declaramos dos variables
        // contador en cero, y opcion en -1 (para no crear problemas con el while)
        int contador = 0;
        int opcion = -1;

        // Hacemos un bucle while, mientras el usuario no
        // indique que quiera salir, el bucle seguira
        while (opcion != 0) {

            // Menu donde podremos crear figuras y guardarlas en el Array
            System.out.println("\n=== CALCULADORA DE FIGURAS GEOMÉTRICAS ===");
            System.out.println("1. Crear Círculo");
            System.out.println("2. Crear Rectángulo");
            System.out.println("3. Crear Triángulo");
            System.out.println("4. Mostrar resumen");
            System.out.println("5. Dibujar figuras");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            // Se lee la opcion
            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: debes introducir un número.");
                sc.nextLine(); // limpiar buffer
                continue;
            }

            switch (opcion) {

                case 1 -> { // Círculo
                    try {
                        System.out.print("Introduce el radio: ");
                        double radio = sc.nextDouble();

                        Figura c = new Circulo(radio);
                        figuras[contador++] = c;

                        System.out.printf("Área: %.2f\n", c.calcularArea());
                        System.out.printf("Perímetro: %.2f\n", c.calcularPerimetro());
                    } catch (InputMismatchException e) {
                        System.out.println("Error: debes introducir un número.");
                        sc.nextLine();
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                case 2 -> { // Rectángulo
                    try {
                        System.out.print("Introduce la base: ");
                        double base = sc.nextDouble();

                        System.out.print("Introduce la altura: ");
                        double altura = sc.nextDouble();

                        Figura r = new Rectangulo(base, altura);
                        figuras[contador++] = r;

                        System.out.printf("Área: %.2f\n", r.calcularArea());
                        System.out.printf("Perímetro: %.2f\n", r.calcularPerimetro());
                    } catch (InputMismatchException e) {
                        System.out.println("Error: debes introducir números.");
                        sc.nextLine();
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                case 3 -> { // Triángulo
                    try {
                        System.out.print("Lado 1: ");
                        double l1 = sc.nextDouble();
                        System.out.print("Lado 2: ");
                        double l2 = sc.nextDouble();
                        System.out.print("Lado 3: ");
                        double l3 = sc.nextDouble();

                        Figura t = new Triangulo(l1, l2, l3);
                        figuras[contador++] = t;

                        System.out.printf("Área: %.2f\n", t.calcularArea());
                        System.out.printf("Perímetro: %.2f\n", t.calcularPerimetro());
                    } catch (InputMismatchException e) {
                        System.out.println("Error: debes introducir números.");
                        sc.nextLine();
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                case 4 -> {
                    System.out.println("\n--- Resumen de figuras creadas ---");
                    for (int i = 0; i < contador; i++) {
                        Figura f = figuras[i];
                        System.out.println((i + 1) + ". " + f.getClass().getSimpleName()
                                + " | Área: " + f.calcularArea()
                                + " | Perímetro: " + f.calcularPerimetro());
                    }
                }

                case 5 -> {
                    System.out.println("\n--- Dibujando todas las figuras ---");

                    for (int i = 0; i < contador; i++) {
                        Figura f = figuras[i];

                        System.out.println((i + 1) + ". " + f.getClass().getSimpleName());

                        if (f instanceof Dibujable d) {
                            d.dibujar();
                        } else {
                            System.out.println("No dibujable");
                        }
                    }
                }

                case 0 -> System.out.println("Saliendo...");

                default -> System.out.println("Opción no válida.");
            }
        }

        sc.close();
    }
}