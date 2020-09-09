package step2.model;

public class Person {
    private final String name;
    private Position position;

    private Person(String name) {
        this.name = name;
    }

    private Person(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static Person valueOf(String inputName) {
        validateNameLength(inputName);
        return new Person(inputName);
    }

    public static Person Of(String inputName, int position) {
        validateNameLength(inputName);
        return new Person(inputName, Position.valueOf(position));
    }

    private static void validateNameLength(String inputName) {
        if (inputName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public String printName() {
        return this.name;
    }

    public Position printCurrentPosition() {
        return position;
    }
}
