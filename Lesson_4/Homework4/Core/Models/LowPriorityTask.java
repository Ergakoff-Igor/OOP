package Homework4.Core.Models;

import java.time.LocalDateTime;


public class LowPriorityTask extends Task{

    public LowPriorityTask(String id, LocalDateTime date, LocalDateTime dedline, String firstName, String lastName,
            String description, Priority priority, Status status) {
        super(id, date, dedline, firstName, lastName, description, priority, status);
    }
    
}
