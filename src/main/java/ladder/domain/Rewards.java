package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private final List<Reward> values;

    public Rewards(List<Reward> values) {
        this.values = List.copyOf(values);
    }

    public static Rewards of(String input) {
        List<Reward> rewards = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Reward::new)
                .collect(Collectors.toList());
        return new Rewards(rewards);
    }

    public List<Integer> getResultLengths() {
        return values.stream()
                .map(Reward::getValue)
                .map(String::length)
                .collect(Collectors.toList());
    }

    public List<Reward> getValues() {
        return values;
    }

    public String getReward(int finalIndex) {
        return values.get(finalIndex).getValue();
    }
}
