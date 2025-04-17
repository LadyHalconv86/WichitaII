package wichitaII;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in); // Creamos un objeto scanner de la clase Scanner
        boolean continuar = true; // Inicializa la variable booleana continuar como true (por defecto, si no se
        // especifica, se inicializa en false)

        while (continuar) { // Se mantiene en el bucle while mientras no se modifique la variable booleana
            // continuar a false
            System.out.println("Elige una opción");
            System.out.println("1. Añadir Estudiante");
            System.out.println("2. Listar Estudiantes");
            System.out.println("3. Eliminar listado de estudiantes"); // He añadido una opción más para eliminar el
            // listado si se considera necesario
            System.out.println("4. Salir");
            int opcion = scanner.nextInt(); // Se crea el objeto de tipo entero opcion que tomará el valor introducido
            // por teclado gracias a la clase Scanner
            scanner.nextLine(); // Cambia de línea tras introducir la opción requerida

            switch (opcion) {
                case 1:
                    System.out.println("Introduce el nombre del estudiante");
                    String nombre = scanner.nextLine(); // Se introduce la variable nombre de tipo String por teclado y
                    // cambia de línea
                    System.out.println("Introduce la edad del estudiante");
                    int edad = scanner.nextInt(); // Se introduce la variable edad de tipo entero por teclado y cambia de
                    // línea
                    addEstudiante(nombre, edad); // Lanza el método estático addEstudiante con los atributos nombre y edad
                    break;
                case 2:
                    listarEstudiantes(); // Lanza el método estático listarEstudiantes
                    break;
                case 3:
                    eliminarListado(); // Lanza el método estático eliminarListado
                    break;
                case 4:
                    continuar = false; // Cambia el valor de continuar a false, con lo que sale del bucle
                    System.out.println("Operación finalizada");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, inténtalo de nuevo"); // Mensaje por defecto si se indica
                // una opción diferente a 1, 2,
                // 3 o 4
            }

        }

    }

    private static void addEstudiante(String nombre, int edad) { // Método estático para añadir estudiante al listado
        try (FileWriter fw = new FileWriter("estudiantes.txt", true); BufferedWriter bw = new BufferedWriter(fw)) { // Crea
            // el
            // archivo
            // estudiantes.txt
            bw.write(nombre + ", " + edad + " años."); // Escribe en el archivo estudiantes.txt el nombre y edad de los
            // estudiantes con la estructura indicada
            bw.newLine();
        } catch (IOException e) { // Captura la excepción de tipo input o output
            System.out.println("Ocurrió un error al escribir el archivo."); // Mensaje que devuelve en caso de que se
            // capture la excepción
            ;
        }
    }

    private static void listarEstudiantes() { // Método estático para listar los estudiantes añadidos al archivo
        // estudiantes.txt

        try (FileReader fr = new FileReader("estudiantes.txt"); BufferedReader br = new BufferedReader(fr)) {
            String str; // Añadirá la información escrita en el archivo estudiantes.txt a un objeto de
            // tipo String denominado str

            while ((str = br.readLine()) != null) { // Mientras el objeto de tipo String str tenga líneas de texto,
                // imprimirá esas líneas
                System.out.println(str);
            }

        } catch (FileNotFoundException e) { // Excepción capturada si no encuentra el archivo
            System.out.println(e.getMessage());
        } catch (IOException e) { // Excepción capturada de tipo inputo/output
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }

    }

    private static void eliminarListado() { // Método estático para eliminar el listado
        File archivo = new File("estudiantes.txt"); // Hacemos que estudiantes.txt se cree como objeto denominado
        // archivo de la clase File
        Scanner scanner = new Scanner(System.in); // Creamos un nuevo scanner. Al ser métodos privados, no podemos
        // acceder al scanner del menú original

        System.out.println("¿Está seguro de que desea eliminar el listado de estudiantes?");
        System.out.println("1. Sí, deseo eliminar el listado");
        System.out.println("2. No, deseo volver al menú principal");

        int opcion2 = scanner.nextInt(); // Se crea el objeto de tipo entero opcion2 que tomará el valor introducido por
        // teclado gracias a la clase Scanner
        scanner.nextLine(); // Cambia de línea al introducir la opción

        switch (opcion2) { // Bucle switch
            case 1:
                archivo.delete(); // Elimina el objeto archivo, es decir, estudiantes.txt
                System.out.println("El listado se ha eliminado correctamente"); // Devuelve mensaje de operación realizada
                // // correctamente
                break;
            case 2:
                break; // En caso de escoger la opción 2, sale del bucle y volverá al bucle switch
            // original del método main ya que no hemos cambiado el valor de continuar a
            // false
            default:
                System.out.println("Opción no válida. Por favor, intenta de nuevo"); // Mensaje por defecto si no se escogen
            // las opciones 1 o 2
        }

    }

}
