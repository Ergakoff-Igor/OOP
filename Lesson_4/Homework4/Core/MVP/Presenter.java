package Homework4.Core.MVP;
import Homework4.Core.Models.HighPriorityTask;
import Homework4.Core.Models.LowPriorityTask;
import Homework4.Core.Models.NormalPriorityTask;
import Homework4.Core.Models.Priority;
import Homework4.Core.Models.Task;
public class Presenter {
    
    private Model model;
    private View view;

    public Presenter(View view, String pathDb) {
        this.view = view;
        model = new Model(pathDb);
    }

    public void LoadFromFile() {
        System.out.println("LoadFromFile");
        model.load();
        if (model.currentBook().count() > 0) {
            model.setCurrentIndex(0);
            Task task = model.currentTask();
            view.setId(task.id);
            view.setDate(task.date);
            view.setDedline(task.dedline);
            view.setFirstName(task.firstName);
            view.setLastName(task.lastName);
            view.setDescription(task.description);
            view.setPriority(task.priority);
            view.setStatus(task.status);
        }
    }

    public void add(Priority priority) {
        if (priority.equals(Priority.high)){
            System.out.println("add HighPriorityTask");
            model.currentBook().add(
                new HighPriorityTask (view.getId(), view.getDate(), view.getDedline(0), view.getFirstName(), view.getLastName(), view.getDescription(), priority, view.getStatus()));
                this.saveToFile();         
        } else if (priority.equals(Priority.low)){
            System.out.println("add LowPriorityTask");
            model.currentBook().add(
                new LowPriorityTask (view.getId(), view.getDate(), view.getDedline(7), view.getFirstName(), view.getLastName(), view.getDescription(), priority, view.getStatus()));
                this.saveToFile();          
        } else {
            System.out.println("add NormalPriorityTask");
            model.currentBook().add(
                new NormalPriorityTask (view.getId(), view.getDate(), view.getDedline(3), view.getFirstName(), view.getLastName(), view.getDescription(), Priority.normal, view.getStatus()));
                this.saveToFile();  
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
                view.setDate(task.date);
                view.setDedline(task.dedline);
                view.setFirstName(task.firstName);
                view.setLastName(task.lastName);
                view.setDescription(task.description);
                view.setPriority(task.priority);
                view.setStatus(task.status);              
            }
        }
    }

    public void prev() {
        if (model.currentBook().count() > 0) {
            if (model.getCurrentIndex() - 1 > -1) {
                model.setCurrentIndex(model.getCurrentIndex() - 1);
                Task task = model.currentTask();
                view.setId(task.id);
                view.setDate(task.date);
                view.setDedline(task.dedline);
                view.setFirstName(task.firstName);
                view.setLastName(task.lastName);
                view.setDescription(task.description);
                view.setPriority(task.priority);
                view.setStatus(task.status);
            }
        }
    }
}
