package ladder.domain;

import ladder.exception.PositionOutOfRangeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Rewards {
    public static final int START_INCLUSIVE = 0;
    public static final String POSITION_OUT_OF_RANGE_MESSAGE = "포지션 범위를 벗어났습니다.";
    private final List<Reward> rewards;

    private Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public Rewards(String... rewardNames) {
        this(toRewards(rewardNames));
    }

    private static List<Reward> toRewards(String... names) {
        return IntStream.range(START_INCLUSIVE, names.length)
                .mapToObj(index -> new Reward(names[index], index))
                .collect(Collectors.toList());
    }

    public Result result(Player player) {
        return rewards.stream()
                .filter(reward -> reward.isEqualPosition(player))
                .findFirst()
                .map(reward -> new Result(player.name(), reward.name()))
                .orElseThrow(() -> new PositionOutOfRangeException(POSITION_OUT_OF_RANGE_MESSAGE));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rewards rewards1 = (Rewards) o;
        return Objects.equals(rewards, rewards1.rewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewards);
    }

    public Results results(Players players) {
        ArrayList<Result> results = new ArrayList<>();
        players.each(player -> results.add(result(player)));
        return new Results(results);
    }
}
