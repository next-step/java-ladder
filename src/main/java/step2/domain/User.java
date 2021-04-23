package step2.domain;

public class User {

    private final Name name;

    public User(Name name) {
        this.name = name;
    }

    public User(String name) {
        this.name = new Name(name);
    }

    public Name name() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            return name.equals(((User) obj).name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
