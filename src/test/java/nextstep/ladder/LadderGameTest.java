package nextstep.ladder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LadderGameTest {

  @Test
  void testCreatePlayer() {
    String playerName = "pobi";

    Player player = new Player(playerName);

    assertThat(player).isEqualTo(new Player(playerName));
  }

  @Test
  void testCreatePlayerWithLongerThan5LetterName() {
    String playerName = "pobi123";

    assertThatThrownBy(() -> new Player(playerName))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("이름은 5자 이하여야 합니다.");
  }

  @Test
  void testCreateLine() {
    Line line = new Line(3, () -> true);

    List<Point> points = line.getPoints();

    for (int i = 1; i < points.size(); i++) {
      assertFalse(points.get(i - 1).hasLine() && points.get(i).hasLine(), "연속된 true 발견됨");
    }
  }
}
