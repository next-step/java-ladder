package nextstep.ladder.domain;

public class Person {

    private final Name name;

    public Person(String name) {
        this.name = new Name(name);
    }

    @Override
    public String toString() {
        return name + "     ";
    }
}
