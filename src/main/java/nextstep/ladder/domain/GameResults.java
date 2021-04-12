package nextstep.ladder.domain;

import nextstep.ladder.views.InputView;
import nextstep.ladder.views.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class GameResults {
    private final static String ALL_RESULT = "all";
    private final List<GameResult> gameResults;

    private GameResults(LadderResults ladderResults, Players players) {
        this.gameResults = createResults(ladderResults, players);
    }

    private List<GameResult> createResults(LadderResults ladderResults, Players players) {
        return players.players()
                .stream()
                .map(player -> createPlayerResult(ladderResults, player))
                .collect(Collectors.toList());
    }

    private GameResult createPlayerResult(LadderResults ladderResults, Player player) {
        String reward = ladderResults.getLadderResult(player.position());
        return new GameResult(player.name(), reward);
    }

    private GameResult getPlayerResult(String name) {
        return gameResults.stream()
                .filter(gameResult -> gameResult.name().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("참가자 이름을 확인해 주세요."));
    }

    public void showPlayerResults() {
        String name = InputView.choosePlayerResult();
        while(!isAllResult(name)) {
            GameResult gameResult = getPlayerResult(name);
            ResultView.showPlayerResult(gameResult);
            name = InputView.choosePlayerResult();
        }
        ResultView.showAllResults(gameResults);
    }

    private boolean isAllResult(String value) {
        return value.equals(ALL_RESULT);
    }

    public static GameResults of(LadderResults ladderResults, Players players) {
        return new GameResults(ladderResults, players);
    }
}
