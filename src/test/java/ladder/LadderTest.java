package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LadderTest {

  Ladder ladder;

  @BeforeEach
  public void setup() {
    int lineHeight = 6;
    Players players = new Players("lee,chang,jun");
    ladder = new Ladder(6, players.count());
  }

  @Test
  public void 생성된_라인수_테스트() {
    assertThat(ladder.getHeight()).isEqualTo(6);
  }

  @Test
  public void moveTest() {
    Point straightPoint = new Point(Direction.STRAIGHT);
    Point rightPoint = new Point(Direction.RIGHT);
    Point leftPoint = new Point(Direction.LEFT);

    List<Point> pointsParam = Arrays.asList(straightPoint, rightPoint, leftPoint);
    Points points = new Points(pointsParam);

    //  |     |-----|
    //  |     |-----|
    Line line = new Line(points);
    Line line2 = new Line(points);
    List<Line> lines = Arrays.asList(line, line2);
    Ladder ladder = new Ladder(lines);

    assertThat(ladder.move(0)).isEqualTo(0);
    assertThat(ladder.move(1)).isEqualTo(1);
    assertThat(ladder.move(2)).isEqualTo(2);
  }

}