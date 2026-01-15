package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LineTest {

  @ParameterizedTest
  @ValueSource(ints = {2, 3, 5, 10, 20})
  void 라인생성(int countOfPerson) {
    Line line = new Line(countOfPerson);
    assertThat(line).isNotNull();
  }

  @Test
  void 연속된가로선이없어야함() {
    for (int trial = 0; trial < 100; trial++) {
      Line line = new Line(10);

      for (int i = 0; i < 8; i++) {
        boolean current = line.hasConnectionAt(i);
        boolean next = line.hasConnectionAt(i + 1);

        assertThat(current && next).isFalse();
      }
    }
  }

  @Test
  void toString_포맷확인() {
    Line line = new Line(3);
    String result = line.toString();
    assertThat(result).startsWith("     ");
    assertThat(result).endsWith("|");
  }

  @Test
  void move_오른쪽연결시오른쪽이동() {
    // |-----|     |
    // 0     1     2
    Line line = new Line(java.util.List.of(true, false));
    assertThat(line.move(0)).isEqualTo(1);
  }

  @Test
  void move_왼쪽연결시왼쪽이동() {
    // |-----|     |
    // 0     1     2
    Line line = new Line(java.util.List.of(true, false));
    assertThat(line.move(1)).isEqualTo(0);
  }

  @Test
  void move_연결없으면그대로() {
    // |-----|     |
    // 0     1     2
    Line line = new Line(java.util.List.of(true, false));
    assertThat(line.move(2)).isEqualTo(2);
  }

  @Test
  void 연속된가로선입력시예외() {
    assertThatThrownBy(() -> new Line(java.util.List.of(true, true, false)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("연속된 가로선은 허용되지 않습니다.");
  }
}