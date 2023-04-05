package Homework5.Phonebook.Core.MVP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Homework5.Phonebook.Core.Infrastructure.Phonebook;
import Homework5.Phonebook.Core.Models.Contact;

public class Model {

    Phonebook currentBook;
    Contact contact;
    private int currentIndex;
    private String path;

    public Model(String path) {
        currentBook = new Phonebook();
        currentIndex = 0;
        this.path = path;
    }

    public Contact currentContact() {
        if (currentIndex >= 0) {
            return currentBook.getCotact(currentIndex);
        } else {
            return null;
        }
    }

    public void load() {
        try (Scanner scanner = new Scanner(new File(path));) {
            while (scanner.hasNextLine()) {
                currentBook.add(getRecordFromLine(scanner.nextLine()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Contact getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(", ");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
            rowScanner.close();
            contact = new Contact(values.get(0), values.get(1), values.get(2), values.get(3));
        }
        return contact;
    }

    public void save() {
        try (FileWriter writer = new FileWriter(path, false)) {
            for (int i = 0; i < currentBook.count(); i++) {
                Contact contact = currentBook.getCotact(i);
                writer.append(String.format("%s, ", contact.firstName));
                writer.append(String.format("%s, ", contact.lastName));
                writer.append(String.format("%s, ", contact.company));
                writer.append(String.format("%s\n", contact.phone));
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }



    public Phonebook currentBook() {
        return this.currentBook;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public void setCurrentIndex(int value) {
        this.currentIndex = value;
    }

    public Iterator<Model> iterator() {
        return null;
    }
}