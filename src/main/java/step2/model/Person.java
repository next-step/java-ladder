package step2.model;

public class Person {
    private final String name;

    public Person(String inputName) {
        validateNameLength(inputName);
        this.name = inputName;
    }

    private void validateNameLength(String inputName) {
        if (inputName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public String printName() {
        return this.name;
    }
}
