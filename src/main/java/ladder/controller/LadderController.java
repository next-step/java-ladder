package ladder.controller;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderComponent;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.result.ExecutionResults;
import ladder.domain.user.LadderPlayers;
import ladder.strategy.LineStrategy;
import ladder.view.InputView;
import ladder.view.ResultView;

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

        Ladder ladder = Ladder.createLadder(lineStrategy, LadderComponent.of(players.size(), height.getHeight()));

        ResultView.printLadderResult(players.getPlayers(), ladder.getLines());
        ResultView.printItems(items);

        ExecutionResults results = items.executeGame(players, ladder);

        printGameResults(players, results);
    }

    private void printGameResults(LadderPlayers players, ExecutionResults results) {
        String wantedName = InputView.printInputFindPlayer();

        if (isAll(wantedName)) {
            ResultView.printResults(players.getPlayerNames(), results.getResults());
            return;
        }

        int findIndexByName = players.findIndexByName(wantedName);
        ResultView.printSingleResult(findIndexByName, results.getResults());

        printGameResults(players, results);
    }

    private boolean isAll(String wantedName) {
        return wantedName.equalsIgnoreCase(ALL_RESULTS);
    }

}
