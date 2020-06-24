package nextstep.step2;

public class Person {

    private final String name;

    public static Person of(String name) {
        return new Person(name);
    }

    private Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
