package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
  @Test
  @DisplayName("한 줄 이상 있으면 Ladder 생성에 성공한다.")
  void createLadder_success() {
    Ladder ladder = new Ladder(List.of(new Line(3), new Line(3)));
    assertThat(ladder.height()).isEqualTo(2);
  }

  @Test
  @DisplayName("줄이 비어 있으면 IllegalArgument 예외가 발생한다.")
  void createLadder_fail_emptyLines() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> new Ladder(Collections.emptyList()))
        .withMessageContaining("Ladder는 높이가 1 이상이어야 합니다.");
  }

  @Test
  @DisplayName("lines가 null인 경우 IllegalArgument 예외가 발생한다.")
  void createLadder_fail_nullLines() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> new Ladder(null))
        .withMessageContaining("Ladder는 높이가 1 이상이어야 합니다.");
  }

  @Test
  @DisplayName("사다리를 타고 최종 위치로 이동한다")
  void move() {
    // 3명 기준, index 0 ~ 2
    // Line1: 0 <-> 1
    // Line2: 1 <-> 2
    // Line3: 2 <-> 1

    Line line1 = new Line(List.of(true, false));  // 0→1
    Line line2 = new Line(List.of(false, true));  // 1→2
    Line line3 = new Line(List.of(true, false));  // 2→1

    Ladder ladder = new Ladder(List.of(line1, line2, line3));

    assertThat(ladder.move(0)).isEqualTo(2); // 0→1→2→2
    assertThat(ladder.move(1)).isEqualTo(1); // 1→1→2→1
    assertThat(ladder.move(2)).isEqualTo(0); // 2→2→1→0
  }
}
