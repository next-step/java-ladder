package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Rewards {

  private final List<Reward> rewards;

  public Rewards(List<Reward> rewards) {
    this.rewards = Collections.unmodifiableList(rewards);
  }

  public static Rewards of(List<String> values) {
    int count = values.size();
    List<Reward> rewards = IntStream.range(0, count)
            .mapToObj(index -> new Reward(values.get(index), index))
            .collect(toList());
    return new Rewards(rewards);
  }

  public int getSize() {
    return this.rewards.size();
  }

  public List<Reward> getRewards() {
    return rewards;
  }

  public Reward getReward(int index) {
    return this.rewards.get(index);
  }
}
