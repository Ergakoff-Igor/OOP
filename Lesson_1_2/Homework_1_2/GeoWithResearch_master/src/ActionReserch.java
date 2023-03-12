import java.util.ArrayList;

public interface ActionReserch {
    /**
     * Получить родственников person с отношением re
     */
    ArrayList<String> spend(Person person, Relationship re);

    /**
     * Получить братьев и сестер
     */    
    ArrayList<String> brotherSister(Person person);

    /**
     * Получить бабушек и дедушек
     */
    ArrayList<String> grand(Person person);

}
