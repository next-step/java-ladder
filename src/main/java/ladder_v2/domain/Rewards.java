package ladder_v2.domain;

import java.util.ArrayList;
import java.util.List;

public class Rewards {

    private List<String> rewards = new ArrayList<>();

    public Rewards(List<String> rewards) {
        this.rewards = rewards;
    }

    public List<String> rewards(){
        return rewards;
    }
    public String get(int i) {
        return rewards.get(i);
    }
}
