package nextstep.ladder;

import nextstep.ladder.domain.entity.LadderHeight;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderHeightTest {

  @ParameterizedTest
  @ValueSource(ints = {1, 5, 10})
  @DisplayName("양수를 사다리의 높이로 주어 사다리 높이 class를 생성한다.")
  void create(int input) {
    LadderHeight ladderHeight = new LadderHeight(input);
    assertEquals(ladderHeight.howTall(), input);
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, -5, -10})
  @DisplayName("음수를 사다리의 높이로 주면 excetpion을 던진다.")
  void createNegativeInteger(int input) {
    assertThrows(IllegalArgumentException.class, () -> new LadderHeight(input));
  }


}
