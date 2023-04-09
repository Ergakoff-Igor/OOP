public class MobilePhone extends BasePhone implements SMS{

    public MobilePhone(String name) {
        super(name);
    }
    
    @Override
    public void call() {
        super.call();
    }

    @Override
    public void sendSMS() {
        System.out.println("Отправляем СМС");
    }
}
