import java.util.ArrayList;
import java.util.TreeSet;

public interface ActionReserch {
    /**
     * Получить родственников person с отношением re
     */
    ArrayList<String> spend(Person person, Relationship re);

    /**
     * Получить братьев и сестер
     */    
    ArrayList<String> brothers_sisters(Person person, Relationship re1, Relationship re2);


    ArrayList<String> grand(Person person);

    TreeSet<Person> allRelatives();
}
