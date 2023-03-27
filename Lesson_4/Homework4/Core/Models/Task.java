package Homework4.Core.Models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Task  implements Comparable<Task> {
    public String id;
    public LocalDate date;
    public LocalTime time;
    public LocalDate dedline;
    public String firstName;
    public String lastName;
    public String description;

    public Task(String id, String firstName, String lastName, String description) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
    }
    
    

    @Override
    public int compareTo(Task o) {
        // ???...
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        Task t = (Task)obj;
        return this.id == t.id
                && this.id == t.id
        ;
    }

}
