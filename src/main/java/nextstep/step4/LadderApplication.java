package nextstep.step4;

import nextstep.step4.domain.*;
import nextstep.step4.view.InputView;
import nextstep.step4.view.ResultView;

import java.util.List;
import java.util.Map;

public class LadderApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        List<String> playersNameList = inputView.inputPlayersName();
        List<String> ladderResultList = inputView.inputLadderResults();
        int maxHeight = inputView.inputLadderHeight();

        Players players = Players.from(playersNameList);
        Ladder ladder = Ladder.of(players.getCountOfPlayer(), maxHeight);
        LadderResult ladderResult = LadderResult.from(ladderResultList);

        resultView.printLadderStatus(players, ladder, ladderResult);

        LadderGame ladderGame = LadderGame.of(players, ladder, ladderResult);
        startLadderGame(ladderGame, inputView, resultView);
    }

    private static void startLadderGame(LadderGame ladderGame, InputView inputView, ResultView resultView) {
        while (true) {
            String playerName = inputView.inputWinner();
            Map<PlayerName, String> result = ladderGame.findResultsByPlayerName(playerName);
            resultView.printLadderGameResult(result);
            if (playerName.equals("all")) {
                break;
            }
        }
    }

}
