package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RewardsTest {

  @Test
  void rewards_constructor() {

    List<String> values = Arrays.asList("3000", "4000", "5000");
    Rewards rewards = Rewards.of(values);

    assertThat(rewards.getSize()).isEqualTo(3);
  }
}
