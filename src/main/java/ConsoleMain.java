import domain.Ladder;
import domain.Participants;
import domain.PositiveNumber;
import view.InputView;
import view.ResultView;

public class ConsoleMain {
    public static void main(String[] args) {
        String participantsName = InputView.inputParticipantsName();
        PositiveNumber height = PositiveNumber.from(InputView.inputHeightOfLadder());

        Participants participants = Participants.fromInput(participantsName);

        Ladder ladder = Ladder.of(height, participants);

        ResultView.printLadder(participants, ladder);
    }
}
