package Task4;

import java.util.ArrayList;
import java.util.Collections;

public class BabyAList extends ArrayList {
    private String ethnicity;

    public String getEthnicity() {
        return ethnicity;
    }

    @Override
    public String toString() {
        return "\n\nBabyAList{" +
                "babies=" + babies + "\n" +
                '}';
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public ArrayList<Baby> getBabies() {
        return babies;
    }

    public void setBabies(ArrayList<Baby> babies) {
        this.babies = babies;
    }

    private ArrayList<Baby> babies = new ArrayList<>();
    public BabyAList(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    @Override
    public int size() {
        return babies.size();
    }

    @Override
    public Object get(int index) {
        return babies.get(index);
    }


    public Object set(int index, Baby element) {
        return babies.set(index, element);
    }


    public boolean add(Baby o) {
        babies.add(o);
        sortBabiesByCount();
        if(babies.size() > 7) {
            babies.remove(babies.size() - 1);
        }
        return true;
    }

    public void sortBabiesByCount() {
        Collections.sort(babies, (baby1, baby2) -> {
            int count1 = Integer.parseInt(baby1.getCount());
            int count2 = Integer.parseInt(baby2.getCount());
            return Integer.compare(count2, count1); // Сортировка по убыванию
        });
    }
    @Override
    public void clear() {
        babies.clear();
    }
}
