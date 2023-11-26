package nextstep.step4.inout;

import nextstep.step4.inout.domain.Ladder;
import nextstep.step4.inout.domain.LadderHeight;
import nextstep.step4.inout.domain.UserData;
import nextstep.step4.inout.input.Input;
import nextstep.step4.inout.result.Result;

public class Main {
    public static void main(String[] args) {
        final UserData userData = Input.inputLadderUserData();
        final LadderHeight ladderHeight = Input.inputLadderHeight();

        Ladder ladder = new Ladder(userData, ladderHeight);
        Result.printMakingLadderResult(ladder);

        Result.printLadderRunResult(ladder.run());
    }
}
