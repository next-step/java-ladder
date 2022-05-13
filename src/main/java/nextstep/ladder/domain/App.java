package nextstep.ladder.domain;

import nextstep.ladder.domain.factory.UsersFactory;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

public class App {
    public static void main(String[] args) {
        Users users = UsersFactory.newInstance(InputView.getUserNames());
        Ladder ladder = new LadderMaker(new LineMakerImpl(users.size())).makeLadder(InputView.getLadderHeight());
        ResultView.printResult(users, ladder);
    }
}
