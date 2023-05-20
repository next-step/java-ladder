package ladder.control;

import ladder.domain.Lines;
import ladder.domain.Renderer;
import ladder.domain.Scene;
import ladder.domain.Users;
import ladder.present.Presenter;

public class LadderController {
    public static void main(String[] args) {
        Presenter presenter = new Presenter();
        Users users = presenter.users();

        int row = presenter.ladderHeight();
        int column = users.count();

        Lines lines = Lines.of(column, row);
        Scene scene = new Renderer(column, row, lines, users)
                .renderingSceneWithUser();
        presenter.renderingLadder(scene);
    }
}
