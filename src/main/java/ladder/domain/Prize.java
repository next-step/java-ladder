package ladder.domain;

import java.util.List;
import java.util.Objects;

public class Prize {
    private final List<String> hitResults;

    private Prize(List<String> hitResults) {
        this.hitResults = hitResults;
    }

    public static Prize of(List<String> hitResults) {
        return new Prize(hitResults);
    }

    public String prizeOfIndex(int index) {
        return hitResults.get(index);
    }

    public List<String> getHitResults() {
        return hitResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prize prize = (Prize) o;
        return Objects.equals(hitResults, prize.hitResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hitResults);
    }

}
