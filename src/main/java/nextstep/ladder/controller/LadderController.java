package nextstep.ladder.controller;

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
        List<String> ladderReward = inputView.askLadderReward(players.size());
        int height = inputView.askLadderHeight();

        Ladder ladder = Ladder.of(height, players.size());

        outputView.print(players, ladder, ladderReward);

        LadderGame ladderGame = new LadderGame(ladder, players);
        List<Player> playerResult = ladderGame.result();

        String name = "";
        while (!ALL.equals(name)) {
            name = inputView.askPlayerNameToConfirm();
            outputView.printResultBy(ladderReward, playerResult, name);
        }
    }

    private List<Player> toPlayer(List<String> names) {
        return IntStream.range(0, names.size())
                .mapToObj(idx -> new Player(names.get(idx), idx))
                .collect(toList());
    }
}
