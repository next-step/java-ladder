package step2.domain;

import java.util.Objects;

public class Name {
    private static final int MAX_LIMIT = 5;

    private final String name;

    public Name(String name) {
        if (name.length() > MAX_LIMIT) {
            throw new RuntimeException("사람 이름은 최대 5글자 입니다.");
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                '}';
    }
}
