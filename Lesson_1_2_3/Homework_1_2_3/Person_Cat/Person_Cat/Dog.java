public class Dog extends Pet implements ActionPet, PetEat, PetMoving, PetSay, PetSleeping {

    public Dog(String name) {
        super(name);
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
        if (num == 2 || num == 3) {
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
        }
    }

    @Override
    public void runPet() {
        System.out.println("Пес прибежал, помохал хвостом...");
    }

    @Override
    public void petSleep() {
        System.out.println("Пес спит, его сон чуток, он всегда готов действовать!!!");
    }

    @Override
    public void petAwake() {
        System.out.println("Пес проснулся");
    }

    @Override
    public void petSay() {
        System.out.println("Пес говорит 'Гав-Гав'");
    }

    @Override
    public void petEat() {
        System.out.println("Пес ест");
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
