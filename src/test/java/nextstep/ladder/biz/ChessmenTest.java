package nextstep.ladder.biz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ChessmenTest {

  @Test
  void create() {
    assertThat(Chessmen.location(0)).isEqualTo(Chessmen.location(0));
  }

  @Test
  void nextLocation() {
    Chessmen chessmen = Chessmen.location(0);
    chessmen.down(Point.of(true, 0));

    assertThat(chessmen).isEqualTo(Chessmen.location(1));
  }

  @Test
  void currentLocation() {
    Chessmen chessmen = Chessmen.location(0);
    chessmen.down(Point.of(false, 0));

    assertThat(chessmen).isEqualTo(Chessmen.location(0));
  }

}
