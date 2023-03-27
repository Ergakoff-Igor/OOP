package Homework4.UI;

import java.util.Scanner;

import Homework4.Config;
import Homework4.Core.MVP.Presenter;
import Homework4.Core.MVP.View;

public class App {
    public static void ButtonClick() {
        System.out.print("\033[H\033[J");
        View view = new ConsoleView();
        Presenter presenter = new Presenter(view, Config.pathDb);


        try (Scanner in = new Scanner(System.in)) {
            try {
            while (true) {
                System.out.println("1 - Предыдущая запись \n2 - Следующая запись \n3 - Добавить задачу \n4 - Показать все задачи");
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
                        presenter.LoadFromFile();
                        break;
                    default:
                        System.out.println("Такой команды нет");
                        break;
                }
                
            }
        } catch (Exception e) {
            System.out.println("Некорректный ввод");
        } finally {
            in.close();
        }
        }
    }
}
