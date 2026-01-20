package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class LadderTest {

  @Test
  void 사다리생성_자동생성() {
    assertDoesNotThrow(() -> new Ladder(5, new Height(10)));
  }

  @Test
  void 사다리생성_직접주입() {
    List<Line> lines = new ArrayList<>();
    lines.add(new Line(5, new RandomLineConnectionStrategy()));
    lines.add(new Line(5, new RandomLineConnectionStrategy()));

    assertDoesNotThrow(() -> new Ladder(lines, new Height(10)));
  }

  @Test
  void 최대높이초과시예외() {
    List<Line> lines = new ArrayList<>();
    for (int i = 0; i < 11; i++) {
      lines.add(new Line(5, new RandomLineConnectionStrategy()));
    }

    assertThatThrownBy(() -> new Ladder(lines, new Height(10)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("최대 사다리 높이는 10입니다.");
  }

  @Test
  void 최대높이와정확히같은높이는허용() {
    List<Line> lines = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      lines.add(new Line(5, new RandomLineConnectionStrategy()));
    }

    assertDoesNotThrow(() -> new Ladder(lines, new Height(10)));
  }

  @Test
  void 사다리이동() {
    // |-----|     |     |
    // |     |-----|     |
    // 0     1     2     3
    List<Line> lines = List.of(
        new Line(List.of(true, false, false)),
        new Line(List.of(false, true, false))
    );
    Ladder ladder = new Ladder(lines, new Height(5));

    assertThat(ladder.findEnd(0)).isEqualTo(2);  // 0 → 1 → 2
    assertThat(ladder.findEnd(1)).isEqualTo(0);  // 1 → 0 → 0
    assertThat(ladder.findEnd(2)).isEqualTo(1);  // 2 → 2 → 1
    assertThat(ladder.findEnd(3)).isEqualTo(3);  // 3 → 3 → 3
  }
}