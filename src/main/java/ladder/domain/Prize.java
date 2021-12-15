package ladder.domain;

public class Prize {
    private final Name name;

    public Prize(String name) {
        this(new Name(name));
    }

    public Prize(Name name) {
        this.name = name;
    }

    public String getName() {
        return this.name.getName();
    }
}
