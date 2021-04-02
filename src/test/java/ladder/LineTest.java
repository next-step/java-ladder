package ladder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ladder.domain.Line;
import ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

  @Test
  @DisplayName("Line 속 point 확인")
  public void makePoint() {
    List<Boolean> tmp = Arrays.asList(false,true,false,true);
    List<Point> points= new ArrayList<>();
    for (int i = 0; i< 4; i++) {
      points.add(new Point(tmp.get(i)));
    }

    Line line = new Line(() -> points);
    assertThat(line.getPoints()).isEqualTo(points);

  }
}
