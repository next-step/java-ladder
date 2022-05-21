package ladder.domain.core;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderPartLinesTest {

  @Test
  @DisplayName("사다리 높이, 너비에 따라 잘 생성되는지 확인")
  void of() {
    LadderPartLines lines = LadderPartLines.of(10, 10);

    assertThat(lines.height()).isEqualTo(10);
    assertThat(lines.getWidth()).isEqualTo(10);
  }

  @Test
  @DisplayName("사다리 타기 결과가 정확한지 확인")
  void traverse() {
    int width = 10;
    LadderPartLines ladderPartLines = LadderPartLines.of(10, width);
    List<Integer> actual = new ArrayList<>();
    List<Integer> expect = new ArrayList<>();

    for (int startIdx = 0; startIdx < width; startIdx++) {
      actual.add(ladderPartLines.traverse(startIdx));
      expect.add(startIdx);
    }

    assertThat(actual).containsExactlyInAnyOrderElementsOf(expect);
  }
}