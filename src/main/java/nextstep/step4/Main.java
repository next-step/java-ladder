package nextstep.step4;

import nextstep.step4.domain.Ladder;
import nextstep.step4.domain.LadderHeight;
import nextstep.step4.domain.LadderResult;
import nextstep.step4.domain.UserData;
import nextstep.step4.input.Input;
import nextstep.step4.result.Result;

public class Main {
    public static void main(String[] args) {
        final UserData userData = Input.inputLadderUserData();
        final LadderHeight ladderHeight = Input.inputLadderHeight();

        Ladder ladder = new Ladder(userData, ladderHeight);
        Result.printMakingLadderResult(ladder);

        final LadderResult ladderResult = ladder.run();
    }
}
