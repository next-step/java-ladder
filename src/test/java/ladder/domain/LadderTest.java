package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.security.InvalidParameterException;
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
    Ladder ladder = getTestLadder();
    Ladder ladder2 = getTestLadder();

    assertThat(ladder).usingRecursiveComparison().isEqualTo(ladder2);
  }

  @Test
  @DisplayName("사다리 높이가 제대로 생성되는지 확인")
  void getLadderHeight() {
    Ladder ladder = getTestLadder();

    assertThat(ladder.getLadderHeight()).isEqualTo(3);
  }

  @Test
  @DisplayName("사다리 너비가 잘 생성되는지 확인")
  void getLadderWidth() {
    Ladder ladder = getTestLadder();

    assertThat(ladder.getLadderWidth()).isEqualTo(3);
  }

  @Test
  @DisplayName("사다리 높이가 정상적이지 않을 경우 에러")
  void exception() {
    assertThatThrownBy(() -> {
      List<ConnectStrategy> connectStrategies = new ArrayList<>();
      Ladder ladder = Ladder.of(connectStrategies);
    }).isInstanceOf(InvalidParameterException.class);
  }

  Ladder getTestLadder() {
    List<ConnectStrategy> connectStrategies = new ArrayList<>();
    connectStrategies.add(new FixedConnectStrategy(List.of(true, false, true)));
    connectStrategies.add(new FixedConnectStrategy(List.of(false, false, false)));
    connectStrategies.add(new FixedConnectStrategy(List.of(true, true, true)));
    return Ladder.of(connectStrategies);
  }
}
