public class Tiger extends Animal implements Eatable{
    private int weight;

    public Tiger(String name, int age, String color, int weight) {
        super(name, age, color);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    @Override
    public void voice() {
        System.out.println("Тигр рычит");
    }

    @Override
    public void eat() {
        System.out.println("Тигер ест");
    }
}
