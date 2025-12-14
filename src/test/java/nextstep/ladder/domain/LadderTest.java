package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class LadderTest {

  @Test
  void 사다리생성_자동생성() {
    assertDoesNotThrow(() -> new Ladder(5, 10));
  }

  @Test
  void 사다리생성_직접주입() {
    List<Line> lines = new ArrayList<>();
    lines.add(new Line(5));
    lines.add(new Line(5));

    assertDoesNotThrow(() -> new Ladder(lines, 10));
  }

  @Test
  void 최대높이초과시예외() {
    List<Line> lines = new ArrayList<>();
    for (int i = 0; i < 11; i++) {
      lines.add(new Line(5));
    }

    assertThatThrownBy(() -> new Ladder(lines, 10))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("최대 사다리 높이는 10입니다.");
  }

  @Test
  void 최대높이와정확히같은높이는허용() {
    List<Line> lines = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      lines.add(new Line(5));
    }

    assertDoesNotThrow(() -> new Ladder(lines, 10));
  }

}