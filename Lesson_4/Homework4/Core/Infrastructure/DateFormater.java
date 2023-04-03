package Homework4.Core.Infrastructure;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormater {

    final static DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public String LocalDateTimeToString(LocalDateTime date) {
        
        String formattedString = date.format(CUSTOM_FORMATTER);
        return formattedString;
    }

    public LocalDateTime StringToLocalDateTime(String text) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime dateTime = LocalDateTime.parse(text, formatter);
        return dateTime;
    }

}
