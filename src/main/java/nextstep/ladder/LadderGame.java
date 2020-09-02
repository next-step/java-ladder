package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {

    public static void main(String[] args) {
        String joinUsers = InputView.inputGameUser();

        Users users = Users.from(User.generateUsers(joinUsers));
        int countOfUser = users.size();

        int height = InputView.inputLadderHeight();
        LadderLine ladderLine = LadderLine.of(height, countOfUser, new LadderAutoGenerator());

        ResultView.printGameResult(users.getUsers(), ladderLine);
    }
}
