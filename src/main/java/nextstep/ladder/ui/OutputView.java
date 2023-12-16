package nextstep.ladder.ui;

import nextstep.ladder.domain.JoinMembers;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.ui.dto.LadderResponse;
import nextstep.ladder.ui.dto.MembersResponse;

public class OutputView {
    public static void outputLadderGame(LadderGame ladderGame) {
        outputMembers(ladderGame.getJoinMembers());
        outputLadder(ladderGame.getLadder());
    }

    private static void outputMembers(JoinMembers joinMembers) {
        System.out.println(MembersResponse.from(joinMembers).getResponse());
    }

    private static void outputLadder(Ladder ladder) {
        System.out.println(LadderResponse.from(ladder).getResponse());
    }
}
