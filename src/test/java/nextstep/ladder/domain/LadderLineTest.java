package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LadderLineTest {

  @Test
  void init() {
    LadderLine ladderLine = LadderLine.init(10);
    assertThat(ladderLine.size()).isEqualTo(10);
  }

  @Test
  void move() {
    LadderLine ladderLine = new LadderLine(List.of(
        Point.first(true),
        Point.first(true).next(),
        Point.first(true).next().last()
    ));

    assertThat(ladderLine.move(0)).isEqualTo(1);
    assertThat(ladderLine.move(1)).isZero();
    assertThat(ladderLine.move(2)).isEqualTo(2);
  }
}
