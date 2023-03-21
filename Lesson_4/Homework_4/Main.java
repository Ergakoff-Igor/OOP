
import java.util.ArrayList;

import java.util.List;

public class Main {
    public static void main(String[] args) {

//        Arrays<Double> arrays = new Arrays<>(1.0,2.0,3.0,4.0);
//        System.out.println(arrays.avg());
//
//        Arrays<Integer> anotherArrays = new Arrays<>(1,2,3,4);
//        System.out.println(arrays.sameAvg(anotherArrays));

        Box<Apple> appleBox = new Box<>(new Apple(1.0),new Apple(2.0),new Apple(3.0),
                new Apple(4.0));
        Box<Orange> orangeBox = new Box<>(new Orange(2.5));

        Box<Fruit> fruitBox = new Box<>(new Apple(1.3), new Orange(7.2));

        // ----------------------------------------

        List<Fruit> fruitList = new ArrayList<>();

        List<Apple> appleList = new ArrayList<>();

        List<Orange> orangeList = new ArrayList<>();

//        appleList.add(new Orange(1.0));

//        orangeList.add(new Fruit(2.3));

        fruitList.add(new Apple(1.1));


    }
}
