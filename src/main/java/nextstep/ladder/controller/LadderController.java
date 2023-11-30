package nextstep.ladder.controller;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.Collectors;
import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {

    private final InputView inputView;
    private final ResultView resultView;

    public LadderController(InputStream in, PrintStream out) {
        this.inputView = InputView.from(in);
        this.resultView = ResultView.from(out);
    }

    public static LadderController of(InputStream in, PrintStream out) {
        return new LadderController(in, out);
    }

    public void start() {
        Players players = getPlayers();
        resultView.outputPlayers(players);

        Ladder ladder = getLadder(players);
        resultView.outputLadder(ladder);
    }

    private Ladder getLadder(Players players) {
        resultView.outputInitLadderHeight();
        int ladderHeight = inputView.initLadderHeight();
        return Ladder.of(ladderHeight, players.list().size());
    }

    private Players getPlayers() {
        resultView.outputInitPlayers();
        String playersString = inputView.initPlayers();
        return Players.from(Arrays.stream(playersString.split(",")).collect(Collectors.toList()));
    }
}
