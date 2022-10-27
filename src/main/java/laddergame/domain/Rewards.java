package laddergame.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {

    private final List<Reward> values;

    public Rewards(List<Reward> inputs) {
        this.values = inputs;
    }

    public Rewards(String[] inputs) {
        this(Arrays.stream(inputs)
                .map(Reward::new)
                .collect(Collectors.toList()));
    }

    public Reward getReward(int index) {
        return values.get(index);
    }

    public List<Reward> getRewards() {
        return Collections.unmodifiableList(values);
    }

    public int numberOfRewards(){
        return values.size();
    }
}
