package Task4;

import org.w3c.dom.*;

public class DOMAnalyser {
    public static void Analyze(Document doc) {
        int num = doc.getDocumentElement().getElementsByTagName("ethnicity").getLength();
        NodeList lstEth = doc.getDocumentElement().getElementsByTagName("ethnicity");
        for (int i = 0; i < num; i++) {
            NamedNodeMap attributes = lstEth.item(i).getAttributes();
            System.out.println("\t" + attributes.item(0).getNodeName() + ": " + attributes.item(0).getNodeValue().trim());
            int babiesNum = lstEth.item(i).getChildNodes().getLength();
            NodeList babies = lstEth.item(i).getChildNodes();

            for (int j = 0; j < babiesNum; j++) {
                attributes = babies.item(j).getAttributes();
                for (int k = 0; k < attributes.getLength(); k++) {
                    Node attr = attributes.item(k);
                    System.out.print("\t" + attr.getNodeName() + ": " + attr.getNodeValue().trim());
                }
                System.out.println();
            }
        }
    }
}