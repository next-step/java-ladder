package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

  @DisplayName("Test for isAdjacent method")
  @Test
  public void testAdjocent() {
    Player aya = new Player("Aya", 0);
    Player billo = new Player("Billo", 1);
    Player clsan = new Player("Clsan", 2);

    assertThat(aya.isAdjacent(billo)).isTrue();
    assertThat(aya.isAdjacent(clsan)).isFalse();
    assertThat(billo.isAdjacent(aya)).isTrue();
    assertThat(billo.isAdjacent(clsan)).isTrue();
    assertThat(clsan.isAdjacent(aya)).isFalse();
    assertThat(clsan.isAdjacent(billo)).isTrue();
  }
}
