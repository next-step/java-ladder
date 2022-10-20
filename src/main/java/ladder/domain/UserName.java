package ladder.domain;

import java.util.Objects;

public class UserName {

    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public UserName(String name) {
        if (isInvalidName(name)) {
            throw new IllegalArgumentException("유효하지 않은 사용자 이름입니다.");
        }
        this.name = name;
    }

    private boolean isInvalidName(String name) {
        return name == null || name.isBlank() || name.length() > MAX_NAME_LENGTH;
    }

    public int maxLength(String result) {
        return Math.max(this.name.length(), result.length());
    }

    public String getName() {
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
