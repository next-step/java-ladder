package nextstep.ladder.domain.participant;

import java.util.Objects;
import java.util.Optional;

public class Name {
    private final String name;

    public Name(final String name) {
        this.name = Optional.ofNullable(name)
                .filter(n -> n.length() > 0)
                .filter(n -> n.length() < 6)
                .filter(n -> !n.isBlank())
                .orElseThrow(() -> new IllegalArgumentException("이름은 빈 칸, 혹은 5글자를 초과할 수 없습니다."));
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
