package ladder.domain;

import java.util.List;
import java.util.Objects;

public class LadderResult {
    private List<String> results;

    public LadderResult(String ...inputs) {

    }

    public static LadderResult from(String input) {
        return null;
    }

    public String getResultBy(int index) {
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return results.equals(that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
