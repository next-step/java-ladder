package ladder.controller;

import ladder.domain.game.LadderGame;
import ladder.domain.game.LadderGameResults;
import ladder.domain.game.LadderRewards;
import ladder.domain.ladder.Lines;
import ladder.domain.ladder.ladderInfo.LadderHeight;
import ladder.domain.player.LadderPlayer;
import ladder.domain.player.LadderPlayers;
import ladder.ui.InputView;
import ladder.ui.ResultView;

public class LadderController {
    private static final String ALL = "all";

    public static void main(String[] args) {
        LadderPlayers ladderPlayers = InputView.inputGamerNames();
        LadderRewards ladderRewards = InputView.inputGameResult();
        LadderHeight ladderHeight = InputView.inputLadderMaxHeight();

        Lines ladder = LadderGame.createLadder(ladderPlayers.getPlayerCount(), ladderHeight);
        ResultView.print(ladder, ladderPlayers, ladderRewards);

        LadderGameResults results = LadderGame.start(ladder, ladderPlayers, ladderRewards);
        while (true) {
            LadderPlayer ladderPlayer = InputView.inputTargetPlayer();
            if (ALL.equals(ladderPlayer.getPlayerName().toLowerCase())) {
                ResultView.printAllResult(results);
                break;
            }
            ResultView.printResult(ladderPlayer, results);
        }
    }
}
