package file;

import gerenciador.GerenciadorCarro;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Rangel
 */
public class SerializadorXMLCarro {
    public String ToXML(GerenciadorCarro carros) {
        try {
            JAXBContext context = JAXBContext.newInstance(GerenciadorCarro.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter writer = new StringWriter();
            marshaller.marshal(carros, writer);
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public GerenciadorCarro fromXML(String xmlString) {
        try {
            JAXBContext context = JAXBContext.newInstance(GerenciadorCarro.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader reader = new StringReader(xmlString);

            return (GerenciadorCarro) unmarshaller.unmarshal(reader);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
