/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import gerenciador.GerenciadorImovel;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Rangel
 */
public class SerializadorXMLImovel {
     public String ToXML(GerenciadorImovel imoveis) {
        try {
            JAXBContext context = JAXBContext.newInstance(GerenciadorImovel.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter writer = new StringWriter();
            marshaller.marshal(imoveis, writer);
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public GerenciadorImovel fromXML(String xmlString) {
        try {
            JAXBContext context = JAXBContext.newInstance(GerenciadorImovel.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader reader = new StringReader(xmlString);

            return (GerenciadorImovel) unmarshaller.unmarshal(reader);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
