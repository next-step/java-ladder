import domain.DefaultLadderGenerator;
import domain.Ladder;
import domain.LadderGenerator;
import domain.Participants;
import view.InputView;
import view.ResultView;

public class ConsoleMain {

    public static void main(String[] args) {
        String names = InputView.inputParticipantsName();
        String rewards = InputView.inputRewards();
        int height = InputView.inputHeightOfLadder();

        LadderGenerator ladderGenerator = new DefaultLadderGenerator();
        Participants participants = Participants.from(names);
        Ladder ladder = ladderGenerator.generate(participants.size(), height);

        ResultView.printLadder(participants, ladder, rewards);
    }
}
