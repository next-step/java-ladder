package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.MatchResult;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        Ladder ladder = new Ladder(inputView.people(), inputView.executeResults(), inputView.height());
        ResultView.printResult(ladder);

        MatchResult matchResult = new MatchResult(ladder);

        matchResult.result("pobi");

        inputView.close();
    }
}
