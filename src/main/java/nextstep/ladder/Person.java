package nextstep.ladder;

public class Person {

    private final String name;

    private Person(String name) {
        this.name = name;
    }

    public static Person of(String name) {
        return new Person(name);
    }

    public String getName() {
        return name;
    }
}
