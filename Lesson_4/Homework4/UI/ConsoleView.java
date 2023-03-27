package Homework4.UI;

import java.util.Scanner;

import Homework4.Core.MVP.View;

public class ConsoleView implements View {
    Scanner in;
    public ConsoleView() {
        in = new Scanner(System.in);
    }

    @Override
    public String getId(){
        System.out.printf("Id: ");
        return in.nextLine();
    }

    @Override
    public void setId(String value) {
        System.out.printf("Id: %s\n", value);
    }

    @Override
    public String getFirstName() {
        System.out.printf("FirstName: ");
        return in.nextLine();
    }

    @Override
    public void setFirstName(String value) {
        System.out.printf("FirstName: %s\n", value);
    }

    @Override
    public String getLastName() {
        System.out.printf("LastName: ");
        return in.nextLine();
    }

    @Override
    public void setLastName(String value) {
        System.out.printf("LastName: %s\n", value);
    }

    @Override
    public String getDescription() {
        System.out.printf("Description: ");
        return in.nextLine();
    }

    @Override
    public void setDescription(String value) {
        System.out.printf("Description: %s\n", value);        
    }
    
}
