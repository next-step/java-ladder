package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinesTest {

  @Test
  void 사다리_0번출발_1번도착() {
    Line line = new Line(true, false);
    Lines lines = new Lines(line);

    assertThat(lines.getLastIndex(0)).isEqualTo(1);
  }

  @Test
  void 사다리_1번출발_0번도착() {
    Line line = new Line(true, false);
    Lines lines = new Lines(line);

    assertThat(lines.getLastIndex(1)).isEqualTo(0);
  }

  @Test
  void 사다리_2번출발_2번도착() {
    Line line = new Line(true, false);
    Lines lines = new Lines(line);

    assertThat(lines.getLastIndex(2)).isEqualTo(2);
  }

}