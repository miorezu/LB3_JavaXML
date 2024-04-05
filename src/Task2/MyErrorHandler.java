package Task2;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class MyErrorHandler implements ErrorHandler {
    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.err.println("Warning:   " + e);
        System.err.println("\tLine = " + e.getLineNumber() + "\tcolumn = " + e.getColumnNumber());
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        System.err.println("Error:   " + e);
        System.err.println("\tLine = " + e.getLineNumber() + "\tcolumn = " + e.getColumnNumber());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.err.println("Fatal Error:   " + e);
        System.err.println("\tLine = " + e.getLineNumber() + "\tcolumn = " + e.getColumnNumber());
        System.exit(-1);
    }
}