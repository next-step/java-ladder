package nextstep.ladder.controller;

import nextstep.ladder.dto.LadderResult;
import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.LadderGame;
import nextstep.ladder.model.Player;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LadderController {
    private static final String ALL = "all";

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<Player> players = toPlayer(inputView.askNames());
        List<String> reward = inputView.askLadderReward(players.size());
        int height = inputView.askLadderHeight();

        Ladder ladder = Ladder.of(height, players.size());

        outputView.print(players, ladder, reward);

        LadderGame ladderGame = new LadderGame(ladder, players);
        List<Player> movedPlayer = ladderGame.move();

        confirmResult(new LadderResult(movedPlayer, reward));
    }

    private List<Player> toPlayer(List<String> names) {
        return IntStream.range(0, names.size())
                .mapToObj(idx -> new Player(names.get(idx), idx))
                .collect(toList());
    }

    private void confirmResult(LadderResult ladderResult) {
        String name = "";
        while (!ALL.equals(name)) {
            name = inputView.askPlayerNameToConfirm();
            outputView.printResultBy(ladderResult, name);
        }
    }
}
