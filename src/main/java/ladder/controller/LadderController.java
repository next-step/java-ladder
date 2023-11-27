package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.PlayLadder;
import ladder.domain.Players;
import ladder.domain.Prizes;
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
        PlayLadder playLadder = play(inputView.readName(), inputView.readPrize(), inputView.readHeight());
        outputView.printLadder(playLadder);
    }

    private PlayLadder play(List<String> nameList, List<String> prizeList, long height) {
        Players players = Players.of(nameList);
        Prizes prizes = Prizes.of(prizeList);

        LadderSize ladderSize = LadderSize.of(players, height);
        Ladder ladder = Ladder.of(ladderSize, new RandomPathStrategy());

        return PlayLadder.of(players, prizes, ladder);
    }
}
