/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.ups.proyecto.mateo.orellana.vista;

import ec.edu.ups.proyecto.mateo.orellana.modelo.Contacto;
import ec.edu.ups.proyecto.mateo.orellana.controlador.ArbolContactos;
import java.util.Scanner;

/**
 *
 * @author mateo
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolContactos arbol = new ArbolContactos();

        while (true) {
            System.out.println("1. Agregar Contacto");
            System.out.println("2. Buscar Contacto");
            System.out.println("3. Eliminar Contacto");
            System.out.println("4. Agregar Correo");
            System.out.println("5. Agregar Red Social");
            System.out.println("6. Imprimir Árbol (preorder, inorder, postorder, achura)");
            System.out.println("7. Obtener número de contactos totales");
            System.out.println("8. Obtener número de niveles del árbol");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del contacto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Número de teléfono: ");
                    String telefono = scanner.nextLine();
                    arbol.agregarContacto(new Contacto(nombre, telefono));
                    break;
                case 2:
                    System.out.print("Nombre del contacto a buscar: ");
                    String nombreBusqueda = scanner.nextLine();
                    Contacto contactoBuscado = arbol.buscarContacto(nombreBusqueda);
                    if (contactoBuscado != null) {
                        System.out.println(contactoBuscado);
                    } else {
                        System.out.println("Contacto no encontrado.");
                        System.out.print("¿Desea crear un nuevo contacto con el nombre ingresado? (S/N): ");
                        String respuesta = scanner.nextLine();
                        if (respuesta.equalsIgnoreCase("S")) {
                            System.out.print("Número de teléfono: ");
                            String nuevoTelefono = scanner.nextLine();
                            arbol.agregarContacto(new Contacto(nombreBusqueda, nuevoTelefono));
                        }
                    }
                    break;
                case 3:
                    System.out.print("Nombre del contacto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    arbol.eliminarContacto(nombreEliminar);
                    break;
                case 4:
                    System.out.print("Nombre del contacto: ");
                    String nombreCorreo = scanner.nextLine();
                    System.out.print("Correo a agregar: ");
                    String correo = scanner.nextLine();
                    arbol.agregarCorreo(nombreCorreo, correo);
                    break;
                case 5:
                    System.out.print("Nombre del contacto: ");
                    String nombreRedSocial = scanner.nextLine();
                    System.out.print("Red social a agregar: ");
                    String redSocial = scanner.nextLine();
                    System.out.print("URL de la red social: ");
                    String url = scanner.nextLine();
                    arbol.agregarRedSocial(nombreRedSocial, redSocial, url);
                    break;
                case 6:
                    System.out.println("Recorrido Preorder:");
                    arbol.recorridoPreorder();
                    System.out.println("Recorrido Inorder:");
                    arbol.recorridoInorder();
                    System.out.println("Recorrido Postorder:");
                    arbol.recorridoPostorder();
                    System.out.println("Recorrido por Achura:");
                    arbol.recorridoAchura();
                    break;
                case 7:
                    int totalContactos = arbol.obtenerNumeroContactos();
                    System.out.println("Número de contactos totales: " + totalContactos);
                    break;
                case 8:
                    int numNiveles = arbol.obtenerNumeroNiveles();
                    System.out.println("Número de niveles del árbol: " + numNiveles);
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
    }
}
