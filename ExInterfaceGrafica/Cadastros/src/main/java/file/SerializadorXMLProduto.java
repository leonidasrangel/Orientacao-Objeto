package file;

import gerenciador.GerenciadorProduto;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Rangel
 */
public class SerializadorXMLProduto {
    public String ToXML(GerenciadorProduto produtos) {
        try {
            JAXBContext context = JAXBContext.newInstance(GerenciadorProduto.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter writer = new StringWriter();
            marshaller.marshal(produtos, writer);
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public GerenciadorProduto fromXML(String xmlString) {
        try {
            JAXBContext context = JAXBContext.newInstance(GerenciadorProduto.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader reader = new StringReader(xmlString);

            return (GerenciadorProduto) unmarshaller.unmarshal(reader);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
