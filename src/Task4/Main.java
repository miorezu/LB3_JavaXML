package Task4;

import org.w3c.dom.Document;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<BabyAList> babies = SearchPopularParser.parse("Popular_Baby_Names_NY.xml");
        Document doc = DOM.XMLCompose(babies);
        DOM.XMLSave(doc, "Babies_DOM.xml");
        System.out.println("\nInformation out with DOM\n");
        DOMAnalyser.Analyze(doc);
    }
}