package nextstep.refactoring;

import nextstep.ladder.strategy.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final int countOfPerson;
    private final Lines lines;

    public Ladder(int height, int countOfPerson, BooleanGenerator booleanGenerator) {
        this.countOfPerson = countOfPerson;
        lines = new Lines(height, countOfPerson, booleanGenerator);
    }

    public List<LadderResult> execute() {
        List<LadderResult> ladderResults = new ArrayList<>();
        for (int index = 0; index < countOfPerson; index++) {
            int resultIndex = lines.move(index);
            ladderResults.add(new LadderResult(index, resultIndex));
        }
        return ladderResults;
    }
}
