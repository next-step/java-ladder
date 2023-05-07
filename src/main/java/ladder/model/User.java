package ladder.model;

public class User {
    private final Name name;

    public User(Name name) {
        this.name = name;
    }

    public User(String name) {
        this.name = new Name(name);
    }

    public Name getName() {
        return this.name;
    }
}
