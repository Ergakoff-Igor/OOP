
public class Cat extends Pet implements ActionPet, PetEat, PetMoving, PetSay, PetSleeping {

    public Cat(String name, Sex sex, int age, String color) {
        super(name, sex, age, color);
    }

    public Cat(String name) {
        super(name);
    }

    public Cat() {
        super("");
    }    

    private State state;

    // Методы состояния животного
    @Override
    public void power(int num) {
        if (num == 1) {
            runPet();
            this.state = State.hungry;
            petSay();
            new Person().feedPet();
            petEat();
            this.state = State.sleep;
        }
        if (num == 2) {
            this.state = State.sleep;
            petSleep();
            this.state = State.dontSleep;
            petAwake();
            runPet();
            this.state = State.hungry;
            petSay();
            new Person().feedPet();
            petEat();
            petSleep();
            this.state = State.sleep;
        } else {
            this.state = State.sleep;
            petSleep();
        }
    }

    /** Кот прибежал */
    @Override
    public void runPet() {
        System.out.println("Кот прибежал...");
    }

    /** Кот спит */
    @Override
    public void petSleep() {
        System.out.println("Котик спит, он устал");
    }

    @Override
    public void petAwake() {
        System.out.println("Кот проснулся");
    }

    /** Кот орёт "Мяу-Мяу" */
    @Override
    public void petSay() {
        System.out.println("Кот орёт 'Мяу-Мяу'");
    }

    /** Кот ест */
    @Override
    public void petEat() {
        System.out.println("Кот ест");
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("%s", getName());
    }

    
}
