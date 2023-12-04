package ladder.controller;


import ladder.domain.*;
import ladder.strategy.RandomRowStrategy;
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
        Players players = Players.of(inputView.readName());
        Prizes prizes = Prizes.of(inputView.readPrize());
        LadderSize ladderSize = LadderSize.of(players, inputView.readHeight());
        Ladder ladder = Ladder.from(ladderSize, new RandomRowStrategy());

        PlayLadder playLadder = PlayLadder.of(players, prizes, ladder);
        outputView.printLadder(playLadder);

        LadderResults ladderResults = playLadder.moveResult();

        outputView.printLadderResult(ladderResults.values(), inputView.resultType());
    }
}
