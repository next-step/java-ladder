package step3.domain;

import java.util.Collections;
import java.util.List;

public class LadderGame {
    private final Names names;
    private final Ladder ladder;

    public LadderGame(Names names, int height) {
        InputValidator.validateHeight(height);
        this.names = names;
        this.ladder = new Ladder(names.size(), height);
    }

    public Result getEachResult(Name name, Results results) {
        return results.get(ladder.findResultIndexBy(names.indexOf(name)));
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names.getNames());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(ladder.getLines());
    }
}
