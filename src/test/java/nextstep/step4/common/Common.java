package nextstep.step4.common;

import nextstep.step4.domain.Ladder;
import nextstep.step4.domain.LadderHeight;
import nextstep.step4.domain.UserData;
import nextstep.step4.domain.UserInputTexts;

public class Common {
    public static Ladder makeDefaultLadder() {
        final UserData userData = new UserData(
                new UserInputTexts("pobi,honux,crong,jk"),
                new UserInputTexts("꽝,5000,꽝,3000")
        );
        final LadderHeight ladderHeight = new LadderHeight(5);

        return new Ladder(userData, ladderHeight);
    }
}
