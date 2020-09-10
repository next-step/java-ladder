package nextstep.ladder;

import nextstep.ladder.domain.line.LadderLineGenerator;
import nextstep.ladder.domain.line.LadderLines;
import nextstep.ladder.domain.point.RightPointRandomStrategy;
import nextstep.ladder.domain.result.LadderResult;
import nextstep.ladder.domain.user.UserGenerator;
import nextstep.ladder.domain.user.Users;

public class LadderAdministrator {

    private LadderAdministrator() {
    }

    public static Users userManagement(String joinUsers) {
        return Users.from(UserGenerator.generateUsers(joinUsers));
    }

    public static LadderResult ladderResultManagement(Users users) {
        return new LadderResult(users.getUsers());
    }

    public static LadderLines ladderLinesManagement(LadderResult ladderResults, int height, int countOfUser) {
        LadderLines ladderLines = LadderLineGenerator.generateLadderLine(height, countOfUser, new RightPointRandomStrategy());
        ladderLines.goDownALadder(ladderResults.getLadderResult());
        return ladderLines;
    }
}
