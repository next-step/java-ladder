package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class DirectionTest {
  @Test
  public void STRAIGHT와LEFT는_라인이없고_RIGHT만_라인이있다() {
    assertThat(Direction.STRAIGHT.hasLine()).isEqualTo(false);
    assertThat(Direction.LEFT.hasLine()).isEqualTo(false);
    assertThat(Direction.RIGHT.hasLine()).isEqualTo(true);
  }

  @Test
  public void drawTest() {
    assertThat(Direction.STRAIGHT.draw()).isEqualTo("|     ");
    assertThat(Direction.LEFT.draw()).isEqualTo("|     ");
    assertThat(Direction.RIGHT.draw()).isEqualTo("|-----");
  }
}
