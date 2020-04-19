package ladder.domain;

import Utils.StringUtils;

import java.util.Objects;

public class User {
    private static final String NAME_REQUIRED = "이름은 빈값이면 안됩니다.";
    private static final int MAXIMUM_NAME_INPUT = 5;
    private static final String MAXIMUM_NAME_INPUT_ERROR = "5자 이상 입력할 수 없습니다.";
    private final String name;
    private int position;

    public User(final String name) {
        this.name = validate(name);
        this.position = 0;
    }

    public User(final String name, final int position) {
        this.name = validate(name);
        this.position = position;
    }

    private String validate(final String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException(NAME_REQUIRED);
        }

        if (name.length() > MAXIMUM_NAME_INPUT) {
            throw new IllegalArgumentException(MAXIMUM_NAME_INPUT_ERROR);
        }

        return name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
