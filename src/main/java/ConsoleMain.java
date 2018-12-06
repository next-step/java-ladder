import domain.*;
import domain.generator.LadderGenerator;
import view.InputView;
import view.ResultView;

public class ConsoleMain {

    public static void main(String[] args) {
        String inputNames = InputView.inputParticipantsName();
        String inputRewards = InputView.inputRewards();
        String inputLevel = InputView.inputLevel();

        LadderGenerator ladderGenerator = LadderGeneratorFactory.create(inputLevel);
        Participants participants = Participants.from(inputNames);
        Rewards rewards = Rewards.from(inputRewards);
        Ladder ladder = ladderGenerator.generate(participants.size());

        ResultView.printLadder(participants, ladder, rewards);

        RewardMap rewardMap = new RewardMap(participants, rewards);
        rewardMap.initMapFromResult(ladder.play());

        String nameForReward = InputView.inputNameForReward();
        ResultView.printLadderGameResult(rewardMap, nameForReward);
    }
}
