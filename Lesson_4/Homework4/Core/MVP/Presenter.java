package Homework4.Core.MVP;
import Homework4.Core.Models.Task;
public class Presenter {
    
    private Model model;
    private View view;

    public Presenter(View view, String pathDb) {
        this.view = view;
        model = new Model(pathDb);
    }

    public void LoadFromFile() {
        model.load();
        if (model.currentBook().count() > 0) {
            model.setCurrentIndex(0);
            var task = model.currentTask();
            view.setId(task.id);
            view.setFirstName(task.firstName);
            view.setLastName(task.lastName);
            view.setDescription(task.description);
        }
    }

    public void add() {
        model.currentBook().add(
                new Task(view.getId(), view.getFirstName(), view.getLastName(), view.getDescription()));
                System.out.println(model);
    }

    public void remove() {
        Task task = new Task(view.getId(), view.getFirstName(), view.getLastName(), view.getDescription());
        model.currentBook().remove(task);

        if (model.currentBook().count() < 1) {
            model.setCurrentIndex(-1);
            view.setId("");
            view.setFirstName("");
            view.setLastName("");
            view.setDescription("");
        } else {
            model.setCurrentIndex(model.getCurrentIndex() - 1);
            if (model.getCurrentIndex() < 0)
                model.setCurrentIndex(0);
            Task temp = model.currentTask();
            view.setFirstName(temp.id);
            view.setFirstName(temp.firstName);
            view.setLastName(temp.lastName);
            view.setDescription(temp.description);
        }
    }

    public void saveToFile() {
        model.save();
    }

    public void next() {
        if (model.currentBook().count() > 0) {
            if (model.getCurrentIndex() + 1 < model.currentBook().count()) {
                model.setCurrentIndex(model.getCurrentIndex() + 1);
                Task task = model.currentTask();
                view.setId(task.id);
                view.setFirstName(task.firstName);
                view.setLastName(task.lastName);
                view.setDescription(task.description);                
            }
        }
    }

    public void prev() {
        if (model.currentBook().count() > 0) {
            if (model.getCurrentIndex() - 1 > -1) {
                model.setCurrentIndex(model.getCurrentIndex() - 1);
                Task task = model.currentTask();
                view.setId(task.id);
                view.setFirstName(task.firstName);
                view.setLastName(task.lastName);
                view.setDescription(task.description);  
            }
        }
    }
}
