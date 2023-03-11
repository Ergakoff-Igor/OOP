public abstract class Human {

    private String name;
    private int age;
    private Sex sex;

    public Human(String name, Sex sex, int age) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
