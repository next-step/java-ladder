package ladder_v2.domain;

import java.util.ArrayList;
import java.util.List;

public class Rewards {

    private List<String> rewards = new ArrayList<>();

    public Rewards(List<String> rewards) {
        inputValidation(rewards);
        this.rewards = rewards;
    }

    private void inputValidation(List<String> rewards) {
        if(rewards.size() < 2){
            throw new IllegalArgumentException("Reward는 최소 2개 이상이어야 합니다.");
        }
    }

    public List<String> rewards(){
        return rewards;
    }
    public String get(int i) {
        return rewards.get(i);
    }
}
