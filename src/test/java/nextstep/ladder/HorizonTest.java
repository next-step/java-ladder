package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class HorizonTest {

  @Test
  void createHorizon() {
    Horizon horizon = new Horizon(3);

    assertThat(horizon.asString())
        .isIn(Arrays.asList("|--------|        |", "|        |--------|"));
  }
}
