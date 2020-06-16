package nextstep.step2;

import nextstep.step2.domain.LadderGenerator;
import nextstep.step2.view.InputView;
import nextstep.step2.view.ResultView;

import java.util.List;

public class LadderGameStarter {
    public static void main(String[] args) throws Exception {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Validator validator = new Validator();

        List<String> userNames = validator.checkUserNameLength(inputView.getUserNames());
        int ladderHeight = validator.checkLadderHeight(inputView.getLadderHeight());

        LadderGenerator ladderGenerator = new LadderGenerator(userNames.size(), ladderHeight);
        resultView.showResult(userNames, ladderGenerator.getLadder());
    }
}
