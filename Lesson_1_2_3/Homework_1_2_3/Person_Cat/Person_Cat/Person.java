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
    public void callPet(String petName, int petNum, int task) {

        System.out.printf("%s зовет %sа \n", this.getName(), petName);

        if (petNum == 1) {
            new Cat(petName).power(task);
        } else if (petNum == 2) {
            System.out.printf("%s\n", petName);
            new Dog(petName).power(task);
        }
        
    }

    /** Человек кормит кота */
    @Override
    public void feedPet() {
        System.out.println("насыпаем корм...");
    }    

    @Override
    public String toString() {
        return String.format("%s", getName());
    }    
}
