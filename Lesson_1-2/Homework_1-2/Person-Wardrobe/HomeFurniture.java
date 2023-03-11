
import java.util.ArrayList;


public class HomeFurniture {

    enum State {
        Open, Close
    }

    private static int defaultIndex;
    private static ArrayList<String> names;

    static {
        defaultIndex = 1;
        names = new ArrayList<String>();
    }

    /** Номер шкафа */
    private int Number;

    /** Имя шкафа */
    private String name;
    private State state;

    /**
     * Создание шкафа
     * 
     * @param name  Имя шкафа
     * @param Number Номер шкафа
     */
    private HomeFurniture(String name, int Number) {
        if ((name.isEmpty()
                || Character.isDigit(name.charAt(0)))
                || HomeFurniture.names.indexOf(name) != -1)
        {
            this.name =
             String.format("DefaultName_%d", defaultIndex++);
        } else {
            this.name = name;
        }

        HomeFurniture.names.add(this.name);
        this.Number = Number;
        this.state = State.Close;

    }

    


    public HomeFurniture(String name) {
        this(name, 1);
    }

    public HomeFurniture() {
        this("");
    }

    // Методы открытия/закрытия шкафа
    public void power() {
        if (this.state == State.Close) {
            this.OpenDoor();
            this.state = State.Open;
        } else {
            this.CloseDoor();
            this.state = State.Close;
        }
    }

    /** Открыть шкаф */
    public void OpenDoor() {
        System.out.println("Дверца открыта...");
    }

    /** Закрыть шкаф */
    public void CloseDoor() {
        System.out.println("Дверца закрыта...");
    }
    



    public int getNumber() {
        return this.Number;
    }

    public String getName() {
        return this.name;
    }


    @Override
    public String toString() {
        return String.format("%s %d\n", this.name, this.Number);
    }
}
