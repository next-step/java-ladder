package ladder.control;

import ladder.domain.Ladder;
import ladder.domain.Users;
import ladder.present.Presenter;

public class LadderController {
    public static void main(String[] args) {
        Presenter presenter = new Presenter();

        Users users = presenter.users();
        int row = presenter.ladderHeight();
        int column = users.count();
        Ladder ladder = new Ladder(column, row);

        presenter.renderingLadder(users.names(), ladder);
    }
}
