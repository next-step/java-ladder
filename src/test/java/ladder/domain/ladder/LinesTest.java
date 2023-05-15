package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinesTest {

  @Test
  void 사다리_시작위치에_따른_사다리_이동_결과_검증() {
    Line line1 = new Line(true, false);
    Line line2 = new Line(false, false);
    Line line3 = new Line(false, true);

    Lines lines = new Lines(line1, line2, line3);

    assertThat(lines.getLastIndex(0)).isEqualTo(2);
    assertThat(lines.getLastIndex(1)).isEqualTo(0);
    assertThat(lines.getLastIndex(2)).isEqualTo(1);
  }

}