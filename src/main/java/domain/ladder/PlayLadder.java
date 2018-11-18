package domain.ladder;

import view.console.InputView;
import view.console.ResultView;

import java.util.List;

public class PlayLadder {
    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        List<Player> players = InputView.names();

        List<String> result = InputView.result();
        List<Line> lines = InputView.ladderCount(players);

        LadderManage ladderManage = new LadderManage(players, lines);

        LadderResult ladderResult = new LadderResult(result);
        resultView.result(ladderManage, ladderResult);

        String playerNames = InputView.resultPlayer();
        Laddering laddering = ladderManage.play(playerNames);

        List<PlayResult> playResult = laddering.playerResult(playerNames, ladderResult);
        resultView.resultPlay(playResult);
        String playerNames2 = InputView.resultPlayer();
        List<PlayResult> playResult2 = laddering.playerResult(playerNames2, ladderResult);
        resultView.resultPlay(playResult2);

    }

}
