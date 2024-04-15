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
        if (player.isName("all")) {
            resultView.print(gameBoard.resultAll(rewards));
            return;
        }
        resultView.print(gameBoard.result(player, rewards));
    }
}
