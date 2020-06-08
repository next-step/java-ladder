package nextstep.ladder.domain.gameresult;

import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.reward.Rewards;
import nextstep.ladder.domain.exceptions.InvalidGameResultParameterException;
import nextstep.ladder.domain.exceptions.NotExistPlayerNameException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    public GameResult findByPlayerName(String playerName) {
        return this.values.stream()
                .filter(gameResult -> gameResult.getPlayerName().equals(playerName))
                .findFirst()
                .orElseThrow(() -> new NotExistPlayerNameException("Player " + playerName + " is not exist"));
    }

    public List<GameResult> getValues() {
        return new ArrayList<>(values);
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
