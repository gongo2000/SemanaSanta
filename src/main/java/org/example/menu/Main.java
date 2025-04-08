package org.example.menu;

import org.example.model.Cofradia;
import org.example.management.XMLManagement;
import org.example.management.JSONManagement;
import org.example.management.TXTManagement;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TXTManagement txtManagement = new TXTManagement();
        XMLManagement xmlManagement = new XMLManagement();
        JSONManagement jsonManagement = new JSONManagement();
        List<Cofradia> cofradiasList = null;

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Leer datos desde el fichero de texto y generar objetos.");
            System.out.println("2. Guardar datos en XML.");
            System.out.println("3. Guardar datos en JSON.");
            System.out.println("4. Leer datos desde XML y mostrarlos.");
            System.out.println("5. Leer datos desde JSON y mostrarlos.");
            System.out.println("6. Salir de la aplicación.");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (choice) {
                case 1:
                    txtManagement.Carga("cofradias.txt");
                    cofradiasList = txtManagement.getCofradiaList();
                    if (cofradiasList != null && !cofradiasList.isEmpty()) {
                        System.out.println("Datos leídos desde el fichero de texto.");
                    } else {
                        System.out.println("No se encontraron datos en el archivo TXT.");
                    }
                    break;
                case 2:
                    if (cofradiasList != null && !cofradiasList.isEmpty()) {
                        XMLManagement.MarshallingCofradiasXML marshallingXML = xmlManagement.new MarshallingCofradiasXML();
                        marshallingXML.marshallingCofradiasXML(cofradiasList);
                    } else {
                        System.out.println("No hay datos para guardar en XML.");
                    }
                    break;
                case 3:
                    if (cofradiasList != null && !cofradiasList.isEmpty()) {
                        JSONManagement.MarshallingCofradiasJSON marshallingJSON = jsonManagement.new MarshallingCofradiasJSON();
                        marshallingJSON.marshallingCofradiasJSON(cofradiasList);
                    } else {
                        System.out.println("No hay datos para guardar en JSON.");
                    }
                    break;
                case 4:
                    List<Cofradia> cofradiasFromXML = xmlManagement.unmarshallingCofradiasXML();
                    if (cofradiasFromXML != null && !cofradiasFromXML.isEmpty()) {
                        System.out.println("Datos leídos desde XML:");
                        cofradiasFromXML.forEach(System.out::println);
                    } else {
                        System.out.println("No se encontraron datos en el archivo XML.");
                    }
                    break;
                case 5:
                    List<Cofradia> cofradiasFromJSON = jsonManagement.unmarshallingCofradiasJSON();
                    if (cofradiasFromJSON != null && !cofradiasFromJSON.isEmpty()) {
                        System.out.println("Datos leídos desde JSON:");
                        cofradiasFromJSON.forEach(System.out::println);
                    } else {
                        System.out.println("No se encontraron datos en el archivo JSON.");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo de la aplicación.");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}