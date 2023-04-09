
public class Main {
    
    public static void main(String[] args) {
        Home<BasePhone> home = new Home<>(new HomePhone("Домашний телефон"), new SmartPhone("Iphone"));
        
        Pouch<NewMobilePhone> pouch = new Pouch<>(new NewMobilePhone("Siemens"));

    }
}
