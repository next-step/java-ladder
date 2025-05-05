package nextstep.ladder.domain.name;

import java.util.Objects;

public class Name {
    private String name;

    public Name(String name) {
        if (null == name || name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("이름의 형식이 올바르지 않습니다. name=" + name);
        }
        this.name = name.trim();
    }

    @Override
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
