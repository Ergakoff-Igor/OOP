public class Person extends Human implements ActionPeople{

    public Person (String name, Sex sex, int age) {
        super(name, sex, age);
    }


    public Person(String name) {
        super(name);
    }

    public Person() {
        super("");
    }

    /** Человек зовет кота Кис-кис */
    @Override
    public void callCat() {
        System.out.printf("%s зовет кота Кис-кис\n", getName());
    }

    /** Человек кормит кота */
    @Override
    public void feedCat() {
        System.out.println("насыпаем корм...");
    }    

    @Override
    public String toString() {
        return String.format("%s", getName());
    }    
}
