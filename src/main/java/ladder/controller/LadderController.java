package ladder.controller;

import ladder.config.LadderConfig;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.result.ExecutionResults;
import ladder.domain.user.LadderPlayers;
import ladder.generator.LadderGenerator;
import ladder.strategy.PlayResult;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Map;

public class LadderController {

    public static final String ALL_RESULTS = "all";

    private final LadderConfig config;

    public LadderController(LadderConfig config) {
        this.config = config;
    }

    public void start() {
        LadderPlayers players = new LadderPlayers(InputView.printInputNames());
        ExecutionResults items = new ExecutionResults(InputView.printInputItems());
        LadderHeight height = new LadderHeight(InputView.printInputLadderHeight());

        LadderGenerator ladderGenerator = config.ladderGenerator(height);
        Ladder ladder = ladderGenerator.generate(players.size());

        ResultView.printLadderResult(players.getPlayers(), ladder.getLines());
        ResultView.printItems(items);

        PlayResult playResult = config.playResult(ladder);
        Map<String, String> result = playResult.play(players, items);

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
