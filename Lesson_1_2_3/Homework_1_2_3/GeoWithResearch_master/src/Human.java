public abstract class Human {

    private String fullName;
    private int age;
    private Sex sex;

    public Human(String fullName, Sex sex, int age) {
        this.fullName = fullName;
        this.age = age;
        this.sex = sex;
    }

    public Human(String fullName) {
        this.fullName = fullName;
    }

    public Human() {
        this("");
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
