package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.PositiveNumber;
import nextstep.ladder.domain.ResultRow;
import nextstep.ladder.domain.Users;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

public class LadderRunner {
    public static void main(String[] args) {
        Users users = Users.from(InputView.readUserNames());
        ResultRow resultRow = new ResultRow(InputView.readGameResult());
        PositiveNumber height = new PositiveNumber(InputView.readLadderHeight());
        LadderGame ladderGame = new LadderGame(users, height, resultRow);
        ResultView.printLadder(ladderGame);
    }
}
