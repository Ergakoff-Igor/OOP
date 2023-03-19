public class Person {

    private String fullName;
    private int birthYear;
    private Sex sex;

    public Person(String fullName, Sex sex, int year) {
        this.fullName = fullName;
        this.birthYear = year;
        this.sex = sex;
    }

    public Person(String fullName) {
        this.fullName = fullName;
    }

    public Person() {
        this("");
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    
}
