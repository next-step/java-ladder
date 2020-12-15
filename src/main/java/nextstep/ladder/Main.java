package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Users users = UserInputView.enter();
        LadderHeight ladderHeight = LadderHeightInputView.enter();

        LadderGoalBoard ladderGoalBoard = LadderGoalInputView.enter();

        LadderGame ladderGame = new LadderGame(users, ladderHeight, ladderGoalBoard);

        LadderStatePrintView.print(ladderGame);

        String key = SelectUserInputView.enter();
        List<LadderResult> ladderResults = ladderGame.start(key);
        LadderResultView.print(ladderResults);

    }

}
