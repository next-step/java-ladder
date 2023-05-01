package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class HeightTest {

  @ParameterizedTest(name = "사다리 높이 입력 시 입력한 높이 반환 테스트")
  @ValueSource(ints = {1, 5, 9, Integer.MAX_VALUE})
  public void create_사다리_높이(int input) {
    assertThat(new LadderHeight(input).height()).isEqualTo(input);
  }

  @Test
  @DisplayName("1 미만의 사다리 높이 입력시 IllegalArgumentException throw")
  public void create_1_미만_사다리_높이() {
    assertThatThrownBy(() -> new LadderHeight(0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("사다리의 높이는 1이상 이어야 합니다. 현재 사다리 입력 : " + 0);
  }
}
