package ladder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ladder.domain.Line;
import ladder.domain.Point;
import ladder.domain.generator.Generator;
import ladder.domain.generator.PointsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

  @Test
  @DisplayName("Line 생성 후 point 사이즈 확인")
  public void create() {
    Line line = new Line(4);
    assertThat(line.size()).isEqualTo(4);
  }

  @Test
  @DisplayName("Line 속 point 확인")
  public void makePoint() {
    Line line = new Line(4);

    List<Boolean> tmp = Arrays.asList(false,true,false,true);
    List<Point> points= new ArrayList<>();
    for (int i = 0; i< 4; i++) {
      points.add(new Point(tmp.get(i)));
    }

    assertThat(line.makePoints(() -> points)).isEqualTo(points);

  }
}
