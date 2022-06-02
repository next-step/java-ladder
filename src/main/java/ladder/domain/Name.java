package ladder.domain;

import java.util.Objects;

public class Name {
    private static final int MAXIMUM = 5;

    private final String name;

    private Name(String name) {
        validateName(name);
        this.name = name;
    }

    public static Name of(String name) {
        return new Name(name);
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (name.length() > MAXIMUM) {
            throw new IllegalArgumentException("유저이름이 다섯자를 넘을 수 없습니다.");
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
}
