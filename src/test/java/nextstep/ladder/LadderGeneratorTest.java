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
  void render() {
    List<Horizon> ladder = LadderGenerator.generate(4);

    for (Horizon horizon : ladder) {
      System.out.println(horizon.asString());
    }
  }
}
