package ladder;

import java.util.Objects;

public class User {
    private static final int MAX_NAME_LENGTH = 5;
    private String name;

    public User(String name) {
        valid(name);
        this.name = name;
    }

    private void valid(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자까지 입력 가능합니다.");
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
