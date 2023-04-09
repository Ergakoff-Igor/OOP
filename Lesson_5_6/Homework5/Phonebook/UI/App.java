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
        presenter.loadFromFile();

        try (Scanner in = new Scanner(System.in)) {

            while (true) {
                System.out.println("\nНавигация:");
                System.out.println("1 - предыдущий контакт    2 - следующий контакт");
                System.out.println("\nДействия:");
                System.out.println("3 - добавить контакт");
                System.out.println("4 - удалить контакт");
                System.out.println("5 - показать список всех контактов");
                System.out.println("6 - поиск контакта");
                System.out.println("7 - добавить номер");
                System.out.println("0 - выход");
                System.out.printf("Выберите действие: ");
                String key = in.next();
                System.out.print("\033[H\033[J");
                switch (key) {
                    case "1":
                        System.out.print("\033[H\033[J");
                        presenter.prev();
                        break;
                    case "2":
                        System.out.print("\033[H\033[J");
                        presenter.next();
                        break;
                    case "3":
                        System.out.print("\033[H\033[J");
                        presenter.addContact();
                        presenter.saveToFile();
                        break;
                    case "4":
                        System.out.print("\033[H\033[J");
                        presenter.remove();
                        System.out.print("\033[H\033[J");
                        presenter.saveToFile();
                        presenter.loadFromFile();
                        break;
                    case "5":
                        System.out.print("\033[H\033[J");
                        presenter.viewAll();
                        break;
                    case "6":
                        System.out.print("\033[H\033[J");
                        presenter.findContact();
                        break;
                    case "7":
                        System.out.print("\033[H\033[J");
                        presenter.addPhone();
                        presenter.saveToFile();
                        presenter.loadFromFile();
                        break;
                    case "0":
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
