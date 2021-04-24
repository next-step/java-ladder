package ladder.domain;

public class User {
    private Name name;

    public User(String name) {
        this(new Name(name));
    }

    public User(Name name) {
        this.name = name;
    }

    public String name() {
        return this.name.name();
    }
}
