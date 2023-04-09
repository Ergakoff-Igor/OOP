package Homework5.Phonebook.Core.Infrastructure;

import java.util.ArrayList;
import java.util.Scanner;

public class Phones implements PhonesAction{

     @Override
    public ArrayList<String> addPhone(String line) {
        ArrayList<String> phones = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(" ");
            while (rowScanner.hasNext()) {
                phones.add(rowScanner.next());
            }
            rowScanner.close();
        }
        return phones;

        // ArrayList<String> phones = new ArrayList<>();
        // phones.add(phone);
        // return phones;
    }

    @Override
    public String phonesToString(ArrayList<String> phones) {
        StringBuilder builder = new StringBuilder();
        for(String phone : phones) {
            builder.append(phone + " ");
        }
        String str = builder.toString();
        return str;
    }
}
