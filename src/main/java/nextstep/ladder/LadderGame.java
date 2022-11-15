package nextstep.ladder;

import java.util.List;
import java.util.Random;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {
    private final ResultView resultView;
    private final Ladder ladder;

    public LadderGame(final InputView inputView, final ResultView resultView) {
        this.resultView = resultView;

        final List<Player> players = inputView.inputPlayers();
        final Height height = inputView.inputLadderHeight();

        final Random random = new Random();
        this.ladder = new Ladder(players, height, random::nextBoolean);
    }

    public void printLadder() {
        this.resultView.writeLadder(this.ladder);
    }
}
