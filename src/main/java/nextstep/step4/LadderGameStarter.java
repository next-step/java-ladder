package nextstep.step4;

import nextstep.step4.domain.Ladder;
import nextstep.step4.domain.User;
import nextstep.step4.domain.strategy.RandomDrawLineStrategy;
import nextstep.step4.view.InputView;
import nextstep.step4.view.ResultView;

import java.util.List;
import java.util.Map;

public class LadderGameStarter {
    public static void main(String[] args) {
        List<String> userNames = Validator.checkUserNameLength(InputView.getUserNames());
        List<String> playResult = Validator.checkPlayResult(userNames, InputView.getPlayResult());
        int ladderHeight = Validator.checkLadderHeight(InputView.getLadderHeight());

        Ladder ladder = new Ladder(userNames.size(), ladderHeight, new RandomDrawLineStrategy());
        ResultView.showLadderResult(userNames, ladder);
        ResultView.showPlayResult(playResult);

        Map<String, User> resultMap =  ladder.getLadderGameResult(userNames, playResult);
        ResultView.showFinalResult(resultMap);
    }
}
