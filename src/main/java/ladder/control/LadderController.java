package ladder.control;

import ladder.domain.LadderRender;
import ladder.domain.Users;
import ladder.present.Presenter;

public class LadderController {
    public static void main(String[] args) {
        Presenter presenter = new Presenter();

        Users users = presenter.users();
        int row = presenter.ladderHeight();
        int column = users.count();
        LadderRender ladderRender = new LadderRender(column, row);

        presenter.renderingLadder(users.names(), ladderRender);
    }
}
