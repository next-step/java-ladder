package laddergame.domain;

import java.util.Map;
import java.util.Objects;

public class TotalResult {
    private final Map<Player, Result> total;

    public TotalResult(Map<Player, Result> total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TotalResult)) return false;
        TotalResult that = (TotalResult) o;
        return Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total);
    }
}
