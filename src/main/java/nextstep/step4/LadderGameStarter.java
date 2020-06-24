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
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Validator validator = new Validator();

        List<String> userNames = validator.checkUserNameLength(inputView.getUserNames());
        List<String> playResult = validator.checkPlayResult(userNames, inputView.getPlayResult());
        int ladderHeight = validator.checkLadderHeight(inputView.getLadderHeight());

        Ladder ladder = new Ladder(userNames.size(), ladderHeight, new RandomDrawLineStrategy());
        resultView.showLadderResult(userNames, ladder);
        resultView.showPlayResult(playResult);

        Map<String, User> resultMap =  ladder.getLadderGameResult(userNames, playResult);

        while (true) {
            String userName = validator.checkUserNameForResult(inputView.getUserNameForResult(), resultMap);
            if (userName.equals("all")) {
                resultView.showAllResult(resultMap);
                System.exit(0);
            }
            resultView.showUserResult(resultMap.get(userName));
        }
    }
}
