package step4;

import step4.controller.LadderGame;
import step4.domain.GameInfo;
import step4.domain.LadderInfo;
import step4.domain.Participants;
import step4.domain.Rewards;
import step4.view.InputView;
import step4.view.ResultView;

public class LadderApplication {
    public static void main(String[] args) {
        String participantsName = InputView.inputParticipantsName();
        Participants participants = Participants.of(participantsName);
        ResultView.nextLine();

        String rewardsName = InputView.inputRewardsName();
        Rewards rewards = Rewards.of(rewardsName);
        ResultView.nextLine();

        int height = InputView.inputLadderHeight();
        ResultView.nextLine();

        LadderGame ladderGame = LadderGame.create();
        LadderInfo ladderInfo = LadderInfo.of(participants.size(), height);
        GameInfo gameInfo = GameInfo.of(participants, rewards);
        ladderGame.start(ladderInfo, gameInfo);
    }
}
