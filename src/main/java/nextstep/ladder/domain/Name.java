package nextstep.ladder.domain;

import java.util.Objects;

public class Name {

    public static final String GUIDE_ERR_USER_MAX_SIZE = "이름은 한 글자 이상 최대 5글자까지 부여할 수 있습니다.";
    private static final int NAME_MAX_SIZE = 5;
    private static final int NAME_MIN_SIZE = 1;
    private final String value;

    private Name(final String name) {
        this.value = name;
    }

    public static Name valueOf(final String name) {
        checkNameRange(name);
        return new Name(name);
    }

    private static void checkNameRange(final String name) {
        if(name.length() > NAME_MAX_SIZE || name.length() < NAME_MIN_SIZE) {
            throw new IllegalArgumentException(GUIDE_ERR_USER_MAX_SIZE);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        final Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
