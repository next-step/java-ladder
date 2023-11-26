package ladder.domain;

public class Member {

    private final Name name;

    public Member(String name) {
        this.name = new Name(name);
    }

    public Name name() {
        return name;
    }
}
