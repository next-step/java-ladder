package step2.controller;

import step2.domain.*;
import step2.service.LadderGameService;
import step2.strategy.LineCreateStrategy;
import step2.view.ResultView;

public class LadderGame {
    private LineCreateStrategy lineCreateStrategy;
    private LadderGameService ladderGameService;

    private LadderGame(LineCreateStrategy lineCreateStrategy) {
        this.lineCreateStrategy = lineCreateStrategy;
        this.ladderGameService = new LadderGameService();
    }

    public static LadderGame create(LineCreateStrategy lineCreateStrategy) {
        return new LadderGame(lineCreateStrategy);
    }

    public void start(Participants participants, Height height, Rewards rewards) {
        LadderInfo ladderInfo = LadderInfo.of(participants.size(), height.getHeight());
        Ladder ladder = Ladder.create(ladderInfo, lineCreateStrategy);
        ResultView.showResult(participants, ladder, rewards);
        GameHistory history = ladderGameService.start(ladder, ladderInfo);
    }
}
