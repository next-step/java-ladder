package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGameManager;
import nextstep.ladder.domain.LadderGenerator;
import nextstep.ladder.domain.Users;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();
        ladderGame.playLadderGame();
    }

    private void playLadderGame() {
        LadderGameManager ladderGameManager = inputView.inputLadderGameManager();

        Users users = Users.create(ladderGameManager.getUsers());

        LadderGenerator ladderGenerator = LadderGenerator.create(users.size(), ladderGameManager.getLadderHeight());
        Ladder ladder = ladderGenerator.make();

        resultView.showLadderGameResult(users, ladder);
    }
}
