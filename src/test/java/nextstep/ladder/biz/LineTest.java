package nextstep.ladder.biz;

import nextstep.ladder.Player;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

  public static final List<Point> POINTS_CASE1_1X2 = Arrays.asList(Point.of(true, 0), Point.of(false, 1));
  public static final List<Point> POINTS_CASE2_1X2 = Arrays.asList(Point.of(false, 0), Point.of(true, 1));

  public static final List<Point> ONE_TURE_POINTS_OF_FIRST_LINE = Arrays.asList(Point.of(true, 0));
  public static final List<Point> ONE_FALSE_POINTS_OF_FIRST_LINE = Arrays.asList(Point.of(false, 0));

  public static final List<Point> ONE_TURE_POINTS_OF_SECOND_LINE = Arrays.asList(Point.of(true, 1));
  public static final List<Point> ONE_FALSE_POINTS_OF_SECOND_LINE = Arrays.asList(Point.of(false, 1));

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
  void castingLine() {
    Line line = new Line(3);

    assertThat(line.castingLine(Chessmen.of(new Player("name0", 0))).getPoints())
            .isIn(ONE_TURE_POINTS_OF_FIRST_LINE, ONE_FALSE_POINTS_OF_FIRST_LINE);

    List<Point> points = line.castingLine(Chessmen.of(new Player("name1", 1))).getPoints();
    assertThat(points)
            .isIn(POINTS_CASE1_1X2, POINTS_CASE2_1X2);

    assertThat(line.castingLine(Chessmen.of(new Player("name2", 2))).getPoints())
            .isIn(ONE_TURE_POINTS_OF_SECOND_LINE, ONE_FALSE_POINTS_OF_SECOND_LINE);
  }

}
