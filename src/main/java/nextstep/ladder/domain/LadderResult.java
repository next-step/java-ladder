package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LadderResult {
    private final Map<PlayerResult, String> values;

    public LadderResult(Map<PlayerResult, String> values) {
        this.values = values;
    }

    public LadderResult(Ladder ladder,
                        List<String> results) {
        this.values = new HashMap<>();
        calculateResults(ladder, results);
    }

    private void calculateResults(Ladder ladder,
                                  List<String> results) {
        for (PlayerResult playerResult : ladder.playerResults()) {
            values.put(playerResult, results.get(playerResult.endPoint()));
        }
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
