package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Rewards {
  private final List<String> rewards;

  public Rewards(List<String> rewards) {
    this.rewards = new ArrayList<>(rewards);
  }

  public int size() {
    return rewards.size();
  }

  public List<String> getRewards() {
    return new ArrayList<>(rewards);
  }

  public String getRewardAt(int index) {
    return rewards.get(index);
  }
}