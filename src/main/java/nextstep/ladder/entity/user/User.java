package nextstep.ladder.entity.user;

import java.util.Objects;

public class User {
    private final String name;
    private static final int MAX_NAME_SIZE = 5;

    public User(String name) {
        nameValid(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void nameValid(String name) {

        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("이름은 5자를 초과 할 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
