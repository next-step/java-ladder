package nextstep.ladder.biz;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LineTest {

  public static final List<Point> POINTS_CASE1_1X2 = Arrays.asList(Point.of(true, 0), Point.of(false, 1));
  public static final List<Point> POINTS_CASE2_1X2 = Arrays.asList(Point.of(false, 0), Point.of(true, 1));

  public static final List<Point> POINTS_CASE1_POSITION0 = Arrays.asList(Point.of(true, 0));
  public static final List<Point> POINTS_CASE2_POSITION0 = Arrays.asList(Point.of(false, 0));

  public static final List<Point> POINTS_CASE1_POSITION1 = Arrays.asList(Point.of(true, 1));
  public static final List<Point> POINTS_CASE2_POSITION1 = Arrays.asList(Point.of(false, 1));

  @Test
  void createLine() {
    countOfPerson(new Line(2), 1);
    countOfPerson(new Line(3), 2);
    countOfPerson(new Line(4), 3);
  }

  void countOfPerson(Line line, int expectCountOfBridge) {
    assertThat(line.getPoints().size()).isEqualTo(expectCountOfBridge);
  }

  @Test
  void createLineByCountOfPerson() {
    Line points = new Line(3);

    assertThat(points.getPoints())
            .isIn(POINTS_CASE1_1X2, POINTS_CASE2_1X2);
  }

  @Test
  void selectableLine() {
    Line line = new Line(3);

    assertThat(line.selectableLine(Chessmen.location(0)).getPoints())
            .isIn(POINTS_CASE1_POSITION0, POINTS_CASE2_POSITION0);

    List<Point> points = line.selectableLine(Chessmen.location(1)).getPoints();
    assertThat(points)
            .isIn(POINTS_CASE1_1X2, POINTS_CASE2_1X2);

    assertThat(line.selectableLine(Chessmen.location(2)).getPoints())
            .isIn(POINTS_CASE1_POSITION1, POINTS_CASE2_POSITION1);
  }
}
