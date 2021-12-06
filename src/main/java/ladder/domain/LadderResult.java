package ladder.domain;

import java.util.Map;
import java.util.Objects;

public class LadderResult {
    private final Map<Integer, Integer> value;

    public LadderResult(Map<Integer, Integer> value) {
        this.value = value;
    }

    public int result(User user) {
        return this.value.get(user.initPosition());
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
