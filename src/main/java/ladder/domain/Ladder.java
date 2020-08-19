package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

import ladder.domain.core.line.Line;
import ladder.ui.result.DisplayResult;

public class Ladder implements DisplayResult {
    private List<Line> ladder;

    Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static LadderBuilder builder(){
        return new LadderBuilder();
    }

    @Override
    public String toDisplay() {
        return ladder.stream()
            .map(l -> l.toDisplayResult().toDisplay())
            .collect(Collectors.joining("\n"));
    }
}
