package nextstep.ladder.domain.participant;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(final String name) {
        this.checkNameLength(name);
        this.name = name;
    }

    private void checkNameLength(String name) {
        if (name == null || name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("이름은 빈 칸, 혹은 5글자를 초과할 수 없습니다.");
        }
    }

    String getName() {
        return this.name;
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
