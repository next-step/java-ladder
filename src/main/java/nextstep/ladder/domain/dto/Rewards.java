package nextstep.ladder.domain.dto;

import java.util.List;

public class Rewards {
  private final List<String> rewards;

  public Rewards(List<String> rewards) {
    this.rewards = rewards;
  }

  public Rewards(String[] rewards) {
    this(List.of(rewards));
  }

  public String getRewards(int index) {
    return rewards.get(index);
  }

  public List<String> getRewards() {
    return this.rewards;
  }
}
