package Task1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class SAXHandler extends DefaultHandler {
    private int indent = 0;
    private int maxRows;
    private int count = 0;

    public SAXHandler(int maxRows) {
        this.maxRows = maxRows + 2;
        this.count = 0;
    }

    public SAXHandler() {
    }

    private ArrayList<String> qNamesDoc = new ArrayList<String>();

    private void printIndent(int indentSize) {
        for (int s = 0; s < indentSize; s++) {
            System.out.print(" ");
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start Document Processing");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Finish Document Processing");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("row")) {
            count++;
        }
        if (count < maxRows) {
            indent = indent + 4;
            printIndent(indent);
            System.out.println("Start Element (" + qName + ") processing");
            if (qName.equals("row")) {
                if (attributes.getLength() > 0) {
                    printIndent(indent + 4);
                    System.out.println("Attributes: ");
                    for (int i = 0; i < attributes.getLength(); i++) {
                        printIndent(indent + 8);
                        System.out.println(attributes.getQName(i).trim() + " = " + attributes.getValue(i).trim());
                    }
                }
            }
            if (!qNamesDoc.contains(qName)) {
                qNamesDoc.add(qName);
            }
        } else {
            System.out.println("List of all tags:" + qNamesDoc);
            System.exit(0);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        printIndent(indent);
        System.out.println("Stop Element (" + qName + ") processing");
        indent = indent - 4;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch, start, length).trim();
        if (str.length() > 0) {
            printIndent(indent + 4);
            System.out.println(str);
        }
    }
}