package nextstep.ladder;

import nextstep.ladder.biz.Chessmen;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

  @Test
  void isEqual() {
    assertThat(new Player("name", 0)).isEqualTo(new Player("name", 0));
  }

  @Test
  void asChessmen() {
    assertThat(new Player("name", 0).asChessmen()).isEqualTo(Chessmen.location(0));
  }
}