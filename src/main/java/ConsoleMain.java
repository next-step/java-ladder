import game.ladder.domain.Height;
import game.ladder.domain.Ladder;
import game.ladder.domain.LinesGenerator;
import game.ladder.domain.Participants;
import game.ladder.view.InputView;
import game.ladder.view.OutputView;

public class ConsoleMain {

    public static void main(String[] args) {
        Participants participants = InputView.readParticipant();

        Height height = InputView.readHeight();

        LinesGenerator linesGenerator = new LinesGenerator(height);
        Ladder ladder = new Ladder(linesGenerator, participants);

        OutputView.printLadder(ladder);
    }

}
