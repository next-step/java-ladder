package reladder.service;

import reladder.domain.Ladder;
import reladder.domain.LadderLine;
import reladder.domain.MatchUp;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private Ladder ladder;
    private MatchUp matchUp;

    public LadderGame(Ladder ladder, MatchUp matchUp) {
        this.ladder = ladder;
        this.matchUp = matchUp;
    }

    public String getResult(String name) {
        int personIndex = matchUp.getPersonPosition(name);
        return matchUp.getResultValue(ladder.move(personIndex));
    }

    public List<LadderLine> getLadder() {
        return new ArrayList<>(ladder.getLadderLines());
    }
}
