package ladder.domain;

import java.util.List;
import java.util.Objects;

public class LadderResult {
    private final List<Position> value;

    public LadderResult(List<Position> value) {
        this.value = value;
    }

    public Position result(User user) {
        return this.value.get(user.initPosition().value());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
