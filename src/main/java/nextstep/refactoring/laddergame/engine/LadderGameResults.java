package nextstep.refactoring.laddergame.engine;

import java.util.List;

public class LadderGameResults {

    private final List<LadderGameResult> ladderGameResultList;

    public LadderGameResults(List<LadderGameResult> ladderGameResultList) {
        this.ladderGameResultList = ladderGameResultList;
    }

    public List<LadderGameResult> getLadderGameResultList() {
        return ladderGameResultList;
    }
}
