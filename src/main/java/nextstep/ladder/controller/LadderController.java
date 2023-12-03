package nextstep.ladder.controller;

import java.util.List;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.lines.Lines;
import nextstep.ladder.domain.lines.RandomLinesFactory;

public class LadderController {

    private final RandomLinesFactory randomLinesFactory;

    public LadderController(RandomLinesFactory randomLinesFactory) {
        this.randomLinesFactory = randomLinesFactory;
    }

    public Ladder startLadderGame(List<String> names, int height) {
        Lines randomLines = randomLinesFactory.createLines(height, names.size());
        return new Ladder(names, randomLines);
    }
}
