package Homework4.Core.MVP;


import java.time.LocalDateTime;
import Homework4.Core.Models.Status;
import Homework4.Core.Models.Priority;

public interface View {
    String getId();
    void setId(String value);
    LocalDateTime getDate();
    void setDate(LocalDateTime value);
    LocalDateTime getDedline(int day);
    void setDedline(LocalDateTime value);
    String getFirstName();
    void setFirstName(String value);
    String getLastName();
    void setLastName(String value);
    String getDescription();
    void setDescription(String value);
    Priority getPriority();
    void setPriority(Priority Status);
    Status getStatus();
    void setStatus(Status Status);


}
