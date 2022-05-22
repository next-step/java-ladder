package ladder.domain.core;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class LadderTest {

  @Test
  @DisplayName("사다리 높이를 잘 가져오는지 확인")
  void getLadderHeight() {
    Ladder ladder = Ladder.of(10, 10);

    assertThat(ladder.getLadderHeight()).isEqualTo(10);
  }

  @RepeatedTest(100)
  @DisplayName("사다리 타기 결과 인덱스가 중복되지 않는지 확인")
  void traverse() {
    int width = 10;
    Ladder ladder = Ladder.of(10, width);
    List<Integer> actual = new ArrayList<>();
    List<Integer> expect = new ArrayList<>();

    for (int startIdx = 0; startIdx < width; startIdx++) {
      actual.add(ladder.traverse(startIdx));
      expect.add(startIdx);
    }

    assertThat(actual).containsExactlyInAnyOrderElementsOf(expect);
  }
}
