package Task4;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class SearchPopularHandler extends DefaultHandler {
    public SearchPopularHandler() {
    }

    private ArrayList<Baby> children = new ArrayList<>();
    private ArrayList<BabyAList> BabyLists = new ArrayList<>();

    private boolean inRow = false;
    private Baby currentBaby;
    private String currentElement;

    public ArrayList<BabyAList> getBabyLists() {
        return BabyLists;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start Document Processing");
    }

    @Override
    public void endDocument() throws SAXException {
        boolean added = false;
        System.out.println("Finish Document Processing");
        for (Baby baby : children) {
            added = false;
            for (BabyAList aList : BabyLists) {
                if (baby.getEthnicity().equals(aList.getEthnicity())) {
                    aList.add(baby);
                    added = true;
                }
            }
            if (!added) {
                BabyAList newList = new BabyAList(baby.getEthnicity());
                newList.add(baby);
                BabyLists.add(newList);
            }

        }

        System.out.println("\nPopular names:");
        System.out.println(BabyLists);

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("row")) {
            currentBaby = new Baby();
            inRow = true;
        }
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("row") && currentBaby != null) {
            children.add(currentBaby);
        }
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (inRow) {
            String data = new String(ch, start, length).trim();
            switch (currentElement) {
                case "brth_yr":
                    currentBaby.setBirthdayDate(data);
                    break;
                case "gndr":
                    currentBaby.setGender(data);
                    break;
                case "ethcty":
                    currentBaby.setEthnicity(data);
                    break;
                case "nm":
                    currentBaby.setName(data);
                    break;
                case "cnt":
                    currentBaby.setCount(data);
                    break;
                case "rnk":
                    String rnkValue = new String(ch, start, length);
                    if (rnkValue.equals("1")) {
                        currentBaby.setRank(data);
                    } else {
                        currentBaby = null;
                    }
                    break;
            }
        }
    }
}