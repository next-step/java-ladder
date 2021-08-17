package nextstep.ladder.model;

import java.util.Objects;

public class Name {
    private static final int MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MAX_LENGTH + "자를 넘길 수 없습니다!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return name.equals(name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
