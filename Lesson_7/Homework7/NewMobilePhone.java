public class NewMobilePhone extends MobilePhone{

    public NewMobilePhone(String name) {
        super(name);
    }

    @Override
    public void call() {
        System.out.println("Играет музыка");
    }
    
}
