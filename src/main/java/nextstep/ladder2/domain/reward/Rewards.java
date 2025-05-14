package nextstep.ladder2.domain.reward;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {

    private List<Reward> rewards;

    public Rewards(String...names) {
        this(Arrays.stream(names)
                .map(Reward::new)
                .collect(Collectors.toList()));
    }

    public Rewards(Reward...rewards) {
        this(List.of(rewards));
    }

    public Rewards(List<Reward> rewards) {
        if (rewards == null || rewards.isEmpty()) {
            throw new IllegalArgumentException("보상 목록은 비어 있을 수 없습니다.");
        }
        
        this.rewards = rewards;
    }

    public List<Reward> values() {
        return List.copyOf(rewards);
    }
    
    public int count() {
        return rewards.size();
    }

    public Reward get(int i) {
        return rewards.get(i);
    }
}