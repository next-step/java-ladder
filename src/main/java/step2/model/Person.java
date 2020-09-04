package step2.model;

public class Person {
    private final String name;

    public Person(String inputName) {
        if (inputName.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = inputName;
    }

    public String printName() {
        return this.name;
    }
}
