package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CoordinatesTest {
  @ParameterizedTest
  @CsvSource(value = { "-1, 0", "0, -1", "-1, -1" })
  void 잘못된_좌표(Integer x, Integer y) {
    assertThatThrownBy(() -> Coordinates.of(x, y))
            .isInstanceOf(IllegalStateException.class)
            .hasMessage("음수 좌표를 가질 수 없습니다.");
  }

  @ParameterizedTest
  @CsvSource(value = { "1, 1", "11, 11" })
  void 캐싱() {
    assertThat(Coordinates.of(1, 1) == Coordinates.of(1, 1)).isTrue();
  }
  
  @Test
  void 우하단() {
    assertThat(Coordinates.of(1, 1).downRight()).isEqualTo(Coordinates.of(2, 2));
  }

  @Test
  void 좌하단() {
    assertThat(Coordinates.of(1, 1).downLeft()).isEqualTo(Coordinates.of(0, 2));
  }

  @Test
  void 직하단() {
    assertThat(Coordinates.of(1, 1).downStraight()).isEqualTo(Coordinates.of(1, 2));
  }
}
