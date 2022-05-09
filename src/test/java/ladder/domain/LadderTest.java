package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.strategy.ConnectStrategy;
import ladder.domain.strategy.FixedConnectStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

  @Test
  @DisplayName("사다리가 잘 생성되는지 확인")
  void of() {
    List<ConnectStrategy> connectStrategies = new ArrayList<>();
    connectStrategies.add(new FixedConnectStrategy(List.of(true, false, true)));
    connectStrategies.add(new FixedConnectStrategy(List.of(false, false, false)));
    connectStrategies.add(new FixedConnectStrategy(List.of(true, true, true)));
    Ladder ladder = Ladder.of(3, connectStrategies);

    assertThat(ladder.isConnect(0, 0)).isTrue();
    assertThat(ladder.isConnect(1, 1)).isFalse();
    assertThat(ladder.isConnect(2, 2)).isTrue();
  }
}
