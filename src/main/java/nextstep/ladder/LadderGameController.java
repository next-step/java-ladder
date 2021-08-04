package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.dto.LadderPlayerGameResult;
import nextstep.ladder.domain.info.LadderGameInfo;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderGameController {
    public static void main(String[] args) {
        List<String> playerNames = InputView.inputPlayers();
        List<String> gameResults = InputView.inputGameResults();
        int ladderHeight = InputView.inputLadderHeight();

        LadderGame ladderGame = makeLadderGame(playerNames, gameResults, ladderHeight);
        printLadderResult(ladderGame);

        LadderPlayerGameResult gameResult = playLadderGame(ladderGame);
        printGameResult(gameResult);
    }

    private static LadderGame makeLadderGame(List<String> playerNames, List<String> gameResults, int ladderHeight) {
        LadderGameInfo ladderGameInfo = LadderGameInfo.of(playerNames, gameResults, ladderHeight);
        return LadderGame.of(ladderGameInfo);
    }

    private static void printLadderResult(LadderGame ladderGame) {
        ResultView.printLadderResult(ladderGame.resultLadderFigure());
    }

    private static LadderPlayerGameResult playLadderGame(LadderGame ladderGame) {
        return ladderGame.play();
    }

    private static void printGameResult(LadderPlayerGameResult gameResult) {
        String player;
        while (!(player = InputView.inputGameResultOfPlayer()).isEmpty()) {
            ResultView.printPlayerGameResult(player, gameResult);
        }
    }

}
