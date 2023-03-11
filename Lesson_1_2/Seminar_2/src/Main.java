public class Main {
    public static void main(String[] args) {
        Tiger tiger = new Tiger("Вася", 1, "Черно-оранжевый", 10);
        Cat cat = new Cat("Петя", 1, "Черный");
        Fish fish = new Fish("Рыбонька", 1, "Серебристый");

        tiger.voice();
        cat.voice();
        fish.swim();
    }
}
