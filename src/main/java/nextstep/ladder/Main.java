package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Users users = UserInputView.enter();
        LadderHeight ladderHeight = LadderHeightInputView.enter();
        LadderGoals ladderGoals = LadderGoalInputView.enter();
        Ladder ladder = new Ladder(users, ladderHeight, new RandomDirectionStrategy());
        LadderStatePrintView.print(ladder, users, ladderGoals);

        String key = SelectUserInputView.enter();
        LadderResults ladderResults = ladder.start(users, ladderGoals);
        LadderResultView.print(key, ladderResults);

    }

}
