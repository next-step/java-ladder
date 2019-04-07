import domain.Ladder;
import domain.Line;
import domain.Participants;
import view.InputView;
import view.ResultView;

public class LadderMain {
    public static void main (String args[]) {
        Participants participants = InputView.getNameOfParticipants();
        int depthOfLadders = InputView.getDepthOfLadders();
        Ladder ladder = new Ladder(depthOfLadders, participants.getNumber());

        ResultView.printLadders(participants, ladder);


    }
}
