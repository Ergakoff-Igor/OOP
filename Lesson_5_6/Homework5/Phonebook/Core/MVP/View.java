package Homework5.Phonebook.Core.MVP;

public interface View {
    String getFirstName();
    void setFirstName(String value);
    String getLastName();
    void setLastName(String value);
    String getСompany();
    void setСompany(String value);
    String getPhone();
    void setPhone(String value);   
    void setContact(String fname, String lname, String com, String phone); 
}
