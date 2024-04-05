package Task3;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class HandlerEthnicity extends DefaultHandler {
    public HandlerEthnicity() {
    }

    private ArrayList<String> ethnicities = new ArrayList<String>();
    private boolean inEthnicity = false;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start Document Processing");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Finish Document Processing");
        System.out.println("\nAll ethnicities:");
        System.out.println(ethnicities);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("ethcty")) {
            inEthnicity = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (inEthnicity) {
            String str = new String(ch, start, length).trim();
            if (!ethnicities.contains(str)) {
                ethnicities.add(str);
            }
            inEthnicity = false;
        }
    }
}