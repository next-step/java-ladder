package nextstep.ladder;

import nextstep.ladder.view.inputView;

import static nextstep.ladder.view.ResultView.resultJoinMember;
import static nextstep.ladder.view.inputView.inputJoinMember;
import static nextstep.ladder.view.inputView.inputLadderCount;

public class LadderApplication {
    public static void main(String[] args) {
        String joinMember = inputJoinMember();
        resultJoinMember(joinMember);
        int ladderCount = inputLadderCount();
    }
}
