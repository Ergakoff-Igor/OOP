public class Cat extends Animal implements Say, Eatable{

    public Cat(String name, int age, String color) {
        super(name, age, color);
    }


    @Override
    public void voice() {
        System.out.println("Кошка мяукает");
    }

    @Override
    public void eat() {
        System.out.println("Кошка ест");
    }
}
