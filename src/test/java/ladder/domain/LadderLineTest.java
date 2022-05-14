package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.domain.strategy.ConnectStrategy;
import ladder.domain.strategy.FixedConnectStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderLineTest {

  @Test
  @DisplayName("연결 전략을 통해 LadderLine 이 잘 생성되는지 확인")
  void of() {
    ConnectStrategy connectStrategy = new FixedConnectStrategy(List.of(true, false, true));
    LadderLine ladderLine = LadderLine.of(connectStrategy);
    assertThat(ladderLine).usingRecursiveComparison().isEqualTo(LadderLine.of(connectStrategy));
  }

  @Test
  @DisplayName("해당 좌표 연결/비연결 여부 확인")
  void isConnect() {
    ConnectStrategy connectStrategy = new FixedConnectStrategy(List.of(true, false, true));
    LadderLine ladderLine = LadderLine.of(connectStrategy);
    assertThat(ladderLine.isConnect(0)).isTrue();
    assertThat(ladderLine.isConnect(1)).isFalse();
    assertThat(ladderLine.isConnect(2)).isTrue();
  }
}
