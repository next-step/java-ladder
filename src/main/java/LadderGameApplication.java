import view.InputView;
import view.ResultView;
import domain.Ladder;
import domain.Players;


public class LadderGameApplication {

    public static void main(String[] args) {
        Players players = InputView.inputPlayers();
        int ladderHeight = InputView.inputLadderHeight();

        Ladder ladder = new Ladder(ladderHeight, players.size());
        ResultView.printResult(players, ladder);
    }
}
