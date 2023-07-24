package nextstep.ladder.domain.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rewards {
  private final List<String> rewards;

  public Rewards(List<String> rewards) {
    this.rewards = rewards;
  }

  public Rewards(String[] rewards) {
    this(List.of(rewards));
  }

  public String getReward(int index) {
    return rewards.get(index);
  }

  public List<String> getRewards() {
    return this.rewards;
  }
  
  public Map<Integer, String> toMap() {
    Map<Integer, String> rewardMap = new HashMap<>();
    for (int i = 0; i < rewards.size(); i++) {
      rewardMap.put(i, rewards.get(i));
    }

    return rewardMap;
  }
}
