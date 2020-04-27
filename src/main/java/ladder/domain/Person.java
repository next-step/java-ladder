package ladder.domain;

public class Person {
    private String name;
    private ResultValue resultValue;

    private Person(String name) {
        this.name = name;
    }

    public static Person getInstanceByName(String name) {
        return new Person(name);
    }

    public String getName() {
        return this.name;
    }
}
