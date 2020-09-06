package step2.model;

public class Person {
    private final String name;

    private Person(String name) {
        this.name = name;
    }

    public static Person valueOf(String inputName) {
        validateNameLength(inputName);
        return new Person(inputName);
    }

    private static void validateNameLength(String inputName) {
        if (inputName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public String printName() {
        return this.name;
    }
}
