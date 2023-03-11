
public class Person extends Human implements OpenCloseFurniture, Work {

    public Person(String name, Sex sex, int age) {
        super(name, sex, age);
    }


    public Person(String name) {
        super(name);
    }

    Wardrobe homeFurniture = new Wardrobe("Шкаф");

    /** Закрыть шкаф */
    @Override
    public void openFurniture() {
        System.out.println("Открываеи шкаф...");
    }

    /** Закрыть шкаф */
    @Override
    public void closeFurniture() {
        System.out.println("Закрываем шкаф...");
    }

    // Методы открытия/закрытия шкафа
    @Override
    public void powerFurniture() {
        if (homeFurniture.getState() == homeFurniture.getState().Close) {
            homeFurniture.openDoor();
            homeFurniture.setState(homeFurniture.getState().Open);
        } else {
            homeFurniture.closeDoor();
            homeFurniture.setState(homeFurniture.getState().Close);
        }
    }


    /** Достать вещи */
    @Override
    public void pushFromToWardrobe() {
        System.out.println("Взяли вещи");
    }


    /** Положить вещи */
    @Override
    public void pullToWardrobe() {
        System.out.println("Положили вещи");
    }



}
