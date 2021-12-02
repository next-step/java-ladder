package step2.controller;

import step2.domain.Height;
import step2.domain.Ladder;
import step2.domain.LadderInfo;
import step2.domain.Participants;
import step2.strategy.LineCreateStrategy;
import step2.view.ResultView;

public class LadderGame {
    private LineCreateStrategy lineCreateStrategy;

    private LadderGame(LineCreateStrategy lineCreateStrategy) {
        this.lineCreateStrategy = lineCreateStrategy;
    }

    public static LadderGame create(LineCreateStrategy lineCreateStrategy) {
        return new LadderGame(lineCreateStrategy);
    }

    public void start(Participants participants, Height height) {
        LadderInfo ladderInfo = LadderInfo.of(participants.size(), height.getHeight());
        Ladder ladder = Ladder.create(ladderInfo, lineCreateStrategy);
        ResultView.showResult(participants.getNames(), ladder);
    }
}
