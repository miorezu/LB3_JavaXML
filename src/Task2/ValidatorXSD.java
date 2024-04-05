package Task2;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;


public class ValidatorXSD {
    public static void validate(String xmlFileName, String xsdFileName) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        Schema schema = null;
        try {
            schema = factory.newSchema(new File(xsdFileName));
            javax.xml.validation.Validator validator = schema.newValidator();
            ErrorHandler errorHandler = new MyErrorHandler();
            validator.setErrorHandler(errorHandler);

            Source source = new StreamSource(xmlFileName);
            validator.validate(source);
            System.out.println("The file " + xmlFileName + " is valid");
        } catch (SAXException e) {
            System.out.println("The file " + xmlFileName + " is NOT valid because");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ValidatorXSD.validate("Popular_Baby_Names_NY.xml",
                "Popular_Baby_Names_NY.xsd");
    }
}