public class SmartPhone extends MobilePhone implements Ethernet{
    
    public SmartPhone(String name) {
        super(name);
    }

    @Override
    public void call() {
        System.out.println("Играет музыка");
    }

    @Override
    public void sendSMS() {
        System.out.println("Отправка картинок");
    }

    @Override
    public void ethernet() {
        System.out.println("Сидим в интернете");
    }


}
