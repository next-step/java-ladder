package ladder.control;

import ladder.domain.Ladder;
import ladder.domain.Scene;
import ladder.domain.Users;
import ladder.present.Presenter;
import ladder.present.Renderer;

public class LadderController {
    public static void main(String[] args) {
        Presenter presenter = new Presenter();
        Users users = presenter.users();

        int row = presenter.ladderHeight();
        int column = users.count();

        Ladder ladder = Ladder.of(column, row);
        Scene scene = new Renderer(column, row, ladder, users)
                .renderingSceneWithUser();
        presenter.renderingLadder(scene);
    }
}
