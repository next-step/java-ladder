package domain.ladder;

import view.console.InputView;
import view.console.ResultView;

public class PlayLadder {
    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        LadderManage ladderManage = new LadderManage(InputView.names(), InputView.ladderCount());
        resultView.result(ladderManage.getPlayers(), ladderManage.getLines());
    }

}
