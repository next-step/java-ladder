package nextstep.ladder.controller;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.Collectors;
import nextstep.ladder.model.GameResult;
import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Player;
import nextstep.ladder.model.Players;
import nextstep.ladder.model.PlayersGameResult;
import nextstep.ladder.model.RandomLineGenerator;
import nextstep.ladder.model.RowLineFactory;
import nextstep.ladder.model.ScoreCalculator;
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
        GameResult gameResult = getGameResult();
        Ladder ladder = getLadder(players);

        outputLadder(players, ladder, gameResult);

        PlayersGameResult playersGameResult = ScoreCalculator.of(players, ladder).playersGameResult();
        resultView.outputInitResultOfPlayer();
        initPlayerLoop(players, playersGameResult, gameResult);
    }

    private void initPlayerLoop(Players players, PlayersGameResult playersGameResult, GameResult gameResult) {
        String currentPlayerName = inputView.initResult();

        while (!"all".equals(currentPlayerName)) {
            resultView.outputInitResultOfPlayer();
            Player player = players.findPlayer(currentPlayerName);
            String resultByPlayer = playersGameResult.findResultByPlayer(player, gameResult);
            resultView.outputPlayersResult(player, resultByPlayer);
            currentPlayerName = inputView.initResult();
        }

        players.list().forEach(player -> {
            String resultByPlayer = playersGameResult.findResultByPlayer(player,
                gameResult);
            resultView.outputPlayersResult(player, resultByPlayer);
        });
    }


    private void outputLadder(Players players, Ladder ladder, GameResult gameResult) {
        resultView.outputPlayers(players);
        resultView.outputLadder(ladder);
        resultView.outputGameResult(gameResult);
    }

    private GameResult getGameResult() {
        resultView.outputInitGameResult();
        String origin = inputView.initGameResult();
        return GameResult.of(origin);
    }

    private Ladder getLadder(Players players) {
        resultView.outputInitLadderHeight();
        int ladderHeight = inputView.initLadderHeight();
        return Ladder.of(ladderHeight,
            RowLineFactory.from(randomLineGenerator, players.list().size()));
    }

    private Players getPlayers() {
        resultView.outputInitPlayers();
        String playersString = inputView.initPlayers();
        return Players.from(Arrays.stream(playersString.split(",")).collect(Collectors.toList()));
    }
}
