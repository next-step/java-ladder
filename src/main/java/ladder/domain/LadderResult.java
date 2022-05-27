package ladder.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LadderResult {
    private final Map<Person, String> ladderResult;

    private LadderResult(Map<Person, String> ladderResult) {
        this.ladderResult = new LinkedHashMap<>(ladderResult);
    }

    public static LadderResult of(Map<Person, String> ladderResult) {
        return new LadderResult(ladderResult);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(ladderResult, that.ladderResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderResult);
    }

}
