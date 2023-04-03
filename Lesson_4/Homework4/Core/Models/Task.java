package Homework4.Core.Models;



import java.time.LocalDateTime;
;

public class Task  implements Comparable<Task> {
    public String id;
    public LocalDateTime date;
    public LocalDateTime dedline;
    public String firstName;
    public String lastName;
    public String description;
    public Priority priority;
    public Status status;

    public Task(String id, LocalDateTime date, LocalDateTime dedline, String firstName, String lastName, String description, Priority priority, Status status) {
        this.id = id;
        this.date = date;
        this.dedline = dedline;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.priority = priority;
        this.status = status;

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
