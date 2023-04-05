package Homework5.Phonebook.UI;

import java.util.Scanner;

import Homework5.Phonebook.Config;
import Homework5.Phonebook.Core.MVP.Presenter;
import Homework5.Phonebook.Core.MVP.View;

public class App {
    public static void ButtonClick() {
        System.out.print("\033[H\033[J");
        View view = new ConsoleView();
        Presenter presenter = new Presenter(view, Config.pathDb);
        presenter.LoadFromFile();

        try (Scanner in = new Scanner(System.in)) {

            while (true) {
                System.out.println("\nНавигация:");
                System.out.println("1 - предыдущий контакт    2 - следующий контакт");
                System.out.println("\nДействия:");
                System.out.println("3 - добавить контакт");
                System.out.println("4 - удалить контакт");
                System.out.println("5 - выход");
                System.out.printf("Выберите действие: ");
                String key = in.next();
                System.out.print("\033[H\033[J");
                switch (key) {
                    case "1":
                        presenter.prev();
                        break;
                    case "2":
                        presenter.next();
                        break;
                    case "3":
                        presenter.add();
                        presenter.saveToFile();
                        break;
                    case "4":
                        presenter.remove(presenter.next());
                        presenter.saveToFile();
                        break;
                    case "5":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Такой команды нет");
                        break;
                }
            }
        }

    }
}
