package ladder.domain;

import ladder.engine.Ladder;
import ladder.engine.LadderResult;

public class HeeSeokLadder implements Ladder {
    private Lines lines;

    public HeeSeokLadder(Lines lines) {
        this.lines = lines;
    }

    @Override
    public Lines lines() {
        return this.lines;
    }

    @Override
    public LadderResult play(Users users) {
        LadderResult ladderResult = new LadderResult();
        for (User user : users) {
            int resultPosition = lines.calulateGameResult(user.position());
            ladderResult.put(user.position(), resultPosition);
        }
        return ladderResult;
    }
}
