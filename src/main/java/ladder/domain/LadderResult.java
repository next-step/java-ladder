package ladder.domain;

import java.util.Objects;

public class LadderResult {
    private String result;

    public LadderResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
