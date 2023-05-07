package ladder.control;

import ladder.domain.Ladder;
import ladder.domain.Users;
import ladder.present.Presenter;

public class LadderController {
    public static void main(String[] args) {
        Presenter presenter = new Presenter();

        Users users = presenter.users();
        int height = presenter.ladderHeight();
        int width = users.count();
        Ladder ladder = new Ladder(height,width);

        presenter.renderingLadder(users.names(),ladder);
    }
}
