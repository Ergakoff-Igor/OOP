import java.util.Scanner;

public class Menu {

    Person human = new Person("Игорь");
    Cat cat = new Cat("Кактус");
    Dog dog = new Dog("Барон");
    String petName;

    public Menu() {
        try (Scanner iSc = new Scanner(System.in)) {
            try {
                System.out.printf("1 - %s\n", cat.getName());
                System.out.printf("2 - %s\n", dog.getName());
                System.out.printf("Укажите номер питомца: ");
                int petNum = iSc.nextInt();
                if (petNum == 1 ) {
                    petName = cat.getName();
                } else if (petNum == 2 ) {
                    petName = dog.getName();
                }
                System.out.printf("%s зовёт %sа. опишите состояние питомца:\n", human.getName().toString(), petName.toString());
                System.out.println("1 - Питомец голоден и бодр");
                System.out.println("2 - Питомец голоден и спит");
                System.out.println("3 - Питомец не голоден и спит");
                int task = iSc.nextInt();

                switch (task) {
                    case 1:
                        
                        human.callPet(this.petName, petNum, task);
                        break;
                    case 2:
                    human.callPet(this.petName, petNum, task);
                        break;
                    case 3:
                    human.callPet(this.petName, petNum, task);
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
