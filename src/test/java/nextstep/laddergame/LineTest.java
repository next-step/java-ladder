package nextstep.laddergame;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class LineTest {
  @Test
  public void create() throws Exception {
    //given
    Line line = Line.createLine(3);

    //when
    //then
    assertNotNull(line);
  }
}