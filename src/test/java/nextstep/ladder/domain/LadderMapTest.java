package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import nextstep.ladder.domain.generator.BooleanGenerator;
import nextstep.ladder.domain.generator.RandomBooleanGenerator;
import nextstep.ladder.domain.dimension.LadderMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderMapTest {

  BooleanGenerator booleanGenerator;

  @BeforeEach
  void setUp() {
    booleanGenerator = new RandomBooleanGenerator();
  }

  @Test
  @DisplayName("사다리 너비가 1 미만일 경우 예외 발생")
  void validateWidth() {
    int width = 0;
    int height = 5;

     assertThatThrownBy(() -> new LadderMap(width, height, booleanGenerator))
         .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("사다리 높이가 1 미만일 경우 예외 발생")
  void validateHeight() {
    int width = 3;
    int height = 0;

    assertThatThrownBy(() -> new LadderMap(width, height, booleanGenerator))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("사다리 정상 생성")
  void createLadder() {
    int width = 6;
    int height = 5;

    assertThatNoException().isThrownBy(() -> new LadderMap(width, height, booleanGenerator));
  }

  @Test
  @DisplayName("사다리를 타고 움직일 때 정상적으로 이동하는지 확인")
  void getLine() {
    LadderMap ladderMap = new LadderMap(3, 5, () -> true);

    assertThat(ladderMap.move(0)).isEqualTo(1);
  }

}
