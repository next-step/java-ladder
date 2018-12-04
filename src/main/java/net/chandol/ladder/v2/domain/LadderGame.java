package net.chandol.ladder.v2.domain;

import net.chandol.ladder.v2.domain.line.LinesGenerator;
import net.chandol.ladder.v2.dto.LadderGameInitializeRequest;

public class LadderGame {
    private LinesGenerator linesGenerator;
    private Ladder ladder;

    public LadderGame(LinesGenerator linesGenerator) {
        this.linesGenerator = linesGenerator;
    }

    public Ladder initializeLadder(LadderGameInitializeRequest request) {
        return this.ladder = new Ladder(request.getPlayers(), request.getHeight(), linesGenerator);
    }

    public Ladder getLadder() {
        return ladder;
    }
}
