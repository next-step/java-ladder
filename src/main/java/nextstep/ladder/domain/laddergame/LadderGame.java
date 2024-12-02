package nextstep.ladder.domain.laddergame;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.LadderResult;
import nextstep.ladder.domain.laddergame.position.Positions;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final Ladder ladder;
    private final LadderResult ladderResult;

    public LadderGame(Ladder ladder, LadderResult ladderResult) {
        this.ladder = ladder;
        this.ladderResult = ladderResult;
    }

    public LadderGameResult play() {
        List<Positions> positionsList = new ArrayList<>();

        for (int i = 0; i < ladder.getPlayers().size(); i++) {
            Positions positions = new Positions();
            positionsList.add(positions.add(ladder.getLines(), i));
        }

        return new LadderGameResult(ladder.getPlayers(), positionsList, ladderResult);
    }

}
