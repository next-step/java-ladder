package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.RandomLinesGenerator;
import nextstep.ladder.domain.Users;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        Users users = Users.toUsers(InputView.askUserNames());
        Ladder ladder = new Ladder(new RandomLinesGenerator(),
                users.userCount(),
                InputView.askHeight());
        OutputView.drawLadder(ladder, users);
    }
}
