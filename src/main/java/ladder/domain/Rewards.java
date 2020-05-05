package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rewards {
    private List<String> rewards;

    private Rewards(List<String> rewards) {
        this.rewards = new ArrayList<>(rewards);
    }

    public static Rewards getInstance(String[] results) {
        return new Rewards(Arrays.asList(results));
    }

    public static Rewards getInstance(List<String> rewards) {
        return new Rewards(rewards);
    }

    public List<String> getValues() {
        return new ArrayList<>(rewards);
    }

    public int getWidth() {
        return rewards.size();
    }

    public String getValue(int resultIndex) {
        return rewards.get(resultIndex);
    }
}
