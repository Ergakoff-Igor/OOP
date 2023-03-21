public class Box<T extends Fruit> {
    private T[] fruits;

    public Box(T... fruits) {
        this.fruits = fruits;
    }

    public T[] getFruits() {
        return fruits;
    }
}
