package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.PositiveNumber;
import nextstep.ladder.domain.Users;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

public class LadderRunner {
    public static void main(String[] args) {
        Users users = InputView.readUsers();
        PositiveNumber height = InputView.readLadderHeight();

        LadderGame ladderGame = new LadderGame(users, height);

        ResultView.printGameResult(ladderGame);
    }
}
