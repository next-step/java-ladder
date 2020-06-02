package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameResults {
    private List<GameResult> values;

    private GameResults(List<GameResult> gameResultList) {
        this.values = new ArrayList<>(gameResultList);
    }

    public static GameResults create(Players players, Rewards rewards) {
        List<GameResult> gameResultList = IntStream.range(0, players.size())
                .mapToObj(num -> new GameResult(players.getPlayerOfLocation(num), rewards.getByIndex(num)))
                .collect(Collectors.toList());

        return new GameResults(gameResultList);
    }
}
