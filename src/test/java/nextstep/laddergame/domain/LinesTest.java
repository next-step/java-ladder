package nextstep.laddergame.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LinesTest {

  @Test
  @DisplayName("높이와 인원 수를 입력을 받아서 Lines를 생성할 수 있다")
  public void create() throws Exception {
    //given
    Lines lines = Lines.createLines(5, 4);

    //when
    //then
    assertNotNull(lines);
  }

  @Test
  @DisplayName("빈 리스트로 Line을 생성할 경우 익셉션이 발생한다")
  public void createException() throws IOException {
    //given
    List<Point> points = new ArrayList<>();

    //when
    IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
        () -> new Line(points));

    //then
    assertTrue(thrown.getMessage().contains("ERROR"));
  }
}