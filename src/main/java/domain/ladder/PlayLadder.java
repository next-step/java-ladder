package domain.ladder;

import view.console.InputView;
import view.console.ResultView;

import java.util.List;

public class PlayLadder {
    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        List<Player> players = InputView.names();

        List<String> result = InputView.result();

        LadderLevel ladderLevel = InputView.getLevel();
        List<LadderLine> ladderLines = InputView.createLadder(players, ladderLevel.getLadderCount());

        LadderManage ladderManage = new LadderManage(players, ladderLines);

        LadderResult ladderResult = new LadderResult(result);
        resultView.result(ladderManage, ladderResult);

        String playerNames = InputView.resultPlayer();
        Laddering laddering = ladderManage.play(playerNames);
        List<PlayResult> playResult = laddering.playerResult(ladderResult);
        resultView.resultPlay(playResult);

        String playerNames2 = InputView.resultPlayer();
        Laddering laddering2 = ladderManage.play(playerNames2);
        List<PlayResult> playResult2 = laddering2.playerResult(ladderResult);
        resultView.resultPlay(playResult2);

    }

}
