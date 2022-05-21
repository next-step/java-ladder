package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

  @Test
  @DisplayName("사다리 높이를 잘 가져오는지 확인")
  void getLadderHeight() {
    Ladder ladder = Ladder.of(10, 10);

    assertThat(ladder.getLadderHeight()).isEqualTo(10);
  }

  @Test
  @DisplayName("사다리 타기 결과가 정확한지 확인")
  void traverse() {
    int width = 10;
    Ladder ladder = Ladder.of(10, width);
    LadderPartLines lines = ladder.getLadderLines();
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
