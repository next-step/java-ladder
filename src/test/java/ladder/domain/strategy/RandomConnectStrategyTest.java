package ladder.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomConnectStrategyTest {

  @Test
  @DisplayName("한번 연결되었으면, 다음은 연결되지 않는것을 확인.")
  void connect() {
    RandomConnectStrategy randomConnectStrategy = new RandomConnectStrategy();
    boolean islastConnect = false;

    for (int i = 0; i < 100; i++) {
      boolean isCurrConnect = randomConnectStrategy.isConnect();
      if (islastConnect) {
        assertThat(isCurrConnect).isFalse();
      }
      islastConnect = isCurrConnect;
    }
  }
}