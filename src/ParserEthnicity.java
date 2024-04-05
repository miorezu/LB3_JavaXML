import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ParserEthnicity {

    public static void parse(String fileName) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            javax.xml.parsers.SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            DefaultHandler handler = new HandlerEthnicity();
            reader.setContentHandler(handler);
            InputStream xmlStream = new FileInputStream(fileName);
            InputSource xmlSource = new InputSource(xmlStream);
            reader.parse(xmlSource);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ParserEthnicity.parse("Popular_Baby_Names_NY.xml");
    }
}