
public class Person {

    private String name;
    private int age;
    private Sex sex;

    public Person(String name, Sex sex, int age) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Person(String name) {
        this.name = name;
    }

    HomeFurniture homeFurniture = new HomeFurniture("Шкаф");

    /** Закрыть шкаф */
    public void OpenFurniture() {
        System.out.println("Открываеи шкаф...");
    }

    /** Закрыть шкаф */
    public void CloseFurniture() {
        System.out.println("Закрываем шкаф...");
    }

    /** Работа */
    public void pushFromToWardrobe() {
        System.out.println("Взяли вещи");
    }

    public void pullToWardrobe() {
        System.out.println("Положили вещи");
    }
}
