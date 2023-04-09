package Homework5.Phonebook.Core.Infrastructure;

import java.util.List;
import Homework5.Phonebook.Core.Models.Contact;

public interface GetterContacts {
    Contact getCotact(int index);
    List<Contact> getContacts();
    boolean contains(int index);
}
