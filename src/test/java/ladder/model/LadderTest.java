package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

  @Test
  @DisplayName("생성 테스트")
  void createTest() {
    //given
    int height = 5;
    int width = 4;

    //when
    Ladder ladder = new Ladder(5, 4);

    //then
    List<Line> lines = ladder.lines();
    assertThat(lines.size()).isEqualTo(height);
    for (Line line : lines) {
      assertThat(line.size()).isEqualTo(width);
    }
  }

  @Test
  @DisplayName("잘못된 생성 테스트")
  void invalidCreateTest() {
    //then
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new Ladder(0, 4);
    });
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new Ladder(5, 0);
    });
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new Ladder(-1, 0);
    });
  }
}
