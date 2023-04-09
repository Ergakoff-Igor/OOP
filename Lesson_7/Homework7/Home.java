public class Home<T extends BasePhone> {
    private T[] phones;

    public Home(T... phones) {
        this.phones = phones;
    }

    public T[] getFruits() {
        return phones;
    }
}
