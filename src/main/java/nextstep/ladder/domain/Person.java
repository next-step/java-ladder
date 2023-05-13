package nextstep.ladder.domain;

public class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }
}
