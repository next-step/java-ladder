package nextstep.ladder.domain.gameresult;

import nextstep.ladder.domain.exceptions.InvalidGameResultParameterException;
import nextstep.ladder.domain.ladder.HorizontalLocation;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.reward.Reward;
import nextstep.ladder.domain.reward.Rewards;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class GameResults {
    private Map<String, Reward> values;

    private GameResults(Map<String, Reward> gameResultList) {
        this.values = Collections.unmodifiableMap(gameResultList);
    }

    public static GameResults create(Players players, Rewards rewards) {
        validate(players.size(), rewards.size());

        Map<String, Reward> resultMap = new HashMap();

        IntStream.range(0, players.size())
                .forEach(num -> resultMap.put(
                        players.getPlayerOfLocation(new HorizontalLocation(num, players.size())).getName(),
                        rewards.getByIndex(num)));

        return new GameResults(resultMap);
    }

    public Reward findByPlayerName(String playerName) {
        return this.values.get(playerName);
    }

    public Map<String, Reward> getValues() {
        return this.values;
    }

    private static void validate(int playersSize, int rewardsSize) {
        if (playersSize != rewardsSize) {
            throw new InvalidGameResultParameterException("Players size and rewards size must equal");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResults that = (GameResults) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
