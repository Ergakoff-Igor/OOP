package Homework4.Core.MVP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Homework4.Core.Infrastructure.Scheduler;
import Homework4.Core.Infrastructure.DateFormater;
import Homework4.Core.Infrastructure.ImportExportCSV;
import Homework4.Core.Infrastructure.ModelWithSheduller;
import Homework4.Core.Infrastructure.ReturnPriority;
import Homework4.Core.Infrastructure.ReturnStatus;
import Homework4.Core.Models.Task;

public class Model implements ImportExportCSV, ModelWithSheduller {

    Scheduler currentBook;
    Task task;
    DateFormater dateFormater;
    private int currentIndex;
    private String path;
    final static DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Model(String path) {
        currentBook = new Scheduler();
        currentIndex = 0;
        dateFormater = new DateFormater();
        this.path = path;
    }

    @Override
    public Task currentTask() {
        if (currentIndex >= 0) {
            return currentBook.getTask(currentIndex);
        } else {
            // ???...
            return null;
        }
    }

    @Override
    public void load() {
        System.out.println("Load");
        try (Scanner scanner = new Scanner(new File(path));) {
            while (scanner.hasNextLine()) {
                currentBook.add(getRecordFromLine(scanner.nextLine()));
            }
            // scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        
    }

    @Override
    public Task getRecordFromLine(String line) {
        System.out.println("getRecordFromLine");
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(", ");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
            // rowScanner.close();
            task = new Task(values.get(0), dateFormater.StringToLocalDateTime(values.get(1)) , dateFormater.StringToLocalDateTime(values.get(3)), values.get(3), values.get(4), values.get(5), new ReturnPriority().SrtingToPriority(values.get(6)), new ReturnStatus().SrtingToStatus(values.get(7)));
        }
        return task;
    }

    @Override
    public void save() {
        try (FileWriter writer = new FileWriter(path, false)) {
            for (int i = 0; i < currentBook.count(); i++) {
                Task task = currentBook.getTask(i);
                writer.append(String.format("%s, ", task.id.toString()));
                writer.append(String.format("%s, ", dateFormater.LocalDateTimeToString(task.date)));
                writer.append(String.format("%s, ", dateFormater.LocalDateTimeToString(task.dedline)));
                writer.append(String.format("%s, ", task.firstName));
                writer.append(String.format("%s, ", task.lastName));
                writer.append(String.format("%s, ", task.description));
                writer.append(String.format("%s, ", task.priority.toString()));
                writer.append(String.format("%s\n", task.status.toString()));
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Scheduler currentBook() {
        return this.currentBook;
    }

    @Override
    public int getCurrentIndex() {
        return this.currentIndex;
    }

    @Override
    public void setCurrentIndex(int value) {
        this.currentIndex = value;
    }

}