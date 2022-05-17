package ladder.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLineConnectorTest {

  @Test
  @DisplayName("한번 연결되었으면, 다음은 연결되지 않는것을 확인.")
  void connect() {
    //given
    int height = 100;
    int width = 100;
    RandomLadderConnectStrategy randomConnectStrategy = new RandomLadderConnectStrategy(height,
        width);
    List<List<Boolean>> eachHeightConnects = new ArrayList<>();

    //when
    for (int heightIdx = 0; heightIdx < height; heightIdx++) {
      eachHeightConnects.add(randomConnectStrategy.create(heightIdx));
    }

    //then
    for (List<Boolean> connects : eachHeightConnects) {
      assertThat(containContinuousConnect(connects)).isFalse();
    }
  }

  private boolean containContinuousConnect(List<Boolean> connects) {
    for (int i = 0; i < connects.size() - 1; i++) {
      if (connects.get(i) && connects.get(i + 1)) {
        return true;
      }
    }
    return false;
  }
}