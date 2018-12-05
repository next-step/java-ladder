package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {

    private static final String SEPARATOR = ",";
    private static final String OUTPUT_FORMAT = "%6s";
    private final List<String> rewards;

    private Rewards(List<String> rewards) {
        this.rewards = rewards;
    }

    public static Rewards from(String input) {
        return new Rewards(Arrays.asList(input.split(SEPARATOR)));
    }

    int size() {
        return rewards.size();
    }

    String get(int i) {
        return rewards.get(i);
    }

    @Override
    public String toString() {
        return rewards.stream()
            .map(s -> String.format(OUTPUT_FORMAT, s))
            .collect(Collectors.joining());
    }
}
