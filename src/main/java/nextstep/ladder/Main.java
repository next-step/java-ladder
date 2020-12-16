package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Users users = UserInputView.enter();
        LadderHeight ladderHeight = LadderHeightInputView.enter();

        LadderGoals ladderGoals = LadderGoalInputView.enter();

        LadderGame ladderGame = new LadderGame(users, ladderHeight, ladderGoals);

        LadderStatePrintView.print(ladderGame);

        String key = SelectUserInputView.enter();
        List<LadderResult> ladderResults = ladderGame.start(key);
        LadderResultView.print(ladderResults);

    }

}
