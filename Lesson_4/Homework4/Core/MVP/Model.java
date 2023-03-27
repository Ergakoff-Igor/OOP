package Homework4.Core.MVP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Homework4.Core.Infrastructure.Scheduler;
import Homework4.Core.Models.Task;

public class Model {

    Scheduler currentBook;
    Task task;
    private int currentIndex;
    private String path;

    public Model(String path) {
        currentBook = new Scheduler();
        currentIndex = 0;
        this.path = path;
    }

    public Task currentTask() {
        if (currentIndex >= 0) {
            return currentBook.getTask(currentIndex);
        } else {
            // ???...
            return null;
        }
    }

    public void load() {
        try (Scanner scanner = new Scanner(new File(path));) {
            while (scanner.hasNextLine()) {
                currentBook.add(getRecordFromLine(scanner.nextLine()));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }

    private Task getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(", ");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
            task = new Task(values.get(0), values.get(1), values.get(2), values.get(3));
        }
        return task;

        // try {
        // File file = new File(path);
        // FileReader fr = new FileReader(file);
        // BufferedReader reader = new BufferedReader(fr);
        // String id = reader.readLine();
        // while (id != null) {
        // String fname = reader.readLine();
        // String lname = reader.readLine();
        // String description = reader.readLine();
        // this.currentBook.add(new Task(id, fname, lname, description));
        // id = reader.readLine();
        // }
        // reader.close();
        // fr.close();
        // for (int i = 0; i < currentBook.count(); i++) {
        // Task contact = currentBook.getTask(i);
        // System.out.printf("%s %s %s %s\n",contact.id, contact.firstName,
        // contact.lastName, contact.description);
        // }

        // } catch (Exception e) {
        // e.printStackTrace();
        // }
    }

    public void save() {
        try (FileWriter writer = new FileWriter(path, false)) {
            for (int i = 0; i < currentBook.count(); i++) {
                Task task = currentBook.getTask(i);
                writer.append(String.format("%s, ", task.id));
                writer.append(String.format("%s, ", task.firstName));
                writer.append(String.format("%s, ", task.lastName));
                writer.append(String.format("%s\n", task.description));
            }
            // for (int i = 0; i < currentBook.count(); i++) {
            // Task contact = currentBook.getTask(i);
            // writer.append(String.format("%s\n", contact.id));
            // writer.append(String.format("%s\n", contact.firstName));
            // writer.append(String.format("%s\n", contact.lastName));
            // writer.append(String.format("%s\n", contact.description));
            // }
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // public static void main(String[] args) throws IOException {
    // String[][] employees = {
    // {"Man", "Sparkes", "msparkes0@springhow.com", "Engineering"},
    // {"Dulcinea", "Terzi", "dterzi1@springhow.com", "Engineering"},
    // {"Tamar", "Bedder", "tbedder2@springhow.com", "Legal"},
    // {"Vance", "Scouller", "vscouller3@springhow.com", "Sales"},
    // {"Gran", "Jagoe", "gjagoe4@springhow.com", "Business Development"}
    // };

    // File csvFile = new File("employees.csv");
    // FileWriter fileWriter = new FileWriter(csvFile);

    // //write header line here if you need.

    // for (String[] data : employees) {
    // StringBuilder line = new StringBuilder();
    // for (int i = 0; i < data.length; i++) {
    // line.append("\"");
    // line.append(data[i].replaceAll("\"","\"\""));
    // line.append("\"");
    // if (i != data.length - 1) {
    // line.append(',');
    // }
    // }
    // line.append("\n");
    // fileWriter.write(line.toString());
    // }
    // fileWriter.close();
    // }
    public Scheduler currentBook() {
        return this.currentBook;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public void setCurrentIndex(int value) {
        this.currentIndex = value;
    }
}