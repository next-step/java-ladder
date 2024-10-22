package ladder.domain;

import java.util.Objects;

public class Member {
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Member(String name) {
        if (isOutOfBoundLength(name)) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private boolean isOutOfBoundLength(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Member member = (Member) o;
        return Objects.equals(name, member.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
