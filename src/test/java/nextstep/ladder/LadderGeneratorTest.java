package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LadderGeneratorTest {

  @Test
  void create() {
    assertThat(LadderGenerator.generate(4).size()).isEqualTo(5);
  }

  @Test
  void renderFor4Person() {
    List<Horizon> ladder = LadderGenerator.generate(4);

    for (Horizon horizon : ladder) {
      System.out.println(horizon.asString());
    }
  }

  @Test
  void renderFor10Person() {
    List<Horizon> ladder = LadderGenerator.generate(10);

    for (Horizon horizon : ladder) {
      System.out.println(horizon.asString());
    }
  }
}
