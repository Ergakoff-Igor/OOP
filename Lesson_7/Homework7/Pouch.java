public class Pouch<T extends MobilePhone> {
    private T[] phones;

    public Pouch(T... phones) {
        this.phones = phones;
    }

    public T[] getFruits() {
        return phones;
    }
}
