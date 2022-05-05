package nextstep.step4;

import nextstep.step4.domain.Ladder;
import nextstep.step4.domain.LadderResult;
import nextstep.step4.domain.Players;
import nextstep.step4.view.InputView;
import nextstep.step4.view.ResultView;

import java.util.List;

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
        
    }

}
