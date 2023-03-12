import java.util.ArrayList;
import java.util.UUID;

public class Animal implements Comparable<Animal> {
    private String name;
    private Integer age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Animal o) {
        return this.getAge() - o.getAge();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        UUID id = UUID.randomUUID();
        if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else return this.getName().equals(((Animal) obj).getName());
    }
}
