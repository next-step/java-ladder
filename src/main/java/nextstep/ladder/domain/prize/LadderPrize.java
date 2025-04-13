package nextstep.ladder.domain.prize;

import java.util.Objects;

public class LadderPrize {
    private final String value;

    public LadderPrize(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderPrize that = (LadderPrize) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
