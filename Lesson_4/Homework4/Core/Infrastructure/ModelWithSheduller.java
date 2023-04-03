package Homework4.Core.Infrastructure;

import Homework4.Core.Models.Task;

public interface ModelWithSheduller {
    Task currentTask();
    Task getRecordFromLine(String line);
    Scheduler currentBook();
    int getCurrentIndex();
    void setCurrentIndex(int value);
}
