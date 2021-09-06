package laddergame.user;

import java.util.Objects;

public class UserName{

    private static final int NAME_MAX_LENGTH = 5;
    private static final String BLANK = "";
    private final String name;

    public UserName(String name) {
        isBlank(name);
        isLengthOver5(name);
        this.name = name;
    }

    private void isBlank(String name) {
        if(name == null || BLANK.equals(name.trim())) {
            throw new IllegalArgumentException("이름은 빈 값일 수 없습니다.");
        }
    }

    private void isLengthOver5(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하입니다.");
        }
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
