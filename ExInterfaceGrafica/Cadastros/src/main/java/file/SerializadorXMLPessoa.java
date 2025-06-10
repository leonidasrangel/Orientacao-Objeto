package file;

import gerenciador.GerenciadorPessoa;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Rangel
 */
public class SerializadorXMLPessoa {
    public String ToXML(GerenciadorPessoa pessoas) {
        try {
            JAXBContext context = JAXBContext.newInstance(GerenciadorPessoa.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter writer = new StringWriter();
            marshaller.marshal(pessoas, writer);
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public GerenciadorPessoa fromXML(String xmlString) {
        try {
            JAXBContext context = JAXBContext.newInstance(GerenciadorPessoa.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader reader = new StringReader(xmlString);

            return (GerenciadorPessoa) unmarshaller.unmarshal(reader);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
