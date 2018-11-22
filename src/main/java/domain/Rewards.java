package domain;

import java.util.Arrays;
import java.util.List;

public class Rewards {

    private static final String SEPARATOR = ",";
    private static final String OUTPUT_FORMAT = "%6s";

    private final List<String> rewards;

    public Rewards(List<String> rewards) {
        this.rewards = rewards;
    }

    public static Rewards fromInput(String input) {
        return new Rewards(Arrays.asList(input.split(SEPARATOR)));
    }

    public int size() {
        return rewards.size();
    }

    public String get(int i) {
        return rewards.get(i);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        rewards.forEach(reward -> stringBuilder.append(String.format(OUTPUT_FORMAT, reward)));

        return stringBuilder.toString();
    }
}
