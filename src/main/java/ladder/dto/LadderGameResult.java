package ladder.dto;

import ladder.domain.Ladder;

import java.util.List;

public class LadderGameResult {
    private final Ladder ladder;
    private final List<String> names;

    public LadderGameResult(Ladder ladder, List<String> names) {
        this.ladder = ladder;
        this.names = names;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<String> getNames() {
        return names;
    }
}
