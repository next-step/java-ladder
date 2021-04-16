package nextstep.laddergame;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import nextstep.laddergame.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {
  @Test
  @DisplayName("크기를 입력받아서 Line을 생성한다")
  public void create() throws Exception {
    //given
    Line line = Line.createLine(3);

    //when
    //then
    assertNotNull(line);
  }
}