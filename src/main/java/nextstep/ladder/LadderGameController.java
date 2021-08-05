package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.dto.LadderPlayerGameResult;
import nextstep.ladder.domain.info.LadderGameInfo;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;
import java.util.stream.Stream;

public class LadderGameController {
    public static void main(String[] args) {
        List<String> playerNames = InputView.inputPlayers();
        List<String> gameResults = InputView.inputGameResults();
        int ladderHeight = InputView.inputLadderHeight();

        LadderGame ladderGame = makeLadderGame(playerNames, gameResults, ladderHeight);
        printLadderResult(ladderGame);

        LadderPlayerGameResult gameResult = ladderGame.play();
        printGameResult(gameResult);
    }

    private static LadderGame makeLadderGame(List<String> playerNames, List<String> gameResults, int ladderHeight) {
        LadderGameInfo ladderGameInfo = LadderGameInfo.of(playerNames, gameResults, ladderHeight);
        return LadderGame.of(ladderGameInfo);
    }

    private static void printLadderResult(LadderGame ladderGame) {
        ResultView.printLadderResult(ladderGame.resultLadderFigure());
    }

    private static void printGameResult(LadderPlayerGameResult gameResult) {
        String player = InputView.inputGameResultOfPlayer();
        while (!player.isEmpty()) {
            ResultView.printPlayerGameResult(player, gameResult);
            player = InputView.inputGameResultOfPlayer();
        }
    }

}
