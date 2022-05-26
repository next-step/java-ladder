package nextstep.ladder.domain;

import java.util.Objects;

public class Member {
    private final Name name;
    private final Position position;

    public Member(String name) {
        this(name, new Position(0, 0));
    }

    public Member(String name, Position position) {
        this.name = new Name(name);
        this.position = position;
    }

    public Member(String name, int x) {
        this.name = new Name(name);
        this.position = new Position(x);
    }

    public void move(Points points) {
        this.position.move(points);
    }

    @Override
    public String toString() {
        return this.name.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(name, member.name) && Objects.equals(position, member.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}

