package ladder;

import ladder.controller.LadderController;
import ladder.domain.Players;
import ladder.util.StringUtil;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Arrays;

public class LadderGameApplication {
    private static final String PLAYER_DELIMITER = ",";

    public static void main(String[] args) {
        try {
            String inputPlayer = InputView.inputPlayer();
            Players players = Players.of(Arrays.asList(StringUtil.split(inputPlayer.trim(), PLAYER_DELIMITER)));
            int ladderHeight = InputView.inputLadderHeight();
            InputView inputView = new InputView(players, ladderHeight);

            LadderController ladderController = new LadderController(inputView);

            ResultView resultView = ladderController.startLadderGame();

            resultView.printOutPlayers();
            System.out.println();
            resultView.printOutLineResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
