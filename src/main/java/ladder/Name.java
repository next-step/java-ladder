package ladder;

import java.util.Objects;

public class Name {
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        if (name == null || name.trim().isBlank()) {
            throw new IllegalArgumentException("이름이 없습니다.");
        }
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5글자입니다.");
        }
        this.name = name;
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
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                '}';
    }
}
