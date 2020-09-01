package nextstep.ladder.biz;

import nextstep.ladder.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

  @DisplayName("|        |")
  @Test
  void chopsticks2X1() {
    Ladder ladder = new Ladder(
            Arrays.asList(new Line(Arrays.asList(Point.of(false, 0))))
    );

    assertThat(ladder.play(Chessmen.of(new Player("name0", 0)))).isEqualTo(Chessmen.of(new Player("name0", 0)));
    assertThat(ladder.play(Chessmen.of(new Player("name1", 1)))).isEqualTo(Chessmen.of(new Player("name1", 1)));
  }

  @DisplayName("|--------|")
  @Test
  void bridge2X1() {
    Ladder ladder = new Ladder(
            Arrays.asList(new Line(Arrays.asList(Point.of(true, 0))))
    );

    assertThat(ladder.play(Chessmen.of(new Player("name0", 0)))).isEqualTo(Chessmen.of(new Player("name0", 0), 1));
    assertThat(ladder.play(Chessmen.of(new Player("name1", 1)))).isEqualTo(Chessmen.of(new Player("name1", 1), 0));
  }

  /**
   * |   |
   * |   |
   */
  @Test
  void chopsticks2X2() {
    Ladder ladder = new Ladder(
            Arrays.asList(
                    new Line(Arrays.asList(Point.of(false, 0))),
                    new Line(Arrays.asList(Point.of(false, 0)))
            )
    );

    assertThat(ladder.play(Chessmen.of(new Player("name0", 0)))).isEqualTo(Chessmen.of(new Player("name0", 0)));
    assertThat(ladder.play(Chessmen.of(new Player("name1", 1)))).isEqualTo(Chessmen.of(new Player("name1", 1)));
  }

  /**
   * |---|
   * |   |
   */
  @Test
  void bridgeIsOne2X2() {
    Ladder ladder = new Ladder(
            Arrays.asList(
                    new Line(Arrays.asList(Point.of(true, 0))),
                    new Line(Arrays.asList(Point.of(false, 0)))
            )
    );

    assertThat(ladder.play(Chessmen.of(new Player("name0", 0))))
            .isEqualTo(Chessmen.of(new Player("name0", 0), 1));
    assertThat(ladder.play(Chessmen.of(new Player("name1", 1))))
            .isEqualTo(Chessmen.of(new Player("name1", 1), 0));
  }

  /**
   * |---|
   * |---|
   */
  @Test
  void bridgeIsTwo2X2() {
    Ladder ladder = new Ladder(
            Arrays.asList(
                    new Line(Arrays.asList(Point.of(true, 0))),
                    new Line(Arrays.asList(Point.of(true, 0)))
            )
    );

    assertThat(ladder.play(Chessmen.of(new Player("name0", 0)))).isEqualTo(Chessmen.of(new Player("name0", 0)));
    assertThat(ladder.play(Chessmen.of(new Player("name1", 1)))).isEqualTo(Chessmen.of(new Player("name1", 1)));
  }

  /**
   * |---|   |
   * |   |---|
   */
  @Test
  void perBridgeIsOne3X2() {
    Ladder ladder = new Ladder(
            Arrays.asList(
                    new Line(Arrays.asList(Point.of(true, 0), Point.of(false, 1))),
                    new Line(Arrays.asList(Point.of(false, 0), Point.of(true, 1)))
            )
    );
    assertThat(ladder.play(Chessmen.of(new Player("name0", 0)))).isEqualTo(Chessmen.of(new Player("name0", 0), 2));
    assertThat(ladder.play(Chessmen.of(new Player("name1", 1)))).isEqualTo(Chessmen.of(new Player("name1", 1), 0));
    assertThat(ladder.play(Chessmen.of(new Player("name2", 2)))).isEqualTo(Chessmen.of(new Player("name2", 2), 1));
  }
}
