import domain.*;
import view.InputView;
import view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {
        Players players = InputView.promptForPlayer();
        Rewards rewards = InputView.promptForRewards();
        Height height = InputView.promptForHeight();
        GameBoard gameBoard = GameBoard.of(players, height, new RandomBridgeCreationStrategy());

        ResultView resultView = new ResultView();
        gameBoard.display(resultView);
        rewards.display(resultView);

        Player player = InputView.promptForResult();
        GameResult result = gameBoard.result(player, rewards);
        resultView.print(result);
    }
}
