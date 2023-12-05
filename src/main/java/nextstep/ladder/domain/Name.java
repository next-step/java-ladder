package nextstep.ladder.domain;

import java.util.Objects;

public class Name {
    public static final int MAX_NAME_LENGTH = 5;
    private String name;

    public Name(String name) {
        lengthCheck(name);
        this.name = name;
    }

    private void lengthCheck(String value) {
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
