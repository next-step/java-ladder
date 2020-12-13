package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.LadderGoalBoard;
import nextstep.ladder.domain.LadderHeight;
import nextstep.ladder.domain.Users;
import nextstep.ladder.view.LadderGoalInputView;
import nextstep.ladder.view.LadderHeightInputView;
import nextstep.ladder.view.LadderStatePrintView;
import nextstep.ladder.view.UserInputView;

public class Main {

    public static void main(String[] args) {
        Users users = UserInputView.enter();
        LadderHeight ladderHeight = LadderHeightInputView.enter();

        LadderGoalBoard ladderGoalBoard = LadderGoalInputView.enter();

        LadderGame ladderGame = new LadderGame(users, ladderHeight, ladderGoalBoard);

        LadderStatePrintView.print(ladderGame);
    }

}
