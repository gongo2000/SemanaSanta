package org.example.management;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Cofradia;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONManagement {
    public class MarshallingCofradiasJSON {
        public void marshallingCofradiasJSON(List<Cofradia> cofradias) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(new File("cofradias.json"), cofradias);
                System.out.println("Datos guardados correctamente en el archivo JSON.");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Cofradia> unmarshallingCofradiasJSON() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("cofradias.json");
            if (file.exists()) {
                return mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, Cofradia.class));
            } else {
                System.out.println("El archivo cofradias.json no existe.");
                return null;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}