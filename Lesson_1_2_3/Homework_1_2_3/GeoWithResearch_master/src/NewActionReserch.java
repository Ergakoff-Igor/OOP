import java.util.ArrayList;

public interface NewActionReserch {
        /**
     * Получить супруга
     */
    ArrayList<String> partner(Person person);   
    
    /**
     * Получить умерших родственников
     */
    ArrayList<String> die(Person person); 
}
