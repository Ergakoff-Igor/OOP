package Homework5.Phonebook.Core.Infrastructure;

import java.util.ArrayList;
import java.util.List;

import Homework5.Phonebook.Core.Models.Contact;

public class Phonebook {

    private List<Contact> contacts;
    
    public Phonebook() {
        contacts = new ArrayList<Contact>();
    }

    // Добавление контакта
    public boolean add(Contact contact) {
        boolean flag = false;
        if (!contacts.contains(contact)) {
            contacts.add(contact);
            flag = true;
        }
        return flag;
    }

    // Вывод контакта
    public Contact getCotact(int index) {
        return contains(index) ? contacts.get(index) : null;
    }

    // Удаление контакта
    public boolean remove(Contact contact) {
        boolean flag = false;
        if (contacts.indexOf(contact) != -1) {
            contacts.remove(contact);
            flag = true;
        }
        return flag;
    }


    private boolean contains(int index) {
        return contacts != null
                && contacts.size() > index;
    }

    public List<Contact> getContacts() {
        return this.contacts;
    }


    public int count() {
        return contacts.size();
    }
}
