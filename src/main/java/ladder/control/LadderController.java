package ladder.control;

import ladder.domain.Ladder;
import ladder.domain.Results;
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
    Results results = presenter.results(users, ladder);
    Scene scene = Renderer.of(ladder, users, results).renderingScene();
    presenter.renderingLadder(scene);
    presenter.renderingResults(scene, results);
    presenter.renderingResults(scene, results);
  }
}
