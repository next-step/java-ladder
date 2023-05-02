package nextstep.ladder.domain;

import java.util.Objects;

public class Member {
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Member(String name) {
        if (name == null || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("이름은 %d 글자를 초과할 수 없습니다.", MAX_NAME_LENGTH));
        }

        this.name = name;
    }

    public String name() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(name, member.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
