package Task4;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public class DOM {

    public static Document XMLCompose(ArrayList<BabyAList> babies) {
        Document doc = null;

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Babies");
            doc.appendChild(rootElement);

            for (BabyAList Blist : babies) {
                Element ethnicity = doc.createElement("ethnicity");
                Attr attribute = doc.createAttribute("GroupName");
                attribute.setValue(Blist.getEthnicity());
                ethnicity.setAttributeNode(attribute);

                for (Baby baby : Blist.getBabies()) {
                    Element LBaby = doc.createElement("Baby");
                    attribute = doc.createAttribute("Name");
                    attribute.setValue(baby.getName());
                    LBaby.setAttributeNode(attribute);

                    attribute = doc.createAttribute("birthdayDate");
                    attribute.setValue(baby.getBirthdayDate());
                    LBaby.setAttributeNode(attribute);

                    attribute = doc.createAttribute("gender");
                    attribute.setValue(baby.getGender());
                    LBaby.setAttributeNode(attribute);

                    attribute = doc.createAttribute("ethnicity");
                    attribute.setValue(baby.getEthnicity());
                    LBaby.setAttributeNode(attribute);

                    attribute = doc.createAttribute("count");
                    attribute.setValue(baby.getCount());
                    LBaby.setAttributeNode(attribute);

                    attribute = doc.createAttribute("rank");
                    attribute.setValue(baby.getRank());
                    LBaby.setAttributeNode(attribute);

                    ethnicity.appendChild(LBaby);
                }
                rootElement.appendChild(ethnicity);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return doc;
    }

    public static void XMLSave(Document doc, String fileName) {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "Windows-1251");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(fileName.trim()));
        try {
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        System.out.println("File " + fileName.trim() + " saved!");
    }
}