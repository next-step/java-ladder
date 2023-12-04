package ladder2.controller;


import ladder2.domain.*;
import ladder2.strategy.RandomRowStrategy;
import ladder2.view.InputView;
import ladder2.view.OutputView;

import java.util.Map;
import java.util.stream.Collectors;

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

        ladder.move(players);

        outputView.printLadderResult(ladderResults(players, prizes), inputView.resultType());
    }

    public Map<String, LadderResult> ladderResults(Players players, Prizes prizes) {
        return players.players()
                .stream()
                .map(player -> new LadderResult(player.name(), prizes.value(player.position())))
                .collect(Collectors.toMap(LadderResult::playerName, ladderResult -> ladderResult));
    }
}
