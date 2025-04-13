package nextstep.ladder.domain.edge;

import java.util.Objects;

public class LadderUser {
    private final String value;
    private final Position position;

    public LadderUser(String name) {
        this(name, new Position(0));
    }

    public LadderUser(String name, Position position) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5자를 넘을 수 없습니다.");
        }
        this.value = name;
        this.position = position;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderUser that = (LadderUser) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
