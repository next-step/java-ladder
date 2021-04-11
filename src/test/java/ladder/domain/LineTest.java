package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

  @Test
  @DisplayName("[Line] 한 라인에 사람 수만큼 좌표 생성 되었는지 테스트")
  void create_line() {
    Line line = Line.init(4, new RandomConnect());
    int size = line.points().size();
    assertThat(size).isEqualTo(4);
  }
}
