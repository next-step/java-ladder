package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LadderGeneratorTest {

  @Test
  void create() {
    assertThat(LadderGenerator.generate(Players.valueOf(Arrays.asList("make", "some", "noise"), 4)).size()).
        isEqualTo(4);
  }

  @Test
  void renderFor3Person() {
    List<Horizon> ladder = LadderGenerator.generate(Players.valueOf(Arrays.asList("make", "some", "noise"), 4));

    for (Horizon horizon : ladder) {
      System.out.println(horizon.asString());
    }
  }

  @Test
  void renderFor5Person() {
    List<Horizon> ladder = LadderGenerator.generate(Players.valueOf(Arrays.asList("player1", "player2", "player3", "player4", "player5"), 4));

    for (Horizon horizon : ladder) {
      System.out.println(horizon.asString());
    }
  }
}
