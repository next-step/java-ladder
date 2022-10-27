package ladder;

import java.util.Objects;

public class UserName {

    private static final int USER_NAME_LENGTH = 5;
    private final String name;

    private UserName(String name) {
        valid(name);
        this.name = name;
    }

    public static UserName from(String name) {
        return new UserName(name);
    }

    private void valid(String name) {
        if (name.length() > USER_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 가능합니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserName userName = (UserName) o;
        return Objects.equals(name, userName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
