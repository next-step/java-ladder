package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

  @Test
  @DisplayName("사다리 가로 라인 생성")
  void create() {
    Line line = Line.from(List.of(true, false, true));
    assertThat(line).isEqualTo(Line.from(List.of(true, false, true)));
  }
}