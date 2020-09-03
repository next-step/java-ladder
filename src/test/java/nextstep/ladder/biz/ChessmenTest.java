package nextstep.ladder.biz;

import nextstep.ladder.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ChessmenTest {

  public static final List<Point> POINTS_CASE1_1X2 = Arrays.asList(Point.of(true, 0), Point.of(false, 1));
  public static final List<Point> POINTS_CASE2_1X2 = Arrays.asList(Point.of(false, 0), Point.of(true, 1));

  public static final List<Point> ONE_TURE_POINTS_OF_FIRST_LINE = Arrays.asList(Point.of(true, 0));
  public static final List<Point> ONE_FALSE_POINTS_OF_FIRST_LINE = Arrays.asList(Point.of(false, 0));

  @Test
  void isEqual() {
    assertThat(Chessmen.of(new Player("name0", 0))).isEqualTo(Chessmen.of(new Player("name0", 0)));
  }

  @Test
  void invalid() {
    assertThatThrownBy(() -> Chessmen.of(new Player("nobody", -1)))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void moveRight() {
    Chessmen chessmen = Chessmen.of(new Player("name0", 0));

    assertThat(chessmen.moveRight()).isEqualTo(Chessmen.of(new Player("name0", 0), 1));

  }

  @Test
  void moveLeft() {
    Chessmen chessmen = Chessmen.of(new Player("name1", 1));

    assertThat(chessmen.moveLeft()).isEqualTo(Chessmen.of(new Player("name1", 1), 0));
  }

  @DisplayName("||        |")
  @Test
  void stayOnPier() {
    Line line = new Line(ONE_FALSE_POINTS_OF_FIRST_LINE);

    assertThat(Chessmen.of(new Player("name", 0)).cast(line))
            .isEqualTo(Chessmen.of(new Player("name", 0)));
  }


  @DisplayName("||--------|")
  @Test
  void moveRightOnOneBridge() {
    Line line = new Line(ONE_TURE_POINTS_OF_FIRST_LINE);

    assertThat(Chessmen.of(new Player("name", 0)).cast(line))
            .isEqualTo(Chessmen.of(new Player("name", 0), 1));
  }

  @DisplayName("|--------||")
  @Test
  void moveLeftOnOneBridge() {
    Line line = new Line(ONE_TURE_POINTS_OF_FIRST_LINE);

    assertThat(Chessmen.of(new Player("name", 1)).cast(line))
            .isEqualTo(Chessmen.of(new Player("name", 1), 0));
  }

  @DisplayName("|----||    |")
  @Test
  void moveLeftOnTwoBridge() {
    Line line = new Line(POINTS_CASE1_1X2);

    assertThat(Chessmen.of(new Player("name", 1)).cast(line))
            .isEqualTo(Chessmen.of(new Player("name", 1), 0));
  }

  @DisplayName("|    ||----|")
  @Test
  void moveRightOnTwoBridge() {
    Line line = new Line(POINTS_CASE2_1X2);

    assertThat(Chessmen.of(new Player("name", 1)).cast(line))
            .isEqualTo(Chessmen.of(new Player("name", 1), 2));
  }

}
