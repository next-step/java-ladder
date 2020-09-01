package nextstep.ladder.biz;

import nextstep.ladder.Player;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ChessmenTest {

  @Test
  void create() {
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

}
