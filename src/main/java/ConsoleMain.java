import domain.*;
import view.InputView;
import view.ResultView;

public class ConsoleMain {

    public static void main(String[] args) {
        String inputNames = InputView.inputParticipantsName();
        String inputRewards = InputView.inputRewards();
        int height = InputView.inputHeightOfLadder();

        LadderGenerator ladderGenerator = new DefaultLadderGenerator();
        Participants participants = Participants.from(inputNames);
        Rewards rewards = Rewards.from(inputRewards);
        Ladder ladder = ladderGenerator.generate(participants.size(), height);

        ResultView.printLadder(participants, ladder, rewards);

        RewardMap rewardMap = new RewardMap(participants, rewards);
        rewardMap.initMapFromResult(ladder.play());

        String nameForReward = InputView.inputNameForReward();
        ResultView.printLadderGameResult(rewardMap, nameForReward);
    }
}
