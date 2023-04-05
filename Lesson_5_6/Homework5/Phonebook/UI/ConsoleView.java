package Homework5.Phonebook.UI;

import java.util.Scanner;

import Homework5.Phonebook.Core.MVP.View;

public class ConsoleView implements View {
    Scanner in;
    public ConsoleView() {
        in = new Scanner(System.in, "ibm866");
    }
    @Override
    public String getFirstName() {
        System.out.printf("Имя: ");
        return in.nextLine();
    }

    @Override
    public void setFirstName(String value) {
        System.out.printf("Имя: %s\n", value);
    }

    @Override
    public String getLastName() {
        System.out.printf("Фамилия: ");
        return in.nextLine();
    }

    @Override
    public void setLastName(String value) {
        System.out.printf("Фамилия: %s\n", value);
    }

    @Override
    public String getСompany() {
        System.out.printf("Компания: ");
        return in.nextLine();
    }
    @Override
    public void setСompany(String value) {
        System.out.printf("Компания: %s\n", value); 
    }
    @Override
    public String getPhone() {
        System.out.printf("Телефон: ");
        return in.nextLine();
    }
    @Override
    public void setPhone(String value) {
        System.out.printf("Телефон: %s\n", value); 
    }
    
}
