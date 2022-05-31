package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LinesTest {

  @Test
  @DisplayName("")
  void move() {
    Lines lines = new Lines(
        List.of(
            new Line(List.of(
                Position.of(0, Point.of(false, true)),
                Position.of(1, Point.of(true, false)),
                Position.of(2, Point.of(false, false))
            )),
            new Line(List.of(
                Position.of(0, Point.of(false, false)),
                Position.of(1, Point.of(false, true)),
                Position.of(2, Point.of(true, false))
            )),
            new Line(List.of(
                Position.of(0, Point.of(false, false)),
                Position.of(1, Point.of(false, true)),
                Position.of(2, Point.of(true, false))
            ))
        )
    );
    assertThat(lines.move(0)).isEqualTo(1);
  }
}