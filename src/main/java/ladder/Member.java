package ladder;

import java.util.Objects;

public class Member {

    private static final int MEMBER_NAME_LENGTH_LIMIT = 5;

    private final String name;

    private Member(final String name) {
        validate(name);
        this.name = name;
    }

    public static Member newInstance(final String name) {
        return new Member(name);
    }

    private void validate(final String name) {
        if (Objects.isNull(name) || "".equals(name.trim()) || name.length() > MEMBER_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("Member name must be exist and the length must be less than 5.");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
