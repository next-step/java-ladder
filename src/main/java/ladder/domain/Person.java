package ladder.domain;

public class Person {
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Person(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return beautify();
    }

    private String beautify() {
        return String.format("%" + (MAX_NAME_LENGTH + 1) + "s", name);
    }
}
