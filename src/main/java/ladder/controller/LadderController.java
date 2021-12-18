package ladder.controller;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderComponentDto;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.result.ExecutionResults;
import ladder.domain.user.LadderPlayers;
import ladder.strategy.LineStrategy;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Map;

public class LadderController {

    public static final String ALL_RESULTS = "all";

    private final LineStrategy lineStrategy;

    public LadderController(LineStrategy lineStrategy) {
        this.lineStrategy = lineStrategy;
    }

    public void start() {
        LadderPlayers players = new LadderPlayers(InputView.printInputNames());
        ExecutionResults items = new ExecutionResults(InputView.printInputItems());
        LadderHeight height = new LadderHeight(InputView.printInputLadderHeight());

        Ladder ladder = Ladder.createLadder(lineStrategy, new LadderComponentDto(players, height));

        ResultView.printLadderResult(players.getPlayers(), ladder.getLines());
        ResultView.printItems(items);

        Map<String, String> result = items.executeGame(players, ladder);
        printGameResults(players, result);
    }

    private void printGameResults(LadderPlayers players, Map<String, String> result) {
        String targetName = InputView.printInputFindPlayer();

        if (isAll(targetName)) {
            ResultView.printResults(players.getPlayerNames(), result);
            return;
        }

        String findName = players.findByName(targetName);
        ResultView.printSingleResult(result.get(findName));

        printGameResults(players, result);
    }

    private boolean isAll(String wantedName) {
        return wantedName.equalsIgnoreCase(ALL_RESULTS);
    }

}
