package ladder.domain.result;

import ladder.domain.position.MovedPositions;
import ladder.domain.reward.Rewards;
import lombok.Builder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameResults {

    private final List<GameResult> gameResults;

    @Builder
    private GameResults(Rewards rewards, MovedPositions positions) {
        this.gameResults = generateResult(rewards, positions);
    }

    public List<GameResult> getGameResults() {
        return Collections.unmodifiableList(gameResults);
    }

    private List<GameResult> generateResult(Rewards rewards, MovedPositions positions) {
        return positions.getPositions()
                .stream()
                .map(position -> GameResult.builder()
                        .name(position.getName())
                        .reward(rewards.getNameByPosition(position.getFinalPosition()))
                        .build())
                .collect(Collectors.toList());
    }
}
