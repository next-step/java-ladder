package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

  @DisplayName("플레이어 수에 따른 bar 생성 테스트")
  @Test
  void create() {
    Line line = Line.of(Players.of("test1, test2, test3"));
    assertThat(line.size()).isEqualTo(2);
  }
}
