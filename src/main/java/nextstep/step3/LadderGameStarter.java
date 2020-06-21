package nextstep.step3;

import nextstep.step3.domain.Ladder;
import nextstep.step3.domain.LadderGenerator;
import nextstep.step3.domain.User;
import nextstep.step3.utils.LadderUtils;
import nextstep.step3.view.InputView;
import nextstep.step3.view.ResultView;

import java.util.List;
import java.util.Map;

public class LadderGameStarter {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Validator validator = new Validator();

        List<User> users = validator.checkUserNameLength(inputView.getUserNames());
        List<String> playResult = validator.checkPlayResult(users, inputView.getPlayResult());
        int ladderHeight = validator.checkLadderHeight(inputView.getLadderHeight());

        LadderGenerator ladderGenerator = new LadderGenerator(users.size(), ladderHeight);
        Ladder ladder = ladderGenerator.getLadder();
        resultView.showLadderResult(users, ladder);
        resultView.showPlayResult(playResult);

        Map<String, User> resultMap =  LadderUtils.getMappingResult(users, playResult, ladder.getLadderGameResult());

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
