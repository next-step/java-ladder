package nextstep.ladder.biz;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import nextstep.ladder.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
  void selectableLine() {
    Line line = new Line(3);

    assertThat(line.selectableLine(Chessmen.location(0)).getPoints())
            .isIn(ONE_TURE_POINTS_OF_FIRST_LINE, ONE_FALSE_POINTS_OF_FIRST_LINE);

    List<Point> points = line.selectableLine(Chessmen.location(1)).getPoints();
    assertThat(points)
            .isIn(POINTS_CASE1_1X2, POINTS_CASE2_1X2);

    assertThat(line.selectableLine(Chessmen.location(2)).getPoints())
            .isIn(ONE_TURE_POINTS_OF_SECOND_LINE, ONE_FALSE_POINTS_OF_SECOND_LINE);
  }


  @Test
  void moveRightOnOneBridge() {
    Line line = new Line(ONE_TURE_POINTS_OF_FIRST_LINE);
    assertThat(line.cast(Chessmen.of(new Player("name", 0))))
            .isEqualTo(Chessmen.of(new Player("name", 1)));
  }

  @Test
  void moveLeftOnOneBridge() {
    Line line = new Line(ONE_TURE_POINTS_OF_FIRST_LINE);
    assertThat(line.cast(Chessmen.of(new Player("name", 1))))
            .isEqualTo(Chessmen.of(new Player("name", 0)));
  }

  @DisplayName("|----|    |")
  @Test
  void moveLeftOnTwoBridge() {
    Line line = new Line(POINTS_CASE1_1X2);
    assertThat(line.cast(Chessmen.of(new Player("name", 1))))
            .isEqualTo(Chessmen.of(new Player("name", 0)));
  }

  @DisplayName("|    |----|")
  @Test
  void moveRightOnTwoBridge() {
    Line line = new Line(POINTS_CASE2_1X2);
    assertThat(line.cast(Chessmen.of(new Player("name", 1))))
            .isEqualTo(Chessmen.of(new Player("name", 2)));
  }
}
