
public class Cat extends Pet implements ActionCat{

public Cat (String name, Sex sex, int age, String color) {
    super(name, sex, age, color);
}

public Cat (String name) {
    super(name);
}

private State state;

    // Методы состояния животного
    @Override
    public void power(int num) {
        if (num == 1) {
            runCat();
            this.state = State.hungry;
            catBawl();
            new Person().feedCat();
            catEat();
            this.state = State.sleep;
        }if (num == 2) {
            this.state = State.sleep; 
            catSleep();
            this.state = State.dontSleep;
            catAwake();  
            runCat();
            this.state = State.hungry;
            catBawl();
            new Person().feedCat();
            catEat();
            catSleep();
            this.state = State.sleep;                    
        } else {
            this.state = State.sleep;  
            this.catSleep();
        }
    }

    /** Кот прибежал */
    @Override
    public void runCat() {
        System.out.println("Кот прибежал...");
    }

    /** Кот спит */
    @Override
    public void catSleep() {
        System.out.println("Котик спит, он устал");
    }

    @Override
    public void catAwake(){
        System.out.println("Кот проснулся");
    }

    /** Кот орёт "Мяу-Мяу" */
    @Override
    public void catBawl() {
        System.out.println("Кот орёт 'Мяу-Мяу'");
    }

    /** Кот ест */
    @Override
    public void catEat() {
        System.out.println("Кот ест");
    }

    @Override
    public String toString() {
        return String.format("%s", getName());
    }
}
