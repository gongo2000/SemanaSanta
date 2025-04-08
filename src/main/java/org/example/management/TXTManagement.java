package org.example.management;

import org.example.model.Cofradia;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TXTManagement {
    private List<Cofradia> cofradiaList;

    public TXTManagement(){this.cofradiaList = new ArrayList<Cofradia>();}

    public List<Cofradia> getCofradiaList(){
        return cofradiaList;
    }

//cargamos las cofradias que hay dentro del archivo en el array

    public void Carga (String semanaSanta){
        this.cofradiaList = new ArrayList<>();
        Path ficheroCofradia = Paths.get("D:\\instituto\\2DAM RECUS\\acesso datos\\practica 1\\Cofradia\\cofradias.txt");

        try {
            List<String> lineas = Files.readAllLines(ficheroCofradia);
            int id = 1;
            for (String linea : lineas) {
                linea = linea.trim();
                String[] datos = linea.split(";");
                if (datos.length == 4) {
                    this.cofradiaList.add(new Cofradia(datos[0], Integer.parseInt(datos[1]), Integer.parseInt(datos[2]), datos[3] ));
                }
            }
            // Imprimimos los objetos creados
            for (int i = 0; i < cofradiaList.size();i++){
                System.out.println(cofradiaList.get(i));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}



