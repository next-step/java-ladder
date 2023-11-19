package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LadderResult {
    private final Map<Name, String> values;

    public LadderResult(Map<Name, String> values) {
        this.values = Map.copyOf(values);
    }

    public LadderResult(PlayerResults playerResults,
                        List<String> results) {
        //this(playerResults.ladderResult(results));
        this(Collections.EMPTY_MAP);
    }

    public Map<Name, String> results() {
        return this.values;
    }

    public String result(String name) {
        return this.values.get(new Name(name));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

}
