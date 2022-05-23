package nextstep.ladder.domain;

public class Member {
    private final Name name;

    public Member(String name) {
        this.name = new Name(name);
    }

    @Override
    public String toString() {
        return this.name.toString();
    }
}

