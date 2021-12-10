package step4.domain;

import java.util.ArrayList;
import java.util.List;

import static step4.utils.StringUtil.split;

public class Rewards {
    private final List<Reward> rewards = new ArrayList<>();

    private Rewards(String[] names) {
        for (String name : names) {
            rewards.add(Reward.of(name));
        }
    }

    public static Rewards of(String names) {
        return new Rewards(split(names));
    }

    public int size() {
        return rewards.size();
    }

    public List<Reward> rewards() {
        return rewards;
    }

    public String findBy(int index) {
        return rewards.get(index).name();
    }
}
