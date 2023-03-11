
public class Person {

    private String name;
    private int age;
    private Sex sex;

    enum Sex {
        man,
        woman
    } 

    public Person(String name, Sex sex, int age) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Person(String name) {
        this.name = name;
    }


    /** Человек зовет кота Кис-кис */
    public void callCat() {
        System.out.printf("%s зовет кота Кис-кис\n", name);
    }

    @Override
    public String toString() {
        return String.format("%s", this.name);
    }
}
