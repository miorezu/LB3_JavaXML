package Task4;

import Task3.HandlerEthnicity;
import Task3.ParserEthnicity;
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

public class SearchPopularParser {


    public static void parse(String fileName) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            javax.xml.parsers.SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            DefaultHandler handler = new SearchPopularHandler();
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
        SearchPopularParser.parse("Popular_Baby_Names_NY.xml"); 
    }
}