package nextstep.ladder.model;

public class Person {
    private final String name;

    public Person(String name) {
        validate(name);
        this.name = name.trim();
    }

    private void validate(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }
}
