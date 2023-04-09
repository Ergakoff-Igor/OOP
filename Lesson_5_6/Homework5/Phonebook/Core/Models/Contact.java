package Homework5.Phonebook.Core.Models;

import java.util.ArrayList;

public class Contact {
    public String firstName;
    public String lastName;
    public String company;
    public ArrayList<String> phones;

    public Contact(String firstName, String lastName, String company, ArrayList<String> phones) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.phones = phones;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else
            return (this.firstName.equals(((Contact) obj).firstName)
                    && this.lastName.equals(((Contact) obj).lastName));
    }
}
