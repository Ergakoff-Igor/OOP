
public class Wardrobe extends HomeFurniture implements StateOfDoor{

    public Wardrobe(String name, String color) {
        super(name, color);
    }

    public Wardrobe(String name) {
        super(name);
    }
    

    /** Имя шкафа */
    private String name;
    private State state;

    /*
     * Методы состояния шкафа
     */
    @Override
    public void openDoor() {
        System.out.println("Дверца открыта...");
        this.state = State.Open;
    }    

    @Override
    public void closeDoor() {
        System.out.println("Дверца закрыта...");
        this.state = State.Close;
    }

    @Override
    public String toString() {
        return String.format("%s", this.name);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
