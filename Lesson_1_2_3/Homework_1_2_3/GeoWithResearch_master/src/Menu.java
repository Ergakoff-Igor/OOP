import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Menu {
    public Menu(Person name, GeoTree gt) {
        try (Scanner iSc = new Scanner(System.in)) {
            try {
                System.out.printf("1 - Показать родителей %s\n", name.getFullName());
                System.out.printf("2 - Покаазать детей %s\n", name.getFullName());
                System.out.printf("3 - Показать братьев и сестер %s\n", name.getFullName());
                System.out.printf("4 - Показать бабушек и дедушек %s\n", name.getFullName());
                System.out.println("5 - Показать всех членов семьи, и отсортировать по году рождения");
                int task = iSc.nextInt();

                switch (task) {
                    case 1:
                        ArrayList<String> parentSet = new Reserch(gt).spend(name, Relationship.children);
                        if (parentSet.isEmpty()) {
                            System.out.println("Данные отсутствуют");
                        } else {
                            System.out.printf("Родители %s -> %s\n", name.getFullName(), parentSet);
                        }
                        break;
                    case 2:
                        ArrayList<String> childrenSet = new Reserch(gt).spend(name, Relationship.parent);
                        if (childrenSet.isEmpty()) {
                            System.out.println("Данные отсутствуют");
                        } else {
                            System.out.printf("Дети %s -> %s\n", name.getFullName(), childrenSet);
                        }
                        break;
                    case 3:
                        ArrayList<String> brotherSisterSet = new Reserch(gt).brothers_sisters(name, Relationship.parent,
                                Relationship.parent);
                        if (brotherSisterSet.isEmpty()) {
                            System.out.println("Данные отсутствуют");
                        } else {
                            System.out.printf("Братья / сестры %s-> %s\n", name.getFullName(), brotherSisterSet);
                        }
                        break;
                    case 4:
                        ArrayList<String> grandSet = new Reserch(gt).grand(name);
                        if (grandSet.isEmpty()) {
                            System.out.println("Данные отсутствуют");
                        } else {
                            System.out.printf("бабушки / дедушки %s-> %s\n", name.getFullName(), grandSet);
                        }
                        break;
                    case 5:
                        TreeSet<Person> allRelatives = new Reserch(gt).allRelatives();
                        for (Person p : allRelatives) {
                            System.out.printf("Имя: %s, Дата рождения: %d г.\n", p.getFullName(), p.getBirthYear());
                        }
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
