
import java.util.ArrayList;

public class Cat {

    enum State {
        hungry, sleep, dontSleep
    }

    private static int defaultIndex;
    private static ArrayList<String> names;

    static {
        defaultIndex = 1;
        names = new ArrayList<String>();
    }

    /** Номер Животного */
    private int Number;

    /** Имя животного */
    private String name;
    public State state;

    /**
     * Создание животного
     * 
     * @param name   Имя животного
     * @param Number Номер животного
     */
    private Cat(String name, int Number) {
        if ((name.isEmpty()
                || Character.isDigit(name.charAt(0)))
                || Cat.names.indexOf(name) != -1)

        {
            this.name = String.format("DefaultName_%d", defaultIndex++);
        } else {
            this.name = name;
        }

        Cat.names.add(this.name);
        this.Number = Number;
        this.state = State.dontSleep;

    }

    public Cat(String name) {
        this(name, 1);
    }

    public Cat() {
        this("");
    }

    // Методы состояния живлтного животного
    public void power(int num) {
        if (num == 1) {
            this.RunCat();
            this.state = State.hungry;
            this.CatBawl();
            this.CatEat();
            this.state = State.sleep;
        }if (num == 2) {
            this.state = State.sleep; 
            this.CatSleep();
            this.state = State.dontSleep;
            this.CatAwake();  
            this.RunCat();
            this.state = State.hungry;
            this.CatBawl();
            this.CatEat();
            this.CatSleep();
            this.state = State.sleep;                    
        } else {
            this.state = State.sleep;  
            this.CatSleep();
        }
    }

    /** Кот прибежал */
    public void RunCat() {
        System.out.println("Кот прибежал...");
    }

    /** Кот спит */
    public void CatSleep() {
        System.out.println("Котик спит, он устал");
    }

    public void CatAwake(){
        System.out.println("Кот проснулся");
    }
    /** Кот орёт "Мяу-Мяу" */
    public void CatBawl() {
        System.out.println("Кот орёт 'Мяу-Мяу'");
    }

    /** Кот ест */
    public void CatEat() {
        System.out.println("Кот ест");
    }

    public int getNumber() {
        return this.Number;
    }

    public String getName() {
        return this.name;
    }

    public State getState() {
        return this.state;
    }

    @Override
    public String toString() {
        return String.format("%s %d\n", this.name, this.Number);
    }
}
