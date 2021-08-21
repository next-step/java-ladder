package ladder.domain;

import java.util.Objects;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(final String name) {
        validateSize(name);
        this.name = name.trim();
    }

    private void validateSize(final String name) {
        if (Objects.isNull(name) || name.trim().length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("플레이어 이름은 null 또는 5자를 초과할 수 없습니다.");
        }
    }

    public String getValue() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
