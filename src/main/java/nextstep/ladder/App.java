package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderMaker;
import nextstep.ladder.domain.LineMakerImpl;
import nextstep.ladder.domain.Users;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

public class App {
    public static void main(String[] args) {
        Users users = new Users(InputView.getUserNames());
        Ladder ladder = new LadderMaker(new LineMakerImpl(users.size())).makeLadder(InputView.getLadderHeight());
        ResultView.printResult(users, ladder);
    }
}
