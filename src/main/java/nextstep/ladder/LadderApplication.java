package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Members;

import static nextstep.ladder.view.ResultView.resultLadder;
import static nextstep.ladder.view.inputView.inputJoinMember;
import static nextstep.ladder.view.inputView.inputLadderCount;

public class LadderApplication {
    public static void main(String[] args) {
        Members members = new Members(inputJoinMember());
        Height height = new Height(inputLadderCount());
        Ladder ladder = new Ladder(members, height);

        resultLadder(members.getMembers(), ladder);
    }
}
