package step4_ladderGame.domain;

import java.util.Objects;

public class Name {

    private final String name;

    public final static int MAX_NAME_LENGTH = 5;

    private Name(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("플레이어 이름은 5글자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public static Name of(String name) {
        return new Name(name);
    }

    public String toString() {
        return name;
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
