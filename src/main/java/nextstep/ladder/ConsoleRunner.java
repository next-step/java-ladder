package nextstep.ladder;

import nextstep.ladder.domain.laddar.LadderGame;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.view.InputView;
import nextstep.ladder.domain.view.ResultView;

import java.util.List;

public class ConsoleRunner {
    public static void main(String[] args) {
        List<String> playerNames = InputView.playerNames();
        ResultView.newLine();

        int ladderHeight = InputView.ladderHeight();
        ResultView.newLine();

        LadderGame ladderGame = LadderGame.of(Players.from(playerNames), ladderHeight);
        ResultView.printResult(ladderGame.getGameResult());
    }
}
