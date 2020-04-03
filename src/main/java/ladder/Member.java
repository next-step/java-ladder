package ladder;

import java.util.Objects;

public class Member {

    private static final int MEMBER_NAME_LENGTH_LIMIT = 5;

    private final String name;

    private Member(String name) {
        validate(name);
        this.name = name;
    }

    public static Member newInstance(String name) {
        return new Member(name);
    }

    private void validate(String name) {
        if (Objects.isNull(name) || name.isEmpty() || name.length() > MEMBER_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("Member name must be exist and the length must be less than 5.");
        }
    }
}
