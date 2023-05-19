package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LadderTest {

  private Ladder ladder;

  @BeforeEach
  void setUp() {
    Point first = Point.of(0, false, true);
    Point second = Point.of(1, true, false);
    Point last = Point.of(2, false, false);

    this.ladder = new Ladder(new Line(first, second, last));
  }

  @Test
  void 사다리_0번출발_1번도착() {
    assertThat(ladder.getIndexOfResult(0)).isEqualTo(1);
  }

  @Test
  void 사다리_1번출발_0번도착() {
    assertThat(ladder.getIndexOfResult(1)).isEqualTo(0);
  }

  @Test
  void 사다리_2번출발_2번도착() {
    assertThat(ladder.getIndexOfResult(2)).isEqualTo(2);
  }

}