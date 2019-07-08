package ladder.util;

import ladder.model.Rewards;

import java.util.Arrays;
import java.util.List;

public class MockRewardsGenerator {

  public static Rewards of(String... args) {
    List<String> rewards = Arrays.asList(args);
    return Rewards.of(rewards);
  }
}
