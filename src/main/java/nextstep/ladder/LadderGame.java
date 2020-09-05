package nextstep.ladder;

import nextstep.ladder.domain.ladderline.LadderGenerator;
import nextstep.ladder.domain.ladderline.LadderLine;
import nextstep.ladder.domain.point.RightPointRandomStrategy;
import nextstep.ladder.domain.user.UserGenerator;
import nextstep.ladder.domain.user.Users;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {

    public static void main(String[] args) {
        String joinUsers = InputView.inputGameUser();

        Users users = Users.from(UserGenerator.generateUsers(joinUsers));
        int countOfUser = users.size();

        String ladderResult = InputView.inputLadderResult();

        int height = InputView.inputLadderHeight();
        LadderLine ladderLine = LadderGenerator.generateLadderLine(height, countOfUser, new RightPointRandomStrategy());

        ResultView.printGameResult(users.getUsers(), ladderLine);
    }
}
