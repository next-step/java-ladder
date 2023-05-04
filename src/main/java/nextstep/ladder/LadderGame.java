package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Member;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;

public class LadderGame {
    public static void main(String[] args) {
        List<Member> members = InputView.members();
        int height = InputView.ladderHeight();

        Ladder ladder = new Ladder(members.size(), height);

        OutputView.endMessage();
        OutputView.gameResult(members, ladder);
    }
}
