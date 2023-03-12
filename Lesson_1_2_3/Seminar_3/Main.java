import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        Animal first = new Animal("Мурзик", 1);
//        Animal second = new Animal("Мурзик", 1);

//        System.out.println(first.equals(second));

        Animal animalSecond = new Animal("Животное_1", 2);
        Animal animalFirst = new Animal("Животное_2", 1);
        Animal animalFourth = new Animal("Животное_3", 2);
        Animal animalThird = new Animal("Животное_4", 3);
//
//        System.out.println(animalFirst.compareTo(animalSecond));
//
//        AnimalAgeComparator animalAgeComparator = new AnimalAgeComparator();
//        System.out.println(animalAgeComparator.compare(animalFirst, animalSecond));
        ArrayList<Animal> list = new ArrayList<>();
//
        list.add(animalSecond);
        list.add(animalThird);
        list.add(animalFirst);
        list.add(animalFourth);


//
//        System.out.println(list);
//
//        Collections.sort(list, new AnimalAgeComparator());
//
//        System.out.println(list);
    }

    /*
    ==
    obj.equals(Object object)

     */
}
