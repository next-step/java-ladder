package ladder.domain;

import java.util.Map;

public class LadderResult {

    private final Map<Member, GameResult> values;

    public LadderResult(Map<Member, GameResult> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
