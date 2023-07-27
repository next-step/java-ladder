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

  public List<String> getRewards() {
    return this.rewards;
  }

  public String get(int index) {
    return this.rewards.get(index);
  }
}
