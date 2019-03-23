package ladder.domain;

public class Person {
    private static final int MAX = 5;
    private final String name;

    public Person(String name) {
        if (name.length() > MAX) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return beautify();
    }

    private String beautify() {
        return String.format("%" + MAX + "s", name);
    }
}
