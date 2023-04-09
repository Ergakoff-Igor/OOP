public abstract class BasePhone implements Call {
    private String name;

    public BasePhone (String name) {
        this.name = name;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void call() {
        System.out.println("Телефон звонит");
        
    }

    @Override
    public String toString() {
        return this.name;
    }
}
