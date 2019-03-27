import domain.Ladders;
import domain.Players;
import view.InputView;
import view.ResultView;

public class ConsoleApplication {

    public static void main(String[] args) {
        Players players = InputView.inputPlayers();
        Ladders ladders = InputView.inputLadders(players.size());

        ResultView.viewResult(players, ladders);
    }
}
