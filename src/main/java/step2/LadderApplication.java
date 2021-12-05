package step2;

import step2.controller.LadderGame;
import step2.domain.GameInfo;
import step2.domain.Height;
import step2.domain.Participants;
import step2.domain.Rewards;
import step2.strategy.RandomLineCreateStrategy;
import step2.view.InputView;

public class LadderApplication {
    public static void main(String[] args) {
        //input
        String names = InputView.inputParticipantName();
        System.out.println();

        String reward = InputView.inputLadderReward();
        System.out.println();

        GameInfo gameInfo = GameInfo.of(Participants.of(names), Rewards.of(reward));

        int height = InputView.inputLadderHeight();
        System.out.println();

        //start
        LadderGame ladderGame = LadderGame.create(new RandomLineCreateStrategy());
        ladderGame.start(gameInfo, Height.of(height));
    }
}
