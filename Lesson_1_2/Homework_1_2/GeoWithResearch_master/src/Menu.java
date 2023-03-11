import java.util.Scanner;

public class Menu {
    public Menu(Person name, GeoTree gt) {
        try (Scanner iSc = new Scanner(System.in)) {
            try {
                System.out.printf("1 - Показать родителей \n2 - Покаазать детей \n3 - Показать братьев и сестер\n Введите номер действия: ");
                int task = iSc.nextInt();

                switch (task) {
                    case 1:
                        System.out.printf("Родители %s -> %s\n", name.getFullName(), new Reserch(gt).spend(name, Relationship.children));
                        break;
                    case 2:
                        System.out.printf("Дети %s -> %s\n", name.getFullName(), new Reserch(gt).spend(name, Relationship.parent));
                        break;
                    case 3:
                        System.out.printf("Братья / сестры %s-> %s\n", name.getFullName(), new Reserch(gt).brotherSister(name));
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
