package Homework5.Phonebook.Core.MVP;

import Homework5.Phonebook.Core.Infrastructure.Phonebook;
import Homework5.Phonebook.Core.Models.Contact;

public interface ModelCurrentActions {
    Contact currentContact();
    Phonebook currentBook();
    int getCurrentIndex();
    void setCurrentIndex(int value);
}
