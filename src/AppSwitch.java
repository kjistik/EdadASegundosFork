
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class AppSwitch {

    static int getData(int prop) {
        int year, month, day;
        String year1, month1, day1;
        boolean valid = false;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                switch (prop) {
                    case 1: {
                        System.out.print("Escriba su año de nacimiento (YYYY): ");
                        year1 = sc.nextLine();
                        year = Integer.parseInt(year1);
                        if (year1.length() != 4) {
                            throw new NumberFormatException();
                        }
                        valid = true;
                        return year;
                    }
                    case 2: {
                        System.out.print("Escriba su mes de nacimiento (MM): ");
                        month1 = sc.nextLine();
                        month = Integer.parseInt(month1);
                        if (month1.length() != 2 || month < 1 || month > 12) {
                            throw new NumberFormatException();
                        }
                        valid = true;
                        return month;
                    }
                    case 3: {
                        System.out.print("Escriba su día de nacimiento (DD): ");
                        day1 = sc.nextLine();
                        day = Integer.parseInt(day1);
                        if (day1.length() != 2 || day < 1 || day > 31) {
                            throw new NumberFormatException();
                        }
                        valid = true;
                        return day;
                    }
                    default: {
                        return -1;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ingresar un número entero de 4 dígitos.");
            }
        } while (!valid);
        sc.close();
        return -1;
    }

    // Inicio.
    public static void main(String[] args) throws Exception {
        // Declaración de variables usadas.
        Scanner sc = new Scanner(System.in);
        int year, month, day;
        String respuesta;
        boolean valid = false;
        LocalDate fechaActual = LocalDate.now();
        long aSeg;

        // Mensaje.
        System.out.println("Convertiremos su edad a segundos");
        // Datos del año.
        year = getData(1);
        // Datos del mes.
        month = getData(2);
        // Datos del día.
        day = getData(3);
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
                valid = true;
            } else if (respuesta.equalsIgnoreCase("N")) {
                System.out.println("Cerrando el programa...");
                valid = true;
            } else {
                System.out.println("Respuesta inválida. Por favor, ingrese Y o N.");
            }

        } while (!valid);
        System.out.println("¡Que tenga un buen día!");
        // Se cierra el scanner.
        sc.close();
    }
}
// Fin programa.
