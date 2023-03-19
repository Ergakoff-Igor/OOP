import java.util.Comparator;

public class PersonYearComparator implements Comparator<Person>{
    public int compare(Person a, Person b){
      
        if(a.getBirthYear()> b.getBirthYear())
            return 1;
        else if(a.getBirthYear()< b.getBirthYear())
            return -1;
        else
            return 0;
    }
}
