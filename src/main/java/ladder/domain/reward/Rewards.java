package ladder.domain.reward;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class Rewards {
    private static final String DELIMITER = ",";
    private static final String NOT_MATCHES_COUNT_MESSAGE = "참여자수와 실행결과 입력 수는 일치해야합니다.";

    private final List<Reward> rewards;

    private Rewards(List<Reward> rewards, int playersCount) {
        validateMatchesCount(rewards, playersCount);
        this.rewards = rewards;
    }

    public static Rewards of(List<Reward> rewards, int playersCount) {
        return new Rewards(rewards, playersCount);
    }

    public static Rewards ofPrizes(String prizes, int playersCount) {
        return new Rewards(splitPrizes(prizes), playersCount);
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public String findPrize(int index) {
        return rewards.get(index).getPrize();
    }

    private static List<Reward> splitPrizes(String prizes) {
        return Arrays.stream(prizes.split(DELIMITER))
                .map(Reward::new)
                .collect(toList());
    }

    private void validateMatchesCount(List<Reward> rewards, int playersCount) {
        if (rewards.size() != playersCount) {
            throw new IllegalArgumentException(NOT_MATCHES_COUNT_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rewards that = (Rewards) o;
        return Objects.equals(rewards, that.rewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewards);
    }
}
