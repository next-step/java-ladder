package nextstep.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameResults {
    private final List<GameResult> gameResults;

    private GameResults(LadderResult ladderResult, Players players) {
        this.gameResults = createResults(ladderResult, players);
    }

    private List<GameResult> createResults(LadderResult ladderResult, Players players) {
        return players.players()
                .stream()
                .map(player -> createPlayerResult(ladderResult, player))
                .collect(Collectors.toList());
    }

    private GameResult createPlayerResult(LadderResult ladderResult, Player player) {
        String reward = ladderResult.ladderResult(player.position());
        return new GameResult(player.name(), reward);
    }

    public static GameResults of(LadderResult ladderResult, Players players) {
        return new GameResults(ladderResult, players);
    }

    public GameResult getPlayerResult(String name) {
        return gameResults.stream()
                .filter(gameResult -> gameResult.name().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("참가자 이름을 확인해 주세요."));
    }

    public List<GameResult> gameResults() {
        return Collections.unmodifiableList(gameResults);
    }
}