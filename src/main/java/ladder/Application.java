package ladder;

import ladder.game.domain.LadderGameInfo;
import ladder.game.domain.LadderGameResults;
import ladder.game.ui.LadderGame;
import ladder.player.domain.Players;
import ladder.prize.domain.Prizes;
import ladder.view.InputView;
import ladder.view.OutputView;


public class Application {
    public static final String END_CONDITION = "all";

    public static void main(String[] args) {
        Players players = Players.of(InputView.requestPlayerNames());
        Prizes prizes = Prizes.of(InputView.requestPrizes());

        LadderGameInfo ladderGameInfo = LadderGameInfo.of(players, prizes);
        LadderGame ladderGame = LadderGame.init(ladderGameInfo, InputView.requestHeight());
        OutputView.print(ladderGame);

        LadderGameResults ladderGameResults = ladderGame.play();
        while (true) {
            String specificPlayer = InputView.requestSpecificPlayer();
            if (specificPlayer.equalsIgnoreCase(END_CONDITION)) {
                OutputView.print(ladderGameResults.getAllPlayersResult());
                break;
            }
            OutputView.print(ladderGameResults.getSpecificPlayerResult(specificPlayer));
        }

    }
}
