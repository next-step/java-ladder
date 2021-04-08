package nextstep.ladder.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinesTest {

  @Test
  @DisplayName("포지션 입력 시, 라인 하나 이동 결과 포지션이 응답한다.")
  void result() {
    Line line = Line.generate(3, () -> true);
    assertAll(
        () -> assertEquals(line.move(1), 2),
        () -> assertEquals(line.move(2), 1),
        () -> assertEquals(line.move(3), 3)
    );
  }
}
