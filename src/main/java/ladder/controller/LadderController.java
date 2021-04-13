package ladder.controller;

import ladder.domain.engine.*;
import ladder.domain.factory.LadderFactoryBean;
import ladder.domain.nextstep.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderController {

    private Players players;
    private ExecutionResults executionResults;
    private Ladder ladder;
    private LadderResults ladderResults;
    private final static Map<NextStepPoint, String> printPoints = new HashMap<>();
    private final static String ALL_PLAYERS = "all";

    static {
        printPoints.put(NextStepPoint.LEFT, "--|");
        printPoints.put(NextStepPoint.DOWN, "     |");
        printPoints.put(NextStepPoint.RIGHT, "     |---");
    }

    public LadderController() {
        players = new Players(InputView.enterPlayers());
        executionResults = new ExecutionResults(players.numberOfPlayer(), InputView.enterExecutionResults());
        ladder = LadderFactoryBean.LadderFactory().generateLadder(players.numberOfPlayer(), InputView.enterHeight());
    }

    private void printPlayers() {
        List<String> playersList = players.players()
                .stream()
                .map(player -> player.name())
                .collect(Collectors.toList());
        ResultView.printPlayers(playersList);
    }

    private void printLine(Line line) {
        line.points()
                .forEach(point -> ResultView.printPoint(printPoints.get(point)));
        ResultView.printEmptyLine();
    }

    private void printLadder() {
        ladder.lines()
                .stream()
                .forEach(this::printLine);
    }

    private void printResult() {
        ResultView.printResult(executionResults.executionResults());
    }

    private void printExecutionResult() {
        String playerName = InputView.enterPlayerYouWant();
        Map<String, String> results;
        if (playerName.equalsIgnoreCase(ALL_PLAYERS)) {
            results = ladderResults.resultsOfAll();
            ResultView.printExecutionResult(results);
            return;
        }
        results = ladderResults.results(new Player(playerName));
        ResultView.printExecutionResult(results);
    }

    public void run() {
        printPlayers();
        printLadder();
        printResult();

        ladderResults = ladder.ladderResults(players, executionResults);
        printExecutionResult();
        printExecutionResult();
    }
}
