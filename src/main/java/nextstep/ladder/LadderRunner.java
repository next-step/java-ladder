package nextstep.ladder;

import nextstep.ladder.domain.GameResult;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.PositiveNumber;
import nextstep.ladder.domain.ResultLine;
import nextstep.ladder.domain.Users;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

public class LadderRunner {
    public static void main(String[] args) {
        Users users = Users.from(InputView.readUserNames());
        ResultLine resultLine = new ResultLine(InputView.readGameResult());
        PositiveNumber height = new PositiveNumber(InputView.readLadderHeight());
        LadderGame ladderGame = new LadderGame(users, height, resultLine);
        ResultView.printLadder(ladderGame);

        GameResult gameResult = ladderGame.start(InputView.readUserName());
        ResultView.printResult(gameResult);
    }
}
