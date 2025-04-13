package nextstep.ladder.domain.edge;

import java.util.Objects;

public class LadderUser {
    private final String value;

    public LadderUser(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5자를 넘을 수 없습니다.");
        }
        this.value = name;
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
