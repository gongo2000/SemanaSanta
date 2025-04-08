package org.example.management;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.model.Cofradia;
import org.example.model.SemanaSanta;

import javax.xml.bind.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLManagement {
    public class MarshallingCofradiasXML {
        public void marshallingCofradiasXML(List<Cofradia> cofradiasList) {
            try {
                JAXBContext context = JAXBContext.newInstance(SemanaSanta.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

               SemanaSanta semanaSanta = new SemanaSanta();
                semanaSanta.setSemanaSanta(cofradiasList);

                marshaller.marshal(semanaSanta, new File("cofradias.xml"));

                System.out.println("Archivo XML creado o actualizado y datos escritos correctamente.");
            } catch (JAXBException e) {
                e.printStackTrace();
                System.out.println("Error al crear o actualizar el archivo XML: " + e.getMessage());
            }
        }
    }

    public List<Cofradia> unmarshallingCofradiasXML() {
        List<Cofradia> cofradiasList = new ArrayList<>();
        try {
            JAXBContext context = JAXBContext.newInstance(SemanaSanta.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            File file = new File("cofradias.xml");
            if (file.exists()) {
                SemanaSanta semanaSanta = (SemanaSanta) unmarshaller.unmarshal(file);
                return semanaSanta.getSemanaSanta();
            } else {
                System.out.println("El archivo cofradias.xml no existe.");
                return null;
            }
        } catch (JAXBException e) {
            System.out.println("Error al leer el archivo XML: " + e.getMessage());
            return null;
        }
    }
}