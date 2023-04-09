package Homework5.Phonebook.Core.MVP;

import Homework5.Phonebook.Core.Models.Contact;

public interface ModelImporterCSV {
    void loadFromCSV();
    Contact getRecordFromLine(String line);
}
