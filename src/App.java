import java.time.LocalDate;
import java.util.Scanner;
import java.time.Period;

public class App {
    // Inicio.
    public static void main(String[] args) throws Exception {
        // Declaración de variables usadas.
        Scanner sc = new Scanner(System.in);
        int year = 0, month = 0, day = 0;
        String year1, month1, day1, respuesta;
        boolean valid1 = false, valid2 = false, valid3 = false, valid4 = false;
        LocalDate fechaActual = LocalDate.now();
        long aSeg = 0;

        // Mensaje.
        System.out.println("Convertiremos su edad a segundos");
        // Datos del año.
        do {
            try {
                System.out.print("Escriba su año de nacimiento (YYYY): ");
                year1 = sc.nextLine();
                year = Integer.parseInt(year1);
                if (year1.length() != 4) {
                    throw new NumberFormatException();
                }
                valid1 = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ingresar un número entero de 4 dígitos.");
            }
        } while (!valid1);
        // Datos del mes.
        do {
            try {
                System.out.print("Escriba su mes de nacimiento (MM): ");
                month1 = sc.nextLine();
                month = Integer.parseInt(month1);
                if (month1.length() != 2) {
                    throw new NumberFormatException();
                } else if (month < 1 || month > 12) {
                    throw new NumberFormatException();
                }
                valid2 = true;
            } catch (NumberFormatException e) {
                System.out.println(
                        "Entrada inválida. Debe ingresar un número entero de 2 dígitos y que esté entre 01 y 12.");
            }
        } while (!valid2);
        // Datos del día.
        do {
            try {
                System.out.print("Escriba su día de nacimiento (DD): ");
                day1 = sc.nextLine();
                day = Integer.parseInt(day1);
                if (day1.length() != 2) {
                    throw new NumberFormatException();
                } else if (day < 1 || day > 31) {
                    throw new NumberFormatException();
                }
                valid3 = true;
            } catch (NumberFormatException e) {
                System.out.println(
                        "Entrada inválida. Debe ingresar un número entero de 2 dígitos y que esté entre 01 y 31.");
            }
        } while (!valid3);
        // Conversión datos a edad.
        LocalDate fechaNac = LocalDate.of(year, month, day);
        System.out.println("¡Datos ingresados correctamente!");
        Period periodo = Period.between(fechaNac, fechaActual);
        int edad = periodo.getYears();
        System.out.println("Su edad actual es de " + edad + " años.");
        // Conversión opcional.
        do {
            System.out.print("¿Convertir a segundos? (Y/N): ");
            respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("Y")) {
                aSeg = edad * 365L * 24 * 60 * 60;
                System.out.println("Su edad es de " + aSeg + " segundos.");
                valid4 = true;
            } else if (respuesta.equalsIgnoreCase("N")) {
                System.out.println("Cerrando el programa...");
                valid4 = true;
            } else {
                System.out.println("Respuesta inválida. Por favor, ingrese Y o N.");
            }

        } while (!valid4);
        System.out.println("¡Que tenga un buen día!");
        // Se cierra el scanner.
        sc.close();
    }
}
// Fin programa.