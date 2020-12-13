package nextstep.step4.domain;

import java.util.Objects;

public class User {

    private static final int LENGTH_LIMIT = 5;

    private int index;
    private final String name;

    private User(int index, String name) {
        validate(name);
        this.index = index;
        this.name = name;
    }

    private void validate(String name) {
        checkNameLength(name);
        checkEmptyName(name);
    }

    private void checkNameLength(String name) {
        if(name.length() > LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }

    private void checkEmptyName(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름을 입력해주세요");
        }
    }

    public static User of(int index, String name) {
        return new User(index, name);
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return index == user.index &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, name);
    }
}
