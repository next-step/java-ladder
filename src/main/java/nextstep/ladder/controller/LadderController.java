package nextstep.ladder.controller;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.Collectors;
import nextstep.ladder.model.GameResult;
import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.LineFactory;
import nextstep.ladder.model.Players;
import nextstep.ladder.model.RandomLineGenerator;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {

    private final InputView inputView;
    private final ResultView resultView;

    private final RandomLineGenerator randomLineGenerator = RandomLineGenerator.getInstance();

    public LadderController(InputStream in, PrintStream out) {
        this.inputView = InputView.from(in);
        this.resultView = ResultView.from(out);
    }

    public static LadderController of(InputStream in, PrintStream out) {
        return new LadderController(in, out);
    }

    public void start() {
        Players players = getPlayers();
        Ladder ladder = getLadder(players);
        GameResult gameResult = getGameResult();

        resultView.outputPlayers(players);
        resultView.outputLadder(ladder);
        resultView.outputGameResult(gameResult);
    }

    private GameResult getGameResult() {
        resultView.outputInitGameResult();
        return GameResult.of(inputView.initGameResult());
    }

    private Ladder getLadder(Players players) {
        resultView.outputInitLadderHeight();
        int ladderHeight = inputView.initLadderHeight();
        return Ladder.of(ladderHeight,
            LineFactory.from(randomLineGenerator, players.list().size()));
    }

    private Players getPlayers() {
        resultView.outputInitPlayers();
        String playersString = inputView.initPlayers();
        return Players.from(Arrays.stream(playersString.split(",")).collect(Collectors.toList()));
    }
}
