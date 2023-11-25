package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.PlayLadder;
import ladder.domain.Players;
import ladder.strategy.RandomPathStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        PlayLadder playLadder = play(inputView.readName(), inputView.readHeight());
        outputView.printLadder(playLadder);
    }

    private PlayLadder play(List<String> names, long height) {
        Players players = Players.of(names);
        Ladder ladder = Ladder.of(players.size() - 1, height, new RandomPathStrategy());
        PlayLadder playLadder = PlayLadder.of(players, ladder);
        return playLadder;
    }
}
