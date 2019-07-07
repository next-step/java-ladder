package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PositionTest {

  @Test
  void test_equals() {
    Position position1 = new Position(0);
    Position position2 = new Position(0);

    assertThat(position1).isEqualTo(position2);
  }
}
