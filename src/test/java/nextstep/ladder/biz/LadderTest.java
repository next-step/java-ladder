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
    PointDirection first = PointDirection.first(false);
    Ladder ladder = new Ladder(
            Arrays.asList(new LadderLine(Arrays.asList(first, first.next(false))))
    );

    assertThat(ladder.play(Chessmen.of(new Player("name0", 0)))).isEqualTo(Chessmen.of(new Player("name0", 0)));
    assertThat(ladder.play(Chessmen.of(new Player("name1", 1)))).isEqualTo(Chessmen.of(new Player("name1", 1)));
  }

  @DisplayName("|--------|")
  @Test
  void bridge2X1() {
    PointDirection first = PointDirection.first(true);
    Ladder ladder = new Ladder(
            Arrays.asList(new LadderLine(Arrays.asList(first, first.next())))
    );

    assertThat(ladder.play(Chessmen.of(new Player("name0", 0)))).isEqualTo(Chessmen.of(new Player("name0", 0), 1));
    assertThat(ladder.play(Chessmen.of(new Player("name1", 1)))).isEqualTo(Chessmen.of(new Player("name1", 1), 0));
  }
}
