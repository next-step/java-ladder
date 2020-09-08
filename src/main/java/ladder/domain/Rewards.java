package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private static final String DELIMITER = ",";
    private final List<String> rewards;

    public Rewards(List<String> rewards) {
        this.rewards = rewards;
    }

    public static Rewards of(String input) {
        if (input == null || input.isEmpty()) {
            throw new NullPointerException("주어진 인풋이 없습니다.");
        }

        String[] values = input.split(DELIMITER);
        List<String> rewards = Arrays.stream(values)
                .collect(Collectors.toList());

        return new Rewards(rewards);
    }

    public String getRewardByPosition(int position) {
        return rewards.get(position);
    }

    @Override
    public String toString() {
        return rewards.stream()
                .map(reward -> String.format("%-7s", reward))
                .collect(Collectors.joining(""));
    }
}
