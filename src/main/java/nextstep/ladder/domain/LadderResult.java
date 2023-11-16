package nextstep.ladder.domain;

import java.util.*;

public class LadderResult {
    private final Map<Name, String> values;

    public LadderResult(Map<Name, String> values) {
        this.values = values;
    }

    public LadderResult(Ladder ladder,
                        List<String> results) {
        this.values = new HashMap<>();
        calculateResults(ladder, results);
    }

    private void calculateResults(Ladder ladder,
                                  List<String> results) {
        ladder.playerResults()
                .forEach(playerResult -> values.put(playerResult.name(), results.get(playerResult.endPoint())));
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
