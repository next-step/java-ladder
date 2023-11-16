package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LadderResult {
    private final Map<Name, String> values;

    public LadderResult(Map<Name, String> values) {
        this.values = values;
    }

    public LadderResult(Ladder ladder,
                        List<String> results) {
        PlayerResults playerResults = ladder.playerResult();
        this.values = Map.copyOf(playerResults.ladderResult(results));
    }

    public Map<Name, String> result() {
        return Collections.unmodifiableMap(this.values);
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
