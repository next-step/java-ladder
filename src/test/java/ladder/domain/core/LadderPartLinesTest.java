package ladder.domain;

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
    assertThat(lines.getLines().get(0).getLine().size()).isEqualTo(10);
  }

  @Test
  @DisplayName("사다리 타기 결과가 정확한지 확인")
  void traverse() {
    int width = 10;
    LadderPartLines lines = LadderPartLines.of(10, width);
    List<Integer> expects = new ArrayList<>();
    List<Integer> actual = new ArrayList<>();

    for (int startIdx = 0; startIdx < width; startIdx++) {
      int expect = startIdx;
      for (LadderPartLine line : lines.getLines()) {
        expect = line.move(expect);
      }
      expects.add(expect);
      actual.add(lines.traverse(startIdx));
    }

    assertThat(actual).isEqualTo(expects);
  }
}