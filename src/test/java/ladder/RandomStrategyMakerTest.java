package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RandomStrategyMakerTest {

  @Test
  public void 연속으로_가로선을_만들지_않는다() {
    assertThat(RandomStrategyMaker.make(true)).isEqualTo(false);
  }
}
