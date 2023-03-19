
public class Main {
    public static void main(String[] args) {
        Person irina = new Person("Ирина", Sex.woman, 1963);
        Person vasya = new Person("Вася", Sex.man, 1992);
        Person masha = new Person("Маша", Sex.woman, 1992);
        Person jane = new Person("Женя", Sex.woman, 2020);
        Person ivan = new Person("Ваня", Sex.man, 2012);
        GeoTree gt = new GeoTree();
        gt.append(irina, vasya);
        gt.append(irina, masha);
        gt.append(vasya, jane);
        gt.append(vasya, ivan);
        
        new Menu(ivan, gt);
    }

}
