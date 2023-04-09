package Homework5.Phonebook.Core.MVP;

import Homework5.Phonebook.Core.Infrastructure.Phones;
import Homework5.Phonebook.Core.Models.Contact;

public class Presenter implements PresenterAdd, PresenterLoad, PresenterNavigator, 
PresenterRemove, PresenterSave , PresenterFindContact, PresenterOutputContacts{

    private Model model;
    private View view;

    public Presenter(View view, String pathDb) {
        this.view = view;
        model = new Model(pathDb);
    }

    @Override
    public void addContact() {
        System.out.println("Добавление контакта:\n");
        model.currentBook().add(
                new Contact(view.getFirstName(), view.getLastName(), view.getСompany(),
                        new Phones().addPhone(view.getPhone())));
    }

    @Override
    public void addPhone() {
        for (int i = 0; i < model.currentBook().count(); i++) {
            if (model.currentBook().getCotact(i).equals(model.currentContact())) {
                model.currentBook().getCotact(i).phones.add(view.getPhone());
                break;
            }             
        }    
    }

    @Override
    public int findContact() {
        System.out.println("Поиск контакта:\n");
        String fname = view.getFirstName();
        String lname = view.getLastName();

        for (int i = 0; i < model.currentBook().count(); i++) {
            if (model.currentBook().getCotact(i).firstName.equals(fname) && model.currentBook().getCotact(i).lastName.equals(lname)) {
                this.outputContact(model.currentBook().getCotact(i));
                break;
            }             
        }
        return model.getCurrentIndex();
    }

    @Override
    public void remove() {
        for (int i = 0; i < model.currentBook().count(); i++) {
            if (model.currentBook().getCotact(i).equals(model.currentContact())) {
                model.currentBook().remove(model.currentBook().getCotact(i));
                break;
            }             
        }
    }

    @Override
    public void saveToFile() {
        model.saveToCSV();
    }

    @Override
    public void loadFromFile() {
        model.loadFromCSV();
    }

    @Override
    public int next() {
        if (model.currentBook().count() > 0) {
            if (model.getCurrentIndex() + 1 < model.currentBook().count()) {
                model.setCurrentIndex(model.getCurrentIndex() + 1);
                this.outputContact(model.currentContact());
            } else {
                System.out.println("Вы просмотрели все контакты. Введите \"1\"");
            }
        }
        return model.getCurrentIndex();
    }

    @Override
    public int prev() {
        if (model.currentBook().count() > 0) {
            if (model.getCurrentIndex() - 1 > -1) {
                model.setCurrentIndex(model.getCurrentIndex() - 1);
                this.outputContact(model.currentContact());
            } else {
                System.out.println("Вы попали в начало списка. Введите \"2\"");
            }
        }
        return model.getCurrentIndex();
    }

    @Override
    public void viewAll() {
        System.out.print("\033[H\033[J");
        for (Contact contact : model.currentBook().getContacts()) {
            view.setContact(contact.firstName, contact.lastName, contact.company, model.phonesAct.phonesToString(contact.phones));
        }
    }

    @Override
    public int outputContact(Contact contact) {
        System.out.print("\033[H\033[J");
        System.out.printf("№: %d из: %d\n", model.getCurrentIndex() + 1, model.currentBook().count());
        view.setFirstName(contact.firstName);
        view.setLastName(contact.lastName);
        view.setСompany(contact.company);
        view.setPhone(model.phonesAct.phonesToString(contact.phones));
        return model.getCurrentIndex();
    }
}
