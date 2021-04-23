package step2.domain;

public class Product {

    private final String value;

    public Product(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof String) {
            return value.equals(obj);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
