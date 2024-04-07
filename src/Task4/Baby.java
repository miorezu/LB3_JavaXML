package Task4;

public class Baby {
    private String name;
    private String birthdayDate;
    private String gender;
    private String ethnicity;
    private String count;
    private String rank;

    public Baby(String name, String birthdayDate, String gender, String ethnicity, String count, String rank) {
        this.name = name;
        this.birthdayDate = birthdayDate;
        this.gender = gender;
        this.ethnicity = ethnicity;
        this.count = count;
        this.rank = rank;
    }
    public Baby() {
    }

    @Override
    public String toString() {
        return "\nBaby{" +
                "name='" + name + '\'' +
                ", birthdayDate='" + birthdayDate + '\'' +
                ", gender='" + gender + '\'' +
                ", ethnicity='" + ethnicity + '\'' +
                ", count='" + count + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(String birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }


}
