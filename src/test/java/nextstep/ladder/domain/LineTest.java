package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LineTest {

  @Test
  void create() {
    Line line = new Line(List.of(true, false, true));
    assertThat(line).isEqualTo(new Line(List.of(true, false, true)));
  }
}