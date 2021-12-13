package ladder.controller;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.result.ExecutionResults;
import ladder.domain.user.Players;
import ladder.strategy.LineStrategy;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LadderController {

    public static final String ALL_RESULTS = "all";

    private final LineStrategy lineStrategy;

    public LadderController(LineStrategy lineStrategy) {
        this.lineStrategy = lineStrategy;
    }

    public void start() {
        List<String> names = InputView.printInputNames();
        Players players = new Players(names);
        ExecutionResults results = new ExecutionResults(InputView.printInputItems());
        LadderHeight height = new LadderHeight(InputView.printInputLadderHeight());

        Ladder ladder = createLadder(players, height);
        ResultView.printLadderResult(players.getPlayers(), ladder.getLines(), results.getResults());

        String findPlayer = InputView.printInputFindPlayer();
        List<Integer> indices = executeResult(findPlayer, players, ladder);
        ResultView.printGameResult(players.getPlayers(), results.getResults(), indices);
    }

    private Ladder createLadder(Players players, LadderHeight height) {
        return Ladder.createLadder(lineStrategy, players, height);
    }

    private List<Integer> executeResult(String findPlayer, Players players, Ladder ladder) {
        List<Integer> indices = new ArrayList<>();
        if (findPlayer.equals(ALL_RESULTS)) {
            return addIndices(players, ladder, indices);
        }
        int index = players.findPlayers(findPlayer);
        int position = ladder.move(index + 1);
        indices.add(position);
        return indices;
    }

    private List<Integer> addIndices(Players players, Ladder ladder, List<Integer> indices) {
        for (int index = 0; index < players.size(); index++) {
            int position = ladder.move(index + 1);
            indices.add(position - 1);
        }
        return indices;
    }

}
