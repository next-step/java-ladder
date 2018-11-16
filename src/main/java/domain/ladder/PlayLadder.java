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
        resultView.result(ladderManage, ladderResult.getResults());

        InputView.resultPlayer();
    }

}
