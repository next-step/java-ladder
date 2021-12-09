package step4;

import step4.controller.LadderGame;
import step4.domain.GameInfo;
import step4.domain.LadderInfo;
import step4.domain.Participants;
import step4.domain.Rewards;
import step4.view.InputView;

public class LadderApplication {
    public static void main(String[] args) {
        String participantsName = InputView.inputParticipantsName();
        Participants participants = Participants.of(participantsName);
        System.out.println();

        String rewardsName = InputView.inputRewardsName();
        Rewards rewards = Rewards.of(rewardsName);
        System.out.println();

        int height = InputView.inputLadderHeight();
        System.out.println();

        LadderGame ladderGame = LadderGame.create(GameInfo.of(participants, rewards));
        ladderGame.start(LadderInfo.of(participants.size(), height));
    }
}
