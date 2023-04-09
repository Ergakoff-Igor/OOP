package Homework5.Phonebook.Core.MVP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Homework5.Phonebook.Core.Infrastructure.Phonebook;
import Homework5.Phonebook.Core.Models.Contact;
import Homework5.Phonebook.Core.Infrastructure.Phones;

public class Model implements ModelCurrentActions, ModelExporterCSV, ModelImporterCSV{

    Phonebook currentBook;
    Contact contact;
    Phones phonesAct;
    private int currentIndex;
    private String path;

    public Model(String path) {
        currentBook = new Phonebook();
        phonesAct = new Phones();
        currentIndex = 0;
        this.path = path;
    }

    @Override
    public Contact currentContact() {
        if (currentIndex >= 0) {
            return currentBook.getCotact(currentIndex);
        } else {
            return null;
        }
    }

    @Override
    public void loadFromCSV() {
        try (Scanner scanner = new Scanner(new File(path));) {
            while (scanner.hasNextLine()) {
                currentBook.add(getRecordFromLine(scanner.nextLine()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Contact getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(", ");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
            rowScanner.close();
            contact = new Contact(values.get(0), values.get(1), values.get(2), phonesAct.addPhone(values.get(3)));
        }
        return contact;
    }

    @Override
    public void saveToCSV() {
        try (FileWriter writer = new FileWriter(path, false)) {
            for (int i = 0; i < currentBook.count(); i++) {
                Contact contact = currentBook.getCotact(i);
                writer.append(String.format("%s, ", contact.firstName));
                writer.append(String.format("%s, ", contact.lastName));
                writer.append(String.format("%s, ", contact.company));
                writer.append(String.format("%s\n", phonesAct.phonesToString(contact.phones)));
                // writer.append(String.format("%s\n", contact.phones));
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Phonebook currentBook() {
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