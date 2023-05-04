package ladder.model;

public class Name {
    private static final int MAX_LENGTH = 5;
    private final String value;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value == null || value.length() == 0) {
            throw new IllegalArgumentException("name is null or empty: " + value);
        }
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("the length of name must be <= " + MAX_LENGTH);
        }
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
