package Homework5.Phonebook.Core.Infrastructure;

import java.util.ArrayList;
import java.util.List;

import Homework5.Phonebook.Core.Models.Contact;

public class Phonebook implements AdderContact, ContactCounter, GetterContacts, RemoverContact{

    private List<Contact> contacts;
    
    public Phonebook() {
        contacts = new ArrayList<Contact>();
    }

    // Добавление контакта
    @Override
    public boolean add(Contact contact) {
        boolean flag = false;
        if (!contacts.contains(contact)) {
            contacts.add(contact);
            flag = true;
        }
        return flag;
    }

    // Вывод контакта
    @Override
    public Contact getCotact(int index) {
        return contains(index) ? contacts.get(index) : null;
    }

    // Удаление контакта
    @Override
    public boolean remove(Contact contact) {
        boolean flag = false;
        if (contacts.indexOf(contact) != -1) {
            contacts.remove(contact);
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean contains (int index) {
        return contacts != null
                && contacts.size() > index;
    }

    @Override
    public List<Contact> getContacts() {
        return this.contacts;
    }

    @Override
    public int count() {
        return contacts.size();
    }
}
