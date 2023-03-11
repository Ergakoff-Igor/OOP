import java.util.Scanner;

public class Menu {

    Person human = new Person("Игорь");
    Cat cat = new Cat("Кактус");

    public Menu() {

        try (Scanner iSc = new Scanner(System.in)) {
            try {
                System.out.printf("%s зовёт кота. опишите состояние кота:\n", human.getName().toString());
                System.out.println("1 - Кот голоден и бодр");
                System.out.println("2 - Кот голоден и спит");
                System.out.println("3 - Кот не голоден и спит");
                int task = iSc.nextInt();

                switch (task) {
                    case 1:
                        human.callCat();
                        cat.power(task);
                        break;
                    case 2:
                        human.callCat();
                        cat.power(task);
                        break;
                    case 3:
                        human.callCat();
                        cat.power(task);
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
