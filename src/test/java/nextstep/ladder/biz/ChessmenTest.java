package nextstep.ladder.biz;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ChessmenTest {

  @Test
  void create() {
    assertThat(Chessmen.location(0)).isEqualTo(Chessmen.location(0));
  }

  @Test
  void invalid() {
    assertThatThrownBy(() -> Chessmen.location(-1))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void moveRight() {
    Chessmen chessmen = Chessmen.location(0);
    chessmen.moveRight();

    assertThat(chessmen).isEqualTo(Chessmen.location(1));

  }

  @Test
  void moveLeft() {
    Chessmen chessmen = Chessmen.location(1);
    chessmen.moveLeft();

    assertThat(chessmen).isEqualTo(Chessmen.location(0));
  }

}
