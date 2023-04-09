package Homework5.Phonebook.Core.MVP;

import Homework5.Phonebook.Core.Models.Contact;

public interface PresenterOutputContacts {
    void viewAll();
    int outputContact(Contact contact);
}
