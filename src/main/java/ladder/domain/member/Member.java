package ladder.domain.member;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Member {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Member(String name) {
        validateName(name);

        this.name = name;
    }

    private void validateName(String name) {
        if (StringUtils.isBlank(name) || (MAX_NAME_LENGTH < name.length())) {
            throw new IllegalArgumentException("It's not valid name : " + name);
        }
    }

    public String getName() {
        return name;
    }

    public String toFormedString() {
        return String.format("%" + MAX_NAME_LENGTH + "s", this.name);
    }

    @Override
    public String toString() {
        return name;
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
