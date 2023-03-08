import java.util.Scanner;

public class Menu {
    Person human = new Person("Игорь");
    HomeFurniture homeFurniture = new HomeFurniture("Шкаф");

    enum State {
        Open, Close
    }

    public Menu() {
        try (Scanner iSc = new Scanner(System.in)) {
            try {
                System.out.printf(
                        "1 - Взять вещи из закрытого шкафа\n2 - Положить вещи в закрытый шкаф \n3 - Взять вещи из открытого шкафа\n4 - Положить вещи в открытый шкаф\n Введите номер действия: ");
                int task = iSc.nextInt();

                switch (task) {
                    case 1:
                        human.OpenFurniture();
                        homeFurniture.power();
                        human.pushFromToWardrobe();
                        human.CloseFurniture();
                        homeFurniture.power();
                        break;
                    case 2:
                        human.OpenFurniture();
                        homeFurniture.power();
                        human.pullToWardrobe();
                        human.CloseFurniture();
                        homeFurniture.power();
                        break;
                    case 3:
                        homeFurniture.power();
                        human.pushFromToWardrobe();
                        human.CloseFurniture();
                        homeFurniture.power();
                        break;
                    case 4:
                        homeFurniture.power();
                        human.pullToWardrobe();
                        human.CloseFurniture();
                        homeFurniture.power();
                        break;
                    default:
                        System.out.println("Некорректный ввод");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Некорректный ввод");
            } finally {
                iSc.close();
            }
        }
    }
}
