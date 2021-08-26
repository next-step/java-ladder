package ladderGame.step4.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

  @DisplayName("사다리 생성 최소 입력값 검증.")
  @Test
  void invalidLadder() {
    int height = 0;
    int playerCount = 1;

    assertThatThrownBy(() -> Ladder.of(height, playerCount))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("사다리 객체 생성 테스트.")
  @Test
  void createLadder()
      throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

    List<Point> points = new ArrayList<>();
    points.add(new Point(0, Location.first(true)));

    List<Line> lines = new ArrayList<>();
    lines.add(new Line(points));

    Constructor<Ladder> constructor = Ladder.class.getDeclaredConstructor(List.class);
    constructor.setAccessible(true);

    Ladder ladder = constructor.newInstance(lines);
    Ladder ladder2 = constructor.newInstance(lines);
    assertThat(ladder).isEqualTo(ladder2);
  }
}