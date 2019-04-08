import domain.Ladder;
import domain.Players;
import view.InputView;
import view.ResultView;

public class LadderMain {
    public static void main (String[] args) {
        Players players = InputView.getNameOfParticipants();
        int depthOfLadders = InputView.getDepthOfLadders();
        Ladder ladder = new Ladder(depthOfLadders, players.getNumber());

        ResultView.printLadders(players, ladder);


    }
}
