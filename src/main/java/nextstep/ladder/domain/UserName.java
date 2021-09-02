package nextstep.ladder.domain;

import java.util.Objects;

public class UserName {

    public static final int USER_NAME_LENGTH_LIMIT = 5;

    private String name;

    public UserName(String name) {
        this.name = name;
        if (name.length() > USER_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름은 최대 " + USER_NAME_LENGTH_LIMIT + "글자 까지만 가능합니다");
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserName userName = (UserName) o;
        return Objects.equals(name, userName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
