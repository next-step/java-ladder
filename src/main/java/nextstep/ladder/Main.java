package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Users users = UserInputView.enter();
        LadderHeight ladderHeight = LadderHeightInputView.enter();

        LadderGoals ladderGoals = LadderGoalInputView.enter();

        Ladder ladder = new Ladder(users, ladderHeight, ladderGoals, new RandomDirectionStrategy());
        LadderStatePrintView.print(ladder, users, ladderGoals);

        String key = SelectUserInputView.enter();
        List<LadderResult> ladderResults = ladder.start(key, users);
        LadderResultView.print(ladderResults);

    }

}
