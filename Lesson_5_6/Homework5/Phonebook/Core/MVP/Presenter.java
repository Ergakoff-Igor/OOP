package Homework5.Phonebook.Core.MVP;

import Homework5.Phonebook.Core.Models.Contact;

public class Presenter {

    private Model model;
    private View view;

    public Presenter(View view, String pathDb) {
        this.view = view;
        model = new Model(pathDb);
    }

    public int LoadFromFile() {
        model.load();

        if (model.currentBook().count() > 0) {
            model.setCurrentIndex(0);
            Contact contact = model.currentContact();

            System.out.printf("№: %d из: %d\n", model.getCurrentIndex() + 1, model.currentBook().count());
            view.setFirstName(contact.firstName);
            view.setLastName(contact.lastName);
            view.setСompany(contact.company);
            view.setPhone(contact.phone);

        }
        return model.getCurrentIndex();
    }

    public void add() {
        model.currentBook().add(
                new Contact(view.getFirstName(), view.getLastName(), view.getСompany(), view.getPhone()));
    }

    public void remove(int index) {
        if (index == - 1 || index == model.currentBook().count()-1) {
            model.currentBook().remove(model.currentBook().getCotact(index));
        }
        else {
        model.currentBook().remove(model.currentBook().getCotact(index - 1));
        }
    }

    public void saveToFile() {
        model.save();
    }

    public int next() {
        if (model.currentBook().count() > 0) {
            if (model.getCurrentIndex() + 1 < model.currentBook().count()) {
                model.setCurrentIndex(model.getCurrentIndex() + 1);
                Contact contact = model.currentContact();
                System.out.printf("№: %d из: %d\n", model.getCurrentIndex() + 1, model.currentBook().count());
                view.setFirstName(contact.firstName);
                view.setLastName(contact.lastName);
                view.setСompany(contact.company);
                view.setPhone(contact.phone);
            } else {
                System.out.println("Вы просмотрели все контакты. Введите \"1\"");
            }
        }
        return model.getCurrentIndex();
    }

    public int prev() {
        if (model.currentBook().count() > 0) {
            if (model.getCurrentIndex() - 1 > -1) {
                model.setCurrentIndex(model.getCurrentIndex() - 1);
                Contact contact = model.currentContact();
                System.out.printf("№: %d из: %d\n", model.getCurrentIndex() + 1, model.currentBook().count());
                view.setFirstName(contact.firstName);
                view.setLastName(contact.lastName);
                view.setСompany(contact.company);
                view.setPhone(contact.phone);
            } else {
                System.out.println("Вы попали в начало списка. Введите \"2\"");
            }
        }
        return model.getCurrentIndex();
    }

    public void viewAll() {

    }
}
