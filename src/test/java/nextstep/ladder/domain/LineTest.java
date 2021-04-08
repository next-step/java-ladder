package nextstep.ladder.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class LineTest {

  @Test
  void generateLine() {
    //given//when
    Line line = Line.generate(5, () -> true);
    //then
    List<Boolean> points = line.getPoints();
    System.out.println(points);
    assertAll(
        () -> assertFalse(points.get(0)),
        () -> assertTrue(points.get(1)),
        () -> assertFalse(points.get(2)),
        () -> assertTrue(points.get(3)),
        () -> assertFalse(points.get(4))
    );
  }

}