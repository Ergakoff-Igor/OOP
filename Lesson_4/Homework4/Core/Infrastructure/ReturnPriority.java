package Homework4.Core.Infrastructure;

import Homework4.Core.Models.Priority;

public class ReturnPriority {

    public Priority SrtingToPriority(String text) {
        if (text.equals("high")) {
            return Priority.high;
        } else if (text.equals("normal")) {
            return Priority.normal;
        } else {
            return Priority.low;
        }
    }
}
