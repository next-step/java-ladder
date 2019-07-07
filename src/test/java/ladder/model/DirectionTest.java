package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DirectionTest {

  @Test
  @DisplayName("Direction.of를 사용한 생성")
  void test_of() {
    assertThat(Direction.of(false, true)).isEqualTo(Direction.RIGHT);
    assertThat(Direction.of(true, false)).isEqualTo(Direction.LEFT);
    assertThat(Direction.of(false, false)).isEqualTo(Direction.PASS);
  }

  @Test
  @DisplayName("move")
  void test_move() {
    assertThat(Direction.RIGHT.move(new Position(0))).isEqualTo(new Position(1));
    assertThat(Direction.PASS.move(new Position(0))).isEqualTo(new Position(0));
    assertThat(Direction.LEFT.move(new Position(1))).isEqualTo(new Position(0));
  }
}
