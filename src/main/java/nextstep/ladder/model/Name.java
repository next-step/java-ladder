package nextstep.ladder.model;

public class Name {
    private final String value;

    private Name(String name) {
        this.value = name;
    }

    public static Name of(String name) {
        return new Name(name);
    }

    @Override
    public String toString() {
        return this.value;
    }
}
