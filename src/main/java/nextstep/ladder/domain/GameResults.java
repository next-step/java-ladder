package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.InvalidGameResultParameterException;

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
        validate(players.size(), rewards.size());
        List<GameResult> gameResultList = IntStream.range(0, players.size())
                .mapToObj(num -> new GameResult(players.getPlayerOfLocation(num), rewards.getByIndex(num)))
                .collect(Collectors.toList());

        return new GameResults(gameResultList);
    }

    private static void validate(int playersSize, int rewardsSize) {
        if (playersSize != rewardsSize) {
            throw new InvalidGameResultParameterException("Players size and rewards size must equal");
        }
    }
}
