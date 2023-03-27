package Homework4.Core.Infrastructure;

import java.util.ArrayList;
import java.util.List;

import Homework4.Core.Models.Task;

public class Scheduler {

    private List<Task> tasks;
    
    public Scheduler() {
        tasks = new ArrayList<Task>();
    }

    // create
    public boolean add(Task task) {
        boolean flag = false;
        if (!tasks.contains(task)) {
            tasks.add(task);
            flag = true;
        }
        return flag;
    }

    // read
    public Task getTask(int index) {
        return contains(index) ? tasks.get(index) : null;
    }

    // update
    // ???...

    // delete
    public boolean remove(Task task) {
        boolean flag = false;
        if (tasks.indexOf(task) != -1) {
            tasks.remove(task);
            flag = true;
        }
        return flag;
    }


    private boolean contains(int index) {
        return tasks != null
                && tasks.size() > index;
    }

    public List<Task> gettasks() {
        // if ???...
        return tasks;
    }


    public int count() {
        return tasks.size();
    }


}
