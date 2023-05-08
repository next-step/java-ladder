package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Members;
import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.ResultMatch;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGame {
    public static void main(String[] args) {
        Members members = InputView.members();
        Result result = InputView.result(members.countOfMember());
        int height = InputView.ladderHeight();

        Ladder ladder = new Ladder(members, height);

        OutputView.endMessage();
        OutputView.ladderResult(members, ladder);
        OutputView.runResult(result);

        ResultMatch resultMatch = new ResultMatch(result, ladder);

        String memberName = InputView.match();
        OutputView.gameResult(resultMatch, members, memberName);
    }
}
