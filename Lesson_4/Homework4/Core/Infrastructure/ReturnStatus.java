package Homework4.Core.Infrastructure;

import Homework4.Core.Models.Status;

public class ReturnStatus {

    public Status SrtingToStatus(String text) {
        if (text.equals("done")) {
            return Status.done;
        } else {
            return Status.inWork;
        }
    }
}
