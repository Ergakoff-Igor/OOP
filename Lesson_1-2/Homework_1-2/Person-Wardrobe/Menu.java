import java.util.Scanner;

public class Menu {
    Person human = new Person("Игорь");
    Wardrobe homeFurniture = new Wardrobe("Шкаф");

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
                        human.openFurniture();
                        human.powerFurniture();
                        human.pushFromToWardrobe();
                        human.closeFurniture();
                        human.powerFurniture();
                        break;
                    case 2:
                        human.openFurniture();
                        human.powerFurniture();
                        human.pullToWardrobe();
                        human.closeFurniture();
                        human.powerFurniture();
                        break;
                    case 3:
                        human.powerFurniture();     
                        human.pushFromToWardrobe();
                        human.closeFurniture();
                        human.powerFurniture();
                        break;
                    case 4:
                        human.powerFurniture();
                        human.pullToWardrobe();
                        human.closeFurniture();
                        human.powerFurniture();
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
