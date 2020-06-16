package nextstep.step2;

import nextstep.step2.domain.GenerateLadder;
import nextstep.step2.view.InputView;
import nextstep.step2.view.ResultView;

import java.util.List;

public class LadderGameStarter {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Validator validator = new Validator();

        List<String> userNames = validator.userNameLengthIsUnderFive(inputView.getUserNames());
        int ladderHeight = validator.checkLadderHeight(inputView.getLadderHeight());

        GenerateLadder generateLadder = new GenerateLadder(userNames.size(), ladderHeight);
        resultView.showResult(userNames, generateLadder.getLadder());
    }
}
