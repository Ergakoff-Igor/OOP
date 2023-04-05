package Homework5.Phonebook.Core.Models;

public class Contact {
    public String firstName;
    public String lastName;
    public String company;
    public String phone;

    public Contact(String firstName, String lastName, String company, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.phone = phone;
    }
    
    @Override
    public boolean equals(Object obj) {
        Contact t = (Contact)obj;
        return this.firstName == t.firstName
                && this.lastName == t.lastName
        ;
    }

}
