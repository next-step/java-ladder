package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.PlayLadder;
import ladder.domain.Players;
import ladder.domain.Prizes;
import ladder.strategy.RandomPathStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        PlayLadder playLadder = initialize();
        outputView.printLadder(playLadder);
        outputView.printLadderResult(playLadder.move(), inputView.resultType());
    }

    private PlayLadder initialize() {
        Players players = Players.of(inputView.readName());
        Prizes prizes = Prizes.of(inputView.readPrize());

        LadderSize ladderSize = LadderSize.of(players, inputView.readHeight());
        Ladder ladder = Ladder.of(ladderSize, new RandomPathStrategy());

        return PlayLadder.of(players, prizes, ladder);
    }

}
