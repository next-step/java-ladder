package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.RandomLinesGenerator;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(InputView.askUserNames(),
                InputView.askResults(),
                InputView.askHeight(),
                new RandomLinesGenerator());

        ladderGame.play();

        OutputView.drawLadder(ladderGame);
        OutputView.drawResult(ladderGame, InputView.askResultUserName());
    }
}
