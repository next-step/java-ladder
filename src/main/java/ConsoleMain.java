import domain.*;
import view.InputView;
import view.ResultView;

public class ConsoleMain {
    public static void main(String[] args) {
        String participantsName = InputView.inputParticipantsName();
        String rewardsStr = InputView.inputRewards();
        PositiveNumber height = PositiveNumber.from(InputView.inputHeightOfLadder());

        Participants participants = Participants.fromInput(participantsName);
        Rewards rewards = Rewards.fromInput(rewardsStr);

        Ladder ladder = Ladder.of(height, participants);

        ResultView.printLadder(participants, ladder, rewards);

        String nameForReward = InputView.inputNameForReward();

        LadderResult result = new LadderResult(ladder, participants, rewards);

        ResultView.printLadderGameResult(result, nameForReward);
    }
}
