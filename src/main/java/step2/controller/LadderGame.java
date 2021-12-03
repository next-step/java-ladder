package step2.controller;

import step2.domain.*;
import step2.service.LadderGameService;
import step2.strategy.LineCreateStrategy;
import step2.view.ResultView;

public class LadderGame {
    private final LineCreateStrategy lineCreateStrategy;
    private final LadderGameService ladderGameService;

    private LadderGame(LineCreateStrategy lineCreateStrategy) {
        this.lineCreateStrategy = lineCreateStrategy;
        this.ladderGameService = new LadderGameService();
    }

    public static LadderGame create(LineCreateStrategy lineCreateStrategy) {
        return new LadderGame(lineCreateStrategy);
    }

    public void start(Participants participants, Height height, Rewards rewards) {
        validateMatchSize(participants, rewards);

        LadderInfo ladderInfo = LadderInfo.of(participants.size(), height.getHeight());
        Ladder ladder = Ladder.create(ladderInfo, lineCreateStrategy);
        ResultView.showResult(participants, ladder, rewards);

        GameHistory history = ladderGameService.start(ladder, ladderInfo);
        ladderGameService.result(history, participants, rewards);
    }

    private void validateMatchSize(Participants participants, Rewards rewards) {
        int participantsSize = participants.size();
        int rewardsSize = rewards.size();
        if (participantsSize != rewardsSize) {
            throw new IllegalArgumentException("참가자 수와 보상의 수가 일치하지 않습니다.");
        }
    }
}
