package laddergame.domain;

public class User {
    private final Name name;

    public User(String name) {
        this.name = new Name(name);
    }

    public Name getName() {
        return name;
    }
}
