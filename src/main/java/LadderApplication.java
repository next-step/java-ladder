import domain.Height;
import domain.GameBoard;
import domain.Players;
import domain.RandomBridgeCreationStrategy;
import view.InputView;
import view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {
        Players players = InputView.promptForPlayer();
        Height height = InputView.promptForHeight();
        GameBoard gameBoard = GameBoard.of(players, height, new RandomBridgeCreationStrategy());

        ResultView resultView = new ResultView();
        gameBoard.display(resultView);
    }
}
