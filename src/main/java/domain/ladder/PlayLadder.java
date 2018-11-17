package domain.ladder;

import view.console.InputView;
import view.console.ResultView;

import java.util.List;

public class PlayLadder {
    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        String[] names = InputView.names();
        List<String> result = InputView.result();
        int ladderCount = InputView.ladderCount();
        LadderManage ladderManage = new LadderManage(names, ladderCount);
        LadderResult ladderResult = new LadderResult(result);
        resultView.result(ladderManage, ladderResult);

        Laddering laddering = new Laddering(ladderManage.getPlayers(), ladderManage.getLines());
        String playerNames = InputView.resultPlayer();
        List<PlayResult> playResult = laddering.showResult(playerNames, ladderResult);
        resultView.resultPlay(playResult);
        String playerNames2 = InputView.resultPlayer();
        List<PlayResult> playResult2 = laddering.showResult(playerNames2, ladderResult);
        resultView.resultPlay(playResult2);

    }

}
