package net.chandol.ladder.v2.domain;

import net.chandol.ladder.v2.domain.line.LinesGenerator;
import net.chandol.ladder.v2.dto.LadderGameResult;
import net.chandol.ladder.v2.dto.LadderInitializeRequest;

public class LadderGame {
    private LinesGenerator linesGenerator;
    private Ladder ladder;

    public LadderGame(LinesGenerator linesGenerator) {
        this.linesGenerator = linesGenerator;
    }

    public Ladder initializeLadder(LadderInitializeRequest request) {
        return this.ladder = new Ladder(request, linesGenerator);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public LadderGameResult getResult() {
        return ladder.createGameResult();
    }
}
