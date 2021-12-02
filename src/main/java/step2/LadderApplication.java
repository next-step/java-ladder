package step2;

import step2.controller.LadderGame;
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

        int height = InputView.inputLadderHeight();
        System.out.println();

        //start
        LadderGame ladderGame = LadderGame.create(new RandomLineCreateStrategy());
        ladderGame.start(Participants.of(names), Height.of(height), Rewards.of(reward));
    }
}
