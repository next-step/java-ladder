package ladder.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FixedConnectStrategyTest {

  @Test
  @DisplayName("고정된 사다리 연결 전략이 잘 생성되는지 확인")
  void equal() {
    List<Boolean> fixedConnects = List.of(true, false, true, false);
    FixedConnectStrategy fixedConnectStrategy = new FixedConnectStrategy(fixedConnects);

    for (int i = 0; i < fixedConnects.size(); i++) {
      assertThat(fixedConnectStrategy.isConnect(i)).isEqualTo(fixedConnects.get(i));
    }
  }
}