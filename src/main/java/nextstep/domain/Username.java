package nextstep.domain;

import java.util.Objects;

public class Username {

    public static final int LENGTH_MAX = 5;
    public static final String ALL = "all";

    private final String name;

    public Username(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(
                    String.format("이름의 길이는 %d글자를 초과할 수 없습니다.", LENGTH_MAX));
        }
    }

    public int length() {
        return name.length();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Username username = (Username) o;
        return Objects.equals(name, username.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
