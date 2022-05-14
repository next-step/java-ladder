package ladder.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomConnectStrategyTest {

  @Test
  @DisplayName("한번 연결되었으면, 다음은 연결되지 않는것을 확인.")
  void connect() {
    RandomConnectStrategy randomConnectStrategy = new RandomConnectStrategy(100);

    List<Boolean> connects = randomConnectStrategy.create();

    boolean islastConnect = false;
    for (Boolean connect : connects) {
      assertThat(islastConnect && connect).isFalse();
      islastConnect = connect;
    }
  }
}