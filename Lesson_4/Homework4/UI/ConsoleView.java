package Homework4.UI;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Scanner;
import java.util.UUID;

import Homework4.Core.Infrastructure.DateFormater;
import Homework4.Core.MVP.View;
import Homework4.Core.Models.Priority;
import Homework4.Core.Models.Status;


public class ConsoleView implements View {
    public UUID id;
    Scanner in;
    DateFormater dateFormater;

    public ConsoleView() {
        in = new Scanner(System.in, "ibm866");
    }

    @Override
    public String getId() {
        System.out.println("getId");
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    @Override
    public void setId(String value) {
        System.out.println("setId");
        System.out.printf("ID: %s\n", value.toString());
    }

    @Override
    public String getFirstName() {
        System.out.println("getFirstName");
        System.out.printf("Имя: ");
        return in.nextLine();
    }

    @Override
    public void setFirstName(String value) {
        System.out.println("setFirstName");
        System.out.printf("Имя: %s\n", value);
    }

    @Override
    public String getLastName() {
        System.out.println("getLastName");
        System.out.printf("Фамилия: ");
        return in.nextLine();
    }

    @Override
    public void setLastName(String value) {
        System.out.println("setLastName");
        System.out.printf("Фамилия: %s\n", value);
    }

    @Override
    public String getDescription() {    
        System.out.println("getDescription"); 
        System.out.printf("Описание: ");
        return in.nextLine();
    }

    @Override
    public void setDescription(String value) {
        System.out.println("setDescription");
        System.out.printf("Описание: %s\n", value);
    }

    @Override
    public void setDate(LocalDateTime value) {
        System.out.println("setDate");
        System.out.printf("Дата создания задачи: %s\n", dateFormater.LocalDateTimeToString(value));
    }

    @Override
    public LocalDateTime getDate() {
        System.out.println("getDate");
        LocalDateTime date = LocalDateTime.now();
        return date;
    }

    @Override
    public void setDedline(LocalDateTime value) {
        System.out.println("setDedline");
        System.out.printf("Дедлайн: %s\n", dateFormater.LocalDateTimeToString(value));
    }

    @Override
    public LocalDateTime getDedline(int day) {
        System.out.println("getDedline");
        LocalDateTime dedline = LocalDateTime.now();
        // LocalDateTime dedline = LocalDateTime.from(date.toInstant(null).atZone(ZoneId.of("UTC"))).plusDays(3);

        return dedline;
    }

    @Override
    public void setPriority(Priority value) {
        System.out.println("setPriority");
        if (value.equals(Priority.high)) {
            System.out.println("Уровень приоритета: Немедленное выполнение");
        } else if (value.equals(Priority.normal)) {
            System.out.println("Уровень приоритета: Обычный приоритет");
        } else if (value.equals(Priority.low)) {
            System.out.println("Уровень приоритета: Низкий приоритет");
        }
    }

    @Override
    public Priority getPriority() {     
        System.out.println("getPriority");
        System.out.println("1 - Немедленное выполнение");
        System.out.println("2 - Обычный приоритет");
        System.out.println("3 - Низкий приоритет");
        System.out.println("Введите номер приоритета: ");
        int priority = in.nextInt();

        while (true) {
            switch (priority) {
                case 1:
                System.out.println("Priority.high");
                    return Priority.high;
                case 2:
                System.out.println("Priority.normal");
                    return Priority.normal;
                case 3:
                System.out.println("Priority.low");
                    return Priority.low;
                default:
                System.out.println("Priority.normal");
                    return Priority.normal;
            }
        }
    }

    @Override
    public void setStatus(Status value) {
        System.out.println("setStatus");
        if (value.equals(Status.inWork)) {
            System.out.println("Status: В работе");
        } else if (value.equals(Status.done)) {
            System.out.println("Status: Выполнено");
        }
    }

    @Override
    public Status getStatus() {  
        System.out.println("getStatus");      
        System.out.println("1 - В работе");
        System.out.println("2 - Выполнено");
        System.out.println("Введите статус выполнения: ");
        int status = in.nextInt();

        while (true) {
            switch (status) {
                case 1:
                    return Status.inWork;
                case 2:
                    return Status.done;
                default:
                    return Status.inWork;
            }
        }
    }

   

}
