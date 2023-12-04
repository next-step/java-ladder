package ladder.domain;

import java.util.Map;

public class WinnerResult {

    private final Map<Member, GameResult> values;

    public WinnerResult(Map<Member, GameResult> values) {
        this.values = values;
    }

    public Map<Member, GameResult> values() {
        return values;
    }

    public GameResult gameResult(String member) {
        return values.get(new Member(member));
    }

    @Override
    public String toString() {
        return values.toString();

    }
}
