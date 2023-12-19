package nextstep.ladder.ui;

import nextstep.ladder.domain.JoinMembers;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.ui.dto.LadderResponse;
import nextstep.ladder.ui.dto.MembersResponse;

public class OutputView {

    public static void outputLadder(Ladder ladder) {
        outputMembers(ladder.getJoinMembers());
        System.out.println(LadderResponse.from(ladder).getResponse());
    }

    private static void outputMembers(JoinMembers joinMembers) {
        System.out.println(MembersResponse.from(joinMembers).getResponse());
    }
}
