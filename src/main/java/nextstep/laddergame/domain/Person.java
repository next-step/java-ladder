package nextstep.laddergame.domain;

public class Person {
    private Name name;
    private int sequence;
    private String result;

    private Person(String name) {
        this.name = Name.create(name);
    }

    public Person(String name, int sequence) {
        this.name = Name.create(name);
        this.sequence = sequence;
    }

    public static Person from(String name) {
        return new Person(name);
    }

    public static Person of(String name, int sequence) {
        return new Person(name, sequence);
    }

    public String getName() {
        return this.name.getName();
    }
}
