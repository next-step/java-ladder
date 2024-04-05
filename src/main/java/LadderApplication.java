import domain.*;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LadderApplication {

    public static void main(String[] args) {
        Players players = InputView.promptForPlayer();
        List<Reward> rewards = InputView.promptForRewards();
        Height height = InputView.promptForHeight();
        GameBoard gameBoard = GameBoard.of(players, height, new RandomBridgeCreationStrategy());

        ResultView resultView = new ResultView();
        gameBoard.display(resultView);
    }
}
