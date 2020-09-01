package nextstep.ladder;

import nextstep.ladder.biz.Chessmen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class PrizesTest {

  private Prizes prizes;

  @BeforeEach
  void setUp() {
    prizes = new Prizes(Arrays.asList(new Prize("1st", 0), new Prize("2nd", 1), new Prize("3rd", 2)));
  }

  @Test
  void isEqual() {
    assertThat(prizes)
            .isEqualTo(new Prizes(Arrays.asList(new Prize("1st", 0), new Prize("2nd", 1), new Prize("3rd", 2))));
  }

  @Test
  void nameToList() {
    assertThat(prizes.nameToList())
            .isEqualTo(Arrays.asList("1st", "2nd", "3rd"));
  }

  @Test
  void prizeOf() {
    assertThat(prizes.prizeOf(Chessmen.of(new Player("name0", 0)))).isEqualTo(new Prize("1st", 0));
  }
}