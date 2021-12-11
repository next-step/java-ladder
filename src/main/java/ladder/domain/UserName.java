package ladder.domain;

import java.util.Objects;

public class UserName {
    private final String name;

    public UserName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 최대5글자까지 부여할 수 있습니다.");
        }
        this.name = name;
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
