package ladder.domain;

public class Person {
    private String name;

    private Person(String name) {
        this.name = name;
    }

    public static Person getInstance(String name) {
        return new Person(name);
    }

    public static Person getNewInstance(Person person) {
        return new Person(person.name);
    }

    public static String nameOf(Person person) {
        return person.name;
    }
}
