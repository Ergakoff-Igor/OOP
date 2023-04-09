package Homework5.Phonebook.Core.Infrastructure;

import java.util.ArrayList;

public interface PhonesAction {
    ArrayList<String> addPhone(String phone);
    String phonesToString (ArrayList<String> phones);
}
