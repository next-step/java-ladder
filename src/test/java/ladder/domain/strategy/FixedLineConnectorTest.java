package ladder.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FixedLineConnectorTest {

  @Test
  @DisplayName("고정된 사다리 연결 전략이 잘 생성되는지 확인")
  void equal() {
    List<List<Boolean>> fixedConnects = List.of(List.of(true, false, true, false),
        List.of(true, false, true, false), List.of(true, false, true, false));
    FixedLadderConnectStrategy fixedConnectStrategy = new FixedLadderConnectStrategy(fixedConnects);

    for (int height = 0; height < 3; height++) {
      assertThat(fixedConnectStrategy.create(height)).isEqualTo(fixedConnects.get(height));
    }

  }
}